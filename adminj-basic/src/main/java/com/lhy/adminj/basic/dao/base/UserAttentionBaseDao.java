package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserAttention;

/**
 * 用户关注表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserAttentionBaseDao {

	public void save(UserAttention userAttention);
	
	public void update(UserAttention userAttention);

	public void modify(UserAttention userAttention);

	public void delete(Long attentionId);

	public void batchSave(List<UserAttention> list);

    public void batchUpdate(List<UserAttention> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param attentionId 关注ID
	 * @return UserAttention
	 */
	public UserAttention findById(Long attentionId);

	/**
	 * 根据对象查询
	 * @param userAttention
	 * @return List
	 */
	public List<UserAttention> find(UserAttention userAttention);

	/**
	 * 根据对象查询
	 * @param userAttention
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserAttention> find(UserAttention userAttention, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userAttention
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserAttention> find(UserAttention userAttention, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userAttention
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserAttention> find(UserAttention userAttention, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userAttention
	 * @return Long
	 */
	public Long count(UserAttention userAttention);
}
