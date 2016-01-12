package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserDynamicInfo;

/**
 * 用户动态表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserDynamicInfoBaseDao {

	public void save(UserDynamicInfo userDynamicInfo);
	
	public void update(UserDynamicInfo userDynamicInfo);

	public void modify(UserDynamicInfo userDynamicInfo);

	public void delete(Long dynamicId);

	public void batchSave(List<UserDynamicInfo> list);

    public void batchUpdate(List<UserDynamicInfo> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param dynamicId 动态ID,自增ID
	 * @return UserDynamicInfo
	 */
	public UserDynamicInfo findById(Long dynamicId);

	/**
	 * 根据对象查询
	 * @param userDynamicInfo
	 * @return List
	 */
	public List<UserDynamicInfo> find(UserDynamicInfo userDynamicInfo);

	/**
	 * 根据对象查询
	 * @param userDynamicInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicInfo> find(UserDynamicInfo userDynamicInfo, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userDynamicInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicInfo> find(UserDynamicInfo userDynamicInfo, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userDynamicInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicInfo> find(UserDynamicInfo userDynamicInfo, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userDynamicInfo
	 * @return Long
	 */
	public Long count(UserDynamicInfo userDynamicInfo);
}
