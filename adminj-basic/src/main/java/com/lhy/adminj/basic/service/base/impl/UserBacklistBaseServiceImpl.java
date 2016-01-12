package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserBacklistBaseService;
import com.lhy.adminj.basic.dao.UserBacklistDao;

import com.lhy.adminj.basic.model.UserBacklist;

/**
 * 用户黑名单表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserBacklistBaseServiceImpl implements UserBacklistBaseService{
	@Autowired
	protected UserBacklistDao userBacklistDao;

	@Override
	public void save(UserBacklist userBacklist) {
		userBacklistDao.save(userBacklist);
	}
	
	@Override
	public void update(UserBacklist userBacklist) {
		userBacklistDao.update(userBacklist);
	}

	@Override
	public void modify(UserBacklist userBacklist) {
		userBacklistDao.modify(userBacklist);
	}

	@Override
	public void delete(Long userId){
		userBacklistDao.delete(userId);
	}

	@Override
	public void batchSave(List<UserBacklist> list){
		userBacklistDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserBacklist> list){
		userBacklistDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userBacklistDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param userId 用户ID,自增序列
	 * @return UserBacklist
	 */
	public UserBacklist findById(Long userId){
		return userBacklistDao.findById(userId);
	}

	/**
	 * 根据对象查询
	 * @param userBacklist
	 * @return List
	 */
	public List<UserBacklist> find(UserBacklist userBacklist){
		return userBacklistDao.find(userBacklist);
	}

	/**
	 * 根据对象查询
	 * @param userBacklist
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserBacklist> find(UserBacklist userBacklist, String[][] orders){
		return userBacklistDao.find(userBacklist, orders);
	}

	/**
	 * 根据对象查询
	 * @param userBacklist
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserBacklist> find(UserBacklist userBacklist, Long offset, Long rows){
		return userBacklistDao.find(userBacklist, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userBacklist
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserBacklist> find(UserBacklist userBacklist, String[][] orders, Long offset, Long rows){
    	return userBacklistDao.find(userBacklist, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userBacklist
	 * @return Long
	 */
	public Long count(UserBacklist userBacklist){
		return userBacklistDao.count(userBacklist);
	}
}