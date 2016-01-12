package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.StockUserBaseService;
import com.lhy.adminj.basic.dao.StockUserDao;

import com.lhy.adminj.basic.model.StockUser;

/**
 * 证券开户表302001Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockUserBaseServiceImpl implements StockUserBaseService{
	@Autowired
	protected StockUserDao stockUserDao;

	@Override
	public void save(StockUser stockUser) {
		stockUserDao.save(stockUser);
	}
	
	@Override
	public void update(StockUser stockUser) {
		stockUserDao.update(stockUser);
	}

	@Override
	public void delete(Long stockUserId){
		stockUserDao.delete(stockUserId);
	}

	/**
	 * 根据主键查询
	 * @param stockUserId 主键
	 * @return StockUser
	 */
	public StockUser findById(Long stockUserId){
		return stockUserDao.findById(stockUserId);
	}

	/**
	 * 根据对象查询
	 * @param stockUser
	 * @return List
	 */
	public List<StockUser> find(StockUser stockUser){
		return stockUserDao.find(stockUser);
	}

	/**
	 * 根据对象查询
	 * @param stockUser
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockUser> find(StockUser stockUser, Long offset, Long rows){
		return stockUserDao.find(stockUser, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param stockUser
	 * @return Long
	 */
	public Long count(StockUser stockUser){
		return stockUserDao.count(stockUser);
	}
}