package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.URoleBaseService;
import com.lhy.adminj.basic.dao.URoleDao;

import com.lhy.adminj.basic.model.URole;

/**
 * 角色表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class URoleBaseServiceImpl implements URoleBaseService{
	@Autowired
	protected URoleDao uRoleDao;

	@Override
	public void save(URole uRole) {
		uRoleDao.save(uRole);
	}
	
	@Override
	public void update(URole uRole) {
		uRoleDao.update(uRole);
	}

	@Override
	public void modify(URole uRole) {
		uRoleDao.modify(uRole);
	}

	@Override
	public void delete(Long id){
		uRoleDao.delete(id);
	}

	@Override
	public void batchSave(List<URole> list){
		uRoleDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<URole> list){
		uRoleDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		uRoleDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return URole
	 */
	public URole findById(Long id){
		return uRoleDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param uRole
	 * @return List
	 */
	public List<URole> find(URole uRole){
		return uRoleDao.find(uRole);
	}

	/**
	 * 根据对象查询
	 * @param uRole
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<URole> find(URole uRole, String[][] orders){
		return uRoleDao.find(uRole, orders);
	}

	/**
	 * 根据对象查询
	 * @param uRole
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<URole> find(URole uRole, Long offset, Long rows){
		return uRoleDao.find(uRole, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uRole
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<URole> find(URole uRole, String[][] orders, Long offset, Long rows){
    	return uRoleDao.find(uRole, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param uRole
	 * @return Long
	 */
	public Long count(URole uRole){
		return uRoleDao.count(uRole);
	}
}