package com.std.account.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.account.bo.IBankcardBO;
import com.std.account.bo.base.PaginableBOImpl;
import com.std.account.core.OrderNoGenerater;
import com.std.account.dao.IBankCardDAO;
import com.std.account.domain.Bankcard;
import com.std.account.enums.EBoolean;
import com.std.account.enums.EGeneratePrefix;
import com.std.account.exception.BizException;

/**
 * @author: asus 
 * @since: 2016年12月22日 下午4:32:05 
 * @history:
 */
@Component
public class BankcardBOImpl extends PaginableBOImpl<Bankcard> implements
        IBankcardBO {

    @Autowired
    private IBankCardDAO bankcardDAO;

    @Override
    public boolean isBankcardExist(String code) {
        Bankcard condition = new Bankcard();
        condition.setCode(code);
        if (bankcardDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveBankcard(Bankcard data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.BankCard.getCode());
            data.setCode(code);
            data.setStatus(EBoolean.YES.getCode());
            data.setCreateDatetime(new Date());
            bankcardDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeBankcard(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Bankcard data = new Bankcard();
            data.setCode(code);
            count = bankcardDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBankcard(Bankcard data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = bankcardDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Bankcard> queryBankcardList(Bankcard condition) {
        return bankcardDAO.selectList(condition);
    }

    @Override
    public Bankcard getBankcard(String code) {
        Bankcard data = null;
        if (StringUtils.isNotBlank(code)) {
            Bankcard condition = new Bankcard();
            condition.setCode(code);
            data = bankcardDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "银行卡不存在");
            }
        }
        return data;
    }

    /** 
     * @see com.std.account.bo.IBankcardBO#getBankcardByBankcardNumber(java.lang.String)
     */
    @Override
    public Bankcard getBankcardByBankcardNumber(String bankcardNumber) {
        Bankcard data = null;
        if (StringUtils.isNotBlank(bankcardNumber)) {
            Bankcard condition = new Bankcard();
            condition.setBankcardNumber(bankcardNumber);
            List<Bankcard> list = bankcardDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                data = list.get(0);
            }
        }
        return data;
    }
}
