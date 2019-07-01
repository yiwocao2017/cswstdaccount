package com.std.account.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年12月25日 下午3:25:44 
 * @history:
 */
public class XN802514Req {
    // 系统编号(必填)
    private String systemCode;

    // 单号(必填)
    private String code;

    // 对账金额(0 无偏差，正数加钱，负数扣钱)(必填)
    private String checkAmount;

    // 对账说明(必填)
    private String checkNote;

    // 对账人(必填)
    private String checkUser;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(String checkAmount) {
        this.checkAmount = checkAmount;
    }

    public String getCheckNote() {
        return checkNote;
    }

    public void setCheckNote(String checkNote) {
        this.checkNote = checkNote;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }
}
