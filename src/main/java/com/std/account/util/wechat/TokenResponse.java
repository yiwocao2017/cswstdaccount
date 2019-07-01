/**
 * @Title TokenResponse.java 
 * @Package com.std.sms.sent.wechat 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年11月26日 下午2:28:19 
 * @version V1.0   
 */
package com.std.account.util.wechat;

/** 
 * @author: haiqingzheng 
 * @since: 2016年11月26日 下午2:28:19 
 * @history:
 */
public class TokenResponse {

    private String access_token;

    private String expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

}
