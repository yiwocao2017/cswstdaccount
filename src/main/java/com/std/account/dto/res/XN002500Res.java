/**
 * @Title XN802182Res.java 
 * @Package com.std.account.dto.res 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月26日 下午4:46:41 
 * @version V1.0   
 */
package com.std.account.dto.res;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月26日 下午4:46:41 
 * @history:
 */
public class XN002500Res {

    // 橙账本流水编号
    private String payCode;

    // 公众号id
    private String appId;

    // 微信支付分配的商户号
    private String partnerid;

    // 微信预支付订单号
    private String prepayId;

    // 订单详情扩展字符串
    private String wechatPackage;

    // 随机字符串
    private String nonceStr;

    // 时间戳
    private String timeStamp;

    // 签名
    private String sign;

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getWechatPackage() {
        return wechatPackage;
    }

    public void setWechatPackage(String wechatPackage) {
        this.wechatPackage = wechatPackage;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
