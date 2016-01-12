package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.URole;

/**
 * 角色表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface URoleBaseDao {

	public void save(URole uRole);
	
	public void update(URole uRole);

	public void modify(URole uRole);

	public void delete(Long id);

	public void batchSave(List<URole> list);

    public void batchUpdate(List<URole> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return URole
	 */
	public URole findById(Long id);

	/**
	 * 根据对象查询
	 * @param uRole
	 * @return List
	 */
	public List<URole> find(URole uRole);

	/**
	 * 根据对象查询
	 * @param uRole
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<URole> find(URole uRole, String[][] orders);

	/**
	 * 根据对象查询
	 * @param uRole
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<URole> find(URole uRole, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param uRole
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<URole> find(URole uRole, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param uRole
	 * @return Long
	 */
	public Long count(URole uRole);
}
