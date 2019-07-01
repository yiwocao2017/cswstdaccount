package com.std.account.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 上午10:09:32 
 * @history:
 */
public enum EBizType {
    // 每个系统的分布说明
    AJ_REG("01", "注册送积分"), AJ_SIGN("02", "每日签到"), AJ_CZ("11", "充值"), AJ_QX(
            "-11", "取现"), AJ_LB("19", "蓝补"), AJ_HC("-19", "红冲"), ZH_O2O("-ZH1",
            "正汇O2O支付")
    // 取现审批和兑换币种，产生记录为冻结流水，故我的流水中排除这些情况
    , EXCHANGE_CURRENCY("200", "币种兑换"), Transfer_CURRENCY("201", "同币种的划转"), AJ_CGBGM(
            "210", "菜狗币购买"), CG_HB2CGB("211", "嗨币兑换菜狗币");

    public static Map<String, EBizType> getBizTypeMap() {
        Map<String, EBizType> map = new HashMap<String, EBizType>();
        for (EBizType bizType : EBizType.values()) {
            map.put(bizType.getCode(), bizType);
        }
        return map;
    }

    EBizType(String code, String value) {
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
