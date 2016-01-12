package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UUserRole;

/**
 * 用户角色关系表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UUserRoleBaseDao {

	public void save(UUserRole uUserRole);
	
	public void update(UUserRole uUserRole);

	public void modify(UUserRole uUserRole);

	public void delete(Long id);

	public void batchSave(List<UUserRole> list);

    public void batchUpdate(List<UUserRole> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return UUserRole
	 */
	public UUserRole findById(Long id);

	/**
	 * 根据对象查询
	 * @param uUserRole
	 * @return List
	 */
	public List<UUserRole> find(UUserRole uUserRole);

	/**
	 * 根据对象查询
	 * @param uUserRole
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UUserRole> find(UUserRole uUserRole, String[][] orders);

	/**
	 * 根据对象查询
	 * @param uUserRole
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UUserRole> find(UUserRole uUserRole, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param uUserRole
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UUserRole> find(UUserRole uUserRole, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param uUserRole
	 * @return Long
	 */
	public Long count(UUserRole uUserRole);
}
