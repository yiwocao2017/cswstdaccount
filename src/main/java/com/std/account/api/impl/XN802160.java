package com.std.account.api.impl;

import com.std.account.ao.IBaofooAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802160Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * BaofooPC端网关支付-提交拼接
 * @author: myb858 
 * @since: 2016年11月5日 下午1:41:18 
 * @history:
 */
public class XN802160 extends AProcessor {
    private IBaofooAO baofooAO = SpringContextHolder.getBean(IBaofooAO.class);

    private XN802160Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String url = baofooAO.getPCPayUrl(req);
        return url;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802160Req.class);
        StringValidater.validateBlank(req.getCompanyCode(), req.getTransId(),
            req.getOrderMoney(), req.getTradeDate());

    }

}
