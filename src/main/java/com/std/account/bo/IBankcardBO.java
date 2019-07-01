package com.std.account.bo;

import java.util.List;

import com.std.account.bo.base.IPaginableBO;
import com.std.account.domain.Bankcard;

public interface IBankcardBO extends IPaginableBO<Bankcard> {

    public boolean isBankcardExist(String code);

    public String saveBankcard(Bankcard data);

    public int removeBankcard(String code);

    public int refreshBankcard(Bankcard data);

    public List<Bankcard> queryBankcardList(Bankcard condition);

    public Bankcard getBankcard(String code);

    public Bankcard getBankcardByBankcardNumber(String bankcardNumber);

}
