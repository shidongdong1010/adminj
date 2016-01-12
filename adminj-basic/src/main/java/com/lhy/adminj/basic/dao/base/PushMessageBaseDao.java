package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.PushMessage;

/**
 * 推送消息表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface PushMessageBaseDao {

	public void save(PushMessage pushMessage);
	
	public void update(PushMessage pushMessage);

	public void modify(PushMessage pushMessage);

	public void delete(Long pushId);

	public void batchSave(List<PushMessage> list);

    public void batchUpdate(List<PushMessage> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param pushId 推送ID
	 * @return PushMessage
	 */
	public PushMessage findById(Long pushId);

	/**
	 * 根据对象查询
	 * @param pushMessage
	 * @return List
	 */
	public List<PushMessage> find(PushMessage pushMessage);

	/**
	 * 根据对象查询
	 * @param pushMessage
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<PushMessage> find(PushMessage pushMessage, String[][] orders);

	/**
	 * 根据对象查询
	 * @param pushMessage
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<PushMessage> find(PushMessage pushMessage, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param pushMessage
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<PushMessage> find(PushMessage pushMessage, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param pushMessage
	 * @return Long
	 */
	public Long count(PushMessage pushMessage);
}
