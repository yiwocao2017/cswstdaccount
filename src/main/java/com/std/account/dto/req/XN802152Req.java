package com.std.account.dto.req;

public class XN802152Req {
    // 公司名(必填)
    private String companyCode;

    // 商户订单号(必填)
    private String mchntOrderId;

    // 用户编号(必填)
    private String userId;

    // 交易金额(必填)
    private String amt;

    // 银行卡号(必填)
    private String bankCard;

    // 姓名(必填)
    private String name;

    // 证件类型(必填)0.身份证 1.护照 2.军官证 3.士 兵证 4.回乡证 6.户口本 7.其它
    private String idType;

    // 身份证号码(必填)
    private String idNo;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getMchntOrderId() {
        return mchntOrderId;
    }

    public void setMchntOrderId(String mchntOrderId) {
        this.mchntOrderId = mchntOrderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

}
