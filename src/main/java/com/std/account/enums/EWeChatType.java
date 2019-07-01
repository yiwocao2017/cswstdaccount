/**
 * @Title EWeChatType.java 
 * @Package com.std.account.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月26日 下午3:47:12 
 * @version V1.0   
 */
package com.std.account.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月26日 下午3:47:12 
 * @history:
 */
public enum EWeChatType {
    JSAPI("JSAPI", "公众号支付"), APP("APP", "APP支付"), NATIVE("NATIVE", "扫码支付");
    public static Map<String, EWeChatType> getFromTypeMap() {
        Map<String, EWeChatType> map = new HashMap<String, EWeChatType>();
        for (EWeChatType direction : EWeChatType.values()) {
            map.put(direction.getCode(), direction);
        }
        return map;
    }

    EWeChatType(String code, String value) {
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
