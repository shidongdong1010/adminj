package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户登陆日志
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserLoginInfo implements Serializable {

    /** 登陆表主键 **/
    private Long loginId;

    /** 登陆的用户ID **/
    private Long userId;

    /** 登陆用户名 **/
    private String userName;

    /** 登陆IP **/
    private String loginIp;

    /** 客户端不IP **/
    private String clientId;

    /** 客户端类型[0:android, 1:iOS] **/
    private Long clientType;

    /** 创建时间 **/
    private Date createDate;

    /** 连续登录次数 **/
    private Long loginContinueNum;


    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Long getClientType() {
        return clientType;
    }

    public void setClientType(Long clientType) {
        this.clientType = clientType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getLoginContinueNum() {
        return loginContinueNum;
    }

    public void setLoginContinueNum(Long loginContinueNum) {
        this.loginContinueNum = loginContinueNum;
    }

}
