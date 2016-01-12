package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserStatRecordBaseService;
import com.lhy.adminj.basic.dao.UserStatRecordDao;

import com.lhy.adminj.basic.model.UserStatRecord;

/**
 * 用户统计记录表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserStatRecordBaseServiceImpl implements UserStatRecordBaseService{
	@Autowired
	protected UserStatRecordDao userStatRecordDao;

	@Override
	public void save(UserStatRecord userStatRecord) {
		userStatRecordDao.save(userStatRecord);
	}
	
	@Override
	public void update(UserStatRecord userStatRecord) {
		userStatRecordDao.update(userStatRecord);
	}

	@Override
	public void modify(UserStatRecord userStatRecord) {
		userStatRecordDao.modify(userStatRecord);
	}

	@Override
	public void delete(Long userId){
		userStatRecordDao.delete(userId);
	}

	@Override
	public void batchSave(List<UserStatRecord> list){
		userStatRecordDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserStatRecord> list){
		userStatRecordDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userStatRecordDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param userId 用户ID
	 * @return UserStatRecord
	 */
	public UserStatRecord findById(Long userId){
		return userStatRecordDao.findById(userId);
	}

	/**
	 * 根据对象查询
	 * @param userStatRecord
	 * @return List
	 */
	public List<UserStatRecord> find(UserStatRecord userStatRecord){
		return userStatRecordDao.find(userStatRecord);
	}

	/**
	 * 根据对象查询
	 * @param userStatRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserStatRecord> find(UserStatRecord userStatRecord, String[][] orders){
		return userStatRecordDao.find(userStatRecord, orders);
	}

	/**
	 * 根据对象查询
	 * @param userStatRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStatRecord> find(UserStatRecord userStatRecord, Long offset, Long rows){
		return userStatRecordDao.find(userStatRecord, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userStatRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStatRecord> find(UserStatRecord userStatRecord, String[][] orders, Long offset, Long rows){
    	return userStatRecordDao.find(userStatRecord, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userStatRecord
	 * @return Long
	 */
	public Long count(UserStatRecord userStatRecord){
		return userStatRecordDao.count(userStatRecord);
	}
}