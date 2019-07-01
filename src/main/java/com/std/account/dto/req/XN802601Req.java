package com.std.account.dto.req;

public class XN802601Req {
    // 系统编号(必填)
    private String systemCode;

    // 来方-户名(必填)
    private String FromAccountName;

    // 来方-账号(必填)
    private String FromAccountNumber;

    // 受方-户名(必填)
    private String ToAccountName;

    // 受方-账号(必填)
    private String ToAccountNumber;

    // 变动金额(必填-划转金额)
    private String transAmount;

    // 业务类型(必填-划转业务类型)
    private String bizType;

    // 业务说明(必填-划转业务说明)
    private String bizNote;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getFromAccountName() {
        return FromAccountName;
    }

    public void setFromAccountName(String fromAccountName) {
        FromAccountName = fromAccountName;
    }

    public String getFromAccountNumber() {
        return FromAccountNumber;
    }

    public void setFromAccountNumber(String fromAccountNumber) {
        FromAccountNumber = fromAccountNumber;
    }

    public String getToAccountName() {
        return ToAccountName;
    }

    public void setToAccountName(String toAccountName) {
        ToAccountName = toAccountName;
    }

    public String getToAccountNumber() {
        return ToAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        ToAccountNumber = toAccountNumber;
    }

    public String getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(String transAmount) {
        this.transAmount = transAmount;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizNote() {
        return bizNote;
    }

    public void setBizNote(String bizNote) {
        this.bizNote = bizNote;
    }

}
