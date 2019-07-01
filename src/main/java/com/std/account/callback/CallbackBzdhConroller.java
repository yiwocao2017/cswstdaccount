package com.std.account.callback;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.std.account.ao.IExchangeCurrencyAO;
import com.std.account.enums.EBizType;

/**
 * 币种兑换回调控制层
 * @author: xieyj 
 * @since: 2017年4月20日 下午5:00:52 
 * @history:
 */
@Controller
public class CallbackBzdhConroller {

    private static Logger logger = Logger
        .getLogger(CallbackBzdhConroller.class);

    @Autowired
    IExchangeCurrencyAO exchangeCurrencyAO;

    // 自身支付回调
    @RequestMapping("/bzdh/callback")
    public synchronized void doCallbackPay(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        boolean isSuccess = Boolean.valueOf(request.getParameter("isSuccess"));
        String payGroup = request.getParameter("payGroup");
        String payCode = request.getParameter("payCode");
        Long amount = Long.valueOf(request.getParameter("transAmount"));
        String bizType = request.getParameter("bizType");
        // 支付成功，商户处理后同步返回给微信参数
        if (!isSuccess) {
            logger.info("支付失败");
        } else {
            logger.info("===============付款成功==============");
            // ------------------------------
            // 处理业务开始
            // ------------------------------
            try {
                if (EBizType.AJ_CGBGM.getCode().equals(bizType)) {
                    System.out.println("**** 进入菜狗币购买售卖，服务器回调 start****");
                    exchangeCurrencyAO.paySuccess(payGroup, payCode, amount);
                    System.out.println("**** 进入菜狗币购买售卖，服务器回调 end****");
                } else if (EBizType.EXCHANGE_CURRENCY.getCode().equals(bizType)) {
                    System.out.println("**** 进入币种兑换，服务器回调 start****");
                    exchangeCurrencyAO.paySuccess(payGroup, payCode, amount);
                    System.out.println("**** 进入币种兑换，服务器回调 end****");
                }
            } catch (Exception e) {
                logger.info("支付回调异常,原因：" + e.getMessage());
            }
        }
    }
}
