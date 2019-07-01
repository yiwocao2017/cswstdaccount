package com.std.account.bo;

import java.util.List;

import com.std.account.bo.base.IPaginableBO;
import com.std.account.domain.CompanyChannel;
import com.std.account.enums.EChannelType;

public interface ICompanyChannelBO extends IPaginableBO<CompanyChannel> {
    /**
     * 获取最优且可行的渠道
     * @param companyCode 公司编号
     * @param payType 支付类型
     * @return 
     * @create: 2016年11月16日 下午8:05:39 myb858
     * @history:
     */
    public EChannelType getBestChannel(String companyCode,
            EChannelType channelType);

    /**
     * 获取最优且可行的渠道
     * @param companyCode
     * @param channelTypeList
     * @return 
     * @create: 2016年12月23日 下午9:21:14 xieyj
     * @history:
     */
    public EChannelType getBestChannel(String companyCode,
            List<String> channelTypeList);

    public void transAmountPC(String companyCode, EChannelType channelType,
            Long transAmount, String order, String bankCode);

    public boolean isCompanyChannelExist(Long id);

    public long getCompanyChannelCount(String companyCode, String channelType);

    public Long saveCompanyChannel(CompanyChannel data);

    public int removeCompanyChannel(Long id);

    public int refreshCompanyChannel(CompanyChannel data);

    public List<CompanyChannel> queryCompanyChannelList(CompanyChannel condition);

    public CompanyChannel getCompanyChannel(Long id);

    public CompanyChannel getCompanyChannel(String companyCode,
            String systemCode, String channelType);

}
