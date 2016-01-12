package com.lhy.adminj.basic.model;

import java.io.Serializable;

/**
 * 用户角色关系表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UUserRole implements Serializable {

    /** 主键ID **/
    private Long id;

    /** 用户ID **/
    private Long userId;

    /** 角色ID **/
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}
