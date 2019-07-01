package com.std.account.dto.req;

/**
 * 绑定银行卡
 * @author: asus 
 * @since: 2016年12月22日 下午4:56:20 
 * @history:
 */
public class XN802010Req {
    // 系统编号（必填）
    public String systemCode;

    // 银行编号
    private String bankCode;

    // 卡号（必填）
    public String bankcardNumber;

    // 银行名称（必填）
    public String bankName;

    // 支行名称（必填）
    public String subbranch;

    // 绑定手机号（必填）
    public String bindMobile;

    // 用户编号（必填）
    public String userId;

    // 用户姓名（必填）
    public String realName;

    // 类型（必填）
    public String type;

    // 币种（必填）
    public String currency;

    // 备注（选填）
    public String remark;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getBindMobile() {
        return bindMobile;
    }

    public void setBindMobile(String bindMobile) {
        this.bindMobile = bindMobile;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

}
