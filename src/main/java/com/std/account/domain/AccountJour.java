/**
 * @Title AccountJour.java 
 * @Package com.ibis.account.domain 
 * @Description 
 * @author miyb  
 * @date 2015-2-12 下午8:38:25 
 * @version V1.0   
 */
package com.std.account.domain;

import java.util.Date;

import com.std.account.dao.base.ABaseDO;

/** 
 * 监控账户余额。
 * @author: miyb 
 * @since: 2015-2-12 下午8:38:25 
 * @history:
 */
public class AccountJour extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1255747682967604091L;

    // 查询条件1：创建起始时间
    private Date createDatetimeStart;

    // 查询条件2：创建终止时间
    private Date createDatetimeEnd;

    // ---------db properties start--------------------------
    // 流水号
    private Long ajNo;

    // 业务类型
    private String bizType;

    // 关联单号
    private String refNo;

    // 发生金额（有正负之分）
    private Long transAmount;

    // 发生前金额
    private Long preAmount;

    // 发生后金额
    private Long postAmount;

    // 备注
    private String remark;

    // 创建时间
    private Date createDatetime;

    // 账号
    private String accountNumber;

    // 状态
    private String status;

    // 理应对账时间
    private String workDate;

    // 对账人（li为程序）
    private String checkUser;

    // 对账时间
    private Date checkDatetime;

    // ---------db properties end--------------------------
    // 币种
    private String currency;

    // 手机号
    private String mobile;

    // 手机号
    private String mobileForLikeQuery;

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

    public Long getAjNo() {
        return ajNo;
    }

    public void setAjNo(Long ajNo) {
        this.ajNo = ajNo;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public Long getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Long transAmount) {
        this.transAmount = transAmount;
    }

    public Long getPreAmount() {
        return preAmount;
    }

    public void setPreAmount(Long preAmount) {
        this.preAmount = preAmount;
    }

    public Long getPostAmount() {
        return postAmount;
    }

    public void setPostAmount(Long postAmount) {
        this.postAmount = postAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getCheckDatetime() {
        return checkDatetime;
    }

    public void setCheckDatetime(Date checkDatetime) {
        this.checkDatetime = checkDatetime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileForLikeQuery() {
        return mobileForLikeQuery;
    }

    public void setMobileForLikeQuery(String mobileForLikeQuery) {
        this.mobileForLikeQuery = mobileForLikeQuery;
    }
}
