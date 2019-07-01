package com.std.account.callback;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.std.account.ao.IAlipayAO;
import com.std.account.ao.IWeChatAO;
import com.std.account.domain.CallbackResult;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月26日 下午1:44:16 
 * @history:
 */
@Controller
public class CallbackConroller {

    private static Logger logger = Logger.getLogger(CallbackConroller.class);

    @Autowired
    IWeChatAO weChatAO;

    @Autowired
    IAlipayAO alipayAO;

    // 微信APP支付回调
    @RequestMapping("/wechat/app/callback")
    public synchronized void doCallbackWechatAPP(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            // 获取回调参数
            PrintWriter out = response.getWriter();
            InputStream inStream = request.getInputStream();
            String result = getReqResult(out, inStream);
            logger.info("**** APP支付回调结果 ****：" + result);
            // 解析回调结果
            CallbackResult callbackResult = weChatAO.doCallbackAPP(result);
            // 回调业务biz，通知支付结果
            weChatAO.doBizCallback(callbackResult);
            // 通知微信服务器(我已收到请求，不用再继续回调我了)
            String noticeStr = setXML("SUCCESS", "");
            out.print(new ByteArrayInputStream(noticeStr.getBytes(Charset
                .forName("UTF-8"))));
        } catch (Exception e) {
            logger.info("APP支付回调异常,原因：" + e.getMessage());
        }
    }

    // 微信H5支付回调
    @RequestMapping("/wechat/H5/callback")
    public synchronized void doCallbackWechatH5(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            // 获取回调参数
            PrintWriter out = response.getWriter();
            InputStream inStream = request.getInputStream();
            String result = getReqResult(out, inStream);
            logger.info("**** 公众号支付回调结果 ****：" + result);
            // 解析回调结果
            CallbackResult callbackResult = weChatAO.doCallbackH5(result);
            // 回调业务biz，通知支付结果
            weChatAO.doBizCallback(callbackResult);
            // 通知微信服务器(我已收到请求，不用再继续回调我了)
            String noticeStr = setXML("SUCCESS", "");
            out.print(new ByteArrayInputStream(noticeStr.getBytes(Charset
                .forName("UTF-8"))));
        } catch (Exception e) {
            logger.info("公众号支付回调异常,原因：" + e.getMessage());
        }
    }

    // 微信H5充值回调
    @RequestMapping("/wechat/H5/callbackQz")
    public synchronized void doCallbackWechatH5Qz(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            // 获取回调参数
            PrintWriter out = response.getWriter();
            InputStream inStream = request.getInputStream();
            String result = getReqResult(out, inStream);
            logger.info("**** 公众号充值回调结果 ****：" + result);
            // 解析回调结果
            weChatAO.doCallbackH5Qz(result);
            // 通知微信服务器(我已收到请求，不用再继续回调我了)
            String noticeStr = setXML("SUCCESS", "");
            out.print(new ByteArrayInputStream(noticeStr.getBytes(Charset
                .forName("UTF-8"))));
        } catch (Exception e) {
            logger.info("公众号充值回调异常,原因：" + e.getMessage());
        }
    }

    // 微信扫码支付回调
    @RequestMapping("/wechat/native/callback")
    public synchronized void doCallbackWechatNative(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            // 获取回调参数
            PrintWriter out = response.getWriter();
            InputStream inStream = request.getInputStream();
            String result = getReqResult(out, inStream);
            logger.info("**** 扫码支付回调结果 ****：" + result);

            // 解析回调结果
            CallbackResult callbackResult = weChatAO.doCallbackNative(result);
            // 回调业务biz，通知支付结果
            weChatAO.doBizCallback(callbackResult);

            // 通知微信服务器(我已收到请求，不用再继续回调我了)
            String noticeStr = setXML("SUCCESS", "");
            out.print(new ByteArrayInputStream(noticeStr.getBytes(Charset
                .forName("UTF-8"))));
        } catch (Exception e) {
            logger.info("扫码支付支付回调异常,原因：" + e.getMessage());
        }
    }

    // 支付宝APP支付回调
    @RequestMapping("/alipay/app/callback")
    public synchronized void doCallbackAlipayAPP(HttpServletRequest request,
            HttpServletResponse response) {

        try {
            // 获取回调参数
            PrintWriter out = response.getWriter();
            InputStream inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inStream.close();
            String result = new String(outSteam.toByteArray(), "utf-8");
            logger.info("**** APP支付回调结果： ****：" + result);
            // 解析回调结果
            CallbackResult callbackResult = alipayAO.doCallbackAPP(result);
            logger.info("**** 回调业务biz参数： ****：" + callbackResult);
            // 回调业务biz，通知支付结果
            alipayAO.doBizCallback(callbackResult);
            // 通知支付宝服务器(我已收到请求，不用再继续回调我了)
            out.print("success");
        } catch (Exception e) {
            logger.info("APP支付回调异常,原因：" + e.getMessage());
        }
    }

    private String getReqResult(PrintWriter out, InputStream inStream)
            throws IOException {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return new String(outSteam.toByteArray(), "utf-8");
    }

    public String setXML(String return_code, String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code
                + "]]></return_code><return_msg><![CDATA[" + return_msg
                + "]]></return_msg></xml>";
    }
}
