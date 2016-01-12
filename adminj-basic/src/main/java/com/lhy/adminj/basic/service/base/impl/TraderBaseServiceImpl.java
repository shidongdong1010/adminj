package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.TraderBaseService;
import com.lhy.adminj.basic.dao.TraderDao;

import com.lhy.adminj.basic.model.Trader;

/**
 * 券商信息表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class TraderBaseServiceImpl implements TraderBaseService{
	@Autowired
	protected TraderDao traderDao;

	@Override
	public void save(Trader trader) {
		traderDao.save(trader);
	}
	
	@Override
	public void update(Trader trader) {
		traderDao.update(trader);
	}

	@Override
	public void delete(Long traderId){
		traderDao.delete(traderId);
	}

	/**
	 * 根据主键查询
	 * @param traderId 券商ID
	 * @return Trader
	 */
	public Trader findById(Long traderId){
		return traderDao.findById(traderId);
	}

	/**
	 * 根据对象查询
	 * @param trader
	 * @return List
	 */
	public List<Trader> find(Trader trader){
		return traderDao.find(trader);
	}

	/**
	 * 根据对象查询
	 * @param trader
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Trader> find(Trader trader, Long offset, Long rows){
		return traderDao.find(trader, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param trader
	 * @return Long
	 */
	public Long count(Trader trader){
		return traderDao.count(trader);
	}
}