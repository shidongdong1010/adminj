package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserAttentionBaseService;
import com.lhy.adminj.basic.dao.UserAttentionDao;

import com.lhy.adminj.basic.model.UserAttention;

/**
 * 用户关注表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserAttentionBaseServiceImpl implements UserAttentionBaseService{
	@Autowired
	protected UserAttentionDao userAttentionDao;

	@Override
	public void save(UserAttention userAttention) {
		userAttentionDao.save(userAttention);
	}
	
	@Override
	public void update(UserAttention userAttention) {
		userAttentionDao.update(userAttention);
	}

	@Override
	public void modify(UserAttention userAttention) {
		userAttentionDao.modify(userAttention);
	}

	@Override
	public void delete(Long attentionId){
		userAttentionDao.delete(attentionId);
	}

	@Override
	public void batchSave(List<UserAttention> list){
		userAttentionDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserAttention> list){
		userAttentionDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userAttentionDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param attentionId 关注ID
	 * @return UserAttention
	 */
	public UserAttention findById(Long attentionId){
		return userAttentionDao.findById(attentionId);
	}

	/**
	 * 根据对象查询
	 * @param userAttention
	 * @return List
	 */
	public List<UserAttention> find(UserAttention userAttention){
		return userAttentionDao.find(userAttention);
	}

	/**
	 * 根据对象查询
	 * @param userAttention
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserAttention> find(UserAttention userAttention, String[][] orders){
		return userAttentionDao.find(userAttention, orders);
	}

	/**
	 * 根据对象查询
	 * @param userAttention
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserAttention> find(UserAttention userAttention, Long offset, Long rows){
		return userAttentionDao.find(userAttention, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userAttention
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserAttention> find(UserAttention userAttention, String[][] orders, Long offset, Long rows){
    	return userAttentionDao.find(userAttention, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userAttention
	 * @return Long
	 */
	public Long count(UserAttention userAttention){
		return userAttentionDao.count(userAttention);
	}
}