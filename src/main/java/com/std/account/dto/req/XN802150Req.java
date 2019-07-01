package com.std.account.dto.req;

public class XN802150Req {
    // 公司编号(必填)
    private String companyCode;

    // 订单号(必填)-下一版：去掉此参数
    private String orderId;

    // 交易金额(必填)
    private String orderAmt;

    // 支付类型(必填)
    private String orderPayType;

    // 银行代码(必填)
    private String issInsCd;

    // 商品名称(非必填)
    private String goodsName;

    // 商品展示网址(非必填)
    private String goodsDisplayUrl;

    // 备注(非必填)
    private String rem;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(String orderAmt) {
        this.orderAmt = orderAmt;
    }

    public String getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(String orderPayType) {
        this.orderPayType = orderPayType;
    }

    public String getIssInsCd() {
        return issInsCd;
    }

    public void setIssInsCd(String issInsCd) {
        this.issInsCd = issInsCd;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDisplayUrl() {
        return goodsDisplayUrl;
    }

    public void setGoodsDisplayUrl(String goodsDisplayUrl) {
        this.goodsDisplayUrl = goodsDisplayUrl;
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }

}
