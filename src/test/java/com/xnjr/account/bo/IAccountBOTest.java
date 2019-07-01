package com.xnjr.account.bo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.std.account.bo.IAccountBO;
import com.std.account.bo.base.Paginable;
import com.std.account.domain.Account;
import com.xnjr.account.base.ABizTest;

public class IAccountBOTest extends ABizTest {
    @Autowired
    private IAccountBO accountBO;

    @Test
    public void getPaginable() {
        Account condition = new Account();
        condition.setStatus("1");
        condition.setOrder("t.account_number", false);
        Paginable<Account> page = accountBO.getPaginable(1, 1, condition);
        logger.info("getPaginable : {}", page);
    }

}
