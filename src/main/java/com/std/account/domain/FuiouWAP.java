package com.std.account.domain;

import com.std.account.common.FYPropertiesUtil;

public class FuiouWAP {
    // 加密标志(必填)是否对订单信息 FM 域的内容进行加 密,1 表示加密,0 表示不加密
    private String ENCTP = FYPropertiesUtil.Config.WAP_ENCTP;

    // 版本号(必填)
    private String VERSION = FYPropertiesUtil.Config.WAP_VERSION;

    // 交易类型 (必填)
    private String TYPE = FYPropertiesUtil.Config.WAP_TYPE;

    // 是否隐藏支付页面富友的 logo,1 隐藏,0 显示(必填)
    private String LOGOTP = FYPropertiesUtil.Config.WAP_LOGOTP;

    // 保留字段1(选填)
    private String REM1;

    // 保留字段1(选填)
    private String REM2;

    // 保留字段1(选填)
    private String REM3;

    // 签名方式md5 或 rsa (必填)
    private String SIGNTP = FYPropertiesUtil.Config.WAP_SIGNTP;

    private String payUrl = FYPropertiesUtil.Config.WAP_PAYURL;

    // private String payUrl =
    // "https://mpay.fuiou.com:16128/h5pay/payAction.pay";

    // "http://www-1.fuiou.com:18670/mobile_pay/h5pay/payAction.pay";

    public String getENCTP() {
        return ENCTP;
    }

    public void setENCTP(String eNCTP) {
        ENCTP = eNCTP;
    }

    public String getVERSION() {
        return VERSION;
    }

    public void setVERSION(String vERSION) {
        VERSION = vERSION;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String tYPE) {
        TYPE = tYPE;
    }

    public String getLOGOTP() {
        return LOGOTP;
    }

    public void setLOGOTP(String lOGOTP) {
        LOGOTP = lOGOTP;
    }

    public String getREM1() {
        return REM1;
    }

    public void setREM1(String rEM1) {
        REM1 = rEM1;
    }

    public String getREM2() {
        return REM2;
    }

    public void setREM2(String rEM2) {
        REM2 = rEM2;
    }

    public String getREM3() {
        return REM3;
    }

    public void setREM3(String rEM3) {
        REM3 = rEM3;
    }

    public String getSIGNTP() {
        return SIGNTP;
    }

    public void setSIGNTP(String sIGNTP) {
        SIGNTP = sIGNTP;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }
}
