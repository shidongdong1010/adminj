package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserBaseService;
import com.lhy.adminj.basic.dao.UserDao;

import com.lhy.adminj.basic.model.User;

/**
 * 用户表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserBaseServiceImpl implements UserBaseService{
	@Autowired
	protected UserDao userDao;

	@Override
	public void save(User user) {
		userDao.save(user);
	}
	
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void modify(User user) {
		userDao.modify(user);
	}

	@Override
	public void delete(Long userId){
		userDao.delete(userId);
	}

	@Override
	public void batchSave(List<User> list){
		userDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<User> list){
		userDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param userId 用户ID,自增序列
	 * @return User
	 */
	public User findById(Long userId){
		return userDao.findById(userId);
	}

	/**
	 * 根据对象查询
	 * @param user
	 * @return List
	 */
	public List<User> find(User user){
		return userDao.find(user);
	}

	/**
	 * 根据对象查询
	 * @param user
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<User> find(User user, String[][] orders){
		return userDao.find(user, orders);
	}

	/**
	 * 根据对象查询
	 * @param user
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<User> find(User user, Long offset, Long rows){
		return userDao.find(user, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param user
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<User> find(User user, String[][] orders, Long offset, Long rows){
    	return userDao.find(user, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param user
	 * @return Long
	 */
	public Long count(User user){
		return userDao.count(user);
	}
}