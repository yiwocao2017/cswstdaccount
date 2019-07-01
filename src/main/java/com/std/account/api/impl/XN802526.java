package com.std.account.api.impl;

import com.std.account.ao.IJourAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802526Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 前端提现申请
 * @author: xieyj 
 * @since: 2017年5月2日 下午1:38:59 
 * @history:
 */
public class XN802526 extends AProcessor {

    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN802526Req req = null;

    @Override
    public synchronized Object doBusiness() throws BizException {
        Long transAmount = StringValidater.toLong(req.getTransAmount());
        jourAO.doOfflineWith(req.getAccountNumber(), req.getBankcardNumber(),
            transAmount, req.getSystemCode(), req.getTradePwd());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802526Req.class);
        StringValidater.validateBlank(req.getSystemCode(),
            req.getBankcardNumber(), req.getAccountNumber());
        StringValidater.validateAmount(req.getTransAmount());
    }
}
