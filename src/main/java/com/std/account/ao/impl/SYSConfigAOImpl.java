package com.std.account.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.account.ao.ISYSConfigAO;
import com.std.account.bo.ISYSConfigBO;
import com.std.account.bo.base.Paginable;
import com.std.account.domain.SYSConfig;

/**
 * @author: Gejin 
 * @since: 2016年4月17日 下午7:32:28 
 * @history:
 */
@Service
public class SYSConfigAOImpl implements ISYSConfigAO {
    @Autowired
    ISYSConfigBO sysConfigBO;

    @Override
    public void editSYSConfig(Long id, String cvalue, String updater,
            String remark) {
        sysConfigBO.refreshSYSConfig(id, cvalue, updater, remark);
    }

    @Override
    public Paginable<SYSConfig> querySYSConfigPage(int start, int limit,
            SYSConfig condition) {
        return sysConfigBO.getPaginable(start, limit, condition);
    }

    @Override
    public SYSConfig getSYSConfig(Long id) {
        return sysConfigBO.getSYSConfig(id);
    }

    @Override
    public SYSConfig getSYSConfig(String key, String companyCode,
            String systemCode) {
        return sysConfigBO.getSYSConfig(key, companyCode, systemCode);
    }
}
