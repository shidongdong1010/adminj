package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserDynamicCommentBaseService;
import com.lhy.adminj.basic.dao.UserDynamicCommentDao;

import com.lhy.adminj.basic.model.UserDynamicComment;

/**
 * 用户动态评论表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicCommentBaseServiceImpl implements UserDynamicCommentBaseService{
	@Autowired
	protected UserDynamicCommentDao userDynamicCommentDao;

	@Override
	public void save(UserDynamicComment userDynamicComment) {
		userDynamicCommentDao.save(userDynamicComment);
	}
	
	@Override
	public void update(UserDynamicComment userDynamicComment) {
		userDynamicCommentDao.update(userDynamicComment);
	}

	@Override
	public void modify(UserDynamicComment userDynamicComment) {
		userDynamicCommentDao.modify(userDynamicComment);
	}

	@Override
	public void delete(Long commentId){
		userDynamicCommentDao.delete(commentId);
	}

	@Override
	public void batchSave(List<UserDynamicComment> list){
		userDynamicCommentDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserDynamicComment> list){
		userDynamicCommentDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userDynamicCommentDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param commentId 评论ID
	 * @return UserDynamicComment
	 */
	public UserDynamicComment findById(Long commentId){
		return userDynamicCommentDao.findById(commentId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicComment
	 * @return List
	 */
	public List<UserDynamicComment> find(UserDynamicComment userDynamicComment){
		return userDynamicCommentDao.find(userDynamicComment);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicComment
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicComment> find(UserDynamicComment userDynamicComment, String[][] orders){
		return userDynamicCommentDao.find(userDynamicComment, orders);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicComment
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicComment> find(UserDynamicComment userDynamicComment, Long offset, Long rows){
		return userDynamicCommentDao.find(userDynamicComment, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicComment
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicComment> find(UserDynamicComment userDynamicComment, String[][] orders, Long offset, Long rows){
    	return userDynamicCommentDao.find(userDynamicComment, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userDynamicComment
	 * @return Long
	 */
	public Long count(UserDynamicComment userDynamicComment){
		return userDynamicCommentDao.count(userDynamicComment);
	}
}