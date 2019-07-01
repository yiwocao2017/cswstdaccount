package com.std.account.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年9月17日 下午4:09:17 
 * @history:
 */
public class XN802006Req extends ASearchReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 类型（第一层/第二层）（选填）
    private String type;

    // 父key（选填）
    private String parentKey;

    // key（选填）
    private String dkey;

    // 系统编号（必填）
    private String systemCode;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public String getDkey() {
        return dkey;
    }

    public void setDkey(String dkey) {
        this.dkey = dkey;
    }

}
