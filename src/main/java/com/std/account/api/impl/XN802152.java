package com.std.account.api.impl;

import com.std.account.ao.IFuiouAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.dto.req.XN802152Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * fuiouWap端一键支付-提交拼接
 * @author: myb858 
 * @since: 2016年11月5日 下午8:26:37 
 * @history:
 */
public class XN802152 extends AProcessor {
    private IFuiouAO fuiouAO = SpringContextHolder.getBean(IFuiouAO.class);

    private XN802152Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String url = fuiouAO.getWapPayUrl(req);
        return url;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802152Req.class);

    }

}
