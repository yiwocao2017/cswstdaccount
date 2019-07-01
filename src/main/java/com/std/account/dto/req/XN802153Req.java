package com.std.account.dto.req;

public class XN802153Req {
    private String companyCode;

    // 版本号
    private String version;

    // 类型
    private String type;

    // 响应代码
    private String responseCode;

    // 响应中文􏰁 述
    private String responseMsg;

    // 商户号
    private String mchntCd;

    // 商户订单号
    private String mchntOrderId;

    // 富友订单号
    private String orderId;

    // 银行卡号
    private String backCard;

    // 交易金额
    private String amt;

    // 摘要数据
    private String sign;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getMchntCd() {
        return mchntCd;
    }

    public void setMchntCd(String mchntCd) {
        this.mchntCd = mchntCd;
    }

    public String getMchntOrderId() {
        return mchntOrderId;
    }

    public void setMchntOrderId(String mchntOrderId) {
        this.mchntOrderId = mchntOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBackCard() {
        return backCard;
    }

    public void setBackCard(String backCard) {
        this.backCard = backCard;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
