package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.MyVoteDetailBaseService;
import com.lhy.adminj.basic.dao.MyVoteDetailDao;

import com.lhy.adminj.basic.model.MyVoteDetail;

/**
 * 我的跟投详情Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyVoteDetailBaseServiceImpl implements MyVoteDetailBaseService{
	@Autowired
	protected MyVoteDetailDao myVoteDetailDao;

	@Override
	public void save(MyVoteDetail myVoteDetail) {
		myVoteDetailDao.save(myVoteDetail);
	}
	
	@Override
	public void update(MyVoteDetail myVoteDetail) {
		myVoteDetailDao.update(myVoteDetail);
	}

	@Override
	public void modify(MyVoteDetail myVoteDetail) {
		myVoteDetailDao.modify(myVoteDetail);
	}

	@Override
	public void delete(Long voteDetailId){
		myVoteDetailDao.delete(voteDetailId);
	}

	@Override
	public void batchSave(List<MyVoteDetail> list){
		myVoteDetailDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<MyVoteDetail> list){
		myVoteDetailDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		myVoteDetailDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param voteDetailId 跟头详情ID
	 * @return MyVoteDetail
	 */
	public MyVoteDetail findById(Long voteDetailId){
		return myVoteDetailDao.findById(voteDetailId);
	}

	/**
	 * 根据对象查询
	 * @param myVoteDetail
	 * @return List
	 */
	public List<MyVoteDetail> find(MyVoteDetail myVoteDetail){
		return myVoteDetailDao.find(myVoteDetail);
	}

	/**
	 * 根据对象查询
	 * @param myVoteDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyVoteDetail> find(MyVoteDetail myVoteDetail, String[][] orders){
		return myVoteDetailDao.find(myVoteDetail, orders);
	}

	/**
	 * 根据对象查询
	 * @param myVoteDetail
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyVoteDetail> find(MyVoteDetail myVoteDetail, Long offset, Long rows){
		return myVoteDetailDao.find(myVoteDetail, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myVoteDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyVoteDetail> find(MyVoteDetail myVoteDetail, String[][] orders, Long offset, Long rows){
    	return myVoteDetailDao.find(myVoteDetail, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param myVoteDetail
	 * @return Long
	 */
	public Long count(MyVoteDetail myVoteDetail){
		return myVoteDetailDao.count(myVoteDetail);
	}
}