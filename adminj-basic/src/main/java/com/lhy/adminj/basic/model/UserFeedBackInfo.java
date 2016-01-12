package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 意见反馈信息表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserFeedBackInfo implements Serializable {

    /** 意见反馈信息ID **/
    private Long feedbackId;

    /** 用户Id **/
    private Long userId;

    /** 意见内容 **/
    private String contect;

    /** 创建时间 **/
    private Date createTime;


    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContect() {
        return contect;
    }

    public void setContect(String contect) {
        this.contect = contect;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
