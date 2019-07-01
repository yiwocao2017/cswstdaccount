package com.std.account.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2017年1月5日 上午9:57:49 
 * @history:
 */
public enum ESysAccount {
    CNY("A2016100000000000000", "人民币"), FRB("A2016100000000000001", "分润"), GXJL(
            "A2016100000000000002", "贡献值"), QBB("A2016100000000000003", "钱包币"), GWB(
            "A2016100000000000004", "购物币"), HBB("A2016100000000000005", "红包币"), HBYJ(
            "A2016100000000000006", "红包业绩");

    public static Map<String, ESysAccount> getResultMap() {
        Map<String, ESysAccount> map = new HashMap<String, ESysAccount>();
        for (ESysAccount sysAccount : ESysAccount.values()) {
            map.put(sysAccount.getCode(), sysAccount);
        }
        return map;
    }

    ESysAccount(String code, String value) {
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
