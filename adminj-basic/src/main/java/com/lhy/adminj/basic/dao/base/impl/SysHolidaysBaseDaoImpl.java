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

import com.lhy.adminj.basic.dao.base.SysHolidaysBaseDao;
import com.lhy.adminj.basic.model.SysHolidays;

/**
 * 节假日表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class SysHolidaysBaseDaoImpl implements SysHolidaysBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`holidays_id`, _this.`year`, _this.`holidays`, _this.`create_date`, _this.`update_date`, _this.`is_valid`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`holidays_id`, _this.`year`, _this.`holidays`, _this.`create_date`, _this.`update_date`, _this.`is_valid` FROM sys_holidays _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO sys_holidays(`holidays_id`, `year`, `holidays`, `create_date`, `update_date`, `is_valid`) VALUES (:holidays_id, :year, :holidays, :create_date, :update_date, :is_valid)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE sys_holidays SET `holidays_id` = :holidays_id, `year` = :year, `holidays` = :holidays, `create_date` = :create_date, `update_date` = :update_date, `is_valid` = :is_valid WHERE `holidays_id` = :holidays_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM sys_holidays WHERE `holidays_id` = ?";

	@Override
	public void save(SysHolidays sysHolidays) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(sysHolidays);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		sysHolidays.setHolidaysId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(SysHolidays sysHolidays) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(sysHolidays);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(SysHolidays sysHolidays) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE sys_holidays SET ");
		if(sysHolidays.getHolidaysId() != null){
			sql.append(" holidays_id = ?, ");
			param.add(sysHolidays.getHolidaysId());
		}
		if(sysHolidays.getYear() != null){
			sql.append(" year = ?, ");
			param.add(sysHolidays.getYear());
		}
		if(sysHolidays.getHolidays() != null){
			sql.append(" holidays = ?, ");
			param.add(sysHolidays.getHolidays());
		}
		if(sysHolidays.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(sysHolidays.getCreateDate());
		}
		if(sysHolidays.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(sysHolidays.getUpdateDate());
		}
		if(sysHolidays.getIsValid() != null){
			sql.append(" is_valid = ? ");
			param.add(sysHolidays.getIsValid());
		}
		sql.append(" WHERE holidays_id = ? ");
		param.add(sysHolidays.getHolidaysId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param sysHolidayss
	 * @return
	 */
	public Map<String, Object>[] toMap(List<SysHolidays> sysHolidayss){
		Map<String, Object>[] maps = new Map[sysHolidayss.size()];
		for(int i = 0; i < sysHolidayss.size(); i++){
			SysHolidays sysHolidays = sysHolidayss.get(i);
			maps[i] = toMap(sysHolidays);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param sysHolidays
	 * @return
	 */
	public Map<String, Object> toMap(SysHolidays sysHolidays){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("holidays_id", sysHolidays.getHolidaysId());
        paramMap.put("year", sysHolidays.getYear());
        paramMap.put("holidays", sysHolidays.getHolidays());
        paramMap.put("create_date", sysHolidays.getCreateDate());
        paramMap.put("update_date", sysHolidays.getUpdateDate());
        paramMap.put("is_valid", sysHolidays.getIsValid());
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
	public void delete(Long holidaysId){
		jdbcTemplate.update(DELETE_SQL, holidaysId);
	}

	@Override
	public void batchSave(List<SysHolidays> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<SysHolidays> list){
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
	 * @param holidaysId 节假日ID
	 * @return SysHolidays
	 */
	@Override
	public SysHolidays findById(Long holidaysId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`holidays_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(SysHolidays.class), holidaysId);
	}

	/**
	 * 根据对象查询
	 * @param sysHolidays
	 * @return List
	 */
	@Override
	public List<SysHolidays> find(SysHolidays sysHolidays){
		return this.find(sysHolidays, null, null);
	}

	/**
	 * 根据对象查询
	 * @param sysHolidays
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<SysHolidays> find(SysHolidays sysHolidays, String[][] orders){
		return this.find(sysHolidays, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param sysHolidays
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<SysHolidays> find(SysHolidays sysHolidays, Long offset, Long rows){
		return this.find(sysHolidays, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param sysHolidays
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<SysHolidays> find(SysHolidays sysHolidays, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(sysHolidays != null){
			if(sysHolidays.getHolidaysId() != null){
				sql.append(" AND _this.`holidays_id` = ?");
				param.add(sysHolidays.getHolidaysId());
			}
			if(sysHolidays.getYear() != null){
				sql.append(" AND _this.`year` = ?");
				param.add(sysHolidays.getYear());
			}
			if(sysHolidays.getHolidays() != null){
				sql.append(" AND _this.`holidays` = ?");
				param.add(sysHolidays.getHolidays());
			}
			if(sysHolidays.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(sysHolidays.getCreateDate());
			}
			if(sysHolidays.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(sysHolidays.getUpdateDate());
			}
			if(sysHolidays.getIsValid() != null && !"".equals(sysHolidays.getIsValid())){
				sql.append(" AND _this.`is_valid` = ?");
				param.add(sysHolidays.getIsValid());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(SysHolidays.class));
	}


	/**
	 * 根据对象查询条数
	 * @param sysHolidays
	 * @return Long
	 */
	@Override
	public Long count(SysHolidays sysHolidays){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM sys_holidays  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(sysHolidays != null){
			if(sysHolidays.getHolidaysId() != null){
				sql.append(" AND _this.`holidays_id` = ? ");
				param.add(sysHolidays.getHolidaysId());
			}
			if(sysHolidays.getYear() != null){
				sql.append(" AND _this.`year` = ? ");
				param.add(sysHolidays.getYear());
			}
			if(sysHolidays.getHolidays() != null){
				sql.append(" AND _this.`holidays` = ? ");
				param.add(sysHolidays.getHolidays());
			}
			if(sysHolidays.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(sysHolidays.getCreateDate());
			}
			if(sysHolidays.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(sysHolidays.getUpdateDate());
			}
			if(sysHolidays.getIsValid() != null && !"".equals(sysHolidays.getIsValid())){
				sql.append(" AND _this.`is_valid` = ? ");
				param.add(sysHolidays.getIsValid());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}