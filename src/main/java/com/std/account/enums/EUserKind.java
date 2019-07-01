package com.std.account.enums;

public enum EUserKind {
    F1("f1", "C端会员"), F2("f2", "B端商家"), Operator("01", "平台"), Partner("11",
            "合伙人");

    EUserKind(String code, String value) {
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
