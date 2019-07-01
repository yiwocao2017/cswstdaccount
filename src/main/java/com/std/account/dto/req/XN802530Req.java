package com.std.account.dto.req;

public class XN802530Req {
    // 用户编号(必填)
    private String userId;

    // 支付类型(必填)
    private String payType;

    // 充值金额(必填)
    private String amount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
