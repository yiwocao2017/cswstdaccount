/**
 * @Title AJourBOImpl.java 
 * @Package com.ibis.account.bo.impl 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:22:07 
 * @version V1.0   
 */
package com.std.account.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.account.bo.IAccountBO;
import com.std.account.bo.IJourBO;
import com.std.account.bo.base.PaginableBOImpl;
import com.std.account.common.DateUtil;
import com.std.account.core.OrderNoGenerater;
import com.std.account.dao.IJourDAO;
import com.std.account.domain.Account;
import com.std.account.domain.Jour;
import com.std.account.enums.EBizType;
import com.std.account.enums.EBoolean;
import com.std.account.enums.EChannelType;
import com.std.account.enums.EGeneratePrefix;
import com.std.account.enums.EJourStatus;
import com.std.account.exception.BizException;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:22:07 
 * @history:
 */
@Component
public class JourBOImpl extends PaginableBOImpl<Jour> implements IJourBO {
    @Autowired
    private IJourDAO jourDAO;

    @Autowired
    private IAccountBO accountBO;

    @Override
    public Jour getJour(String code, String systemCode) {
        Jour data = null;
        if (StringUtils.isNotBlank(code)) {
            Jour condition = new Jour();
            condition.setCode(code);
            condition.setSystemCode(systemCode);
            data = jourDAO.select(condition);
            if (data == null) {
                throw new BizException("xn000000", "单号不存在");
            }
        }
        return data;
    }

    @Override
    public Jour getRelativeJour(String code, String payGroup) {
        Jour data = null;
        if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(payGroup)) {
            Jour condition = new Jour();
            condition.setPayGroup(payGroup);
            List<Jour> results = jourDAO.selectList(condition);
            for (Jour jour : results) {
                if (!code.equals(jour.getCode())) {
                    data = jour;
                }
            }
            if (data == null) {
                throw new BizException("xn000000", "相对单号不存在");
            }
        }
        return data;
    }

    @Override
    public String addToChangeJour(String systemCode, String accountNumber,
            String channelType, String bizType, String bizNote,
            Long transAmount, String payGroup) {
        Account account = accountBO.getAccount(accountNumber);
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.AJour.getCode());
        Jour data = new Jour();
        data.setCode(code);
        data.setPayGroup(payGroup);
        data.setUserId(account.getUserId());
        data.setRealName(account.getRealName());
        data.setAccountNumber(accountNumber);
        data.setChannelType(channelType);
        data.setBizType(bizType);
        data.setBizNote(bizNote);
        data.setTransAmount(transAmount);
        data.setCreateDatetime(new Date());
        data.setStatus(EJourStatus.todoCallBack.getCode());
        data.setWorkDate(DateUtil.dateToStr(new Date(),
            DateUtil.DB_DATE_FORMAT_STRING));
        data.setSystemCode(systemCode);
        jourDAO.insert(data);
        return code;
    }

    @Override
    public String addWithChangeJour(String systemCode, String accountNumber,
            String channelType, String bizType, String bizNote,
            Long transAmount, Long fee, String payGroup) {
        Account account = accountBO.getAccount(accountNumber);
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.AJour.getCode());
        Jour data = new Jour();
        data.setCode(code);
        data.setPayGroup(payGroup);
        data.setUserId(account.getUserId());
        data.setRealName(account.getRealName());
        data.setAccountNumber(accountNumber);
        data.setChannelType(channelType);
        data.setBizType(bizType);
        data.setBizNote(bizNote);
        data.setTransAmount(transAmount);
        data.setCreateDatetime(new Date());
        data.setStatus(EJourStatus.todoCallBack.getCode());
        data.setWorkDate(DateUtil.dateToStr(new Date(),
            DateUtil.DB_DATE_FORMAT_STRING));
        data.setFee(fee);
        data.setSystemCode(systemCode);
        jourDAO.insert(data);
        return code;
    }

    /**
     * @see com.std.account.bo.IJourBO#callBackChangeJour(com.std.account.domain.Jour, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int callBackFromChangeJour(Jour data, String rollbackUser,
            String rollbackNote, String channelOrder) {
        EJourStatus eJourStatus = EJourStatus.todoCheck;
        data.setStatus(eJourStatus.getCode());
        Account account = accountBO.getAccount(data.getAccountNumber());
        Long preAmount = account.getAmount();
        Long postAmount = preAmount;

        data.setPreAmount(preAmount);
        data.setPostAmount(postAmount);
        data.setRollbackUser(rollbackUser);
        data.setRollbackDatetime(new Date());
        data.setRemark(rollbackNote);

        data.setChannelOrder(channelOrder);
        return jourDAO.updateCallback(data);
    }

    /**
     * @see com.std.account.bo.IJourBO#callBackChangeJour(com.std.account.domain.Jour, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int callBackChangeJour(Jour data, String rollBackResult,
            String rollbackUser, String rollbackNote, String channelOrder) {
        Account account = accountBO.getAccount(data.getAccountNumber());
        Long preAmount = account.getAmount();
        Long postAmount = preAmount;
        EJourStatus eJourStatus = EJourStatus.todoCheck;
        if (EBoolean.NO.getCode().equals(rollBackResult)) {
            eJourStatus = EJourStatus.callBack_NO;
        } else {
            postAmount = preAmount + data.getTransAmount();
        }

        data.setStatus(eJourStatus.getCode());
        data.setPreAmount(preAmount);
        data.setPostAmount(postAmount);
        data.setRollbackUser(rollbackUser);
        data.setRollbackDatetime(new Date());

        data.setRemark(rollbackNote);
        data.setChannelOrder(channelOrder);
        return jourDAO.updateCallback(data);
    }

    /**
     * @see com.std.account.bo.IJourBO#callBackOffChangeJour(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long)
     */
    @Override
    public int callBackOffChangeJour(Jour data, String rollbackResult,
            String rollbackUser, String rollbackNote, Long preAmount,
            Long postAmount) {
        EJourStatus eJourStatus = EJourStatus.todoCheck;
        if (EBoolean.NO.getCode().equals(rollbackResult)) {
            eJourStatus = EJourStatus.callBack_NO;
        }
        data.setStatus(eJourStatus.getCode());
        data.setPreAmount(preAmount);
        data.setPostAmount(postAmount);
        data.setRollbackUser(rollbackUser);
        data.setRollbackDatetime(new Date());
        data.setRemark(rollbackNote);
        return jourDAO.updateCallback(data);
    }

    /** 
     * @see com.std.account.bo.IJourBO#addChangedJour(java.lang.String, java.lang.String, com.std.account.enums.EChannelType, java.lang.String, com.std.account.enums.EPayType, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long)
     */
    @Override
    public String addChangedJour(String systemCode, String accountNumber,
            EChannelType channelType, String channelOrder, String bizType,
            String bizNote, Long preAmount, Long transAmount) {
        Account account = accountBO.getAccount(accountNumber);
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.AJour.getCode());
        Long postAmount = preAmount + transAmount;
        Jour data = new Jour();
        data.setCode(code);
        data.setSystemCode(systemCode);
        data.setUserId(account.getUserId());
        data.setRealName(account.getRealName());
        data.setAccountNumber(accountNumber);
        data.setChannelType(channelType.getCode());
        data.setChannelOrder(channelOrder);
        data.setBizType(bizType);
        data.setBizNote(bizNote);
        data.setTransAmount(transAmount);

        data.setPreAmount(preAmount);
        data.setPostAmount(postAmount);
        data.setCreateDatetime(new Date());
        data.setStatus(EJourStatus.todoCheck.getCode());
        data.setWorkDate(DateUtil.dateToStr(new Date(),
            DateUtil.DB_DATE_FORMAT_STRING));
        jourDAO.insert(data);
        return code;
    }

    @Override
    public void doCheckJour(String code, EBoolean checkResult,
            String checkUser, String checkNote) {
        Jour data = new Jour();
        data.setCode(code);
        EJourStatus eJourStatus = EJourStatus.Checked_YES;
        if (EBoolean.NO.equals(checkResult)) {
            eJourStatus = EJourStatus.Checked_NO;
        }
        data.setStatus(eJourStatus.getCode());
        data.setCheckUser(checkUser);
        data.setCheckDatetime(new Date());
        data.setRemark(checkNote);
        jourDAO.updateCheck(data);
    }

    /**
     * @see com.std.account.bo.IJourBO#addAdjustJour(com.std.account.domain.Account, java.lang.String, java.lang.Long)
     */
    @Override
    public String addAdjustJour(Account account, String channelOrder,
            Long transAmount) {
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.AJour.getCode());
        Jour data = new Jour();
        data.setCode(code);
        data.setSystemCode(account.getSystemCode());
        data.setUserId(account.getUserId());
        data.setRealName(account.getRealName());
        data.setAccountNumber(account.getAccountNumber());
        Jour jour = this.getJour(channelOrder, account.getSystemCode());
        data.setChannelType(EChannelType.Adjust_ZH.getCode());
        if (EChannelType.NBZ.getCode().equals(jour.getChannelType())) {
            data.setChannelType(EChannelType.ROLL_ZH.getCode());
        }
        data.setChannelOrder(channelOrder);
        // 产生红冲蓝补订单
        EBizType eBizType = EBizType.AJ_HC;
        if (transAmount > 0) {
            eBizType = EBizType.AJ_LB;
        }
        String bizNote = eBizType.getValue() + ",调账单号[" + channelOrder + "]";
        data.setBizType(eBizType.getCode());
        data.setBizNote(bizNote);
        data.setTransAmount(transAmount);
        data.setCreateDatetime(new Date());
        data.setStatus(EJourStatus.todoAdjust.getCode());
        data.setWorkDate(null);
        jourDAO.insert(data);
        return code;
    }

    /** 
     * @see com.std.account.bo.IJourBO#doAdjustAccount(java.lang.String, com.std.account.enums.EBoolean, java.lang.String)
     */
    @Override
    public void doAdjustJour(String code, EBoolean adjustResult,
            String adjustUser, Date adjustDate, String adjustNote,
            Long preAmount, Long postAmount) {
        Jour data = new Jour();
        data.setCode(code);
        EJourStatus eJourStatus = EJourStatus.adjusted_YES;
        if (EBoolean.NO.equals(adjustResult)) {
            eJourStatus = EJourStatus.adjusted_NO;
        }
        data.setStatus(eJourStatus.getCode());
        data.setAdjustUser(adjustUser);
        data.setAdjustDatetime(adjustDate);
        data.setRemark(adjustNote);
        data.setPreAmount(preAmount);
        data.setPostAmount(postAmount);
        jourDAO.updateAdjust(data);
    }

    /** 
     * @see com.std.account.bo.IJourBO#refreshOrderStatus(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void refreshOrderStatus(String code, String adjustUser,
            Date adjustDate, String adjustNote) {
        Jour data = new Jour();
        data.setCode(code);
        data.setStatus(EJourStatus.Adjusted.getCode());
        data.setAdjustUser(adjustUser);
        data.setAdjustDatetime(adjustDate);
        data.setRemark(adjustNote);
        jourDAO.updateAdjustStatus(data);
    }

    /** 
     * @see com.std.account.bo.IJourBO#queryJourList(com.std.account.domain.Jour)
     */
    @Override
    public List<Jour> queryJourList(Jour condition) {
        return jourDAO.selectList(condition);
    }

    /**
     * @see com.std.account.bo.IJourBO#getStatisticsTransAmount(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Long getStatisticsTransAmount(String systemCode, String userId,
            String currency, String bizType) {
        Long totalAmount = 0L;
        Jour condition = new Jour();
        condition.setSystemCode(systemCode);
        condition.setUserId(userId);
        condition.setCurrency(currency);
        condition.setBizType(bizType);
        List<Jour> jourList = jourDAO.selectList(condition);
        for (Jour jour : jourList) {
            totalAmount += jour.getTransAmount();
        }
        return totalAmount;
    }

    /** 
     * @see com.std.account.bo.IJourBO#doCheckExistJour(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void doCheckExistApplyJour(String accountNumber, String bizType) {
        Jour condition = new Jour();
        condition.setAccountNumber(accountNumber);
        condition.setBizType(bizType);
        condition.setStatus(EJourStatus.todoCallBack.getCode());
        List<Jour> list = jourDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            throw new BizException("xn000000", "已有申请记录，请审批后再申请");
        }
    }
}
