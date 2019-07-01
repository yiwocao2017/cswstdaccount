/**
 * @Title CMBBOImpl.java 
 * @Package com.std.account.bo.impl 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年3月1日 下午4:34:41 
 * @version V1.0   
 */
package com.std.account.bo.impl;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;

import com.std.account.bo.ICMBBO;
import com.std.account.core.OrderNoGenerater;
import com.std.account.domain.ChannelBank;
import com.std.account.domain.CompanyChannel;
import com.std.account.enums.EGeneratePrefix;
import com.std.account.util.cmb.CMBRequest;
import com.std.account.util.cmb.CMBUtil;

/** 
 * @author: haiqingzheng 
 * @since: 2017年3月1日 下午4:34:41 
 * @history:
 */
public class CMBBOImpl implements ICMBBO {

    static Logger logger = Logger.getLogger(CMBBOImpl.class);

    @Override
    public String pay(String accountNo, String accountName,
            ChannelBank channelBank, Long amount, String remark,
            CompanyChannel companyChannel) {
        // 生成本次代付的业务参考号，本系统唯一
        String bizOrderNo = OrderNoGenerater
            .generate(EGeneratePrefix.CMB_BIZ_NO.getCode());

        CMBRequest cmbRequest = CMBUtil.getPayRequest(bizOrderNo,
            companyChannel.getChannelCompany(),
            companyChannel.getPrivateKey1(), companyChannel.getPrivateKey2(),
            amount, remark, accountNo, accountName, channelBank.getBankName());
        String response = CMBUtil.doPost(companyChannel.getPrivateKey3(),
            cmbRequest);

        // 请求结果解析
        String RETCOD = Jsoup.parse(response).select("RETCOD").html();
        String REQSTS = Jsoup.parse(response).select("REQSTS").html();
        String RTNFLG = Jsoup.parse(response).select("RTNFLG").html();
        String YURREF = Jsoup.parse(response).select("YURREF").html();
        logger.info("银企直联直接支付返回结果： RETCOD=" + RETCOD + " REQSTS=" + REQSTS
                + " RTNFLG=" + RTNFLG + " YURREF=" + YURREF);
        if ("0".equals(RETCOD)) {
            if ("FIN".equals(REQSTS) && "F".equals(RTNFLG)) {
                logger.info("支付失败");
            } else {
                logger.info("支付已被银行受理");
            }
        } else if ("-9".equals(RETCOD) || "-1".equals(RETCOD)) {
            logger.info("交易可疑，请查询支付结果");
        } else {
            logger.info("交易请求失败");
        }
        return bizOrderNo;
    }
}
