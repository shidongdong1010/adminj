package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserStockPositionActualBaseService;
import com.lhy.adminj.basic.dao.UserStockPositionActualDao;

import com.lhy.adminj.basic.model.UserStockPositionActual;

/**
 * 股票时段持仓表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserStockPositionActualBaseServiceImpl implements UserStockPositionActualBaseService{
	@Autowired
	protected UserStockPositionActualDao userStockPositionActualDao;

	@Override
	public void save(UserStockPositionActual userStockPositionActual) {
		userStockPositionActualDao.save(userStockPositionActual);
	}
	
	@Override
	public void update(UserStockPositionActual userStockPositionActual) {
		userStockPositionActualDao.update(userStockPositionActual);
	}

	@Override
	public void modify(UserStockPositionActual userStockPositionActual) {
		userStockPositionActualDao.modify(userStockPositionActual);
	}

	@Override
	public void delete(Long actualPositionId){
		userStockPositionActualDao.delete(actualPositionId);
	}

	@Override
	public void batchSave(List<UserStockPositionActual> list){
		userStockPositionActualDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserStockPositionActual> list){
		userStockPositionActualDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userStockPositionActualDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param actualPositionId 股票持仓ID
	 * @return UserStockPositionActual
	 */
	public UserStockPositionActual findById(Long actualPositionId){
		return userStockPositionActualDao.findById(actualPositionId);
	}

	/**
	 * 根据对象查询
	 * @param userStockPositionActual
	 * @return List
	 */
	public List<UserStockPositionActual> find(UserStockPositionActual userStockPositionActual){
		return userStockPositionActualDao.find(userStockPositionActual);
	}

	/**
	 * 根据对象查询
	 * @param userStockPositionActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserStockPositionActual> find(UserStockPositionActual userStockPositionActual, String[][] orders){
		return userStockPositionActualDao.find(userStockPositionActual, orders);
	}

	/**
	 * 根据对象查询
	 * @param userStockPositionActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStockPositionActual> find(UserStockPositionActual userStockPositionActual, Long offset, Long rows){
		return userStockPositionActualDao.find(userStockPositionActual, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userStockPositionActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStockPositionActual> find(UserStockPositionActual userStockPositionActual, String[][] orders, Long offset, Long rows){
    	return userStockPositionActualDao.find(userStockPositionActual, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userStockPositionActual
	 * @return Long
	 */
	public Long count(UserStockPositionActual userStockPositionActual){
		return userStockPositionActualDao.count(userStockPositionActual);
	}
}