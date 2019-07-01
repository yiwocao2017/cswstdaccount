package com.std.account.bo;

import java.util.Date;
import java.util.List;

import com.std.account.bo.base.IPaginableBO;
import com.std.account.domain.Account;
import com.std.account.domain.Jour;
import com.std.account.enums.EBoolean;
import com.std.account.enums.EChannelType;

/**
 * @author: xieyj 
 * @since: 2016年12月23日 下午2:40:13 
 * @history:
 */
public interface IJourBO extends IPaginableBO<Jour> {

    /**
     * 新增未变动金额之流水
     * @param systemCode
     * @param accountNumber
     * @param channelType
     * @param payType
     * @param bizType
     * @param bizNote
     * @param transAmount
     * @return 
     * @create: 2016年12月23日 下午2:52:19 xieyj
     * @history:
     */
    public String addToChangeJour(String systemCode, String accountNumber,
            String channelType, String bizType, String bizNote,
            Long transAmount, String payGroup);

    public String addWithChangeJour(String systemCode, String accountNumber,
            String channelType, String bizType, String bizNote,
            Long transAmount, Long fee, String payGroup);

    /**
     * from线上划账成功回调处理流水(发生前金额，发生后金额不变)
     * @param data
     * @param rollbackUser
     * @param rollbackNote
     * @param channelOrder
     * @return 
     * @create: 2017年5月3日 下午1:04:33 xieyj
     * @history:
     */
    public int callBackFromChangeJour(Jour data, String rollbackUser,
            String rollbackNote, String channelOrder);

    /**
     * 线上充值/to线上划账回调处理流水(发生前金额，发生后金额内部设置)
     * @param data
     * @param rollBackResult
     * @param rollbackUser
     * @param rollbackNote
     * @param channelOrder
     * @return 
     * @create: 2017年5月3日 上午11:07:35 xieyj
     * @history:
     */
    public int callBackChangeJour(Jour data, String rollBackResult,
            String rollbackUser, String rollbackNote, String channelOrder);

    /**
     * 线下充值取现回调处理流水
     * @param data
     * @param rollbackResult
     * @param rollbackUser
     * @param rollbackNote
     * @param preAmount
     * @param postAmount
     * @return 
     * @create: 2017年5月3日 上午11:09:27 xieyj
     * @history:
     */
    public int callBackOffChangeJour(Jour data, String rollbackResult,
            String rollbackUser, String rollbackNote, Long preAmount,
            Long postAmount);

    /**
     * 新增已变动金额之流水
     * @param systemCode
     * @param accountNumber
     * @param channelType
     * @param channelOrder
     * @param payType
     * @param bizType
     * @param bizNote
     * @param preAmount
     * @param transAmount
     * @return 
     * @create: 2016年12月23日 下午2:48:40 xieyj
     * @history:
     */
    public String addChangedJour(String systemCode, String accountNumber,
            EChannelType channelType, String channelOrder, String bizType,
            String bizNote, Long preAmount, Long transAmount);

    /**
     * 对账结果录入
     * @param code
     * @param checkResult
     * @param checkUser
     * @param checkNote 
     * @create: 2016年12月25日 下午5:00:10 xieyj
     * @history:
     */
    public void doCheckJour(String code, EBoolean checkResult,
            String checkUser, String checkNote);

    /**
     * 产生调账订单
     * @param account
     * @param channelOrder
     * @param transAmount
     * @return 
     * @create: 2016年12月25日 下午5:06:48 xieyj
     * @history:
     */
    public String addAdjustJour(Account account, String channelOrder,
            Long transAmount);

    /**
     * 调账结果录入
     * @param code
     * @param adjustResult
     * @param adjustUser
     * @param adjustDate
     * @param adjustNote
     * @param preAmount
     * @param postAmount 
     * @create: 2016年12月26日 下午9:30:42 xieyj
     * @history:
     */
    public void doAdjustJour(String code, EBoolean adjustResult,
            String adjustUser, Date adjustDate, String adjustNote,
            Long preAmount, Long postAmount);

    /**
     * 需调账订单变更状态为已调账
     * @param code
     * @param adjustUser
     * @param adjustDate
     * @param adjustNote 
     * @create: 2016年12月26日 下午9:10:31 xieyj
     * @history:
     */
    public void refreshOrderStatus(String code, String adjustUser,
            Date adjustDate, String adjustNote);

    /**
     * 获取流水列表
     * @param data
     * @return 
     * @create: 2016年11月11日 上午10:52:08 xieyj
     * @history:
     */
    public List<Jour> queryJourList(Jour condition);

    /**
     * 判断申请记录是否存在
     * @param accountNumber
     * @param bizType 
     * @create: 2017年5月2日 下午2:24:39 xieyj
     * @history:
     */
    public void doCheckExistApplyJour(String accountNumber, String bizType);

    /**
     * 获取详情
     * @param code
     * @param systemCode
     * @return 
     * @create: 2016年12月24日 上午8:19:51 xieyj
     * @history:
     */
    public Jour getJour(String code, String systemCode);

    /**
     * 获取同一支付组号内，相对的一条流水信息
     * @param code 流水
     * @param payGroup
     * @return 
     * @create: 2017年3月23日 下午7:45:17 haiqingzheng
     * @history:
     */
    public Jour getRelativeJour(String code, String payGroup);

    /**
     * 统计发生金额
     * @param systemCode
     * @param userId
     * @param currency
     * @param bizType
     * @return 
     * @create: 2017年2月23日 下午11:16:05 xieyj
     * @history:
     */
    public Long getStatisticsTransAmount(String systemCode, String userId,
            String currency, String bizType);

}
