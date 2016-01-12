package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserDynamicPraiseRecord;

/**
 * 用户动态点赞记录表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserDynamicPraiseRecordBaseService {

	public void save(UserDynamicPraiseRecord userDynamicPraiseRecord);
	
	public void update(UserDynamicPraiseRecord userDynamicPraiseRecord);

	public void modify(UserDynamicPraiseRecord userDynamicPraiseRecord);

	public void delete(Long praiseId);

	public void batchSave(List<UserDynamicPraiseRecord> list);

    public void batchUpdate(List<UserDynamicPraiseRecord> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param praiseId 点赞ID
	 * @return UserDynamicPraiseRecord
	 */
	public UserDynamicPraiseRecord findById(Long praiseId);

	/**
	 * 根据对象查询
	 * @param userDynamicPraiseRecord
	 * @return List
	 */
	public List<UserDynamicPraiseRecord> find(UserDynamicPraiseRecord userDynamicPraiseRecord);

	/**
	 * 根据对象查询
	 * @param userDynamicPraiseRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDynamicPraiseRecord> find(UserDynamicPraiseRecord userDynamicPraiseRecord, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userDynamicPraiseRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicPraiseRecord> find(UserDynamicPraiseRecord userDynamicPraiseRecord, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userDynamicPraiseRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDynamicPraiseRecord> find(UserDynamicPraiseRecord userDynamicPraiseRecord, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userDynamicPraiseRecord
	 * @return Long
	 */
	public Long count(UserDynamicPraiseRecord userDynamicPraiseRecord);
}
