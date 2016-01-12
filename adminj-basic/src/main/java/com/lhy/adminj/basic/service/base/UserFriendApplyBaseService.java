package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserFriendApply;

/**
 * 用户好友申请记录Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserFriendApplyBaseService {

	public void save(UserFriendApply userFriendApply);
	
	public void update(UserFriendApply userFriendApply);

	public void modify(UserFriendApply userFriendApply);

	public void delete(Long applyId);

	public void batchSave(List<UserFriendApply> list);

    public void batchUpdate(List<UserFriendApply> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param applyId 用户好友申请ID
	 * @return UserFriendApply
	 */
	public UserFriendApply findById(Long applyId);

	/**
	 * 根据对象查询
	 * @param userFriendApply
	 * @return List
	 */
	public List<UserFriendApply> find(UserFriendApply userFriendApply);

	/**
	 * 根据对象查询
	 * @param userFriendApply
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserFriendApply> find(UserFriendApply userFriendApply, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userFriendApply
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFriendApply> find(UserFriendApply userFriendApply, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userFriendApply
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFriendApply> find(UserFriendApply userFriendApply, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userFriendApply
	 * @return Long
	 */
	public Long count(UserFriendApply userFriendApply);
}
