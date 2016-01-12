package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户打招呼表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserMeetRecord implements Serializable {

    /** ID **/
    private Long meetId;

    /** 用户ID **/
    private Long userId;

    /** 附近好友ID **/
    private Long friendId;

    /** 亲密次数【每次加1】 **/
    private Double familiarSum;

    /** 打招呼 **/
    private String say;

    /** 创建日期 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;


    public Long getMeetId() {
        return meetId;
    }

    public void setMeetId(Long meetId) {
        this.meetId = meetId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public Double getFamiliarSum() {
        return familiarSum;
    }

    public void setFamiliarSum(Double familiarSum) {
        this.familiarSum = familiarSum;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
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
