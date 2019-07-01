package com.std.account.enums;

import java.util.HashMap;
import java.util.Map;

public enum EFromType {
    BankCard("BC", "银行卡"), Alipay("alipay", "支付宝");
    public static Map<String, EFromType> getFromTypeMap() {
        Map<String, EFromType> map = new HashMap<String, EFromType>();
        for (EFromType direction : EFromType.values()) {
            map.put(direction.getCode(), direction);
        }
        return map;
    }

    EFromType(String code, String value) {
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
