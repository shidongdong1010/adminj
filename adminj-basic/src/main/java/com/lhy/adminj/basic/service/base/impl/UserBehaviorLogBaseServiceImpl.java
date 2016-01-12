package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserBehaviorLogBaseService;
import com.lhy.adminj.basic.dao.UserBehaviorLogDao;

import com.lhy.adminj.basic.model.UserBehaviorLog;

/**
 * 用户行为日志Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserBehaviorLogBaseServiceImpl implements UserBehaviorLogBaseService{
	@Autowired
	protected UserBehaviorLogDao userBehaviorLogDao;

	@Override
	public void save(UserBehaviorLog userBehaviorLog) {
		userBehaviorLogDao.save(userBehaviorLog);
	}
	
	@Override
	public void update(UserBehaviorLog userBehaviorLog) {
		userBehaviorLogDao.update(userBehaviorLog);
	}

	@Override
	public void modify(UserBehaviorLog userBehaviorLog) {
		userBehaviorLogDao.modify(userBehaviorLog);
	}

	@Override
	public void delete(Long id){
		userBehaviorLogDao.delete(id);
	}

	@Override
	public void batchSave(List<UserBehaviorLog> list){
		userBehaviorLogDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserBehaviorLog> list){
		userBehaviorLogDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userBehaviorLogDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id 
	 * @return UserBehaviorLog
	 */
	public UserBehaviorLog findById(Long id){
		return userBehaviorLogDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param userBehaviorLog
	 * @return List
	 */
	public List<UserBehaviorLog> find(UserBehaviorLog userBehaviorLog){
		return userBehaviorLogDao.find(userBehaviorLog);
	}

	/**
	 * 根据对象查询
	 * @param userBehaviorLog
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserBehaviorLog> find(UserBehaviorLog userBehaviorLog, String[][] orders){
		return userBehaviorLogDao.find(userBehaviorLog, orders);
	}

	/**
	 * 根据对象查询
	 * @param userBehaviorLog
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserBehaviorLog> find(UserBehaviorLog userBehaviorLog, Long offset, Long rows){
		return userBehaviorLogDao.find(userBehaviorLog, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userBehaviorLog
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserBehaviorLog> find(UserBehaviorLog userBehaviorLog, String[][] orders, Long offset, Long rows){
    	return userBehaviorLogDao.find(userBehaviorLog, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userBehaviorLog
	 * @return Long
	 */
	public Long count(UserBehaviorLog userBehaviorLog){
		return userBehaviorLogDao.count(userBehaviorLog);
	}
}