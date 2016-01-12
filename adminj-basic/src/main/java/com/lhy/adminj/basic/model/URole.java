package com.lhy.adminj.basic.model;

import java.io.Serializable;

/**
 * 角色表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class URole implements Serializable {

    /** 主键ID **/
    private Long id;

    /** 角色名称 **/
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
