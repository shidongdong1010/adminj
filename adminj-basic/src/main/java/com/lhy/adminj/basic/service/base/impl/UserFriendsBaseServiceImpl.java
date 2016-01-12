package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserFriendsBaseService;
import com.lhy.adminj.basic.dao.UserFriendsDao;

import com.lhy.adminj.basic.model.UserFriends;

/**
 * 用户好友表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserFriendsBaseServiceImpl implements UserFriendsBaseService{
	@Autowired
	protected UserFriendsDao userFriendsDao;

	@Override
	public void save(UserFriends userFriends) {
		userFriendsDao.save(userFriends);
	}
	
	@Override
	public void update(UserFriends userFriends) {
		userFriendsDao.update(userFriends);
	}

	@Override
	public void modify(UserFriends userFriends) {
		userFriendsDao.modify(userFriends);
	}

	@Override
	public void delete(Long friendId){
		userFriendsDao.delete(friendId);
	}

	@Override
	public void batchSave(List<UserFriends> list){
		userFriendsDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserFriends> list){
		userFriendsDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userFriendsDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param friendId 用户好友ID,自增序列
	 * @return UserFriends
	 */
	public UserFriends findById(Long friendId){
		return userFriendsDao.findById(friendId);
	}

	/**
	 * 根据对象查询
	 * @param userFriends
	 * @return List
	 */
	public List<UserFriends> find(UserFriends userFriends){
		return userFriendsDao.find(userFriends);
	}

	/**
	 * 根据对象查询
	 * @param userFriends
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserFriends> find(UserFriends userFriends, String[][] orders){
		return userFriendsDao.find(userFriends, orders);
	}

	/**
	 * 根据对象查询
	 * @param userFriends
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFriends> find(UserFriends userFriends, Long offset, Long rows){
		return userFriendsDao.find(userFriends, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userFriends
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFriends> find(UserFriends userFriends, String[][] orders, Long offset, Long rows){
    	return userFriendsDao.find(userFriends, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userFriends
	 * @return Long
	 */
	public Long count(UserFriends userFriends){
		return userFriendsDao.count(userFriends);
	}
}