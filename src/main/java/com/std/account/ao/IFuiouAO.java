package com.std.account.ao;

import com.std.account.annotation.ServiceModule;
import com.std.account.dto.req.XN802150Req;
import com.std.account.dto.req.XN802151Req;
import com.std.account.dto.req.XN802152Req;
import com.std.account.dto.req.XN802153Req;
import com.std.account.dto.res.ChannelCallbackRes;

@ServiceModule
public interface IFuiouAO {

    String getPCPayUrl(XN802150Req req);

    String getWapPayUrl(XN802152Req req);

    ChannelCallbackRes handlePCPay(XN802151Req req);

    ChannelCallbackRes handleWAPPay(XN802153Req req);

}
