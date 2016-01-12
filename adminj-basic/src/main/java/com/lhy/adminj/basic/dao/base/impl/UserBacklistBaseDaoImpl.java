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

import com.lhy.adminj.basic.dao.base.UserBacklistBaseDao;
import com.lhy.adminj.basic.model.UserBacklist;

/**
 * 用户黑名单表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserBacklistBaseDaoImpl implements UserBacklistBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`user_id`, _this.`reply_blacklist`, _this.`talk_blacklist`, _this.`show_blacklist`, _this.`create_date`, _this.`update_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`user_id`, _this.`reply_blacklist`, _this.`talk_blacklist`, _this.`show_blacklist`, _this.`create_date`, _this.`update_date` FROM umc_user_backlist _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_backlist(`user_id`, `reply_blacklist`, `talk_blacklist`, `show_blacklist`, `create_date`, `update_date`) VALUES (:user_id, :reply_blacklist, :talk_blacklist, :show_blacklist, :create_date, :update_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_backlist SET `user_id` = :user_id, `reply_blacklist` = :reply_blacklist, `talk_blacklist` = :talk_blacklist, `show_blacklist` = :show_blacklist, `create_date` = :create_date, `update_date` = :update_date WHERE `user_id` = :user_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_backlist WHERE `user_id` = ?";

	@Override
	public void save(UserBacklist userBacklist) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userBacklist);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userBacklist.setUserId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserBacklist userBacklist) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userBacklist);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserBacklist userBacklist) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_backlist SET ");
		if(userBacklist.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userBacklist.getUserId());
		}
		if(userBacklist.getReplyBlacklist() != null){
			sql.append(" reply_blacklist = ?, ");
			param.add(userBacklist.getReplyBlacklist());
		}
		if(userBacklist.getTalkBlacklist() != null){
			sql.append(" talk_blacklist = ?, ");
			param.add(userBacklist.getTalkBlacklist());
		}
		if(userBacklist.getShowBlacklist() != null){
			sql.append(" show_blacklist = ?, ");
			param.add(userBacklist.getShowBlacklist());
		}
		if(userBacklist.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userBacklist.getCreateDate());
		}
		if(userBacklist.getUpdateDate() != null){
			sql.append(" update_date = ? ");
			param.add(userBacklist.getUpdateDate());
		}
		sql.append(" WHERE user_id = ? ");
		param.add(userBacklist.getUserId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userBacklists
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserBacklist> userBacklists){
		Map<String, Object>[] maps = new Map[userBacklists.size()];
		for(int i = 0; i < userBacklists.size(); i++){
			UserBacklist userBacklist = userBacklists.get(i);
			maps[i] = toMap(userBacklist);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userBacklist
	 * @return
	 */
	public Map<String, Object> toMap(UserBacklist userBacklist){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user_id", userBacklist.getUserId());
        paramMap.put("reply_blacklist", userBacklist.getReplyBlacklist());
        paramMap.put("talk_blacklist", userBacklist.getTalkBlacklist());
        paramMap.put("show_blacklist", userBacklist.getShowBlacklist());
        paramMap.put("create_date", userBacklist.getCreateDate());
        paramMap.put("update_date", userBacklist.getUpdateDate());
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
	public void delete(Long userId){
		jdbcTemplate.update(DELETE_SQL, userId);
	}

	@Override
	public void batchSave(List<UserBacklist> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserBacklist> list){
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
	 * @param userId 用户ID,自增序列
	 * @return UserBacklist
	 */
	@Override
	public UserBacklist findById(Long userId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`user_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserBacklist.class), userId);
	}

	/**
	 * 根据对象查询
	 * @param userBacklist
	 * @return List
	 */
	@Override
	public List<UserBacklist> find(UserBacklist userBacklist){
		return this.find(userBacklist, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userBacklist
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserBacklist> find(UserBacklist userBacklist, String[][] orders){
		return this.find(userBacklist, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userBacklist
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserBacklist> find(UserBacklist userBacklist, Long offset, Long rows){
		return this.find(userBacklist, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userBacklist
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserBacklist> find(UserBacklist userBacklist, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userBacklist != null){
			if(userBacklist.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userBacklist.getUserId());
			}
			if(userBacklist.getReplyBlacklist() != null && !"".equals(userBacklist.getReplyBlacklist())){
				sql.append(" AND _this.`reply_blacklist` = ?");
				param.add(userBacklist.getReplyBlacklist());
			}
			if(userBacklist.getTalkBlacklist() != null && !"".equals(userBacklist.getTalkBlacklist())){
				sql.append(" AND _this.`talk_blacklist` = ?");
				param.add(userBacklist.getTalkBlacklist());
			}
			if(userBacklist.getShowBlacklist() != null && !"".equals(userBacklist.getShowBlacklist())){
				sql.append(" AND _this.`show_blacklist` = ?");
				param.add(userBacklist.getShowBlacklist());
			}
			if(userBacklist.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userBacklist.getCreateDate());
			}
			if(userBacklist.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userBacklist.getUpdateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserBacklist.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userBacklist
	 * @return Long
	 */
	@Override
	public Long count(UserBacklist userBacklist){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_backlist  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userBacklist != null){
			if(userBacklist.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userBacklist.getUserId());
			}
			if(userBacklist.getReplyBlacklist() != null && !"".equals(userBacklist.getReplyBlacklist())){
				sql.append(" AND _this.`reply_blacklist` = ? ");
				param.add(userBacklist.getReplyBlacklist());
			}
			if(userBacklist.getTalkBlacklist() != null && !"".equals(userBacklist.getTalkBlacklist())){
				sql.append(" AND _this.`talk_blacklist` = ? ");
				param.add(userBacklist.getTalkBlacklist());
			}
			if(userBacklist.getShowBlacklist() != null && !"".equals(userBacklist.getShowBlacklist())){
				sql.append(" AND _this.`show_blacklist` = ? ");
				param.add(userBacklist.getShowBlacklist());
			}
			if(userBacklist.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userBacklist.getCreateDate());
			}
			if(userBacklist.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userBacklist.getUpdateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}