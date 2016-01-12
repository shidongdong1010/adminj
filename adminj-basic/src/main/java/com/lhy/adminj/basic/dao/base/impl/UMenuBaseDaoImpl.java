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

import com.lhy.adminj.basic.dao.base.UMenuBaseDao;
import com.lhy.adminj.basic.model.UMenu;

/**
 * 菜单表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UMenuBaseDaoImpl implements UMenuBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`name`, _this.`level`, _this.`parent_id`, _this.`is_leaf`, _this.`url`, _this.`is_enable`, _this.`sort`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`name`, _this.`level`, _this.`parent_id`, _this.`is_leaf`, _this.`url`, _this.`is_enable`, _this.`sort` FROM u_menu _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO u_menu(`id`, `name`, `level`, `parent_id`, `is_leaf`, `url`, `is_enable`, `sort`) VALUES (:id, :name, :level, :parent_id, :is_leaf, :url, :is_enable, :sort)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE u_menu SET `id` = :id, `name` = :name, `level` = :level, `parent_id` = :parent_id, `is_leaf` = :is_leaf, `url` = :url, `is_enable` = :is_enable, `sort` = :sort WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM u_menu WHERE `id` = ?";

	@Override
	public void save(UMenu uMenu) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uMenu);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		uMenu.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UMenu uMenu) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uMenu);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UMenu uMenu) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE u_menu SET ");
		if(uMenu.getId() != null){
			sql.append(" id = ?, ");
			param.add(uMenu.getId());
		}
		if(uMenu.getName() != null){
			sql.append(" name = ?, ");
			param.add(uMenu.getName());
		}
		if(uMenu.getLevel() != null){
			sql.append(" level = ?, ");
			param.add(uMenu.getLevel());
		}
		if(uMenu.getParentId() != null){
			sql.append(" parent_id = ?, ");
			param.add(uMenu.getParentId());
		}
		if(uMenu.getIsLeaf() != null){
			sql.append(" is_leaf = ?, ");
			param.add(uMenu.getIsLeaf());
		}
		if(uMenu.getUrl() != null){
			sql.append(" url = ?, ");
			param.add(uMenu.getUrl());
		}
		if(uMenu.getIsEnable() != null){
			sql.append(" is_enable = ?, ");
			param.add(uMenu.getIsEnable());
		}
		if(uMenu.getSort() != null){
			sql.append(" sort = ? ");
			param.add(uMenu.getSort());
		}
		sql.append(" WHERE id = ? ");
		param.add(uMenu.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param uMenus
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UMenu> uMenus){
		Map<String, Object>[] maps = new Map[uMenus.size()];
		for(int i = 0; i < uMenus.size(); i++){
			UMenu uMenu = uMenus.get(i);
			maps[i] = toMap(uMenu);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param uMenu
	 * @return
	 */
	public Map<String, Object> toMap(UMenu uMenu){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", uMenu.getId());
        paramMap.put("name", uMenu.getName());
        paramMap.put("level", uMenu.getLevel());
        paramMap.put("parent_id", uMenu.getParentId());
        paramMap.put("is_leaf", uMenu.getIsLeaf());
        paramMap.put("url", uMenu.getUrl());
        paramMap.put("is_enable", uMenu.getIsEnable());
        paramMap.put("sort", uMenu.getSort());
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
	public void batchSave(List<UMenu> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UMenu> list){
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
	 * @return UMenu
	 */
	@Override
	public UMenu findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UMenu.class), id);
	}

	/**
	 * 根据对象查询
	 * @param uMenu
	 * @return List
	 */
	@Override
	public List<UMenu> find(UMenu uMenu){
		return this.find(uMenu, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uMenu
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UMenu> find(UMenu uMenu, String[][] orders){
		return this.find(uMenu, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uMenu
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UMenu> find(UMenu uMenu, Long offset, Long rows){
		return this.find(uMenu, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uMenu
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UMenu> find(UMenu uMenu, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(uMenu != null){
			if(uMenu.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(uMenu.getId());
			}
			if(uMenu.getName() != null && !"".equals(uMenu.getName())){
				sql.append(" AND _this.`name` = ?");
				param.add(uMenu.getName());
			}
			if(uMenu.getLevel() != null){
				sql.append(" AND _this.`level` = ?");
				param.add(uMenu.getLevel());
			}
			if(uMenu.getParentId() != null){
				sql.append(" AND _this.`parent_id` = ?");
				param.add(uMenu.getParentId());
			}
			if(uMenu.getIsLeaf() != null){
				sql.append(" AND _this.`is_leaf` = ?");
				param.add(uMenu.getIsLeaf());
			}
			if(uMenu.getUrl() != null && !"".equals(uMenu.getUrl())){
				sql.append(" AND _this.`url` = ?");
				param.add(uMenu.getUrl());
			}
			if(uMenu.getIsEnable() != null){
				sql.append(" AND _this.`is_enable` = ?");
				param.add(uMenu.getIsEnable());
			}
			if(uMenu.getSort() != null){
				sql.append(" AND _this.`sort` = ?");
				param.add(uMenu.getSort());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UMenu.class));
	}


	/**
	 * 根据对象查询条数
	 * @param uMenu
	 * @return Long
	 */
	@Override
	public Long count(UMenu uMenu){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM u_menu  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(uMenu != null){
			if(uMenu.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(uMenu.getId());
			}
			if(uMenu.getName() != null && !"".equals(uMenu.getName())){
				sql.append(" AND _this.`name` = ? ");
				param.add(uMenu.getName());
			}
			if(uMenu.getLevel() != null){
				sql.append(" AND _this.`level` = ? ");
				param.add(uMenu.getLevel());
			}
			if(uMenu.getParentId() != null){
				sql.append(" AND _this.`parent_id` = ? ");
				param.add(uMenu.getParentId());
			}
			if(uMenu.getIsLeaf() != null){
				sql.append(" AND _this.`is_leaf` = ? ");
				param.add(uMenu.getIsLeaf());
			}
			if(uMenu.getUrl() != null && !"".equals(uMenu.getUrl())){
				sql.append(" AND _this.`url` = ? ");
				param.add(uMenu.getUrl());
			}
			if(uMenu.getIsEnable() != null){
				sql.append(" AND _this.`is_enable` = ? ");
				param.add(uMenu.getIsEnable());
			}
			if(uMenu.getSort() != null){
				sql.append(" AND _this.`sort` = ? ");
				param.add(uMenu.getSort());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}