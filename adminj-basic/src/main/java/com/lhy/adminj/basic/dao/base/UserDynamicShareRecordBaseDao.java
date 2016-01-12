package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserDynamicShareRecord;

/**
 * 用户动态分享记录表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserDynamicShareRecordBaseDao {

	public void save(UserDynamicShareRecord userDynamicShareRecord);
	
	public void update(UserDynamicShareRecord userDynamicShareRecord);

	public void modify(UserDynamicShareRecord userDynamicShareRecord);

	public void delete(Long shareId);

	public void batchSave(List<UserDynamicShareRecord> list);

    public void batchUpdate(List<UserDynamicShareRecord> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param shareId 分享ID
	 * @return UserDynamicShareRecord
	 */
	public UserDynamicShareRecord findById(Long shareId);

	/**
	 * 根据对象查询
	 * @param userDynamicShareRecord
	 * @return List
	 */
	public List<UserDynamicShareRecord> find(UserDynamicShareRecord userDynamicShareRecord);

	/**
	 * 根据对象查询
	 * @param userDynamicShareRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicShareRecord> find(UserDynamicShareRecord userDynamicShareRecord, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userDynamicShareRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicShareRecord> find(UserDynamicShareRecord userDynamicShareRecord, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userDynamicShareRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicShareRecord> find(UserDynamicShareRecord userDynamicShareRecord, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userDynamicShareRecord
	 * @return Long
	 */
	public Long count(UserDynamicShareRecord userDynamicShareRecord);
}
