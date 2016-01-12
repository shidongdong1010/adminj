package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 证券开户表302001
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockUser implements Serializable {

    /** 主键 **/
    private Long stockUserId;

    /** 券商提供的客户号（根据这个客户号，去相关券商查询其交易信息等) **/
    private String fidKhh;

    /** 券商的服务范围 **/
    private Double fidFwxm;

    /** 券商的委托范围 **/
    private Double fidWtfs;

    /** 证件信息 **/
    private String fidZjbh;

    /** 营业部 **/
    private String fidYyb;

    /** 群组 **/
    private String fidKhqz;

    /** 卡号 **/
    private String fidKhkh;

    /** 姓名 **/
    private String fidKhxm;

    /** 状态：0正常，其它异常 **/
    private Double fidKhzt;

    /** 几句风险承受能力 **/
    private Double fidTzzfl;

    /** 证券风险承受能力 **/
    private Double fidKhjf;

    /** 通讯地址 **/
    private String fidDz;

    /** 电话 **/
    private String fidDh;

    /** 传真 **/
    private String fidFax;

    /** 邮箱 **/
    private String fidEmail;

    /** 手机 **/
    private String fidMobile;

    /** 操作日期 **/
    private Date creatDate;

    /** 操作人 **/
    private Long creator;

    /** 最新操作时间 **/
    private Date lastUpdateDate;

    /** 最新操作人 **/
    private Long lastUpdater;

    /** 逻辑删除标志（n不删除，y删除） **/
    private Long dr;

    /** 关联券商表主键 **/
    private Long brokerId;


    public Long getStockUserId() {
        return stockUserId;
    }

    public void setStockUserId(Long stockUserId) {
        this.stockUserId = stockUserId;
    }

    public String getFidKhh() {
        return fidKhh;
    }

    public void setFidKhh(String fidKhh) {
        this.fidKhh = fidKhh;
    }

    public Double getFidFwxm() {
        return fidFwxm;
    }

    public void setFidFwxm(Double fidFwxm) {
        this.fidFwxm = fidFwxm;
    }

    public Double getFidWtfs() {
        return fidWtfs;
    }

    public void setFidWtfs(Double fidWtfs) {
        this.fidWtfs = fidWtfs;
    }

    public String getFidZjbh() {
        return fidZjbh;
    }

    public void setFidZjbh(String fidZjbh) {
        this.fidZjbh = fidZjbh;
    }

    public String getFidYyb() {
        return fidYyb;
    }

    public void setFidYyb(String fidYyb) {
        this.fidYyb = fidYyb;
    }

    public String getFidKhqz() {
        return fidKhqz;
    }

    public void setFidKhqz(String fidKhqz) {
        this.fidKhqz = fidKhqz;
    }

    public String getFidKhkh() {
        return fidKhkh;
    }

    public void setFidKhkh(String fidKhkh) {
        this.fidKhkh = fidKhkh;
    }

    public String getFidKhxm() {
        return fidKhxm;
    }

    public void setFidKhxm(String fidKhxm) {
        this.fidKhxm = fidKhxm;
    }

    public Double getFidKhzt() {
        return fidKhzt;
    }

    public void setFidKhzt(Double fidKhzt) {
        this.fidKhzt = fidKhzt;
    }

    public Double getFidTzzfl() {
        return fidTzzfl;
    }

    public void setFidTzzfl(Double fidTzzfl) {
        this.fidTzzfl = fidTzzfl;
    }

    public Double getFidKhjf() {
        return fidKhjf;
    }

    public void setFidKhjf(Double fidKhjf) {
        this.fidKhjf = fidKhjf;
    }

    public String getFidDz() {
        return fidDz;
    }

    public void setFidDz(String fidDz) {
        this.fidDz = fidDz;
    }

    public String getFidDh() {
        return fidDh;
    }

    public void setFidDh(String fidDh) {
        this.fidDh = fidDh;
    }

    public String getFidFax() {
        return fidFax;
    }

    public void setFidFax(String fidFax) {
        this.fidFax = fidFax;
    }

    public String getFidEmail() {
        return fidEmail;
    }

    public void setFidEmail(String fidEmail) {
        this.fidEmail = fidEmail;
    }

    public String getFidMobile() {
        return fidMobile;
    }

    public void setFidMobile(String fidMobile) {
        this.fidMobile = fidMobile;
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

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

}
