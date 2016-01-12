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

import com.lhy.adminj.basic.dao.base.UUserRoleBaseDao;
import com.lhy.adminj.basic.model.UUserRole;

/**
 * 用户角色关系表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UUserRoleBaseDaoImpl implements UUserRoleBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`user_id`, _this.`role_id`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`user_id`, _this.`role_id` FROM u_user_role _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO u_user_role(`id`, `user_id`, `role_id`) VALUES (:id, :user_id, :role_id)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE u_user_role SET `id` = :id, `user_id` = :user_id, `role_id` = :role_id WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM u_user_role WHERE `id` = ?";

	@Override
	public void save(UUserRole uUserRole) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uUserRole);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		uUserRole.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UUserRole uUserRole) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uUserRole);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UUserRole uUserRole) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE u_user_role SET ");
		if(uUserRole.getId() != null){
			sql.append(" id = ?, ");
			param.add(uUserRole.getId());
		}
		if(uUserRole.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(uUserRole.getUserId());
		}
		if(uUserRole.getRoleId() != null){
			sql.append(" role_id = ? ");
			param.add(uUserRole.getRoleId());
		}
		sql.append(" WHERE id = ? ");
		param.add(uUserRole.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param uUserRoles
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UUserRole> uUserRoles){
		Map<String, Object>[] maps = new Map[uUserRoles.size()];
		for(int i = 0; i < uUserRoles.size(); i++){
			UUserRole uUserRole = uUserRoles.get(i);
			maps[i] = toMap(uUserRole);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param uUserRole
	 * @return
	 */
	public Map<String, Object> toMap(UUserRole uUserRole){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", uUserRole.getId());
        paramMap.put("user_id", uUserRole.getUserId());
        paramMap.put("role_id", uUserRole.getRoleId());
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
	public void batchSave(List<UUserRole> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UUserRole> list){
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
	 * @return UUserRole
	 */
	@Override
	public UUserRole findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UUserRole.class), id);
	}

	/**
	 * 根据对象查询
	 * @param uUserRole
	 * @return List
	 */
	@Override
	public List<UUserRole> find(UUserRole uUserRole){
		return this.find(uUserRole, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uUserRole
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UUserRole> find(UUserRole uUserRole, String[][] orders){
		return this.find(uUserRole, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uUserRole
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UUserRole> find(UUserRole uUserRole, Long offset, Long rows){
		return this.find(uUserRole, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uUserRole
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UUserRole> find(UUserRole uUserRole, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(uUserRole != null){
			if(uUserRole.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(uUserRole.getId());
			}
			if(uUserRole.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(uUserRole.getUserId());
			}
			if(uUserRole.getRoleId() != null){
				sql.append(" AND _this.`role_id` = ?");
				param.add(uUserRole.getRoleId());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UUserRole.class));
	}


	/**
	 * 根据对象查询条数
	 * @param uUserRole
	 * @return Long
	 */
	@Override
	public Long count(UUserRole uUserRole){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM u_user_role  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(uUserRole != null){
			if(uUserRole.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(uUserRole.getId());
			}
			if(uUserRole.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(uUserRole.getUserId());
			}
			if(uUserRole.getRoleId() != null){
				sql.append(" AND _this.`role_id` = ? ");
				param.add(uUserRole.getRoleId());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}