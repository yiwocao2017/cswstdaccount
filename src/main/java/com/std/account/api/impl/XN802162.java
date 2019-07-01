package com.std.account.api.impl;

import com.std.account.ao.IBaofooAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.dto.req.XN802162Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * BaofooPC端网关支付-页面跳转处理
 * @author: myb858 
 * @since: 2016年11月5日 下午3:43:16 
 * @history:
 */
public class XN802162 extends AProcessor {

    private IBaofooAO baofooAO = SpringContextHolder.getBean(IBaofooAO.class);

    private XN802162Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return baofooAO.handlePCPay(req);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802162Req.class);

    }

}
