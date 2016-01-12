package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserBehaviorLog;

/**
 * 用户行为日志Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserBehaviorLogBaseDao {

	public void save(UserBehaviorLog userBehaviorLog);
	
	public void update(UserBehaviorLog userBehaviorLog);

	public void modify(UserBehaviorLog userBehaviorLog);

	public void delete(Long id);

	public void batchSave(List<UserBehaviorLog> list);

    public void batchUpdate(List<UserBehaviorLog> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id 
	 * @return UserBehaviorLog
	 */
	public UserBehaviorLog findById(Long id);

	/**
	 * 根据对象查询
	 * @param userBehaviorLog
	 * @return List
	 */
	public List<UserBehaviorLog> find(UserBehaviorLog userBehaviorLog);

	/**
	 * 根据对象查询
	 * @param userBehaviorLog
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserBehaviorLog> find(UserBehaviorLog userBehaviorLog, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userBehaviorLog
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserBehaviorLog> find(UserBehaviorLog userBehaviorLog, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userBehaviorLog
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserBehaviorLog> find(UserBehaviorLog userBehaviorLog, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userBehaviorLog
	 * @return Long
	 */
	public Long count(UserBehaviorLog userBehaviorLog);
}
