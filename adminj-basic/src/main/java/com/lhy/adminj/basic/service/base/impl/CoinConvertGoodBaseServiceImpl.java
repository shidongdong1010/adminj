package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.CoinConvertGoodBaseService;
import com.lhy.adminj.basic.dao.CoinConvertGoodDao;

import com.lhy.adminj.basic.model.CoinConvertGood;

/**
 * 兑换商品表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CoinConvertGoodBaseServiceImpl implements CoinConvertGoodBaseService{
	@Autowired
	protected CoinConvertGoodDao coinConvertGoodDao;

	@Override
	public void save(CoinConvertGood coinConvertGood) {
		coinConvertGoodDao.save(coinConvertGood);
	}
	
	@Override
	public void update(CoinConvertGood coinConvertGood) {
		coinConvertGoodDao.update(coinConvertGood);
	}

	@Override
	public void modify(CoinConvertGood coinConvertGood) {
		coinConvertGoodDao.modify(coinConvertGood);
	}

	@Override
	public void delete(Long id){
		coinConvertGoodDao.delete(id);
	}

	@Override
	public void batchSave(List<CoinConvertGood> list){
		coinConvertGoodDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<CoinConvertGood> list){
		coinConvertGoodDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		coinConvertGoodDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return CoinConvertGood
	 */
	public CoinConvertGood findById(Long id){
		return coinConvertGoodDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertGood
	 * @return List
	 */
	public List<CoinConvertGood> find(CoinConvertGood coinConvertGood){
		return coinConvertGoodDao.find(coinConvertGood);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertGood
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<CoinConvertGood> find(CoinConvertGood coinConvertGood, String[][] orders){
		return coinConvertGoodDao.find(coinConvertGood, orders);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertGood
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<CoinConvertGood> find(CoinConvertGood coinConvertGood, Long offset, Long rows){
		return coinConvertGoodDao.find(coinConvertGood, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertGood
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<CoinConvertGood> find(CoinConvertGood coinConvertGood, String[][] orders, Long offset, Long rows){
    	return coinConvertGoodDao.find(coinConvertGood, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param coinConvertGood
	 * @return Long
	 */
	public Long count(CoinConvertGood coinConvertGood){
		return coinConvertGoodDao.count(coinConvertGood);
	}
}