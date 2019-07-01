package com.std.account.dto.req;

import java.util.List;

public class XN802511Req {
    // 订单编号(必填)
    private List<String> codeList;

    // 回调备注(必填)
    private String rollbackNote;

    // 回调人(必填)
    private String rollbackUser;

    // 回调结果(选填)
    private String rollbackResult;

    // 系统编号(必填)
    private String systemCode;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getRollbackNote() {
        return rollbackNote;
    }

    public void setRollbackNote(String rollbackNote) {
        this.rollbackNote = rollbackNote;
    }

    public String getRollbackUser() {
        return rollbackUser;
    }

    public void setRollbackUser(String rollbackUser) {
        this.rollbackUser = rollbackUser;
    }

    public String getRollbackResult() {
        return rollbackResult;
    }

    public void setRollbackResult(String rollbackResult) {
        this.rollbackResult = rollbackResult;
    }
}
