package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 券商管理表，后期接入的券商都通过此表进行管理
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class Brokers implements Serializable {

    /**  **/
    private Long brokerId;

    /** 券商名称 **/
    private String brokerName;

    /** 券商代码 **/
    private String brokerCode;

    /** 券商类型：(1-证券经纪业务,2-证券投资咨询业务,3-与证券有关的财务顾问业务,4-证券承销与保荐业务,5-证券自营业务,6-证券资产管理业务,7-其他证券业务) **/
    private String brokerClass;

    /** 券商接入状态：(1-正常,2-终止,3-以外) **/
    private String brokerState;

    /** 券商所属地：(1-上海（SH）,2-深圳（SZ）,3-其他) **/
    private String brokerLocal;

    /** 券商地址 **/
    private String brokerAddress;

    /** 券商注册金额 **/
    private Double brokerMoney;

    /** 平台使用状态:(1-正常,2-取消) **/
    private String brokerAppState;

    /** 券商接入手续费 **/
    private Double brokerFee;

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

    /** 合作结束时间 **/
    private Date coopEndDate;

    /** 合作开始时间 **/
    private Date coopStartData;


    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    public String getBrokerClass() {
        return brokerClass;
    }

    public void setBrokerClass(String brokerClass) {
        this.brokerClass = brokerClass;
    }

    public String getBrokerState() {
        return brokerState;
    }

    public void setBrokerState(String brokerState) {
        this.brokerState = brokerState;
    }

    public String getBrokerLocal() {
        return brokerLocal;
    }

    public void setBrokerLocal(String brokerLocal) {
        this.brokerLocal = brokerLocal;
    }

    public String getBrokerAddress() {
        return brokerAddress;
    }

    public void setBrokerAddress(String brokerAddress) {
        this.brokerAddress = brokerAddress;
    }

    public Double getBrokerMoney() {
        return brokerMoney;
    }

    public void setBrokerMoney(Double brokerMoney) {
        this.brokerMoney = brokerMoney;
    }

    public String getBrokerAppState() {
        return brokerAppState;
    }

    public void setBrokerAppState(String brokerAppState) {
        this.brokerAppState = brokerAppState;
    }

    public Double getBrokerFee() {
        return brokerFee;
    }

    public void setBrokerFee(Double brokerFee) {
        this.brokerFee = brokerFee;
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

    public Date getCoopEndDate() {
        return coopEndDate;
    }

    public void setCoopEndDate(Date coopEndDate) {
        this.coopEndDate = coopEndDate;
    }

    public Date getCoopStartData() {
        return coopStartData;
    }

    public void setCoopStartData(Date coopStartData) {
        this.coopStartData = coopStartData;
    }

}
