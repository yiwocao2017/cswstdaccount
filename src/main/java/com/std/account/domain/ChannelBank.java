package com.std.account.domain;

import com.std.account.dao.base.ABaseDO;

public class ChannelBank extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 序号
    private Long id;

    // 银行编号
    private String bankCode;

    // 银行名称
    private String bankName;

    // 渠道银行
    private String channelType;

    // 状态(1 启用 0 不启用)
    private String status;

    // 渠道银行代号
    private String channelBank;

    // 每日笔数限制
    private Long maxOrder;

    // 单笔限额
    private Long orderAmount;

    // 每日限额
    private Long dayAmount;

    // 每月限额
    private Long monthAmount;

    // 备注
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getMaxOrder() {
        return maxOrder;
    }

    public void setMaxOrder(Long maxOrder) {
        this.maxOrder = maxOrder;
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getDayAmount() {
        return dayAmount;
    }

    public void setDayAmount(Long dayAmount) {
        this.dayAmount = dayAmount;
    }

    public Long getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(Long monthAmount) {
        this.monthAmount = monthAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getChannelBank() {
        return channelBank;
    }

    public void setChannelBank(String channelBank) {
        this.channelBank = channelBank;
    }
}
