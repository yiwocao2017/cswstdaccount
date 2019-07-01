package com.std.account.dto.req;

/**
 * 加盟商对商户划转资金
 * @author: xieyj 
 * @since: 2017年4月14日 下午1:00:06 
 * @history:
 */
public class XN802401Req {
    // 上级用户编号
    private String fromUserId;

    // 下发用户编号
    private String toUserId;

    // 划转金额(必填)
    private String amount;

    // 币种(菜狗币和积分币)(必填)
    private String currency;

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
