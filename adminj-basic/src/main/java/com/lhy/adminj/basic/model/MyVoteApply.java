package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 我的跟投申请
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyVoteApply implements Serializable {

    /** 申请ID **/
    private Long applyId;

    /** 审核用户ID **/
    private Long auditUserId;

    /** 申请跟投用户ID **/
    private Long applyUserId;

    /** 申请状态(W-待审核,P-同意,D-拒绝) **/
    private String status;

    /** 创建日期 **/
    private Date createDate;

    /** 创建日期 **/
    private Date updateDate;

    /** 删除标志(Y-是,N-否) **/
    private String isDel;

    /** 组合Id **/
    private Long groupId;


    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Long getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Long auditUserId) {
        this.auditUserId = auditUserId;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

}
