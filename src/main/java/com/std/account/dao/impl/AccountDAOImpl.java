/**
 * @Title AccountDAOImpl.java 
 * @Package com.ibis.account.dao.impl 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:18:26 
 * @version V1.0   
 */
package com.std.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.account.dao.IAccountDAO;
import com.std.account.dao.base.support.AMybatisTemplate;
import com.std.account.domain.Account;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:18:26 
 * @history:
 */
@Repository("accountDAOImpl")
public class AccountDAOImpl extends AMybatisTemplate implements IAccountDAO {

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Account data) {
        return super.insert(NAMESPACE.concat("insert_account"), data);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Account data) {
        return 0;
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Account select(Account condition) {
        return super.select(NAMESPACE.concat("select_account"), condition,
            Account.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public long selectTotalCount(Account condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_account_count"),
            condition);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Account> selectList(Account condition) {
        return super.selectList(NAMESPACE.concat("select_account"), condition,
            Account.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Account> selectList(Account condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_account"), start,
            count, condition, Account.class);
    }

    /** 
     * @see com.xnjr.account.dao.ibis.account.dao.IAccountDAO#updateAmount(com.ibis.account.domain.Account)
     */
    @Override
    public int updateAmount(Account data) {
        return super.update(NAMESPACE.concat("update_account_amount"), data);
    }

    /** 
     * @see com.xnjr.account.dao.ibis.account.dao.IAccountDAO#updateFrozenAmount(com.ibis.account.domain.Account)
     */
    @Override
    public int updateFrozenAmount(Account data) {
        return super.update(NAMESPACE.concat("update_account_frozen_amount"),
            data);
    }

    /** 
     * @see com.std.account.dao.IAccountDAO#updateRealName(com.std.account.domain.Account)
     */
    @Override
    public int updateRealName(Account data) {
        return super.update(NAMESPACE.concat("update_account_realName"), data);
    }

    /** 
     * @see com.xnjr.account.dao.ibis.account.dao.IAccountDAO#updateStatus(com.ibis.account.domain.Account)
     */
    @Override
    public int updateStatus(Account data) {
        return super.update(NAMESPACE.concat("update_account_status"), data);
    }
}
