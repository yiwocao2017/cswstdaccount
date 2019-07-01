package com.std.account.api.impl;

import com.std.account.ao.IJourAO;
import com.std.account.api.AProcessor;
import com.std.account.common.DateUtil;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.domain.Jour;
import com.std.account.dto.req.XN802521Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 流水列表查询
 * @author: xieyj 
 * @since: 2016年12月26日 下午12:29:08 
 * @history:
 */
public class XN802521 extends AProcessor {

    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN802521Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Jour condition = new Jour();
        condition.setRealNameQuery(req.getRealName());
        condition.setAccountType(req.getAccountType());
        condition.setStatus(req.getStatus());
        condition.setAccountNumber(req.getAccountNumber());
        condition.setCurrency(req.getCurrency());
        condition.setChannelType(req.getChannelType());
        condition.setChannelOrder(req.getChannelOrder());
        condition.setBizType(req.getBizType());
        condition.setStatus(req.getStatus());
        condition.setRollbackUser(req.getRollbackUser());
        condition.setWorkDate(req.getWorkDate());
        condition.setCheckUser(req.getCheckUser());
        condition.setAdjustUser(req.getAdjustUser());
        condition.setCreateDatetimeStart(DateUtil.getFrontDate(
            req.getCreateDatetimeStart(), false));
        condition.setCreateDatetimeEnd(DateUtil.getFrontDate(
            req.getCreateDatetimeEnd(), true));
        condition.setSystemCode(req.getSystemCode());
        return jourAO.queryJourList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802521Req.class);
        StringValidater.validateBlank(req.getSystemCode());
    }
}
