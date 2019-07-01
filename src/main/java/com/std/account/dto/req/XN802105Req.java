package com.std.account.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年9月17日 下午4:09:23 
 * @history:
 */
public class XN802105Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 公司编号(选填)
    private String companyCode;

    // 公司名称(选填)
    private String companyName;

    // 渠道类型(选填)
    private String channelType;

    // 支付类型(选填)
    private String payType;

    // 状态(选填)（启用/不启用）
    private String status;

    // 渠道给公司的代号(选填)
    private String channelCompany;

    // 系统编号
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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannelCompany() {
        return channelCompany;
    }

    public void setChannelCompany(String channelCompany) {
        this.channelCompany = channelCompany;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

}
