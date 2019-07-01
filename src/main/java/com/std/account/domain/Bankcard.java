package com.std.account.domain;

import java.util.Date;

import com.std.account.dao.base.ABaseDO;

/**
* 银行卡
* @author: xieyj 
* @since: 2016年12月22日 15:14:12
* @history:
*/
public class Bankcard extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 银行卡编号
    private String bankcardNumber;

    // 银行行别
    private String bankCode;

    // 银行名称
    private String bankName;

    // 开户支行
    private String subbranch;

    // 银行卡绑定手机号
    private String bindMobile;

    // 用户编号
    private String userId;

    // 真实姓名
    private String realName;

    // 类型
    private String type;

    // 状态
    private String status;

    // 币种
    private String currency;

    // 余额
    private Long amount;

    // 冻结金额
    private Long frozenAmount;

    // MD5
    private String md5;

    // 创建时间
    private Date createDatetime;

    // 备注
    private String remark;

    // 最近一次变动对应的流水编号
    private String lastOrder;

    // 系统编号
    private String systemCode;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setBindMobile(String bindMobile) {
        this.bindMobile = bindMobile;
    }

    public String getBindMobile() {
        return bindMobile;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getMd5() {
        return md5;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setLastOrder(String lastOrder) {
        this.lastOrder = lastOrder;
    }

    public String getLastOrder() {
        return lastOrder;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(Long frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

}
