package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.MyGroupDetailBaseService;
import com.lhy.adminj.basic.dao.MyGroupDetailDao;

import com.lhy.adminj.basic.model.MyGroupDetail;

/**
 * 我的组合表详情Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupDetailBaseServiceImpl implements MyGroupDetailBaseService{
	@Autowired
	protected MyGroupDetailDao myGroupDetailDao;

	@Override
	public void save(MyGroupDetail myGroupDetail) {
		myGroupDetailDao.save(myGroupDetail);
	}
	
	@Override
	public void update(MyGroupDetail myGroupDetail) {
		myGroupDetailDao.update(myGroupDetail);
	}

	@Override
	public void modify(MyGroupDetail myGroupDetail) {
		myGroupDetailDao.modify(myGroupDetail);
	}

	@Override
	public void delete(Long groupDetailId){
		myGroupDetailDao.delete(groupDetailId);
	}

	@Override
	public void batchSave(List<MyGroupDetail> list){
		myGroupDetailDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<MyGroupDetail> list){
		myGroupDetailDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		myGroupDetailDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param groupDetailId 组合详情ID
	 * @return MyGroupDetail
	 */
	public MyGroupDetail findById(Long groupDetailId){
		return myGroupDetailDao.findById(groupDetailId);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetail
	 * @return List
	 */
	public List<MyGroupDetail> find(MyGroupDetail myGroupDetail){
		return myGroupDetailDao.find(myGroupDetail);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyGroupDetail> find(MyGroupDetail myGroupDetail, String[][] orders){
		return myGroupDetailDao.find(myGroupDetail, orders);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetail
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupDetail> find(MyGroupDetail myGroupDetail, Long offset, Long rows){
		return myGroupDetailDao.find(myGroupDetail, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupDetail> find(MyGroupDetail myGroupDetail, String[][] orders, Long offset, Long rows){
    	return myGroupDetailDao.find(myGroupDetail, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param myGroupDetail
	 * @return Long
	 */
	public Long count(MyGroupDetail myGroupDetail){
		return myGroupDetailDao.count(myGroupDetail);
	}
}