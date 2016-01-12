package com.lhy.adminj.basic.model;

import com.lhy.adminj.basic.enumeration.NumEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户统计记录表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserStatRecord implements Serializable {

    /** 用户ID **/
    private Long userId;

    /** 动态数 **/
    private Long dynamicNum;

    /** 关注数 **/
    private Long attentionNum;

    /** 跟买数 **/
    private Long followBuyNum;

    /** 好友数 **/
    private Long friendsNum;

    /** 组合数 **/
    private Long groupNum;

    /** 交易数 **/
    private Long tradeNum;

    /** 创建日期 **/
    private Date createDate;

    /** 更新日期 **/
    private Date updateDate;

    /** 登陆数 **/
    private Long loginNum;

    /** 说说数 **/
    private Long talkNum;

    /** 晒单数 **/
    private Long orderNum;

    /** 转发数 **/
    private Long forwardNum;

    /** 点赞数 **/
    private Long praiseNum;

    /** 评论数 **/
    private Long commentNum;

    /** 分享数 **/
    private Long shareNum;

    /** 打赏数 **/
    private Long coinNum;

    public UserStatRecord(){

    }

    public UserStatRecord(Long userId) {
        super();
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDynamicNum() {
        return dynamicNum;
    }

    public void setDynamicNum(Long dynamicNum) {
        this.dynamicNum = dynamicNum;
    }

    public Long getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(Long attentionNum) {
        this.attentionNum = attentionNum;
    }

    public Long getFollowBuyNum() {
        return followBuyNum;
    }

    public void setFollowBuyNum(Long followBuyNum) {
        this.followBuyNum = followBuyNum;
    }

    public Long getFriendsNum() {
        return friendsNum;
    }

    public void setFriendsNum(Long friendsNum) {
        this.friendsNum = friendsNum;
    }

    public Long getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Long groupNum) {
        this.groupNum = groupNum;
    }

    public Long getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(Long tradeNum) {
        this.tradeNum = tradeNum;
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

    public Long getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(Long loginNum) {
        this.loginNum = loginNum;
    }

    public Long getTalkNum() {
        return talkNum;
    }

    public void setTalkNum(Long talkNum) {
        this.talkNum = talkNum;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
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

    public Long getCoinNum() {
        return coinNum;
    }

    public void setCoinNum(Long coinNum) {
        this.coinNum = coinNum;
    }

    /**
     * 得到用户统计信息的默认值
     *
     * @param userId 用户ID
     */
    public static UserStatRecord userStatRecordInit(Long userId,UserStatRecord userStatRecord){
        userStatRecord.setUserId(userId); // 用户ID
        if(null==userStatRecord.getDynamicNum()){
            userStatRecord.setDynamicNum(NumEnum.ZERO.getNumLong()); // 动态数
        }
        if(null==userStatRecord.getAttentionNum()){
            userStatRecord.setAttentionNum(NumEnum.ZERO.getNumLong()); // 关注数
        }
        if(null==userStatRecord.getFollowBuyNum()){
            userStatRecord.setFollowBuyNum(NumEnum.ZERO.getNumLong()); // 跟买数
        }
        if(null==userStatRecord.getFriendsNum()){
            userStatRecord.setFriendsNum(NumEnum.ZERO.getNumLong()); // 好友数
        }
        if(null==userStatRecord.getGroupNum()){
            userStatRecord.setGroupNum(NumEnum.ZERO.getNumLong()); // 组合数
        }
        if(null==userStatRecord.getTradeNum()){
            userStatRecord.setTradeNum(NumEnum.ZERO.getNumLong()); // 交易数
        }
        if(null==userStatRecord.getLoginNum()){
            userStatRecord.setLoginNum(NumEnum.ZERO.getNumLong()); // 登陆数
        }
        if(null==userStatRecord.getTalkNum()){
            userStatRecord.setTalkNum(NumEnum.ZERO.getNumLong()); // 说说数
        }
        if(null==userStatRecord.getOrderNum()){
            userStatRecord.setOrderNum(NumEnum.ZERO.getNumLong()); // 晒单数
        }
        if(null==userStatRecord.getForwardNum()){
            userStatRecord.setForwardNum(NumEnum.ZERO.getNumLong()); // 转发数
        }
        if(null==userStatRecord.getPraiseNum()){
            userStatRecord.setPraiseNum(NumEnum.ZERO.getNumLong()); // 点赞数
        }
        if(null==userStatRecord.getCommentNum()){
            userStatRecord.setCommentNum(NumEnum.ZERO.getNumLong()); // 评论数
        }
        if(null==userStatRecord.getShareNum()){
            userStatRecord.setShareNum(NumEnum.ZERO.getNumLong()); // 分享数
        }
        if(null==userStatRecord.getCoinNum()){
            userStatRecord.setCoinNum(NumEnum.ZERO.getNumLong()); // 打赏数
        }
        Date currDate = new Date();
        userStatRecord.setCreateDate(currDate); // 创建时间
        userStatRecord.setUpdateDate(currDate); // 更新时间
        return userStatRecord;
    }
}
