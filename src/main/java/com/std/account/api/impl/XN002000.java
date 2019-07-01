package com.std.account.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.std.account.ao.IAccountAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN002000Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 *  一人创建多个币种账户（注册时）
 * @author: myb858 
 * @since: 2017年4月3日 下午1:59:08 
 * @history:
 */
public class XN002000 extends AProcessor {
    private IAccountAO accountAO = SpringContextHolder
        .getBean(IAccountAO.class);

    private XN002000Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        accountAO.distributeAccount(req.getUserId(), req.getRealName(),
            req.getType(), req.getCurrencyList(), req.getSystemCode());
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN002000Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getType(),
            req.getSystemCode());
        if (CollectionUtils.isEmpty(req.getCurrencyList())) {
            new BizException("XN0000", "账户币种不能为空");
        }
    }

}
