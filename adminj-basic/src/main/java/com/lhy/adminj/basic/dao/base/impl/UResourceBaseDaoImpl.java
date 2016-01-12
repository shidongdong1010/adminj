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

import com.lhy.adminj.basic.dao.base.UResourceBaseDao;
import com.lhy.adminj.basic.model.UResource;

/**
 * Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UResourceBaseDaoImpl implements UResourceBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`name`, _this.`url`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`name`, _this.`url` FROM u_resource _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO u_resource(`id`, `name`, `url`) VALUES (:id, :name, :url)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE u_resource SET `id` = :id, `name` = :name, `url` = :url WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM u_resource WHERE `id` = ?";

	@Override
	public void save(UResource uResource) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uResource);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		uResource.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UResource uResource) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uResource);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UResource uResource) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE u_resource SET ");
		if(uResource.getId() != null){
			sql.append(" id = ?, ");
			param.add(uResource.getId());
		}
		if(uResource.getName() != null){
			sql.append(" name = ?, ");
			param.add(uResource.getName());
		}
		if(uResource.getUrl() != null){
			sql.append(" url = ? ");
			param.add(uResource.getUrl());
		}
		sql.append(" WHERE id = ? ");
		param.add(uResource.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param uResources
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UResource> uResources){
		Map<String, Object>[] maps = new Map[uResources.size()];
		for(int i = 0; i < uResources.size(); i++){
			UResource uResource = uResources.get(i);
			maps[i] = toMap(uResource);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param uResource
	 * @return
	 */
	public Map<String, Object> toMap(UResource uResource){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", uResource.getId());
        paramMap.put("name", uResource.getName());
        paramMap.put("url", uResource.getUrl());
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
	public void batchSave(List<UResource> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UResource> list){
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
	 * @return UResource
	 */
	@Override
	public UResource findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UResource.class), id);
	}

	/**
	 * 根据对象查询
	 * @param uResource
	 * @return List
	 */
	@Override
	public List<UResource> find(UResource uResource){
		return this.find(uResource, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uResource
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UResource> find(UResource uResource, String[][] orders){
		return this.find(uResource, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uResource
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UResource> find(UResource uResource, Long offset, Long rows){
		return this.find(uResource, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uResource
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UResource> find(UResource uResource, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(uResource != null){
			if(uResource.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(uResource.getId());
			}
			if(uResource.getName() != null && !"".equals(uResource.getName())){
				sql.append(" AND _this.`name` = ?");
				param.add(uResource.getName());
			}
			if(uResource.getUrl() != null && !"".equals(uResource.getUrl())){
				sql.append(" AND _this.`url` = ?");
				param.add(uResource.getUrl());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UResource.class));
	}


	/**
	 * 根据对象查询条数
	 * @param uResource
	 * @return Long
	 */
	@Override
	public Long count(UResource uResource){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM u_resource  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(uResource != null){
			if(uResource.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(uResource.getId());
			}
			if(uResource.getName() != null && !"".equals(uResource.getName())){
				sql.append(" AND _this.`name` = ? ");
				param.add(uResource.getName());
			}
			if(uResource.getUrl() != null && !"".equals(uResource.getUrl())){
				sql.append(" AND _this.`url` = ? ");
				param.add(uResource.getUrl());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}