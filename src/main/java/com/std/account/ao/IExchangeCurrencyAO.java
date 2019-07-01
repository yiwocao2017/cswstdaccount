package com.std.account.ao;

import com.std.account.bo.base.Paginable;
import com.std.account.domain.ExchangeCurrency;

public interface IExchangeCurrencyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 获取虚拟币价值。1fromCurrency等于多少toCurrency
    public Double getExchangeRate(String fromCurrency, String toCurrency);

    public String applyExchange(String userId, Long fromAmount,
            String fromCurrency, String toCurrency);

    public void approveExchange(String code, String approveResult,
            String approver, String approveNote);

    public Object payExchange(String fromUserId, String toUserId, Long amount,
            String currency, String payType);

    public void paySuccess(String payGroup, String payCode, Long transAmount);

    public String doExchange(String userId, Long fromAmount,
            String fromCurrency, String toCurrency);

    public Paginable<ExchangeCurrency> queryExchangeCurrencyPage(int start,
            int limit, ExchangeCurrency condition);

    public ExchangeCurrency getExchangeCurrency(String code);

    // 商户针对C端手机划转资金
    public void doTransferB2C(String storeOwner, String mobile, Long amount,
            String currency);

    // 加盟商对商户划转资金
    public void doTransferF2B(String franchiseeUser, String storeOwner,
            Long amount, String currency);

    // 平台对加盟商划转资金
    public void doTransferP2F(String fromUserId, String toUserId, Long amount,
            String currency);

    // 平台对用户划转资金
    public void doTransferP2C(String fromUserId, String toUserId,
            Long amount, String currency);

}
