package com.std.account.api.impl;

import com.std.account.ao.IBankcardAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802011Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 删除银行卡
 * @author: asus 
 * @since: 2016年12月22日 下午5:54:08 
 * @history:
 */
public class XN802011 extends AProcessor {
    private IBankcardAO bankCardAO = SpringContextHolder
        .getBean(IBankcardAO.class);

    private XN802011Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bankCardAO.dropBankcard(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802011Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
