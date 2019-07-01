package com.std.account.dto.res;

public class ChannelCallbackRes {
    // 是否成功
    private boolean isSuccess;

    // 错误编号
    private String errorCode;

    // 错误信息:成功则显示"成功"
    private String errorInfo;

    // 支付订单号
    private String channelOrderNo;

    // 商家订单号
    private String companyOrderNo;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
    }

    public String getCompanyOrderNo() {
        return companyOrderNo;
    }

    public void setCompanyOrderNo(String companyOrderNo) {
        this.companyOrderNo = companyOrderNo;
    }

}
