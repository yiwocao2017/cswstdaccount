/**
 * @Title XN802516.java 
 * @Package com.std.account.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年12月25日 下午3:49:18 
 * @version V1.0   
 */
package com.std.account.api.impl;

import com.std.account.ao.IJourAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802516Req;
import com.std.account.dto.res.BooleanRes;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/** 
 * 调账
 * @author: xieyj 
 * @since: 2016年12月25日 下午3:49:18 
 * @history:
 */
public class XN802516 extends AProcessor {
    private IJourAO jourAO = SpringContextHolder.getBean(IJourAO.class);

    private XN802516Req req = null;

    @Override
    public synchronized Object doBusiness() throws BizException {
        jourAO.adjustJour(req.getCode(), req.getAdjustResult(),
            req.getAdjustUser(), req.getAdjustNote(), req.getSystemCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802516Req.class);
        StringValidater.validateBlank(req.getCode(), req.getAdjustResult(),
            req.getAdjustUser(), req.getAdjustNote(), req.getSystemCode());
    }
}
