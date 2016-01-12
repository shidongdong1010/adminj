package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserDynamicSetBaseService;
import com.lhy.adminj.basic.dao.UserDynamicSetDao;

import com.lhy.adminj.basic.model.UserDynamicSet;

/**
 * 用户动态设置表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicSetBaseServiceImpl implements UserDynamicSetBaseService{
	@Autowired
	protected UserDynamicSetDao userDynamicSetDao;

	@Override
	public void save(UserDynamicSet userDynamicSet) {
		userDynamicSetDao.save(userDynamicSet);
	}
	
	@Override
	public void update(UserDynamicSet userDynamicSet) {
		userDynamicSetDao.update(userDynamicSet);
	}

	@Override
	public void modify(UserDynamicSet userDynamicSet) {
		userDynamicSetDao.modify(userDynamicSet);
	}

	@Override
	public void delete(Long userId){
		userDynamicSetDao.delete(userId);
	}

	@Override
	public void batchSave(List<UserDynamicSet> list){
		userDynamicSetDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserDynamicSet> list){
		userDynamicSetDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userDynamicSetDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param userId 用户ID
	 * @return UserDynamicSet
	 */
	public UserDynamicSet findById(Long userId){
		return userDynamicSetDao.findById(userId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicSet
	 * @return List
	 */
	public List<UserDynamicSet> find(UserDynamicSet userDynamicSet){
		return userDynamicSetDao.find(userDynamicSet);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicSet
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicSet> find(UserDynamicSet userDynamicSet, String[][] orders){
		return userDynamicSetDao.find(userDynamicSet, orders);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicSet
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicSet> find(UserDynamicSet userDynamicSet, Long offset, Long rows){
		return userDynamicSetDao.find(userDynamicSet, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicSet
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicSet> find(UserDynamicSet userDynamicSet, String[][] orders, Long offset, Long rows){
    	return userDynamicSetDao.find(userDynamicSet, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userDynamicSet
	 * @return Long
	 */
	public Long count(UserDynamicSet userDynamicSet){
		return userDynamicSetDao.count(userDynamicSet);
	}
}