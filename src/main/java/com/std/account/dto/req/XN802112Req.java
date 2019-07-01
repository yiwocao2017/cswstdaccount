package com.std.account.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年9月17日 下午4:09:23 
 * @history:
 */
public class XN802112Req {
    // 编号（必填）
    private String id;

    // 银行编号(必填)
    private String bankCode;

    // 银行名称(必填)
    private String bankName;

    // 渠道类型(必填)
    private String channelType;

    // 状态(必填)(1 启用 0 不启用)
    private String status;

    // 渠道给银行的代号(必填)
    private String channelBank;

    // 每日笔数限制(必填)
    private String maxOrder;

    // 单笔限额(必填)
    private String orderAmount;

    // 每日限额(必填)
    private String dayAmount;

    // 每月限额(必填)
    private String monthAmount;

    // 备注(选填)
    private String remark;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMaxOrder() {
        return maxOrder;
    }

    public void setMaxOrder(String maxOrder) {
        this.maxOrder = maxOrder;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getDayAmount() {
        return dayAmount;
    }

    public void setDayAmount(String dayAmount) {
        this.dayAmount = dayAmount;
    }

    public String getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(String monthAmount) {
        this.monthAmount = monthAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelBank() {
        return channelBank;
    }

    public void setChannelBank(String channelBank) {
        this.channelBank = channelBank;
    }
}
