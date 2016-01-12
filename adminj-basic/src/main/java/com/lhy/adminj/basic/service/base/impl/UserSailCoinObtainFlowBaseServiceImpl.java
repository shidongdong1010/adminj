package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserSailCoinObtainFlowBaseService;
import com.lhy.adminj.basic.dao.UserSailCoinObtainFlowDao;

import com.lhy.adminj.basic.model.UserSailCoinObtainFlow;

/**
 * 用户航币获取流水表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserSailCoinObtainFlowBaseServiceImpl implements UserSailCoinObtainFlowBaseService{
	@Autowired
	protected UserSailCoinObtainFlowDao userSailCoinObtainFlowDao;

	@Override
	public void save(UserSailCoinObtainFlow userSailCoinObtainFlow) {
		userSailCoinObtainFlowDao.save(userSailCoinObtainFlow);
	}
	
	@Override
	public void update(UserSailCoinObtainFlow userSailCoinObtainFlow) {
		userSailCoinObtainFlowDao.update(userSailCoinObtainFlow);
	}

	@Override
	public void modify(UserSailCoinObtainFlow userSailCoinObtainFlow) {
		userSailCoinObtainFlowDao.modify(userSailCoinObtainFlow);
	}

	@Override
	public void delete(Long obtainFlowId){
		userSailCoinObtainFlowDao.delete(obtainFlowId);
	}

	@Override
	public void batchSave(List<UserSailCoinObtainFlow> list){
		userSailCoinObtainFlowDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserSailCoinObtainFlow> list){
		userSailCoinObtainFlowDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userSailCoinObtainFlowDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param obtainFlowId 航币获取流水ID,自增
	 * @return UserSailCoinObtainFlow
	 */
	public UserSailCoinObtainFlow findById(Long obtainFlowId){
		return userSailCoinObtainFlowDao.findById(obtainFlowId);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinObtainFlow
	 * @return List
	 */
	public List<UserSailCoinObtainFlow> find(UserSailCoinObtainFlow userSailCoinObtainFlow){
		return userSailCoinObtainFlowDao.find(userSailCoinObtainFlow);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinObtainFlow
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserSailCoinObtainFlow> find(UserSailCoinObtainFlow userSailCoinObtainFlow, String[][] orders){
		return userSailCoinObtainFlowDao.find(userSailCoinObtainFlow, orders);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinObtainFlow
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinObtainFlow> find(UserSailCoinObtainFlow userSailCoinObtainFlow, Long offset, Long rows){
		return userSailCoinObtainFlowDao.find(userSailCoinObtainFlow, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinObtainFlow
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinObtainFlow> find(UserSailCoinObtainFlow userSailCoinObtainFlow, String[][] orders, Long offset, Long rows){
    	return userSailCoinObtainFlowDao.find(userSailCoinObtainFlow, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userSailCoinObtainFlow
	 * @return Long
	 */
	public Long count(UserSailCoinObtainFlow userSailCoinObtainFlow){
		return userSailCoinObtainFlowDao.count(userSailCoinObtainFlow);
	}
}