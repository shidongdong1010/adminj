package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.User;

/**
 * 用户表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserBaseDao {

	public void save(User user);
	
	public void update(User user);

	public void modify(User user);

	public void delete(Long userId);

	public void batchSave(List<User> list);

    public void batchUpdate(List<User> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param userId 用户ID,自增序列
	 * @return User
	 */
	public User findById(Long userId);

	/**
	 * 根据对象查询
	 * @param user
	 * @return List
	 */
	public List<User> find(User user);

	/**
	 * 根据对象查询
	 * @param user
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<User> find(User user, String[][] orders);

	/**
	 * 根据对象查询
	 * @param user
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<User> find(User user, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param user
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<User> find(User user, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param user
	 * @return Long
	 */
	public Long count(User user);
}
