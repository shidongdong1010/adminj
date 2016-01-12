package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 浮动表(涨幅、跌幅、换手率、振幅榜)
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class Ratio implements Serializable {

    /** 浮动表主键 **/
    private Long ratioId;

    /** 股票代码 **/
    private String stockCode;

    /** 股票名称 **/
    private String stockName;

    /** 最新价 **/
    private Double stockPrice;

    /** 股票涨幅 **/
    private Double stockZf;

    /** 股票涨幅榜 **/
    private Double stockUp;

    /** 跌幅榜 **/
    private Double stockDown;

    /** 换手率 **/
    private Double stockHsl;

    /** 振幅榜 **/
    private Double stockZfb;

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


    public Long getRatioId() {
        return ratioId;
    }

    public void setRatioId(Long ratioId) {
        this.ratioId = ratioId;
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

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Double getStockZf() {
        return stockZf;
    }

    public void setStockZf(Double stockZf) {
        this.stockZf = stockZf;
    }

    public Double getStockUp() {
        return stockUp;
    }

    public void setStockUp(Double stockUp) {
        this.stockUp = stockUp;
    }

    public Double getStockDown() {
        return stockDown;
    }

    public void setStockDown(Double stockDown) {
        this.stockDown = stockDown;
    }

    public Double getStockHsl() {
        return stockHsl;
    }

    public void setStockHsl(Double stockHsl) {
        this.stockHsl = stockHsl;
    }

    public Double getStockZfb() {
        return stockZfb;
    }

    public void setStockZfb(Double stockZfb) {
        this.stockZfb = stockZfb;
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
