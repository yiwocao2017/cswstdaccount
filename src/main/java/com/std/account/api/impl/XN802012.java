package com.std.account.api.impl;

import com.std.account.ao.IBankcardAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.domain.Bankcard;
import com.std.account.dto.req.XN802012Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 修改银行卡
 * @author: xieyj 
 * @since: 2017年1月18日 上午11:08:40 
 * @history:
 */
public class XN802012 extends AProcessor {
    private IBankcardAO bankCardAO = SpringContextHolder
        .getBean(IBankcardAO.class);

    private XN802012Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Bankcard data = new Bankcard();
        data.setCode(req.getCode());
        data.setBankcardNumber(req.getBankcardNumber());
        data.setBankCode(req.getBankCode());
        data.setBankName(req.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setBindMobile(req.getBindMobile());
        data.setStatus(req.getStatus());
        data.setRemark(req.getRemark());
        return bankCardAO.editBankcard(data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802012Req.class);
        StringValidater.validateBlank(req.getCode(), req.getBankcardNumber(),
            req.getBankCode(), req.getBankName());
    }
}
