package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 券商信息表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class Trader implements Serializable {

    /** 券商ID **/
    private Long traderId;

    /** 券商名称 **/
    private String name;

    /** 券商中文简称 **/
    private String cnShortName;

    /** 券商英文简称 **/
    private String enShortName;

    /** 是否合作(Y-是,N-否) **/
    private String cooperation;

    /** 修改时间 **/
    private Date updateDate;

    /** 合作结束时间 **/
    private Date coopEndDate;

    /** 创建时间 **/
    private Date createDate;

    /** 合作开始时间 **/
    private Date coopStartData;


    public Long getTraderId() {
        return traderId;
    }

    public void setTraderId(Long traderId) {
        this.traderId = traderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnShortName() {
        return cnShortName;
    }

    public void setCnShortName(String cnShortName) {
        this.cnShortName = cnShortName;
    }

    public String getEnShortName() {
        return enShortName;
    }

    public void setEnShortName(String enShortName) {
        this.enShortName = enShortName;
    }

    public String getCooperation() {
        return cooperation;
    }

    public void setCooperation(String cooperation) {
        this.cooperation = cooperation;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCoopEndDate() {
        return coopEndDate;
    }

    public void setCoopEndDate(Date coopEndDate) {
        this.coopEndDate = coopEndDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCoopStartData() {
        return coopStartData;
    }

    public void setCoopStartData(Date coopStartData) {
        this.coopStartData = coopStartData;
    }

}
