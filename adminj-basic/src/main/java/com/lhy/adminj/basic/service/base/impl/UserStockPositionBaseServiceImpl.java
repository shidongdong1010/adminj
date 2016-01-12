package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserStockPositionBaseService;
import com.lhy.adminj.basic.dao.UserStockPositionDao;

import com.lhy.adminj.basic.model.UserStockPosition;

/**
 * 股票持仓表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserStockPositionBaseServiceImpl implements UserStockPositionBaseService{
	@Autowired
	protected UserStockPositionDao userStockPositionDao;

	@Override
	public void save(UserStockPosition userStockPosition) {
		userStockPositionDao.save(userStockPosition);
	}
	
	@Override
	public void update(UserStockPosition userStockPosition) {
		userStockPositionDao.update(userStockPosition);
	}

	@Override
	public void modify(UserStockPosition userStockPosition) {
		userStockPositionDao.modify(userStockPosition);
	}

	@Override
	public void delete(Long positionId){
		userStockPositionDao.delete(positionId);
	}

	@Override
	public void batchSave(List<UserStockPosition> list){
		userStockPositionDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserStockPosition> list){
		userStockPositionDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userStockPositionDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param positionId 股票持仓ID
	 * @return UserStockPosition
	 */
	public UserStockPosition findById(Long positionId){
		return userStockPositionDao.findById(positionId);
	}

	/**
	 * 根据对象查询
	 * @param userStockPosition
	 * @return List
	 */
	public List<UserStockPosition> find(UserStockPosition userStockPosition){
		return userStockPositionDao.find(userStockPosition);
	}

	/**
	 * 根据对象查询
	 * @param userStockPosition
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserStockPosition> find(UserStockPosition userStockPosition, String[][] orders){
		return userStockPositionDao.find(userStockPosition, orders);
	}

	/**
	 * 根据对象查询
	 * @param userStockPosition
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStockPosition> find(UserStockPosition userStockPosition, Long offset, Long rows){
		return userStockPositionDao.find(userStockPosition, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userStockPosition
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStockPosition> find(UserStockPosition userStockPosition, String[][] orders, Long offset, Long rows){
    	return userStockPositionDao.find(userStockPosition, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userStockPosition
	 * @return Long
	 */
	public Long count(UserStockPosition userStockPosition){
		return userStockPositionDao.count(userStockPosition);
	}
}