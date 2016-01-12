package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UOperLog implements Serializable {

    /** 主键ID **/
    private Long id;

    /** 业务类型(0-添加用户, 1-注销用户, 2-锁定用户, 3-启用用户,4-用户赋角色,5-用户去角色,10-添加角色,11-禁用角色, 12-启用角色,13-角色赋权限,14-角色去权限,20-添加权限, 21-修改权限, 22-禁用权限,23-启用权限) **/
    private Long appType;

    /** 关联操作的ID **/
    private Long appId;

    /** 操作描述 **/
    private String desc;

    /** 操作人ID **/
    private Long userId;

    /** 操作人的IP **/
    private String ip;

    /** 创建时间 **/
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppType() {
        return appType;
    }

    public void setAppType(Long appType) {
        this.appType = appType;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
