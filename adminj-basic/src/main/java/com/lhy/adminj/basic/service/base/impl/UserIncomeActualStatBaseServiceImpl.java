package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserIncomeActualStatBaseService;
import com.lhy.adminj.basic.dao.UserIncomeActualStatDao;

import com.lhy.adminj.basic.model.UserIncomeActualStat;

/**
 * 用户收益实时统计Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserIncomeActualStatBaseServiceImpl implements UserIncomeActualStatBaseService{
	@Autowired
	protected UserIncomeActualStatDao userIncomeActualStatDao;

	@Override
	public void save(UserIncomeActualStat userIncomeActualStat) {
		userIncomeActualStatDao.save(userIncomeActualStat);
	}
	
	@Override
	public void update(UserIncomeActualStat userIncomeActualStat) {
		userIncomeActualStatDao.update(userIncomeActualStat);
	}

	@Override
	public void modify(UserIncomeActualStat userIncomeActualStat) {
		userIncomeActualStatDao.modify(userIncomeActualStat);
	}

	@Override
	public void delete(Long actualStatId){
		userIncomeActualStatDao.delete(actualStatId);
	}

	@Override
	public void batchSave(List<UserIncomeActualStat> list){
		userIncomeActualStatDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserIncomeActualStat> list){
		userIncomeActualStatDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userIncomeActualStatDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param actualStatId 实时统计ID
	 * @return UserIncomeActualStat
	 */
	public UserIncomeActualStat findById(Long actualStatId){
		return userIncomeActualStatDao.findById(actualStatId);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeActualStat
	 * @return List
	 */
	public List<UserIncomeActualStat> find(UserIncomeActualStat userIncomeActualStat){
		return userIncomeActualStatDao.find(userIncomeActualStat);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeActualStat
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserIncomeActualStat> find(UserIncomeActualStat userIncomeActualStat, String[][] orders){
		return userIncomeActualStatDao.find(userIncomeActualStat, orders);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeActualStat
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserIncomeActualStat> find(UserIncomeActualStat userIncomeActualStat, Long offset, Long rows){
		return userIncomeActualStatDao.find(userIncomeActualStat, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeActualStat
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserIncomeActualStat> find(UserIncomeActualStat userIncomeActualStat, String[][] orders, Long offset, Long rows){
    	return userIncomeActualStatDao.find(userIncomeActualStat, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userIncomeActualStat
	 * @return Long
	 */
	public Long count(UserIncomeActualStat userIncomeActualStat){
		return userIncomeActualStatDao.count(userIncomeActualStat);
	}
}