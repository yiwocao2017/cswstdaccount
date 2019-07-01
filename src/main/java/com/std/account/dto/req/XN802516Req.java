package com.std.account.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年12月25日 下午3:25:44 
 * @history:
 */
public class XN802516Req {

    // 系统编号(必填)
    private String systemCode;

    // 单号(必填)
    private String code;

    // 调账结果(必填) 1/0
    private String adjustResult;

    // 调账说明(必填)
    private String adjustNote;

    // 调账人(必填)
    private String adjustUser;

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

    public String getAdjustResult() {
        return adjustResult;
    }

    public void setAdjustResult(String adjustResult) {
        this.adjustResult = adjustResult;
    }

    public String getAdjustNote() {
        return adjustNote;
    }

    public void setAdjustNote(String adjustNote) {
        this.adjustNote = adjustNote;
    }

    public String getAdjustUser() {
        return adjustUser;
    }

    public void setAdjustUser(String adjustUser) {
        this.adjustUser = adjustUser;
    }
}
