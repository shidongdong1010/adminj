package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户好友表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserFriends implements Serializable {

    /** 用户好友ID,自增序列 **/
    private Long friendId;

    /** 用户ID **/
    private Long userId;

    /** 好友用户ID **/
    private Long friendUserId;

    /** 共同好友数 **/
    private Long commonFriendNum;

    /** 创建时间 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;

    /**  **/
    private String friendRemark;

    /** 好友标签[1-朋友，2-家人，3-同事（二期数据库取）] **/
    private String friendLabel;


    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendUserId() {
        return friendUserId;
    }

    public void setFriendUserId(Long friendUserId) {
        this.friendUserId = friendUserId;
    }

    public Long getCommonFriendNum() {
        return commonFriendNum;
    }

    public void setCommonFriendNum(Long commonFriendNum) {
        this.commonFriendNum = commonFriendNum;
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

    public String getFriendRemark() {
        return friendRemark;
    }

    public void setFriendRemark(String friendRemark) {
        this.friendRemark = friendRemark;
    }

    public String getFriendLabel() {
        return friendLabel;
    }

    public void setFriendLabel(String friendLabel) {
        this.friendLabel = friendLabel;
    }

}
