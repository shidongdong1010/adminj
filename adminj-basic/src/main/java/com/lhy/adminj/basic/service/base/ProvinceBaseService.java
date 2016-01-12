package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.Province;

/**
 * 省份表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface ProvinceBaseService {

	public void save(Province province);
	
	public void update(Province province);

	public void modify(Province province);

	public void delete(Long provinceId);

	public void batchSave(List<Province> list);

    public void batchUpdate(List<Province> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param provinceId 省份ID
	 * @return Province
	 */
	public Province findById(Long provinceId);

	/**
	 * 根据对象查询
	 * @param province
	 * @return List
	 */
	public List<Province> find(Province province);

	/**
	 * 根据对象查询
	 * @param province
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<Province> find(Province province, String[][] orders);

	/**
	 * 根据对象查询
	 * @param province
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Province> find(Province province, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param province
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Province> find(Province province, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param province
	 * @return Long
	 */
	public Long count(Province province);
}
