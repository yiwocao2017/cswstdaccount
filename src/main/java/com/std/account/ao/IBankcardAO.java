package com.std.account.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.account.bo.base.Paginable;
import com.std.account.domain.Bankcard;

/**
 * 
 * @author: asus 
 * @since: 2016年12月22日 下午3:29:32 
 * @history:
 */
@Component
public interface IBankcardAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBankcard(Bankcard data);

    public int dropBankcard(String code);

    public int editBankcard(Bankcard data);

    public Paginable<Bankcard> queryBankcardPage(int start, int limit,
            Bankcard condition);

    public List<Bankcard> queryBankcardList(Bankcard condition);

    public Bankcard getBankcard(String code);

}
