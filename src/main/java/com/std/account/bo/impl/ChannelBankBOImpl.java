package com.std.account.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.account.bo.IChannelBankBO;
import com.std.account.bo.base.PaginableBOImpl;
import com.std.account.dao.IChannelBankDAO;
import com.std.account.domain.ChannelBank;
import com.std.account.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年11月10日 下午8:31:09 
 * @history:
 */
@Component
public class ChannelBankBOImpl extends PaginableBOImpl<ChannelBank> implements
        IChannelBankBO {

    @Autowired
    private IChannelBankDAO channelBankDAO;

    @Override
    public boolean isChannelBankExist(Long id) {
        ChannelBank condition = new ChannelBank();
        condition.setId(id);
        if (channelBankDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int saveChannelBank(ChannelBank data) {
        int count = 0;
        if (data != null) {
            count = channelBankDAO.insert(data);
        }
        return count;
    }

    @Override
    public int removeChannelBank(Long id) {
        int count = 0;
        if (id != null) {
            ChannelBank data = new ChannelBank();
            data.setId(id);
            count = channelBankDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshChannelBank(ChannelBank data) {
        int count = 0;
        if (data != null) {
            count = channelBankDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ChannelBank> queryChannelBankList(ChannelBank condition) {
        return channelBankDAO.selectList(condition);
    }

    @Override
    public ChannelBank getChannelBank(Long id) {
        ChannelBank data = null;
        if (id != null) {
            ChannelBank condition = new ChannelBank();
            condition.setId(id);
            data = channelBankDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "渠道银行不存在");
            }
        }
        return data;
    }
}
