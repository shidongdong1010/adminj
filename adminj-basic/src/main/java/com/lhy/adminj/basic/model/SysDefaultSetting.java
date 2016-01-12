package com.lhy.adminj.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 默认值设置表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class SysDefaultSetting implements Serializable {

    /** 代码 **/
    private String code;

    /** 默认值 **/
    private String value;

    /** 默认值说明 **/
    private String desc;

    /**  **/
    private Date createTime;

    /**  **/
    private Long createUserId;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

}
