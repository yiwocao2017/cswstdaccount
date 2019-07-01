/**
 * @Title IWechatBO.java 
 * @Package com.std.account.bo 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年2月27日 下午3:14:48 
 * @version V1.0   
 */
package com.std.account.bo;

import com.std.account.domain.CompanyChannel;
import com.std.account.dto.res.XN002500Res;
import com.std.account.dto.res.XN002501Res;

/** 
 * @author: haiqingzheng 
 * @since: 2017年2月27日 下午3:14:48 
 * @history:
 */
public interface IWechatBO {
    public String getPrepayIdApp(CompanyChannel companyChannel, String bizNote,
            String code, Long transAmount, String ip, String backUrl);

    public XN002500Res getPayInfoApp(CompanyChannel companyChannel,
            String payCode, String prepayId);

    public String getPrepayIdH5(CompanyChannel companyChannel, String openId,
            String bizNote, String code, Long transAmount, String ip,
            String wxBackUrl, String bizBackUrl);

    public XN002501Res getPayInfoH5(CompanyChannel companyChannel,
            String payCode, String prepayId);

    public String getPrepayIdNative(CompanyChannel companyChannel,
            String bizNote, String code, Long transAmount, String ip,
            String backUrl);

}
