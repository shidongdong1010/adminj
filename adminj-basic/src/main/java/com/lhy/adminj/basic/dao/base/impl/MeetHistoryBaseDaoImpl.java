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

import com.lhy.adminj.basic.dao.base.MeetHistoryBaseDao;
import com.lhy.adminj.basic.model.MeetHistory;

/**
 * 相遇历史记录表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MeetHistoryBaseDaoImpl implements MeetHistoryBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`meet_his_id`, _this.`user_id`, _this.`meet_user_id`, _this.`meet_city_code`, _this.`meet_data`, _this.`say`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`meet_his_id`, _this.`user_id`, _this.`meet_user_id`, _this.`meet_city_code`, _this.`meet_data`, _this.`say` FROM umc_meet_history _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_meet_history(`meet_his_id`, `user_id`, `meet_user_id`, `meet_city_code`, `meet_data`, `say`) VALUES (:meet_his_id, :user_id, :meet_user_id, :meet_city_code, :meet_data, :say)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_meet_history SET `meet_his_id` = :meet_his_id, `user_id` = :user_id, `meet_user_id` = :meet_user_id, `meet_city_code` = :meet_city_code, `meet_data` = :meet_data, `say` = :say WHERE `meet_his_id` = :meet_his_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_meet_history WHERE `meet_his_id` = ?";

	@Override
	public void save(MeetHistory meetHistory) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(meetHistory);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		meetHistory.setMeetHisId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(MeetHistory meetHistory) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(meetHistory);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(MeetHistory meetHistory) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_meet_history SET ");
		if(meetHistory.getMeetHisId() != null){
			sql.append(" meet_his_id = ?, ");
			param.add(meetHistory.getMeetHisId());
		}
		if(meetHistory.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(meetHistory.getUserId());
		}
		if(meetHistory.getMeetUserId() != null){
			sql.append(" meet_user_id = ?, ");
			param.add(meetHistory.getMeetUserId());
		}
		if(meetHistory.getMeetCityCode() != null){
			sql.append(" meet_city_code = ?, ");
			param.add(meetHistory.getMeetCityCode());
		}
		if(meetHistory.getMeetData() != null){
			sql.append(" meet_data = ?, ");
			param.add(meetHistory.getMeetData());
		}
		if(meetHistory.getSay() != null){
			sql.append(" say = ? ");
			param.add(meetHistory.getSay());
		}
		sql.append(" WHERE meet_his_id = ? ");
		param.add(meetHistory.getMeetHisId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param meetHistorys
	 * @return
	 */
	public Map<String, Object>[] toMap(List<MeetHistory> meetHistorys){
		Map<String, Object>[] maps = new Map[meetHistorys.size()];
		for(int i = 0; i < meetHistorys.size(); i++){
			MeetHistory meetHistory = meetHistorys.get(i);
			maps[i] = toMap(meetHistory);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param meetHistory
	 * @return
	 */
	public Map<String, Object> toMap(MeetHistory meetHistory){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("meet_his_id", meetHistory.getMeetHisId());
        paramMap.put("user_id", meetHistory.getUserId());
        paramMap.put("meet_user_id", meetHistory.getMeetUserId());
        paramMap.put("meet_city_code", meetHistory.getMeetCityCode());
        paramMap.put("meet_data", meetHistory.getMeetData());
        paramMap.put("say", meetHistory.getSay());
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
	public void delete(Long meetHisId){
		jdbcTemplate.update(DELETE_SQL, meetHisId);
	}

	@Override
	public void batchSave(List<MeetHistory> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<MeetHistory> list){
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
	 * @param meetHisId 相遇历史记录ID
	 * @return MeetHistory
	 */
	@Override
	public MeetHistory findById(Long meetHisId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`meet_his_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(MeetHistory.class), meetHisId);
	}

	/**
	 * 根据对象查询
	 * @param meetHistory
	 * @return List
	 */
	@Override
	public List<MeetHistory> find(MeetHistory meetHistory){
		return this.find(meetHistory, null, null);
	}

	/**
	 * 根据对象查询
	 * @param meetHistory
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<MeetHistory> find(MeetHistory meetHistory, String[][] orders){
		return this.find(meetHistory, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param meetHistory
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MeetHistory> find(MeetHistory meetHistory, Long offset, Long rows){
		return this.find(meetHistory, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param meetHistory
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MeetHistory> find(MeetHistory meetHistory, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(meetHistory != null){
			if(meetHistory.getMeetHisId() != null){
				sql.append(" AND _this.`meet_his_id` = ?");
				param.add(meetHistory.getMeetHisId());
			}
			if(meetHistory.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(meetHistory.getUserId());
			}
			if(meetHistory.getMeetUserId() != null){
				sql.append(" AND _this.`meet_user_id` = ?");
				param.add(meetHistory.getMeetUserId());
			}
			if(meetHistory.getMeetCityCode() != null && !"".equals(meetHistory.getMeetCityCode())){
				sql.append(" AND _this.`meet_city_code` = ?");
				param.add(meetHistory.getMeetCityCode());
			}
			if(meetHistory.getMeetData() != null){
				sql.append(" AND _this.`meet_data` = ?");
				param.add(meetHistory.getMeetData());
			}
			if(meetHistory.getSay() != null && !"".equals(meetHistory.getSay())){
				sql.append(" AND _this.`say` = ?");
				param.add(meetHistory.getSay());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(MeetHistory.class));
	}


	/**
	 * 根据对象查询条数
	 * @param meetHistory
	 * @return Long
	 */
	@Override
	public Long count(MeetHistory meetHistory){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_meet_history  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(meetHistory != null){
			if(meetHistory.getMeetHisId() != null){
				sql.append(" AND _this.`meet_his_id` = ? ");
				param.add(meetHistory.getMeetHisId());
			}
			if(meetHistory.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(meetHistory.getUserId());
			}
			if(meetHistory.getMeetUserId() != null){
				sql.append(" AND _this.`meet_user_id` = ? ");
				param.add(meetHistory.getMeetUserId());
			}
			if(meetHistory.getMeetCityCode() != null && !"".equals(meetHistory.getMeetCityCode())){
				sql.append(" AND _this.`meet_city_code` = ? ");
				param.add(meetHistory.getMeetCityCode());
			}
			if(meetHistory.getMeetData() != null){
				sql.append(" AND _this.`meet_data` = ? ");
				param.add(meetHistory.getMeetData());
			}
			if(meetHistory.getSay() != null && !"".equals(meetHistory.getSay())){
				sql.append(" AND _this.`say` = ? ");
				param.add(meetHistory.getSay());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}