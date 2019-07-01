package com.std.account.api.impl;

import com.std.account.ao.ICompanyChannelAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802107Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 详情查询公司渠道
 * @author: xieyj 
 * @since: 2016年11月11日 下午3:43:45 
 * @history:
 */
public class XN802107 extends AProcessor {
    private ICompanyChannelAO companyChannelAO = SpringContextHolder
        .getBean(ICompanyChannelAO.class);

    private XN802107Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return companyChannelAO.getCompanyChannel(StringValidater.toLong(req
            .getId()));
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802107Req.class);
        StringValidater.validateBlank(req.getId());
    }
}
