package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UUserRoleBaseService;
import com.lhy.adminj.basic.dao.UUserRoleDao;

import com.lhy.adminj.basic.model.UUserRole;

/**
 * 用户角色关系表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UUserRoleBaseServiceImpl implements UUserRoleBaseService{
	@Autowired
	protected UUserRoleDao uUserRoleDao;

	@Override
	public void save(UUserRole uUserRole) {
		uUserRoleDao.save(uUserRole);
	}
	
	@Override
	public void update(UUserRole uUserRole) {
		uUserRoleDao.update(uUserRole);
	}

	@Override
	public void modify(UUserRole uUserRole) {
		uUserRoleDao.modify(uUserRole);
	}

	@Override
	public void delete(Long id){
		uUserRoleDao.delete(id);
	}

	@Override
	public void batchSave(List<UUserRole> list){
		uUserRoleDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UUserRole> list){
		uUserRoleDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		uUserRoleDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return UUserRole
	 */
	public UUserRole findById(Long id){
		return uUserRoleDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param uUserRole
	 * @return List
	 */
	public List<UUserRole> find(UUserRole uUserRole){
		return uUserRoleDao.find(uUserRole);
	}

	/**
	 * 根据对象查询
	 * @param uUserRole
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UUserRole> find(UUserRole uUserRole, String[][] orders){
		return uUserRoleDao.find(uUserRole, orders);
	}

	/**
	 * 根据对象查询
	 * @param uUserRole
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UUserRole> find(UUserRole uUserRole, Long offset, Long rows){
		return uUserRoleDao.find(uUserRole, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uUserRole
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UUserRole> find(UUserRole uUserRole, String[][] orders, Long offset, Long rows){
    	return uUserRoleDao.find(uUserRole, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param uUserRole
	 * @return Long
	 */
	public Long count(UUserRole uUserRole){
		return uUserRoleDao.count(uUserRole);
	}
}