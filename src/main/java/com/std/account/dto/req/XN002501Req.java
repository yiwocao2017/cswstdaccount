/**
 * @Title XN802180Req.java 
 * @Package com.std.account.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月23日 上午9:25:46 
 * @version V1.0   
 */
package com.std.account.dto.req;

/** 
 * 微信公众号支付请求接口，返回预付单信息
 * @author: haiqingzheng 
 * @since: 2016年12月23日 上午9:25:46 
 * @history:
 */
public class XN002501Req {

    // 付款方用户编号（必填）
    private String fromUserId;

    // 付款方微信openId（必填）
    private String fromOpenId;

    // 收款方用户编号（必填）
    private String toUserId;

    // 业务类型（必填）
    private String bizType;

    // 付款方业务备注（必填）
    private String fromBizNote;

    // 收款方业务备注（必填）
    private String toBizNote;

    // 划转资金(必填)
    private String transAmount;

    // 支付组号(必填)
    private String payGroup;

    // 回调地址(必填)
    private String backUrl;

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromOpenId() {
        return fromOpenId;
    }

    public void setFromOpenId(String fromOpenId) {
        this.fromOpenId = fromOpenId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getFromBizNote() {
        return fromBizNote;
    }

    public void setFromBizNote(String fromBizNote) {
        this.fromBizNote = fromBizNote;
    }

    public String getToBizNote() {
        return toBizNote;
    }

    public void setToBizNote(String toBizNote) {
        this.toBizNote = toBizNote;
    }

    public String getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(String transAmount) {
        this.transAmount = transAmount;
    }

    public String getPayGroup() {
        return payGroup;
    }

    public void setPayGroup(String payGroup) {
        this.payGroup = payGroup;
    }

}
