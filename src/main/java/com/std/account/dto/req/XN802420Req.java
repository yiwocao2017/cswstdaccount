/**
 * @Title XN802530Req.java 
 * @Package com.std.account.dto.req 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年3月30日 下午2:17:07 
 * @version V1.0   
 */
package com.std.account.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2017年3月30日 下午2:17:07 
 * @history:
 */
public class XN802420Req {
    // 采购方用户编号(必填)
    private String fromUserId;

    // 售卖方用户编号(必填)
    private String toUserId;

    // 购买数量(必填)
    private String amount;

    // 购买虚拟币币种(必填)
    private String currency;

    // 支付类型（必填）
    private String payType;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

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
