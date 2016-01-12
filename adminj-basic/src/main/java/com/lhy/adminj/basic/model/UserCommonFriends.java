package com.lhy.adminj.basic.model;

import java.io.Serializable;

/**
 * 用户共同好友
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserCommonFriends implements Serializable {

    /** 主键 **/
    private Long commonFriendId;

    /** 用户A id **/
    private Long useraId;

    /** 用户B id **/
    private Long userbId;

    /** 共同好友用户id **/
    private Long commonFriendUserid;

    /** 共同好友用户名 **/
    private String commonFriendUsername;

    /** 共同好友昵称 **/
    private String commonFriendNickname;


    public Long getCommonFriendId() {
        return commonFriendId;
    }

    public void setCommonFriendId(Long commonFriendId) {
        this.commonFriendId = commonFriendId;
    }

    public Long getUseraId() {
        return useraId;
    }

    public void setUseraId(Long useraId) {
        this.useraId = useraId;
    }

    public Long getUserbId() {
        return userbId;
    }

    public void setUserbId(Long userbId) {
        this.userbId = userbId;
    }

    public Long getCommonFriendUserid() {
        return commonFriendUserid;
    }

    public void setCommonFriendUserid(Long commonFriendUserid) {
        this.commonFriendUserid = commonFriendUserid;
    }

    public String getCommonFriendUsername() {
        return commonFriendUsername;
    }

    public void setCommonFriendUsername(String commonFriendUsername) {
        this.commonFriendUsername = commonFriendUsername;
    }

    public String getCommonFriendNickname() {
        return commonFriendNickname;
    }

    public void setCommonFriendNickname(String commonFriendNickname) {
        this.commonFriendNickname = commonFriendNickname;
    }

}
