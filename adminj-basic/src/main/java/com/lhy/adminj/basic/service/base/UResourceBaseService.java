package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UResource;

/**
 * Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UResourceBaseService {

	public void save(UResource uResource);
	
	public void update(UResource uResource);

	public void modify(UResource uResource);

	public void delete(Long id);

	public void batchSave(List<UResource> list);

    public void batchUpdate(List<UResource> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id 
	 * @return UResource
	 */
	public UResource findById(Long id);

	/**
	 * 根据对象查询
	 * @param uResource
	 * @return List
	 */
	public List<UResource> find(UResource uResource);

	/**
	 * 根据对象查询
	 * @param uResource
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UResource> find(UResource uResource, String[][] orders);

	/**
	 * 根据对象查询
	 * @param uResource
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UResource> find(UResource uResource, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param uResource
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UResource> find(UResource uResource, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param uResource
	 * @return Long
	 */
	public Long count(UResource uResource);
}
