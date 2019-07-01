package com.std.account.dto.req;

public class XN802162Req {
    // 公司名(必填)
    private String companyCode;

    // 结果通知：1=跳到成功界面，否则跳转至错误界面
    private String result;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
