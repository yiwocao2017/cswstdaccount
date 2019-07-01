package com.std.account.dto.req;

/**
 * @author: xieyj 
 * @since: 2017年1月18日 上午11:09:57 
 * @history:
 */
public class XN802012Req {
    // 编号(必填)
    public String code;

    // 卡号(必填)
    public String bankcardNumber;

    // 银行行别（必填）
    public String bankCode;

    // 银行名称（必填）
    public String bankName;

    // 支行名称（选填）
    public String subbranch;

    // 绑定手机号（选填）
    public String bindMobile;

    // 状态(必填)
    public String status;

    // 备注（选填）
    public String remark;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
