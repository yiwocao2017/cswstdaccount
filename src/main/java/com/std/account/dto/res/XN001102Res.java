package com.std.account.dto.res;

public class XN001102Res {
    // 用户编号
    private String userId;

    public XN001102Res() {
    }

    public XN001102Res(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
