package com.std.account.api.impl;

import com.std.account.ao.IAccountAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802602Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 外部账PC端网关支付申请（沿最优支付渠道）；
 * @author: myb858 
 * @since: 2016年11月16日 下午1:41:55 
 * @history:
 */
public class XN802602 extends AProcessor {
    private IAccountAO accountAO = SpringContextHolder
        .getBean(IAccountAO.class);

    private XN802602Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        accountAO.transAmountPC(req.getSystemCode(), req.getCompanyCode(),
            req.getAccountName(), req.getAccountNumber(),
            StringValidater.toLong(req.getTransAmount()), req.getBankCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802602Req.class);
        StringValidater.validateBlank(req.getSystemCode(),
            req.getCompanyCode(), req.getAccountName(), req.getAccountNumber(),
            req.getTransAmount(), req.getBankCode());
        StringValidater.validateAmount(req.getTransAmount());
    }

}
