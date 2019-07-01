package com.std.account.api.impl;

import com.std.account.ao.ICompanyChannelAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.domain.CompanyChannel;
import com.std.account.dto.req.XN802102Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 修改公司渠道
 * @author: xieyj 
 * @since: 2016年9月17日 下午1:50:23 
 * @history:
 */
public class XN802102 extends AProcessor {
    private ICompanyChannelAO companyChannelAO = SpringContextHolder
        .getBean(ICompanyChannelAO.class);

    private XN802102Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        CompanyChannel data = new CompanyChannel();
        data.setId(StringValidater.toLong(req.getId()));
        data.setCompanyCode(req.getCompanyCode());
        data.setCompanyName(req.getCompanyName());
        data.setChannelType(req.getChannelType());
        data.setStatus(req.getStatus());
        data.setChannelCompany(req.getChannelCompany());
        data.setPrivateKey1(req.getPrivatekey());
        data.setPageUrl(req.getPageUrl());
        data.setErrorUrl(req.getErrorUrl());
        data.setBackUrl(req.getBackUrl());
        data.setFee(StringValidater.toLong(req.getFee()));
        data.setRemark(req.getRemark());
        companyChannelAO.editCompanyChannel(data);
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802102Req.class);
        StringValidater.validateBlank(req.getId(), req.getCompanyCode(),
            req.getCompanyName(), req.getChannelType(), req.getStatus(),
            req.getChannelCompany(), req.getPrivatekey(), req.getPageUrl(),
            req.getErrorUrl(), req.getBackUrl());
        StringValidater.validateAmount(req.getFee());
    }
}
