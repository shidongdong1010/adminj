package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserMessageBaseService;
import com.lhy.adminj.basic.dao.UserMessageDao;

import com.lhy.adminj.basic.model.UserMessage;

/**
 * 用户消息表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserMessageBaseServiceImpl implements UserMessageBaseService{
	@Autowired
	protected UserMessageDao userMessageDao;

	@Override
	public void save(UserMessage userMessage) {
		userMessageDao.save(userMessage);
	}
	
	@Override
	public void update(UserMessage userMessage) {
		userMessageDao.update(userMessage);
	}

	@Override
	public void modify(UserMessage userMessage) {
		userMessageDao.modify(userMessage);
	}

	@Override
	public void delete(Long messageId){
		userMessageDao.delete(messageId);
	}

	@Override
	public void batchSave(List<UserMessage> list){
		userMessageDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserMessage> list){
		userMessageDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userMessageDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param messageId 用户消息表ID
	 * @return UserMessage
	 */
	public UserMessage findById(Long messageId){
		return userMessageDao.findById(messageId);
	}

	/**
	 * 根据对象查询
	 * @param userMessage
	 * @return List
	 */
	public List<UserMessage> find(UserMessage userMessage){
		return userMessageDao.find(userMessage);
	}

	/**
	 * 根据对象查询
	 * @param userMessage
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserMessage> find(UserMessage userMessage, String[][] orders){
		return userMessageDao.find(userMessage, orders);
	}

	/**
	 * 根据对象查询
	 * @param userMessage
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserMessage> find(UserMessage userMessage, Long offset, Long rows){
		return userMessageDao.find(userMessage, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userMessage
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserMessage> find(UserMessage userMessage, String[][] orders, Long offset, Long rows){
    	return userMessageDao.find(userMessage, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userMessage
	 * @return Long
	 */
	public Long count(UserMessage userMessage){
		return userMessageDao.count(userMessage);
	}
}