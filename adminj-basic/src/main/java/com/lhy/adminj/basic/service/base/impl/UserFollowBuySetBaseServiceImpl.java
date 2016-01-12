package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserFollowBuySetBaseService;
import com.lhy.adminj.basic.dao.UserFollowBuySetDao;

import com.lhy.adminj.basic.model.UserFollowBuySet;

/**
 * 用户跟买设置Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserFollowBuySetBaseServiceImpl implements UserFollowBuySetBaseService{
	@Autowired
	protected UserFollowBuySetDao userFollowBuySetDao;

	@Override
	public void save(UserFollowBuySet userFollowBuySet) {
		userFollowBuySetDao.save(userFollowBuySet);
	}
	
	@Override
	public void update(UserFollowBuySet userFollowBuySet) {
		userFollowBuySetDao.update(userFollowBuySet);
	}

	@Override
	public void modify(UserFollowBuySet userFollowBuySet) {
		userFollowBuySetDao.modify(userFollowBuySet);
	}

	@Override
	public void delete(Long userId){
		userFollowBuySetDao.delete(userId);
	}

	@Override
	public void batchSave(List<UserFollowBuySet> list){
		userFollowBuySetDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserFollowBuySet> list){
		userFollowBuySetDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userFollowBuySetDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param userId 用户ID
	 * @return UserFollowBuySet
	 */
	public UserFollowBuySet findById(Long userId){
		return userFollowBuySetDao.findById(userId);
	}

	/**
	 * 根据对象查询
	 * @param userFollowBuySet
	 * @return List
	 */
	public List<UserFollowBuySet> find(UserFollowBuySet userFollowBuySet){
		return userFollowBuySetDao.find(userFollowBuySet);
	}

	/**
	 * 根据对象查询
	 * @param userFollowBuySet
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserFollowBuySet> find(UserFollowBuySet userFollowBuySet, String[][] orders){
		return userFollowBuySetDao.find(userFollowBuySet, orders);
	}

	/**
	 * 根据对象查询
	 * @param userFollowBuySet
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFollowBuySet> find(UserFollowBuySet userFollowBuySet, Long offset, Long rows){
		return userFollowBuySetDao.find(userFollowBuySet, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userFollowBuySet
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFollowBuySet> find(UserFollowBuySet userFollowBuySet, String[][] orders, Long offset, Long rows){
    	return userFollowBuySetDao.find(userFollowBuySet, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userFollowBuySet
	 * @return Long
	 */
	public Long count(UserFollowBuySet userFollowBuySet){
		return userFollowBuySetDao.count(userFollowBuySet);
	}
}