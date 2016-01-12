package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.MyGroupActualBaseService;
import com.lhy.adminj.basic.dao.MyGroupActualDao;

import com.lhy.adminj.basic.model.MyGroupActual;

/**
 * 我的组合时段Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupActualBaseServiceImpl implements MyGroupActualBaseService{
	@Autowired
	protected MyGroupActualDao myGroupActualDao;

	@Override
	public void save(MyGroupActual myGroupActual) {
		myGroupActualDao.save(myGroupActual);
	}
	
	@Override
	public void update(MyGroupActual myGroupActual) {
		myGroupActualDao.update(myGroupActual);
	}

	@Override
	public void modify(MyGroupActual myGroupActual) {
		myGroupActualDao.modify(myGroupActual);
	}

	@Override
	public void delete(Long actualGroupId){
		myGroupActualDao.delete(actualGroupId);
	}

	@Override
	public void batchSave(List<MyGroupActual> list){
		myGroupActualDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<MyGroupActual> list){
		myGroupActualDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		myGroupActualDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param actualGroupId 组合ID
	 * @return MyGroupActual
	 */
	public MyGroupActual findById(Long actualGroupId){
		return myGroupActualDao.findById(actualGroupId);
	}

	/**
	 * 根据对象查询
	 * @param myGroupActual
	 * @return List
	 */
	public List<MyGroupActual> find(MyGroupActual myGroupActual){
		return myGroupActualDao.find(myGroupActual);
	}

	/**
	 * 根据对象查询
	 * @param myGroupActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyGroupActual> find(MyGroupActual myGroupActual, String[][] orders){
		return myGroupActualDao.find(myGroupActual, orders);
	}

	/**
	 * 根据对象查询
	 * @param myGroupActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupActual> find(MyGroupActual myGroupActual, Long offset, Long rows){
		return myGroupActualDao.find(myGroupActual, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myGroupActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupActual> find(MyGroupActual myGroupActual, String[][] orders, Long offset, Long rows){
    	return myGroupActualDao.find(myGroupActual, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param myGroupActual
	 * @return Long
	 */
	public Long count(MyGroupActual myGroupActual){
		return myGroupActualDao.count(myGroupActual);
	}
}