/**
 * @Title WeChatAOImpl.java 
 * @Package com.std.account.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月23日 上午11:21:03 
 * @version V1.0   
 */
package com.std.account.ao.impl;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.account.ao.IWeChatAO;
import com.std.account.bo.IAccountBO;
import com.std.account.bo.ICompanyChannelBO;
import com.std.account.bo.IExchangeCurrencyBO;
import com.std.account.bo.IJourBO;
import com.std.account.bo.IUserBO;
import com.std.account.bo.IWechatBO;
import com.std.account.common.JsonUtil;
import com.std.account.common.PropertiesUtil;
import com.std.account.common.SysConstant;
import com.std.account.domain.Account;
import com.std.account.domain.CallbackResult;
import com.std.account.domain.CompanyChannel;
import com.std.account.domain.Jour;
import com.std.account.dto.res.XN002500Res;
import com.std.account.dto.res.XN002501Res;
import com.std.account.enums.EBizType;
import com.std.account.enums.EBoolean;
import com.std.account.enums.EChannelType;
import com.std.account.enums.ECurrency;
import com.std.account.enums.EJourStatus;
import com.std.account.enums.ESystemCode;
import com.std.account.exception.BizException;
import com.std.account.http.PostSimulater;
import com.std.account.util.AmountUtil;
import com.std.account.util.HttpsUtil;
import com.std.account.util.wechat.TokenResponse;
import com.std.account.util.wechat.WXOrderQuery;
import com.std.account.util.wechat.XMLUtil;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月23日 上午11:21:03 
 * @history:
 */
@Service
public class WeChatAOImpl implements IWeChatAO {

    @Autowired
    IWechatBO wechatBO;

    @Autowired
    IJourBO jourBO;

    @Autowired
    ICompanyChannelBO companyChannelBO;

    @Autowired
    IAccountBO accountBO;

    @Autowired
    IUserBO userBO;

    @Autowired
    IExchangeCurrencyBO exchangeCurrencyBO;

    @Override
    public XN002500Res getPrepayIdApp(String fromUserId, String toUserId,
            String bizType, String fromBizNote, String toBizNote,
            Long transAmount, String payGroup, String backUrl) {
        if (transAmount.longValue() == 0l) {
            throw new BizException("xn000000", "发生金额为零，不能使用微信支付");
        }
        Account fromAccount = accountBO.getAccountByUser(fromUserId,
            ECurrency.CNY.getCode());
        String systemCode = fromAccount.getSystemCode();
        // 如果是正汇系统的O2O消费买单，付款至分润账户
        String toAcccoutCurrency = ECurrency.CNY.getCode();
        Long toTransAmount = transAmount;
        if (ESystemCode.ZHPAY.getCode().equals(systemCode)
                && EBizType.ZH_O2O.getCode().equals(bizType)) {
            toAcccoutCurrency = ECurrency.ZH_FRB.getCode();
            toTransAmount = AmountUtil.mul(transAmount, exchangeCurrencyBO
                .getExchangeRate(ECurrency.CNY.getCode(),
                    ECurrency.ZH_FRB.getCode()));
        }
        Account toAccount = accountBO.getAccountByUser(toUserId,
            toAcccoutCurrency);
        // Account toAccount = accountBO.getAccountByUser(toUserId,
        // ECurrency.CNY.getCode());

        // 落地付款方流水信息
        String jourCode = jourBO.addToChangeJour(systemCode,
            fromAccount.getAccountNumber(), EChannelType.WeChat_APP.getCode(),
            bizType, fromBizNote, transAmount, payGroup);
        // 落地收款方流水信息
        jourBO.addToChangeJour(systemCode, toAccount.getAccountNumber(),
            EChannelType.WeChat_APP.getCode(), bizType, toBizNote,
            toTransAmount, payGroup);
        // 获取微信支付配置信息
        CompanyChannel companyChannel = companyChannelBO.getCompanyChannel(
            systemCode, systemCode, EChannelType.WeChat_APP.getCode());
        // 获取微信公众号支付prepayid
        String prepayId = wechatBO.getPrepayIdApp(companyChannel, fromBizNote,
            jourCode, transAmount, SysConstant.IP, backUrl);
        // 返回微信APP支付所需信息
        return wechatBO.getPayInfoApp(companyChannel, jourCode, prepayId);
    }

    @Override
    @Transactional
    public XN002501Res getPrepayIdH5(String fromUserId, String fromOpenId,
            String toUserId, String bizType, String fromBizNote,
            String toBizNote, Long transAmount, String payGroup,
            String bizBackUrl) {
        if (transAmount.longValue() == 0l) {
            throw new BizException("xn000000", "发生金额为零，不能使用微信支付");
        }
        if (StringUtils.isBlank(fromOpenId)) {
            throw new BizException("xn0000", "请先微信登录再支付");
        }
        Account fromAccount = accountBO.getAccountByUser(fromUserId,
            ECurrency.CNY.getCode());
        Account toAccount = accountBO.getAccountByUser(toUserId,
            ECurrency.CNY.getCode());
        String systemCode = fromAccount.getSystemCode();
        // 落地付款方流水信息
        String jourCode = jourBO.addToChangeJour(systemCode,
            fromAccount.getAccountNumber(), EChannelType.WeChat_H5.getCode(),
            bizType, fromBizNote, transAmount, payGroup);
        // 落地收款方流水信息
        jourBO.addToChangeJour(systemCode, toAccount.getAccountNumber(),
            EChannelType.WeChat_H5.getCode(), bizType, toBizNote, transAmount,
            payGroup);
        // 获取微信公众号支付prepayid
        CompanyChannel companyChannel = companyChannelBO.getCompanyChannel(
            systemCode, systemCode, EChannelType.WeChat_H5.getCode());
        String prepayId = wechatBO.getPrepayIdH5(companyChannel, fromOpenId,
            fromBizNote, jourCode, transAmount, SysConstant.IP,
            PropertiesUtil.Config.WECHAT_H5_BACKURL, bizBackUrl);
        // 返回微信公众号支付所需信息
        return wechatBO.getPayInfoH5(companyChannel, jourCode, prepayId);
    }

    @Override
    @Transactional
    public String getPrepayIdNative(String fromUserId, String toUserId,
            String bizType, String fromBizNote, String toBizNote,
            Long transAmount, String payGroup, String backUrl) {
        if (transAmount.longValue() == 0l) {
            throw new BizException("xn000000", "发生金额为零，不能使用微信支付");
        }
        Account fromAccount = accountBO.getAccountByUser(fromUserId,
            ECurrency.CNY.getCode());
        Account toAccount = accountBO.getAccountByUser(toUserId,
            ECurrency.CNY.getCode());
        String systemCode = fromAccount.getSystemCode();
        // 落地付款方流水信息
        String jourCode = jourBO.addToChangeJour(systemCode,
            fromAccount.getAccountNumber(),
            EChannelType.WeChat_NATIVE.getCode(), bizType, fromBizNote,
            transAmount, payGroup);
        // 落地收款方流水信息
        jourBO.addToChangeJour(systemCode, toAccount.getAccountNumber(),
            EChannelType.WeChat_NATIVE.getCode(), bizType, toBizNote,
            transAmount, payGroup);
        // 获取微信扫码支付codeURL
        CompanyChannel companyChannel = companyChannelBO.getCompanyChannel(
            systemCode, systemCode, EChannelType.WeChat_NATIVE.getCode());
        String codeUrl = wechatBO.getPrepayIdNative(companyChannel,
            fromBizNote, jourCode, transAmount, SysConstant.IP, backUrl);
        // 返回微信APP支付所需信息
        return codeUrl;
    }

    @Override
    public CallbackResult doCallbackAPP(String result) {
        String systemCode = null;
        String companyCode = null;
        String backUrl = null;
        String wechatOrderNo = null;
        Jour fromJour = null;
        Jour toJour = null;
        Map<String, String> map = null;
        try {
            map = XMLUtil.doXMLParse(result);
            String attach = map.get("attach");
            String[] codes = attach.split("\\|\\|");
            systemCode = codes[0];
            companyCode = codes[1];
            backUrl = codes[2];
            wechatOrderNo = map.get("transaction_id");
            fromJour = jourBO.getJour(map.get("out_trade_no"), systemCode);
            toJour = jourBO.getRelativeJour(fromJour.getCode(),
                fromJour.getPayGroup());
        } catch (JDOMException | IOException e) {
            throw new BizException("xn000000", "回调结果XML解析失败");
        }
        // 判断是否已回调
        if (!EJourStatus.todoCallBack.getCode().equals(fromJour.getStatus())) {
            throw new BizException("xn000000", "已回调成功");
        }
        // 此处调用订单查询接口验证是否交易成功
        boolean isSucc = reqOrderquery(map, EChannelType.WeChat_APP.getCode());
        // 支付成功，商户处理后同步返回给微信参数
        if (!isSucc) {
            // 支付失败
            System.out.println("支付失败");
            jourBO.callBackChangeJour(fromJour, EBoolean.NO.getCode(),
                "WeChat_APP", "微信APP支付后台自动回调", wechatOrderNo);
            jourBO.callBackChangeJour(toJour, EBoolean.NO.getCode(),
                "WeChat_APP", "微信APP支付后台自动回调", wechatOrderNo);
        } else {
            System.out.println("===============付款成功==============");
            // ------------------------------
            // 处理业务开始
            // ------------------------------
            jourBO.callBackFromChangeJour(fromJour, "WeChat_APP",
                "微信APP支付后台自动回调", wechatOrderNo);
            jourBO.callBackChangeJour(toJour, EBoolean.YES.getCode(),
                "WeChat_APP", "微信APP支付后台自动回调", wechatOrderNo);
            // 收款方账户加钱
            accountBO.transAmountNotJour(systemCode, toJour.getAccountNumber(),
                toJour.getTransAmount(), toJour.getCode());
            // ------------------------------
            // 处理业务完毕
            // ------------------------------
        }
        return new CallbackResult(isSucc, fromJour.getBizType(),
            fromJour.getCode(), fromJour.getPayGroup(),
            fromJour.getTransAmount(), systemCode, companyCode, backUrl);
    }

    @Override
    public CallbackResult doCallbackH5(String result) {
        String systemCode = null;
        String companyCode = null;
        String backUrl = null;
        String wechatOrderNo = null;
        Jour fromJour = null;
        Jour toJour = null;
        Map<String, String> map = null;
        try {
            map = XMLUtil.doXMLParse(result);
            String attach = map.get("attach");
            String[] codes = attach.split("\\|\\|");
            systemCode = codes[0];
            companyCode = codes[1];
            backUrl = codes[2];
            wechatOrderNo = map.get("transaction_id");
            fromJour = jourBO.getJour(map.get("out_trade_no"), systemCode);
            toJour = jourBO.getRelativeJour(fromJour.getCode(),
                fromJour.getPayGroup());
            if (!EJourStatus.todoCallBack.getCode()
                .equals(fromJour.getStatus())) {
                throw new BizException("xn000000", "流水不处于待回调状态，重复回调");
            }
        } catch (JDOMException | IOException e) {
            throw new BizException("xn000000", "回调结果XML解析失败");
        }

        // 此处调用订单查询接口验证是否交易成功
        boolean isSucc = reqOrderquery(map, EChannelType.WeChat_H5.getCode());
        // 支付成功，商户处理后同步返回给微信参数
        if (!isSucc) {
            // 支付失败
            System.out.println("支付失败");
            jourBO.callBackChangeJour(fromJour, EBoolean.NO.getCode(),
                "WeChat_H5", "微信公众号支付后台自动回调", wechatOrderNo);
            jourBO.callBackChangeJour(toJour, EBoolean.NO.getCode(),
                "WeChat_H5", "微信公众号支付后台自动回调", wechatOrderNo);
        } else {
            System.out.println("===============付款成功==============");
            // ------------------------------
            // 处理业务开始
            // ------------------------------
            jourBO.callBackFromChangeJour(fromJour, "WeChat_H5",
                "微信公众号支付后台自动回调", wechatOrderNo);
            jourBO.callBackChangeJour(toJour, EBoolean.YES.getCode(),
                "WeChat_H5", "微信公众号支付后台自动回调", wechatOrderNo);
            // 收款方账户加钱
            accountBO.transAmountNotJour(systemCode, toJour.getAccountNumber(),
                toJour.getTransAmount(), toJour.getCode());
            // ------------------------------
            // 处理业务完毕
            // ------------------------------
        }
        return new CallbackResult(isSucc, fromJour.getBizType(),
            fromJour.getCode(), fromJour.getPayGroup(),
            fromJour.getTransAmount(), systemCode, companyCode, backUrl);
    }

    /** 
     * @see com.std.account.ao.IWeChatAO#doCallbackH5Qz(java.lang.String)
     */
    @Override
    public void doCallbackH5Qz(String result) {
        String systemCode = null;
        String wechatOrderNo = null;
        Jour jour = null;
        Map<String, String> map = null;
        try {
            map = XMLUtil.doXMLParse(result);
            String attach = map.get("attach");
            String[] codes = attach.split("\\|\\|");
            systemCode = codes[0];
            wechatOrderNo = map.get("transaction_id");
            jour = jourBO.getJour(map.get("out_trade_no"), systemCode);
            if (!EJourStatus.todoCallBack.getCode().equals(jour.getStatus())) {
                throw new BizException("xn000000", "充值流水不处于待回调状态，重复回调");
            }
        } catch (JDOMException | IOException e) {
            throw new BizException("xn000000", "回调结果XML解析失败");
        }

        // 此处调用订单查询接口验证是否交易成功
        boolean isSucc = reqOrderquery(map, EChannelType.WeChat_H5.getCode());
        // 支付成功，商户处理后同步返回给微信参数
        if (!isSucc) {
            // 支付失败
            System.out.println("支付失败");
            jourBO.callBackChangeJour(jour, EBoolean.NO.getCode(), "WeChat_H5",
                "微信公众号充值后台自动回调", wechatOrderNo);
        } else {
            System.out.println("===============付款成功==============");
            // ------------------------------
            // 处理业务开始
            // ------------------------------
            jourBO.callBackChangeJour(jour, EBoolean.YES.getCode(),
                "WeChat_H5", "微信公众号充值后台自动回调", wechatOrderNo);
            // 账户加钱
            accountBO.transAmountNotJour(systemCode, jour.getAccountNumber(),
                jour.getTransAmount(), jour.getCode());
            // ------------------------------
            // 处理业务完毕
            // ------------------------------
        }
    }

    @Override
    public CallbackResult doCallbackNative(String result) {
        String systemCode = null;
        String companyCode = null;
        String backUrl = null;
        String wechatOrderNo = null;
        Jour fromJour = null;
        Jour toJour = null;
        Map<String, String> map = null;
        try {
            map = XMLUtil.doXMLParse(result);
            String attach = map.get("attach");
            String[] codes = attach.split("\\|\\|");
            systemCode = codes[0];
            companyCode = codes[1];
            backUrl = codes[2];
            wechatOrderNo = map.get("transaction_id");
            fromJour = jourBO.getJour(map.get("out_trade_no"), systemCode);
            toJour = jourBO.getRelativeJour(fromJour.getCode(),
                fromJour.getPayGroup());
            if (!EJourStatus.todoCallBack.getCode()
                .equals(fromJour.getStatus())) {
                throw new BizException("xn000000", "流水不处于待回调状态，重复回调");
            }
        } catch (JDOMException | IOException e) {
            throw new BizException("xn000000", "回调结果XML解析失败");
        }

        // 此处调用订单查询接口验证是否交易成功
        boolean isSucc = reqOrderquery(map,
            EChannelType.WeChat_NATIVE.getCode());
        // 支付成功，商户处理后同步返回给微信参数
        if (!isSucc) {
            // 支付失败
            System.out.println("支付失败");
            jourBO.callBackChangeJour(fromJour, EBoolean.NO.getCode(),
                "WeChat_NATIVE", "微信扫码支付后台自动回调", wechatOrderNo);
            jourBO.callBackChangeJour(toJour, EBoolean.NO.getCode(),
                "WeChat_NATIVE", "微信扫码支付后台自动回调", wechatOrderNo);
        } else {
            System.out.println("===============付款成功==============");
            // ------------------------------
            // 处理业务开始
            // ------------------------------
            jourBO.callBackFromChangeJour(fromJour, "WeChat_NATIVE",
                "微信扫码支付后台自动回调", wechatOrderNo);
            jourBO.callBackChangeJour(toJour, EBoolean.YES.getCode(),
                "WeChat_NATIVE", "微信扫码支付后台自动回调", wechatOrderNo);
            // 收款方账户加钱
            accountBO.transAmountNotJour(systemCode, toJour.getAccountNumber(),
                toJour.getTransAmount(), toJour.getCode());
            // ------------------------------
            // 处理业务完毕
            // ------------------------------
        }
        return new CallbackResult(isSucc, fromJour.getBizType(),
            fromJour.getCode(), fromJour.getPayGroup(),
            fromJour.getTransAmount(), systemCode, companyCode, backUrl);
    }

    @Override
    public String getAccessToken(String appId, String appSecret) {
        String accessToken = null;
        String postUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + appId + "&secret=" + appSecret;
        String response = null;
        try {
            response = new String(HttpsUtil.post(postUrl, "", "UTF-8"));
            TokenResponse tokenResponse = JsonUtil.json2Bean(response,
                TokenResponse.class);
            accessToken = tokenResponse.getAccess_token();
        } catch (Exception e) {
            throw new BizException("xn000000", "获取微信accessToekn失败，请检查参数");
        }
        return accessToken;
    }

    public boolean reqOrderquery(Map<String, String> map, String channelType) {
        System.out.println("******* 开始订单查询 ******");
        WXOrderQuery orderQuery = new WXOrderQuery();
        orderQuery.setAppid(map.get("appid"));
        orderQuery.setMch_id(map.get("mch_id"));
        orderQuery.setTransaction_id(map.get("transaction_id"));
        orderQuery.setOut_trade_no(map.get("out_trade_no"));
        orderQuery.setNonce_str(map.get("nonce_str"));

        String attach = map.get("attach");
        System.out.println("attcah=" + attach);
        String[] codes = attach.split("\\|\\|");
        System.out.println("companyCode=" + codes[0] + " systemCode="
                + codes[1]);
        CompanyChannel companyChannel = companyChannelBO.getCompanyChannel(
            codes[0], codes[1], channelType);

        // 此处需要密钥PartnerKey，此处直接写死，自己的业务需要从持久化中获取此密钥，否则会报签名错误
        orderQuery.setPartnerKey(companyChannel.getPrivateKey1());

        Map<String, String> orderMap = orderQuery.reqOrderquery();
        // 此处添加支付成功后，支付金额和实际订单金额是否等价，防止钓鱼
        if (orderMap.get("return_code") != null
                && orderMap.get("return_code").equalsIgnoreCase("SUCCESS")) {
            if (orderMap.get("trade_state") != null
                    && orderMap.get("trade_state").equalsIgnoreCase("SUCCESS")) {
                String total_fee = map.get("total_fee");
                String order_total_fee = map.get("total_fee");
                if (Integer.parseInt(order_total_fee) >= Integer
                    .parseInt(total_fee)) {
                    System.out.println("******* 开订单查询结束，结果正确 ******");
                    return true;
                }
            }
        }
        System.out.println("******* 开订单查询结束，结果不正确 ******");
        return false;
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
