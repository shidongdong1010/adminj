package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户动态评论表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicComment implements Serializable {

    /** 评论ID **/
    private Long commentId;

    /** 动态ID,自增ID **/
    private Long dynamicId;

    /** 评论者用户ID **/
    private Long userId;

    /** 被评论用户ID **/
    private Long commentUserId;

    /** 评论 **/
    private String comment;

    /** 点赞数 **/
    private Long praiseNum;

    /** 创建日期 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;

    /** 删除标志(Y-是,N-否) **/
    private String isDel;

    /** 是否显示地理位置(Y-是,N-否) **/
    private String showLocation;

    /** 地理位置 **/
    private String local;

    /** @给谁 **/
    private Long giveUserId;

    /** 图片路径 **/
    private String imagePath;


    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Long praiseNum) {
        this.praiseNum = praiseNum;
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

    public String getShowLocation() {
        return showLocation;
    }

    public void setShowLocation(String showLocation) {
        this.showLocation = showLocation;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Long getGiveUserId() {
        return giveUserId;
    }

    public void setGiveUserId(Long giveUserId) {
        this.giveUserId = giveUserId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
