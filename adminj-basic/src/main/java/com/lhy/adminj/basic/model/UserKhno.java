package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户卷商表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserKhno implements Serializable {

    /** ID **/
    private Long id;

    /** 1:上海证券 **/
    private Long brokerid;

    /** 卷商账户 **/
    private String khno;

    /** 用户Id **/
    private Long userid;

    /** 创建时间 **/
    private Date createTime;

    /** 是否删除[Y-是，N-否] **/
    private String isDel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrokerid() {
        return brokerid;
    }

    public void setBrokerid(Long brokerid) {
        this.brokerid = brokerid;
    }

    public String getKhno() {
        return khno;
    }

    public void setKhno(String khno) {
        this.khno = khno;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

}
