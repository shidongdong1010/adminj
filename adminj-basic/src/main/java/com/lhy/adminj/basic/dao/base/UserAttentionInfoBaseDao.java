package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserAttentionInfo;

/**
 * 用户关注表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserAttentionInfoBaseDao {

	public void save(UserAttentionInfo userAttentionInfo);
	
	public void update(UserAttentionInfo userAttentionInfo);

	public void modify(UserAttentionInfo userAttentionInfo);

	public void delete(Long attentionId);

	public void batchSave(List<UserAttentionInfo> list);

    public void batchUpdate(List<UserAttentionInfo> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param attentionId 关注ID
	 * @return UserAttentionInfo
	 */
	public UserAttentionInfo findById(Long attentionId);

	/**
	 * 根据对象查询
	 * @param userAttentionInfo
	 * @return List
	 */
	public List<UserAttentionInfo> find(UserAttentionInfo userAttentionInfo);

	/**
	 * 根据对象查询
	 * @param userAttentionInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserAttentionInfo> find(UserAttentionInfo userAttentionInfo, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userAttentionInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserAttentionInfo> find(UserAttentionInfo userAttentionInfo, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userAttentionInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserAttentionInfo> find(UserAttentionInfo userAttentionInfo, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userAttentionInfo
	 * @return Long
	 */
	public Long count(UserAttentionInfo userAttentionInfo);
}
