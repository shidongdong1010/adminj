package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 股票时段表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockActual implements Serializable {

    /** 股票表主键 **/
    private Long actualStockId;

    /** 时段类型 H-小时 **/
    private String actualType;

    /** 时段时间 **/
    private Date actualDate;

    /** 股票名称  **/
    private String stockName;

    /** 股票代码  **/
    private String stockCode;

    /** 涨跌幅 **/
    private Double zdf;

    /** 涨跌数 **/
    private Double zds;

    /** 最高价 **/
    private Double zgj;

    /** 最后更新时间 **/
    private Date utime;

    /** 成交量 **/
    private Long cjl;

    /** 今开盘 **/
    private Double jkp;

    /** 最低价 **/
    private Double zdj;

    /** 股票类型 1:沪市 sh,2:深市 sz **/
    private String stype;

    /** 成交金额 **/
    private Double cjje;

    /** 昨收盘 **/
    private Double zsp;

    /** 最新值 **/
    private Double zxz;

    /** 差价,zxz-zsp **/
    private Double diffPrice;

    /** 创建时间 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateTime;


    public Long getActualStockId() {
        return actualStockId;
    }

    public void setActualStockId(Long actualStockId) {
        this.actualStockId = actualStockId;
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

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Double getZdf() {
        return zdf;
    }

    public void setZdf(Double zdf) {
        this.zdf = zdf;
    }

    public Double getZds() {
        return zds;
    }

    public void setZds(Double zds) {
        this.zds = zds;
    }

    public Double getZgj() {
        return zgj;
    }

    public void setZgj(Double zgj) {
        this.zgj = zgj;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public Long getCjl() {
        return cjl;
    }

    public void setCjl(Long cjl) {
        this.cjl = cjl;
    }

    public Double getJkp() {
        return jkp;
    }

    public void setJkp(Double jkp) {
        this.jkp = jkp;
    }

    public Double getZdj() {
        return zdj;
    }

    public void setZdj(Double zdj) {
        this.zdj = zdj;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public Double getCjje() {
        return cjje;
    }

    public void setCjje(Double cjje) {
        this.cjje = cjje;
    }

    public Double getZsp() {
        return zsp;
    }

    public void setZsp(Double zsp) {
        this.zsp = zsp;
    }

    public Double getZxz() {
        return zxz;
    }

    public void setZxz(Double zxz) {
        this.zxz = zxz;
    }

    public Double getDiffPrice() {
        return diffPrice;
    }

    public void setDiffPrice(Double diffPrice) {
        this.diffPrice = diffPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
