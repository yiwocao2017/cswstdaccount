package com.std.account.ao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.account.ao.IAccountAO;
import com.std.account.bo.IAccountBO;
import com.std.account.bo.ICompanyChannelBO;
import com.std.account.bo.IExchangeCurrencyBO;
import com.std.account.bo.IJourBO;
import com.std.account.bo.IUserBO;
import com.std.account.bo.base.Paginable;
import com.std.account.core.StringValidater;
import com.std.account.domain.Account;
import com.std.account.enums.EAccountType;
import com.std.account.enums.EChannelType;
import com.std.account.exception.BizException;
import com.std.account.util.AmountUtil;

@Service
public class AccountAOImpl implements IAccountAO {
    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IExchangeCurrencyBO exchangeCurrencyBO;

    @Autowired
    private ICompanyChannelBO companyChannelBO;

    @Autowired
    private IJourBO jourBO;

    @Autowired
    private IUserBO userBO;

    /** 
     * @see com.std.account.ao.IAccountAO#distributeAccount(java.lang.String, java.lang.String, com.std.account.enums.EAccountType, java.util.List, java.lang.String)
     */
    @Override
    @Transactional
    public void distributeAccount(String userId, String realName,
            String accountType, List<String> currencyList, String systemCode) {
        if (CollectionUtils.isNotEmpty(currencyList)) {
            Map<String, EAccountType> map = EAccountType
                .getAccountTypeResultMap();
            EAccountType eAccountType = map.get(accountType);
            if (null == eAccountType) {
                new BizException("XN0000", "账户类型不存在");
            }
            for (String currency : currencyList) {
                accountBO.distributeAccount(userId, realName, eAccountType,
                    currency, systemCode);
            }
        }
    }

    @Override
    public void editAccountName(String userId, String realName,
            String systemCode) {
        // 验证用户名和系统编号
        Account data = new Account();
        data.setUserId(userId);
        data.setRealName(realName);
        List<Account> accountList = accountBO.queryAccountList(data);
        if (CollectionUtils.isEmpty(accountList)) {
            new BizException("XN0000", "该用户无对应账号");
        }
        accountBO.refreshAccountName(userId, realName);
    }

    @Override
    @Transactional
    public void transAmountCZB(String fromAccountNumber,
            String toAccountNumber, Long transAmount, String bizType,
            String bizNote) {
        if (fromAccountNumber != null
                && fromAccountNumber.equals(toAccountNumber)) {
            new BizException("XN0000", "来去双方账号一致，无需内部划转");
        }
        Account fromAccount = accountBO.getAccount(fromAccountNumber);
        Account toAccount = accountBO.getAccount(toAccountNumber);
        Double rate = exchangeCurrencyBO.getExchangeRate(
            fromAccount.getCurrency(), toAccount.getCurrency());
        accountBO.transAmount(fromAccountNumber, EChannelType.NBZ, null,
            -transAmount, bizType, bizNote);
        accountBO.transAmount(toAccountNumber, EChannelType.NBZ, null,
            AmountUtil.mul(transAmount, rate), bizType, bizNote);
    }

    @Override
    @Transactional
    public void transAmountCZB(String fromUserId, String toUserId,
            String currency, Long transAmount, String bizType,
            String fromBizNote, String toBizNote) {
        Account fromAccount = accountBO.getAccountByUser(fromUserId, currency);
        Account toAccount = accountBO.getAccountByUser(toUserId, currency);
        accountBO.transAmount(fromAccount.getAccountNumber(), EChannelType.NBZ,
            null, -transAmount, bizType, fromBizNote);
        accountBO.transAmount(toAccount.getAccountNumber(), EChannelType.NBZ,
            null, transAmount, bizType, toBizNote);
    }

    @Override
    @Transactional
    public void transAmountPC(String systemCode, String companyCode,
            String accountName, String accountNumber, Long transAmount,
            String bankCode) {
        // // 智能路由
        // EChannelType channelType =
        // companyChannelBO.getBestChannel(companyCode,
        // EPayType.PC);
        // // 调用对应渠道，进行资金划转申请
        // Account dbAccount = accountBO.getAccount(systemCode, accountNumber);
        // EBizType bizType = EBizType.AJ_CZ;
        // if (transAmount < 0) {
        // bizType = EBizType.AJ_QX;
        // }
        // String order = jourBO.addTochangeJour(systemCode, accountName,
        // accountNumber, channelType, EPayType.PC, bizType,
        // dbAccount.getAmount(), transAmount);
        // companyChannelBO.transAmountPC(companyCode, channelType, EPayType.PC,
        // transAmount, order, bankCode);
    }

    // @Override
    // @Transactional
    // public void exchangeAmount(String systemCode, String fromAccountNumber,
    // String toAccountNumber, Long transAmount, Double rate,
    // String bizType, String bizNote) {
    // if (fromAccountNumber != null
    // && fromAccountNumber.equals(toAccountNumber)) {
    // new BizException("XN0000", "来去双方账号一致，无需内部划转");
    // }
    // accountBO.transAmount(systemCode, fromAccountNumber, EChannelType.NBZ,
    // null, -transAmount, bizType, bizNote);
    // // 币种间划转
    // Long toTransAmount = Double.valueOf(transAmount * rate).longValue();
    // accountBO.transAmount(systemCode, toAccountNumber, EChannelType.NBZ,
    // null, toTransAmount, bizType, bizNote);
    // }

    @Override
    @Transactional
    public void transAmountWAP(String systemCode, String accountName,
            String accountNumber, Long transAmount, String idType, String idNo,
            String name, String bankCard) {
        // 智能路由
        // 调用对应渠道，进行资金划转。

    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountBO.getAccount(accountNumber);
    }

    /** 
     * @see com.std.account.ao.IAccountAO#queryAccountPage(int, int, com.std.account.domain.Account)
     */
    @Override
    public Paginable<Account> queryAccountPage(int start, int limit,
            Account condition) {
        return accountBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.std.account.ao.IAccountAO#queryAccountList(com.std.account.domain.Account)
     */
    @Override
    public List<Account> queryAccountList(Account condition) {
        return accountBO.queryAccountList(condition);
    }

    /** 
     * @see com.std.account.ao.IAccountAO#getAccountByUserId(java.lang.String, java.lang.String)
     */
    @Override
    public List<Account> getAccountByUserId(String userId, String currency) {
        Account condition = new Account();
        condition.setUserId(userId);
        condition.setCurrency(currency);
        return accountBO.queryAccountList(condition);
    }

    @Override
    public void transAmount(String accountNumber, String channelType,
            String channelOrder, String transAmount, String bizType,
            String bizNote) {
        accountBO.transAmount(accountNumber, channelType, channelOrder,
            StringValidater.toLong(transAmount), bizType, bizNote);
    }
}
