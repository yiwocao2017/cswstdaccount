package com.std.account.dto.req;

/** 
 * @author: xieyj 
 * @since: 2016年12月23日 下午7:48:53 
 * @history:
 */
public class XN802501Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 288709607414715351L;

    // 户名
    private String realName;

    // 类别（B端账号，C端账号，平台账号）
    private String type;

    // 状态（正常/程序冻结/人工冻结）
    private String status;

    // 币种
    private String currency;

    // 最近一次变动对应的流水编号
    private String lastOrder;

    // 系统编号(必填)
    private String systemCode;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLastOrder() {
        return lastOrder;
    }

    public void setLastOrder(String lastOrder) {
        this.lastOrder = lastOrder;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
