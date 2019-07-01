package com.std.account.api.impl;

import com.std.account.ao.ICompanyChannelAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802101Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 删除公司渠道
 * @author: xieyj 
 * @since: 2016年11月11日 下午3:27:22 
 * @history:
 */
public class XN802101 extends AProcessor {
    private ICompanyChannelAO companyChannelAO = SpringContextHolder
        .getBean(ICompanyChannelAO.class);

    private XN802101Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Long id = StringValidater.toLong(req.getId());
        companyChannelAO.dropCompanyChannel(id);
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802101Req.class);
        StringValidater.validateBlank(req.getId());
    }
}
