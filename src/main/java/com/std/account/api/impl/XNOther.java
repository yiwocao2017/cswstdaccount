package com.std.account.api.impl;

import com.std.account.api.AProcessor;
import com.std.account.exception.BizException;
import com.std.account.exception.ParaException;

public class XNOther extends AProcessor {

    @Override
    public Object doBusiness() throws BizException {
        throw new BizException("702xxx", "无效API功能号");
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        throw new ParaException("702xxx", "无效API功能号");

    }

}
