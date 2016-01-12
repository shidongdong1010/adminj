package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 平台客户和证券客户关联
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockUserInfo implements Serializable {

    /** 主键 **/
    private Long stockUserInfoId;

    /** 关联平台用户表主键 **/
    private Long userId;

    /** 关联券商客户号主键 **/
    private Long stockUserId;

    /** 状态：0正常、1异常 **/
    private String status;

    /** 创建日期 **/
    private Date creatDate;

    /** 操作人 **/
    private Long creator;

    /** 最新更新时间 **/
    private Date lastUpdateDate;

    /** 最新更新操作人 **/
    private Long lastUpdater;

    /** 逻辑删除标志（n不删除，y删除） **/
    private Long dr;

    /** 券商id **/
    private Long brokerId;

    /** 客户号 **/
    private String storkKhh;


    public Long getStockUserInfoId() {
        return stockUserInfoId;
    }

    public void setStockUserInfoId(Long stockUserInfoId) {
        this.stockUserInfoId = stockUserInfoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStockUserId() {
        return stockUserId;
    }

    public void setStockUserId(Long stockUserId) {
        this.stockUserId = stockUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getStorkKhh() {
        return storkKhh;
    }

    public void setStorkKhh(String storkKhh) {
        this.storkKhh = storkKhh;
    }

}
