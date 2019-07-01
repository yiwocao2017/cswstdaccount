package com.std.account.dto.req;

public class XN802412Req {
    // 申请人（必填）
    private String userId;

    // 来方虚拟币金额（必填）
    private String fromAmount;

    // 来方虚拟币币种（必填）
    private String fromCurrency;

    // 去方虚拟币币种（必填）
    private String toCurrency;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(String fromAmount) {
        this.fromAmount = fromAmount;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

}
