package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 我的组合时段详情
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupDetailActual implements Serializable {

    /** 组合详情ID **/
    private Long actualDetailId;

    /** 时段类型 H-小时 **/
    private String actualType;

    /** 时段时间 **/
    private Date actualDate;

    /** 组合ID **/
    private Long groupId;

    /** 股票ID **/
    private Long storkId;

    /** 股票代码 **/
    private String storkCode;

    /** 股票名称 **/
    private String storkName;

    /** 总交易收益 **/
    private Double totalTradeIncome;

    /** 单天交易收益 **/
    private Double todayTradeIncome;

    /** 总成本 **/
    private Double totalCost;

    /** 创建日期 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;

    /** 删除标志(Y-是,N-否) **/
    private String isDel;


    public Long getActualDetailId() {
        return actualDetailId;
    }

    public void setActualDetailId(Long actualDetailId) {
        this.actualDetailId = actualDetailId;
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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getStorkId() {
        return storkId;
    }

    public void setStorkId(Long storkId) {
        this.storkId = storkId;
    }

    public String getStorkCode() {
        return storkCode;
    }

    public void setStorkCode(String storkCode) {
        this.storkCode = storkCode;
    }

    public String getStorkName() {
        return storkName;
    }

    public void setStorkName(String storkName) {
        this.storkName = storkName;
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
