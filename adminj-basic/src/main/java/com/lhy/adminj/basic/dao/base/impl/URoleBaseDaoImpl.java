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

import com.lhy.adminj.basic.dao.base.URoleBaseDao;
import com.lhy.adminj.basic.model.URole;

/**
 * 角色表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class URoleBaseDaoImpl implements URoleBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`name`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`name` FROM u_role _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO u_role(`id`, `name`) VALUES (:id, :name)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE u_role SET `id` = :id, `name` = :name WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM u_role WHERE `id` = ?";

	@Override
	public void save(URole uRole) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uRole);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		uRole.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(URole uRole) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uRole);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(URole uRole) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE u_role SET ");
		if(uRole.getId() != null){
			sql.append(" id = ?, ");
			param.add(uRole.getId());
		}
		if(uRole.getName() != null){
			sql.append(" name = ? ");
			param.add(uRole.getName());
		}
		sql.append(" WHERE id = ? ");
		param.add(uRole.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param uRoles
	 * @return
	 */
	public Map<String, Object>[] toMap(List<URole> uRoles){
		Map<String, Object>[] maps = new Map[uRoles.size()];
		for(int i = 0; i < uRoles.size(); i++){
			URole uRole = uRoles.get(i);
			maps[i] = toMap(uRole);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param uRole
	 * @return
	 */
	public Map<String, Object> toMap(URole uRole){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", uRole.getId());
        paramMap.put("name", uRole.getName());
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
	public void batchSave(List<URole> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<URole> list){
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
	 * @return URole
	 */
	@Override
	public URole findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(URole.class), id);
	}

	/**
	 * 根据对象查询
	 * @param uRole
	 * @return List
	 */
	@Override
	public List<URole> find(URole uRole){
		return this.find(uRole, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uRole
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<URole> find(URole uRole, String[][] orders){
		return this.find(uRole, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uRole
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<URole> find(URole uRole, Long offset, Long rows){
		return this.find(uRole, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uRole
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<URole> find(URole uRole, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(uRole != null){
			if(uRole.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(uRole.getId());
			}
			if(uRole.getName() != null && !"".equals(uRole.getName())){
				sql.append(" AND _this.`name` = ?");
				param.add(uRole.getName());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(URole.class));
	}


	/**
	 * 根据对象查询条数
	 * @param uRole
	 * @return Long
	 */
	@Override
	public Long count(URole uRole){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM u_role  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(uRole != null){
			if(uRole.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(uRole.getId());
			}
			if(uRole.getName() != null && !"".equals(uRole.getName())){
				sql.append(" AND _this.`name` = ? ");
				param.add(uRole.getName());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}