package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 航币兑换规则
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CoinConvertRule implements Serializable {

    /**  **/
    private Long id;

    /** 航币 **/
    private Double coin;

    /** 人民币 **/
    private Double rmb;

    /** 开始时间 **/
    private Date beginTime;

    /** 结束时间 **/
    private Date endTime;

    /** 是否启用(0-启用,1-禁用) **/
    private Long isEnable;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCoin() {
        return coin;
    }

    public void setCoin(Double coin) {
        this.coin = coin;
    }

    public Double getRmb() {
        return rmb;
    }

    public void setRmb(Double rmb) {
        this.rmb = rmb;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Long isEnable) {
        this.isEnable = isEnable;
    }

}
