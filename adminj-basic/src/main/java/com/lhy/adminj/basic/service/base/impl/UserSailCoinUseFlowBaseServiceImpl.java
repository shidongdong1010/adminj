package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserSailCoinUseFlowBaseService;
import com.lhy.adminj.basic.dao.UserSailCoinUseFlowDao;

import com.lhy.adminj.basic.model.UserSailCoinUseFlow;

/**
 * 用户航币使用流水表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserSailCoinUseFlowBaseServiceImpl implements UserSailCoinUseFlowBaseService{
	@Autowired
	protected UserSailCoinUseFlowDao userSailCoinUseFlowDao;

	@Override
	public void save(UserSailCoinUseFlow userSailCoinUseFlow) {
		userSailCoinUseFlowDao.save(userSailCoinUseFlow);
	}
	
	@Override
	public void update(UserSailCoinUseFlow userSailCoinUseFlow) {
		userSailCoinUseFlowDao.update(userSailCoinUseFlow);
	}

	@Override
	public void modify(UserSailCoinUseFlow userSailCoinUseFlow) {
		userSailCoinUseFlowDao.modify(userSailCoinUseFlow);
	}

	@Override
	public void delete(Long useFlowId){
		userSailCoinUseFlowDao.delete(useFlowId);
	}

	@Override
	public void batchSave(List<UserSailCoinUseFlow> list){
		userSailCoinUseFlowDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserSailCoinUseFlow> list){
		userSailCoinUseFlowDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userSailCoinUseFlowDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param useFlowId 航币使用流水ID,自增
	 * @return UserSailCoinUseFlow
	 */
	public UserSailCoinUseFlow findById(Long useFlowId){
		return userSailCoinUseFlowDao.findById(useFlowId);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinUseFlow
	 * @return List
	 */
	public List<UserSailCoinUseFlow> find(UserSailCoinUseFlow userSailCoinUseFlow){
		return userSailCoinUseFlowDao.find(userSailCoinUseFlow);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinUseFlow
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserSailCoinUseFlow> find(UserSailCoinUseFlow userSailCoinUseFlow, String[][] orders){
		return userSailCoinUseFlowDao.find(userSailCoinUseFlow, orders);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinUseFlow
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinUseFlow> find(UserSailCoinUseFlow userSailCoinUseFlow, Long offset, Long rows){
		return userSailCoinUseFlowDao.find(userSailCoinUseFlow, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinUseFlow
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinUseFlow> find(UserSailCoinUseFlow userSailCoinUseFlow, String[][] orders, Long offset, Long rows){
    	return userSailCoinUseFlowDao.find(userSailCoinUseFlow, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userSailCoinUseFlow
	 * @return Long
	 */
	public Long count(UserSailCoinUseFlow userSailCoinUseFlow){
		return userSailCoinUseFlowDao.count(userSailCoinUseFlow);
	}
}