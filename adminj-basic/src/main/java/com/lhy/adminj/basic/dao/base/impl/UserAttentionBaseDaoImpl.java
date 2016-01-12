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

import com.lhy.adminj.basic.dao.base.UserAttentionBaseDao;
import com.lhy.adminj.basic.model.UserAttention;

/**
 * 用户关注表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserAttentionBaseDaoImpl implements UserAttentionBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`attention_id`, _this.`user_id`, _this.`attention_user_id`, _this.`craete_date`, _this.`update_date`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`attention_id`, _this.`user_id`, _this.`attention_user_id`, _this.`craete_date`, _this.`update_date`, _this.`is_del` FROM umc_user_attention _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_attention(`attention_id`, `user_id`, `attention_user_id`, `craete_date`, `update_date`, `is_del`) VALUES (:attention_id, :user_id, :attention_user_id, :craete_date, :update_date, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_attention SET `attention_id` = :attention_id, `user_id` = :user_id, `attention_user_id` = :attention_user_id, `craete_date` = :craete_date, `update_date` = :update_date, `is_del` = :is_del WHERE `attention_id` = :attention_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_attention WHERE `attention_id` = ?";

	@Override
	public void save(UserAttention userAttention) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userAttention);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userAttention.setAttentionId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserAttention userAttention) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userAttention);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserAttention userAttention) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_attention SET ");
		if(userAttention.getAttentionId() != null){
			sql.append(" attention_id = ?, ");
			param.add(userAttention.getAttentionId());
		}
		if(userAttention.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userAttention.getUserId());
		}
		if(userAttention.getAttentionUserId() != null){
			sql.append(" attention_user_id = ?, ");
			param.add(userAttention.getAttentionUserId());
		}
		if(userAttention.getCraeteDate() != null){
			sql.append(" craete_date = ?, ");
			param.add(userAttention.getCraeteDate());
		}
		if(userAttention.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userAttention.getUpdateDate());
		}
		if(userAttention.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(userAttention.getIsDel());
		}
		sql.append(" WHERE attention_id = ? ");
		param.add(userAttention.getAttentionId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userAttentions
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserAttention> userAttentions){
		Map<String, Object>[] maps = new Map[userAttentions.size()];
		for(int i = 0; i < userAttentions.size(); i++){
			UserAttention userAttention = userAttentions.get(i);
			maps[i] = toMap(userAttention);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userAttention
	 * @return
	 */
	public Map<String, Object> toMap(UserAttention userAttention){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("attention_id", userAttention.getAttentionId());
        paramMap.put("user_id", userAttention.getUserId());
        paramMap.put("attention_user_id", userAttention.getAttentionUserId());
        paramMap.put("craete_date", userAttention.getCraeteDate());
        paramMap.put("update_date", userAttention.getUpdateDate());
        paramMap.put("is_del", userAttention.getIsDel());
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
	public void delete(Long attentionId){
		jdbcTemplate.update(DELETE_SQL, attentionId);
	}

	@Override
	public void batchSave(List<UserAttention> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserAttention> list){
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
	 * @param attentionId 关注ID
	 * @return UserAttention
	 */
	@Override
	public UserAttention findById(Long attentionId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`attention_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserAttention.class), attentionId);
	}

	/**
	 * 根据对象查询
	 * @param userAttention
	 * @return List
	 */
	@Override
	public List<UserAttention> find(UserAttention userAttention){
		return this.find(userAttention, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userAttention
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserAttention> find(UserAttention userAttention, String[][] orders){
		return this.find(userAttention, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userAttention
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserAttention> find(UserAttention userAttention, Long offset, Long rows){
		return this.find(userAttention, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userAttention
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserAttention> find(UserAttention userAttention, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userAttention != null){
			if(userAttention.getAttentionId() != null){
				sql.append(" AND _this.`attention_id` = ?");
				param.add(userAttention.getAttentionId());
			}
			if(userAttention.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userAttention.getUserId());
			}
			if(userAttention.getAttentionUserId() != null){
				sql.append(" AND _this.`attention_user_id` = ?");
				param.add(userAttention.getAttentionUserId());
			}
			if(userAttention.getCraeteDate() != null){
				sql.append(" AND _this.`craete_date` = ?");
				param.add(userAttention.getCraeteDate());
			}
			if(userAttention.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userAttention.getUpdateDate());
			}
			if(userAttention.getIsDel() != null && !"".equals(userAttention.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(userAttention.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserAttention.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userAttention
	 * @return Long
	 */
	@Override
	public Long count(UserAttention userAttention){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_attention  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userAttention != null){
			if(userAttention.getAttentionId() != null){
				sql.append(" AND _this.`attention_id` = ? ");
				param.add(userAttention.getAttentionId());
			}
			if(userAttention.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userAttention.getUserId());
			}
			if(userAttention.getAttentionUserId() != null){
				sql.append(" AND _this.`attention_user_id` = ? ");
				param.add(userAttention.getAttentionUserId());
			}
			if(userAttention.getCraeteDate() != null){
				sql.append(" AND _this.`craete_date` = ? ");
				param.add(userAttention.getCraeteDate());
			}
			if(userAttention.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userAttention.getUpdateDate());
			}
			if(userAttention.getIsDel() != null && !"".equals(userAttention.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(userAttention.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}