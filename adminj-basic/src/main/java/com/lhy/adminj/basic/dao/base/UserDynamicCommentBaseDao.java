package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserDynamicComment;

/**
 * 用户动态评论表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserDynamicCommentBaseDao {

	public void save(UserDynamicComment userDynamicComment);
	
	public void update(UserDynamicComment userDynamicComment);

	public void modify(UserDynamicComment userDynamicComment);

	public void delete(Long commentId);

	public void batchSave(List<UserDynamicComment> list);

    public void batchUpdate(List<UserDynamicComment> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param commentId 评论ID
	 * @return UserDynamicComment
	 */
	public UserDynamicComment findById(Long commentId);

	/**
	 * 根据对象查询
	 * @param userDynamicComment
	 * @return List
	 */
	public List<UserDynamicComment> find(UserDynamicComment userDynamicComment);

	/**
	 * 根据对象查询
	 * @param userDynamicComment
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicComment> find(UserDynamicComment userDynamicComment, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userDynamicComment
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicComment> find(UserDynamicComment userDynamicComment, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userDynamicComment
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicComment> find(UserDynamicComment userDynamicComment, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userDynamicComment
	 * @return Long
	 */
	public Long count(UserDynamicComment userDynamicComment);
}
