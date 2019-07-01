package com.std.account.api.impl;

import com.std.account.ao.IExchangeCurrencyAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN002051Req;
import com.std.account.dto.res.XN002051Res;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 获取虚拟币价值。1人民币等于多少虚拟币
 * @author: myb858 
 * @since: 2017年4月3日 下午10:54:36 
 * @history:
 */
public class XN002051 extends AProcessor {

    private IExchangeCurrencyAO exchangeCurrencyAO = SpringContextHolder
        .getBean(IExchangeCurrencyAO.class);

    private XN002051Req req = null;

    /** 
    * @see com.xnjr.base.api.IProcessor#doBusiness()
    */
    @Override
    public Object doBusiness() throws BizException {
        Double rate = exchangeCurrencyAO.getExchangeRate(req.getFromCurrency(),
            req.getToCurrency());
        return new XN002051Res(rate);
    }

    /** 
    * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
    */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN002051Req.class);
        StringValidater.validateBlank(req.getFromCurrency(),
            req.getToCurrency());
    }

}
