package com.std.account.bo;

import com.std.account.domain.User;
import com.std.account.enums.EUserKind;

/**
 * @author: xieyj 
 * @since: 2016年5月30日 上午9:28:13 
 * @history:
 */
public interface IUserBO {
    public User getRemoteUser(String userId);

    /**
     * 校验支付密码
     * @param userId 用户编号在所有的系统中唯一
     * @param tradePwd
     * @return 
     * @create: 2015年11月10日 上午9:16:42 myb858
     * @history:
     */
    public void checkTradePwd(String userId, String tradePwd);

    /**
     * 根据手机号获取用户编号
     * @param mobile
     * @param kind
     * @param systemCode
     * @return 
     * @create: 2016年12月28日 上午10:09:53 xieyj
     * @history:
     */
    public String isUserExist(String mobile, EUserKind kind, String systemCode);
}
