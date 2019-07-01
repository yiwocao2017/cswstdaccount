package com.std.account.bo;

import java.util.List;

import com.std.account.bo.base.IPaginableBO;
import com.std.account.domain.Account;
import com.std.account.enums.EAccountStatus;
import com.std.account.enums.EAccountType;
import com.std.account.enums.EChannelType;

/**
 * @author: xieyj
 * @since: 2016年11月11日 上午11:23:06 
 * @history:
 */
public interface IAccountBO extends IPaginableBO<Account> {

    /**
     * 分配账户
     * @param userId
     * @param realName
     * @param accountType
     * @param currency
     * @param systemCode
     * @return 
     * @create: 2016年12月23日 下午12:35:22 xieyj
     * @history:
     */
    public String distributeAccount(String userId, String realName,
            EAccountType accountType, String currency, String systemCode);

    /**
     * 划转资金
     * @param systemCode
     * @param accountNumber
     * @param channelType
     * @param channelOrder
     * @param transAmount
     * @param bizType
     * @param bizNote 
     * @create: 2016年12月23日 下午5:58:06 xieyj
     * @history:
     */
    public void transAmount(String accountNumber, EChannelType channelType,
            String channelOrder, Long transAmount, String bizType,
            String bizNote);

    /**
     * 改变账户金额，无流水
     * @param systemCode
     * @param accountNumber
     * @param transAmount
     * @param lastOrder 
     * @create: 2016年12月25日 下午11:21:43 xieyj
     * @history:
     */
    public void transAmountNotJour(String systemCode, String accountNumber,
            Long transAmount, String lastOrder);

    /**
     * 更新户名
     * @param userId
     * @param realName 
     * @create: 2017年1月4日 上午11:34:18 xieyj
     * @history:
     */
    public void refreshAccountName(String userId, String realName);

    /**
     * 冻结账户金额
     * @param systemCode
     * @param accountNumber
     * @param freezeAmount
     * @param lastOrder 
     * @create: 2016年12月23日 下午5:25:55 xieyj
     * @history:
     */
    public void frozenAmount(String systemCode, String accountNumber,
            Long freezeAmount, String lastOrder);

    /**
     * 解冻账户(审核通过，扣除冻结金额；审核不通过，冻结金额原路返回)
     * @param systemCode
     * @param unfrozenResult 1 通过， 0 不通过
     * @param accountNumber
     * @param unfreezeAmount
     * @param lastOrder 
     * @create: 2016年12月25日 下午2:55:10 xieyj
     * @history:
     */
    public void unfrozenAmount(String systemCode, String unfrozenResult,
            String accountNumber, Long unfreezeAmount, String lastOrder);

    /**
     * 更新账户状态
     * @param systemCode
     * @param accountNumber
     * @param status 
     * @create: 2016年12月23日 下午5:27:04 xieyj
     * @history:
     */
    public void refreshStatus(String systemCode, String accountNumber,
            EAccountStatus status);

    /**
     * 获取账户
     * @param accountNumber
     * @return 
     * @create: 2016年12月23日 下午5:27:22 xieyj
     * @history:
     */
    public Account getAccount(String accountNumber);

    /**
     * 通过用户编号和币种获取币种
     * @param userId
     * @param currency
     * @return 
     * @create: 2016年12月28日 下午1:55:21 xieyj
     * @history:
     */
    public Account getAccountByUser(String userId, String currency);

    /**
     * 获取系统账户
     * @param sysUser
     * @param currency
     * @return 
     * @create: 2017年4月5日 下午9:19:34 xieyj
     * @history:
     */
    public Account getSysAccount(String sysUser, String currency);

    /**
     * 获取账户列表
     * @param data
     * @return 
     * @create: 2016年11月11日 上午10:52:08 xieyj
     * @history:
     */
    public List<Account> queryAccountList(Account data);

    public void transAmount(String accountNumber, String channelType,
            String channelOrder, Long transAmount, String bizType,
            String bizNote);
}
