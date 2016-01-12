package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.MyVoteDetail;

/**
 * 我的跟投详情Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface MyVoteDetailBaseDao {

	public void save(MyVoteDetail myVoteDetail);
	
	public void update(MyVoteDetail myVoteDetail);

	public void modify(MyVoteDetail myVoteDetail);

	public void delete(Long voteDetailId);

	public void batchSave(List<MyVoteDetail> list);

    public void batchUpdate(List<MyVoteDetail> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param voteDetailId 跟头详情ID
	 * @return MyVoteDetail
	 */
	public MyVoteDetail findById(Long voteDetailId);

	/**
	 * 根据对象查询
	 * @param myVoteDetail
	 * @return List
	 */
	public List<MyVoteDetail> find(MyVoteDetail myVoteDetail);

	/**
	 * 根据对象查询
	 * @param myVoteDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyVoteDetail> find(MyVoteDetail myVoteDetail, String[][] orders);

	/**
	 * 根据对象查询
	 * @param myVoteDetail
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyVoteDetail> find(MyVoteDetail myVoteDetail, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param myVoteDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyVoteDetail> find(MyVoteDetail myVoteDetail, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param myVoteDetail
	 * @return Long
	 */
	public Long count(MyVoteDetail myVoteDetail);
}
