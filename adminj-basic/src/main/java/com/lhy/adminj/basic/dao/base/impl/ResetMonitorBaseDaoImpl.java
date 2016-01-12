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

import com.lhy.adminj.basic.dao.base.ResetMonitorBaseDao;
import com.lhy.adminj.basic.model.ResetMonitor;

/**
 * 股票数据清理监控表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class ResetMonitorBaseDaoImpl implements ResetMonitorBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`reset_id`, _this.`reset_date`, _this.`reset_data_date`, _this.`position_num_reset`, _this.`del_position_stock`, _this.`group_income_reset`, _this.`group_detail_income_reset`, _this.`del_group_detail`, _this.`create_date`, _this.`update_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`reset_id`, _this.`reset_date`, _this.`reset_data_date`, _this.`position_num_reset`, _this.`del_position_stock`, _this.`group_income_reset`, _this.`group_detail_income_reset`, _this.`del_group_detail`, _this.`create_date`, _this.`update_date` FROM tmc_reset_monitor _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_reset_monitor(`reset_id`, `reset_date`, `reset_data_date`, `position_num_reset`, `del_position_stock`, `group_income_reset`, `group_detail_income_reset`, `del_group_detail`, `create_date`, `update_date`) VALUES (:reset_id, :reset_date, :reset_data_date, :position_num_reset, :del_position_stock, :group_income_reset, :group_detail_income_reset, :del_group_detail, :create_date, :update_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_reset_monitor SET `reset_id` = :reset_id, `reset_date` = :reset_date, `reset_data_date` = :reset_data_date, `position_num_reset` = :position_num_reset, `del_position_stock` = :del_position_stock, `group_income_reset` = :group_income_reset, `group_detail_income_reset` = :group_detail_income_reset, `del_group_detail` = :del_group_detail, `create_date` = :create_date, `update_date` = :update_date WHERE `reset_id` = :reset_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_reset_monitor WHERE `reset_id` = ?";

	@Override
	public void save(ResetMonitor resetMonitor) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(resetMonitor);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		resetMonitor.setResetId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(ResetMonitor resetMonitor) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(resetMonitor);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(ResetMonitor resetMonitor) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_reset_monitor SET ");
		if(resetMonitor.getResetId() != null){
			sql.append(" reset_id = ?, ");
			param.add(resetMonitor.getResetId());
		}
		if(resetMonitor.getResetDate() != null){
			sql.append(" reset_date = ?, ");
			param.add(resetMonitor.getResetDate());
		}
		if(resetMonitor.getResetDataDate() != null){
			sql.append(" reset_data_date = ?, ");
			param.add(resetMonitor.getResetDataDate());
		}
		if(resetMonitor.getPositionNumReset() != null){
			sql.append(" position_num_reset = ?, ");
			param.add(resetMonitor.getPositionNumReset());
		}
		if(resetMonitor.getDelPositionStock() != null){
			sql.append(" del_position_stock = ?, ");
			param.add(resetMonitor.getDelPositionStock());
		}
		if(resetMonitor.getGroupIncomeReset() != null){
			sql.append(" group_income_reset = ?, ");
			param.add(resetMonitor.getGroupIncomeReset());
		}
		if(resetMonitor.getGroupDetailIncomeReset() != null){
			sql.append(" group_detail_income_reset = ?, ");
			param.add(resetMonitor.getGroupDetailIncomeReset());
		}
		if(resetMonitor.getDelGroupDetail() != null){
			sql.append(" del_group_detail = ?, ");
			param.add(resetMonitor.getDelGroupDetail());
		}
		if(resetMonitor.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(resetMonitor.getCreateDate());
		}
		if(resetMonitor.getUpdateDate() != null){
			sql.append(" update_date = ? ");
			param.add(resetMonitor.getUpdateDate());
		}
		sql.append(" WHERE reset_id = ? ");
		param.add(resetMonitor.getResetId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param resetMonitors
	 * @return
	 */
	public Map<String, Object>[] toMap(List<ResetMonitor> resetMonitors){
		Map<String, Object>[] maps = new Map[resetMonitors.size()];
		for(int i = 0; i < resetMonitors.size(); i++){
			ResetMonitor resetMonitor = resetMonitors.get(i);
			maps[i] = toMap(resetMonitor);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param resetMonitor
	 * @return
	 */
	public Map<String, Object> toMap(ResetMonitor resetMonitor){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("reset_id", resetMonitor.getResetId());
        paramMap.put("reset_date", resetMonitor.getResetDate());
        paramMap.put("reset_data_date", resetMonitor.getResetDataDate());
        paramMap.put("position_num_reset", resetMonitor.getPositionNumReset());
        paramMap.put("del_position_stock", resetMonitor.getDelPositionStock());
        paramMap.put("group_income_reset", resetMonitor.getGroupIncomeReset());
        paramMap.put("group_detail_income_reset", resetMonitor.getGroupDetailIncomeReset());
        paramMap.put("del_group_detail", resetMonitor.getDelGroupDetail());
        paramMap.put("create_date", resetMonitor.getCreateDate());
        paramMap.put("update_date", resetMonitor.getUpdateDate());
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
	public void delete(Long resetId){
		jdbcTemplate.update(DELETE_SQL, resetId);
	}

	@Override
	public void batchSave(List<ResetMonitor> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<ResetMonitor> list){
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
	 * @param resetId 清理ID
	 * @return ResetMonitor
	 */
	@Override
	public ResetMonitor findById(Long resetId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`reset_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(ResetMonitor.class), resetId);
	}

	/**
	 * 根据对象查询
	 * @param resetMonitor
	 * @return List
	 */
	@Override
	public List<ResetMonitor> find(ResetMonitor resetMonitor){
		return this.find(resetMonitor, null, null);
	}

	/**
	 * 根据对象查询
	 * @param resetMonitor
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<ResetMonitor> find(ResetMonitor resetMonitor, String[][] orders){
		return this.find(resetMonitor, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param resetMonitor
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<ResetMonitor> find(ResetMonitor resetMonitor, Long offset, Long rows){
		return this.find(resetMonitor, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param resetMonitor
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<ResetMonitor> find(ResetMonitor resetMonitor, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(resetMonitor != null){
			if(resetMonitor.getResetId() != null){
				sql.append(" AND _this.`reset_id` = ?");
				param.add(resetMonitor.getResetId());
			}
			if(resetMonitor.getResetDate() != null){
				sql.append(" AND _this.`reset_date` = ?");
				param.add(resetMonitor.getResetDate());
			}
			if(resetMonitor.getResetDataDate() != null){
				sql.append(" AND _this.`reset_data_date` = ?");
				param.add(resetMonitor.getResetDataDate());
			}
			if(resetMonitor.getPositionNumReset() != null && !"".equals(resetMonitor.getPositionNumReset())){
				sql.append(" AND _this.`position_num_reset` = ?");
				param.add(resetMonitor.getPositionNumReset());
			}
			if(resetMonitor.getDelPositionStock() != null && !"".equals(resetMonitor.getDelPositionStock())){
				sql.append(" AND _this.`del_position_stock` = ?");
				param.add(resetMonitor.getDelPositionStock());
			}
			if(resetMonitor.getGroupIncomeReset() != null && !"".equals(resetMonitor.getGroupIncomeReset())){
				sql.append(" AND _this.`group_income_reset` = ?");
				param.add(resetMonitor.getGroupIncomeReset());
			}
			if(resetMonitor.getGroupDetailIncomeReset() != null && !"".equals(resetMonitor.getGroupDetailIncomeReset())){
				sql.append(" AND _this.`group_detail_income_reset` = ?");
				param.add(resetMonitor.getGroupDetailIncomeReset());
			}
			if(resetMonitor.getDelGroupDetail() != null && !"".equals(resetMonitor.getDelGroupDetail())){
				sql.append(" AND _this.`del_group_detail` = ?");
				param.add(resetMonitor.getDelGroupDetail());
			}
			if(resetMonitor.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(resetMonitor.getCreateDate());
			}
			if(resetMonitor.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(resetMonitor.getUpdateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(ResetMonitor.class));
	}


	/**
	 * 根据对象查询条数
	 * @param resetMonitor
	 * @return Long
	 */
	@Override
	public Long count(ResetMonitor resetMonitor){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_reset_monitor  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(resetMonitor != null){
			if(resetMonitor.getResetId() != null){
				sql.append(" AND _this.`reset_id` = ? ");
				param.add(resetMonitor.getResetId());
			}
			if(resetMonitor.getResetDate() != null){
				sql.append(" AND _this.`reset_date` = ? ");
				param.add(resetMonitor.getResetDate());
			}
			if(resetMonitor.getResetDataDate() != null){
				sql.append(" AND _this.`reset_data_date` = ? ");
				param.add(resetMonitor.getResetDataDate());
			}
			if(resetMonitor.getPositionNumReset() != null && !"".equals(resetMonitor.getPositionNumReset())){
				sql.append(" AND _this.`position_num_reset` = ? ");
				param.add(resetMonitor.getPositionNumReset());
			}
			if(resetMonitor.getDelPositionStock() != null && !"".equals(resetMonitor.getDelPositionStock())){
				sql.append(" AND _this.`del_position_stock` = ? ");
				param.add(resetMonitor.getDelPositionStock());
			}
			if(resetMonitor.getGroupIncomeReset() != null && !"".equals(resetMonitor.getGroupIncomeReset())){
				sql.append(" AND _this.`group_income_reset` = ? ");
				param.add(resetMonitor.getGroupIncomeReset());
			}
			if(resetMonitor.getGroupDetailIncomeReset() != null && !"".equals(resetMonitor.getGroupDetailIncomeReset())){
				sql.append(" AND _this.`group_detail_income_reset` = ? ");
				param.add(resetMonitor.getGroupDetailIncomeReset());
			}
			if(resetMonitor.getDelGroupDetail() != null && !"".equals(resetMonitor.getDelGroupDetail())){
				sql.append(" AND _this.`del_group_detail` = ? ");
				param.add(resetMonitor.getDelGroupDetail());
			}
			if(resetMonitor.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(resetMonitor.getCreateDate());
			}
			if(resetMonitor.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(resetMonitor.getUpdateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}