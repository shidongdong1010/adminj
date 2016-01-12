package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户动态点赞记录表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicCommentPraise implements Serializable {

    /** 点赞ID **/
    private Long praiseId;

    /** 评论ID **/
    private Long commentId;

    /** 点赞用户ID **/
    private Long userId;

    /** 被点赞用户ID **/
    private Long praiseUserId;

    /** 创建日期 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;

    /**  **/
    private String isDel;


    public Long getPraiseId() {
        return praiseId;
    }

    public void setPraiseId(Long praiseId) {
        this.praiseId = praiseId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPraiseUserId() {
        return praiseUserId;
    }

    public void setPraiseUserId(Long praiseUserId) {
        this.praiseUserId = praiseUserId;
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
