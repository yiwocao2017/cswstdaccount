package com.std.account.api.impl;

import com.std.account.ao.IAccountAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN002100Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 内部转账(指定用户编号和币种进行转账，备注分开)
 * @author: xieyj 
 * @since: 2017年2月23日 下午5:03:24 
 * @history:
 */
public class XN002100 extends AProcessor {

    private IAccountAO accountAO = SpringContextHolder
        .getBean(IAccountAO.class);

    private XN002100Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long transAmount = StringValidater.toLong(req.getTransAmount());
        accountAO.transAmountCZB(req.getFromUserId(), req.getToUserId(),
            req.getCurrency(), transAmount, req.getBizType(),
            req.getFromBizNote(), req.getToBizNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN002100Req.class);
        StringValidater.validateBlank(req.getFromUserId(), req.getToUserId(),
            req.getCurrency(), req.getBizType(), req.getFromBizNote(),
            req.getToBizNote());
        StringValidater.validateAmount(req.getTransAmount());
    }
}
