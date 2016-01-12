package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 短信信息表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class SysSms implements Serializable {

    /** 短信ID **/
    private Long smsId;

    /** 用户ID **/
    private Long userId;

    /** 短信号码 **/
    private String userPhone;

    /** 状态[S-发送成功，F-发送失败] **/
    private String status;

    /** 短信内容 **/
    private String smsDesc;

    /** 创建时间 **/
    private Date createTime;

    /** 发送时间 **/
    private Date sendTime;

    /** 发送类型 **/
    private String sendType;

    /** 发送IP **/
    private String sendIp;


    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSmsDesc() {
        return smsDesc;
    }

    public void setSmsDesc(String smsDesc) {
        this.smsDesc = smsDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getSendIp() {
        return sendIp;
    }

    public void setSendIp(String sendIp) {
        this.sendIp = sendIp;
    }

}
