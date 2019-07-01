package com.std.account.dto.req;

public class XN802160Req {
    // 公司名(必填)
    private String companyCode;

    // 商户订单号(必填)
    private String transId;

    // 订单金额(必填)
    private String orderMoney;

    // 订单日期(必填)
    private String tradeDate;

    // 若选择全部银行则为空字符串,选择全部银行即跳转宝付收银台选择银行(选填)
    private String payId;

    // 商品名称(选填)
    private String productName;

    // 商品数量(选填)
    private String amount;

    // 用户名称(选填)
    private String userName;

    // 附加字段(选填)
    private String additionInfo;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(String orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAdditionInfo() {
        return additionInfo;
    }

    public void setAdditionInfo(String additionInfo) {
        this.additionInfo = additionInfo;
    }

}
