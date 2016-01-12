package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.MyVoteApply;

/**
 * 我的跟投申请Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface MyVoteApplyBaseService {

	public void save(MyVoteApply myVoteApply);
	
	public void update(MyVoteApply myVoteApply);

	public void modify(MyVoteApply myVoteApply);

	public void delete(Long applyId);

	public void batchSave(List<MyVoteApply> list);

    public void batchUpdate(List<MyVoteApply> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param applyId 申请ID
	 * @return MyVoteApply
	 */
	public MyVoteApply findById(Long applyId);

	/**
	 * 根据对象查询
	 * @param myVoteApply
	 * @return List
	 */
	public List<MyVoteApply> find(MyVoteApply myVoteApply);

	/**
	 * 根据对象查询
	 * @param myVoteApply
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyVoteApply> find(MyVoteApply myVoteApply, String[][] orders);

	/**
	 * 根据对象查询
	 * @param myVoteApply
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyVoteApply> find(MyVoteApply myVoteApply, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param myVoteApply
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyVoteApply> find(MyVoteApply myVoteApply, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param myVoteApply
	 * @return Long
	 */
	public Long count(MyVoteApply myVoteApply);
}
