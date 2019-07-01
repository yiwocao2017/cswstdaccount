package com.std.account.enums;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 上午10:09:32 
 * @history:
 */
public enum EPayType {
    RMB_YE("1", "余额支付"), WEIXIN_APP("2", "微信APP"), WEIXIN_H5("5", "微信h5"), WEIXIN_QR_CODE(
            "6", "微信二维码扫描"), ALIPAY("3", "支付宝"), DBHZ("dbhz", "单一币种划转");

    EPayType(String code, String value) {
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
