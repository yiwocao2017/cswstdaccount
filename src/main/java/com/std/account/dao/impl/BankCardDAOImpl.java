package com.std.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.account.dao.IBankCardDAO;
import com.std.account.dao.base.support.AMybatisTemplate;
import com.std.account.domain.Bankcard;

/**
 * 
 * @author: asus 
 * @since: 2016年12月22日 下午4:30:48 
 * @history:
 */
@Repository("bankcardDAOImpl")
public class BankCardDAOImpl extends AMybatisTemplate implements IBankCardDAO {

    @Override
    public int insert(Bankcard data) {
        return super.insert(NAMESPACE.concat("insert_bankcard"), data);
    }

    @Override
    public int delete(Bankcard data) {
        return super.delete(NAMESPACE.concat("delete_bankcard"), data);
    }

    @Override
    public Bankcard select(Bankcard condition) {
        return super.select(NAMESPACE.concat("select_bankcard"), condition,
            Bankcard.class);
    }

    @Override
    public long selectTotalCount(Bankcard condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_bankcard_count"), condition);
    }

    @Override
    public List<Bankcard> selectList(Bankcard condition) {
        return super.selectList(NAMESPACE.concat("select_bankcard"), condition,
            Bankcard.class);
    }

    @Override
    public List<Bankcard> selectList(Bankcard condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_bankcard"), start,
            count, condition, Bankcard.class);
    }

    @Override
    public int update(Bankcard data) {
        return super.update(NAMESPACE.concat("update_bankcard"), data);
    }

}
