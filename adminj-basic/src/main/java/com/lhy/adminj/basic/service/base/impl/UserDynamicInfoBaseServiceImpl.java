package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserDynamicInfoBaseService;
import com.lhy.adminj.basic.dao.UserDynamicInfoDao;

import com.lhy.adminj.basic.model.UserDynamicInfo;

/**
 * 用户动态表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicInfoBaseServiceImpl implements UserDynamicInfoBaseService{
	@Autowired
	protected UserDynamicInfoDao userDynamicInfoDao;

	@Override
	public void save(UserDynamicInfo userDynamicInfo) {
		userDynamicInfoDao.save(userDynamicInfo);
	}
	
	@Override
	public void update(UserDynamicInfo userDynamicInfo) {
		userDynamicInfoDao.update(userDynamicInfo);
	}

	@Override
	public void modify(UserDynamicInfo userDynamicInfo) {
		userDynamicInfoDao.modify(userDynamicInfo);
	}

	@Override
	public void delete(Long dynamicId){
		userDynamicInfoDao.delete(dynamicId);
	}

	@Override
	public void batchSave(List<UserDynamicInfo> list){
		userDynamicInfoDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserDynamicInfo> list){
		userDynamicInfoDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userDynamicInfoDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param dynamicId 动态ID,自增ID
	 * @return UserDynamicInfo
	 */
	public UserDynamicInfo findById(Long dynamicId){
		return userDynamicInfoDao.findById(dynamicId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicInfo
	 * @return List
	 */
	public List<UserDynamicInfo> find(UserDynamicInfo userDynamicInfo){
		return userDynamicInfoDao.find(userDynamicInfo);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicInfo> find(UserDynamicInfo userDynamicInfo, String[][] orders){
		return userDynamicInfoDao.find(userDynamicInfo, orders);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicInfo> find(UserDynamicInfo userDynamicInfo, Long offset, Long rows){
		return userDynamicInfoDao.find(userDynamicInfo, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicInfo> find(UserDynamicInfo userDynamicInfo, String[][] orders, Long offset, Long rows){
    	return userDynamicInfoDao.find(userDynamicInfo, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userDynamicInfo
	 * @return Long
	 */
	public Long count(UserDynamicInfo userDynamicInfo){
		return userDynamicInfoDao.count(userDynamicInfo);
	}
}