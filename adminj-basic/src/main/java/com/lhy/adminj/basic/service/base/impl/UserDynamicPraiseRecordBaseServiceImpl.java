package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserDynamicPraiseRecordBaseService;
import com.lhy.adminj.basic.dao.UserDynamicPraiseRecordDao;

import com.lhy.adminj.basic.model.UserDynamicPraiseRecord;

/**
 * 用户动态点赞记录表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicPraiseRecordBaseServiceImpl implements UserDynamicPraiseRecordBaseService{
	@Autowired
	protected UserDynamicPraiseRecordDao userDynamicPraiseRecordDao;

	@Override
	public void save(UserDynamicPraiseRecord userDynamicPraiseRecord) {
		userDynamicPraiseRecordDao.save(userDynamicPraiseRecord);
	}
	
	@Override
	public void update(UserDynamicPraiseRecord userDynamicPraiseRecord) {
		userDynamicPraiseRecordDao.update(userDynamicPraiseRecord);
	}

	@Override
	public void modify(UserDynamicPraiseRecord userDynamicPraiseRecord) {
		userDynamicPraiseRecordDao.modify(userDynamicPraiseRecord);
	}

	@Override
	public void delete(Long praiseId){
		userDynamicPraiseRecordDao.delete(praiseId);
	}

	@Override
	public void batchSave(List<UserDynamicPraiseRecord> list){
		userDynamicPraiseRecordDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserDynamicPraiseRecord> list){
		userDynamicPraiseRecordDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userDynamicPraiseRecordDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param praiseId 点赞ID
	 * @return UserDynamicPraiseRecord
	 */
	public UserDynamicPraiseRecord findById(Long praiseId){
		return userDynamicPraiseRecordDao.findById(praiseId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicPraiseRecord
	 * @return List
	 */
	public List<UserDynamicPraiseRecord> find(UserDynamicPraiseRecord userDynamicPraiseRecord){
		return userDynamicPraiseRecordDao.find(userDynamicPraiseRecord);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicPraiseRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicPraiseRecord> find(UserDynamicPraiseRecord userDynamicPraiseRecord, String[][] orders){
		return userDynamicPraiseRecordDao.find(userDynamicPraiseRecord, orders);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicPraiseRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicPraiseRecord> find(UserDynamicPraiseRecord userDynamicPraiseRecord, Long offset, Long rows){
		return userDynamicPraiseRecordDao.find(userDynamicPraiseRecord, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicPraiseRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicPraiseRecord> find(UserDynamicPraiseRecord userDynamicPraiseRecord, String[][] orders, Long offset, Long rows){
    	return userDynamicPraiseRecordDao.find(userDynamicPraiseRecord, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userDynamicPraiseRecord
	 * @return Long
	 */
	public Long count(UserDynamicPraiseRecord userDynamicPraiseRecord){
		return userDynamicPraiseRecordDao.count(userDynamicPraiseRecord);
	}
}