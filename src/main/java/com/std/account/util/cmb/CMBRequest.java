package com.std.account.util.cmb;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 */

/**
 * @author haiqingzheng
 *
 */
public class CMBRequest {

    // 函数名
    private String functionName;

    // 数据格式（固定为2）
    private String dateType;

    // 前置机登录用户名
    private String loginName;

    private List<CMBBizRequest> bizRequests;

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public List<CMBBizRequest> getBizRequests() {
        return bizRequests;
    }

    public void setBizRequests(List<CMBBizRequest> bizRequests) {
        this.bizRequests = bizRequests;
    }

    public String getRequestXML() {
        String xml = "<?xml version=\"1.0\" encoding=\"GBK\"?>";
        xml += "<CMBSDKPGK>";
        xml += "<INFO>";
        xml += "<FUNNAM>" + functionName + "</FUNNAM>";
        xml += "<DATTYP>" + dateType + "</DATTYP>";
        xml += "<LGNNAM>" + loginName + "</LGNNAM>";
        xml += " </INFO>";
        for (CMBBizRequest bizRequest : bizRequests) {
            xml += "<" + bizRequest.getBizName() + ">";
            Set<String> keys = bizRequest.getBizParams().keySet();
            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                xml += "<" + key + ">" + bizRequest.getBizParams().get(key)
                        + "</" + key + ">";
            }
            xml += "</" + bizRequest.getBizName() + ">";
        }

        xml += "</CMBSDKPGK>";
        System.out.println(xml);
        return xml;
    }
}
