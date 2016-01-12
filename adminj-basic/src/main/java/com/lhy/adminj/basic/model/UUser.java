package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UUser implements Serializable {

    /** 主键ID **/
    private Long id;

    /** 用户名 **/
    private String userName;

    /** 密码 **/
    private String password;

    /** 密码是否过期(0-正常,1-已过期) **/
    private Long isExpired;

    /** 是否锁定(0-正常,1-锁定) **/
    private Long isLocked;

    /** 是否禁用(0-否,1-是) **/
    private Long isEnable;

    /** 手机号 **/
    private String mobile;

    /** 用户全称 **/
    private String fullname;

    /** 最后登陆时间 **/
    private Date lastLoginTime;

    /** 登录错误次数 **/
    private Long loginErrorCount;

    /** 创建时间 **/
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Long isExpired) {
        this.isExpired = isExpired;
    }

    public Long getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Long isLocked) {
        this.isLocked = isLocked;
    }

    public Long getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Long isEnable) {
        this.isEnable = isEnable;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getLoginErrorCount() {
        return loginErrorCount;
    }

    public void setLoginErrorCount(Long loginErrorCount) {
        this.loginErrorCount = loginErrorCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
