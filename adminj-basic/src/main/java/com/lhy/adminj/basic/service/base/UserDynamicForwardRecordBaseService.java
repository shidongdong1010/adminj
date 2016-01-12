package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserDynamicForwardRecord;

/**
 * 用户动态转发记录表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserDynamicForwardRecordBaseService {

	public void save(UserDynamicForwardRecord userDynamicForwardRecord);
	
	public void update(UserDynamicForwardRecord userDynamicForwardRecord);

	public void modify(UserDynamicForwardRecord userDynamicForwardRecord);

	public void delete(Long forwardId);

	public void batchSave(List<UserDynamicForwardRecord> list);

    public void batchUpdate(List<UserDynamicForwardRecord> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param forwardId 转发ID
	 * @return UserDynamicForwardRecord
	 */
	public UserDynamicForwardRecord findById(Long forwardId);

	/**
	 * 根据对象查询
	 * @param userDynamicForwardRecord
	 * @return List
	 */
	public List<UserDynamicForwardRecord> find(UserDynamicForwardRecord userDynamicForwardRecord);

	/**
	 * 根据对象查询
	 * @param userDynamicForwardRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicForwardRecord> find(UserDynamicForwardRecord userDynamicForwardRecord, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userDynamicForwardRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicForwardRecord> find(UserDynamicForwardRecord userDynamicForwardRecord, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userDynamicForwardRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicForwardRecord> find(UserDynamicForwardRecord userDynamicForwardRecord, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userDynamicForwardRecord
	 * @return Long
	 */
	public Long count(UserDynamicForwardRecord userDynamicForwardRecord);
}
