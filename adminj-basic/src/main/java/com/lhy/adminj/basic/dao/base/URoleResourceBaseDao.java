package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.URoleResource;

/**
 * 角色-资源关系表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface URoleResourceBaseDao {

	public void save(URoleResource uRoleResource);
	
	public void update(URoleResource uRoleResource);

	public void modify(URoleResource uRoleResource);

	public void delete(Long id);

	public void batchSave(List<URoleResource> list);

    public void batchUpdate(List<URoleResource> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return URoleResource
	 */
	public URoleResource findById(Long id);

	/**
	 * 根据对象查询
	 * @param uRoleResource
	 * @return List
	 */
	public List<URoleResource> find(URoleResource uRoleResource);

	/**
	 * 根据对象查询
	 * @param uRoleResource
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<URoleResource> find(URoleResource uRoleResource, String[][] orders);

	/**
	 * 根据对象查询
	 * @param uRoleResource
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<URoleResource> find(URoleResource uRoleResource, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param uRoleResource
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<URoleResource> find(URoleResource uRoleResource, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param uRoleResource
	 * @return Long
	 */
	public Long count(URoleResource uRoleResource);
}
