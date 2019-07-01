/**
 * @Title UserUtil.java 
 * @Package com.cdkj.zhpay.common 
 * @Description 
 * @author xieyj  
 * @date 2017年2月25日 下午2:12:43 
 * @version V1.0   
 */
package com.std.account.common;

import org.apache.commons.lang3.StringUtils;

/** 
 * @author: xieyj 
 * @since: 2017年2月25日 下午2:12:43 
 * @history:
 */
public class UserUtil {

    public static String getUserMobile(String mobile) {
        String result = "";
        if (StringUtils.isNotBlank(mobile)) {
            result = "用户[" + mobile + "]";
        }
        return result;
    }
}
