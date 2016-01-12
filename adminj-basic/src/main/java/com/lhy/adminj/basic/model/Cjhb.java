package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class Cjhb implements Serializable {

    /**  **/
    private Long id;

    /** 成交日期 **/
    private Date cjrq;

    /** 记录主键 **/
    private Long recordid;

    /** 客户号 **/
    private String khh;

    /** 委托类别，文字说明 **/
    private String showWtlb;

    /** 成交数量 **/
    private Long cjsl;

    /** 证券代码 **/
    private String zqdm;

    /** 成交价格 **/
    private Double cjjg;

    /** 委托类别代码 **/
    private String wtlb;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCjrq() {
        return cjrq;
    }

    public void setCjrq(Date cjrq) {
        this.cjrq = cjrq;
    }

    public Long getRecordid() {
        return recordid;
    }

    public void setRecordid(Long recordid) {
        this.recordid = recordid;
    }

    public String getKhh() {
        return khh;
    }

    public void setKhh(String khh) {
        this.khh = khh;
    }

    public String getShowWtlb() {
        return showWtlb;
    }

    public void setShowWtlb(String showWtlb) {
        this.showWtlb = showWtlb;
    }

    public Long getCjsl() {
        return cjsl;
    }

    public void setCjsl(Long cjsl) {
        this.cjsl = cjsl;
    }

    public String getZqdm() {
        return zqdm;
    }

    public void setZqdm(String zqdm) {
        this.zqdm = zqdm;
    }

    public Double getCjjg() {
        return cjjg;
    }

    public void setCjjg(Double cjjg) {
        this.cjjg = cjjg;
    }

    public String getWtlb() {
        return wtlb;
    }

    public void setWtlb(String wtlb) {
        this.wtlb = wtlb;
    }

}
