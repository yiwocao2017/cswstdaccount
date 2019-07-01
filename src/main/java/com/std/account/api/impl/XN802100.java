package com.std.account.api.impl;

import com.std.account.ao.ICompanyChannelAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.domain.CompanyChannel;
import com.std.account.dto.req.XN802100Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 新增公司渠道
 * @author: xieyj 
 * @since: 2016年11月11日 下午3:18:19 
 * @history:
 */
public class XN802100 extends AProcessor {
    private ICompanyChannelAO companyChannelAO = SpringContextHolder
        .getBean(ICompanyChannelAO.class);

    private XN802100Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        CompanyChannel data = new CompanyChannel();
        data.setCompanyCode(req.getCompanyCode());
        data.setCompanyName(req.getCompanyName());
        data.setChannelType(req.getChannelType());
        data.setStatus(req.getStatus());
        data.setChannelCompany(req.getPaycompany());
        data.setPrivateKey1(req.getPrivatekey());
        data.setPageUrl(req.getPageUrl());
        data.setErrorUrl(req.getErrorUrl());
        data.setBackUrl(req.getBackUrl());
        data.setFee(StringValidater.toLong(req.getFee()));
        data.setRemark(req.getRemark());
        data.setSystemCode(req.getSystemCode());
        companyChannelAO.addCompanyChannel(data);
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802100Req.class);
        StringValidater.validateBlank(req.getCompanyCode(),
            req.getCompanyName(), req.getChannelType(), req.getStatus(),
            req.getPaycompany(), req.getPrivatekey(), req.getPageUrl(),
            req.getErrorUrl(), req.getBackUrl());
        StringValidater.validateAmount(req.getFee());
    }
}
