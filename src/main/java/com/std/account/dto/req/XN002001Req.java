package com.std.account.dto.req;


/** 
 * @author: xieyj 
 * @since: 2016年12月23日 下午7:48:53 
 * @history:
 */
public class XN002001Req {
    // 用户编号(必填)
    private String userId;

    // 户名(必填）
    private String realName;

    // 系统编号(必填)
    private String systemCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
