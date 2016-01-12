package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户动态设置表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicSet implements Serializable {

    /** 用户ID **/
    private Long userId;

    /** 可以查看的人(1-所有人,2-跟投者,3-我的好友) **/
    private String seeRange;

    /** 可以评论的人(1-所有人,2-跟投者,3-我的好友) **/
    private String commentRange;

    /** 是否要打赏(Y-是,N-否) **/
    private String needReward;

    /**  **/
    private Double rewardSailCoin;

    /** 是否显示当前位置(Y-是,N-否) **/
    private String showLocation;

    /** 地理位置 **/
    private String local;

    /** 创建时间 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getNeedReward() {
        return needReward;
    }

    public void setNeedReward(String needReward) {
        this.needReward = needReward;
    }

    public Double getRewardSailCoin() {
        return rewardSailCoin;
    }

    public void setRewardSailCoin(Double rewardSailCoin) {
        this.rewardSailCoin = rewardSailCoin;
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
