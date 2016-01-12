package com.lhy.adminj.basic.dao.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.lhy.adminj.basic.dao.base.UserFriendApplyBaseDao;
import com.lhy.adminj.basic.model.UserFriendApply;

/**
 * 用户好友申请记录Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserFriendApplyBaseDaoImpl implements UserFriendApplyBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`apply_id`, _this.`apply_user_id`, _this.`audit_user_id`, _this.`apply_desc`, _this.`apply_status`, _this.`create_date`, _this.`update_date`, _this.`apply_source`, _this.`is_read`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`apply_id`, _this.`apply_user_id`, _this.`audit_user_id`, _this.`apply_desc`, _this.`apply_status`, _this.`create_date`, _this.`update_date`, _this.`apply_source`, _this.`is_read` FROM umc_user_friend_apply _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_friend_apply(`apply_id`, `apply_user_id`, `audit_user_id`, `apply_desc`, `apply_status`, `create_date`, `update_date`, `apply_source`, `is_read`) VALUES (:apply_id, :apply_user_id, :audit_user_id, :apply_desc, :apply_status, :create_date, :update_date, :apply_source, :is_read)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_friend_apply SET `apply_id` = :apply_id, `apply_user_id` = :apply_user_id, `audit_user_id` = :audit_user_id, `apply_desc` = :apply_desc, `apply_status` = :apply_status, `create_date` = :create_date, `update_date` = :update_date, `apply_source` = :apply_source, `is_read` = :is_read WHERE `apply_id` = :apply_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_friend_apply WHERE `apply_id` = ?";

	@Override
	public void save(UserFriendApply userFriendApply) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userFriendApply);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userFriendApply.setApplyId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserFriendApply userFriendApply) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userFriendApply);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserFriendApply userFriendApply) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_friend_apply SET ");
		if(userFriendApply.getApplyId() != null){
			sql.append(" apply_id = ?, ");
			param.add(userFriendApply.getApplyId());
		}
		if(userFriendApply.getApplyUserId() != null){
			sql.append(" apply_user_id = ?, ");
			param.add(userFriendApply.getApplyUserId());
		}
		if(userFriendApply.getAuditUserId() != null){
			sql.append(" audit_user_id = ?, ");
			param.add(userFriendApply.getAuditUserId());
		}
		if(userFriendApply.getApplyDesc() != null){
			sql.append(" apply_desc = ?, ");
			param.add(userFriendApply.getApplyDesc());
		}
		if(userFriendApply.getApplyStatus() != null){
			sql.append(" apply_status = ?, ");
			param.add(userFriendApply.getApplyStatus());
		}
		if(userFriendApply.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userFriendApply.getCreateDate());
		}
		if(userFriendApply.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userFriendApply.getUpdateDate());
		}
		if(userFriendApply.getApplySource() != null){
			sql.append(" apply_source = ?, ");
			param.add(userFriendApply.getApplySource());
		}
		if(userFriendApply.getIsRead() != null){
			sql.append(" is_read = ? ");
			param.add(userFriendApply.getIsRead());
		}
		sql.append(" WHERE apply_id = ? ");
		param.add(userFriendApply.getApplyId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userFriendApplys
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserFriendApply> userFriendApplys){
		Map<String, Object>[] maps = new Map[userFriendApplys.size()];
		for(int i = 0; i < userFriendApplys.size(); i++){
			UserFriendApply userFriendApply = userFriendApplys.get(i);
			maps[i] = toMap(userFriendApply);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userFriendApply
	 * @return
	 */
	public Map<String, Object> toMap(UserFriendApply userFriendApply){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("apply_id", userFriendApply.getApplyId());
        paramMap.put("apply_user_id", userFriendApply.getApplyUserId());
        paramMap.put("audit_user_id", userFriendApply.getAuditUserId());
        paramMap.put("apply_desc", userFriendApply.getApplyDesc());
        paramMap.put("apply_status", userFriendApply.getApplyStatus());
        paramMap.put("create_date", userFriendApply.getCreateDate());
        paramMap.put("update_date", userFriendApply.getUpdateDate());
        paramMap.put("apply_source", userFriendApply.getApplySource());
        paramMap.put("is_read", userFriendApply.getIsRead());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		return SELECT_COLUMN_SQL;
	}

	@Override
	public void delete(Long applyId){
		jdbcTemplate.update(DELETE_SQL, applyId);
	}

	@Override
	public void batchSave(List<UserFriendApply> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserFriendApply> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(UPDATE_SQL, params);
	}

	@Override
	public void batchDelete(List<Long> ids){
        List<Object[]> list = new ArrayList<Object[]>();
        for(Long id : ids){
            list.add(new Object[]{id});
        }
        jdbcTemplate.batchUpdate(DELETE_SQL, list);
	}


	/**
	 * 根据主键查询
	 * @param applyId 用户好友申请ID
	 * @return UserFriendApply
	 */
	@Override
	public UserFriendApply findById(Long applyId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`apply_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserFriendApply.class), applyId);
	}

	/**
	 * 根据对象查询
	 * @param userFriendApply
	 * @return List
	 */
	@Override
	public List<UserFriendApply> find(UserFriendApply userFriendApply){
		return this.find(userFriendApply, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userFriendApply
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserFriendApply> find(UserFriendApply userFriendApply, String[][] orders){
		return this.find(userFriendApply, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userFriendApply
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserFriendApply> find(UserFriendApply userFriendApply, Long offset, Long rows){
		return this.find(userFriendApply, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userFriendApply
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserFriendApply> find(UserFriendApply userFriendApply, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userFriendApply != null){
			if(userFriendApply.getApplyId() != null){
				sql.append(" AND _this.`apply_id` = ?");
				param.add(userFriendApply.getApplyId());
			}
			if(userFriendApply.getApplyUserId() != null){
				sql.append(" AND _this.`apply_user_id` = ?");
				param.add(userFriendApply.getApplyUserId());
			}
			if(userFriendApply.getAuditUserId() != null){
				sql.append(" AND _this.`audit_user_id` = ?");
				param.add(userFriendApply.getAuditUserId());
			}
			if(userFriendApply.getApplyDesc() != null && !"".equals(userFriendApply.getApplyDesc())){
				sql.append(" AND _this.`apply_desc` = ?");
				param.add(userFriendApply.getApplyDesc());
			}
			if(userFriendApply.getApplyStatus() != null && !"".equals(userFriendApply.getApplyStatus())){
				sql.append(" AND _this.`apply_status` = ?");
				param.add(userFriendApply.getApplyStatus());
			}
			if(userFriendApply.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userFriendApply.getCreateDate());
			}
			if(userFriendApply.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userFriendApply.getUpdateDate());
			}
			if(userFriendApply.getApplySource() != null && !"".equals(userFriendApply.getApplySource())){
				sql.append(" AND _this.`apply_source` = ?");
				param.add(userFriendApply.getApplySource());
			}
			if(userFriendApply.getIsRead() != null && !"".equals(userFriendApply.getIsRead())){
				sql.append(" AND _this.`is_read` = ?");
				param.add(userFriendApply.getIsRead());
			}
		}

		// 排序
		if(orders != null && orders.length > 0){
   			sql.append(" ORDER BY ");
			for(int i = 0; i < orders.length; i++){
    			String[] order = orders[i];
				if(i != 0){
    				sql.append("_this.`").append(order[0]).append("`, ");
				}
				if(order.length == 1){
    				sql.append("_this.`").append(order[0]).append("` ASC ");
				}else{
    				sql.append("_this.`").append(order[0]).append("` ").append(order[1]);
				}
			}
		}

		// 分页
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserFriendApply.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userFriendApply
	 * @return Long
	 */
	@Override
	public Long count(UserFriendApply userFriendApply){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_friend_apply  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userFriendApply != null){
			if(userFriendApply.getApplyId() != null){
				sql.append(" AND _this.`apply_id` = ? ");
				param.add(userFriendApply.getApplyId());
			}
			if(userFriendApply.getApplyUserId() != null){
				sql.append(" AND _this.`apply_user_id` = ? ");
				param.add(userFriendApply.getApplyUserId());
			}
			if(userFriendApply.getAuditUserId() != null){
				sql.append(" AND _this.`audit_user_id` = ? ");
				param.add(userFriendApply.getAuditUserId());
			}
			if(userFriendApply.getApplyDesc() != null && !"".equals(userFriendApply.getApplyDesc())){
				sql.append(" AND _this.`apply_desc` = ? ");
				param.add(userFriendApply.getApplyDesc());
			}
			if(userFriendApply.getApplyStatus() != null && !"".equals(userFriendApply.getApplyStatus())){
				sql.append(" AND _this.`apply_status` = ? ");
				param.add(userFriendApply.getApplyStatus());
			}
			if(userFriendApply.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userFriendApply.getCreateDate());
			}
			if(userFriendApply.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userFriendApply.getUpdateDate());
			}
			if(userFriendApply.getApplySource() != null && !"".equals(userFriendApply.getApplySource())){
				sql.append(" AND _this.`apply_source` = ? ");
				param.add(userFriendApply.getApplySource());
			}
			if(userFriendApply.getIsRead() != null && !"".equals(userFriendApply.getIsRead())){
				sql.append(" AND _this.`is_read` = ? ");
				param.add(userFriendApply.getIsRead());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}