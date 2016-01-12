package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户历史收益统计
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserIncomeHisStat implements Serializable {

    /** 历史统计ID **/
    private Long hisStatId;

    /** 用户ID **/
    private Long userId;

    /**  **/
    private Long groupId;

    /** 按天为节点的时间,格式为YYYY-MM-DD **/
    private Date dayNode;

    /** 类型(M-月,D-天) **/
    private String statType;

    /** 收入 **/
    private Double incomeAmount;

    /** 创建时间 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;


    public Long getHisStatId() {
        return hisStatId;
    }

    public void setHisStatId(Long hisStatId) {
        this.hisStatId = hisStatId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Date getDayNode() {
        return dayNode;
    }

    public void setDayNode(Date dayNode) {
        this.dayNode = dayNode;
    }

    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

    public Double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
