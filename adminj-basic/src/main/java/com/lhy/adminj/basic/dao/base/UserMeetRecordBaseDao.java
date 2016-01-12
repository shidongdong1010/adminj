package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserMeetRecord;

/**
 * 用户打招呼表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserMeetRecordBaseDao {

	public void save(UserMeetRecord userMeetRecord);
	
	public void update(UserMeetRecord userMeetRecord);

	public void modify(UserMeetRecord userMeetRecord);

	public void delete(Long meetId);

	public void batchSave(List<UserMeetRecord> list);

    public void batchUpdate(List<UserMeetRecord> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param meetId ID
	 * @return UserMeetRecord
	 */
	public UserMeetRecord findById(Long meetId);

	/**
	 * 根据对象查询
	 * @param userMeetRecord
	 * @return List
	 */
	public List<UserMeetRecord> find(UserMeetRecord userMeetRecord);

	/**
	 * 根据对象查询
	 * @param userMeetRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserMeetRecord> find(UserMeetRecord userMeetRecord, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userMeetRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserMeetRecord> find(UserMeetRecord userMeetRecord, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userMeetRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserMeetRecord> find(UserMeetRecord userMeetRecord, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userMeetRecord
	 * @return Long
	 */
	public Long count(UserMeetRecord userMeetRecord);
}
