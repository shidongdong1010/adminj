package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserIncomeHisStatBaseService;
import com.lhy.adminj.basic.dao.UserIncomeHisStatDao;

import com.lhy.adminj.basic.model.UserIncomeHisStat;

/**
 * 用户历史收益统计Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserIncomeHisStatBaseServiceImpl implements UserIncomeHisStatBaseService{
	@Autowired
	protected UserIncomeHisStatDao userIncomeHisStatDao;

	@Override
	public void save(UserIncomeHisStat userIncomeHisStat) {
		userIncomeHisStatDao.save(userIncomeHisStat);
	}
	
	@Override
	public void update(UserIncomeHisStat userIncomeHisStat) {
		userIncomeHisStatDao.update(userIncomeHisStat);
	}

	@Override
	public void modify(UserIncomeHisStat userIncomeHisStat) {
		userIncomeHisStatDao.modify(userIncomeHisStat);
	}

	@Override
	public void delete(Long hisStatId){
		userIncomeHisStatDao.delete(hisStatId);
	}

	@Override
	public void batchSave(List<UserIncomeHisStat> list){
		userIncomeHisStatDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserIncomeHisStat> list){
		userIncomeHisStatDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userIncomeHisStatDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param hisStatId 历史统计ID
	 * @return UserIncomeHisStat
	 */
	public UserIncomeHisStat findById(Long hisStatId){
		return userIncomeHisStatDao.findById(hisStatId);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeHisStat
	 * @return List
	 */
	public List<UserIncomeHisStat> find(UserIncomeHisStat userIncomeHisStat){
		return userIncomeHisStatDao.find(userIncomeHisStat);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeHisStat
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserIncomeHisStat> find(UserIncomeHisStat userIncomeHisStat, String[][] orders){
		return userIncomeHisStatDao.find(userIncomeHisStat, orders);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeHisStat
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserIncomeHisStat> find(UserIncomeHisStat userIncomeHisStat, Long offset, Long rows){
		return userIncomeHisStatDao.find(userIncomeHisStat, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeHisStat
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserIncomeHisStat> find(UserIncomeHisStat userIncomeHisStat, String[][] orders, Long offset, Long rows){
    	return userIncomeHisStatDao.find(userIncomeHisStat, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userIncomeHisStat
	 * @return Long
	 */
	public Long count(UserIncomeHisStat userIncomeHisStat){
		return userIncomeHisStatDao.count(userIncomeHisStat);
	}
}