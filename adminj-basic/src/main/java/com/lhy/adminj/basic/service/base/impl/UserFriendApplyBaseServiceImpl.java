package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserFriendApplyBaseService;
import com.lhy.adminj.basic.dao.UserFriendApplyDao;

import com.lhy.adminj.basic.model.UserFriendApply;

/**
 * 用户好友申请记录Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserFriendApplyBaseServiceImpl implements UserFriendApplyBaseService{
	@Autowired
	protected UserFriendApplyDao userFriendApplyDao;

	@Override
	public void save(UserFriendApply userFriendApply) {
		userFriendApplyDao.save(userFriendApply);
	}
	
	@Override
	public void update(UserFriendApply userFriendApply) {
		userFriendApplyDao.update(userFriendApply);
	}

	@Override
	public void modify(UserFriendApply userFriendApply) {
		userFriendApplyDao.modify(userFriendApply);
	}

	@Override
	public void delete(Long applyId){
		userFriendApplyDao.delete(applyId);
	}

	@Override
	public void batchSave(List<UserFriendApply> list){
		userFriendApplyDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserFriendApply> list){
		userFriendApplyDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userFriendApplyDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param applyId 用户好友申请ID
	 * @return UserFriendApply
	 */
	public UserFriendApply findById(Long applyId){
		return userFriendApplyDao.findById(applyId);
	}

	/**
	 * 根据对象查询
	 * @param userFriendApply
	 * @return List
	 */
	public List<UserFriendApply> find(UserFriendApply userFriendApply){
		return userFriendApplyDao.find(userFriendApply);
	}

	/**
	 * 根据对象查询
	 * @param userFriendApply
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserFriendApply> find(UserFriendApply userFriendApply, String[][] orders){
		return userFriendApplyDao.find(userFriendApply, orders);
	}

	/**
	 * 根据对象查询
	 * @param userFriendApply
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFriendApply> find(UserFriendApply userFriendApply, Long offset, Long rows){
		return userFriendApplyDao.find(userFriendApply, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userFriendApply
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFriendApply> find(UserFriendApply userFriendApply, String[][] orders, Long offset, Long rows){
    	return userFriendApplyDao.find(userFriendApply, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userFriendApply
	 * @return Long
	 */
	public Long count(UserFriendApply userFriendApply){
		return userFriendApplyDao.count(userFriendApply);
	}
}