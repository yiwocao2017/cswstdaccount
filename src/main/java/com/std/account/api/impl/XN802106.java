package com.std.account.api.impl;

import com.std.account.ao.ICompanyChannelAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.domain.CompanyChannel;
import com.std.account.dto.req.XN802106Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 列表查询公司渠道
 * @author: xieyj 
 * @since: 2016年9月17日 下午1:50:23 
 * @history:
 */
public class XN802106 extends AProcessor {
    private ICompanyChannelAO companyChannelAO = SpringContextHolder
        .getBean(ICompanyChannelAO.class);

    private XN802106Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        CompanyChannel condition = new CompanyChannel();
        condition.setCompanyCode(req.getCompanyCode());
        condition.setCompanyName(req.getCompanyName());
        condition.setChannelType(req.getChannelType());
        condition.setStatus(req.getStatus());
        condition.setChannelCompany(req.getPaycompany());
        return companyChannelAO.queryCompanyChannelList(condition);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802106Req.class);
    }
}
