package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户好友申请记录
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserFriendApply implements Serializable {

    /** 用户好友申请ID **/
    private Long applyId;

    /** 申请人用户ID **/
    private Long applyUserId;

    /** 审核人用户ID(申请目标用户ID) **/
    private Long auditUserId;

    /** 申请简述 **/
    private String applyDesc;

    /** 申请状态(W-待好友审核,P-已添加,D-删除) **/
    private String applyStatus;

    /** 创建时间 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;

    /** 申请来源[1-微信，2-QQ，3-通讯录] **/
    private String applySource;

    /** 是否查看[1-未查看，2-查看] **/
    private String isRead;


    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Long getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Long auditUserId) {
        this.auditUserId = auditUserId;
    }

    public String getApplyDesc() {
        return applyDesc;
    }

    public void setApplyDesc(String applyDesc) {
        this.applyDesc = applyDesc;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getApplySource() {
        return applySource;
    }

    public void setApplySource(String applySource) {
        this.applySource = applySource;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

}
