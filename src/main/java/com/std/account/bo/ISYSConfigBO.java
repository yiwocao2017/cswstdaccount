/**
 * @Title ISYSConfigBO.java 
 * @Package com.xnjr.moom.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午2:40:52 
 * @version V1.0   
 */
package com.std.account.bo;

import java.util.Map;

import com.std.account.bo.base.IPaginableBO;
import com.std.account.domain.SYSConfig;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午2:40:52 
 * @history:
 */
public interface ISYSConfigBO extends IPaginableBO<SYSConfig> {
    public int refreshSYSConfig(Long id, String cvalue, String updater,
            String remark);

    public SYSConfig getSYSConfig(Long id);

    /**
     * systemCode=companyCode时调用此方法
     * @param systemCode
     * @return 
     * @create: 2017年3月22日 下午3:45:36 myb858
     * @history:
     */
    public Map<String, String> getConfigsMap(String systemCode);

    /**
     * systemCode=companyCode时调用此方法
     * @param key
     * @param systemCode
     * @return 
     * @create: 2017年3月22日 下午3:45:54 myb858
     * @history:
     */
    public String getSYSConfig(String key, String systemCode);

    public SYSConfig getSYSConfig(String key, String companyCode,
            String systemCode);

    // 获取人民币对正汇贡献值：1人民币=多少正汇贡献值
    public Double getCNY2GXZ();

    // 获取人民币对正汇分润配置值：1人民币=多少正汇分润
    public Double getCNY2FRB();

    // 获取人民币对菜狗币配置值：1人民币=多少菜狗币
    public Double getCNY2CGB();

    // 获取人民币对菜狗币配置值：1红包币=多少贡献值
    public Double getHBB2GXZ();

    // 获取人民币对菜狗币配置值：1红包业绩=多少贡献值
    public Double getHBYJ2GXZ();

    // 获取人民币对菜狗币配置值：1菜狗币=多少菜狗积分
    public Double getCGB2CGJF();

}
