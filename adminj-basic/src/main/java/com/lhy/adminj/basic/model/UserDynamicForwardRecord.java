package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户动态转发记录表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicForwardRecord implements Serializable {

    /** 转发ID **/
    private Long forwardId;

    /** 动态ID **/
    private Long dynamicId;

    /** 动态归属用户ID **/
    private Long userId;

    /** 转发用户ID **/
    private Long forwardUserId;

    /** 创建日期 **/
    private Date createDate;

    /** 修改时间 **/
    private Date updateDate;

    /** 删除标志(Y-是,N-否) **/
    private String isDel;


    public Long getForwardId() {
        return forwardId;
    }

    public void setForwardId(Long forwardId) {
        this.forwardId = forwardId;
    }

    public Long getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Long dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getForwardUserId() {
        return forwardUserId;
    }

    public void setForwardUserId(Long forwardUserId) {
        this.forwardUserId = forwardUserId;
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

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

}
