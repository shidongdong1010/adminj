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

import com.lhy.adminj.basic.dao.base.TradeActualBaseDao;
import com.lhy.adminj.basic.model.TradeActual;

/**
 * 时段交易记录表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class TradeActualBaseDaoImpl implements TradeActualBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`actual_trade_id`, _this.`actual_type`, _this.`user_id`, _this.`group_id`, _this.`stock_id`, _this.`stock_code`, _this.`stock_name`, _this.`trade_price`, _this.`trade_number`, _this.`turnover_amount`, _this.`trade_type`, _this.`counter_fee`, _this.`stamp_duty`, _this.`commission`, _this.`trade_date`, _this.`trade_time`, _this.`shareholder_code`, _this.`is_revoke`, _this.`stock_khh`, _this.`create_date`, _this.`update_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`actual_trade_id`, _this.`actual_type`, _this.`user_id`, _this.`group_id`, _this.`stock_id`, _this.`stock_code`, _this.`stock_name`, _this.`trade_price`, _this.`trade_number`, _this.`turnover_amount`, _this.`trade_type`, _this.`counter_fee`, _this.`stamp_duty`, _this.`commission`, _this.`trade_date`, _this.`trade_time`, _this.`shareholder_code`, _this.`is_revoke`, _this.`stock_khh`, _this.`create_date`, _this.`update_date` FROM tmc_trade_actual _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_trade_actual(`actual_trade_id`, `actual_type`, `user_id`, `group_id`, `stock_id`, `stock_code`, `stock_name`, `trade_price`, `trade_number`, `turnover_amount`, `trade_type`, `counter_fee`, `stamp_duty`, `commission`, `trade_date`, `trade_time`, `shareholder_code`, `is_revoke`, `stock_khh`, `create_date`, `update_date`) VALUES (:actual_trade_id, :actual_type, :user_id, :group_id, :stock_id, :stock_code, :stock_name, :trade_price, :trade_number, :turnover_amount, :trade_type, :counter_fee, :stamp_duty, :commission, :trade_date, :trade_time, :shareholder_code, :is_revoke, :stock_khh, :create_date, :update_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_trade_actual SET `actual_trade_id` = :actual_trade_id, `actual_type` = :actual_type, `user_id` = :user_id, `group_id` = :group_id, `stock_id` = :stock_id, `stock_code` = :stock_code, `stock_name` = :stock_name, `trade_price` = :trade_price, `trade_number` = :trade_number, `turnover_amount` = :turnover_amount, `trade_type` = :trade_type, `counter_fee` = :counter_fee, `stamp_duty` = :stamp_duty, `commission` = :commission, `trade_date` = :trade_date, `trade_time` = :trade_time, `shareholder_code` = :shareholder_code, `is_revoke` = :is_revoke, `stock_khh` = :stock_khh, `create_date` = :create_date, `update_date` = :update_date WHERE `actual_trade_id` = :actual_trade_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_trade_actual WHERE `actual_trade_id` = ?";

	@Override
	public void save(TradeActual tradeActual) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(tradeActual);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		tradeActual.setActualTradeId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(TradeActual tradeActual) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(tradeActual);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(TradeActual tradeActual) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_trade_actual SET ");
		if(tradeActual.getActualTradeId() != null){
			sql.append(" actual_trade_id = ?, ");
			param.add(tradeActual.getActualTradeId());
		}
		if(tradeActual.getActualType() != null){
			sql.append(" actual_type = ?, ");
			param.add(tradeActual.getActualType());
		}
		if(tradeActual.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(tradeActual.getUserId());
		}
		if(tradeActual.getGroupId() != null){
			sql.append(" group_id = ?, ");
			param.add(tradeActual.getGroupId());
		}
		if(tradeActual.getStockId() != null){
			sql.append(" stock_id = ?, ");
			param.add(tradeActual.getStockId());
		}
		if(tradeActual.getStockCode() != null){
			sql.append(" stock_code = ?, ");
			param.add(tradeActual.getStockCode());
		}
		if(tradeActual.getStockName() != null){
			sql.append(" stock_name = ?, ");
			param.add(tradeActual.getStockName());
		}
		if(tradeActual.getTradePrice() != null){
			sql.append(" trade_price = ?, ");
			param.add(tradeActual.getTradePrice());
		}
		if(tradeActual.getTradeNumber() != null){
			sql.append(" trade_number = ?, ");
			param.add(tradeActual.getTradeNumber());
		}
		if(tradeActual.getTurnoverAmount() != null){
			sql.append(" turnover_amount = ?, ");
			param.add(tradeActual.getTurnoverAmount());
		}
		if(tradeActual.getTradeType() != null){
			sql.append(" trade_type = ?, ");
			param.add(tradeActual.getTradeType());
		}
		if(tradeActual.getCounterFee() != null){
			sql.append(" counter_fee = ?, ");
			param.add(tradeActual.getCounterFee());
		}
		if(tradeActual.getStampDuty() != null){
			sql.append(" stamp_duty = ?, ");
			param.add(tradeActual.getStampDuty());
		}
		if(tradeActual.getCommission() != null){
			sql.append(" commission = ?, ");
			param.add(tradeActual.getCommission());
		}
		if(tradeActual.getTradeDate() != null){
			sql.append(" trade_date = ?, ");
			param.add(tradeActual.getTradeDate());
		}
		if(tradeActual.getTradeTime() != null){
			sql.append(" trade_time = ?, ");
			param.add(tradeActual.getTradeTime());
		}
		if(tradeActual.getShareholderCode() != null){
			sql.append(" shareholder_code = ?, ");
			param.add(tradeActual.getShareholderCode());
		}
		if(tradeActual.getIsRevoke() != null){
			sql.append(" is_revoke = ?, ");
			param.add(tradeActual.getIsRevoke());
		}
		if(tradeActual.getStockKhh() != null){
			sql.append(" stock_khh = ?, ");
			param.add(tradeActual.getStockKhh());
		}
		if(tradeActual.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(tradeActual.getCreateDate());
		}
		if(tradeActual.getUpdateDate() != null){
			sql.append(" update_date = ? ");
			param.add(tradeActual.getUpdateDate());
		}
		sql.append(" WHERE actual_trade_id = ? ");
		param.add(tradeActual.getActualTradeId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param tradeActuals
	 * @return
	 */
	public Map<String, Object>[] toMap(List<TradeActual> tradeActuals){
		Map<String, Object>[] maps = new Map[tradeActuals.size()];
		for(int i = 0; i < tradeActuals.size(); i++){
			TradeActual tradeActual = tradeActuals.get(i);
			maps[i] = toMap(tradeActual);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param tradeActual
	 * @return
	 */
	public Map<String, Object> toMap(TradeActual tradeActual){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("actual_trade_id", tradeActual.getActualTradeId());
        paramMap.put("actual_type", tradeActual.getActualType());
        paramMap.put("user_id", tradeActual.getUserId());
        paramMap.put("group_id", tradeActual.getGroupId());
        paramMap.put("stock_id", tradeActual.getStockId());
        paramMap.put("stock_code", tradeActual.getStockCode());
        paramMap.put("stock_name", tradeActual.getStockName());
        paramMap.put("trade_price", tradeActual.getTradePrice());
        paramMap.put("trade_number", tradeActual.getTradeNumber());
        paramMap.put("turnover_amount", tradeActual.getTurnoverAmount());
        paramMap.put("trade_type", tradeActual.getTradeType());
        paramMap.put("counter_fee", tradeActual.getCounterFee());
        paramMap.put("stamp_duty", tradeActual.getStampDuty());
        paramMap.put("commission", tradeActual.getCommission());
        paramMap.put("trade_date", tradeActual.getTradeDate());
        paramMap.put("trade_time", tradeActual.getTradeTime());
        paramMap.put("shareholder_code", tradeActual.getShareholderCode());
        paramMap.put("is_revoke", tradeActual.getIsRevoke());
        paramMap.put("stock_khh", tradeActual.getStockKhh());
        paramMap.put("create_date", tradeActual.getCreateDate());
        paramMap.put("update_date", tradeActual.getUpdateDate());
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
	public void delete(Long actualTradeId){
		jdbcTemplate.update(DELETE_SQL, actualTradeId);
	}

	@Override
	public void batchSave(List<TradeActual> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<TradeActual> list){
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
	 * @param actualTradeId 交易记录表主键
	 * @return TradeActual
	 */
	@Override
	public TradeActual findById(Long actualTradeId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`actual_trade_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(TradeActual.class), actualTradeId);
	}

	/**
	 * 根据对象查询
	 * @param tradeActual
	 * @return List
	 */
	@Override
	public List<TradeActual> find(TradeActual tradeActual){
		return this.find(tradeActual, null, null);
	}

	/**
	 * 根据对象查询
	 * @param tradeActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<TradeActual> find(TradeActual tradeActual, String[][] orders){
		return this.find(tradeActual, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param tradeActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<TradeActual> find(TradeActual tradeActual, Long offset, Long rows){
		return this.find(tradeActual, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param tradeActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<TradeActual> find(TradeActual tradeActual, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(tradeActual != null){
			if(tradeActual.getActualTradeId() != null){
				sql.append(" AND _this.`actual_trade_id` = ?");
				param.add(tradeActual.getActualTradeId());
			}
			if(tradeActual.getActualType() != null && !"".equals(tradeActual.getActualType())){
				sql.append(" AND _this.`actual_type` = ?");
				param.add(tradeActual.getActualType());
			}
			if(tradeActual.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(tradeActual.getUserId());
			}
			if(tradeActual.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(tradeActual.getGroupId());
			}
			if(tradeActual.getStockId() != null){
				sql.append(" AND _this.`stock_id` = ?");
				param.add(tradeActual.getStockId());
			}
			if(tradeActual.getStockCode() != null && !"".equals(tradeActual.getStockCode())){
				sql.append(" AND _this.`stock_code` = ?");
				param.add(tradeActual.getStockCode());
			}
			if(tradeActual.getStockName() != null && !"".equals(tradeActual.getStockName())){
				sql.append(" AND _this.`stock_name` = ?");
				param.add(tradeActual.getStockName());
			}
			if(tradeActual.getTradeNumber() != null){
				sql.append(" AND _this.`trade_number` = ?");
				param.add(tradeActual.getTradeNumber());
			}
			if(tradeActual.getTradeType() != null && !"".equals(tradeActual.getTradeType())){
				sql.append(" AND _this.`trade_type` = ?");
				param.add(tradeActual.getTradeType());
			}
			if(tradeActual.getTradeDate() != null){
				sql.append(" AND _this.`trade_date` = ?");
				param.add(tradeActual.getTradeDate());
			}
			if(tradeActual.getTradeTime() != null){
				sql.append(" AND _this.`trade_time` = ?");
				param.add(tradeActual.getTradeTime());
			}
			if(tradeActual.getShareholderCode() != null && !"".equals(tradeActual.getShareholderCode())){
				sql.append(" AND _this.`shareholder_code` = ?");
				param.add(tradeActual.getShareholderCode());
			}
			if(tradeActual.getIsRevoke() != null && !"".equals(tradeActual.getIsRevoke())){
				sql.append(" AND _this.`is_revoke` = ?");
				param.add(tradeActual.getIsRevoke());
			}
			if(tradeActual.getStockKhh() != null && !"".equals(tradeActual.getStockKhh())){
				sql.append(" AND _this.`stock_khh` = ?");
				param.add(tradeActual.getStockKhh());
			}
			if(tradeActual.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(tradeActual.getCreateDate());
			}
			if(tradeActual.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(tradeActual.getUpdateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(TradeActual.class));
	}


	/**
	 * 根据对象查询条数
	 * @param tradeActual
	 * @return Long
	 */
	@Override
	public Long count(TradeActual tradeActual){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_trade_actual  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(tradeActual != null){
			if(tradeActual.getActualTradeId() != null){
				sql.append(" AND _this.`actual_trade_id` = ? ");
				param.add(tradeActual.getActualTradeId());
			}
			if(tradeActual.getActualType() != null && !"".equals(tradeActual.getActualType())){
				sql.append(" AND _this.`actual_type` = ? ");
				param.add(tradeActual.getActualType());
			}
			if(tradeActual.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(tradeActual.getUserId());
			}
			if(tradeActual.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(tradeActual.getGroupId());
			}
			if(tradeActual.getStockId() != null){
				sql.append(" AND _this.`stock_id` = ? ");
				param.add(tradeActual.getStockId());
			}
			if(tradeActual.getStockCode() != null && !"".equals(tradeActual.getStockCode())){
				sql.append(" AND _this.`stock_code` = ? ");
				param.add(tradeActual.getStockCode());
			}
			if(tradeActual.getStockName() != null && !"".equals(tradeActual.getStockName())){
				sql.append(" AND _this.`stock_name` = ? ");
				param.add(tradeActual.getStockName());
			}
			if(tradeActual.getTradeNumber() != null){
				sql.append(" AND _this.`trade_number` = ? ");
				param.add(tradeActual.getTradeNumber());
			}
			if(tradeActual.getTradeType() != null && !"".equals(tradeActual.getTradeType())){
				sql.append(" AND _this.`trade_type` = ? ");
				param.add(tradeActual.getTradeType());
			}
			if(tradeActual.getTradeDate() != null){
				sql.append(" AND _this.`trade_date` = ? ");
				param.add(tradeActual.getTradeDate());
			}
			if(tradeActual.getTradeTime() != null){
				sql.append(" AND _this.`trade_time` = ? ");
				param.add(tradeActual.getTradeTime());
			}
			if(tradeActual.getShareholderCode() != null && !"".equals(tradeActual.getShareholderCode())){
				sql.append(" AND _this.`shareholder_code` = ? ");
				param.add(tradeActual.getShareholderCode());
			}
			if(tradeActual.getIsRevoke() != null && !"".equals(tradeActual.getIsRevoke())){
				sql.append(" AND _this.`is_revoke` = ? ");
				param.add(tradeActual.getIsRevoke());
			}
			if(tradeActual.getStockKhh() != null && !"".equals(tradeActual.getStockKhh())){
				sql.append(" AND _this.`stock_khh` = ? ");
				param.add(tradeActual.getStockKhh());
			}
			if(tradeActual.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(tradeActual.getCreateDate());
			}
			if(tradeActual.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(tradeActual.getUpdateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}