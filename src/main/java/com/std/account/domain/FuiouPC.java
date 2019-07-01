package com.std.account.domain;

import com.std.account.common.FYPropertiesUtil;

public class FuiouPC {
    // (非必填)
    private String orderValidTime = FYPropertiesUtil.Config.PC_ORDERVALIDTIME;

    // (必填)
    private String ver = FYPropertiesUtil.Config.PC_VER;

    private String payUrl = FYPropertiesUtil.Config.PC_PAYURL;

    // private String payUrl = "https://pay.fuiou.com/smpGate.do";
    // "http://www-1.fuiou.com:8888/wg1_run/smpGate.do";

    public String getOrderValidTime() {
        return orderValidTime;
    }

    public void setOrderValidTime(String orderValidTime) {
        this.orderValidTime = orderValidTime;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

}
