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

import com.lhy.adminj.basic.dao.base.SysDefaultSettingBaseDao;
import com.lhy.adminj.basic.model.SysDefaultSetting;

/**
 * 默认值设置表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class SysDefaultSettingBaseDaoImpl implements SysDefaultSettingBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`code`, _this.`value`, _this.`desc`, _this.`create_time`, _this.`create_user_id`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`code`, _this.`value`, _this.`desc`, _this.`create_time`, _this.`create_user_id` FROM sys_default_setting _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO sys_default_setting(`code`, `value`, `desc`, `create_time`, `create_user_id`) VALUES (:code, :value, :desc, :create_time, :create_user_id)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE sys_default_setting SET `code` = :code, `value` = :value, `desc` = :desc, `create_time` = :create_time, `create_user_id` = :create_user_id WHERE `code` = :code";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM sys_default_setting WHERE `code` = ?";

	@Override
	public void save(SysDefaultSetting sysDefaultSetting) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(sysDefaultSetting);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		sysDefaultSetting.setCode(keyHolder.getKey().toString());
	}
	
	@Override
	public void update(SysDefaultSetting sysDefaultSetting) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(sysDefaultSetting);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(SysDefaultSetting sysDefaultSetting) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE sys_default_setting SET ");
		if(sysDefaultSetting.getCode() != null){
			sql.append(" code = ?, ");
			param.add(sysDefaultSetting.getCode());
		}
		if(sysDefaultSetting.getValue() != null){
			sql.append(" value = ?, ");
			param.add(sysDefaultSetting.getValue());
		}
		if(sysDefaultSetting.getDesc() != null){
			sql.append(" desc = ?, ");
			param.add(sysDefaultSetting.getDesc());
		}
		if(sysDefaultSetting.getCreateTime() != null){
			sql.append(" create_time = ?, ");
			param.add(sysDefaultSetting.getCreateTime());
		}
		if(sysDefaultSetting.getCreateUserId() != null){
			sql.append(" create_user_id = ? ");
			param.add(sysDefaultSetting.getCreateUserId());
		}
		sql.append(" WHERE code = ? ");
		param.add(sysDefaultSetting.getCode());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param sysDefaultSettings
	 * @return
	 */
	public Map<String, Object>[] toMap(List<SysDefaultSetting> sysDefaultSettings){
		Map<String, Object>[] maps = new Map[sysDefaultSettings.size()];
		for(int i = 0; i < sysDefaultSettings.size(); i++){
			SysDefaultSetting sysDefaultSetting = sysDefaultSettings.get(i);
			maps[i] = toMap(sysDefaultSetting);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param sysDefaultSetting
	 * @return
	 */
	public Map<String, Object> toMap(SysDefaultSetting sysDefaultSetting){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("code", sysDefaultSetting.getCode());
        paramMap.put("value", sysDefaultSetting.getValue());
        paramMap.put("desc", sysDefaultSetting.getDesc());
        paramMap.put("create_time", sysDefaultSetting.getCreateTime());
        paramMap.put("create_user_id", sysDefaultSetting.getCreateUserId());
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
	public void delete(String code){
		jdbcTemplate.update(DELETE_SQL, code);
	}

	@Override
	public void batchSave(List<SysDefaultSetting> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<SysDefaultSetting> list){
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
	 * @param code 代码
	 * @return SysDefaultSetting
	 */
	@Override
	public SysDefaultSetting findById(String code){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`code` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(SysDefaultSetting.class), code);
	}

	/**
	 * 根据对象查询
	 * @param sysDefaultSetting
	 * @return List
	 */
	@Override
	public List<SysDefaultSetting> find(SysDefaultSetting sysDefaultSetting){
		return this.find(sysDefaultSetting, null, null);
	}

	/**
	 * 根据对象查询
	 * @param sysDefaultSetting
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<SysDefaultSetting> find(SysDefaultSetting sysDefaultSetting, String[][] orders){
		return this.find(sysDefaultSetting, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param sysDefaultSetting
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<SysDefaultSetting> find(SysDefaultSetting sysDefaultSetting, Long offset, Long rows){
		return this.find(sysDefaultSetting, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param sysDefaultSetting
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<SysDefaultSetting> find(SysDefaultSetting sysDefaultSetting, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(sysDefaultSetting != null){
			if(sysDefaultSetting.getCode() != null && !"".equals(sysDefaultSetting.getCode())){
				sql.append(" AND _this.`code` = ?");
				param.add(sysDefaultSetting.getCode());
			}
			if(sysDefaultSetting.getValue() != null && !"".equals(sysDefaultSetting.getValue())){
				sql.append(" AND _this.`value` = ?");
				param.add(sysDefaultSetting.getValue());
			}
			if(sysDefaultSetting.getDesc() != null && !"".equals(sysDefaultSetting.getDesc())){
				sql.append(" AND _this.`desc` = ?");
				param.add(sysDefaultSetting.getDesc());
			}
			if(sysDefaultSetting.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ?");
				param.add(sysDefaultSetting.getCreateTime());
			}
			if(sysDefaultSetting.getCreateUserId() != null){
				sql.append(" AND _this.`create_user_id` = ?");
				param.add(sysDefaultSetting.getCreateUserId());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(SysDefaultSetting.class));
	}


	/**
	 * 根据对象查询条数
	 * @param sysDefaultSetting
	 * @return Long
	 */
	@Override
	public Long count(SysDefaultSetting sysDefaultSetting){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM sys_default_setting  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(sysDefaultSetting != null){
			if(sysDefaultSetting.getCode() != null && !"".equals(sysDefaultSetting.getCode())){
				sql.append(" AND _this.`code` = ? ");
				param.add(sysDefaultSetting.getCode());
			}
			if(sysDefaultSetting.getValue() != null && !"".equals(sysDefaultSetting.getValue())){
				sql.append(" AND _this.`value` = ? ");
				param.add(sysDefaultSetting.getValue());
			}
			if(sysDefaultSetting.getDesc() != null && !"".equals(sysDefaultSetting.getDesc())){
				sql.append(" AND _this.`desc` = ? ");
				param.add(sysDefaultSetting.getDesc());
			}
			if(sysDefaultSetting.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ? ");
				param.add(sysDefaultSetting.getCreateTime());
			}
			if(sysDefaultSetting.getCreateUserId() != null){
				sql.append(" AND _this.`create_user_id` = ? ");
				param.add(sysDefaultSetting.getCreateUserId());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}