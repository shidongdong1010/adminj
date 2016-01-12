package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户跟买设置
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserFollowBuySet implements Serializable {

    /** 用户ID **/
    private Long userId;

    /** 跟买人数 **/
    private Long followBuyNum;

    /** 可以查看的人(1-所有人,2-跟投者,3-我的好友) **/
    private String seeRange;

    /** 是否要打赏(Y-是,N-否) **/
    private String needReward;

    /** 打赏航币 **/
    private Long rewardSailCoin;

    /** 创建日期 **/
    private Date createDate;

    /** 更新时间 **/
    private Date updateDate;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFollowBuyNum() {
        return followBuyNum;
    }

    public void setFollowBuyNum(Long followBuyNum) {
        this.followBuyNum = followBuyNum;
    }

    public String getSeeRange() {
        return seeRange;
    }

    public void setSeeRange(String seeRange) {
        this.seeRange = seeRange;
    }

    public String getNeedReward() {
        return needReward;
    }

    public void setNeedReward(String needReward) {
        this.needReward = needReward;
    }

    public Long getRewardSailCoin() {
        return rewardSailCoin;
    }

    public void setRewardSailCoin(Long rewardSailCoin) {
        this.rewardSailCoin = rewardSailCoin;
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
