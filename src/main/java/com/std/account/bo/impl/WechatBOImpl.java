/**
 * @Title WechatBOImpl.java 
 * @Package com.std.account.bo.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年2月27日 下午3:16:19 
 * @version V1.0   
 */
package com.std.account.bo.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.std.account.bo.IWechatBO;
import com.std.account.common.PropertiesUtil;
import com.std.account.domain.CompanyChannel;
import com.std.account.dto.res.XN002500Res;
import com.std.account.dto.res.XN002501Res;
import com.std.account.enums.EWeChatType;
import com.std.account.util.wechat.MD5;
import com.std.account.util.wechat.MD5Util;
import com.std.account.util.wechat.OrderUtil;
import com.std.account.util.wechat.WXPrepay;

/** 
 * @author: haiqingzheng 
 * @since: 2017年2月27日 下午3:16:19 
 * @history:
 */
@Component
public class WechatBOImpl implements IWechatBO {

    @Override
    public String getPrepayIdApp(CompanyChannel companyChannel, String bizNote,
            String code, Long transAmount, String ip, String backUrl) {
        WXPrepay prePay = new WXPrepay();
        prePay.setAppid(companyChannel.getPrivateKey2());// 微信开放平台审核通过的应用APPID
        prePay.setMch_id(companyChannel.getChannelCompany()); // 商户号
        prePay.setBody(companyChannel.getCompanyName() + "-" + bizNote); // 商品描述
        prePay.setOut_trade_no(code); // 订单号
        prePay.setTotal_fee(Long.toString(transAmount / 10)); // 订单总金额，厘转化成分
        prePay.setSpbill_create_ip(ip); // 用户IP
        prePay.setTrade_type(EWeChatType.APP.getCode()); // 交易类型
        prePay.setNotify_url(PropertiesUtil.Config.WECHAT_APP_BACKURL);// 回调地址
        prePay.setPartnerKey(companyChannel.getPrivateKey1()); // 商户秘钥
        prePay.setAttach(companyChannel.getSystemCode() + "||"
                + companyChannel.getCompanyCode() + "||" + backUrl); // 附加字段，回调时返回
        return prePay.submitXmlGetPrepayId();
    }

    @Override
    public XN002500Res getPayInfoApp(CompanyChannel companyChannel,
            String payCode, String prepayId) {
        SortedMap<String, String> nativeObj = new TreeMap<String, String>();
        nativeObj.put("appid", companyChannel.getPrivateKey2());
        nativeObj.put("partnerid", companyChannel.getChannelCompany());
        nativeObj.put("prepayid", prepayId);
        nativeObj.put("package", "Sign=WXPay");
        Random random = new Random();
        String randomStr = MD5.GetMD5String(String.valueOf(random
            .nextInt(10000)));
        nativeObj.put("noncestr", MD5Util.MD5Encode(randomStr, "utf-8")
            .toLowerCase());
        nativeObj.put("timestamp", OrderUtil.GetTimestamp());
        nativeObj.put("sign",
            createSign(nativeObj, companyChannel.getPrivateKey1()));

        XN002500Res res = new XN002500Res();
        res.setAppId(nativeObj.get("appid"));
        res.setPayCode(payCode);
        res.setPartnerid(nativeObj.get("partnerid"));
        res.setPrepayId(nativeObj.get("prepayid"));
        res.setWechatPackage(nativeObj.get("package"));
        res.setNonceStr(nativeObj.get("noncestr"));
        res.setTimeStamp(nativeObj.get("timestamp"));
        res.setSign(nativeObj.get("sign"));
        return res;
    }

    @Override
    public String getPrepayIdH5(CompanyChannel companyChannel, String openId,
            String bizNote, String code, Long transAmount, String ip,
            String wxBackUrl, String bizBackUrl) {
        WXPrepay prePay = new WXPrepay();
        prePay.setAppid(companyChannel.getPrivateKey2());// 微信支付分配的公众账号ID
        prePay.setMch_id(companyChannel.getChannelCompany()); // 商户号
        prePay.setBody(companyChannel.getCompanyName() + "-" + bizNote); // 商品描述
        prePay.setOut_trade_no(code); // 订单号
        prePay.setTotal_fee(Long.toString(transAmount / 10)); // 订单总金额，厘转化成分
        prePay.setSpbill_create_ip(ip); // 用户IP
        prePay.setTrade_type(EWeChatType.JSAPI.getCode()); // 交易类型
        prePay.setNotify_url(wxBackUrl);// 回调地址
        prePay.setPartnerKey(companyChannel.getPrivateKey1()); // 商户秘钥
        prePay.setOpenid(openId); // 支付者openid
        prePay.setAttach(companyChannel.getSystemCode() + "||"
                + companyChannel.getCompanyCode() + "||" + bizBackUrl); // 附加字段，回调时返回
        return prePay.submitXmlGetPrepayId();
    }

    @Override
    public XN002501Res getPayInfoH5(CompanyChannel companyChannel,
            String payCode, String prepayId) {
        SortedMap<String, String> nativeObj = new TreeMap<String, String>();
        nativeObj.put("appId", companyChannel.getPrivateKey2());
        nativeObj.put("timeStamp", OrderUtil.GetTimestamp());
        Random random = new Random();
        String randomStr = MD5.GetMD5String(String.valueOf(random
            .nextInt(10000)));
        nativeObj.put("nonceStr", MD5Util.MD5Encode(randomStr, "utf-8")
            .toLowerCase());
        nativeObj.put("package", "prepay_id=" + prepayId);
        nativeObj.put("signType", "MD5");
        nativeObj.put("paySign",
            createSign(nativeObj, companyChannel.getPrivateKey1()));

        XN002501Res res = new XN002501Res();
        res.setPrepayId(prepayId);
        res.setPayCode(payCode);
        res.setAppId(nativeObj.get("appId"));
        res.setTimeStamp(nativeObj.get("timeStamp"));
        res.setNonceStr(nativeObj.get("nonceStr"));
        res.setWechatPackage(nativeObj.get("package"));
        res.setSignType(nativeObj.get("signType"));
        res.setPaySign(nativeObj.get("paySign"));
        return res;
    }

    @Override
    public String getPrepayIdNative(CompanyChannel companyChannel,
            String bizNote, String code, Long transAmount, String ip,
            String backUrl) {
        WXPrepay prePay = new WXPrepay();
        prePay.setAppid(companyChannel.getPrivateKey2());// 微信支付分配的公众账号ID
        prePay.setMch_id(companyChannel.getChannelCompany()); // 商户号
        prePay.setBody(companyChannel.getCompanyName() + "-" + bizNote); // 商品描述
        prePay.setOut_trade_no(code); // 订单号
        prePay.setTotal_fee(Long.toString(transAmount / 10)); // 订单总金额，厘转化成分
        prePay.setSpbill_create_ip(ip); // 用户IP
        prePay.setTrade_type(EWeChatType.NATIVE.getCode()); // 交易类型
        prePay.setNotify_url(PropertiesUtil.Config.WECHAT_NATIVE_BACKURL);// 回调地址
        prePay.setPartnerKey(companyChannel.getPrivateKey1()); // 商户秘钥
        prePay.setProduct_id(code);
        prePay.setAttach(companyChannel.getSystemCode() + "||"
                + companyChannel.getCompanyCode() + "||" + backUrl); // 附加字段，回调时返回
        return prePay.submitXmlGetCodeUrl();
    }

    /**
     * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
     */
    private String createSign(SortedMap<String, String> packageParams,
            String AppKey) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k)
                    && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + AppKey);
        String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
        return sign;
    }
}
