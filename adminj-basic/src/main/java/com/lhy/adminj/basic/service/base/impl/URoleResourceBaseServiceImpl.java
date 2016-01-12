package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.URoleResourceBaseService;
import com.lhy.adminj.basic.dao.URoleResourceDao;

import com.lhy.adminj.basic.model.URoleResource;

/**
 * 角色-资源关系表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class URoleResourceBaseServiceImpl implements URoleResourceBaseService{
	@Autowired
	protected URoleResourceDao uRoleResourceDao;

	@Override
	public void save(URoleResource uRoleResource) {
		uRoleResourceDao.save(uRoleResource);
	}
	
	@Override
	public void update(URoleResource uRoleResource) {
		uRoleResourceDao.update(uRoleResource);
	}

	@Override
	public void modify(URoleResource uRoleResource) {
		uRoleResourceDao.modify(uRoleResource);
	}

	@Override
	public void delete(Long id){
		uRoleResourceDao.delete(id);
	}

	@Override
	public void batchSave(List<URoleResource> list){
		uRoleResourceDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<URoleResource> list){
		uRoleResourceDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		uRoleResourceDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return URoleResource
	 */
	public URoleResource findById(Long id){
		return uRoleResourceDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param uRoleResource
	 * @return List
	 */
	public List<URoleResource> find(URoleResource uRoleResource){
		return uRoleResourceDao.find(uRoleResource);
	}

	/**
	 * 根据对象查询
	 * @param uRoleResource
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<URoleResource> find(URoleResource uRoleResource, String[][] orders){
		return uRoleResourceDao.find(uRoleResource, orders);
	}

	/**
	 * 根据对象查询
	 * @param uRoleResource
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<URoleResource> find(URoleResource uRoleResource, Long offset, Long rows){
		return uRoleResourceDao.find(uRoleResource, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uRoleResource
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<URoleResource> find(URoleResource uRoleResource, String[][] orders, Long offset, Long rows){
    	return uRoleResourceDao.find(uRoleResource, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param uRoleResource
	 * @return Long
	 */
	public Long count(URoleResource uRoleResource){
		return uRoleResourceDao.count(uRoleResource);
	}
}