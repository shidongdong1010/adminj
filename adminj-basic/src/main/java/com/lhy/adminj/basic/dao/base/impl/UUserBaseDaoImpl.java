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

import com.lhy.adminj.basic.dao.base.UUserBaseDao;
import com.lhy.adminj.basic.model.UUser;

/**
 * 用户表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UUserBaseDaoImpl implements UUserBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`user_name`, _this.`password`, _this.`is_expired`, _this.`is_locked`, _this.`is_enable`, _this.`mobile`, _this.`fullname`, _this.`last_login_time`, _this.`login_error_count`, _this.`create_time`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`user_name`, _this.`password`, _this.`is_expired`, _this.`is_locked`, _this.`is_enable`, _this.`mobile`, _this.`fullname`, _this.`last_login_time`, _this.`login_error_count`, _this.`create_time` FROM u_user _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO u_user(`id`, `user_name`, `password`, `is_expired`, `is_locked`, `is_enable`, `mobile`, `fullname`, `last_login_time`, `login_error_count`, `create_time`) VALUES (:id, :user_name, :password, :is_expired, :is_locked, :is_enable, :mobile, :fullname, :last_login_time, :login_error_count, :create_time)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE u_user SET `id` = :id, `user_name` = :user_name, `password` = :password, `is_expired` = :is_expired, `is_locked` = :is_locked, `is_enable` = :is_enable, `mobile` = :mobile, `fullname` = :fullname, `last_login_time` = :last_login_time, `login_error_count` = :login_error_count, `create_time` = :create_time WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM u_user WHERE `id` = ?";

	@Override
	public void save(UUser uUser) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uUser);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		uUser.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UUser uUser) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(uUser);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UUser uUser) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE u_user SET ");
		if(uUser.getId() != null){
			sql.append(" id = ?, ");
			param.add(uUser.getId());
		}
		if(uUser.getUserName() != null){
			sql.append(" user_name = ?, ");
			param.add(uUser.getUserName());
		}
		if(uUser.getPassword() != null){
			sql.append(" password = ?, ");
			param.add(uUser.getPassword());
		}
		if(uUser.getIsExpired() != null){
			sql.append(" is_expired = ?, ");
			param.add(uUser.getIsExpired());
		}
		if(uUser.getIsLocked() != null){
			sql.append(" is_locked = ?, ");
			param.add(uUser.getIsLocked());
		}
		if(uUser.getIsEnable() != null){
			sql.append(" is_enable = ?, ");
			param.add(uUser.getIsEnable());
		}
		if(uUser.getMobile() != null){
			sql.append(" mobile = ?, ");
			param.add(uUser.getMobile());
		}
		if(uUser.getFullname() != null){
			sql.append(" fullname = ?, ");
			param.add(uUser.getFullname());
		}
		if(uUser.getLastLoginTime() != null){
			sql.append(" last_login_time = ?, ");
			param.add(uUser.getLastLoginTime());
		}
		if(uUser.getLoginErrorCount() != null){
			sql.append(" login_error_count = ?, ");
			param.add(uUser.getLoginErrorCount());
		}
		if(uUser.getCreateTime() != null){
			sql.append(" create_time = ? ");
			param.add(uUser.getCreateTime());
		}
		sql.append(" WHERE id = ? ");
		param.add(uUser.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param uUsers
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UUser> uUsers){
		Map<String, Object>[] maps = new Map[uUsers.size()];
		for(int i = 0; i < uUsers.size(); i++){
			UUser uUser = uUsers.get(i);
			maps[i] = toMap(uUser);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param uUser
	 * @return
	 */
	public Map<String, Object> toMap(UUser uUser){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", uUser.getId());
        paramMap.put("user_name", uUser.getUserName());
        paramMap.put("password", uUser.getPassword());
        paramMap.put("is_expired", uUser.getIsExpired());
        paramMap.put("is_locked", uUser.getIsLocked());
        paramMap.put("is_enable", uUser.getIsEnable());
        paramMap.put("mobile", uUser.getMobile());
        paramMap.put("fullname", uUser.getFullname());
        paramMap.put("last_login_time", uUser.getLastLoginTime());
        paramMap.put("login_error_count", uUser.getLoginErrorCount());
        paramMap.put("create_time", uUser.getCreateTime());
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
	public void batchSave(List<UUser> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UUser> list){
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
	 * @return UUser
	 */
	@Override
	public UUser findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UUser.class), id);
	}

	/**
	 * 根据对象查询
	 * @param uUser
	 * @return List
	 */
	@Override
	public List<UUser> find(UUser uUser){
		return this.find(uUser, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uUser
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UUser> find(UUser uUser, String[][] orders){
		return this.find(uUser, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param uUser
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UUser> find(UUser uUser, Long offset, Long rows){
		return this.find(uUser, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param uUser
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UUser> find(UUser uUser, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(uUser != null){
			if(uUser.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(uUser.getId());
			}
			if(uUser.getUserName() != null && !"".equals(uUser.getUserName())){
				sql.append(" AND _this.`user_name` = ?");
				param.add(uUser.getUserName());
			}
			if(uUser.getPassword() != null && !"".equals(uUser.getPassword())){
				sql.append(" AND _this.`password` = ?");
				param.add(uUser.getPassword());
			}
			if(uUser.getIsExpired() != null){
				sql.append(" AND _this.`is_expired` = ?");
				param.add(uUser.getIsExpired());
			}
			if(uUser.getIsLocked() != null){
				sql.append(" AND _this.`is_locked` = ?");
				param.add(uUser.getIsLocked());
			}
			if(uUser.getIsEnable() != null){
				sql.append(" AND _this.`is_enable` = ?");
				param.add(uUser.getIsEnable());
			}
			if(uUser.getMobile() != null && !"".equals(uUser.getMobile())){
				sql.append(" AND _this.`mobile` = ?");
				param.add(uUser.getMobile());
			}
			if(uUser.getFullname() != null && !"".equals(uUser.getFullname())){
				sql.append(" AND _this.`fullname` = ?");
				param.add(uUser.getFullname());
			}
			if(uUser.getLastLoginTime() != null){
				sql.append(" AND _this.`last_login_time` = ?");
				param.add(uUser.getLastLoginTime());
			}
			if(uUser.getLoginErrorCount() != null){
				sql.append(" AND _this.`login_error_count` = ?");
				param.add(uUser.getLoginErrorCount());
			}
			if(uUser.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ?");
				param.add(uUser.getCreateTime());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UUser.class));
	}


	/**
	 * 根据对象查询条数
	 * @param uUser
	 * @return Long
	 */
	@Override
	public Long count(UUser uUser){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM u_user  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(uUser != null){
			if(uUser.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(uUser.getId());
			}
			if(uUser.getUserName() != null && !"".equals(uUser.getUserName())){
				sql.append(" AND _this.`user_name` = ? ");
				param.add(uUser.getUserName());
			}
			if(uUser.getPassword() != null && !"".equals(uUser.getPassword())){
				sql.append(" AND _this.`password` = ? ");
				param.add(uUser.getPassword());
			}
			if(uUser.getIsExpired() != null){
				sql.append(" AND _this.`is_expired` = ? ");
				param.add(uUser.getIsExpired());
			}
			if(uUser.getIsLocked() != null){
				sql.append(" AND _this.`is_locked` = ? ");
				param.add(uUser.getIsLocked());
			}
			if(uUser.getIsEnable() != null){
				sql.append(" AND _this.`is_enable` = ? ");
				param.add(uUser.getIsEnable());
			}
			if(uUser.getMobile() != null && !"".equals(uUser.getMobile())){
				sql.append(" AND _this.`mobile` = ? ");
				param.add(uUser.getMobile());
			}
			if(uUser.getFullname() != null && !"".equals(uUser.getFullname())){
				sql.append(" AND _this.`fullname` = ? ");
				param.add(uUser.getFullname());
			}
			if(uUser.getLastLoginTime() != null){
				sql.append(" AND _this.`last_login_time` = ? ");
				param.add(uUser.getLastLoginTime());
			}
			if(uUser.getLoginErrorCount() != null){
				sql.append(" AND _this.`login_error_count` = ? ");
				param.add(uUser.getLoginErrorCount());
			}
			if(uUser.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ? ");
				param.add(uUser.getCreateTime());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}