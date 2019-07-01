package com.std.account.dto.req;

public class XN802161Req {
    // 公司名(必填)
    private String companyCode;

    String additionalInfo;// 订单附加消息

    String succTime;// 支付完成时间

    String md5Sign;// MD5签名

    String terminalID;// 商户终端号

    String transID;// 商户流水号

    String result;// 支付结果

    String resultDesc;// 支付结果描述

    String factMoney;// 实际成功金额，以分为单位

    String memberID;// 商户号

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getSuccTime() {
        return succTime;
    }

    public void setSuccTime(String succTime) {
        this.succTime = succTime;
    }

    public String getMd5Sign() {
        return md5Sign;
    }

    public void setMd5Sign(String md5Sign) {
        this.md5Sign = md5Sign;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getFactMoney() {
        return factMoney;
    }

    public void setFactMoney(String factMoney) {
        this.factMoney = factMoney;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
