package com.std.account.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.std.account.ao.ICompanyChannelAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.domain.CompanyChannel;
import com.std.account.dto.req.XN802105Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 分页查询渠道公司
 * @author: xieyj 
 * @since: 2016年11月11日 下午3:36:59 
 * @history:
 */
public class XN802105 extends AProcessor {
    private ICompanyChannelAO companyChannelAO = SpringContextHolder
        .getBean(ICompanyChannelAO.class);

    private XN802105Req req = null;

    /** 
     * @see com.xnjr.base.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        CompanyChannel condition = new CompanyChannel();
        condition.setSystemCode(req.getSystemCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setCompanyName(req.getCompanyName());
        condition.setChannelType(req.getChannelType());
        condition.setStatus(req.getStatus());
        condition.setChannelCompany(req.getChannelCompany());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICompanyChannelAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return companyChannelAO
            .queryCompanyChannelPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802105Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit(),
            req.getSystemCode());
    }
}
