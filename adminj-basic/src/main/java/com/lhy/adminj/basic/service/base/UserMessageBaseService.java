package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserMessage;

/**
 * 用户消息表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserMessageBaseService {

	public void save(UserMessage userMessage);
	
	public void update(UserMessage userMessage);

	public void modify(UserMessage userMessage);

	public void delete(Long messageId);

	public void batchSave(List<UserMessage> list);

    public void batchUpdate(List<UserMessage> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param messageId 用户消息表ID
	 * @return UserMessage
	 */
	public UserMessage findById(Long messageId);

	/**
	 * 根据对象查询
	 * @param userMessage
	 * @return List
	 */
	public List<UserMessage> find(UserMessage userMessage);

	/**
	 * 根据对象查询
	 * @param userMessage
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserMessage> find(UserMessage userMessage, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userMessage
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserMessage> find(UserMessage userMessage, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userMessage
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserMessage> find(UserMessage userMessage, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userMessage
	 * @return Long
	 */
	public Long count(UserMessage userMessage);
}
