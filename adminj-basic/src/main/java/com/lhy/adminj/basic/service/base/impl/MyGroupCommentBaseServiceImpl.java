package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.MyGroupCommentBaseService;
import com.lhy.adminj.basic.dao.MyGroupCommentDao;

import com.lhy.adminj.basic.model.MyGroupComment;

/**
 * 我的组合评论Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupCommentBaseServiceImpl implements MyGroupCommentBaseService{
	@Autowired
	protected MyGroupCommentDao myGroupCommentDao;

	@Override
	public void save(MyGroupComment myGroupComment) {
		myGroupCommentDao.save(myGroupComment);
	}
	
	@Override
	public void update(MyGroupComment myGroupComment) {
		myGroupCommentDao.update(myGroupComment);
	}

	@Override
	public void modify(MyGroupComment myGroupComment) {
		myGroupCommentDao.modify(myGroupComment);
	}

	@Override
	public void delete(Long commentId){
		myGroupCommentDao.delete(commentId);
	}

	@Override
	public void batchSave(List<MyGroupComment> list){
		myGroupCommentDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<MyGroupComment> list){
		myGroupCommentDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		myGroupCommentDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param commentId 组合评论ID
	 * @return MyGroupComment
	 */
	public MyGroupComment findById(Long commentId){
		return myGroupCommentDao.findById(commentId);
	}

	/**
	 * 根据对象查询
	 * @param myGroupComment
	 * @return List
	 */
	public List<MyGroupComment> find(MyGroupComment myGroupComment){
		return myGroupCommentDao.find(myGroupComment);
	}

	/**
	 * 根据对象查询
	 * @param myGroupComment
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyGroupComment> find(MyGroupComment myGroupComment, String[][] orders){
		return myGroupCommentDao.find(myGroupComment, orders);
	}

	/**
	 * 根据对象查询
	 * @param myGroupComment
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupComment> find(MyGroupComment myGroupComment, Long offset, Long rows){
		return myGroupCommentDao.find(myGroupComment, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myGroupComment
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupComment> find(MyGroupComment myGroupComment, String[][] orders, Long offset, Long rows){
    	return myGroupCommentDao.find(myGroupComment, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param myGroupComment
	 * @return Long
	 */
	public Long count(MyGroupComment myGroupComment){
		return myGroupCommentDao.count(myGroupComment);
	}
}