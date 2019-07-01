package com.std.account.dto.req;

public class XN802521Req {
    // 真实姓名
    private String realName;

    // 账户类型
    private String accountType;

    // 账号
    private String accountNumber;

    // 渠道类型
    private String channelType;

    // 渠道单号
    private String channelOrder;

    // 业务类型
    private String bizType;

    // 状态（生成待回调，无需对账，已回调待对账，对账通过，对账不通过待调账，已调账）
    private String status;

    // 处理回调人
    private String rollbackUser;

    // 拟对账时间
    private String workDate;

    // 对账人
    private String checkUser;

    // 调账人
    private String adjustUser;

    // 系统编号
    private String systemCode;

    // 币种
    private String currency;

    // 开始时间起
    private String createDatetimeStart;

    // 开始时间止
    private String createDatetimeEnd;

    public String getCreateDatetimeStart() {
        return createDatetimeStart;
    }

    public void setCreateDatetimeStart(String createDatetimeStart) {
        this.createDatetimeStart = createDatetimeStart;
    }

    public String getCreateDatetimeEnd() {
        return createDatetimeEnd;
    }

    public void setCreateDatetimeEnd(String createDatetimeEnd) {
        this.createDatetimeEnd = createDatetimeEnd;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getChannelOrder() {
        return channelOrder;
    }

    public void setChannelOrder(String channelOrder) {
        this.channelOrder = channelOrder;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRollbackUser() {
        return rollbackUser;
    }

    public void setRollbackUser(String rollbackUser) {
        this.rollbackUser = rollbackUser;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public String getAdjustUser() {
        return adjustUser;
    }

    public void setAdjustUser(String adjustUser) {
        this.adjustUser = adjustUser;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
