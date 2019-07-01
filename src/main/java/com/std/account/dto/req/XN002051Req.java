package com.std.account.dto.req;

public class XN002051Req {
    // 1fromCurrency=多少toCurrency（必填）
    private String fromCurrency;

    // 币种（必填）
    private String toCurrency;

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
