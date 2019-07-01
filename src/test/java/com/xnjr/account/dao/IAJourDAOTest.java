/**
 * @Title IIAJourDAOTest.java 
 * @Package com.ibis.account.dao 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午2:27:03 
 * @version V1.0   
 */
package com.xnjr.account.dao;

import org.unitils.spring.annotation.SpringBeanByType;

import com.std.account.dao.IJourDAO;
import com.xnjr.account.base.ADAOTest;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午2:27:03 
 * @history:
 */
public class IAJourDAOTest extends ADAOTest {
    @SpringBeanByType
    private IJourDAO jourDAO;

    // @Test
    // public void insert() {
    // AccountJour data = new AccountJour();
    // // data.setAjNo(1L);
    // data.setStatus(EOrderStatus.PAY_YES.getCode());
    // data.setBizType(EBizType.AJ_CZ.getCode());
    // data.setRefNo("");
    // data.setTransAmount(1L);
    //
    // data.setPreAmount(0L);
    // data.setPostAmount(1L);
    // data.setRemark("test");
    // data.setCreateDatetime(new Date());
    // data.setWorkDate("20150219");
    //
    // data.setAccountNumber("1");
    // int lineNum = aJourDAO.insert(data);
    // logger.info("insert : {}", lineNum);
    // }
    //
    // @Test
    // public void select() {
    // AccountJour data = new AccountJour();
    // data.setAjNo(1L);
    // data = aJourDAO.select(data);
    // logger.info("select : {}", data);
    // }
    //
    // @Test
    // public void selectTotalCount() {
    // AccountJour data = new AccountJour();
    // data.setAjNo(1L);
    // long id = aJourDAO.selectTotalCount(data);
    // logger.info("selectTotalCount : {}", id);
    // }
    //
    // @Test
    // public void selectList() {
    // AccountJour data = new AccountJour();
    // data.setAjNo(1L);
    // List<AccountJour> dataList = aJourDAO.selectList(data);
    // logger.info("selectList : {}", dataList);
    // }
    //
    // @Test
    // public void selectPage() {
    // AccountJour data = new AccountJour();
    // data.setAjNo(1L);
    // List<AccountJour> dataList = aJourDAO.selectList(data, 0, 1);
    // logger.info("selectPage : {}", dataList);
    // }
    //
    // @Test
    // public void doCheckAccount() {
    // AccountJour data = new AccountJour();
    // data.setAjNo(1L);
    // data.setStatus(EAccountJourStatus.todoCheck.getCode());
    // data.setCheckUser(EUser.LI.getCode());
    // data.setCheckDatetime(new Date());
    // data.setRemark("test check");
    // int count = aJourDAO.doCheckAccount(data);
    // logger.info("doCheckAccount : {}", count);
    // }
}
