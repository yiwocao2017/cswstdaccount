package com.std.account.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.std.account.ao.IJourAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802511Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 批量手动回调(目前限于线下渠道，线上渠道返回服务器暂时无实现)
 * @author: xieyj 
 * @since: 2016年12月23日 下午10:37:46 
 * @history:
 */
public class XN802511 extends AProcessor {
    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN802511Req req = null;

    /** 
    * @see com.xnjr.base.api.IProcessor#doBusiness()
    */
    @Override
    public synchronized Object doBusiness() throws BizException {
        jourAO.doCallBackChangeList(req.getCodeList(), req.getRollbackResult(),
            req.getRollbackUser(), req.getRollbackNote(), req.getSystemCode());
        return new BooleanRes(true);
    }

    /** 
    * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
    */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802511Req.class);
        StringValidater.validateBlank(req.getRollbackUser(),
            req.getRollbackNote(), req.getSystemCode());
        if (CollectionUtils.isEmpty(req.getCodeList())) {
            throw new BizException("订单列表不能为空");
        }
    }
}
