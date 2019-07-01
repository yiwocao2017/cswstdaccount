package com.std.account.api.impl;

import com.std.account.ao.IBankcardAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.domain.Bankcard;
import com.std.account.dto.req.XN802010Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/**
 * 绑定银行卡
 * @author: asus 
 * @since: 2016年12月22日 下午5:04:53 
 * @history:
 */
public class XN802010 extends AProcessor {
    private IBankcardAO bankCardAO = SpringContextHolder
        .getBean(IBankcardAO.class);

    private XN802010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Bankcard data = new Bankcard();
        data.setSystemCode(req.getSystemCode());
        data.setBankcardNumber(req.getBankcardNumber());
        data.setBankCode(req.getBankCode());
        data.setBankName(req.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setBindMobile(req.getBindMobile());
        data.setUserId(req.getUserId());
        data.setRealName(req.getRealName());
        data.setType(req.getType());
        data.setCurrency(req.getCurrency());
        data.setRemark(req.getRemark());
        return bankCardAO.addBankcard(data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802010Req.class);
        StringValidater.validateBlank(req.getSystemCode(),
            req.getBankcardNumber(), req.getBankCode(), req.getBankName(),
            req.getSubbranch(), req.getBindMobile(), req.getUserId(),
            req.getRealName(), req.getType());
    }
}
