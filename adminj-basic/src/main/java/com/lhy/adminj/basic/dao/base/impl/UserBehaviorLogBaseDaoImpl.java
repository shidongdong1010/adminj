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

import com.lhy.adminj.basic.dao.base.UserBehaviorLogBaseDao;
import com.lhy.adminj.basic.model.UserBehaviorLog;

/**
 * 用户行为日志Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserBehaviorLogBaseDaoImpl implements UserBehaviorLogBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`code`, _this.`operation`, _this.`time`, _this.`create_time`, _this.`ip`, _this.`user_id`, _this.`client_id`, _this.`client_type`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`code`, _this.`operation`, _this.`time`, _this.`create_time`, _this.`ip`, _this.`user_id`, _this.`client_id`, _this.`client_type` FROM umc_user_behavior_log _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_behavior_log(`id`, `code`, `operation`, `time`, `create_time`, `ip`, `user_id`, `client_id`, `client_type`) VALUES (:id, :code, :operation, :time, :create_time, :ip, :user_id, :client_id, :client_type)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_behavior_log SET `id` = :id, `code` = :code, `operation` = :operation, `time` = :time, `create_time` = :create_time, `ip` = :ip, `user_id` = :user_id, `client_id` = :client_id, `client_type` = :client_type WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_behavior_log WHERE `id` = ?";

	@Override
	public void save(UserBehaviorLog userBehaviorLog) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userBehaviorLog);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userBehaviorLog.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserBehaviorLog userBehaviorLog) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userBehaviorLog);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserBehaviorLog userBehaviorLog) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_behavior_log SET ");
		if(userBehaviorLog.getId() != null){
			sql.append(" id = ?, ");
			param.add(userBehaviorLog.getId());
		}
		if(userBehaviorLog.getCode() != null){
			sql.append(" code = ?, ");
			param.add(userBehaviorLog.getCode());
		}
		if(userBehaviorLog.getOperation() != null){
			sql.append(" operation = ?, ");
			param.add(userBehaviorLog.getOperation());
		}
		if(userBehaviorLog.getTime() != null){
			sql.append(" time = ?, ");
			param.add(userBehaviorLog.getTime());
		}
		if(userBehaviorLog.getCreateTime() != null){
			sql.append(" create_time = ?, ");
			param.add(userBehaviorLog.getCreateTime());
		}
		if(userBehaviorLog.getIp() != null){
			sql.append(" ip = ?, ");
			param.add(userBehaviorLog.getIp());
		}
		if(userBehaviorLog.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userBehaviorLog.getUserId());
		}
		if(userBehaviorLog.getClientId() != null){
			sql.append(" client_id = ?, ");
			param.add(userBehaviorLog.getClientId());
		}
		if(userBehaviorLog.getClientType() != null){
			sql.append(" client_type = ? ");
			param.add(userBehaviorLog.getClientType());
		}
		sql.append(" WHERE id = ? ");
		param.add(userBehaviorLog.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userBehaviorLogs
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserBehaviorLog> userBehaviorLogs){
		Map<String, Object>[] maps = new Map[userBehaviorLogs.size()];
		for(int i = 0; i < userBehaviorLogs.size(); i++){
			UserBehaviorLog userBehaviorLog = userBehaviorLogs.get(i);
			maps[i] = toMap(userBehaviorLog);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userBehaviorLog
	 * @return
	 */
	public Map<String, Object> toMap(UserBehaviorLog userBehaviorLog){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", userBehaviorLog.getId());
        paramMap.put("code", userBehaviorLog.getCode());
        paramMap.put("operation", userBehaviorLog.getOperation());
        paramMap.put("time", userBehaviorLog.getTime());
        paramMap.put("create_time", userBehaviorLog.getCreateTime());
        paramMap.put("ip", userBehaviorLog.getIp());
        paramMap.put("user_id", userBehaviorLog.getUserId());
        paramMap.put("client_id", userBehaviorLog.getClientId());
        paramMap.put("client_type", userBehaviorLog.getClientType());
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
	public void delete(Long id){
		jdbcTemplate.update(DELETE_SQL, id);
	}

	@Override
	public void batchSave(List<UserBehaviorLog> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserBehaviorLog> list){
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
	 * @param id 
	 * @return UserBehaviorLog
	 */
	@Override
	public UserBehaviorLog findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserBehaviorLog.class), id);
	}

	/**
	 * 根据对象查询
	 * @param userBehaviorLog
	 * @return List
	 */
	@Override
	public List<UserBehaviorLog> find(UserBehaviorLog userBehaviorLog){
		return this.find(userBehaviorLog, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userBehaviorLog
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserBehaviorLog> find(UserBehaviorLog userBehaviorLog, String[][] orders){
		return this.find(userBehaviorLog, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userBehaviorLog
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserBehaviorLog> find(UserBehaviorLog userBehaviorLog, Long offset, Long rows){
		return this.find(userBehaviorLog, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userBehaviorLog
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserBehaviorLog> find(UserBehaviorLog userBehaviorLog, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userBehaviorLog != null){
			if(userBehaviorLog.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(userBehaviorLog.getId());
			}
			if(userBehaviorLog.getCode() != null && !"".equals(userBehaviorLog.getCode())){
				sql.append(" AND _this.`code` = ?");
				param.add(userBehaviorLog.getCode());
			}
			if(userBehaviorLog.getOperation() != null && !"".equals(userBehaviorLog.getOperation())){
				sql.append(" AND _this.`operation` = ?");
				param.add(userBehaviorLog.getOperation());
			}
			if(userBehaviorLog.getTime() != null){
				sql.append(" AND _this.`time` = ?");
				param.add(userBehaviorLog.getTime());
			}
			if(userBehaviorLog.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ?");
				param.add(userBehaviorLog.getCreateTime());
			}
			if(userBehaviorLog.getIp() != null && !"".equals(userBehaviorLog.getIp())){
				sql.append(" AND _this.`ip` = ?");
				param.add(userBehaviorLog.getIp());
			}
			if(userBehaviorLog.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userBehaviorLog.getUserId());
			}
			if(userBehaviorLog.getClientId() != null && !"".equals(userBehaviorLog.getClientId())){
				sql.append(" AND _this.`client_id` = ?");
				param.add(userBehaviorLog.getClientId());
			}
			if(userBehaviorLog.getClientType() != null && !"".equals(userBehaviorLog.getClientType())){
				sql.append(" AND _this.`client_type` = ?");
				param.add(userBehaviorLog.getClientType());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserBehaviorLog.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userBehaviorLog
	 * @return Long
	 */
	@Override
	public Long count(UserBehaviorLog userBehaviorLog){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_behavior_log  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userBehaviorLog != null){
			if(userBehaviorLog.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(userBehaviorLog.getId());
			}
			if(userBehaviorLog.getCode() != null && !"".equals(userBehaviorLog.getCode())){
				sql.append(" AND _this.`code` = ? ");
				param.add(userBehaviorLog.getCode());
			}
			if(userBehaviorLog.getOperation() != null && !"".equals(userBehaviorLog.getOperation())){
				sql.append(" AND _this.`operation` = ? ");
				param.add(userBehaviorLog.getOperation());
			}
			if(userBehaviorLog.getTime() != null){
				sql.append(" AND _this.`time` = ? ");
				param.add(userBehaviorLog.getTime());
			}
			if(userBehaviorLog.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ? ");
				param.add(userBehaviorLog.getCreateTime());
			}
			if(userBehaviorLog.getIp() != null && !"".equals(userBehaviorLog.getIp())){
				sql.append(" AND _this.`ip` = ? ");
				param.add(userBehaviorLog.getIp());
			}
			if(userBehaviorLog.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userBehaviorLog.getUserId());
			}
			if(userBehaviorLog.getClientId() != null && !"".equals(userBehaviorLog.getClientId())){
				sql.append(" AND _this.`client_id` = ? ");
				param.add(userBehaviorLog.getClientId());
			}
			if(userBehaviorLog.getClientType() != null && !"".equals(userBehaviorLog.getClientType())){
				sql.append(" AND _this.`client_type` = ? ");
				param.add(userBehaviorLog.getClientType());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}