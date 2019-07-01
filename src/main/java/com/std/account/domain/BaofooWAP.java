package com.std.account.domain;

import com.std.account.common.BFPropertiesUtil;

public class BaofooWAP {
    // 版本号
    private String version = BFPropertiesUtil.Config.WAP_VER;

    // 字符集
    private String inputCharset = BFPropertiesUtil.Config.WAP_INPUTCHARSET;

    private String language = BFPropertiesUtil.Config.WAP_LANGUAGE;

    private String txnType = BFPropertiesUtil.Config.WAP_TXNTYPE;

    private String txnSubType = BFPropertiesUtil.Config.WAP_TXNSUBTYPE;

    private String bizType;

    private String pfxPath = BFPropertiesUtil.Config.WAP_PFXPATH;

    private String pfxPwd = BFPropertiesUtil.Config.WAP_PFXPWD;

    private String cerPath = BFPropertiesUtil.Config.WAP_CERPATH;

    // 数据类型
    private String dataType = BFPropertiesUtil.Config.WAP_DATATYPE;

    // 渠道访问地址
    private String payUrl = BFPropertiesUtil.Config.WAP_PAYURL;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInputCharset() {
        return inputCharset;
    }

    public void setInputCharset(String inputCharset) {
        this.inputCharset = inputCharset;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getTxnSubType() {
        return txnSubType;
    }

    public void setTxnSubType(String txnSubType) {
        this.txnSubType = txnSubType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getPfxPath() {
        return pfxPath;
    }

    public void setPfxPath(String pfxPath) {
        this.pfxPath = pfxPath;
    }

    public String getPfxPwd() {
        return pfxPwd;
    }

    public void setPfxPwd(String pfxPwd) {
        this.pfxPwd = pfxPwd;
    }

    public String getCerPath() {
        return cerPath;
    }

    public void setCerPath(String cerPath) {
        this.cerPath = cerPath;
    }

}
