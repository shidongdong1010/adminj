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

import com.lhy.adminj.basic.dao.base.UOperLogBaseDao;
import com.lhy.adminj.basic.model.UOperLog;

/**
 * 操作日志Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UOperLogBaseDaoImpl implements UOperLogBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`app_type`, _this.`app_id`, _this.`desc`, _this.`user_id`, _this.`ip`, _this.`create_time`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`app_type`, _this.`app_id`, _this.`desc`, _this.`user_id`, _this.`ip`, _this.`create_time` FROM u_oper_log _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO u_oper_log(`id`, `app_type`, `app_id`, `desc`, `user_id`, `ip`, `create_time`) VALUES (:id, :app_type, :app_id, :desc, :user_id, :ip, :create_time)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE u_oper_log SET `id` = :id, `app_type` = :app_type, `app_id` = :app_id, `desc` = :desc, `user_id` = :user_id, `ip` = :ip, `create_time` = :create_time WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM u_oper_log WHERE `id` = ?";

	@Override
	public void save(UOperLog uOperLog) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uOperLog);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		uOperLog.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UOperLog uOperLog) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uOperLog);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UOperLog uOperLog) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE u_oper_log SET ");
		if(uOperLog.getId() != null){
			sql.append(" id = ?, ");
			param.add(uOperLog.getId());
		}
		if(uOperLog.getAppType() != null){
			sql.append(" app_type = ?, ");
			param.add(uOperLog.getAppType());
		}
		if(uOperLog.getAppId() != null){
			sql.append(" app_id = ?, ");
			param.add(uOperLog.getAppId());
		}
		if(uOperLog.getDesc() != null){
			sql.append(" desc = ?, ");
			param.add(uOperLog.getDesc());
		}
		if(uOperLog.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(uOperLog.getUserId());
		}
		if(uOperLog.getIp() != null){
			sql.append(" ip = ?, ");
			param.add(uOperLog.getIp());
		}
		if(uOperLog.getCreateTime() != null){
			sql.append(" create_time = ? ");
			param.add(uOperLog.getCreateTime());
		}
		sql.append(" WHERE id = ? ");
		param.add(uOperLog.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param uOperLogs
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UOperLog> uOperLogs){
		Map<String, Object>[] maps = new Map[uOperLogs.size()];
		for(int i = 0; i < uOperLogs.size(); i++){
			UOperLog uOperLog = uOperLogs.get(i);
			maps[i] = toMap(uOperLog);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param uOperLog
	 * @return
	 */
	public Map<String, Object> toMap(UOperLog uOperLog){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", uOperLog.getId());
        paramMap.put("app_type", uOperLog.getAppType());
        paramMap.put("app_id", uOperLog.getAppId());
        paramMap.put("desc", uOperLog.getDesc());
        paramMap.put("user_id", uOperLog.getUserId());
        paramMap.put("ip", uOperLog.getIp());
        paramMap.put("create_time", uOperLog.getCreateTime());
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
	public void batchSave(List<UOperLog> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UOperLog> list){
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
	 * @param id 主键ID
	 * @return UOperLog
	 */
	@Override
	public UOperLog findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UOperLog.class), id);
	}

	/**
	 * 根据对象查询
	 * @param uOperLog
	 * @return List
	 */
	@Override
	public List<UOperLog> find(UOperLog uOperLog){
		return this.find(uOperLog, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uOperLog
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UOperLog> find(UOperLog uOperLog, String[][] orders){
		return this.find(uOperLog, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uOperLog
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UOperLog> find(UOperLog uOperLog, Long offset, Long rows){
		return this.find(uOperLog, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uOperLog
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UOperLog> find(UOperLog uOperLog, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(uOperLog != null){
			if(uOperLog.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(uOperLog.getId());
			}
			if(uOperLog.getAppType() != null){
				sql.append(" AND _this.`app_type` = ?");
				param.add(uOperLog.getAppType());
			}
			if(uOperLog.getAppId() != null){
				sql.append(" AND _this.`app_id` = ?");
				param.add(uOperLog.getAppId());
			}
			if(uOperLog.getDesc() != null && !"".equals(uOperLog.getDesc())){
				sql.append(" AND _this.`desc` = ?");
				param.add(uOperLog.getDesc());
			}
			if(uOperLog.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(uOperLog.getUserId());
			}
			if(uOperLog.getIp() != null && !"".equals(uOperLog.getIp())){
				sql.append(" AND _this.`ip` = ?");
				param.add(uOperLog.getIp());
			}
			if(uOperLog.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ?");
				param.add(uOperLog.getCreateTime());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UOperLog.class));
	}


	/**
	 * 根据对象查询条数
	 * @param uOperLog
	 * @return Long
	 */
	@Override
	public Long count(UOperLog uOperLog){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM u_oper_log  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(uOperLog != null){
			if(uOperLog.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(uOperLog.getId());
			}
			if(uOperLog.getAppType() != null){
				sql.append(" AND _this.`app_type` = ? ");
				param.add(uOperLog.getAppType());
			}
			if(uOperLog.getAppId() != null){
				sql.append(" AND _this.`app_id` = ? ");
				param.add(uOperLog.getAppId());
			}
			if(uOperLog.getDesc() != null && !"".equals(uOperLog.getDesc())){
				sql.append(" AND _this.`desc` = ? ");
				param.add(uOperLog.getDesc());
			}
			if(uOperLog.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(uOperLog.getUserId());
			}
			if(uOperLog.getIp() != null && !"".equals(uOperLog.getIp())){
				sql.append(" AND _this.`ip` = ? ");
				param.add(uOperLog.getIp());
			}
			if(uOperLog.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ? ");
				param.add(uOperLog.getCreateTime());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}