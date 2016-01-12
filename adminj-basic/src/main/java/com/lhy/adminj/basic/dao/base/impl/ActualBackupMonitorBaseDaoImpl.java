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

import com.lhy.adminj.basic.dao.base.ActualBackupMonitorBaseDao;
import com.lhy.adminj.basic.model.ActualBackupMonitor;

/**
 * 时段数据备份Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class ActualBackupMonitorBaseDaoImpl implements ActualBackupMonitorBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`backup_id`, _this.`backup_time`, _this.`backup_type`, _this.`nine_half_status`, _this.`ten_half_status`, _this.`eleven_half_status`, _this.`fourteen_status`, _this.`fifteen_status`, _this.`create_date`, _this.`update_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`backup_id`, _this.`backup_time`, _this.`backup_type`, _this.`nine_half_status`, _this.`ten_half_status`, _this.`eleven_half_status`, _this.`fourteen_status`, _this.`fifteen_status`, _this.`create_date`, _this.`update_date` FROM smc_actual_backup_monitor _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO smc_actual_backup_monitor(`backup_id`, `backup_time`, `backup_type`, `nine_half_status`, `ten_half_status`, `eleven_half_status`, `fourteen_status`, `fifteen_status`, `create_date`, `update_date`) VALUES (:backup_id, :backup_time, :backup_type, :nine_half_status, :ten_half_status, :eleven_half_status, :fourteen_status, :fifteen_status, :create_date, :update_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE smc_actual_backup_monitor SET `backup_id` = :backup_id, `backup_time` = :backup_time, `backup_type` = :backup_type, `nine_half_status` = :nine_half_status, `ten_half_status` = :ten_half_status, `eleven_half_status` = :eleven_half_status, `fourteen_status` = :fourteen_status, `fifteen_status` = :fifteen_status, `create_date` = :create_date, `update_date` = :update_date WHERE `backup_id` = :backup_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM smc_actual_backup_monitor WHERE `backup_id` = ?";

	@Override
	public void save(ActualBackupMonitor actualBackupMonitor) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(actualBackupMonitor);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		actualBackupMonitor.setBackupId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(ActualBackupMonitor actualBackupMonitor) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(actualBackupMonitor);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(ActualBackupMonitor actualBackupMonitor) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE smc_actual_backup_monitor SET ");
		if(actualBackupMonitor.getBackupId() != null){
			sql.append(" backup_id = ?, ");
			param.add(actualBackupMonitor.getBackupId());
		}
		if(actualBackupMonitor.getBackupTime() != null){
			sql.append(" backup_time = ?, ");
			param.add(actualBackupMonitor.getBackupTime());
		}
		if(actualBackupMonitor.getBackupType() != null){
			sql.append(" backup_type = ?, ");
			param.add(actualBackupMonitor.getBackupType());
		}
		if(actualBackupMonitor.getNineHalfStatus() != null){
			sql.append(" nine_half_status = ?, ");
			param.add(actualBackupMonitor.getNineHalfStatus());
		}
		if(actualBackupMonitor.getTenHalfStatus() != null){
			sql.append(" ten_half_status = ?, ");
			param.add(actualBackupMonitor.getTenHalfStatus());
		}
		if(actualBackupMonitor.getElevenHalfStatus() != null){
			sql.append(" eleven_half_status = ?, ");
			param.add(actualBackupMonitor.getElevenHalfStatus());
		}
		if(actualBackupMonitor.getFourteenStatus() != null){
			sql.append(" fourteen_status = ?, ");
			param.add(actualBackupMonitor.getFourteenStatus());
		}
		if(actualBackupMonitor.getFifteenStatus() != null){
			sql.append(" fifteen_status = ?, ");
			param.add(actualBackupMonitor.getFifteenStatus());
		}
		if(actualBackupMonitor.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(actualBackupMonitor.getCreateDate());
		}
		if(actualBackupMonitor.getUpdateDate() != null){
			sql.append(" update_date = ? ");
			param.add(actualBackupMonitor.getUpdateDate());
		}
		sql.append(" WHERE backup_id = ? ");
		param.add(actualBackupMonitor.getBackupId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param actualBackupMonitors
	 * @return
	 */
	public Map<String, Object>[] toMap(List<ActualBackupMonitor> actualBackupMonitors){
		Map<String, Object>[] maps = new Map[actualBackupMonitors.size()];
		for(int i = 0; i < actualBackupMonitors.size(); i++){
			ActualBackupMonitor actualBackupMonitor = actualBackupMonitors.get(i);
			maps[i] = toMap(actualBackupMonitor);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param actualBackupMonitor
	 * @return
	 */
	public Map<String, Object> toMap(ActualBackupMonitor actualBackupMonitor){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("backup_id", actualBackupMonitor.getBackupId());
        paramMap.put("backup_time", actualBackupMonitor.getBackupTime());
        paramMap.put("backup_type", actualBackupMonitor.getBackupType());
        paramMap.put("nine_half_status", actualBackupMonitor.getNineHalfStatus());
        paramMap.put("ten_half_status", actualBackupMonitor.getTenHalfStatus());
        paramMap.put("eleven_half_status", actualBackupMonitor.getElevenHalfStatus());
        paramMap.put("fourteen_status", actualBackupMonitor.getFourteenStatus());
        paramMap.put("fifteen_status", actualBackupMonitor.getFifteenStatus());
        paramMap.put("create_date", actualBackupMonitor.getCreateDate());
        paramMap.put("update_date", actualBackupMonitor.getUpdateDate());
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
	public void delete(Long backupId){
		jdbcTemplate.update(DELETE_SQL, backupId);
	}

	@Override
	public void batchSave(List<ActualBackupMonitor> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<ActualBackupMonitor> list){
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
	 * @param backupId 备份ID
	 * @return ActualBackupMonitor
	 */
	@Override
	public ActualBackupMonitor findById(Long backupId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`backup_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(ActualBackupMonitor.class), backupId);
	}

	/**
	 * 根据对象查询
	 * @param actualBackupMonitor
	 * @return List
	 */
	@Override
	public List<ActualBackupMonitor> find(ActualBackupMonitor actualBackupMonitor){
		return this.find(actualBackupMonitor, null, null);
	}

	/**
	 * 根据对象查询
	 * @param actualBackupMonitor
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<ActualBackupMonitor> find(ActualBackupMonitor actualBackupMonitor, String[][] orders){
		return this.find(actualBackupMonitor, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param actualBackupMonitor
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<ActualBackupMonitor> find(ActualBackupMonitor actualBackupMonitor, Long offset, Long rows){
		return this.find(actualBackupMonitor, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param actualBackupMonitor
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<ActualBackupMonitor> find(ActualBackupMonitor actualBackupMonitor, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(actualBackupMonitor != null){
			if(actualBackupMonitor.getBackupId() != null){
				sql.append(" AND _this.`backup_id` = ?");
				param.add(actualBackupMonitor.getBackupId());
			}
			if(actualBackupMonitor.getBackupTime() != null){
				sql.append(" AND _this.`backup_time` = ?");
				param.add(actualBackupMonitor.getBackupTime());
			}
			if(actualBackupMonitor.getBackupType() != null && !"".equals(actualBackupMonitor.getBackupType())){
				sql.append(" AND _this.`backup_type` = ?");
				param.add(actualBackupMonitor.getBackupType());
			}
			if(actualBackupMonitor.getNineHalfStatus() != null && !"".equals(actualBackupMonitor.getNineHalfStatus())){
				sql.append(" AND _this.`nine_half_status` = ?");
				param.add(actualBackupMonitor.getNineHalfStatus());
			}
			if(actualBackupMonitor.getTenHalfStatus() != null && !"".equals(actualBackupMonitor.getTenHalfStatus())){
				sql.append(" AND _this.`ten_half_status` = ?");
				param.add(actualBackupMonitor.getTenHalfStatus());
			}
			if(actualBackupMonitor.getElevenHalfStatus() != null && !"".equals(actualBackupMonitor.getElevenHalfStatus())){
				sql.append(" AND _this.`eleven_half_status` = ?");
				param.add(actualBackupMonitor.getElevenHalfStatus());
			}
			if(actualBackupMonitor.getFourteenStatus() != null && !"".equals(actualBackupMonitor.getFourteenStatus())){
				sql.append(" AND _this.`fourteen_status` = ?");
				param.add(actualBackupMonitor.getFourteenStatus());
			}
			if(actualBackupMonitor.getFifteenStatus() != null && !"".equals(actualBackupMonitor.getFifteenStatus())){
				sql.append(" AND _this.`fifteen_status` = ?");
				param.add(actualBackupMonitor.getFifteenStatus());
			}
			if(actualBackupMonitor.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(actualBackupMonitor.getCreateDate());
			}
			if(actualBackupMonitor.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(actualBackupMonitor.getUpdateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(ActualBackupMonitor.class));
	}


	/**
	 * 根据对象查询条数
	 * @param actualBackupMonitor
	 * @return Long
	 */
	@Override
	public Long count(ActualBackupMonitor actualBackupMonitor){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM smc_actual_backup_monitor  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(actualBackupMonitor != null){
			if(actualBackupMonitor.getBackupId() != null){
				sql.append(" AND _this.`backup_id` = ? ");
				param.add(actualBackupMonitor.getBackupId());
			}
			if(actualBackupMonitor.getBackupTime() != null){
				sql.append(" AND _this.`backup_time` = ? ");
				param.add(actualBackupMonitor.getBackupTime());
			}
			if(actualBackupMonitor.getBackupType() != null && !"".equals(actualBackupMonitor.getBackupType())){
				sql.append(" AND _this.`backup_type` = ? ");
				param.add(actualBackupMonitor.getBackupType());
			}
			if(actualBackupMonitor.getNineHalfStatus() != null && !"".equals(actualBackupMonitor.getNineHalfStatus())){
				sql.append(" AND _this.`nine_half_status` = ? ");
				param.add(actualBackupMonitor.getNineHalfStatus());
			}
			if(actualBackupMonitor.getTenHalfStatus() != null && !"".equals(actualBackupMonitor.getTenHalfStatus())){
				sql.append(" AND _this.`ten_half_status` = ? ");
				param.add(actualBackupMonitor.getTenHalfStatus());
			}
			if(actualBackupMonitor.getElevenHalfStatus() != null && !"".equals(actualBackupMonitor.getElevenHalfStatus())){
				sql.append(" AND _this.`eleven_half_status` = ? ");
				param.add(actualBackupMonitor.getElevenHalfStatus());
			}
			if(actualBackupMonitor.getFourteenStatus() != null && !"".equals(actualBackupMonitor.getFourteenStatus())){
				sql.append(" AND _this.`fourteen_status` = ? ");
				param.add(actualBackupMonitor.getFourteenStatus());
			}
			if(actualBackupMonitor.getFifteenStatus() != null && !"".equals(actualBackupMonitor.getFifteenStatus())){
				sql.append(" AND _this.`fifteen_status` = ? ");
				param.add(actualBackupMonitor.getFifteenStatus());
			}
			if(actualBackupMonitor.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(actualBackupMonitor.getCreateDate());
			}
			if(actualBackupMonitor.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(actualBackupMonitor.getUpdateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}