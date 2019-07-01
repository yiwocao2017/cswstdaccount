package com.std.account.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.std.account.ao.ISYSConfigAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.domain.SYSConfig;
import com.std.account.dto.req.XN802025Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 分页查询系统参数
 * @author: Gejin 
 * @since: 2016年4月17日 下午8:30:55 
 * @history:
 */
public class XN802025 extends AProcessor {
    private ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    private XN802025Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSConfig condition = new SYSConfig();
        String type = req.getType();
        if (StringUtils.isNotBlank(type)) {
            String[] typeArrs = type.split(",");
            List<String> bizTypeList = new ArrayList<String>();
            for (int i = 0; i < typeArrs.length; i++) {
                bizTypeList.add(typeArrs[i]);
            }
            condition.setType(null);
            condition.setTypeList(bizTypeList);
        }
        condition.setCkeyForQuery(req.getCkey());
        condition.setUpdater(req.getUpdater());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSystemCode(req.getSystemCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISYSConfigAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return sysConfigAO.querySYSConfigPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802025Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
        StringValidater
            .validateBlank(req.getSystemCode(), req.getCompanyCode());
    }
}
