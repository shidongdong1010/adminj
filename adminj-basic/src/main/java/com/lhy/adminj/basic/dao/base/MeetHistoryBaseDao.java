package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.MeetHistory;

/**
 * 相遇历史记录表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface MeetHistoryBaseDao {

	public void save(MeetHistory meetHistory);
	
	public void update(MeetHistory meetHistory);

	public void modify(MeetHistory meetHistory);

	public void delete(Long meetHisId);

	public void batchSave(List<MeetHistory> list);

    public void batchUpdate(List<MeetHistory> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param meetHisId 相遇历史记录ID
	 * @return MeetHistory
	 */
	public MeetHistory findById(Long meetHisId);

	/**
	 * 根据对象查询
	 * @param meetHistory
	 * @return List
	 */
	public List<MeetHistory> find(MeetHistory meetHistory);

	/**
	 * 根据对象查询
	 * @param meetHistory
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MeetHistory> find(MeetHistory meetHistory, String[][] orders);

	/**
	 * 根据对象查询
	 * @param meetHistory
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MeetHistory> find(MeetHistory meetHistory, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param meetHistory
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MeetHistory> find(MeetHistory meetHistory, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param meetHistory
	 * @return Long
	 */
	public Long count(MeetHistory meetHistory);
}
