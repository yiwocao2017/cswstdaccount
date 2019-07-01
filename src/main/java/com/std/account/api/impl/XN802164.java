package com.std.account.api.impl;

import com.std.account.ao.IBaofooAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.dto.req.XN802164Req;
import com.std.account.dto.res.ChannelCallbackRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * BaofooWap端一键支付-服务端回调处理
 * @author: myb858 
 * @since: 2016年11月5日 下午5:16:38 
 * @history:
 */
public class XN802164 extends AProcessor {
    private IBaofooAO baofooAO = SpringContextHolder.getBean(IBaofooAO.class);

    private XN802164Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ChannelCallbackRes res = baofooAO.handleWAPPay(req);
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802164Req.class);

    }

}
