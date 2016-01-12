package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserDetailBaseService;
import com.lhy.adminj.basic.dao.UserDetailDao;

import com.lhy.adminj.basic.model.UserDetail;

/**
 * 用户简介表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDetailBaseServiceImpl implements UserDetailBaseService{
	@Autowired
	protected UserDetailDao userDetailDao;

	@Override
	public void save(UserDetail userDetail) {
		userDetailDao.save(userDetail);
	}
	
	@Override
	public void update(UserDetail userDetail) {
		userDetailDao.update(userDetail);
	}

	@Override
	public void modify(UserDetail userDetail) {
		userDetailDao.modify(userDetail);
	}

	@Override
	public void delete(Long userId){
		userDetailDao.delete(userId);
	}

	@Override
	public void batchSave(List<UserDetail> list){
		userDetailDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserDetail> list){
		userDetailDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userDetailDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param userId 用户ID,自增序列
	 * @return UserDetail
	 */
	public UserDetail findById(Long userId){
		return userDetailDao.findById(userId);
	}

	/**
	 * 根据对象查询
	 * @param userDetail
	 * @return List
	 */
	public List<UserDetail> find(UserDetail userDetail){
		return userDetailDao.find(userDetail);
	}

	/**
	 * 根据对象查询
	 * @param userDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDetail> find(UserDetail userDetail, String[][] orders){
		return userDetailDao.find(userDetail, orders);
	}

	/**
	 * 根据对象查询
	 * @param userDetail
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDetail> find(UserDetail userDetail, Long offset, Long rows){
		return userDetailDao.find(userDetail, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDetail> find(UserDetail userDetail, String[][] orders, Long offset, Long rows){
    	return userDetailDao.find(userDetail, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userDetail
	 * @return Long
	 */
	public Long count(UserDetail userDetail){
		return userDetailDao.count(userDetail);
	}
}