package com.std.account.ao.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.std.account.ao.IBaofooAO;
import com.std.account.common.JsonUtil;
import com.std.account.domain.BaofooPC;
import com.std.account.domain.BaofooResult;
import com.std.account.domain.BaofooWAP;
import com.std.account.domain.ChannelCompany;
import com.std.account.dto.req.XN802160Req;
import com.std.account.dto.req.XN802161Req;
import com.std.account.dto.req.XN802162Req;
import com.std.account.dto.req.XN802163Req;
import com.std.account.dto.req.XN802164Req;
import com.std.account.dto.res.ChannelCallbackRes;
import com.std.account.exception.BizException;
import com.std.account.util.MD5;
import com.std.account.util.baofoo.RsaCodingUtil;
import com.std.account.util.baofoo.SecurityUtil;

@Service
public class BaofooAOImpl implements IBaofooAO {
    // @Autowired
    // IChannelCompanyBO channelCompanyBO;

    @Override
    public String getWapPayUrl(XN802163Req req) {
        BaofooWAP baofooWap = new BaofooWAP();
        // ChannelCompany channelCompany = channelCompanyBO.getChannelCompany(
        // req.getCompanyCode(), EChannelType.Baofoo, EPayType.WAP);
        ChannelCompany channelCompany = getWAPCompany();
        // 开始组装
        String memberId = channelCompany.getPaycompany();// 商户号
        String terminalId = channelCompany.getTerminalId();
        String pfxPath = this.getClass().getResource("/").getPath()
                + baofooWap.getPfxPath();
        String pfxPwd = baofooWap.getPfxPwd();
        String tradeDate = req.getTradeDate();
        String version = baofooWap.getVersion();
        String inputCharset = baofooWap.getInputCharset();
        String language = baofooWap.getLanguage();
        String txnType = baofooWap.getTxnType();
        String txnSubType = baofooWap.getTxnSubType();
        String dataType = baofooWap.getDataType();

        String transId = req.getTransId();
        String txnAmt = req.getTxnAmt();
        String payCode = req.getPayCode();
        String accNo = req.getAccNo();
        String idCard = req.getIdCard();
        String idHolder = req.getIdHolder();
        String mobile = req.getMobile();
        String pageUrl = channelCompany.getPageUrl();
        String returnUrl = channelCompany.getBackUrl();
        String backUrl = channelCompany.getErrorUrl();
        String urlString = recharge(transId, txnAmt, payCode, accNo, idCard,
            idHolder, mobile, memberId, terminalId, pageUrl, returnUrl,
            backUrl, pfxPath, pfxPwd, tradeDate, version, inputCharset,
            language, txnType, txnSubType, dataType);
        return baofooWap.getPayUrl() + urlString;
    }

    private ChannelCompany getWAPCompany() {
        ChannelCompany company = new ChannelCompany();
        company.setPaycompany("");
        company.setPrivatekey("");
        company.setTerminalId("");
        company.setPageUrl("");
        company.setBackUrl("");
        company.setErrorUrl("");
        return company;
    }

    private ChannelCompany getPCCompany() {
        ChannelCompany company = new ChannelCompany();
        company.setPaycompany("");
        company.setPrivatekey("");
        company.setTerminalId("");
        company.setPageUrl("");
        company.setBackUrl("");
        company.setErrorUrl("");
        return company;
    }

    @Override
    public String getPCPayUrl(XN802160Req req) {
        BaofooPC baofooPC = new BaofooPC();
        // ChannelCompany channelCompany = channelCompanyBO.getChannelCompany(
        // req.getCompanyCode(), EChannelType.Baofoo, EPayType.PC);
        ChannelCompany channelCompany = getPCCompany();
        // 开始组装
        String MemberID = channelCompany.getPaycompany();// 商户号
        String PayID = req.getPayId();// 功能ID
        String TradeDate = req.getTradeDate();// 下单日期
        String TransID = req.getTransId();// 商户流水号
        String OrderMoney = req.getOrderMoney();// 订单金额
        if (!"".equals(OrderMoney)) {
            BigDecimal a;
            a = new BigDecimal(OrderMoney).multiply(BigDecimal.valueOf(0.1)); // 使用分进行提交
            OrderMoney = String.valueOf(a.setScale(0));
        } else {
            OrderMoney = ("0");
        }
        // String RequestType = request.getParameter("RequestType");
        // if("1".equals(RequestType)) {
        // PayID = "";
        // }
        // String ProductName = request.getParameter("ProductName");//商品名称
        // String Amount = request.getParameter("Amount");//商品数量
        // String Username = request.getParameter("Username");//支付用户名称
        // String AdditionalInfo =
        // request.getParameter("AdditionalInfo");//订单附加信息
        String PageUrl = channelCompany.getPageUrl();// 通知商户页面端地址
        String ReturnUrl = channelCompany.getBackUrl();// 服务器底层通知地址
        String NoticeType = baofooPC.getNoticeType();// 通知类型
        String Md5key = channelCompany.getPrivatekey();// md5密钥（KEY）
        String MARK = "|";
        String md5String = new String(MemberID + MARK + PayID + MARK
                + TradeDate + MARK + TransID + MARK + OrderMoney + MARK
                + PageUrl + MARK + ReturnUrl + MARK + NoticeType + MARK
                + Md5key);// MD5签名格式
        String Signature = MD5.MD5Encode(md5String);// 计算MD5值
        String payUrl = baofooPC.getPayUrl();// 借贷混合
        String TerminalID = channelCompany.getTerminalId();
        String InterfaceVersion = baofooPC.getInterfaceVersion();
        String KeyType = baofooPC.getKeyType();// 加密类型

        return payUrl + "?MemberID=" + MemberID + "&TerminalID=" + TerminalID
                + "&InterfaceVersion=" + InterfaceVersion + "&KeyType="
                + KeyType + "&PayID=" + PayID + "&TradeDate=" + TradeDate
                + "&TransID=" + TransID + "&OrderMoney=" + OrderMoney
                + "&PageUrl=" + PageUrl + "&ReturnUrl=" + ReturnUrl
                + "&Signature=" + Signature + "&NoticeType=" + NoticeType;
    }

    @Override
    public ChannelCallbackRes handleWAPPay(XN802164Req req) {
        BaofooWAP baofooWap = new BaofooWAP();
        // 开始解析
        String cerPath = this.getClass().getResource("/").getPath()
                + baofooWap.getCerPath();
        String dataContent = req.getDataContent();
        if (StringUtils.isBlank(dataContent)) {
            throw new BizException("xn798000", "回调解析入参有误");
        }
        String result = baofooReturn(dataContent, cerPath);
        if (result == null) {
            throw new BizException("xn798000", "返回结果解密出现异常");
        }
        // 返回
        ChannelCallbackRes res = new ChannelCallbackRes();
        BaofooResult baofooResult = JsonUtil.json2Bean(result,
            BaofooResult.class);
        res.setCompanyOrderNo(baofooResult.getTrans_id());
        res.setChannelOrderNo(baofooResult.getTrans_no());
        if ("0000".equalsIgnoreCase(baofooResult.getResp_code())) {
            res.setIsSuccess(true);
            res.setErrorInfo("成功");
        } else {
            res.setIsSuccess(false);
            res.setErrorInfo(baofooResult.getResp_msg());
        }
        return res;
    }

    @Override
    public String handlePCPay(XN802162Req req) {
        ChannelCompany channelCompany = getPCCompany();
        if ("1".equalsIgnoreCase(req.getResult())) {
            return channelCompany.getPageUrl();
        }
        return channelCompany.getErrorUrl();
    }

    @Override
    public ChannelCallbackRes handlePCPay(XN802161Req req) {
        // ChannelCompany channelCompany = channelCompanyBO.getChannelCompany(
        // req.getCompanyCode(), EChannelType.Baofoo, EPayType.PC);
        ChannelCompany channelCompany = getPCCompany();
        // 开始解析
        String MemberID = req.getMemberID();// 商户号
        String TerminalID = req.getTerminalID();// 商户终端号
        String TransID = req.getTransID();// 商户流水号
        String Result = req.getResult();// 支付结果
        String ResultDesc = req.getResultDesc();// 支付结果描述
        String factMoney = req.getFactMoney();// 实际成功金额，以分为单位
        // String a = new BigDecimal(factMoney).divide(BigDecimal.valueOf(100))
        // .setScale(2).toString(); // 使用元显示
        // String FactMoney = a;
        String AdditionalInfo = req.getAdditionalInfo();// 订单附加消息
        String SuccTime = req.getSuccTime();// 支付完成时间
        String Md5Sign = req.getMd5Sign();// MD5签名
        // 验证数据合法性
        String Md5key = channelCompany.getPrivatekey();// md5密钥（KEY）
        String MARK = "~|~";
        String md5String = "MemberID=" + MemberID + MARK + "TerminalID="
                + TerminalID + MARK + "TransID=" + TransID + MARK + "Result="
                + Result + MARK + "ResultDesc=" + ResultDesc + MARK
                + "FactMoney=" + factMoney + MARK + "AdditionalInfo="
                + AdditionalInfo + MARK + "SuccTime=" + SuccTime + MARK
                + "Md5Sign=" + Md5key;
        String WaitSign = MD5.MD5Encode(md5String);// 计算MD5值
        if (WaitSign.compareTo(Md5Sign) != 0) {
            throw new BizException("xn798000", "宝付PC端支付回调返回数据非法");
        }
        ChannelCallbackRes res = new ChannelCallbackRes();
        res.setChannelOrderNo(TransID);
        res.setCompanyOrderNo(TransID);
        if ("1".equalsIgnoreCase(Result)) {
            res.setIsSuccess(true);
            res.setErrorInfo("支付成功");
        } else {
            res.setIsSuccess(false);
            String lbresultDesc = getErrorInfo(Result, ResultDesc);// 支付结果文字描述
            res.setErrorInfo(lbresultDesc);
        }
        return res;
    }

    private String baofooReturn(String returnDate, String cerPath) {
        // 宝付回复密文。。先公钥解密，后base64解密
        String result = "";
        if (returnDate.length() % 128 == 0) {
            returnDate = RsaCodingUtil.decryptByPubCerFile(returnDate.trim(),
                cerPath);
            try {
                result = SecurityUtil.Base64Decode(returnDate);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("[解密报文]:" + result);
        } else {
            result = returnDate;
        }
        return result;
    }

    private String getErrorInfo(String result, String resultDesc) {
        String retInfo = "";
        int a;
        int b;
        if (!"".equals(result)) {
            a = Integer.parseInt(result);
        } else {
            a = 0;
        }
        if (!"".equals(resultDesc)) {
            b = Integer.parseInt(resultDesc);
        } else {
            b = 0;
        }

        if (a == 1) {
            retInfo = "支付成功";
            return retInfo;
        } else {
            switch (b) {
                case 0:
                    retInfo = "充值失败";
                    break;
                case 1:
                    retInfo = "系统错误";
                    break;
                case 2:
                    retInfo = "订单超时";
                    break;
                case 11:
                    retInfo = "系统维护";
                    break;
                case 12:
                    retInfo = "无效商户";
                    break;
                case 13:
                    retInfo = "余额不足";
                    break;
                case 14:
                    retInfo = "超过支付限额";
                    break;
                case 15:
                    retInfo = "卡号或卡密错误";
                    break;
                case 16:
                    retInfo = "不合法的IP地址";
                    break;
                case 17:
                    retInfo = "重复订单金额不符";
                    break;
                case 18:
                    retInfo = "卡密已被使用";
                    break;
                case 19:
                    retInfo = "订单金额错误";
                    break;
                case 20:
                    retInfo = "支付的类型错误";
                    break;
                case 21:
                    retInfo = "卡类型有误";
                    break;
                case 22:
                    retInfo = "卡信息不完整";
                    break;
                case 23:
                    retInfo = "卡号，卡密，金额不正确";
                    break;
                case 24:
                    retInfo = "不能用此卡继续做交易";
                    break;
                case 25:
                    retInfo = "订单无效";
                    break;
                case 26:
                    retInfo = "卡无效";
                    break;
                default:
                    retInfo = "支付失败";
                    break;
            }

            return retInfo;
        }
    }

    private String recharge(String transId, String txnAmt, String payCode,
            String accNo, String idCard, String idHolder, String mobile,
            String memberId, String terminalId, String pageUrl,
            String returnUrl, String backUrl, String pfxPath, String pfxPwd,
            String tradeDate, String version, String inputCharset,
            String language, String txnType, String txnSubType, String dataType) {
        if (!"".equals(txnAmt)) {
            BigDecimal a;
            a = new BigDecimal(txnAmt).multiply(BigDecimal.valueOf(0.1)); // 使用分进行提交
            txnAmt = String.valueOf(a.setScale(0));
        } else {
            txnAmt = ("0");
        }

        // 1、拼接报文==========================================
        String dataContent = "";
        if (dataType == "xml") {
            dataContent = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> "
                    + "<data_content>" + "<txn_sub_type>01</txn_sub_type> "
                    + "<biz_type>0000</biz_type> " + "<terminal_id>"
                    + terminalId
                    + "</terminal_id> "
                    + "<member_id>"
                    + memberId
                    + "</member_id> "
                    + "<pay_code>"
                    + payCode
                    + "</pay_code> "
                    + "<acc_no>"
                    + accNo
                    + "</acc_no> "
                    + "<id_card_type>01</id_card_type> "
                    + "<id_card>"
                    + idCard
                    + "</id_card> "
                    + "<id_holder>"
                    + idHolder
                    + "</id_holder> "
                    + "<mobile>"
                    + mobile
                    + "</mobile> "
                    + "<valid_date /> "
                    + "<valid_no /> "
                    + "<trans_id>"
                    + transId
                    + "</trans_id> "
                    + "<txn_amt>"
                    + txnAmt
                    + "</txn_amt> "
                    + "<trade_date>"
                    + tradeDate
                    + "</trade_date> "
                    + "<commodity_name>商品名称</commodity_name> "
                    + "<commodity_amount>1</commodity_amount> "
                    + "<user_name>用户名</user_name> "
                    + "<page_url>"
                    + pageUrl
                    + "</page_url> "
                    + "<return_url>"
                    + returnUrl
                    + "</return_url> "
                    +
                    /*
                     * "<back_url>"+$("input[name=back_url]").val()+
                     * "</back_url> "+
                     */
                    "<additional_info>helloWorld</additional_info> "
                    + "<req_reserved>附加字段</req_reserved> " + "</data_content>";
        } else {
            dataContent = "{" + "\"txn_sub_type\":\"" + txnSubType + "\","
                    + "\"biz_type\":\"0000\"," + "\"terminal_id\":\""
                    + terminalId + "\"," + "\"member_id\":\"" + memberId
                    + "\"," + "\"pay_code\":\"" + payCode + "\","
                    + "\"acc_no\":\"" + accNo + "\","
                    + "\"id_card_type\":\"01\"," + "\"id_card\":\"" + idCard
                    + "\"," + "\"id_holder\":\"" + idHolder + "\","
                    + "\"mobile\":\"" + mobile + "\"," + "\"valid_date\":\"\","
                    + "\"valid_no\":\"\"," + "\"trans_id\":\"" + transId
                    + "\"," + "\"txn_amt\":\"" + txnAmt + "\","
                    + "\"trade_date\":\"" + tradeDate + "\","
                    + "\"commodity_name\":\"商品名称\","
                    + "\"commodity_amount\":\"1\"," + "\"user_name\":\"用户名\","
                    + "\"additional_info\":\"helloWorld\","
                    + "\"req_reserved\":\"附加字段\"," + "\"page_url\":\""
                    + pageUrl + "\"," +
                    /* "\"back_url\":\""+ +"\","+ */
                    "\"return_url\":\"" + returnUrl + "\"" + "}";
        }
        // 商户私钥加密。先base64 加密，然后 RSA私钥加密
        String base64str = null;
        try {
            base64str = SecurityUtil.Base64Encode(dataContent);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dataContent = RsaCodingUtil.encryptByPriPfxFile(base64str, pfxPath,
            pfxPwd);

        String params = "version=%s&input_charset=%s&language=%s&terminal_id=%s&txn_type=%s&txn_sub_type=%s&member_id=%s&data_type=%s&back_url=%s&data_content=%s";
        params = String.format(params, version, inputCharset, language,
            terminalId, txnType, txnSubType, memberId, dataType, backUrl,
            dataContent);
        // ================ POST 提交 =====================
        System.out.println("?" + params);
        return "?" + params;
    }

}
