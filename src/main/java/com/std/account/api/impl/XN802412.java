package com.std.account.api.impl;

import com.std.account.ao.IExchangeCurrencyAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802412Req;
import com.std.account.dto.res.PKCodeRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 申请虚拟币转化，不需要审核，目前支持转化的有：菜狗币转积分（菜狗），人民币余额转菜狗币（菜狗）
 * @author: myb858 
 * @since: 2017年4月5日 下午6:18:17 
 * @history:
 */
public class XN802412 extends AProcessor {
    private IExchangeCurrencyAO exchangeCurrencyAO = SpringContextHolder
        .getBean(IExchangeCurrencyAO.class);

    private XN802412Req req = null;

    /** 
    * @see com.xnjr.base.api.IProcessor#doBusiness()
    */
    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(exchangeCurrencyAO.doExchange(req.getUserId(),
            StringValidater.toLong(req.getFromAmount()), req.getFromCurrency(),
            req.getToCurrency()));
    }

    /** 
    * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
    */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802412Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getFromAmount(),
            req.getFromCurrency(), req.getToCurrency());
    }

}
