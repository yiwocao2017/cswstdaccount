package com.std.account.api.impl;

import com.std.account.ao.IBankcardAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.domain.Bankcard;
import com.std.account.dto.req.XN802016Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 列表查询银行卡
 * @author: asus 
 * @since: 2016年12月22日 下午7:36:42 
 * @history:
 */
public class XN802016 extends AProcessor {
    private IBankcardAO bankCardAO = SpringContextHolder
        .getBean(IBankcardAO.class);

    private XN802016Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Bankcard condition = new Bankcard();
        condition.setSystemCode(req.getSystemCode());
        condition.setUserId(req.getUserId());
        condition.setBankName(req.getBankName());
        condition.setBankcardNumber(req.getBankcardNumber());
        condition.setType(req.getType());
        condition.setStatus(req.getStatus());
        return bankCardAO.queryBankcardList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802016Req.class);
        StringValidater.validateBlank(req.getSystemCode());
    }

}
