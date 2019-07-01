package com.std.account.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年9月17日 下午4:09:23 
 * @history:
 */
public class XN802115Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 序号
    private Long id;

    // 银行编号
    private String bankCode;

    // 银行名称
    private String bankName;

    // 渠道类型
    private String channelType;

    // 状态(1 启用 0 不启用)
    private String status;

    // 渠道给银行的代号
    private String channelBank;

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

    public String getChannelBank() {
        return channelBank;
    }

    public void setChannelBank(String channelBank) {
        this.channelBank = channelBank;
    }

}
