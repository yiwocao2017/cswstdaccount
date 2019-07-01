package com.std.account.bo.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.std.account.bo.IUserBO;
import com.std.account.domain.User;
import com.std.account.dto.req.XN001100Req;
import com.std.account.dto.req.XN001102Req;
import com.std.account.dto.req.XN001400Req;
import com.std.account.dto.res.XN001102Res;
import com.std.account.dto.res.XN001400Res;
import com.std.account.enums.EUserKind;
import com.std.account.exception.BizException;
import com.std.account.http.BizConnecter;
import com.std.account.http.JsonUtils;

/**
 * @author: xieyj 
 * @since: 2016年5月30日 上午9:28:30 
 * @history:
 */
@Component
public class UserBOImpl implements IUserBO {

    @Override
    public void checkTradePwd(String userId, String tradePwd) {
        XN001100Req req = new XN001100Req();
        req.setTokenId(userId);
        req.setUserId(userId);
        req.setTradePwd(tradePwd);
        BizConnecter.getBizData("001100", JsonUtils.object2Json(req),
            Object.class);
    }

    @Override
    public String isUserExist(String mobile, EUserKind kind, String systemCode) {
        String userId = null;
        XN001102Req req = new XN001102Req();
        req.setMobile(mobile);
        req.setKind(kind.getCode());
        req.setSystemCode(systemCode);
        XN001102Res res = BizConnecter.getBizData("001102",
            JsonUtils.object2Json(req), XN001102Res.class);
        if (res != null) {
            userId = res.getUserId();
        }
        if (StringUtils.isBlank(userId)) {
            throw new BizException("xn0000", "手机号用户不存在");
        }
        return userId;
    }

    @Override
    public User getRemoteUser(String userId) {
        XN001400Req req = new XN001400Req();
        req.setTokenId(userId);
        req.setUserId(userId);
        XN001400Res res = BizConnecter.getBizData("001400",
            JsonUtils.object2Json(req), XN001400Res.class);
        if (res == null) {
            throw new BizException("XN000000", "编号为" + userId + "的用户不存在");
        }
        User user = new User();
        user.setUserId(res.getUserId());
        user.setMobile(res.getMobile());
        user.setOpenId(res.getOpenId());
        user.setCompanyCode(res.getCompanyCode());
        user.setSystemCode(res.getSystemCode());
        return user;
    }
}
