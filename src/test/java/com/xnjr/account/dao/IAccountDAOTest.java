/**
 * @Title IAccountDAOTest.java 
 * @Package com.ibis.account.dao 
 * @Description 
 * @author miyb  
 * @date 2015-2-25 下午4:41:52 
 * @version V1.0   
 */
package com.xnjr.account.dao;

import org.unitils.spring.annotation.SpringBeanByType;

import com.std.account.dao.IAccountDAO;
import com.xnjr.account.base.ADAOTest;

/** 
 * @author: miyb 
 * @since: 2015-2-25 下午4:41:52 
 * @history:
 */
public class IAccountDAOTest extends ADAOTest {
    @SpringBeanByType
    private IAccountDAO accountDAO;

    // @Test
    // public void insert() {
    // Account data = new Account();
    // data.setUserId("miyb");
    // data.setUserId("宓永宝");
    // data.setAccountNumber("1");
    // data.setStatus(EAccountStatus.NORMAL.getCode());
    // data.setAmount(0L);
    //
    // data.setFrozenAmount(0L);
    // data.setCurrency("CNY");
    // data.setMd5(AccountUtil.md5(data.getAmount()));
    // data.setCreateDatetime(new Date());
    // int lineNum = accountDAO.insert(data);
    // logger.info("insert : {}", lineNum);
    // }
    //
    // @Test
    // public void select() {
    // Account data = new Account();
    // data.setAccountNumber("1");
    // data = accountDAO.select(data);
    // logger.info("select : {}", data);
    // }
    //
    // @Test
    // public void selectTotalCount() {
    // Account data = new Account();
    // data.setAccountNumber("1");
    // long id = accountDAO.selectTotalCount(data);
    // logger.info("selectTotalCount : {}", id);
    // }
    //
    // @Test
    // public void selectList() {
    // Account data = new Account();
    // data.setAccountNumber("1");
    // List<Account> dataList = accountDAO.selectList(data);
    // logger.info("selectList : {}", dataList);
    // }
    //
    // @Test
    // public void selectPage() {
    // Account data = new Account();
    // data.setAccountNumber("1");
    // data.setOrder("account_number", true);
    // List<Account> dataList = accountDAO.selectList(data, 0, 1);
    // logger.info("selectPage : {}", dataList);
    // }
    //
    // @Test
    // public void updateAmount() {
    // Account data = new Account();
    // data.setAccountNumber("1");
    // data.setAmount(1L);
    // data.setMd5(AccountUtil.md5(data.getAmount()));
    // data.setUpdateDatetime(new Date());
    // int count = accountDAO.updateAmount(data);
    // logger.info("updateAmount : {}", count);
    // }
    //
    // @Test
    // public void updateFrozenAmount() {
    // Account data = new Account();
    // data.setAccountNumber("1");
    // data.setAmount(1L);
    // data.setFrozenAmount(1L);
    // data.setMd5(AccountUtil.md5(data.getAmount()));
    // data.setUpdateDatetime(new Date());
    // int count = accountDAO.updateFrozenAmount(data);
    // logger.info("updateFrozenAmount : {}", count);
    // }
    //
    // @Test
    // public void updateStatus() {
    // Account data = new Account();
    // data.setAccountNumber("1");
    // data.setStatus(EAccountStatus.LI_LOCK.getCode());
    // data.setUpdateDatetime(new Date());
    // int count = accountDAO.updateStatus(data);
    // logger.info("updateStatus : {}", count);
    // }
}
