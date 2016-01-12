package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户消息表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserMessage implements Serializable {

    /** 用户消息表ID **/
    private Long messageId;

    /** 消息ID **/
    private Long messageTypeId;

    /** 消息类型[1-调仓，2-晒单，3-发表说说] **/
    private String messageType;

    /** 发送牛人ID **/
    private Long sentUserId;

    /** 接收的关注人ID **/
    private Long getUserId;

    /** 创建时间 **/
    private Date createTime;

    /** 消息描述 **/
    private String messageDesc;

    /** 是否阅读[Y-是，N-否] **/
    private String isRead;

    /** 是否删除[Y-是，N-否] **/
    private String isDel;


    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(Long messageTypeId) {
        this.messageTypeId = messageTypeId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Long getSentUserId() {
        return sentUserId;
    }

    public void setSentUserId(Long sentUserId) {
        this.sentUserId = sentUserId;
    }

    public Long getGetUserId() {
        return getUserId;
    }

    public void setGetUserId(Long getUserId) {
        this.getUserId = getUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMessageDesc() {
        return messageDesc;
    }

    public void setMessageDesc(String messageDesc) {
        this.messageDesc = messageDesc;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

}
