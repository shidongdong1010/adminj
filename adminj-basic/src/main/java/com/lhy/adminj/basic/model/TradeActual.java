package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 时段交易记录表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class TradeActual implements Serializable {

    /** 交易记录表主键 **/
    private Long actualTradeId;

    /** 时段类型 H-小时 **/
    private String actualType;

    /** 交易用户ID **/
    private Long userId;

    /**  **/
    private Long groupId;

    /** 股票ID **/
    private Long stockId;

    /** 股票代码 **/
    private String stockCode;

    /** 股票名称 **/
    private String stockName;

    /** 交易价格 **/
    private Double tradePrice;

    /** 交易数量 **/
    private Long tradeNumber;

    /** 成交金额 **/
    private Double turnoverAmount;

    /** 交易类型(B-买,S-卖） **/
    private String tradeType;

    /** 手续费=印花税+佣金 **/
    private Double counterFee;

    /** 印花税 **/
    private Double stampDuty;

    /** 佣金 **/
    private Double commission;

    /** 交易日期 **/
    private Date tradeDate;

    /** 交易时间 **/
    private Date tradeTime;

    /** 股东代码 **/
    private String shareholderCode;

    /** 是否撤销（Y-是,N-否） **/
    private String isRevoke;

    /** 券商提供的客户号 **/
    private String stockKhh;

    /** 操作时间 **/
    private Date createDate;

    /** 更新时间 **/
    private Date updateDate;


    public Long getActualTradeId() {
        return actualTradeId;
    }

    public void setActualTradeId(Long actualTradeId) {
        this.actualTradeId = actualTradeId;
    }

    public String getActualType() {
        return actualType;
    }

    public void setActualType(String actualType) {
        this.actualType = actualType;
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

    public Double getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(Double tradePrice) {
        this.tradePrice = tradePrice;
    }

    public Long getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(Long tradeNumber) {
        this.tradeNumber = tradeNumber;
    }

    public Double getTurnoverAmount() {
        return turnoverAmount;
    }

    public void setTurnoverAmount(Double turnoverAmount) {
        this.turnoverAmount = turnoverAmount;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Double getCounterFee() {
        return counterFee;
    }

    public void setCounterFee(Double counterFee) {
        this.counterFee = counterFee;
    }

    public Double getStampDuty() {
        return stampDuty;
    }

    public void setStampDuty(Double stampDuty) {
        this.stampDuty = stampDuty;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getShareholderCode() {
        return shareholderCode;
    }

    public void setShareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
    }

    public String getIsRevoke() {
        return isRevoke;
    }

    public void setIsRevoke(String isRevoke) {
        this.isRevoke = isRevoke;
    }

    public String getStockKhh() {
        return stockKhh;
    }

    public void setStockKhh(String stockKhh) {
        this.stockKhh = stockKhh;
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
