package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告信息表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class AdvertisingInfo implements Serializable {

    /** 广告信息ID **/
    private Long advertisingId;

    /** 广告URL **/
    private String advertisingUrl;

    /** 广告logo **/
    private String advertisingLogo;

    /** 用户Id **/
    private Long advertisingCreateId;

    /** 创建时间 **/
    private Date createTime;

    /** 用户Id **/
    private Long advertisingUpdateId;

    /** 创建时间 **/
    private Date updateTime;

    /** 是否删除[0-是，1-否] **/
    private String isDel;


    public Long getAdvertisingId() {
        return advertisingId;
    }

    public void setAdvertisingId(Long advertisingId) {
        this.advertisingId = advertisingId;
    }

    public String getAdvertisingUrl() {
        return advertisingUrl;
    }

    public void setAdvertisingUrl(String advertisingUrl) {
        this.advertisingUrl = advertisingUrl;
    }

    public String getAdvertisingLogo() {
        return advertisingLogo;
    }

    public void setAdvertisingLogo(String advertisingLogo) {
        this.advertisingLogo = advertisingLogo;
    }

    public Long getAdvertisingCreateId() {
        return advertisingCreateId;
    }

    public void setAdvertisingCreateId(Long advertisingCreateId) {
        this.advertisingCreateId = advertisingCreateId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getAdvertisingUpdateId() {
        return advertisingUpdateId;
    }

    public void setAdvertisingUpdateId(Long advertisingUpdateId) {
        this.advertisingUpdateId = advertisingUpdateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

}
