package com.std.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class CallbackServlet extends HttpServlet {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1692388053536824054L;

    static Logger logger = Logger.getLogger(CallbackServlet.class);

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        logger.info("Successful Deployment");
        PrintWriter writer = response.getWriter();
        writer.append("Version:1.2.0 \n");
        writer.append("Description:four \n");
        writer.flush();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("**** 进入富友充值服务器回调 ****");
        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("VERSION", request.getParameter("VERSION"));
        resultMap.put("TYPE", request.getParameter("￼TYPE"));
        resultMap.put("RESPONSECODE", request.getParameter("RESPONSECODE"));
        resultMap.put("RESPONSEMSG", request.getParameter("RESPONSEMSG"));
        resultMap.put("MCHNTCD", request.getParameter("MCHNTCD"));
        resultMap.put("MCHNTORDERID", request.getParameter("MCHNTORDERID"));
        resultMap.put("ORDERID", request.getParameter("ORDERID"));
        resultMap.put("BANKCARD", request.getParameter("BANKCARD"));
        resultMap.put("AMT", request.getParameter("AMT"));
        resultMap.put("SIGN", request.getParameter("SIGN"));
        System.out.println(resultMap.get("VERSION"));
    }

}
