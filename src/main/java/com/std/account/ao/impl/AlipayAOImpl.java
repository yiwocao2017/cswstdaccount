/**
 * @Title AlipayAOImpl.java 
 * @Package com.std.account.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2017年1月11日 下午8:56:56 
 * @version V1.0   
 */
package com.std.account.ao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.internal.util.WebUtils;
import com.std.account.ao.IAlipayAO;
import com.std.account.bo.IAccountBO;
import com.std.account.bo.ICompanyChannelBO;
import com.std.account.bo.IExchangeCurrencyBO;
import com.std.account.bo.IJourBO;
import com.std.account.common.DateUtil;
import com.std.account.common.JsonUtil;
import com.std.account.common.PropertiesUtil;
import com.std.account.core.StringValidater;
import com.std.account.domain.Account;
import com.std.account.domain.CallbackResult;
import com.std.account.domain.CompanyChannel;
import com.std.account.domain.Jour;
import com.std.account.dto.res.XN002510Res;
import com.std.account.enums.EBizType;
import com.std.account.enums.EBoolean;
import com.std.account.enums.EChannelType;
import com.std.account.enums.ECurrency;
import com.std.account.enums.EJourStatus;
import com.std.account.exception.BizException;
import com.std.account.http.PostSimulater;
import com.std.account.util.AmountUtil;
import com.std.account.util.CalculationUtil;
import com.std.account.util.alipay.AlipayConfig;
import com.std.account.util.alipay.AlipayCore;

/** 
 * @author: haiqingzheng 
 * @since: 2017年1月11日 下午8:56:56 
 * @history:
 */
@Service
public class AlipayAOImpl implements IAlipayAO {
    static Logger logger = Logger.getLogger(AlipayAOImpl.class);

    public static final String CHARSET = "utf-8";

    @Autowired
    IJourBO jourBO;

    @Autowired
    ICompanyChannelBO companyChannelBO;

    @Autowired
    IAccountBO accountBO;

    @Autowired
    IExchangeCurrencyBO exchangeCurrencyBO;

    /** 
     * @see com.std.account.ao.IAlipayAO#getPrepayIdApp(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String)
     */
    // 配置说明
    // channel_company —— 卖家支付宝用户号
    // private_key1 —— APP_PRIVATE_KEY，开发者应用私钥，由开发者自己生成
    // private_key2 —— ALIPAY_PUBLIC_KEY，支付宝公钥，由支付宝生成
    // private_key3 —— APP_ID，APPID即创建应用后生成
    @Override
    public Object getSignedOrder(String fromUserId, String toUserId,
            String bizType, String fromBizNote, String toBizNote,
            Long transAmount, String payGroup, String backUrl) {
        if (transAmount.longValue() == 0l) {
            throw new BizException("xn000000", "发生金额为零，不能使用支付宝支付");
        }
        // 获取来去方账户信息
        Account fromAccount = accountBO.getAccountByUser(fromUserId,
            ECurrency.CNY.getCode());
        String toAcccoutCurrency = null;
        Long toTransAmount = transAmount;
        // 如果是正汇系统的O2O消费买单，付款至分润账户
        if ("CD-CZH000001".equals(fromAccount.getSystemCode())
                && EBizType.ZH_O2O.getCode().equals(bizType)) {
            toAcccoutCurrency = ECurrency.ZH_FRB.getCode();
            toTransAmount = AmountUtil.mul(transAmount, exchangeCurrencyBO
                .getExchangeRate(ECurrency.CNY.getCode(),
                    ECurrency.ZH_FRB.getCode()));
        } else { // 其他系统，付款至现金账户
            toAcccoutCurrency = ECurrency.CNY.getCode();
        }
        Account toAccount = accountBO.getAccountByUser(toUserId,
            toAcccoutCurrency);
        String systemCode = fromAccount.getSystemCode();
        String companyCode = fromAccount.getSystemCode();

        // 落地付款方和收款方流水信息
        String jourCode = jourBO.addToChangeJour(systemCode,
            fromAccount.getAccountNumber(), EChannelType.Alipay.getCode(),
            bizType, fromBizNote, transAmount, payGroup);
        jourBO.addToChangeJour(systemCode, toAccount.getAccountNumber(),
            EChannelType.Alipay.getCode(), bizType, toBizNote, toTransAmount,
            payGroup);

        // 获取支付宝支付配置参数
        CompanyChannel companyChannel = companyChannelBO.getCompanyChannel(
            companyCode, systemCode, EChannelType.Alipay.getCode());

        // 生成业务参数(bizContent)json字符串
        String bizContentJson = getBizContentJson(fromBizNote, jourCode,
            transAmount, backUrl);

        // 1、按照key=value&key=value方式拼接的未签名原始字符串
        Map<String, String> unsignedParamMap = getUnsignedParamMap(
            companyChannel.getPrivateKey3(), bizContentJson);
        // 注意注意：获取所有请求参数，不包括字节类型参数，如文件、字节流，剔除sign字段，剔除值为空的参数，
        // 并按照第一个字符的键值ASCII码递增排序（字母升序排序），如果遇到相同字符则按照第二个字符的键值ASCII码递增排序，以此类推。
        String unsignedContent = AlipayCore.createLinkString(unsignedParamMap);
        logger.info("*****未签名原始字符串：*****\n" + unsignedContent);

        // 2、对原始字符串进行签名
        String sign = getSign(unsignedContent, companyChannel.getPrivateKey1());
        logger.info("*****签名成功：*****\n" + sign);

        // 3、对请求字符串的所有一级value（biz_content作为一个value）进行encode
        String encodedParams = getEncodedparam(unsignedParamMap);
        encodedParams = encodedParams + "&sign=" + WebUtils.encode(sign);
        logger.info("*****签名并Encode后的请求字符串*****\n" + encodedParams);

        XN002510Res res = new XN002510Res();
        res.setJourCode(jourCode);
        res.setSignOrder(encodedParams);
        return res;
    }

    private String getEncodedparam(Map<String, String> unsignedParamMap) {
        Map<String, String> encodedParamMap = new HashMap<String, String>();
        Set<String> keys = unsignedParamMap.keySet();
        for (String key : keys) {
            encodedParamMap
                .put(key, WebUtils.encode(unsignedParamMap.get(key)));
        }
        return AlipayCore.createLinkString(encodedParamMap);
    }

    private String getSign(String content, String privateKey) {
        String sign = null;
        try {
            sign = AlipaySignature.rsaSign(content, privateKey,
                AlipayConfig.input_charset, AlipayConfig.sign_type);
            if (sign == null) {
                throw new BizException("xn000000", "原始字符串签名失败");
            }
            return sign;
        } catch (AlipayApiException e) {
            throw new BizException("xn000000", "原始字符串签名出错");
        }

    }

    private Map<String, String> getUnsignedParamMap(String appId,
            String bizContentJson) {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("app_id", appId);
        paramMap.put("method", "alipay.trade.app.pay");
        paramMap.put("format", "JSON");
        paramMap.put("charset", CHARSET);
        paramMap.put("sign_type", "RSA2");
        paramMap.put("timestamp",
            DateUtil.dateToStr(new Date(), DateUtil.DATA_TIME_PATTERN_1));
        paramMap.put("version", "1.0");
        paramMap.put("notify_url", PropertiesUtil.Config.ALIPAY_APP_BACKURL);
        paramMap.put("biz_content", bizContentJson);
        return paramMap;
    }

    private String getBizContentJson(String fromBizNote, String jourCode,
            Long transAmount, String backUrl) {
        Map<String, String> bizParams = new HashMap<String, String>();
        bizParams.put("subject", fromBizNote); // 商品的标题 例如：大乐透
        bizParams.put("out_trade_no", jourCode); // 商户网站唯一订单号
        bizParams.put("total_amount", String.valueOf(transAmount / 1000.00)); // 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
        bizParams.put("product_code", "QUICK_MSECURITY_PAY"); // 销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
        bizParams.put("passback_params", backUrl);
        return JsonUtil.Object2Json(bizParams);
    }

    /**
     * @see com.std.account.ao.IAlipayAO#doCallbackAPP(java.lang.String)
     */
    @Override
    public CallbackResult doCallbackAPP(String result) {
        String systemCode = "CD-CZH000001";
        String companyCode = "CD-CZH000001";
        // 目前只有正汇钱包使用支付宝，暂时写死 todo：如何判断公司编号和系统编号???
        CompanyChannel companyChannel = companyChannelBO.getCompanyChannel(
            companyCode, systemCode, EChannelType.Alipay.getCode());
        try {
            // 参数进行url_decode
            // String params = URLDecoder.decode(result, CHARSET);
            // 将异步通知中收到的待验证所有参数都存放到map中
            Map<String, String> paramsMap = split(result);
            // 过滤+排序
            Map<String, String> filterMap = AlipayCore.paraFilter(paramsMap);
            String content = AlipayCore.createLinkString(filterMap);
            // 拿到签名
            String sign = paramsMap.get("sign");
            filterMap.put("sign", sign);
            // 调用SDK验证签名
            boolean signVerified = AlipaySignature.rsa256CheckContent(content,
                sign, companyChannel.getPrivateKey2(), CHARSET);
            logger.info("验签结果：" + signVerified);
            boolean isSuccess = false;
            if (signVerified) {
                // TODO 验签成功后
                // 按照支付结果异步通知中的描述，对支付结果中的业务内容进行1\2\3\4二次校验，校验成功后在response中返回success，校验失败返回failure
                String outTradeNo = paramsMap.get("out_trade_no");
                String totalAmount = paramsMap.get("total_amount");
                String sellerId = paramsMap.get("seller_id");
                String appId = paramsMap.get("app_id");
                String alipayOrderNo = paramsMap.get("trade_no");
                String bizBackUrl = paramsMap.get("passback_params");
                Jour fromJour = jourBO.getJour(outTradeNo, systemCode);
                Jour toJour = jourBO.getRelativeJour(fromJour.getCode(),
                    fromJour.getPayGroup());
                if (!EJourStatus.todoCallBack.getCode().equals(
                    fromJour.getStatus())) {
                    throw new BizException("xn000000", "流水不处于待回调状态，重复回调");
                }

                // 数据正确性校验
                if (fromJour.getTransAmount().equals(
                    StringValidater.toLong(CalculationUtil.mult(totalAmount)))
                        && sellerId.equals(companyChannel.getChannelCompany())
                        && appId.equals(companyChannel.getPrivateKey3())) {
                    isSuccess = true;
                    jourBO.callBackFromChangeJour(fromJour, "ALIPAY",
                        "支付宝APP支付后台自动回调", alipayOrderNo);
                    jourBO.callBackChangeJour(toJour, EBoolean.YES.getCode(),
                        "ALIPAY", "支付宝APP支付后台自动回调", alipayOrderNo);
                    // 收款方账户加钱
                    accountBO.transAmountNotJour(systemCode,
                        toJour.getAccountNumber(), toJour.getTransAmount(),
                        toJour.getCode());
                } else {
                    // 支付失败
                    jourBO.callBackChangeJour(fromJour, EBoolean.NO.getCode(),
                        "ALIPAY", "支付宝APP支付后台自动回调", alipayOrderNo);
                    jourBO.callBackChangeJour(toJour, EBoolean.NO.getCode(),
                        "ALIPAY", "支付宝APP支付后台自动回调", alipayOrderNo);
                    if (!EJourStatus.todoCallBack.getCode().equals(
                        fromJour.getStatus())) {
                        throw new BizException("xn000000", "流水不处于待回调状态，重复回调");
                    }
                }

                return new CallbackResult(isSuccess, fromJour.getBizType(),
                    fromJour.getCode(), fromJour.getPayGroup(),
                    fromJour.getTransAmount(), systemCode, companyCode,
                    bizBackUrl);
            } else {
                throw new BizException("xn000000", "验签失败，默认为非法回调");
            }

        } catch (AlipayApiException e) {
            throw new BizException("xn000000", "支付结果通知验签异常");
        }

    }

    /**
     * @param urlparam 带分隔的url参数
     * @return
     */
    private Map<String, String> split(String urlparam) {
        Map<String, String> map = new HashMap<String, String>();
        String[] param = urlparam.split("&");
        for (String keyvalue : param) {
            String[] pair = keyvalue.split("=");
            if (pair.length == 2) {
                map.put(pair[0], WebUtils.decode(pair[1]));
            }
        }
        return map;
    }

    @Override
    public void doBizCallback(CallbackResult callbackResult) {
        try {
            Properties formProperties = new Properties();
            formProperties.put("isSuccess", callbackResult.isSuccess());
            formProperties.put("systemCode", callbackResult.getSystemCode());
            formProperties.put("companyCode", callbackResult.getCompanyCode());
            formProperties.put("payGroup", callbackResult.getPayGroup());
            formProperties.put("payCode", callbackResult.getJourCode());
            formProperties.put("bizType", callbackResult.getBizType());
            formProperties.put("transAmount", callbackResult.getTransAmount());
            PostSimulater.requestPostForm(callbackResult.getUrl(),
                formProperties);
        } catch (Exception e) {
            throw new BizException("xn000000", "回调业务biz异常");
        }
    }
}
