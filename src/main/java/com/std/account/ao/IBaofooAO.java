package com.std.account.ao;

import com.std.account.annotation.ServiceModule;
import com.std.account.dto.req.XN802160Req;
import com.std.account.dto.req.XN802161Req;
import com.std.account.dto.req.XN802162Req;
import com.std.account.dto.req.XN802163Req;
import com.std.account.dto.req.XN802164Req;
import com.std.account.dto.res.ChannelCallbackRes;

@ServiceModule
public interface IBaofooAO {

    String getPCPayUrl(XN802160Req req);

    String getWapPayUrl(XN802163Req req);

    ChannelCallbackRes handlePCPay(XN802161Req req);

    String handlePCPay(XN802162Req req);

    ChannelCallbackRes handleWAPPay(XN802164Req req);

}
