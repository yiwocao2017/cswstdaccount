package com.std.account.util.cmb;
import java.util.Map;

/**
 * 
 */

/**
 * @author haiqingzheng
 *
 */
public class CMBBizRequest {

    // 业务接口名称
    private String bizName;

    // 业务接口字段名称，字段值
    private Map<String, String> bizParams;

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public Map<String, String> getBizParams() {
        return bizParams;
    }

    public void setBizParams(Map<String, String> bizParams) {
        this.bizParams = bizParams;
    }

}
