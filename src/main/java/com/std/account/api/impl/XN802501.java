package com.std.account.api.impl;

import com.std.account.ao.IAccountAO;
import com.std.account.api.AProcessor;
import com.std.account.common.DateUtil;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.domain.Account;
import com.std.account.dto.req.XN802501Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 列表查询账户
 * @author: xieyj 
 * @since: 2016年12月23日 下午8:32:58 
 * @history:
 */
public class XN802501 extends AProcessor {

    private IAccountAO accountAO = SpringContextHolder
        .getBean(IAccountAO.class);

    private XN802501Req req = null;

    /** 
    * @see com.xnjr.base.api.IProcessor#doBusiness()
    */
    @Override
    public Object doBusiness() throws BizException {
        Account condition = new Account();
        condition.setRealNameQuery(req.getRealName());
        condition.setType(req.getType());
        condition.setStatus(req.getStatus());
        condition.setCurrency(req.getCurrency());
        condition.setLastOrder(req.getLastOrder());
        condition.setSystemCode(req.getSystemCode());
        condition.setCreateDatetimeStart(DateUtil.strToDate(req.getDateStart(),
            DateUtil.DATA_TIME_PATTERN_1));
        condition.setCreateDatetimeEnd(DateUtil.strToDate(req.getDateEnd(),
            DateUtil.DATA_TIME_PATTERN_1));
        return accountAO.queryAccountList(condition);
    }

    /** 
    * @see com.xnjr.base.api.IProcessor#doCheck(java.lang.String)
    */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802501Req.class);
        StringValidater.validateBlank(req.getSystemCode());
    }
}
