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

import com.lhy.adminj.basic.dao.base.URoleResourceBaseDao;
import com.lhy.adminj.basic.model.URoleResource;

/**
 * 角色-资源关系表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class URoleResourceBaseDaoImpl implements URoleResourceBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`role_id`, _this.`resource_id`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`role_id`, _this.`resource_id` FROM u_role_resource _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO u_role_resource(`id`, `role_id`, `resource_id`) VALUES (:id, :role_id, :resource_id)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE u_role_resource SET `id` = :id, `role_id` = :role_id, `resource_id` = :resource_id WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM u_role_resource WHERE `id` = ?";

	@Override
	public void save(URoleResource uRoleResource) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uRoleResource);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		uRoleResource.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(URoleResource uRoleResource) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uRoleResource);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(URoleResource uRoleResource) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE u_role_resource SET ");
		if(uRoleResource.getId() != null){
			sql.append(" id = ?, ");
			param.add(uRoleResource.getId());
		}
		if(uRoleResource.getRoleId() != null){
			sql.append(" role_id = ?, ");
			param.add(uRoleResource.getRoleId());
		}
		if(uRoleResource.getResourceId() != null){
			sql.append(" resource_id = ? ");
			param.add(uRoleResource.getResourceId());
		}
		sql.append(" WHERE id = ? ");
		param.add(uRoleResource.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param uRoleResources
	 * @return
	 */
	public Map<String, Object>[] toMap(List<URoleResource> uRoleResources){
		Map<String, Object>[] maps = new Map[uRoleResources.size()];
		for(int i = 0; i < uRoleResources.size(); i++){
			URoleResource uRoleResource = uRoleResources.get(i);
			maps[i] = toMap(uRoleResource);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param uRoleResource
	 * @return
	 */
	public Map<String, Object> toMap(URoleResource uRoleResource){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", uRoleResource.getId());
        paramMap.put("role_id", uRoleResource.getRoleId());
        paramMap.put("resource_id", uRoleResource.getResourceId());
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
	public void batchSave(List<URoleResource> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<URoleResource> list){
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
	 * @return URoleResource
	 */
	@Override
	public URoleResource findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(URoleResource.class), id);
	}

	/**
	 * 根据对象查询
	 * @param uRoleResource
	 * @return List
	 */
	@Override
	public List<URoleResource> find(URoleResource uRoleResource){
		return this.find(uRoleResource, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uRoleResource
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<URoleResource> find(URoleResource uRoleResource, String[][] orders){
		return this.find(uRoleResource, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uRoleResource
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<URoleResource> find(URoleResource uRoleResource, Long offset, Long rows){
		return this.find(uRoleResource, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uRoleResource
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<URoleResource> find(URoleResource uRoleResource, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(uRoleResource != null){
			if(uRoleResource.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(uRoleResource.getId());
			}
			if(uRoleResource.getRoleId() != null){
				sql.append(" AND _this.`role_id` = ?");
				param.add(uRoleResource.getRoleId());
			}
			if(uRoleResource.getResourceId() != null){
				sql.append(" AND _this.`resource_id` = ?");
				param.add(uRoleResource.getResourceId());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(URoleResource.class));
	}


	/**
	 * 根据对象查询条数
	 * @param uRoleResource
	 * @return Long
	 */
	@Override
	public Long count(URoleResource uRoleResource){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM u_role_resource  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(uRoleResource != null){
			if(uRoleResource.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(uRoleResource.getId());
			}
			if(uRoleResource.getRoleId() != null){
				sql.append(" AND _this.`role_id` = ? ");
				param.add(uRoleResource.getRoleId());
			}
			if(uRoleResource.getResourceId() != null){
				sql.append(" AND _this.`resource_id` = ? ");
				param.add(uRoleResource.getResourceId());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}