package com.std.account.api.impl;

import com.std.account.ao.IBaofooAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.dto.req.XN802163Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * BaofooWap端一键支付-提交拼接
 * @author: myb858 
 * @since: 2016年11月5日 下午3:46:41 
 * @history:
 */
public class XN802163 extends AProcessor {
    private IBaofooAO baofooAO = SpringContextHolder.getBean(IBaofooAO.class);

    private XN802163Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String url = baofooAO.getWapPayUrl(req);
        return url;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802163Req.class);

    }

}
