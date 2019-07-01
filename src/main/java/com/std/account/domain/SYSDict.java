/**
 * @Title SYSDict.java 
 * @Package com.xnjr.moom.domain 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月16日 下午9:50:21 
 * @version V1.0   
 */
package com.std.account.domain;

import java.util.Date;

import com.std.account.dao.base.ABaseDO;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 下午1:35:13 
 * @history:
 */
public class SYSDict extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -9204995364517866187L;

    // 编号（自增长）
    private Long id;

    // 类型（第一层/第二层）
    private String type;

    // 父key
    private String parentKey;

    // key
    private String dkey;

    // value
    private String dvalue;

    // 修改人
    private String updater;

    // 修改时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 系统编号
    private String systemCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public String getDkey() {
        return dkey;
    }

    public void setDkey(String dkey) {
        this.dkey = dkey;
    }

    public String getDvalue() {
        return dvalue;
    }

    public void setDvalue(String dvalue) {
        this.dvalue = dvalue;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
