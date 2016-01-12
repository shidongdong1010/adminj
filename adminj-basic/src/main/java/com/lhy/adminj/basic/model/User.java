package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class User implements Serializable {

    /** 用户ID,自增序列 **/
    private Long userId;

    /** 用户名 **/
    private String userName;

    /** 密码 **/
    private String password;

    /** 绑定手机 **/
    private String mobile;

    /** 注册IP **/
    private String regIp;

    /** 会员类型(0-内部,1-牛人,2-一般投资者) **/
    private String type;

    /** 账号状态(0-正常,1-锁定,2-已删除) **/
    private String status;

    /** 客户端ID **/
    private String clientId;

    /** 客户端类型：[0:android, 1:iOS] **/
    private String clientType;

    /** 推送设置(0-关,1-开) **/
    private String pushSwitch;

    /** 航币数 **/
    private Double sailCurrency;

    /** 级别 **/
    private Long level;

    /** 邮箱 **/
    private String email;

    /** 用户来源[0:领航员, 1:QQ, 2:微信, 3:新浪微博] **/
    private String userSource;

    /** qq号 **/
    private String qq;

    /** 微信号 **/
    private String weChat;

    /** 微博 **/
    private String weibo;

    /** 创建日期 **/
    private Date createDate;

    /** 更新日期 **/
    private Date updateDate;

    /** 第三方用户ID **/
    private String openId;

    /** 经度 **/
    private Double longitude;

    /** 纬度 **/
    private Double latitude;

    /** 最后一次登录城市 **/
    private String lastcity;

    /** 版本号 **/
    private Long version;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getPushSwitch() {
        return pushSwitch;
    }

    public void setPushSwitch(String pushSwitch) {
        this.pushSwitch = pushSwitch;
    }

    public Double getSailCurrency() {
        return sailCurrency;
    }

    public void setSailCurrency(Double sailCurrency) {
        this.sailCurrency = sailCurrency;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserSource() {
        return userSource;
    }

    public void setUserSource(String userSource) {
        this.userSource = userSource;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getLastcity() {
        return lastcity;
    }

    public void setLastcity(String lastcity) {
        this.lastcity = lastcity;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
