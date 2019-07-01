/**
 * @Title ECurrency.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午4:41:06 
 * @version V1.0   
 */
package com.std.account.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年12月24日 下午1:51:38 
 * @history:
 */
public enum ESystemCode {
    ZHPAY("CD-CZH000001", "正汇钱包"), CSH("CD-CCSH00000X", "橙商户"), CAIGO(
            "CD-CCG000007", "菜狗商城"), CSW("CD-CCSW000008", "城市网");

    public static Map<String, ESystemCode> getCurrencyMap() {
        Map<String, ESystemCode> map = new HashMap<String, ESystemCode>();
        for (ESystemCode currency : ESystemCode.values()) {
            map.put(currency.getCode(), currency);
        }
        return map;
    }

    ESystemCode(String code, String value) {
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
