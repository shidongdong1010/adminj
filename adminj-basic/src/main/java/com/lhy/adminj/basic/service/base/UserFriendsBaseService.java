package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserFriends;

/**
 * 用户好友表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserFriendsBaseService {

	public void save(UserFriends userFriends);
	
	public void update(UserFriends userFriends);

	public void modify(UserFriends userFriends);

	public void delete(Long friendId);

	public void batchSave(List<UserFriends> list);

    public void batchUpdate(List<UserFriends> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param friendId 用户好友ID,自增序列
	 * @return UserFriends
	 */
	public UserFriends findById(Long friendId);

	/**
	 * 根据对象查询
	 * @param userFriends
	 * @return List
	 */
	public List<UserFriends> find(UserFriends userFriends);

	/**
	 * 根据对象查询
	 * @param userFriends
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserFriends> find(UserFriends userFriends, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userFriends
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFriends> find(UserFriends userFriends, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userFriends
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFriends> find(UserFriends userFriends, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userFriends
	 * @return Long
	 */
	public Long count(UserFriends userFriends);
}
