package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.SysDefaultSetting;

/**
 * 默认值设置表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface SysDefaultSettingBaseDao {

	public void save(SysDefaultSetting sysDefaultSetting);
	
	public void update(SysDefaultSetting sysDefaultSetting);

	public void modify(SysDefaultSetting sysDefaultSetting);

	public void delete(String code);

	public void batchSave(List<SysDefaultSetting> list);

    public void batchUpdate(List<SysDefaultSetting> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param code 代码
	 * @return SysDefaultSetting
	 */
	public SysDefaultSetting findById(String code);

	/**
	 * 根据对象查询
	 * @param sysDefaultSetting
	 * @return List
	 */
	public List<SysDefaultSetting> find(SysDefaultSetting sysDefaultSetting);

	/**
	 * 根据对象查询
	 * @param sysDefaultSetting
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<SysDefaultSetting> find(SysDefaultSetting sysDefaultSetting, String[][] orders);

	/**
	 * 根据对象查询
	 * @param sysDefaultSetting
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysDefaultSetting> find(SysDefaultSetting sysDefaultSetting, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param sysDefaultSetting
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysDefaultSetting> find(SysDefaultSetting sysDefaultSetting, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param sysDefaultSetting
	 * @return Long
	 */
	public Long count(SysDefaultSetting sysDefaultSetting);
}
