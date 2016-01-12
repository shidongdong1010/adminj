package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 我的组合表详情
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupDetail implements Serializable {

    /** 组合详情ID **/
    private Long groupDetailId;

    /** 组合ID **/
    private Long groupId;

    /** 股票ID **/
    private Long stockId;

    /** 股票代码 **/
    private String stockCode;

    /** 股票名称 **/
    private String stockName;

    /** 总交易收入 **/
    private Double totalTradeIncome;

    /** 当天交易收入 **/
    private Double todayTradeIncome;

    /** 成本 **/
    private Double totalCost;

    /** 创建日期 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;

    /** 删除标志(Y-是,N-否) **/
    private String isDel;


    public Long getGroupDetailId() {
        return groupDetailId;
    }

    public void setGroupDetailId(Long groupDetailId) {
        this.groupDetailId = groupDetailId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
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
