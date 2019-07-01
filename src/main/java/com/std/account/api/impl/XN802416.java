package com.std.account.api.impl;

import com.std.account.ao.IExchangeCurrencyAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802416Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 详情查询虚拟币转化订单
 * @author: myb858 
 * @since: 2017年4月4日 下午1:16:51 
 * @history:
 */
public class XN802416 extends AProcessor {

    private IExchangeCurrencyAO exchangeCurrencyAO = SpringContextHolder
        .getBean(IExchangeCurrencyAO.class);

    private XN802416Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return exchangeCurrencyAO.getExchangeCurrency(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802416Req.class);
        StringValidater.validateBlank(req.getCode());

    }

}
