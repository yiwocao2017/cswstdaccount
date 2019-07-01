package com.std.account.domain;

import java.util.Date;

import com.std.account.dao.base.ABaseDO;

/**
* 币种兑换
* @author: xieyj
* @since: 2017年03月30日 11:54:26
* @history:
*/
public class ExchangeCurrency extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 去方用户
    private String toUserId;

    // 去方金额
    private Long toAmount;

    // 去方币种
    private String toCurrency;

    // 来方用户
    private String fromUserId;

    // 来方金额
    private Long fromAmount;

    // 来方币种
    private String fromCurrency;

    // 产生时间
    private Date createDatetime;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 支付方式
    private String payType;

    // 支付组号
    private String payGroup;

    // 支付编号(第三方支付号)
    private String payCode;

    // 支付金额
    private Long payAmount;

    // 支付时间
    private Date payDatetime;

    // 来方币种
    private String companyCode;

    // 公司编号
    private String systemCode;

    // ******************************************
    private User fromUser;

    private User toUser;

    private Date createDatetimeStart;

    private Date createDatetimeEnd;

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public Date getCreateDatetimeStart() {
        return createDatetimeStart;
    }

    public void setCreateDatetimeStart(Date createDatetimeStart) {
        this.createDatetimeStart = createDatetimeStart;
    }

    public Date getCreateDatetimeEnd() {
        return createDatetimeEnd;
    }

    public void setCreateDatetimeEnd(Date createDatetimeEnd) {
        this.createDatetimeEnd = createDatetimeEnd;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public void setToAmount(Long toAmount) {
        this.toAmount = toAmount;
    }

    public Long getToAmount() {
        return toAmount;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setFromAmount(Long fromAmount) {
        this.fromAmount = fromAmount;
    }

    public Long getFromAmount() {
        return fromAmount;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayGroup(String payGroup) {
        this.payGroup = payGroup;
    }

    public String getPayGroup() {
        return payGroup;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayDatetime(Date payDatetime) {
        this.payDatetime = payDatetime;
    }

    public Date getPayDatetime() {
        return payDatetime;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
