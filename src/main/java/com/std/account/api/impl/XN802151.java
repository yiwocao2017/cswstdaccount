package com.std.account.api.impl;

import com.std.account.ao.IFuiouAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.dto.req.XN802151Req;
import com.std.account.dto.res.ChannelCallbackRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * fuiou网关之“B2C/B2B支付接口”-回调处理
 * @author: myb858 
 * @since: 2016年11月5日 下午1:11:10 
 * @history:
 */
public class XN802151 extends AProcessor {
    private IFuiouAO fuiouAO = SpringContextHolder.getBean(IFuiouAO.class);

    private XN802151Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ChannelCallbackRes res = fuiouAO.handlePCPay(req);
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802151Req.class);
    }

}
