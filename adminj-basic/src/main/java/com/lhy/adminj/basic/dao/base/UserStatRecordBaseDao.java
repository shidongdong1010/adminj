package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserStatRecord;

/**
 * 用户统计记录表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserStatRecordBaseDao {

	public void save(UserStatRecord userStatRecord);
	
	public void update(UserStatRecord userStatRecord);

	public void modify(UserStatRecord userStatRecord);

	public void delete(Long userId);

	public void batchSave(List<UserStatRecord> list);

    public void batchUpdate(List<UserStatRecord> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param userId 用户ID
	 * @return UserStatRecord
	 */
	public UserStatRecord findById(Long userId);

	/**
	 * 根据对象查询
	 * @param userStatRecord
	 * @return List
	 */
	public List<UserStatRecord> find(UserStatRecord userStatRecord);

	/**
	 * 根据对象查询
	 * @param userStatRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserStatRecord> find(UserStatRecord userStatRecord, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userStatRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStatRecord> find(UserStatRecord userStatRecord, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userStatRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStatRecord> find(UserStatRecord userStatRecord, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userStatRecord
	 * @return Long
	 */
	public Long count(UserStatRecord userStatRecord);
}
