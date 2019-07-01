package com.std.account.dao;

import com.std.account.dao.base.IBaseDAO;
import com.std.account.domain.Jour;

/**
 * @author: xieyj 
 * @since: 2016年12月23日 上午11:25:21 
 * @history:
 */
public interface IJourDAO extends IBaseDAO<Jour> {
    String NAMESPACE = IJourDAO.class.getName().concat(".");

    /**
     * 金额发生变动
     * @param data
     * @return 
     * @create: 2016年11月10日 下午6:05:41 xieyj
     * @history:
     */
    public int updateCallback(Jour data);

    /**
     * 对账结果录入
     * @param data
     * @return 
     * @create: 2016年11月10日 下午6:05:41 xieyj
     * @history:
     */
    public int updateCheck(Jour data);

    /**
     * 调账结果录入
     * @param data
     * @return 
     * @create: 2016年11月10日 下午6:05:47 xieyj
     * @history:
     */
    public int updateAdjust(Jour data);

    /**
     * 原调账记录状态更新
     * @param data
     * @return 
     * @create: 2016年12月26日 下午9:29:23 xieyj
     * @history:
     */
    public int updateAdjustStatus(Jour data);
}
