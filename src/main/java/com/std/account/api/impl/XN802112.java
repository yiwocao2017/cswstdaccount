package com.std.account.api.impl;

import com.std.account.ao.IChannelBankAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.domain.ChannelBank;
import com.std.account.dto.req.XN802112Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 修改渠道银行
 * @author: xieyj 
 * @since: 2016年11月11日 下午3:18:19 
 * @history:
 */
public class XN802112 extends AProcessor {
    private IChannelBankAO channelBankAO = SpringContextHolder
        .getBean(IChannelBankAO.class);

    private XN802112Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        ChannelBank data = new ChannelBank();
        data.setId(StringValidater.toLong(req.getId()));
        data.setBankCode(req.getBankCode());
        data.setBankName(req.getBankName());
        data.setChannelType(req.getChannelType());
        data.setStatus(req.getStatus());
        data.setChannelBank(req.getChannelBank());
        data.setMaxOrder(StringValidater.toLong(req.getMaxOrder()));
        data.setOrderAmount(StringValidater.toLong(req.getOrderAmount()));
        data.setDayAmount(StringValidater.toLong(req.getDayAmount()));
        data.setMonthAmount(StringValidater.toLong(req.getMonthAmount()));
        data.setRemark(req.getRemark());
        channelBankAO.editChannelBank(data);
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802112Req.class);
        StringValidater.validateBlank(req.getId(), req.getBankCode(),
            req.getBankName(), req.getChannelType(), req.getStatus(),
            req.getChannelBank());
        StringValidater.validateAmount(req.getMaxOrder(), req.getOrderAmount(),
            req.getDayAmount(), req.getMonthAmount());
    }
}
