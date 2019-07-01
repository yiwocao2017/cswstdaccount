package com.std.account.dto.req;

import java.util.List;

public class XN802411Req {

    // 兑换编号(必填)
    private List<String> codeList;

    // 审批结果(必填)
    private String approveResult;

    // 审批人(必填)
    private String approver;

    // 审批说明(必填)
    private String approveNote;

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

}
