package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 牛人排名记录表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserGenius implements Serializable {

    /** 牛人表主键ID **/
    private Long geniusId;

    /** 用户ID **/
    private Long userId;

    /** 收益率排名 **/
    private Double earningsRateRank;

    /** 活跃度排名 **/
    private Double activeRank;

    /** 跟投人排名 **/
    private Double followRank;

    /** 创建时间 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;

    /** 排名权重 **/
    private Double rankWeight;


    public Long getGeniusId() {
        return geniusId;
    }

    public void setGeniusId(Long geniusId) {
        this.geniusId = geniusId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getEarningsRateRank() {
        return earningsRateRank;
    }

    public void setEarningsRateRank(Double earningsRateRank) {
        this.earningsRateRank = earningsRateRank;
    }

    public Double getActiveRank() {
        return activeRank;
    }

    public void setActiveRank(Double activeRank) {
        this.activeRank = activeRank;
    }

    public Double getFollowRank() {
        return followRank;
    }

    public void setFollowRank(Double followRank) {
        this.followRank = followRank;
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

    public Double getRankWeight() {
        return rankWeight;
    }

    public void setRankWeight(Double rankWeight) {
        this.rankWeight = rankWeight;
    }

}
