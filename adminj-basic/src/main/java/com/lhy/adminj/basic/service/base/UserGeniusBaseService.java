package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserGenius;

/**
 * 牛人排名记录表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserGeniusBaseService {

	public void save(UserGenius userGenius);
	
	public void update(UserGenius userGenius);

	public void modify(UserGenius userGenius);

	public void delete(Long geniusId);

	public void batchSave(List<UserGenius> list);

    public void batchUpdate(List<UserGenius> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param geniusId 牛人表主键ID
	 * @return UserGenius
	 */
	public UserGenius findById(Long geniusId);

	/**
	 * 根据对象查询
	 * @param userGenius
	 * @return List
	 */
	public List<UserGenius> find(UserGenius userGenius);

	/**
	 * 根据对象查询
	 * @param userGenius
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserGenius> find(UserGenius userGenius, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userGenius
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserGenius> find(UserGenius userGenius, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userGenius
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserGenius> find(UserGenius userGenius, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userGenius
	 * @return Long
	 */
	public Long count(UserGenius userGenius);
}
