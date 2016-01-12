package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UUserBaseService;
import com.lhy.adminj.basic.dao.UUserDao;

import com.lhy.adminj.basic.model.UUser;

/**
 * 用户表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UUserBaseServiceImpl implements UUserBaseService{
	@Autowired
	protected UUserDao uUserDao;

	@Override
	public void save(UUser uUser) {
		uUserDao.save(uUser);
	}
	
	@Override
	public void update(UUser uUser) {
		uUserDao.update(uUser);
	}

	@Override
	public void modify(UUser uUser) {
		uUserDao.modify(uUser);
	}

	@Override
	public void delete(Long id){
		uUserDao.delete(id);
	}

	@Override
	public void batchSave(List<UUser> list){
		uUserDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UUser> list){
		uUserDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		uUserDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return UUser
	 */
	public UUser findById(Long id){
		return uUserDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param uUser
	 * @return List
	 */
	public List<UUser> find(UUser uUser){
		return uUserDao.find(uUser);
	}

	/**
	 * 根据对象查询
	 * @param uUser
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UUser> find(UUser uUser, String[][] orders){
		return uUserDao.find(uUser, orders);
	}

	/**
	 * 根据对象查询
	 * @param uUser
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UUser> find(UUser uUser, Long offset, Long rows){
		return uUserDao.find(uUser, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uUser
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UUser> find(UUser uUser, String[][] orders, Long offset, Long rows){
    	return uUserDao.find(uUser, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param uUser
	 * @return Long
	 */
	public Long count(UUser uUser){
		return uUserDao.count(uUser);
	}
}