package com.std.account.enums;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 上午10:54:16 
 * @history:
 */
public enum EExchangeCurrencyStatus {

    TO_PAY("0", "待支付"), PAYED("1", "已支付"), CANCEL("2", "已取消");

    EExchangeCurrencyStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

}
