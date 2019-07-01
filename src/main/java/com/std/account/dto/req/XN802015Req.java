package com.std.account.dto.req;

/**
 * 分页查询银行卡
 * @author: asus 
 * @since: 2016年12月22日 下午7:28:32 
 * @history:
 */
public class XN802015Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 系统编号
    public String systemCode;

    // 银行卡号
    public String bankcardNumber;

    // 银行名称
    public String bankName;

    // 用户编号
    public String userId;

    // 用户姓名
    public String realName;

    // 类型
    public String type;

    // 状态(0 不可用 1可用)
    public String status;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
