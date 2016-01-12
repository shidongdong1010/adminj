package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.MeetHistoryBaseService;
import com.lhy.adminj.basic.dao.MeetHistoryDao;

import com.lhy.adminj.basic.model.MeetHistory;

/**
 * 相遇历史记录表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MeetHistoryBaseServiceImpl implements MeetHistoryBaseService{
	@Autowired
	protected MeetHistoryDao meetHistoryDao;

	@Override
	public void save(MeetHistory meetHistory) {
		meetHistoryDao.save(meetHistory);
	}
	
	@Override
	public void update(MeetHistory meetHistory) {
		meetHistoryDao.update(meetHistory);
	}

	@Override
	public void modify(MeetHistory meetHistory) {
		meetHistoryDao.modify(meetHistory);
	}

	@Override
	public void delete(Long meetHisId){
		meetHistoryDao.delete(meetHisId);
	}

	@Override
	public void batchSave(List<MeetHistory> list){
		meetHistoryDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<MeetHistory> list){
		meetHistoryDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		meetHistoryDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param meetHisId 相遇历史记录ID
	 * @return MeetHistory
	 */
	public MeetHistory findById(Long meetHisId){
		return meetHistoryDao.findById(meetHisId);
	}

	/**
	 * 根据对象查询
	 * @param meetHistory
	 * @return List
	 */
	public List<MeetHistory> find(MeetHistory meetHistory){
		return meetHistoryDao.find(meetHistory);
	}

	/**
	 * 根据对象查询
	 * @param meetHistory
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MeetHistory> find(MeetHistory meetHistory, String[][] orders){
		return meetHistoryDao.find(meetHistory, orders);
	}

	/**
	 * 根据对象查询
	 * @param meetHistory
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MeetHistory> find(MeetHistory meetHistory, Long offset, Long rows){
		return meetHistoryDao.find(meetHistory, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param meetHistory
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MeetHistory> find(MeetHistory meetHistory, String[][] orders, Long offset, Long rows){
    	return meetHistoryDao.find(meetHistory, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param meetHistory
	 * @return Long
	 */
	public Long count(MeetHistory meetHistory){
		return meetHistoryDao.count(meetHistory);
	}
}