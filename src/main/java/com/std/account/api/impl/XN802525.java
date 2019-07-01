package com.std.account.api.impl;

import com.std.account.ao.IAccountAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802525Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 内部转账，不同币种之间以一定比例划转
 * @author: xieyj 
 * @since: 2016年12月25日 下午3:14:31 
 * @history:
 */
public class XN802525 extends AProcessor {

    private IAccountAO accountAO = SpringContextHolder
        .getBean(IAccountAO.class);

    private XN802525Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long transAmount = StringValidater.toLong(req.getTransAmount());
        accountAO.transAmountCZB(req.getFromAccountNumber(),
            req.getToAccountNumber(), transAmount, req.getBizType(),
            req.getBizNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802525Req.class);
        StringValidater.validateBlank(req.getFromAccountNumber(),
            req.getToAccountNumber(), req.getBizType(), req.getBizNote());
        StringValidater.validateAmount(req.getTransAmount());
    }
}
