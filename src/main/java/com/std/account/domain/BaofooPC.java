package com.std.account.domain;

import com.std.account.common.BFPropertiesUtil;

public class BaofooPC {
    // 版本号
    private String interfaceVersion = BFPropertiesUtil.Config.PC_VER;

    // 加密类型
    private String keyType = BFPropertiesUtil.Config.PC_KEYTYPE;

    // 通知类型：固定数字1
    private String noticeType = BFPropertiesUtil.Config.PC_NOTICETYPE;

    // 渠道访问地址
    private String payUrl = BFPropertiesUtil.Config.PC_PAYURL;

    public String getInterfaceVersion() {
        return interfaceVersion;
    }

    public void setInterfaceVersion(String interfaceVersion) {
        this.interfaceVersion = interfaceVersion;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

}
