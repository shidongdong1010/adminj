package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.MyGroupDetailActualBaseService;
import com.lhy.adminj.basic.dao.MyGroupDetailActualDao;

import com.lhy.adminj.basic.model.MyGroupDetailActual;

/**
 * 我的组合时段详情Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupDetailActualBaseServiceImpl implements MyGroupDetailActualBaseService{
	@Autowired
	protected MyGroupDetailActualDao myGroupDetailActualDao;

	@Override
	public void save(MyGroupDetailActual myGroupDetailActual) {
		myGroupDetailActualDao.save(myGroupDetailActual);
	}
	
	@Override
	public void update(MyGroupDetailActual myGroupDetailActual) {
		myGroupDetailActualDao.update(myGroupDetailActual);
	}

	@Override
	public void modify(MyGroupDetailActual myGroupDetailActual) {
		myGroupDetailActualDao.modify(myGroupDetailActual);
	}

	@Override
	public void delete(Long actualDetailId){
		myGroupDetailActualDao.delete(actualDetailId);
	}

	@Override
	public void batchSave(List<MyGroupDetailActual> list){
		myGroupDetailActualDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<MyGroupDetailActual> list){
		myGroupDetailActualDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		myGroupDetailActualDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param actualDetailId 组合详情ID
	 * @return MyGroupDetailActual
	 */
	public MyGroupDetailActual findById(Long actualDetailId){
		return myGroupDetailActualDao.findById(actualDetailId);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetailActual
	 * @return List
	 */
	public List<MyGroupDetailActual> find(MyGroupDetailActual myGroupDetailActual){
		return myGroupDetailActualDao.find(myGroupDetailActual);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetailActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyGroupDetailActual> find(MyGroupDetailActual myGroupDetailActual, String[][] orders){
		return myGroupDetailActualDao.find(myGroupDetailActual, orders);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetailActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupDetailActual> find(MyGroupDetailActual myGroupDetailActual, Long offset, Long rows){
		return myGroupDetailActualDao.find(myGroupDetailActual, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetailActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupDetailActual> find(MyGroupDetailActual myGroupDetailActual, String[][] orders, Long offset, Long rows){
    	return myGroupDetailActualDao.find(myGroupDetailActual, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param myGroupDetailActual
	 * @return Long
	 */
	public Long count(MyGroupDetailActual myGroupDetailActual){
		return myGroupDetailActualDao.count(myGroupDetailActual);
	}
}