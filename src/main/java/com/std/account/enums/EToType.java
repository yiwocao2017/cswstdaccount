package com.std.account.enums;

import java.util.HashMap;
import java.util.Map;

public enum EToType {
    BankCard("BC", "银行卡"), Alipay("alipay", "支付宝");

    public static Map<String, EToType> getToTypeMap() {
        Map<String, EToType> map = new HashMap<String, EToType>();
        for (EToType direction : EToType.values()) {
            map.put(direction.getCode(), direction);
        }
        return map;
    }

    EToType(String code, String value) {
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
