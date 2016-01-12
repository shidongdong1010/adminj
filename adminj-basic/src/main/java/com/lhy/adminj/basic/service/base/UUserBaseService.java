package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UUser;

/**
 * 用户表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UUserBaseService {

	public void save(UUser uUser);
	
	public void update(UUser uUser);

	public void modify(UUser uUser);

	public void delete(Long id);

	public void batchSave(List<UUser> list);

    public void batchUpdate(List<UUser> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return UUser
	 */
	public UUser findById(Long id);

	/**
	 * 根据对象查询
	 * @param uUser
	 * @return List
	 */
	public List<UUser> find(UUser uUser);

	/**
	 * 根据对象查询
	 * @param uUser
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UUser> find(UUser uUser, String[][] orders);

	/**
	 * 根据对象查询
	 * @param uUser
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UUser> find(UUser uUser, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param uUser
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UUser> find(UUser uUser, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param uUser
	 * @return Long
	 */
	public Long count(UUser uUser);
}
