package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserDynamicForwardRecordBaseService;
import com.lhy.adminj.basic.dao.UserDynamicForwardRecordDao;

import com.lhy.adminj.basic.model.UserDynamicForwardRecord;

/**
 * 用户动态转发记录表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicForwardRecordBaseServiceImpl implements UserDynamicForwardRecordBaseService{
	@Autowired
	protected UserDynamicForwardRecordDao userDynamicForwardRecordDao;

	@Override
	public void save(UserDynamicForwardRecord userDynamicForwardRecord) {
		userDynamicForwardRecordDao.save(userDynamicForwardRecord);
	}
	
	@Override
	public void update(UserDynamicForwardRecord userDynamicForwardRecord) {
		userDynamicForwardRecordDao.update(userDynamicForwardRecord);
	}

	@Override
	public void modify(UserDynamicForwardRecord userDynamicForwardRecord) {
		userDynamicForwardRecordDao.modify(userDynamicForwardRecord);
	}

	@Override
	public void delete(Long forwardId){
		userDynamicForwardRecordDao.delete(forwardId);
	}

	@Override
	public void batchSave(List<UserDynamicForwardRecord> list){
		userDynamicForwardRecordDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserDynamicForwardRecord> list){
		userDynamicForwardRecordDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userDynamicForwardRecordDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param forwardId 转发ID
	 * @return UserDynamicForwardRecord
	 */
	public UserDynamicForwardRecord findById(Long forwardId){
		return userDynamicForwardRecordDao.findById(forwardId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicForwardRecord
	 * @return List
	 */
	public List<UserDynamicForwardRecord> find(UserDynamicForwardRecord userDynamicForwardRecord){
		return userDynamicForwardRecordDao.find(userDynamicForwardRecord);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicForwardRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicForwardRecord> find(UserDynamicForwardRecord userDynamicForwardRecord, String[][] orders){
		return userDynamicForwardRecordDao.find(userDynamicForwardRecord, orders);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicForwardRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicForwardRecord> find(UserDynamicForwardRecord userDynamicForwardRecord, Long offset, Long rows){
		return userDynamicForwardRecordDao.find(userDynamicForwardRecord, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicForwardRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicForwardRecord> find(UserDynamicForwardRecord userDynamicForwardRecord, String[][] orders, Long offset, Long rows){
    	return userDynamicForwardRecordDao.find(userDynamicForwardRecord, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userDynamicForwardRecord
	 * @return Long
	 */
	public Long count(UserDynamicForwardRecord userDynamicForwardRecord){
		return userDynamicForwardRecordDao.count(userDynamicForwardRecord);
	}
}