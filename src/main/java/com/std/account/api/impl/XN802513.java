/**
 * @Title XN802513.java 
 * @Package com.std.account.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年12月25日 下午3:49:41 
 * @version V1.0   
 */
package com.std.account.api.impl;

import com.std.account.ao.IAccountAO;
import com.std.account.api.AProcessor;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;
import com.std.account.spring.SpringContextHolder;

/** 
 * 发起自动对账(暂无实现)
 * @author: xieyj 
 * @since: 2016年12月25日 下午3:49:41 
 * @history:
 */
public class XN802513 extends AProcessor {
    private IAccountAO accountAO = SpringContextHolder
        .getBean(IAccountAO.class);

    @Override
    public Object doBusiness() throws BizException {
        return null;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
    }

}
