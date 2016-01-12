package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户动态表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicInfo implements Serializable {

    /** 动态ID,自增ID **/
    private Long dynamicId;

    /** 动态用户ID **/
    private Long userId;

    /** 动态原创用户ID,非转发时是用户ID **/
    private Long originalUserId;

    /** 动态类型(S-晒图,T-说说,Q-提问,F-转发) **/
    private String type;

    /** 动态标题 **/
    private String title;

    /** 动态描述 **/
    private String mark;

    /** 可以查看的人(1-所有人,2-跟投者,3-我的好友) **/
    private String seeRange;

    /** 可以评论的人(1-所有人,2-跟投者,3-我的好友) **/
    private String commentRange;

    /** 是否显示当前位置(Y-是,N-否) **/
    private String showLocation;

    /** 地理位置 **/
    private String local;

    /** 图片路径 **/
    private String imagePath;

    /** 查看是否要打赏(Y-是,N-否) **/
    private String seeIsReward;

    /** 查看打赏航币 **/
    private Double seeRewardSailCoinNum;

    /** 是否删除(Y-是,N-否) **/
    private String isDel;

    /** 转发数 **/
    private Long forwardNum;

    /** 点赞数 **/
    private Long praiseNum;

    /** 评论数 **/
    private Long commentNum;

    /** 分享数 **/
    private Long shareNum;

    /** 是否转发(Y-是,N-否) **/
    private String isForward;

    /** 创建日期 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;

    /**  **/
    private String remark;

    /** 父动态ID,当转发时才会有值 **/
    private Long parentDynamicId;

    /** 状态(W-待审核,P-审核通过,D-审核拒绝) **/
    private String auditStatus;

    /** 审核时间 **/
    private Date auditDate;

    /** 审核备注 **/
    private String auditDesc;

    /** 审核人 **/
    private String auditName;

    /** @给谁 **/
    private Long giveUserId;

    /** 晒单时的组合ID **/
    private Long groupId;

    /** 晒图是否录入(y-是,N-否) **/
    private String isInput;


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

    public Long getOriginalUserId() {
        return originalUserId;
    }

    public void setOriginalUserId(Long originalUserId) {
        this.originalUserId = originalUserId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSeeRange() {
        return seeRange;
    }

    public void setSeeRange(String seeRange) {
        this.seeRange = seeRange;
    }

    public String getCommentRange() {
        return commentRange;
    }

    public void setCommentRange(String commentRange) {
        this.commentRange = commentRange;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getSeeIsReward() {
        return seeIsReward;
    }

    public void setSeeIsReward(String seeIsReward) {
        this.seeIsReward = seeIsReward;
    }

    public Double getSeeRewardSailCoinNum() {
        return seeRewardSailCoinNum;
    }

    public void setSeeRewardSailCoinNum(Double seeRewardSailCoinNum) {
        this.seeRewardSailCoinNum = seeRewardSailCoinNum;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public Long getForwardNum() {
        return forwardNum;
    }

    public void setForwardNum(Long forwardNum) {
        this.forwardNum = forwardNum;
    }

    public Long getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Long praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Long commentNum) {
        this.commentNum = commentNum;
    }

    public Long getShareNum() {
        return shareNum;
    }

    public void setShareNum(Long shareNum) {
        this.shareNum = shareNum;
    }

    public String getIsForward() {
        return isForward;
    }

    public void setIsForward(String isForward) {
        this.isForward = isForward;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getParentDynamicId() {
        return parentDynamicId;
    }

    public void setParentDynamicId(Long parentDynamicId) {
        this.parentDynamicId = parentDynamicId;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public Long getGiveUserId() {
        return giveUserId;
    }

    public void setGiveUserId(Long giveUserId) {
        this.giveUserId = giveUserId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getIsInput() {
        return isInput;
    }

    public void setIsInput(String isInput) {
        this.isInput = isInput;
    }

}
