package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.GroupAttention;

/**
 * 我关注的组合Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface GroupAttentionBaseService {

	public void save(GroupAttention groupAttention);
	
	public void update(GroupAttention groupAttention);

	public void modify(GroupAttention groupAttention);

	public void delete(Long attentionId);

	public void batchSave(List<GroupAttention> list);

    public void batchUpdate(List<GroupAttention> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param attentionId 关注ID
	 * @return GroupAttention
	 */
	public GroupAttention findById(Long attentionId);

	/**
	 * 根据对象查询
	 * @param groupAttention
	 * @return List
	 */
	public List<GroupAttention> find(GroupAttention groupAttention);

	/**
	 * 根据对象查询
	 * @param groupAttention
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<GroupAttention> find(GroupAttention groupAttention, String[][] orders);

	/**
	 * 根据对象查询
	 * @param groupAttention
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<GroupAttention> find(GroupAttention groupAttention, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param groupAttention
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<GroupAttention> find(GroupAttention groupAttention, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param groupAttention
	 * @return Long
	 */
	public Long count(GroupAttention groupAttention);
}
