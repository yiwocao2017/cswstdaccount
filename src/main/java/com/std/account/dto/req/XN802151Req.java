package com.std.account.dto.req;

public class XN802151Req {
    // 公司名(必填)
    private String companyCode;

    String mchntCd;// 商户号

    String orderId;// 商户订单号

    String orderDate;// 订单日期

    String orderAmt;// 交易金额

    String orderSt;// 订单状态

    String orderPayCode;// 错误代码

    String orderPayError;// 错误中文描述

    String resv1;// 保留字段

    String fySsn;// 富有流水号

    String md5;// MD5

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getMchntCd() {
        return mchntCd;
    }

    public void setMchntCd(String mchntCd) {
        this.mchntCd = mchntCd;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(String orderAmt) {
        this.orderAmt = orderAmt;
    }

    public String getOrderSt() {
        return orderSt;
    }

    public void setOrderSt(String orderSt) {
        this.orderSt = orderSt;
    }

    public String getOrderPayCode() {
        return orderPayCode;
    }

    public void setOrderPayCode(String orderPayCode) {
        this.orderPayCode = orderPayCode;
    }

    public String getOrderPayError() {
        return orderPayError;
    }

    public void setOrderPayError(String orderPayError) {
        this.orderPayError = orderPayError;
    }

    public String getResv1() {
        return resv1;
    }

    public void setResv1(String resv1) {
        this.resv1 = resv1;
    }

    public String getFySsn() {
        return fySsn;
    }

    public void setFySsn(String fySsn) {
        this.fySsn = fySsn;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

}
