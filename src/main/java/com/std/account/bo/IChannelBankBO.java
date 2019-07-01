package com.std.account.bo;

import java.util.List;

import com.std.account.bo.base.IPaginableBO;
import com.std.account.domain.ChannelBank;

/**
 * @author: xieyj 
 * @since: 2016年11月10日 下午8:30:39 
 * @history:
 */
public interface IChannelBankBO extends IPaginableBO<ChannelBank> {

    public boolean isChannelBankExist(Long id);

    public int saveChannelBank(ChannelBank data);

    public int removeChannelBank(Long id);

    public int refreshChannelBank(ChannelBank data);

    public List<ChannelBank> queryChannelBankList(ChannelBank condition);

    public ChannelBank getChannelBank(Long id);

}
