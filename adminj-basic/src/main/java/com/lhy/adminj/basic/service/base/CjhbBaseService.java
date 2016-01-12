package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.Cjhb;

/**
 * Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface CjhbBaseService {

	public void save(Cjhb cjhb);
	
	public void update(Cjhb cjhb);

	public void modify(Cjhb cjhb);

	public void delete(Long id);

	public void batchSave(List<Cjhb> list);

    public void batchUpdate(List<Cjhb> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id 
	 * @return Cjhb
	 */
	public Cjhb findById(Long id);

	/**
	 * 根据对象查询
	 * @param cjhb
	 * @return List
	 */
	public List<Cjhb> find(Cjhb cjhb);

	/**
	 * 根据对象查询
	 * @param cjhb
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<Cjhb> find(Cjhb cjhb, String[][] orders);

	/**
	 * 根据对象查询
	 * @param cjhb
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Cjhb> find(Cjhb cjhb, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param cjhb
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Cjhb> find(Cjhb cjhb, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param cjhb
	 * @return Long
	 */
	public Long count(Cjhb cjhb);
}
