package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.MyGroupComment;

/**
 * 我的组合评论Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface MyGroupCommentBaseDao {

	public void save(MyGroupComment myGroupComment);
	
	public void update(MyGroupComment myGroupComment);

	public void modify(MyGroupComment myGroupComment);

	public void delete(Long commentId);

	public void batchSave(List<MyGroupComment> list);

    public void batchUpdate(List<MyGroupComment> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param commentId 组合评论ID
	 * @return MyGroupComment
	 */
	public MyGroupComment findById(Long commentId);

	/**
	 * 根据对象查询
	 * @param myGroupComment
	 * @return List
	 */
	public List<MyGroupComment> find(MyGroupComment myGroupComment);

	/**
	 * 根据对象查询
	 * @param myGroupComment
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyGroupComment> find(MyGroupComment myGroupComment, String[][] orders);

	/**
	 * 根据对象查询
	 * @param myGroupComment
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupComment> find(MyGroupComment myGroupComment, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param myGroupComment
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupComment> find(MyGroupComment myGroupComment, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param myGroupComment
	 * @return Long
	 */
	public Long count(MyGroupComment myGroupComment);
}
