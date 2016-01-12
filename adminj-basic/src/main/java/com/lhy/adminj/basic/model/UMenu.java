package com.lhy.adminj.basic.model;

import java.io.Serializable;

/**
 * 菜单表
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UMenu implements Serializable {

    /** 主键ID **/
    private Long id;

    /** 菜单名称 **/
    private String name;

    /** 菜单级别 **/
    private Long level;

    /** 父菜单ID **/
    private Long parentId;

    /** 是否叶子节点(0-否, 1-是) **/
    private Long isLeaf;

    /** URL **/
    private String url;

    /** 是否禁用(0-否,1-是) **/
    private Long isEnable;

    /** 排序 **/
    private Long sort;


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

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Long isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Long isEnable) {
        this.isEnable = isEnable;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

}
