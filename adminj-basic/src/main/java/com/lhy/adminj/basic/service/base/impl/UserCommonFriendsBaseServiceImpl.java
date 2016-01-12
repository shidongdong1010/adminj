package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserCommonFriendsBaseService;
import com.lhy.adminj.basic.dao.UserCommonFriendsDao;

import com.lhy.adminj.basic.model.UserCommonFriends;

/**
 * 用户共同好友Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserCommonFriendsBaseServiceImpl implements UserCommonFriendsBaseService{
	@Autowired
	protected UserCommonFriendsDao userCommonFriendsDao;

	@Override
	public void save(UserCommonFriends userCommonFriends) {
		userCommonFriendsDao.save(userCommonFriends);
	}
	
	@Override
	public void update(UserCommonFriends userCommonFriends) {
		userCommonFriendsDao.update(userCommonFriends);
	}

	@Override
	public void modify(UserCommonFriends userCommonFriends) {
		userCommonFriendsDao.modify(userCommonFriends);
	}

	@Override
	public void delete(Long commonFriendId){
		userCommonFriendsDao.delete(commonFriendId);
	}

	@Override
	public void batchSave(List<UserCommonFriends> list){
		userCommonFriendsDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserCommonFriends> list){
		userCommonFriendsDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userCommonFriendsDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param commonFriendId 主键
	 * @return UserCommonFriends
	 */
	public UserCommonFriends findById(Long commonFriendId){
		return userCommonFriendsDao.findById(commonFriendId);
	}

	/**
	 * 根据对象查询
	 * @param userCommonFriends
	 * @return List
	 */
	public List<UserCommonFriends> find(UserCommonFriends userCommonFriends){
		return userCommonFriendsDao.find(userCommonFriends);
	}

	/**
	 * 根据对象查询
	 * @param userCommonFriends
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserCommonFriends> find(UserCommonFriends userCommonFriends, String[][] orders){
		return userCommonFriendsDao.find(userCommonFriends, orders);
	}

	/**
	 * 根据对象查询
	 * @param userCommonFriends
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserCommonFriends> find(UserCommonFriends userCommonFriends, Long offset, Long rows){
		return userCommonFriendsDao.find(userCommonFriends, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userCommonFriends
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserCommonFriends> find(UserCommonFriends userCommonFriends, String[][] orders, Long offset, Long rows){
    	return userCommonFriendsDao.find(userCommonFriends, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userCommonFriends
	 * @return Long
	 */
	public Long count(UserCommonFriends userCommonFriends){
		return userCommonFriendsDao.count(userCommonFriends);
	}
}