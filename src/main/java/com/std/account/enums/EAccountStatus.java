package com.std.account.enums;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 上午10:54:16 
 * @history:
 */
public enum EAccountStatus {

    NORMAL("0", "正常"), LI_LOCK("1", "程序锁定"), RG_LOCK("2", "人工锁定");

    EAccountStatus(String code, String value) {
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
