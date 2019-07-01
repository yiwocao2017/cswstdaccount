package com.std.account.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.account.ao.IExchangeCurrencyAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.domain.ExchangeCurrency;
import com.std.account.dto.req.XN802415Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 分页查询虚拟币转化订单
 * @author: myb858 
 * @since: 2017年4月4日 下午1:16:22 
 * @history:
 */
public class XN802415 extends AProcessor {
    private IExchangeCurrencyAO exchangeCurrencyAO = SpringContextHolder
        .getBean(IExchangeCurrencyAO.class);

    private XN802415Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ExchangeCurrency condition = new ExchangeCurrency();

        condition.setToUserId(req.getToUserId());
        condition.setToCurrency(req.getToCurrency());
        condition.setFromUserId(req.getFromUserId());
        condition.setFromCurrency(req.getFromCurrency());

        condition.setStatus(req.getStatus());
        condition.setUpdater(req.getUpdater());
        condition.setPayType(req.getPayType());
        condition.setPayGroup(req.getPayGroup());
        condition.setPayCode(req.getPayCode());

        condition.setSystemCode(req.getSystemCode());
        condition.setCompanyCode(req.getCompanyCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IExchangeCurrencyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return exchangeCurrencyAO.queryExchangeCurrencyPage(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802415Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit(),
            req.getSystemCode(), req.getCompanyCode());

    }

}
