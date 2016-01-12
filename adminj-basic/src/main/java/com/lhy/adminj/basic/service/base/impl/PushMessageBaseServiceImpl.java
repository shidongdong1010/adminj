package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.PushMessageBaseService;
import com.lhy.adminj.basic.dao.PushMessageDao;

import com.lhy.adminj.basic.model.PushMessage;

/**
 * 推送消息表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class PushMessageBaseServiceImpl implements PushMessageBaseService{
	@Autowired
	protected PushMessageDao pushMessageDao;

	@Override
	public void save(PushMessage pushMessage) {
		pushMessageDao.save(pushMessage);
	}
	
	@Override
	public void update(PushMessage pushMessage) {
		pushMessageDao.update(pushMessage);
	}

	@Override
	public void modify(PushMessage pushMessage) {
		pushMessageDao.modify(pushMessage);
	}

	@Override
	public void delete(Long pushId){
		pushMessageDao.delete(pushId);
	}

	@Override
	public void batchSave(List<PushMessage> list){
		pushMessageDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<PushMessage> list){
		pushMessageDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		pushMessageDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param pushId 推送ID
	 * @return PushMessage
	 */
	public PushMessage findById(Long pushId){
		return pushMessageDao.findById(pushId);
	}

	/**
	 * 根据对象查询
	 * @param pushMessage
	 * @return List
	 */
	public List<PushMessage> find(PushMessage pushMessage){
		return pushMessageDao.find(pushMessage);
	}

	/**
	 * 根据对象查询
	 * @param pushMessage
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<PushMessage> find(PushMessage pushMessage, String[][] orders){
		return pushMessageDao.find(pushMessage, orders);
	}

	/**
	 * 根据对象查询
	 * @param pushMessage
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<PushMessage> find(PushMessage pushMessage, Long offset, Long rows){
		return pushMessageDao.find(pushMessage, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param pushMessage
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<PushMessage> find(PushMessage pushMessage, String[][] orders, Long offset, Long rows){
    	return pushMessageDao.find(pushMessage, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param pushMessage
	 * @return Long
	 */
	public Long count(PushMessage pushMessage){
		return pushMessageDao.count(pushMessage);
	}
}