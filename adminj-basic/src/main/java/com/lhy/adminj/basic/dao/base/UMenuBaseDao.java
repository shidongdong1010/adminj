package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UMenu;

/**
 * 菜单表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UMenuBaseDao {

	public void save(UMenu uMenu);
	
	public void update(UMenu uMenu);

	public void modify(UMenu uMenu);

	public void delete(Long id);

	public void batchSave(List<UMenu> list);

    public void batchUpdate(List<UMenu> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return UMenu
	 */
	public UMenu findById(Long id);

	/**
	 * 根据对象查询
	 * @param uMenu
	 * @return List
	 */
	public List<UMenu> find(UMenu uMenu);

	/**
	 * 根据对象查询
	 * @param uMenu
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UMenu> find(UMenu uMenu, String[][] orders);

	/**
	 * 根据对象查询
	 * @param uMenu
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UMenu> find(UMenu uMenu, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param uMenu
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UMenu> find(UMenu uMenu, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param uMenu
	 * @return Long
	 */
	public Long count(UMenu uMenu);
}
