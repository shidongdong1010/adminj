package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserStockBaseService;
import com.lhy.adminj.basic.dao.UserStockDao;

import com.lhy.adminj.basic.model.UserStock;

/**
 * 自选股Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserStockBaseServiceImpl implements UserStockBaseService{
	@Autowired
	protected UserStockDao userStockDao;

	@Override
	public void save(UserStock userStock) {
		userStockDao.save(userStock);
	}
	
	@Override
	public void update(UserStock userStock) {
		userStockDao.update(userStock);
	}

	@Override
	public void delete(Long userId){
		userStockDao.delete(userId);
	}

	/**
	 * 根据主键查询
	 * @param userId 平台用户
	 * @return UserStock
	 */
	public UserStock findById(Long userId){
		return userStockDao.findById(userId);
	}

	/**
	 * 根据对象查询
	 * @param userStock
	 * @return List
	 */
	public List<UserStock> find(UserStock userStock){
		return userStockDao.find(userStock);
	}

	/**
	 * 根据对象查询
	 * @param userStock
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStock> find(UserStock userStock, Long offset, Long rows){
		return userStockDao.find(userStock, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userStock
	 * @return Long
	 */
	public Long count(UserStock userStock){
		return userStockDao.count(userStock);
	}
}