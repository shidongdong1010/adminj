package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.MyVoteApplyBaseService;
import com.lhy.adminj.basic.dao.MyVoteApplyDao;

import com.lhy.adminj.basic.model.MyVoteApply;

/**
 * 我的跟投申请Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyVoteApplyBaseServiceImpl implements MyVoteApplyBaseService{
	@Autowired
	protected MyVoteApplyDao myVoteApplyDao;

	@Override
	public void save(MyVoteApply myVoteApply) {
		myVoteApplyDao.save(myVoteApply);
	}
	
	@Override
	public void update(MyVoteApply myVoteApply) {
		myVoteApplyDao.update(myVoteApply);
	}

	@Override
	public void modify(MyVoteApply myVoteApply) {
		myVoteApplyDao.modify(myVoteApply);
	}

	@Override
	public void delete(Long applyId){
		myVoteApplyDao.delete(applyId);
	}

	@Override
	public void batchSave(List<MyVoteApply> list){
		myVoteApplyDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<MyVoteApply> list){
		myVoteApplyDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		myVoteApplyDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param applyId 申请ID
	 * @return MyVoteApply
	 */
	public MyVoteApply findById(Long applyId){
		return myVoteApplyDao.findById(applyId);
	}

	/**
	 * 根据对象查询
	 * @param myVoteApply
	 * @return List
	 */
	public List<MyVoteApply> find(MyVoteApply myVoteApply){
		return myVoteApplyDao.find(myVoteApply);
	}

	/**
	 * 根据对象查询
	 * @param myVoteApply
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyVoteApply> find(MyVoteApply myVoteApply, String[][] orders){
		return myVoteApplyDao.find(myVoteApply, orders);
	}

	/**
	 * 根据对象查询
	 * @param myVoteApply
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyVoteApply> find(MyVoteApply myVoteApply, Long offset, Long rows){
		return myVoteApplyDao.find(myVoteApply, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myVoteApply
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyVoteApply> find(MyVoteApply myVoteApply, String[][] orders, Long offset, Long rows){
    	return myVoteApplyDao.find(myVoteApply, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param myVoteApply
	 * @return Long
	 */
	public Long count(MyVoteApply myVoteApply){
		return myVoteApplyDao.count(myVoteApply);
	}
}