package com.std.account.ao;

import com.std.account.bo.base.Paginable;
import com.std.account.domain.SYSConfig;

/**
 * 
 * @author: Gejin 
 * @since: 2016年4月17日 下午7:00:47 
 * @history:
 */
public interface ISYSConfigAO {

    String DEFAULT_ORDER_COLUMN = "id";

    public void editSYSConfig(Long id, String cvalue, String updater,
            String remark);

    public Paginable<SYSConfig> querySYSConfigPage(int start, int limit,
            SYSConfig condition);

    public SYSConfig getSYSConfig(Long id);

    public SYSConfig getSYSConfig(String key, String companyCode,
            String systemCode);
}
