package com.std.account.dto.req;

public class XN001102Req {

    // 手机号（必填）
    private String mobile;

    // kind(必填)
    private String kind;

    // 系统编号（必填）
    private String systemCode;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
