package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.CoinConvertOrderBaseService;
import com.lhy.adminj.basic.dao.CoinConvertOrderDao;

import com.lhy.adminj.basic.model.CoinConvertOrder;

/**
 * 兑换订单表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CoinConvertOrderBaseServiceImpl implements CoinConvertOrderBaseService{
	@Autowired
	protected CoinConvertOrderDao coinConvertOrderDao;

	@Override
	public void save(CoinConvertOrder coinConvertOrder) {
		coinConvertOrderDao.save(coinConvertOrder);
	}
	
	@Override
	public void update(CoinConvertOrder coinConvertOrder) {
		coinConvertOrderDao.update(coinConvertOrder);
	}

	@Override
	public void modify(CoinConvertOrder coinConvertOrder) {
		coinConvertOrderDao.modify(coinConvertOrder);
	}

	@Override
	public void delete(Long id){
		coinConvertOrderDao.delete(id);
	}

	@Override
	public void batchSave(List<CoinConvertOrder> list){
		coinConvertOrderDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<CoinConvertOrder> list){
		coinConvertOrderDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		coinConvertOrderDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id 
	 * @return CoinConvertOrder
	 */
	public CoinConvertOrder findById(Long id){
		return coinConvertOrderDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertOrder
	 * @return List
	 */
	public List<CoinConvertOrder> find(CoinConvertOrder coinConvertOrder){
		return coinConvertOrderDao.find(coinConvertOrder);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertOrder
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<CoinConvertOrder> find(CoinConvertOrder coinConvertOrder, String[][] orders){
		return coinConvertOrderDao.find(coinConvertOrder, orders);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertOrder
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<CoinConvertOrder> find(CoinConvertOrder coinConvertOrder, Long offset, Long rows){
		return coinConvertOrderDao.find(coinConvertOrder, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertOrder
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<CoinConvertOrder> find(CoinConvertOrder coinConvertOrder, String[][] orders, Long offset, Long rows){
    	return coinConvertOrderDao.find(coinConvertOrder, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param coinConvertOrder
	 * @return Long
	 */
	public Long count(CoinConvertOrder coinConvertOrder){
		return coinConvertOrderDao.count(coinConvertOrder);
	}
}