/**
 * @Title ICMBBO.java 
 * @Package com.std.account.bo 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年3月1日 下午4:27:27 
 * @version V1.0   
 */
package com.std.account.bo;

import com.std.account.domain.ChannelBank;
import com.std.account.domain.CompanyChannel;

/** 
 * 招商银行——银企直联
 * @author: haiqingzheng 
 * @since: 2017年3月1日 下午4:27:27 
 * @history:
 */
public interface ICMBBO {
    /**
     * @param accountNo 收款方账号
     * @param accountName 收款方户名
     * @param bank 银行信息
     * @param amount 金额
     * @create: 2017年3月1日 下午4:33:11 haiqingzheng
     * @history:
     */
    public String pay(String accountNo, String accountName, ChannelBank bank,
            Long amount, String remark, CompanyChannel companyChannel);
}
