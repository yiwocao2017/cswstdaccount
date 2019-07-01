package com.std.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.account.dao.IChannelBankDAO;
import com.std.account.dao.base.support.AMybatisTemplate;
import com.std.account.domain.ChannelBank;

/**
 * @author: xieyj 
 * @since: 2016年11月10日 下午8:28:34 
 * @history:
 */
@Repository("channelBankDAOImpl")
public class ChannelBankDAOImpl extends AMybatisTemplate implements
        IChannelBankDAO {

    @Override
    public int insert(ChannelBank data) {
        return super.insert(NAMESPACE.concat("insert_channelBank"), data);
    }

    @Override
    public int delete(ChannelBank data) {
        return super.delete(NAMESPACE.concat("delete_channelBank"), data);
    }

    @Override
    public ChannelBank select(ChannelBank condition) {
        return super.select(NAMESPACE.concat("select_channelBank"), condition,
            ChannelBank.class);
    }

    @Override
    public long selectTotalCount(ChannelBank condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_channelBank_count"), condition);
    }

    @Override
    public List<ChannelBank> selectList(ChannelBank condition) {
        return super.selectList(NAMESPACE.concat("select_channelBank"),
            condition, ChannelBank.class);
    }

    @Override
    public List<ChannelBank> selectList(ChannelBank condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_channelBank"), start,
            count, condition, ChannelBank.class);
    }

    /** 
     * @see com.std.account.dao.IChannelBankDAO#update(com.std.account.domain.ChannelBank)
     */
    @Override
    public int update(ChannelBank data) {
        return super.update(NAMESPACE.concat("update_channelBank"), data);
    }

}
