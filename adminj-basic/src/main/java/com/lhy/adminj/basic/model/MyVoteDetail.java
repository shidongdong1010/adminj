package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 我的跟投详情
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyVoteDetail implements Serializable {

    /** 跟头详情ID **/
    private Long voteDetailId;

    /** 组合归属用户ID **/
    private Long groupUserId;

    /** 跟投用户ID **/
    private Long voteUserId;

    /** 组合ID **/
    private Long groupId;

    /** 状态(W-待审核,P-同意,D-拒绝) **/
    private String status;

    /** 创建日期 **/
    private Date createDate;

    /** 创建日期 **/
    private Date updateDate;

    /** 删除标志(Y-是,N-否) **/
    private String isDel;


    public Long getVoteDetailId() {
        return voteDetailId;
    }

    public void setVoteDetailId(Long voteDetailId) {
        this.voteDetailId = voteDetailId;
    }

    public Long getGroupUserId() {
        return groupUserId;
    }

    public void setGroupUserId(Long groupUserId) {
        this.groupUserId = groupUserId;
    }

    public Long getVoteUserId() {
        return voteUserId;
    }

    public void setVoteUserId(Long voteUserId) {
        this.voteUserId = voteUserId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

}
