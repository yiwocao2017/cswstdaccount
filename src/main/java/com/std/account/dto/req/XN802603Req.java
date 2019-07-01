package com.std.account.dto.req;

public class XN802603Req {
    // 系统编号(必填)
    private String systemCode;

    // 公司编号(必填)
    private String companyCode;

    // 户名(必填)
    private String accountName;

    // 账号(必填)
    private String accountNumber;

    // 变动金额(必填-划转金额)
    private String transAmount;

    // 证件类型(必填)0.身份证 1.护照 2.军官证 3.士 兵证 4.回乡证 6.户口本 7.其它
    private String idType;

    // 身份证号码(必填)
    private String idNo;

    // 姓名(必填)
    private String name;

    // 银行卡号(必填)
    private String bankCard;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(String transAmount) {
        this.transAmount = transAmount;
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
