package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 我的组合评论
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupComment implements Serializable {

    /** 组合评论ID **/
    private Long commentId;

    /** 父评论ID,一级默认为0 **/
    private Long parentCommentId;

    /** 被评论用户ID **/
    private Long commentUserId;

    /** 被评论组合ID **/
    private Long groupId;

    /** 评论者用户ID **/
    private Long reviewerUserId;

    /** 评论转发数 **/
    private Long forwardNum;

    /** 评论数 **/
    private Long commentNum;

    /** 评论 **/
    private String comment;

    /** 创建时间 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;


    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public Long getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getReviewerUserId() {
        return reviewerUserId;
    }

    public void setReviewerUserId(Long reviewerUserId) {
        this.reviewerUserId = reviewerUserId;
    }

    public Long getForwardNum() {
        return forwardNum;
    }

    public void setForwardNum(Long forwardNum) {
        this.forwardNum = forwardNum;
    }

    public Long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Long commentNum) {
        this.commentNum = commentNum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

}
