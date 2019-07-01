package com.std.account.dto.req;

/**
 * 新增渠道公司
 * @author: xieyj 
 * @since: 2016年9月17日 下午4:09:23 
 * @history:
 */
public class XN802100Req {
    // 公司编号(必填)
    private String companyCode;

    // 公司名称(必填)
    private String companyName;

    // 渠道类型(必填)
    private String channelType;

    // 状态(必填)（启用/不启用）
    private String status;

    // 渠道给公司的代号(必填)
    private String paycompany;

    // 秘钥(必填)
    private String privatekey;

    // 界面正确回调地址(必填)
    private String pageUrl;

    // 界面错误回调地址(选填)
    private String errorUrl;

    // 服务器回调地址(必填)
    private String backUrl;

    // 手续费(必填)
    private String fee;

    // 备注((选填)
    private String remark;

    //
    private String systemCode;

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

    public String getPaycompany() {
        return paycompany;
    }

    public void setPaycompany(String paycompany) {
        this.paycompany = paycompany;
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
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

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
