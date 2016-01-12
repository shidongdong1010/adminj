package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserDynamicCommentPraiseBaseService;
import com.lhy.adminj.basic.dao.UserDynamicCommentPraiseDao;

import com.lhy.adminj.basic.model.UserDynamicCommentPraise;

/**
 * 用户动态点赞记录表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicCommentPraiseBaseServiceImpl implements UserDynamicCommentPraiseBaseService{
	@Autowired
	protected UserDynamicCommentPraiseDao userDynamicCommentPraiseDao;

	@Override
	public void save(UserDynamicCommentPraise userDynamicCommentPraise) {
		userDynamicCommentPraiseDao.save(userDynamicCommentPraise);
	}
	
	@Override
	public void update(UserDynamicCommentPraise userDynamicCommentPraise) {
		userDynamicCommentPraiseDao.update(userDynamicCommentPraise);
	}

	@Override
	public void modify(UserDynamicCommentPraise userDynamicCommentPraise) {
		userDynamicCommentPraiseDao.modify(userDynamicCommentPraise);
	}

	@Override
	public void delete(Long praiseId){
		userDynamicCommentPraiseDao.delete(praiseId);
	}

	@Override
	public void batchSave(List<UserDynamicCommentPraise> list){
		userDynamicCommentPraiseDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserDynamicCommentPraise> list){
		userDynamicCommentPraiseDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userDynamicCommentPraiseDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param praiseId 点赞ID
	 * @return UserDynamicCommentPraise
	 */
	public UserDynamicCommentPraise findById(Long praiseId){
		return userDynamicCommentPraiseDao.findById(praiseId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicCommentPraise
	 * @return List
	 */
	public List<UserDynamicCommentPraise> find(UserDynamicCommentPraise userDynamicCommentPraise){
		return userDynamicCommentPraiseDao.find(userDynamicCommentPraise);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicCommentPraise
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicCommentPraise> find(UserDynamicCommentPraise userDynamicCommentPraise, String[][] orders){
		return userDynamicCommentPraiseDao.find(userDynamicCommentPraise, orders);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicCommentPraise
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicCommentPraise> find(UserDynamicCommentPraise userDynamicCommentPraise, Long offset, Long rows){
		return userDynamicCommentPraiseDao.find(userDynamicCommentPraise, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicCommentPraise
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicCommentPraise> find(UserDynamicCommentPraise userDynamicCommentPraise, String[][] orders, Long offset, Long rows){
    	return userDynamicCommentPraiseDao.find(userDynamicCommentPraise, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userDynamicCommentPraise
	 * @return Long
	 */
	public Long count(UserDynamicCommentPraise userDynamicCommentPraise){
		return userDynamicCommentPraiseDao.count(userDynamicCommentPraise);
	}
}