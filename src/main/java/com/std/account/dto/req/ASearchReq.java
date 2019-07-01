package com.std.account.dto.req;

import java.io.Serializable;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 下午1:53:25 
 * @history:
 */
public abstract class ASearchReq implements Serializable {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 9192316630188356600L;

    // 创建起始时间(YYYY-MM-DD)
    private String dateStart;

    // 创建终止时间(YYYY-MM-DD)
    private String dateEnd;

    // 排序字段
    private String orderColumn;

    // 排序方向
    private String orderDir;

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderDir() {
        return orderDir;
    }

    public void setOrderDir(String orderDir) {
        this.orderDir = orderDir;
    }

}
