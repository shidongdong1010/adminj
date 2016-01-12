package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 我的组合时段
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupActual implements Serializable {

    /** 组合ID **/
    private Long actualGroupId;

    /** 时段类型 H-小时 **/
    private String actualType;

    /** 时段时间 **/
    private Date actualDate;

    /** 用户ID **/
    private Long userId;

    /** 组合名称 **/
    private String groupName;

    /**  **/
    private String groupDesc;

    /** 当前组合交易总收益 **/
    private Double totalTradeIncome;

    /** 当前组合当天交易总收益 **/
    private Double todayTradeIncome;

    /** 当前组合总成本 **/
    private Double totalCost;

    /** 跟买数 **/
    private Long followBuyNum;

    /** 交易次数 **/
    private Long tradeCount;

    /** 盈利次数 **/
    private Long profitCount;

    /** 亏损次数 **/
    private Long lossCount;

    /** 创建日期 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;

    /** 是否删除：Y-是,N否 **/
    private String isDel;


    public Long getActualGroupId() {
        return actualGroupId;
    }

    public void setActualGroupId(Long actualGroupId) {
        this.actualGroupId = actualGroupId;
    }

    public String getActualType() {
        return actualType;
    }

    public void setActualType(String actualType) {
        this.actualType = actualType;
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public Double getTotalTradeIncome() {
        return totalTradeIncome;
    }

    public void setTotalTradeIncome(Double totalTradeIncome) {
        this.totalTradeIncome = totalTradeIncome;
    }

    public Double getTodayTradeIncome() {
        return todayTradeIncome;
    }

    public void setTodayTradeIncome(Double todayTradeIncome) {
        this.todayTradeIncome = todayTradeIncome;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Long getFollowBuyNum() {
        return followBuyNum;
    }

    public void setFollowBuyNum(Long followBuyNum) {
        this.followBuyNum = followBuyNum;
    }

    public Long getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(Long tradeCount) {
        this.tradeCount = tradeCount;
    }

    public Long getProfitCount() {
        return profitCount;
    }

    public void setProfitCount(Long profitCount) {
        this.profitCount = profitCount;
    }

    public Long getLossCount() {
        return lossCount;
    }

    public void setLossCount(Long lossCount) {
        this.lossCount = lossCount;
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

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

}
