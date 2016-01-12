package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserMeetRecordBaseService;
import com.lhy.adminj.basic.dao.UserMeetRecordDao;

import com.lhy.adminj.basic.model.UserMeetRecord;

/**
 * 用户打招呼表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserMeetRecordBaseServiceImpl implements UserMeetRecordBaseService{
	@Autowired
	protected UserMeetRecordDao userMeetRecordDao;

	@Override
	public void save(UserMeetRecord userMeetRecord) {
		userMeetRecordDao.save(userMeetRecord);
	}
	
	@Override
	public void update(UserMeetRecord userMeetRecord) {
		userMeetRecordDao.update(userMeetRecord);
	}

	@Override
	public void modify(UserMeetRecord userMeetRecord) {
		userMeetRecordDao.modify(userMeetRecord);
	}

	@Override
	public void delete(Long meetId){
		userMeetRecordDao.delete(meetId);
	}

	@Override
	public void batchSave(List<UserMeetRecord> list){
		userMeetRecordDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserMeetRecord> list){
		userMeetRecordDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userMeetRecordDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param meetId ID
	 * @return UserMeetRecord
	 */
	public UserMeetRecord findById(Long meetId){
		return userMeetRecordDao.findById(meetId);
	}

	/**
	 * 根据对象查询
	 * @param userMeetRecord
	 * @return List
	 */
	public List<UserMeetRecord> find(UserMeetRecord userMeetRecord){
		return userMeetRecordDao.find(userMeetRecord);
	}

	/**
	 * 根据对象查询
	 * @param userMeetRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserMeetRecord> find(UserMeetRecord userMeetRecord, String[][] orders){
		return userMeetRecordDao.find(userMeetRecord, orders);
	}

	/**
	 * 根据对象查询
	 * @param userMeetRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserMeetRecord> find(UserMeetRecord userMeetRecord, Long offset, Long rows){
		return userMeetRecordDao.find(userMeetRecord, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userMeetRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserMeetRecord> find(UserMeetRecord userMeetRecord, String[][] orders, Long offset, Long rows){
    	return userMeetRecordDao.find(userMeetRecord, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userMeetRecord
	 * @return Long
	 */
	public Long count(UserMeetRecord userMeetRecord){
		return userMeetRecordDao.count(userMeetRecord);
	}
}