package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserLoginInfoBaseService;
import com.lhy.adminj.basic.dao.UserLoginInfoDao;

import com.lhy.adminj.basic.model.UserLoginInfo;

/**
 * 用户登陆日志Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserLoginInfoBaseServiceImpl implements UserLoginInfoBaseService{
	@Autowired
	protected UserLoginInfoDao userLoginInfoDao;

	@Override
	public void save(UserLoginInfo userLoginInfo) {
		userLoginInfoDao.save(userLoginInfo);
	}
	
	@Override
	public void update(UserLoginInfo userLoginInfo) {
		userLoginInfoDao.update(userLoginInfo);
	}

	@Override
	public void modify(UserLoginInfo userLoginInfo) {
		userLoginInfoDao.modify(userLoginInfo);
	}

	@Override
	public void delete(Long loginId){
		userLoginInfoDao.delete(loginId);
	}

	@Override
	public void batchSave(List<UserLoginInfo> list){
		userLoginInfoDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserLoginInfo> list){
		userLoginInfoDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userLoginInfoDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param loginId 登陆表主键
	 * @return UserLoginInfo
	 */
	public UserLoginInfo findById(Long loginId){
		return userLoginInfoDao.findById(loginId);
	}

	/**
	 * 根据对象查询
	 * @param userLoginInfo
	 * @return List
	 */
	public List<UserLoginInfo> find(UserLoginInfo userLoginInfo){
		return userLoginInfoDao.find(userLoginInfo);
	}

	/**
	 * 根据对象查询
	 * @param userLoginInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserLoginInfo> find(UserLoginInfo userLoginInfo, String[][] orders){
		return userLoginInfoDao.find(userLoginInfo, orders);
	}

	/**
	 * 根据对象查询
	 * @param userLoginInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserLoginInfo> find(UserLoginInfo userLoginInfo, Long offset, Long rows){
		return userLoginInfoDao.find(userLoginInfo, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userLoginInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserLoginInfo> find(UserLoginInfo userLoginInfo, String[][] orders, Long offset, Long rows){
    	return userLoginInfoDao.find(userLoginInfo, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userLoginInfo
	 * @return Long
	 */
	public Long count(UserLoginInfo userLoginInfo){
		return userLoginInfoDao.count(userLoginInfo);
	}
}