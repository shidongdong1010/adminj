package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserAttentionInfoBaseService;
import com.lhy.adminj.basic.dao.UserAttentionInfoDao;

import com.lhy.adminj.basic.model.UserAttentionInfo;

/**
 * 用户关注表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserAttentionInfoBaseServiceImpl implements UserAttentionInfoBaseService{
	@Autowired
	protected UserAttentionInfoDao userAttentionInfoDao;

	@Override
	public void save(UserAttentionInfo userAttentionInfo) {
		userAttentionInfoDao.save(userAttentionInfo);
	}
	
	@Override
	public void update(UserAttentionInfo userAttentionInfo) {
		userAttentionInfoDao.update(userAttentionInfo);
	}

	@Override
	public void modify(UserAttentionInfo userAttentionInfo) {
		userAttentionInfoDao.modify(userAttentionInfo);
	}

	@Override
	public void delete(Long attentionId){
		userAttentionInfoDao.delete(attentionId);
	}

	@Override
	public void batchSave(List<UserAttentionInfo> list){
		userAttentionInfoDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserAttentionInfo> list){
		userAttentionInfoDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userAttentionInfoDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param attentionId 关注ID
	 * @return UserAttentionInfo
	 */
	public UserAttentionInfo findById(Long attentionId){
		return userAttentionInfoDao.findById(attentionId);
	}

	/**
	 * 根据对象查询
	 * @param userAttentionInfo
	 * @return List
	 */
	public List<UserAttentionInfo> find(UserAttentionInfo userAttentionInfo){
		return userAttentionInfoDao.find(userAttentionInfo);
	}

	/**
	 * 根据对象查询
	 * @param userAttentionInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserAttentionInfo> find(UserAttentionInfo userAttentionInfo, String[][] orders){
		return userAttentionInfoDao.find(userAttentionInfo, orders);
	}

	/**
	 * 根据对象查询
	 * @param userAttentionInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserAttentionInfo> find(UserAttentionInfo userAttentionInfo, Long offset, Long rows){
		return userAttentionInfoDao.find(userAttentionInfo, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userAttentionInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserAttentionInfo> find(UserAttentionInfo userAttentionInfo, String[][] orders, Long offset, Long rows){
    	return userAttentionInfoDao.find(userAttentionInfo, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userAttentionInfo
	 * @return Long
	 */
	public Long count(UserAttentionInfo userAttentionInfo){
		return userAttentionInfoDao.count(userAttentionInfo);
	}
}