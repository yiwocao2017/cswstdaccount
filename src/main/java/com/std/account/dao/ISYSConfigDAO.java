/**
 * @Title ISYSConfigDAO.java 
 * @Package com.xnjr.moom.dao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 上午10:19:51 
 * @version V1.0   
 */
package com.std.account.dao;

import com.std.account.dao.base.IBaseDAO;
import com.std.account.domain.SYSConfig;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 上午10:19:51 
 * @history:
 */
public interface ISYSConfigDAO extends IBaseDAO<SYSConfig> {
    String NAMESPACE = ISYSConfigDAO.class.getName().concat(".");

    public int updateValue(SYSConfig data);
}
