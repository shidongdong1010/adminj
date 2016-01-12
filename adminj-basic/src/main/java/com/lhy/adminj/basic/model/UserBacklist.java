package com.lhy.adminj.basic.model;

import com.lhy.adminj.basic.enumeration.YesOrNoEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户黑名单表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserBacklist implements Serializable {

    /** 用户ID,自增序列 **/
    private Long userId;

    /** 是否是评价回复黑名单（Y-是,N-否） **/
    private String replyBlacklist;

    /** 是否说说黑名单（Y-是,N-否） **/
    private String talkBlacklist;

    /** 是否晒图黑名单（Y-是,N-否） **/
    private String showBlacklist;

    /** 创建日期 **/
    private Date createDate;

    /** 更新日期 **/
    private Date updateDate;

    public UserBacklist(){

    }

    public UserBacklist(Long userId) {
        super();
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReplyBlacklist() {
        return replyBlacklist;
    }

    public void setReplyBlacklist(String replyBlacklist) {
        this.replyBlacklist = replyBlacklist;
    }

    public String getTalkBlacklist() {
        return talkBlacklist;
    }

    public void setTalkBlacklist(String talkBlacklist) {
        this.talkBlacklist = talkBlacklist;
    }

    public String getShowBlacklist() {
        return showBlacklist;
    }

    public void setShowBlacklist(String showBlacklist) {
        this.showBlacklist = showBlacklist;
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
    /**
     * 得到默认的黑名单信息
     * @param userId
     */
    public static UserBacklist userBacklistInit(Long userId,UserBacklist userBacklist){
        userBacklist.setUserId(userId);  // 用户ID
        if(StringUtils.isBlank(userBacklist.getReplyBlacklist())){
            userBacklist.setReplyBlacklist(YesOrNoEnum.N.getCode());  // 是否是评价回复黑名单
        }
        if(StringUtils.isBlank(userBacklist.getTalkBlacklist())){
            userBacklist.setTalkBlacklist(YesOrNoEnum.N.getCode());   // 是否说说黑名单
        }
        if(StringUtils.isBlank(userBacklist.getShowBlacklist())){
            userBacklist.setShowBlacklist(YesOrNoEnum.N.getCode());   // 是否晒图黑名单
        }
        userBacklist.setCreateDate(new Date()); // 创建时间
        userBacklist.setUpdateDate(new Date()); // 更新时间
        return userBacklist;
    }
}
