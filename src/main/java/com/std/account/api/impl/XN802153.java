package com.std.account.api.impl;

import com.std.account.ao.IFuiouAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.dto.req.XN802153Req;
import com.std.account.dto.res.ChannelCallbackRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * fuiouWap端-回调处理
 * @author: xieyj 
 * @since: 2016年11月11日 下午2:09:19 
 * @history:
 */
public class XN802153 extends AProcessor {
    private IFuiouAO fuiouAO = SpringContextHolder.getBean(IFuiouAO.class);

    private XN802153Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ChannelCallbackRes res = fuiouAO.handleWAPPay(req);
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802153Req.class);

    }

}
