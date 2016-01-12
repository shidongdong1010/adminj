package com.lhy.adminj.basic.dao.impl;

import com.lhy.adminj.basic.dao.UserDynamicInfoDao;
import com.lhy.adminj.basic.dao.base.impl.UserDynamicInfoBaseDaoImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户动态表Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class UserDynamicInfoDaoImpl extends UserDynamicInfoBaseDaoImpl implements UserDynamicInfoDao {

	/**
	 * 根据对象查询条数
	 * @param userName
	 * @param groupName
	 * @param type
	 * @param auditStatus
	 * @return Long
	 */
	@Override
	public Long orderCount(String userName,String groupName,String type,String auditStatus, String isInput){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT");
		sql.append("	count(*)");
		sql.append(" FROM");
		sql.append("	udc_user_dynamic_info udi");
		sql.append(" INNER JOIN tmc_my_group mg ON mg.user_id = udi.user_id and mg.group_name = udi.title ");
		sql.append(" INNER JOIN umc_user u ON u.user_id = udi.user_id");
		sql.append(" WHERE 1=1 ");
		List<Object> param = new ArrayList<Object>();
		if(StringUtils.isNotBlank(userName)){
			sql.append("  AND u.user_name like ? ");
			param.add("%"+userName+"%");
		}
		if(StringUtils.isNotBlank(groupName)){
			sql.append("  AND mg.group_name like ? ");
			param.add("%"+groupName+"%");
		}
		if(StringUtils.isNotBlank(type)){
			sql.append("  AND udi.type = ? ");
			param.add(type);
		}
		if(StringUtils.isNotBlank(auditStatus)){
			sql.append("  AND udi.audit_status = ? ");
			param.add(auditStatus);
		}
		if(StringUtils.isNotBlank(isInput)){
			sql.append("  AND udi.is_input = ? ");
			param.add(isInput);
		}
		return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
	/**
	 * 根据条件查询
	 * @param userName 用户名
	 * @param groupName 组名
	 * @param type 动态类型
	 * @param offset 开始索引
	 * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Map<String, Object>> find(String userName,String groupName,String type,String auditStatus, String isInput,Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT");
		sql.append("	udi.dynamic_id,");
		sql.append("	u.user_name,");
		sql.append("	u.user_id,");
		sql.append("	mg.group_name,");
		sql.append("	mg.total_trade_income total_income,");
		sql.append("	mg.today_trade_income day_float_limit,");
		sql.append("	mg.total_cost,");
		sql.append("	mg.follow_buy_num,");
		sql.append("	date_format(udi.create_date,'%Y-%c-%d %h:%i:%s') create_date,");
		sql.append("	udi.title,");
		sql.append("	udi.mark,");
		sql.append("	udi.image_path,");
		sql.append("	udi.audit_status");
		sql.append(" FROM");
		sql.append("	udc_user_dynamic_info udi");
		sql.append(" INNER JOIN tmc_my_group mg ON mg.user_id = udi.user_id and mg.group_name = udi.title ");
		sql.append(" INNER JOIN umc_user u ON u.user_id = udi.user_id");
		sql.append(" WHERE 1=1 ");
		List<Object> param = new ArrayList<Object>();
		if(StringUtils.isNotBlank(userName)){
			sql.append("  AND u.user_name like ? ");
			param.add("%"+userName+"%");
		}
		if(StringUtils.isNotBlank(groupName)){
			sql.append("  AND mg.group_name like ? ");
			param.add("%"+groupName+"%");
		}
		if(StringUtils.isNotBlank(type)){
			sql.append("  AND udi.type = ? ");
			param.add(type);
		}
		if(StringUtils.isNotBlank(auditStatus)){
			sql.append("  AND udi.audit_status = ? ");
			param.add(auditStatus);
		}
		if(StringUtils.isNotBlank(isInput)){
			sql.append("  AND udi.is_input = ? ");
			param.add(isInput);
		}
		sql.append(" ORDER BY udi.dynamic_id desc ");
		if(offset != null  && rows != null){
			sql.append("  limit ?,? ");
			param.add(offset);
			param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}
	/**
	 * 根据条件查询条数
	 * @param userName 用户名
	 * @param auditStatus 审核状态
	 * @param createDateStart 开始时间
	 * @param createDateEnd 截止时间
	 * @param type 动态类型
	 * @return Long
	 */
	@Override
	public Long count(String userName,String type,String auditStatus,String createDateStart,String createDateEnd,String is_del, String isInput){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT");
		sql.append("	count(*)");
		sql.append(" FROM");
		sql.append("	udc_user_dynamic_info udi");
		sql.append(" INNER JOIN umc_user u ON u.user_id = udi.user_id");
		sql.append(" WHERE 1=1 ");
		List<Object> param = new ArrayList<Object>();
		if(StringUtils.isNotBlank(userName)){
			sql.append("  AND u.user_name like ? ");
			param.add("%"+userName+"%");
		}
		if(StringUtils.isNotBlank(type)){
			sql.append("  AND udi.type = ? ");
			param.add(type);
		}
		if(StringUtils.isNotBlank(auditStatus)){
			sql.append("  AND udi.audit_status = ? ");
			param.add(auditStatus);
		}
		if(StringUtils.isNotBlank(isInput)){
			sql.append("  AND udi.is_input = ? ");
			param.add(isInput);
		}
		if(StringUtils.isNotBlank(createDateStart)){
			sql.append("  AND date(udi.create_date) >= ? ");
			param.add(createDateStart);
		}
		if(StringUtils.isNotBlank(createDateEnd)){
			sql.append("  AND date(udi.create_date) <= ? ");
			param.add(createDateEnd);
		}
		if(StringUtils.isNotBlank(is_del)){
			sql.append("  AND udi.is_del = ? ");
			param.add(is_del);
		}
		return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
	/**
	 * 根据条件查询
	 * @param userName 用户名
	 * @param auditStatus 审核状态
	 * @param createDateStart 开始时间
	 * @param createDateEnd 截止时间
	 * @param type 动态类型
	 * @param offset 开始索引
	 * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Map<String, Object>> find(String userName,String type,String auditStatus,String createDateStart,String createDateEnd,String is_del, String isInput,Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT");
		sql.append("	udi.dynamic_id,");
		sql.append("	u.user_id,");
		sql.append("	u.user_name,");
		sql.append("	udi.type,");
		sql.append("	date_format(udi.create_date,'%Y-%c-%d %h:%i:%s') create_date,");
		sql.append("	udi.title,");
		sql.append("	udi.mark,");
		sql.append("	udi.image_path,");
		sql.append("	udi.audit_status,");
		sql.append("	udi.is_del");
		sql.append(" FROM");
		sql.append("	udc_user_dynamic_info udi");
		sql.append(" INNER JOIN umc_user u ON u.user_id = udi.user_id");
		sql.append(" WHERE 1=1 ");
		List<Object> param = new ArrayList<Object>();
		if(StringUtils.isNotBlank(userName)){
			sql.append("  AND u.user_name like ? ");
			param.add("%"+userName+"%");
		}
		if(StringUtils.isNotBlank(type)){
			sql.append("  AND udi.type = ? ");
			param.add(type);
		}
		if(StringUtils.isNotBlank(is_del)){
			sql.append("  AND udi.is_del = ? ");
			param.add(is_del);
		}
		if(StringUtils.isNotBlank(auditStatus)){
			sql.append("  AND udi.audit_status = ? ");
			param.add(auditStatus);
		}
		if(StringUtils.isNotBlank(isInput)){
			sql.append("  AND udi.is_input = ? ");
			param.add(isInput);
		}
		if(StringUtils.isNotBlank(createDateStart)){
			sql.append("  AND date(udi.create_date) >= ? ");
			param.add(createDateStart);
		}
		if(StringUtils.isNotBlank(createDateEnd)){
			sql.append("  AND date(udi.create_date) <= ? ");
			param.add(createDateEnd);
		}
		sql.append(" ORDER BY udi.dynamic_id desc ");
		if(offset != null  && rows != null){
			sql.append("  limit ?,? ");
			param.add(offset);
			param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}
}
