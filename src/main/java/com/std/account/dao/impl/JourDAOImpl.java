package com.std.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.account.dao.IJourDAO;
import com.std.account.dao.base.support.AMybatisTemplate;
import com.std.account.domain.Jour;

/**
 * @author: xieyj 
 * @since: 2016年12月23日 上午11:26:51 
 * @history:
 */
@Repository("jourDAOImpl")
public class JourDAOImpl extends AMybatisTemplate implements IJourDAO {

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Jour data) {
        return super.insert(NAMESPACE.concat("insert_jour"), data);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Jour data) {
        return 0;
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Jour select(Jour condition) {
        return super.select(NAMESPACE.concat("select_jour"), condition,
            Jour.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public long selectTotalCount(Jour condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_jour_count"),
            condition);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Jour> selectList(Jour condition) {
        return super.selectList(NAMESPACE.concat("select_jour"), condition,
            Jour.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Jour> selectList(Jour condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_jour"), start, count,
            condition, Jour.class);
    }

    /** 
     * @see com.std.account.dao.IJourDAO#updateCallback(com.std.account.domain.Jour)
     */
    @Override
    public int updateCallback(Jour data) {
        return super.update(NAMESPACE.concat("update_jour_callback"), data);
    }

    /** 
     * @see com.xnjr.account.dao.IJourDAO.account.dao.IAJourDAO#updateCheck(com.Jour.account.domain.AccountJour)
     */
    @Override
    public int updateCheck(Jour data) {
        return super.update(NAMESPACE.concat("update_check_jour"), data);
    }

    /** 
     * @see com.std.account.dao.IJourDAO#updateAdjust(com.std.account.domain.Jour)
     */
    @Override
    public int updateAdjust(Jour data) {
        return super.update(NAMESPACE.concat("update_adjust_jour"), data);
    }

    /** 
     * @see com.std.account.dao.IJourDAO#updateAdjustStatus(com.std.account.domain.Jour)
     */
    @Override
    public int updateAdjustStatus(Jour data) {
        return super.update(NAMESPACE.concat("update_adjust_status"), data);
    }
}
