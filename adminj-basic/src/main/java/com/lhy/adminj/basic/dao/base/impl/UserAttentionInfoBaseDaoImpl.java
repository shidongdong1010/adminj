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

import com.lhy.adminj.basic.dao.base.UserAttentionInfoBaseDao;
import com.lhy.adminj.basic.model.UserAttentionInfo;

/**
 * 用户关注表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserAttentionInfoBaseDaoImpl implements UserAttentionInfoBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`attention_id`, _this.`user_id`, _this.`attention_user_id`, _this.`create_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`attention_id`, _this.`user_id`, _this.`attention_user_id`, _this.`create_date` FROM udc_user_attention_info _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO udc_user_attention_info(`attention_id`, `user_id`, `attention_user_id`, `create_date`) VALUES (:attention_id, :user_id, :attention_user_id, :create_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE udc_user_attention_info SET `attention_id` = :attention_id, `user_id` = :user_id, `attention_user_id` = :attention_user_id, `create_date` = :create_date WHERE `attention_id` = :attention_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM udc_user_attention_info WHERE `attention_id` = ?";

	@Override
	public void save(UserAttentionInfo userAttentionInfo) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userAttentionInfo);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userAttentionInfo.setAttentionId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserAttentionInfo userAttentionInfo) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userAttentionInfo);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserAttentionInfo userAttentionInfo) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE udc_user_attention_info SET ");
		if(userAttentionInfo.getAttentionId() != null){
			sql.append(" attention_id = ?, ");
			param.add(userAttentionInfo.getAttentionId());
		}
		if(userAttentionInfo.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userAttentionInfo.getUserId());
		}
		if(userAttentionInfo.getAttentionUserId() != null){
			sql.append(" attention_user_id = ?, ");
			param.add(userAttentionInfo.getAttentionUserId());
		}
		if(userAttentionInfo.getCreateDate() != null){
			sql.append(" create_date = ? ");
			param.add(userAttentionInfo.getCreateDate());
		}
		sql.append(" WHERE attention_id = ? ");
		param.add(userAttentionInfo.getAttentionId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userAttentionInfos
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserAttentionInfo> userAttentionInfos){
		Map<String, Object>[] maps = new Map[userAttentionInfos.size()];
		for(int i = 0; i < userAttentionInfos.size(); i++){
			UserAttentionInfo userAttentionInfo = userAttentionInfos.get(i);
			maps[i] = toMap(userAttentionInfo);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userAttentionInfo
	 * @return
	 */
	public Map<String, Object> toMap(UserAttentionInfo userAttentionInfo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("attention_id", userAttentionInfo.getAttentionId());
        paramMap.put("user_id", userAttentionInfo.getUserId());
        paramMap.put("attention_user_id", userAttentionInfo.getAttentionUserId());
        paramMap.put("create_date", userAttentionInfo.getCreateDate());
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
	public void batchSave(List<UserAttentionInfo> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserAttentionInfo> list){
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
	 * @return UserAttentionInfo
	 */
	@Override
	public UserAttentionInfo findById(Long attentionId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`attention_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserAttentionInfo.class), attentionId);
	}

	/**
	 * 根据对象查询
	 * @param userAttentionInfo
	 * @return List
	 */
	@Override
	public List<UserAttentionInfo> find(UserAttentionInfo userAttentionInfo){
		return this.find(userAttentionInfo, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userAttentionInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserAttentionInfo> find(UserAttentionInfo userAttentionInfo, String[][] orders){
		return this.find(userAttentionInfo, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userAttentionInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserAttentionInfo> find(UserAttentionInfo userAttentionInfo, Long offset, Long rows){
		return this.find(userAttentionInfo, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userAttentionInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserAttentionInfo> find(UserAttentionInfo userAttentionInfo, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userAttentionInfo != null){
			if(userAttentionInfo.getAttentionId() != null){
				sql.append(" AND _this.`attention_id` = ?");
				param.add(userAttentionInfo.getAttentionId());
			}
			if(userAttentionInfo.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userAttentionInfo.getUserId());
			}
			if(userAttentionInfo.getAttentionUserId() != null){
				sql.append(" AND _this.`attention_user_id` = ?");
				param.add(userAttentionInfo.getAttentionUserId());
			}
			if(userAttentionInfo.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userAttentionInfo.getCreateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserAttentionInfo.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userAttentionInfo
	 * @return Long
	 */
	@Override
	public Long count(UserAttentionInfo userAttentionInfo){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM udc_user_attention_info  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userAttentionInfo != null){
			if(userAttentionInfo.getAttentionId() != null){
				sql.append(" AND _this.`attention_id` = ? ");
				param.add(userAttentionInfo.getAttentionId());
			}
			if(userAttentionInfo.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userAttentionInfo.getUserId());
			}
			if(userAttentionInfo.getAttentionUserId() != null){
				sql.append(" AND _this.`attention_user_id` = ? ");
				param.add(userAttentionInfo.getAttentionUserId());
			}
			if(userAttentionInfo.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userAttentionInfo.getCreateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}