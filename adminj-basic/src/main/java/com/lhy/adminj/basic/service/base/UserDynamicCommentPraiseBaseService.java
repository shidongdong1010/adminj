package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserDynamicCommentPraise;

/**
 * 用户动态点赞记录表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserDynamicCommentPraiseBaseService {

	public void save(UserDynamicCommentPraise userDynamicCommentPraise);
	
	public void update(UserDynamicCommentPraise userDynamicCommentPraise);

	public void modify(UserDynamicCommentPraise userDynamicCommentPraise);

	public void delete(Long praiseId);

	public void batchSave(List<UserDynamicCommentPraise> list);

    public void batchUpdate(List<UserDynamicCommentPraise> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param praiseId 点赞ID
	 * @return UserDynamicCommentPraise
	 */
	public UserDynamicCommentPraise findById(Long praiseId);

	/**
	 * 根据对象查询
	 * @param userDynamicCommentPraise
	 * @return List
	 */
	public List<UserDynamicCommentPraise> find(UserDynamicCommentPraise userDynamicCommentPraise);

	/**
	 * 根据对象查询
	 * @param userDynamicCommentPraise
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicCommentPraise> find(UserDynamicCommentPraise userDynamicCommentPraise, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userDynamicCommentPraise
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicCommentPraise> find(UserDynamicCommentPraise userDynamicCommentPraise, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userDynamicCommentPraise
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicCommentPraise> find(UserDynamicCommentPraise userDynamicCommentPraise, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userDynamicCommentPraise
	 * @return Long
	 */
	public Long count(UserDynamicCommentPraise userDynamicCommentPraise);
}
