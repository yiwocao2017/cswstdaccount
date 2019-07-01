/**
 * @Title XN802450Req.java 
 * @Package com.std.account.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年12月23日 下午7:48:53 
 * @version V1.0   
 */
package com.std.account.dto.req;

import java.util.List;

/** 
 * @author: xieyj 
 * @since: 2016年12月23日 下午7:48:53 
 * @history:
 */
public class XN002000Req {
    // 用户编号(必填)
    private String userId;

    // 户名(选填）
    private String realName;

    // 类型(必填)
    private String type;

    // 币种列表(必填)
    private List<String> currencyList;

    // 系统编号(必填)
    private String systemCode;

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

    public List<String> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<String> currencyList) {
        this.currencyList = currencyList;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
