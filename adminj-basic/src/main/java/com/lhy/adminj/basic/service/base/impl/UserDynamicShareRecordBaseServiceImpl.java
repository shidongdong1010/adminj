package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserDynamicShareRecordBaseService;
import com.lhy.adminj.basic.dao.UserDynamicShareRecordDao;

import com.lhy.adminj.basic.model.UserDynamicShareRecord;

/**
 * 用户动态分享记录表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicShareRecordBaseServiceImpl implements UserDynamicShareRecordBaseService{
	@Autowired
	protected UserDynamicShareRecordDao userDynamicShareRecordDao;

	@Override
	public void save(UserDynamicShareRecord userDynamicShareRecord) {
		userDynamicShareRecordDao.save(userDynamicShareRecord);
	}
	
	@Override
	public void update(UserDynamicShareRecord userDynamicShareRecord) {
		userDynamicShareRecordDao.update(userDynamicShareRecord);
	}

	@Override
	public void modify(UserDynamicShareRecord userDynamicShareRecord) {
		userDynamicShareRecordDao.modify(userDynamicShareRecord);
	}

	@Override
	public void delete(Long shareId){
		userDynamicShareRecordDao.delete(shareId);
	}

	@Override
	public void batchSave(List<UserDynamicShareRecord> list){
		userDynamicShareRecordDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserDynamicShareRecord> list){
		userDynamicShareRecordDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userDynamicShareRecordDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param shareId 分享ID
	 * @return UserDynamicShareRecord
	 */
	public UserDynamicShareRecord findById(Long shareId){
		return userDynamicShareRecordDao.findById(shareId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicShareRecord
	 * @return List
	 */
	public List<UserDynamicShareRecord> find(UserDynamicShareRecord userDynamicShareRecord){
		return userDynamicShareRecordDao.find(userDynamicShareRecord);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicShareRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicShareRecord> find(UserDynamicShareRecord userDynamicShareRecord, String[][] orders){
		return userDynamicShareRecordDao.find(userDynamicShareRecord, orders);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicShareRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicShareRecord> find(UserDynamicShareRecord userDynamicShareRecord, Long offset, Long rows){
		return userDynamicShareRecordDao.find(userDynamicShareRecord, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicShareRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicShareRecord> find(UserDynamicShareRecord userDynamicShareRecord, String[][] orders, Long offset, Long rows){
    	return userDynamicShareRecordDao.find(userDynamicShareRecord, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userDynamicShareRecord
	 * @return Long
	 */
	public Long count(UserDynamicShareRecord userDynamicShareRecord){
		return userDynamicShareRecordDao.count(userDynamicShareRecord);
	}
}