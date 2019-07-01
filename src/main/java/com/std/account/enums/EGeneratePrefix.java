package com.std.account.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 上午10:19:32 
 * @history:
 */
public enum EGeneratePrefix {
    Account("A", "账户"), AJour("AJ", "账户流水"), CompanyChannel("CC", "公司渠道"), ChannelBank(
            "CB", "渠道银行"), BankCard("CT", "银行卡"), CMB_BIZ_NO("CBN",
            "招商银企直联业务参考号"), EXCHANGE_CURRENCY("EC", "币种兑换");

    public static Map<String, EGeneratePrefix> getOrderTypeMap() {
        Map<String, EGeneratePrefix> map = new HashMap<String, EGeneratePrefix>();
        for (EGeneratePrefix orderType : EGeneratePrefix.values()) {
            map.put(orderType.getCode(), orderType);
        }
        return map;
    }

    EGeneratePrefix(String code, String value) {
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
