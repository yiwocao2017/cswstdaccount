package com.std.account.dao;

import com.std.account.dao.base.IBaseDAO;
import com.std.account.domain.Bankcard;

/**
 * 
 * @author: asus 
 * @since: 2016年12月22日 下午4:31:08 
 * @history:
 */
public interface IBankCardDAO extends IBaseDAO<Bankcard> {
    String NAMESPACE = IBankCardDAO.class.getName().concat(".");

    public int update(Bankcard data);
}
