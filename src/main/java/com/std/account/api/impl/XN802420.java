package com.std.account.api.impl;

import com.std.account.ao.IExchangeCurrencyAO;
import com.std.account.api.AProcessor;
import com.std.account.common.JsonUtil;
import com.std.account.core.StringValidater;
import com.std.account.dto.req.XN802420Req;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/** 
 * 虚拟币售卖_微信h5和二维码扫码(菜狗相对用户购买，商家向加盟商，加盟商向平台购买，前端用户问平台购买)
 * @author: haiqingzheng 
 * @since: 2017年3月30日 下午2:15:48 
 * @history:
 */
public class XN802420 extends AProcessor {
    private IExchangeCurrencyAO exchangeCurrencyAO = SpringContextHolder
        .getBean(IExchangeCurrencyAO.class);

    private XN802420Req req = null;

    /** 
     * @see com.std.account.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return exchangeCurrencyAO.payExchange(req.getFromUserId(),
            req.getToUserId(), StringValidater.toLong(req.getAmount()),
            req.getCurrency(), req.getPayType());
    }

    /** 
     * @see com.std.account.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN802420Req.class);
        StringValidater.validateBlank(req.getFromUserId(), req.getToUserId(),
            req.getAmount(), req.getCurrency());
    }

}
