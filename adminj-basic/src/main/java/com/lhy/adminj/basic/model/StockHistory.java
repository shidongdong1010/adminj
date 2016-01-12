package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 股票历史表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockHistory implements Serializable {

    /** 股票历史表主键 **/
    private Long stockHistoryId;

    /** 日期 **/
    private Date stockDate;

    /** 股票code **/
    private String stockCode;

    /** 收盘价 **/
    private Double startPri;

    /** 开盘价 **/
    private Double endPri;

    /** 最高价 **/
    private Double todayMax;

    /** 最低价 **/
    private Double todayMin;

    /** 成交量 **/
    private Double traNumber;

    /** 成交金额 **/
    private Double traAmount;

    /** 调整后价格 **/
    private Double submitPric;

    /** 操作日期 **/
    private Date creatDate;

    /** 操作人 **/
    private Long creator;

    /** 最后更新时间 **/
    private Date lastUpdateDate;

    /** 最后更新人 **/
    private Long lastUpdater;

    /** 逻辑删除标志（n不删除，y删除） **/
    private Long dr;


    public Long getStockHistoryId() {
        return stockHistoryId;
    }

    public void setStockHistoryId(Long stockHistoryId) {
        this.stockHistoryId = stockHistoryId;
    }

    public Date getStockDate() {
        return stockDate;
    }

    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Double getStartPri() {
        return startPri;
    }

    public void setStartPri(Double startPri) {
        this.startPri = startPri;
    }

    public Double getEndPri() {
        return endPri;
    }

    public void setEndPri(Double endPri) {
        this.endPri = endPri;
    }

    public Double getTodayMax() {
        return todayMax;
    }

    public void setTodayMax(Double todayMax) {
        this.todayMax = todayMax;
    }

    public Double getTodayMin() {
        return todayMin;
    }

    public void setTodayMin(Double todayMin) {
        this.todayMin = todayMin;
    }

    public Double getTraNumber() {
        return traNumber;
    }

    public void setTraNumber(Double traNumber) {
        this.traNumber = traNumber;
    }

    public Double getTraAmount() {
        return traAmount;
    }

    public void setTraAmount(Double traAmount) {
        this.traAmount = traAmount;
    }

    public Double getSubmitPric() {
        return submitPric;
    }

    public void setSubmitPric(Double submitPric) {
        this.submitPric = submitPric;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getLastUpdater() {
        return lastUpdater;
    }

    public void setLastUpdater(Long lastUpdater) {
        this.lastUpdater = lastUpdater;
    }

    public Long getDr() {
        return dr;
    }

    public void setDr(Long dr) {
        this.dr = dr;
    }

}
