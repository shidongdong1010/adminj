package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserDynamicSet;

/**
 * 用户动态设置表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserDynamicSetBaseService {

	public void save(UserDynamicSet userDynamicSet);
	
	public void update(UserDynamicSet userDynamicSet);

	public void modify(UserDynamicSet userDynamicSet);

	public void delete(Long userId);

	public void batchSave(List<UserDynamicSet> list);

    public void batchUpdate(List<UserDynamicSet> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param userId 用户ID
	 * @return UserDynamicSet
	 */
	public UserDynamicSet findById(Long userId);

	/**
	 * 根据对象查询
	 * @param userDynamicSet
	 * @return List
	 */
	public List<UserDynamicSet> find(UserDynamicSet userDynamicSet);

	/**
	 * 根据对象查询
	 * @param userDynamicSet
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicSet> find(UserDynamicSet userDynamicSet, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userDynamicSet
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicSet> find(UserDynamicSet userDynamicSet, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userDynamicSet
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicSet> find(UserDynamicSet userDynamicSet, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userDynamicSet
	 * @return Long
	 */
	public Long count(UserDynamicSet userDynamicSet);
}
