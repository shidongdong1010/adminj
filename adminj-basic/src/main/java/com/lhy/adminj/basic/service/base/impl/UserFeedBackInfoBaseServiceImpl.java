package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserFeedBackInfoBaseService;
import com.lhy.adminj.basic.dao.UserFeedBackInfoDao;

import com.lhy.adminj.basic.model.UserFeedBackInfo;

/**
 * 意见反馈信息表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserFeedBackInfoBaseServiceImpl implements UserFeedBackInfoBaseService{
	@Autowired
	protected UserFeedBackInfoDao userFeedBackInfoDao;

	@Override
	public void save(UserFeedBackInfo userFeedBackInfo) {
		userFeedBackInfoDao.save(userFeedBackInfo);
	}
	
	@Override
	public void update(UserFeedBackInfo userFeedBackInfo) {
		userFeedBackInfoDao.update(userFeedBackInfo);
	}

	@Override
	public void modify(UserFeedBackInfo userFeedBackInfo) {
		userFeedBackInfoDao.modify(userFeedBackInfo);
	}

	@Override
	public void delete(Long feedbackId){
		userFeedBackInfoDao.delete(feedbackId);
	}

	@Override
	public void batchSave(List<UserFeedBackInfo> list){
		userFeedBackInfoDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserFeedBackInfo> list){
		userFeedBackInfoDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userFeedBackInfoDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param feedbackId 意见反馈信息ID
	 * @return UserFeedBackInfo
	 */
	public UserFeedBackInfo findById(Long feedbackId){
		return userFeedBackInfoDao.findById(feedbackId);
	}

	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
	 * @return List
	 */
	public List<UserFeedBackInfo> find(UserFeedBackInfo userFeedBackInfo){
		return userFeedBackInfoDao.find(userFeedBackInfo);
	}

	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserFeedBackInfo> find(UserFeedBackInfo userFeedBackInfo, String[][] orders){
		return userFeedBackInfoDao.find(userFeedBackInfo, orders);
	}

	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFeedBackInfo> find(UserFeedBackInfo userFeedBackInfo, Long offset, Long rows){
		return userFeedBackInfoDao.find(userFeedBackInfo, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFeedBackInfo> find(UserFeedBackInfo userFeedBackInfo, String[][] orders, Long offset, Long rows){
    	return userFeedBackInfoDao.find(userFeedBackInfo, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userFeedBackInfo
	 * @return Long
	 */
	public Long count(UserFeedBackInfo userFeedBackInfo){
		return userFeedBackInfoDao.count(userFeedBackInfo);
	}
}