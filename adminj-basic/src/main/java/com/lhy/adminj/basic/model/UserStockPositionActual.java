package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 股票时段持仓表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserStockPositionActual implements Serializable {

    /** 股票持仓ID **/
    private Long actualPositionId;

    /** 时段类型 H-小时 **/
    private String actualType;

    /** 时段时间 **/
    private Date actualDate;

    /** 股票ID **/
    private Long stockId;

    /** 股票代码 **/
    private String stockCode;

    /** 股票名称 **/
    private String stockName;

    /** 用户ID **/
    private Long userId;

    /** 组合ID **/
    private Long groupId;

    /** 组合详情ID **/
    private Long groupDetailId;

    /** 券商客户号 **/
    private String stockKhh;

    /** 股票数量 **/
    private Long stockNum;

    /** 可卖数量 **/
    private Long sellNum;

    /** 币种(CNY-人民币,USD-美元,EUR-欧元,HKD-港币,GBP-英镑,JPY-日元,KRW-韩元,CAD-加元,AUD-澳元,CHF-瑞郎,SGD-新加坡元,MYR-马来西亚币,IDR-印尼,NZD-新西兰,VND-越南,THB-泰铢,PHP-菲律宾) **/
    private String currency;

    /** 成本 **/
    private Double costPrice;

    /** 盈亏 **/
    private Double profitLoss;

    /** 盈亏比率 **/
    private Double profitLossRatio;

    /** 当前价 **/
    private Double currPrice;

    /** 今买数量 **/
    private Long todayBuyNum;

    /** 今卖数量 **/
    private Long todaySellNum;

    /** 成本金额 **/
    private Double costAmount;

    /** 折算汇率 **/
    private Double convertedExchangeRate;

    /** 股东代码 **/
    private String shareholderCode;

    /** 操作时间 **/
    private Date createDate;

    /** 更新时间 **/
    private Date updateDate;

    /** 逻辑删除标志（n-不删除, y-删除） **/
    private String isDel;

    /** 备注 **/
    private String remark;


    public Long getActualPositionId() {
        return actualPositionId;
    }

    public void setActualPositionId(Long actualPositionId) {
        this.actualPositionId = actualPositionId;
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

    public Long getGroupDetailId() {
        return groupDetailId;
    }

    public void setGroupDetailId(Long groupDetailId) {
        this.groupDetailId = groupDetailId;
    }

    public String getStockKhh() {
        return stockKhh;
    }

    public void setStockKhh(String stockKhh) {
        this.stockKhh = stockKhh;
    }

    public Long getStockNum() {
        return stockNum;
    }

    public void setStockNum(Long stockNum) {
        this.stockNum = stockNum;
    }

    public Long getSellNum() {
        return sellNum;
    }

    public void setSellNum(Long sellNum) {
        this.sellNum = sellNum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(Double profitLoss) {
        this.profitLoss = profitLoss;
    }

    public Double getProfitLossRatio() {
        return profitLossRatio;
    }

    public void setProfitLossRatio(Double profitLossRatio) {
        this.profitLossRatio = profitLossRatio;
    }

    public Double getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(Double currPrice) {
        this.currPrice = currPrice;
    }

    public Long getTodayBuyNum() {
        return todayBuyNum;
    }

    public void setTodayBuyNum(Long todayBuyNum) {
        this.todayBuyNum = todayBuyNum;
    }

    public Long getTodaySellNum() {
        return todaySellNum;
    }

    public void setTodaySellNum(Long todaySellNum) {
        this.todaySellNum = todaySellNum;
    }

    public Double getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(Double costAmount) {
        this.costAmount = costAmount;
    }

    public Double getConvertedExchangeRate() {
        return convertedExchangeRate;
    }

    public void setConvertedExchangeRate(Double convertedExchangeRate) {
        this.convertedExchangeRate = convertedExchangeRate;
    }

    public String getShareholderCode() {
        return shareholderCode;
    }

    public void setShareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
