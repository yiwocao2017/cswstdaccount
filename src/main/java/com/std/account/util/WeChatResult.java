/**
 * @Title WeChatResult.java 
 * @Package com.std.account.util 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月23日 下午12:46:24 
 * @version V1.0   
 */
package com.std.account.util;

import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月23日 下午12:46:24 
 * @history:
 */
@XmlRootElement
public class WeChatResult {
    private String return_code;

    private String return_msg;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }
}
