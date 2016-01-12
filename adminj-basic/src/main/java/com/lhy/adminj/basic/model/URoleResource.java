package com.lhy.adminj.basic.model;

import java.io.Serializable;

/**
 * 角色-资源关系表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class URoleResource implements Serializable {

    /** 主键ID **/
    private Long id;

    /** 角色ID **/
    private Long roleId;

    /** 资源ID **/
    private Long resourceId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

}
