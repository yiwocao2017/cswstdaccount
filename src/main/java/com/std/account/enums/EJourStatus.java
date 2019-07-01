package com.std.account.enums;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 上午10:07:50 
 * @history:
 */
public enum EJourStatus {
    todoCallBack("0", "刚生成待回调"), todoCheck("1", "已回调通过,待对账"), callBack_NO("2",
            "回调不通过"), Checked_YES("3", "已对账且账已平"), Checked_NO("4", "帐不平待调账"), Adjusted(
            "5", "已调账"), todoAdjust("6", "无需对账待审批"), adjusted_YES("7",
            "无需对账审批通过"), adjusted_NO("8", "无需对账审批不通过"), Adjust_Status("678",
            "不平帐查询");
    // 用户流水：1，3，4，5，7
    // 取现审核，调账(678)
    EJourStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
