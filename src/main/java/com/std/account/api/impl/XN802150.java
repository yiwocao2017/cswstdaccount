package com.std.account.api.impl;

import com.std.account.ao.IFuiouAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802150Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * fuiou网关PC端之“B2C/B2B支付接口”-提交拼接
 * @author: myb858 
 * @since: 2016年11月5日 下午1:09:29 
 * @history:
 */
public class XN802150 extends AProcessor {
    private IFuiouAO fuiouAO = SpringContextHolder.getBean(IFuiouAO.class);

    private XN802150Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String url = fuiouAO.getPCPayUrl(req);
        return url;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802150Req.class);
        StringValidater.validateBlank(req.getCompanyCode(), req.getOrderId(),
            req.getOrderAmt(), req.getOrderPayType(), req.getIssInsCd());
        StringValidater.validateAmount(req.getOrderAmt());
    }
}
