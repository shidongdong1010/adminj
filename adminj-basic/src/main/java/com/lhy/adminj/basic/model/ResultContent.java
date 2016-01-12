package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 实时交易表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class ResultContent implements Serializable {

    /** 实时数据表主键 **/
    private Long resultContentId;

    /** 股票标号 **/
    private Long gid;

    /** 银行名称 **/
    private String bankName;

    /** 今日开盘价 **/
    private Double todayStartPri;

    /** 昨日收盘价 **/
    private Double yestodEndPri;

    /** 当前价格 **/
    private Double nowPri;

    /** 今日最高价 **/
    private Double todayMax;

    /** 今日最低价 **/
    private Double todayMin;

    /** 竞买价 **/
    private Double competitivePri;

    /** 竞卖价 **/
    private Double reservePri;

    /** 成交量 **/
    private Long traNumber;

    /** 成交金额 **/
    private Double traAmount;

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

    /** 日期 **/
    private Date rDate;

    /** 时间 **/
    private String rTime;

    /** 大盘指数名称 **/
    private String stockName;

    /** 大盘当前点数 **/
    private Double dot;

    /** 大盘当前价格 **/
    private Double nowPic;

    /** 大盘涨跌率 **/
    private Double rate;

    /** 大盘成交量（手） **/
    private Long tradNumber;

    /** 大盘成交金额（万元） **/
    private Double tradAmount;

    /** 分时K线图 **/
    private String minurl;

    /** 日K线图 **/
    private String dayurl;

    /** 周K线图 **/
    private String weekurl;

    /** 月K线图 **/
    private String monthurl;

    /** 正常 **/
    private String resultcod;

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


    public Long getResultContentId() {
        return resultContentId;
    }

    public void setResultContentId(Long resultContentId) {
        this.resultContentId = resultContentId;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getTodayStartPri() {
        return todayStartPri;
    }

    public void setTodayStartPri(Double todayStartPri) {
        this.todayStartPri = todayStartPri;
    }

    public Double getYestodEndPri() {
        return yestodEndPri;
    }

    public void setYestodEndPri(Double yestodEndPri) {
        this.yestodEndPri = yestodEndPri;
    }

    public Double getNowPri() {
        return nowPri;
    }

    public void setNowPri(Double nowPri) {
        this.nowPri = nowPri;
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

    public Double getCompetitivePri() {
        return competitivePri;
    }

    public void setCompetitivePri(Double competitivePri) {
        this.competitivePri = competitivePri;
    }

    public Double getReservePri() {
        return reservePri;
    }

    public void setReservePri(Double reservePri) {
        this.reservePri = reservePri;
    }

    public Long getTraNumber() {
        return traNumber;
    }

    public void setTraNumber(Long traNumber) {
        this.traNumber = traNumber;
    }

    public Double getTraAmount() {
        return traAmount;
    }

    public void setTraAmount(Double traAmount) {
        this.traAmount = traAmount;
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

    public Date getRDate() {
        return rDate;
    }

    public void setRDate(Date rDate) {
        this.rDate = rDate;
    }

    public String getRTime() {
        return rTime;
    }

    public void setRTime(String rTime) {
        this.rTime = rTime;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Double getDot() {
        return dot;
    }

    public void setDot(Double dot) {
        this.dot = dot;
    }

    public Double getNowPic() {
        return nowPic;
    }

    public void setNowPic(Double nowPic) {
        this.nowPic = nowPic;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getTradNumber() {
        return tradNumber;
    }

    public void setTradNumber(Long tradNumber) {
        this.tradNumber = tradNumber;
    }

    public Double getTradAmount() {
        return tradAmount;
    }

    public void setTradAmount(Double tradAmount) {
        this.tradAmount = tradAmount;
    }

    public String getMinurl() {
        return minurl;
    }

    public void setMinurl(String minurl) {
        this.minurl = minurl;
    }

    public String getDayurl() {
        return dayurl;
    }

    public void setDayurl(String dayurl) {
        this.dayurl = dayurl;
    }

    public String getWeekurl() {
        return weekurl;
    }

    public void setWeekurl(String weekurl) {
        this.weekurl = weekurl;
    }

    public String getMonthurl() {
        return monthurl;
    }

    public void setMonthurl(String monthurl) {
        this.monthurl = monthurl;
    }

    public String getResultcod() {
        return resultcod;
    }

    public void setResultcod(String resultcod) {
        this.resultcod = resultcod;
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
