package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserFeedBackInfo;

/**
 * 意见反馈信息表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserFeedBackInfoBaseDao {

	public void save(UserFeedBackInfo userFeedBackInfo);
	
	public void update(UserFeedBackInfo userFeedBackInfo);

	public void modify(UserFeedBackInfo userFeedBackInfo);

	public void delete(Long feedbackId);

	public void batchSave(List<UserFeedBackInfo> list);

    public void batchUpdate(List<UserFeedBackInfo> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param feedbackId 意见反馈信息ID
	 * @return UserFeedBackInfo
	 */
	public UserFeedBackInfo findById(Long feedbackId);

	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
	 * @return List
	 */
	public List<UserFeedBackInfo> find(UserFeedBackInfo userFeedBackInfo);

	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserFeedBackInfo> find(UserFeedBackInfo userFeedBackInfo, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFeedBackInfo> find(UserFeedBackInfo userFeedBackInfo, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFeedBackInfo> find(UserFeedBackInfo userFeedBackInfo, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userFeedBackInfo
	 * @return Long
	 */
	public Long count(UserFeedBackInfo userFeedBackInfo);
}
