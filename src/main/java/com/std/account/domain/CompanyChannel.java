package com.std.account.domain;

import com.std.account.dao.base.ABaseDO;

public class CompanyChannel extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 序号
    private Long id;

    // 公司编号
    private String companyCode;

    // 公司名称
    private String companyName;

    // 渠道类型
    private String channelType;

    // 状态（启用/不启用）
    private String status;

    // 渠道给公司的代号
    private String channelCompany;

    // 秘钥1
    private String privateKey1;

    // 秘钥2
    private String privateKey2;

    // 秘钥3
    private String privateKey3;

    // 秘钥4
    private String privateKey4;

    // 秘钥5
    private String privateKey5;

    // 界面正确回调地址
    private String pageUrl;

    // 界面错误回调地址
    private String errorUrl;

    // 服务器回调地址
    private String backUrl;

    // 手续费
    private Long fee;

    // 备注
    private String remark;

    // 系统编号
    public String systemCode;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getPrivateKey1() {
        return privateKey1;
    }

    public void setPrivateKey1(String privateKey1) {
        this.privateKey1 = privateKey1;
    }

    public String getPrivateKey2() {
        return privateKey2;
    }

    public void setPrivateKey2(String privateKey2) {
        this.privateKey2 = privateKey2;
    }

    public String getPrivateKey3() {
        return privateKey3;
    }

    public void setPrivateKey3(String privateKey3) {
        this.privateKey3 = privateKey3;
    }

    public String getPrivateKey4() {
        return privateKey4;
    }

    public void setPrivateKey4(String privateKey4) {
        this.privateKey4 = privateKey4;
    }

    public String getPrivateKey5() {
        return privateKey5;
    }

    public void setPrivateKey5(String privateKey5) {
        this.privateKey5 = privateKey5;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getChannelCompany() {
        return channelCompany;
    }

    public void setChannelCompany(String channelCompany) {
        this.channelCompany = channelCompany;
    }
}
