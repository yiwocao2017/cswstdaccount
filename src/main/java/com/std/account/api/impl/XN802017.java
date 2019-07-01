package com.std.account.api.impl;

import com.std.account.ao.IBankcardAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802017Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 详情查询银行卡
 * @author: asus 
 * @since: 2016年12月22日 下午8:10:28 
 * @history:
 */
public class XN802017 extends AProcessor {
    private IBankcardAO bankCardAO = SpringContextHolder
        .getBean(IBankcardAO.class);

    private XN802017Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bankCardAO.getBankcard(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802017Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
