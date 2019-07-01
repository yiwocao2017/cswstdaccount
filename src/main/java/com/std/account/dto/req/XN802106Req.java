package com.std.account.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年9月17日 下午4:09:23 
 * @history:
 */
public class XN802106Req extends ASearchReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号（选填）
    private String id;

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
    private String paycompany;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getPaycompany() {
        return paycompany;
    }

    public void setPaycompany(String paycompany) {
        this.paycompany = paycompany;
    }
}
