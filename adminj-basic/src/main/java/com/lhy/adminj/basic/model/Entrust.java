package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 股票委托表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class Entrust implements Serializable {

    /** 股票委托表主键 **/
    private Long entrustId;

    /** 本平台的股票表主键 **/
    private Long stockId;

    /** 股票代码 **/
    private String stockCode;

    /** 股票数量 **/
    private Long stockNumber;

    /** 股票市价格 **/
    private Double entrustPrice;

    /** 委托日期 **/
    private Date entrustDate;

    /** 委托类型（0买入、1卖出、2撤单） **/
    private String entrustStyle;

    /** 买一 **/
    private Long buyOne;

    /** 买一报价 **/
    private Double buyOnePri;

    /** 买二 **/
    private Long buyTwo;

    /** 买二报价 **/
    private Double buyTwoPri;

    /** 买三 **/
    private Long buyThre;

    /** 买三报价 **/
    private Double buyThreePri;

    /** 买四 **/
    private Long buyFour;

    /** 买四报价 **/
    private Double buyFourPri;

    /** 买五 **/
    private Long buyFive;

    /** 买五报价 **/
    private Double buyFivePri;

    /** 卖一 **/
    private Long sellOne;

    /** 卖一报价 **/
    private Double sellOnePri;

    /** 卖二 **/
    private Long sellTwo;

    /** 卖二报价 **/
    private Double sellTwoPri;

    /** 卖三 **/
    private Long sellThre;

    /** 卖三报价 **/
    private Double sellThreePri;

    /** 卖四 **/
    private Long sellFour;

    /** 卖四报价 **/
    private Double sellFourPri;

    /** 卖五 **/
    private Long sellFive;

    /** 卖五报价 **/
    private Double sellFivePri;

    /** 操作时间 **/
    private Date creatDate;

    /** 操作人 **/
    private Long creator;

    /** 最后更新时间 **/
    private Date lastUpdateDate;

    /** 最后更新操作人 **/
    private Long lastUpdater;

    /** 逻辑删除标志（n不删除，y删除） **/
    private Long dr;


    public Long getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Long entrustId) {
        this.entrustId = entrustId;
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

    public Long getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(Long stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Double getEntrustPrice() {
        return entrustPrice;
    }

    public void setEntrustPrice(Double entrustPrice) {
        this.entrustPrice = entrustPrice;
    }

    public Date getEntrustDate() {
        return entrustDate;
    }

    public void setEntrustDate(Date entrustDate) {
        this.entrustDate = entrustDate;
    }

    public String getEntrustStyle() {
        return entrustStyle;
    }

    public void setEntrustStyle(String entrustStyle) {
        this.entrustStyle = entrustStyle;
    }

    public Long getBuyOne() {
        return buyOne;
    }

    public void setBuyOne(Long buyOne) {
        this.buyOne = buyOne;
    }

    public Double getBuyOnePri() {
        return buyOnePri;
    }

    public void setBuyOnePri(Double buyOnePri) {
        this.buyOnePri = buyOnePri;
    }

    public Long getBuyTwo() {
        return buyTwo;
    }

    public void setBuyTwo(Long buyTwo) {
        this.buyTwo = buyTwo;
    }

    public Double getBuyTwoPri() {
        return buyTwoPri;
    }

    public void setBuyTwoPri(Double buyTwoPri) {
        this.buyTwoPri = buyTwoPri;
    }

    public Long getBuyThre() {
        return buyThre;
    }

    public void setBuyThre(Long buyThre) {
        this.buyThre = buyThre;
    }

    public Double getBuyThreePri() {
        return buyThreePri;
    }

    public void setBuyThreePri(Double buyThreePri) {
        this.buyThreePri = buyThreePri;
    }

    public Long getBuyFour() {
        return buyFour;
    }

    public void setBuyFour(Long buyFour) {
        this.buyFour = buyFour;
    }

    public Double getBuyFourPri() {
        return buyFourPri;
    }

    public void setBuyFourPri(Double buyFourPri) {
        this.buyFourPri = buyFourPri;
    }

    public Long getBuyFive() {
        return buyFive;
    }

    public void setBuyFive(Long buyFive) {
        this.buyFive = buyFive;
    }

    public Double getBuyFivePri() {
        return buyFivePri;
    }

    public void setBuyFivePri(Double buyFivePri) {
        this.buyFivePri = buyFivePri;
    }

    public Long getSellOne() {
        return sellOne;
    }

    public void setSellOne(Long sellOne) {
        this.sellOne = sellOne;
    }

    public Double getSellOnePri() {
        return sellOnePri;
    }

    public void setSellOnePri(Double sellOnePri) {
        this.sellOnePri = sellOnePri;
    }

    public Long getSellTwo() {
        return sellTwo;
    }

    public void setSellTwo(Long sellTwo) {
        this.sellTwo = sellTwo;
    }

    public Double getSellTwoPri() {
        return sellTwoPri;
    }

    public void setSellTwoPri(Double sellTwoPri) {
        this.sellTwoPri = sellTwoPri;
    }

    public Long getSellThre() {
        return sellThre;
    }

    public void setSellThre(Long sellThre) {
        this.sellThre = sellThre;
    }

    public Double getSellThreePri() {
        return sellThreePri;
    }

    public void setSellThreePri(Double sellThreePri) {
        this.sellThreePri = sellThreePri;
    }

    public Long getSellFour() {
        return sellFour;
    }

    public void setSellFour(Long sellFour) {
        this.sellFour = sellFour;
    }

    public Double getSellFourPri() {
        return sellFourPri;
    }

    public void setSellFourPri(Double sellFourPri) {
        this.sellFourPri = sellFourPri;
    }

    public Long getSellFive() {
        return sellFive;
    }

    public void setSellFive(Long sellFive) {
        this.sellFive = sellFive;
    }

    public Double getSellFivePri() {
        return sellFivePri;
    }

    public void setSellFivePri(Double sellFivePri) {
        this.sellFivePri = sellFivePri;
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
