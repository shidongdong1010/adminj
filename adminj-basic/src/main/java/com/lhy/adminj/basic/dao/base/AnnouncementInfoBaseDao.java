package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.AnnouncementInfo;

/**
 * 公告信息表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface AnnouncementInfoBaseDao {

	public void save(AnnouncementInfo announcementInfo);
	
	public void update(AnnouncementInfo announcementInfo);

	public void modify(AnnouncementInfo announcementInfo);

	public void delete(Long announcementId);

	public void batchSave(List<AnnouncementInfo> list);

    public void batchUpdate(List<AnnouncementInfo> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param announcementId 公告信息ID
	 * @return AnnouncementInfo
	 */
	public AnnouncementInfo findById(Long announcementId);

	/**
	 * 根据对象查询
	 * @param announcementInfo
	 * @return List
	 */
	public List<AnnouncementInfo> find(AnnouncementInfo announcementInfo);

	/**
	 * 根据对象查询
	 * @param announcementInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<AnnouncementInfo> find(AnnouncementInfo announcementInfo, String[][] orders);

	/**
	 * 根据对象查询
	 * @param announcementInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<AnnouncementInfo> find(AnnouncementInfo announcementInfo, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param announcementInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<AnnouncementInfo> find(AnnouncementInfo announcementInfo, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param announcementInfo
	 * @return Long
	 */
	public Long count(AnnouncementInfo announcementInfo);
}
