/**
 * @Title AccountUtil.java 
 * @Package com.ibis.account.core 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午4:54:24 
 * @version V1.0   
 */
package com.std.account.core;

import com.std.account.common.MD5Util;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午4:54:24 
 * @history:
 */
public class AccountUtil {

    private static String key = "123321";

    public static String md5(Long amount) {
        StringBuffer bf = new StringBuffer(key);
        bf.append(amount);
        return MD5Util.md5(bf.toString());
    }

    public static String md5(String preMd5, Long preAmount, Long nowAmount) {
        // if (preMd5 != null && !preMd5.equals(md5(preAmount))) {
        // throw new BizException("xn000000", "账户金额已被篡改，请联系管理员");
        // }
        StringBuffer bf = new StringBuffer(key);
        bf.append(nowAmount);
        return MD5Util.md5(bf.toString());
    }
}
