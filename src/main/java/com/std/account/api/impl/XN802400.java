package com.std.account.api.impl;

import com.std.account.ao.IExchangeCurrencyAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802400Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 商户针对C端手机划转资金
 * @author: myb858 
 * @since: 2017年4月3日 下午2:39:04 
 * @history:
 */
public class XN802400 extends AProcessor {
    private IExchangeCurrencyAO exchangeCurrencyAO = SpringContextHolder
        .getBean(IExchangeCurrencyAO.class);

    private XN802400Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long amount = StringValidater.toLong(req.getAmount());
        exchangeCurrencyAO.doTransferB2C(req.getStoreOwner(), req.getMobile(),
            amount, req.getCurrency());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802400Req.class);
        StringValidater.validateBlank(req.getStoreOwner(), req.getMobile(),
            req.getAmount(), req.getCurrency());

    }

}
