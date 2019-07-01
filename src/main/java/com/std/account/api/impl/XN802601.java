package com.std.account.api.impl;

import com.std.account.ao.IAccountAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802601Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 内部账划转：本系统账户间资金划转。
 * @author: myb858 
 * @since: 2016年11月16日 下午1:42:30 
 * @history:
 */
public class XN802601 extends AProcessor {

    private IAccountAO accountAO = SpringContextHolder
        .getBean(IAccountAO.class);

    private XN802601Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        // accountAO.transAmountCZB(req.getSystemCode(),
        // req.getFromAccountName(),
        // req.getFromAccountNumber(), req.getToAccountName(),
        // req.getToAccountNumber(),
        // StringValidater.toLong(req.getTransAmount()), req.getBizType(),
        // req.getBizNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802601Req.class);
        StringValidater.validateBlank(req.getSystemCode(),
            req.getFromAccountName(), req.getFromAccountNumber(),
            req.getToAccountName(), req.getToAccountNumber(),
            req.getTransAmount(), req.getBizType(), req.getBizNote());
        StringValidater.validateAmount(req.getTransAmount());
    }
}
