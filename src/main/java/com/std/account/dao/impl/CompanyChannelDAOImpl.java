package com.std.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.std.account.dao.ICompanyChannelDAO;
import com.std.account.dao.base.support.AMybatisTemplate;
import com.std.account.domain.CompanyChannel;

/**
 * @author: xieyj 
 * @since: 2016年11月10日 下午7:47:12 
 * @history:
 */
@Repository("companyChannelDAOImpl")
public class CompanyChannelDAOImpl extends AMybatisTemplate implements
        ICompanyChannelDAO {

    @Override
    public int insert(CompanyChannel data) {
        return super.insert(NAMESPACE.concat("insert_companyChannel"), data);
    }

    @Override
    public int delete(CompanyChannel data) {
        return super.delete(NAMESPACE.concat("delete_companyChannel"), data);
    }

    @Override
    public CompanyChannel select(CompanyChannel condition) {
        return super.select(NAMESPACE.concat("select_companyChannel"),
            condition, CompanyChannel.class);
    }

    @Override
    public long selectTotalCount(CompanyChannel condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_companyChannel_count"), condition);
    }

    @Override
    public List<CompanyChannel> selectList(CompanyChannel condition) {
        return super.selectList(NAMESPACE.concat("select_companyChannel"),
            condition, CompanyChannel.class);
    }

    @Override
    public List<CompanyChannel> selectList(CompanyChannel condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_companyChannel"),
            start, count, condition, CompanyChannel.class);
    }

    /** 
     * @see com.std.account.dao.ICompanyChannelDAO#update(com.std.account.domain.CompanyChannel)
     */
    @Override
    public int update(CompanyChannel data) {
        return super.update(NAMESPACE.concat("update_companyChannel"), data);
    }
}
