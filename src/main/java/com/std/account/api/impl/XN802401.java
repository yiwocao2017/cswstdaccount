package com.std.account.api.impl;

import com.std.account.ao.IExchangeCurrencyAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802401Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 加盟商对商户划转资金
 * @author: myb858 
 * @since: 2017年4月3日 下午2:41:00 
 * @history:
 */
public class XN802401 extends AProcessor {
    private IExchangeCurrencyAO exchangeCurrencyAO = SpringContextHolder
        .getBean(IExchangeCurrencyAO.class);

    private XN802401Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Long amount = StringValidater.toLong(req.getAmount());
        exchangeCurrencyAO.doTransferF2B(req.getFromUserId(),
            req.getToUserId(), amount, req.getCurrency());
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802401Req.class);
        StringValidater.validateBlank(req.getFromUserId(), req.getToUserId(),
            req.getAmount(), req.getCurrency());
    }

}
