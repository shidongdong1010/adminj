package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户收益实时统计
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserIncomeActualStat implements Serializable {

    /** 实时统计ID **/
    private Long actualStatId;

    /** 用户ID **/
    private Long userId;

    /** 类型(P-个人,G-组合) **/
    private String statType;

    /** 组合ID,类型为个人时为默认值 **/
    private Long groupId;

    /** 时间,格式为YYYY-MM-DD **/
    private Date dayTime;

    /**  **/
    private Date hourTime;

    /** 收入 **/
    private Double incomeAmount;

    /** 创建时间 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;


    public Long getActualStatId() {
        return actualStatId;
    }

    public void setActualStatId(Long actualStatId) {
        this.actualStatId = actualStatId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Date getDayTime() {
        return dayTime;
    }

    public void setDayTime(Date dayTime) {
        this.dayTime = dayTime;
    }

    public Date getHourTime() {
        return hourTime;
    }

    public void setHourTime(Date hourTime) {
        this.hourTime = hourTime;
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
