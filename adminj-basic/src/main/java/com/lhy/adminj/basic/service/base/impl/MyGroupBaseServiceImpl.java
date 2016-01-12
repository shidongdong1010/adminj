package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.MyGroupBaseService;
import com.lhy.adminj.basic.dao.MyGroupDao;

import com.lhy.adminj.basic.model.MyGroup;

/**
 * 我的组合表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupBaseServiceImpl implements MyGroupBaseService{
	@Autowired
	protected MyGroupDao myGroupDao;

	@Override
	public void save(MyGroup myGroup) {
		myGroupDao.save(myGroup);
	}
	
	@Override
	public void update(MyGroup myGroup) {
		myGroupDao.update(myGroup);
	}

	@Override
	public void modify(MyGroup myGroup) {
		myGroupDao.modify(myGroup);
	}

	@Override
	public void delete(Long groupId){
		myGroupDao.delete(groupId);
	}

	@Override
	public void batchSave(List<MyGroup> list){
		myGroupDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<MyGroup> list){
		myGroupDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		myGroupDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param groupId 组合ID
	 * @return MyGroup
	 */
	public MyGroup findById(Long groupId){
		return myGroupDao.findById(groupId);
	}

	/**
	 * 根据对象查询
	 * @param myGroup
	 * @return List
	 */
	public List<MyGroup> find(MyGroup myGroup){
		return myGroupDao.find(myGroup);
	}

	/**
	 * 根据对象查询
	 * @param myGroup
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyGroup> find(MyGroup myGroup, String[][] orders){
		return myGroupDao.find(myGroup, orders);
	}

	/**
	 * 根据对象查询
	 * @param myGroup
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroup> find(MyGroup myGroup, Long offset, Long rows){
		return myGroupDao.find(myGroup, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myGroup
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroup> find(MyGroup myGroup, String[][] orders, Long offset, Long rows){
    	return myGroupDao.find(myGroup, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param myGroup
	 * @return Long
	 */
	public Long count(MyGroup myGroup){
		return myGroupDao.count(myGroup);
	}
}