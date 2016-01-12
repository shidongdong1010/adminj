package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告信息表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class AnnouncementInfo implements Serializable {

    /** 公告信息ID **/
    private Long announcementId;

    /** 公告标题 **/
    private String announcementTitle;

    /** 公告标语 **/
    private String announcementLogo;

    /** 公告url **/
    private String announcementUrl;

    /** 公告内容 **/
    private String announcementDesc;

    /** 用户Id **/
    private Long announcementCreateId;

    /** 创建时间 **/
    private Date createTime;

    /** 用户Id **/
    private Long announcementUpdateId;

    /** 创建时间 **/
    private Date updateTime;

    /** 是否删除[0-是，1-否] **/
    private String isDel;


    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getAnnouncementLogo() {
        return announcementLogo;
    }

    public void setAnnouncementLogo(String announcementLogo) {
        this.announcementLogo = announcementLogo;
    }

    public String getAnnouncementUrl() {
        return announcementUrl;
    }

    public void setAnnouncementUrl(String announcementUrl) {
        this.announcementUrl = announcementUrl;
    }

    public String getAnnouncementDesc() {
        return announcementDesc;
    }

    public void setAnnouncementDesc(String announcementDesc) {
        this.announcementDesc = announcementDesc;
    }

    public Long getAnnouncementCreateId() {
        return announcementCreateId;
    }

    public void setAnnouncementCreateId(Long announcementCreateId) {
        this.announcementCreateId = announcementCreateId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getAnnouncementUpdateId() {
        return announcementUpdateId;
    }

    public void setAnnouncementUpdateId(Long announcementUpdateId) {
        this.announcementUpdateId = announcementUpdateId;
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
