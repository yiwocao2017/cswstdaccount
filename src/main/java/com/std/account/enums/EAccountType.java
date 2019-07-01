package com.std.account.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 上午10:54:16 
 * @history:
 */
public enum EAccountType {
    Business("B", "B端账号"), Partner("PA", "合伙人账号"), Customer("C", "C端账号"), Plat(
            "P", "平台账号");

    public static Map<String, EAccountType> getAccountTypeResultMap() {
        Map<String, EAccountType> map = new HashMap<String, EAccountType>();
        for (EAccountType type : EAccountType.values()) {
            map.put(type.getCode(), type);
        }
        return map;
    }

    EAccountType(String code, String value) {
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
