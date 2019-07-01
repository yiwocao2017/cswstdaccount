package com.std.account.dto.req;

public class XN802600Req {

    // 户名(必填)
    private String accountName;

    // 账号(必填)
    private String accountNumber;

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

}
