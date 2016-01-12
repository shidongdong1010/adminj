package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.HisTradeBaseService;
import com.lhy.adminj.basic.dao.HisTradeDao;

import com.lhy.adminj.basic.model.HisTrade;

/**
 * 证券历史交易查询Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class HisTradeBaseServiceImpl implements HisTradeBaseService{
	@Autowired
	protected HisTradeDao hisTradeDao;

	@Override
	public void save(HisTrade hisTrade) {
		hisTradeDao.save(hisTrade);
	}
	
	@Override
	public void update(HisTrade hisTrade) {
		hisTradeDao.update(hisTrade);
	}

	@Override
	public void delete(Long smcId){
		hisTradeDao.delete(smcId);
	}

	/**
	 * 根据主键查询
	 * @param smcId 主键
	 * @return HisTrade
	 */
	public HisTrade findById(Long smcId){
		return hisTradeDao.findById(smcId);
	}

	/**
	 * 根据对象查询
	 * @param hisTrade
	 * @return List
	 */
	public List<HisTrade> find(HisTrade hisTrade){
		return hisTradeDao.find(hisTrade);
	}

	/**
	 * 根据对象查询
	 * @param hisTrade
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<HisTrade> find(HisTrade hisTrade, Long offset, Long rows){
		return hisTradeDao.find(hisTrade, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param hisTrade
	 * @return Long
	 */
	public Long count(HisTrade hisTrade){
		return hisTradeDao.count(hisTrade);
	}
}