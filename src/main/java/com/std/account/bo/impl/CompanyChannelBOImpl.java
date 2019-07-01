package com.std.account.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.account.bo.ICompanyChannelBO;
import com.std.account.bo.base.PaginableBOImpl;
import com.std.account.dao.ICompanyChannelDAO;
import com.std.account.domain.CompanyChannel;
import com.std.account.enums.EChannelType;
import com.std.account.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年11月10日 下午7:49:32 
 * @history:
 */
@Component
public class CompanyChannelBOImpl extends PaginableBOImpl<CompanyChannel>
        implements ICompanyChannelBO {

    @Autowired
    private ICompanyChannelDAO companyChannelDAO;

    @Override
    public boolean isCompanyChannelExist(Long id) {
        CompanyChannel condition = new CompanyChannel();
        condition.setId(id);
        if (companyChannelDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public long getCompanyChannelCount(String companyCode, String channelType) {
        CompanyChannel condition = new CompanyChannel();
        condition.setCompanyCode(companyCode);
        condition.setChannelType(channelType);
        return companyChannelDAO.selectTotalCount(condition);
    }

    @Override
    public Long saveCompanyChannel(CompanyChannel data) {
        Long id = null;
        if (data != null) {
            companyChannelDAO.insert(data);
            id = data.getId();
        }
        return id;
    }

    @Override
    public int removeCompanyChannel(Long id) {
        int count = 0;
        if (id != null) {
            CompanyChannel data = new CompanyChannel();
            data.setId(id);
            count = companyChannelDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCompanyChannel(CompanyChannel data) {
        int count = 0;
        if (data != null) {
            count = companyChannelDAO.update(data);
        }
        return count;
    }

    @Override
    public List<CompanyChannel> queryCompanyChannelList(CompanyChannel condition) {
        return companyChannelDAO.selectList(condition);
    }

    @Override
    public CompanyChannel getCompanyChannel(Long id) {
        CompanyChannel data = null;
        if (id != null) {
            CompanyChannel condition = new CompanyChannel();
            condition.setId(id);
            data = companyChannelDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "公司渠道不存在");
            }
        }
        return data;
    }

    @Override
    public EChannelType getBestChannel(String companyCode,
            EChannelType channelType) {
        return EChannelType.Fuiou_PC;
    }

    /** 
     * @see com.std.account.bo.ICompanyChannelBO#getBestChannel(java.lang.String, java.util.List)
     */
    @Override
    public EChannelType getBestChannel(String companyCode,
            List<String> channelTypeList) {
        return EChannelType.CZB;
    }

    @Override
    public void transAmountPC(String companyCode, EChannelType channelType,
            Long transAmount, String order, String bankCode) {
        // TODO Auto-generated method stub
    }

    @Override
    public CompanyChannel getCompanyChannel(String companyCode,
            String systemCode, String channelType) {
        CompanyChannel condition = new CompanyChannel();
        condition.setCompanyCode(companyCode);
        condition.setSystemCode(systemCode);
        condition.setChannelType(channelType);
        List<CompanyChannel> list = companyChannelDAO.selectList(condition);
        if (CollectionUtils.isEmpty(list)) {
            throw new BizException("xn000000", "获取支付渠道配置失败，请仔细检查配置信息");
        }
        return list.get(0);
    }
}
