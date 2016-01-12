package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.CoinConvertRuleBaseService;
import com.lhy.adminj.basic.dao.CoinConvertRuleDao;

import com.lhy.adminj.basic.model.CoinConvertRule;

/**
 * 航币兑换规则Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CoinConvertRuleBaseServiceImpl implements CoinConvertRuleBaseService{
	@Autowired
	protected CoinConvertRuleDao coinConvertRuleDao;

	@Override
	public void save(CoinConvertRule coinConvertRule) {
		coinConvertRuleDao.save(coinConvertRule);
	}
	
	@Override
	public void update(CoinConvertRule coinConvertRule) {
		coinConvertRuleDao.update(coinConvertRule);
	}

	@Override
	public void modify(CoinConvertRule coinConvertRule) {
		coinConvertRuleDao.modify(coinConvertRule);
	}

	@Override
	public void delete(Long id){
		coinConvertRuleDao.delete(id);
	}

	@Override
	public void batchSave(List<CoinConvertRule> list){
		coinConvertRuleDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<CoinConvertRule> list){
		coinConvertRuleDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		coinConvertRuleDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param id 
	 * @return CoinConvertRule
	 */
	public CoinConvertRule findById(Long id){
		return coinConvertRuleDao.findById(id);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertRule
	 * @return List
	 */
	public List<CoinConvertRule> find(CoinConvertRule coinConvertRule){
		return coinConvertRuleDao.find(coinConvertRule);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertRule
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<CoinConvertRule> find(CoinConvertRule coinConvertRule, String[][] orders){
		return coinConvertRuleDao.find(coinConvertRule, orders);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertRule
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<CoinConvertRule> find(CoinConvertRule coinConvertRule, Long offset, Long rows){
		return coinConvertRuleDao.find(coinConvertRule, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertRule
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<CoinConvertRule> find(CoinConvertRule coinConvertRule, String[][] orders, Long offset, Long rows){
    	return coinConvertRuleDao.find(coinConvertRule, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param coinConvertRule
	 * @return Long
	 */
	public Long count(CoinConvertRule coinConvertRule){
		return coinConvertRuleDao.count(coinConvertRule);
	}
}