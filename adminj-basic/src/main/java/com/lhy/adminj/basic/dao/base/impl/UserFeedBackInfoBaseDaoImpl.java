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

import com.lhy.adminj.basic.dao.base.UserFeedBackInfoBaseDao;
import com.lhy.adminj.basic.model.UserFeedBackInfo;

/**
 * 意见反馈信息表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserFeedBackInfoBaseDaoImpl implements UserFeedBackInfoBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`feedback_id`, _this.`user_id`, _this.`contect`, _this.`create_time`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`feedback_id`, _this.`user_id`, _this.`contect`, _this.`create_time` FROM umc_user_feed_back_info _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_feed_back_info(`feedback_id`, `user_id`, `contect`, `create_time`) VALUES (:feedback_id, :user_id, :contect, :create_time)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_feed_back_info SET `feedback_id` = :feedback_id, `user_id` = :user_id, `contect` = :contect, `create_time` = :create_time WHERE `feedback_id` = :feedback_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_feed_back_info WHERE `feedback_id` = ?";

	@Override
	public void save(UserFeedBackInfo userFeedBackInfo) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userFeedBackInfo);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userFeedBackInfo.setFeedbackId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserFeedBackInfo userFeedBackInfo) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userFeedBackInfo);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserFeedBackInfo userFeedBackInfo) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_feed_back_info SET ");
		if(userFeedBackInfo.getFeedbackId() != null){
			sql.append(" feedback_id = ?, ");
			param.add(userFeedBackInfo.getFeedbackId());
		}
		if(userFeedBackInfo.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userFeedBackInfo.getUserId());
		}
		if(userFeedBackInfo.getContect() != null){
			sql.append(" contect = ?, ");
			param.add(userFeedBackInfo.getContect());
		}
		if(userFeedBackInfo.getCreateTime() != null){
			sql.append(" create_time = ? ");
			param.add(userFeedBackInfo.getCreateTime());
		}
		sql.append(" WHERE feedback_id = ? ");
		param.add(userFeedBackInfo.getFeedbackId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userFeedBackInfos
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserFeedBackInfo> userFeedBackInfos){
		Map<String, Object>[] maps = new Map[userFeedBackInfos.size()];
		for(int i = 0; i < userFeedBackInfos.size(); i++){
			UserFeedBackInfo userFeedBackInfo = userFeedBackInfos.get(i);
			maps[i] = toMap(userFeedBackInfo);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userFeedBackInfo
	 * @return
	 */
	public Map<String, Object> toMap(UserFeedBackInfo userFeedBackInfo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("feedback_id", userFeedBackInfo.getFeedbackId());
        paramMap.put("user_id", userFeedBackInfo.getUserId());
        paramMap.put("contect", userFeedBackInfo.getContect());
        paramMap.put("create_time", userFeedBackInfo.getCreateTime());
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
	public void delete(Long feedbackId){
		jdbcTemplate.update(DELETE_SQL, feedbackId);
	}

	@Override
	public void batchSave(List<UserFeedBackInfo> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserFeedBackInfo> list){
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
	 * @param feedbackId 意见反馈信息ID
	 * @return UserFeedBackInfo
	 */
	@Override
	public UserFeedBackInfo findById(Long feedbackId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`feedback_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserFeedBackInfo.class), feedbackId);
	}

	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
	 * @return List
	 */
	@Override
	public List<UserFeedBackInfo> find(UserFeedBackInfo userFeedBackInfo){
		return this.find(userFeedBackInfo, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserFeedBackInfo> find(UserFeedBackInfo userFeedBackInfo, String[][] orders){
		return this.find(userFeedBackInfo, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserFeedBackInfo> find(UserFeedBackInfo userFeedBackInfo, Long offset, Long rows){
		return this.find(userFeedBackInfo, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserFeedBackInfo> find(UserFeedBackInfo userFeedBackInfo, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userFeedBackInfo != null){
			if(userFeedBackInfo.getFeedbackId() != null){
				sql.append(" AND _this.`feedback_id` = ?");
				param.add(userFeedBackInfo.getFeedbackId());
			}
			if(userFeedBackInfo.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userFeedBackInfo.getUserId());
			}
			if(userFeedBackInfo.getContect() != null && !"".equals(userFeedBackInfo.getContect())){
				sql.append(" AND _this.`contect` = ?");
				param.add(userFeedBackInfo.getContect());
			}
			if(userFeedBackInfo.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ?");
				param.add(userFeedBackInfo.getCreateTime());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserFeedBackInfo.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userFeedBackInfo
	 * @return Long
	 */
	@Override
	public Long count(UserFeedBackInfo userFeedBackInfo){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_feed_back_info  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userFeedBackInfo != null){
			if(userFeedBackInfo.getFeedbackId() != null){
				sql.append(" AND _this.`feedback_id` = ? ");
				param.add(userFeedBackInfo.getFeedbackId());
			}
			if(userFeedBackInfo.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userFeedBackInfo.getUserId());
			}
			if(userFeedBackInfo.getContect() != null && !"".equals(userFeedBackInfo.getContect())){
				sql.append(" AND _this.`contect` = ? ");
				param.add(userFeedBackInfo.getContect());
			}
			if(userFeedBackInfo.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ? ");
				param.add(userFeedBackInfo.getCreateTime());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}