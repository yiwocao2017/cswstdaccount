package com.std.account.dto.req;

public class XN802163Req {

    // 公司名(必填)
    private String companyCode;

    // 商户订单号
    private String transId;

    // 下单时间(必填)
    private String tradeDate;

    // 金额(必填，精确到厘)
    private String txnAmt;

    // 银行编码(选填)
    private String payCode;

    // 银行卡号(选填)
    private String accNo;

    // 身份证类型
    private String idCardType = "01";

    // 身份证号(选填)
    private String idCard;

    // 持卡人(选填)
    private String idHolder;

    // 手机号(选填)
    private String mobile;

    private String validDate;

    private String validNo;

    // 商品名称(选填)
    private String commodityName;

    // 商品数量(选填)
    private String commodityAmount;

    // 用户名称(选填)
    private String userName;

    // 附加字段(选填)
    private String additionInfo;

    private String reqReserved;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(String txnAmt) {
        this.txnAmt = txnAmt;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdHolder() {
        return idHolder;
    }

    public void setIdHolder(String idHolder) {
        this.idHolder = idHolder;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

}
