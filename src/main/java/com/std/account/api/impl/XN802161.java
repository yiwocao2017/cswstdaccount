package com.std.account.api.impl;

import com.std.account.ao.IBaofooAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.dto.req.XN802161Req;
import com.std.account.dto.res.ChannelCallbackRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * BaofooPC端网关支付-服务端回调处理
 * @author: myb858 
 * @since: 2016年11月5日 下午3:16:56 
 * @history:
 */
public class XN802161 extends AProcessor {
    private IBaofooAO baofooAO = SpringContextHolder.getBean(IBaofooAO.class);

    private XN802161Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ChannelCallbackRes res = baofooAO.handlePCPay(req);
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802161Req.class);
    }

}
