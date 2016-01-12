package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.Khno;

/**
 * Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface KhnoBaseService {

	public void save(Khno khno);
	
	public void update(Khno khno);

	public void modify(Khno khno);

	public void delete(String khno);

	public void batchSave(List<Khno> list);

    public void batchUpdate(List<Khno> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param khno 客户号
	 * @return Khno
	 */
	public Khno findById(String khno);

	/**
	 * 根据对象查询
	 * @param khno
	 * @return List
	 */
	public List<Khno> find(Khno khno);

	/**
	 * 根据对象查询
	 * @param khno
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<Khno> find(Khno khno, String[][] orders);

	/**
	 * 根据对象查询
	 * @param khno
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Khno> find(Khno khno, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param khno
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Khno> find(Khno khno, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param khno
	 * @return Long
	 */
	public Long count(Khno khno);
}
