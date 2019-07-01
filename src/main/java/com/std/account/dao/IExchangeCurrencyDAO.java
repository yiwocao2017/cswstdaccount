package com.std.account.dao;

import com.std.account.dao.base.IBaseDAO;
import com.std.account.domain.ExchangeCurrency;

public interface IExchangeCurrencyDAO extends IBaseDAO<ExchangeCurrency> {
    String NAMESPACE = IExchangeCurrencyDAO.class.getName().concat(".");

    int applyExchange(ExchangeCurrency data);

    int approveExchange(ExchangeCurrency data);

    int payExchange(ExchangeCurrency data);

    int paySuccess(ExchangeCurrency data);

    int doExchange(ExchangeCurrency data);
}
