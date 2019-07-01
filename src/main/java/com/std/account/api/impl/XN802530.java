package com.std.account.api.impl;

import com.std.account.ao.IJourAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802530Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 线上充值(微信，支付宝)
 * @author: xieyj 
 * @since: 2017年4月21日 下午4:34:28 
 * @history:
 */
public class XN802530 extends AProcessor {

    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN802530Req req = null;

    @Override
    public synchronized Object doBusiness() throws BizException {
        Long amount = StringValidater.toLong(req.getAmount());
        return jourAO.doRechargeOnline(req.getUserId(), req.getPayType(),
            amount);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802530Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getPayType());
        StringValidater.validateAmount(req.getAmount());
    }
}
