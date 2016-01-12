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

import com.lhy.adminj.basic.dao.base.TradeBaseDao;
import com.lhy.adminj.basic.model.Trade;

/**
 * 交易记录表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class TradeBaseDaoImpl implements TradeBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`trade_id`, _this.`user_id`, _this.`group_id`, _this.`stock_id`, _this.`stock_code`, _this.`stock_name`, _this.`trade_price`, _this.`trade_number`, _this.`turnover_amount`, _this.`trade_type`, _this.`counter_fee`, _this.`stamp_duty`, _this.`commission`, _this.`trade_date`, _this.`trade_time`, _this.`shareholder_code`, _this.`is_revoke`, _this.`stock_khh`, _this.`create_date`, _this.`update_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`trade_id`, _this.`user_id`, _this.`group_id`, _this.`stock_id`, _this.`stock_code`, _this.`stock_name`, _this.`trade_price`, _this.`trade_number`, _this.`turnover_amount`, _this.`trade_type`, _this.`counter_fee`, _this.`stamp_duty`, _this.`commission`, _this.`trade_date`, _this.`trade_time`, _this.`shareholder_code`, _this.`is_revoke`, _this.`stock_khh`, _this.`create_date`, _this.`update_date` FROM tmc_trade _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_trade(`trade_id`, `user_id`, `group_id`, `stock_id`, `stock_code`, `stock_name`, `trade_price`, `trade_number`, `turnover_amount`, `trade_type`, `counter_fee`, `stamp_duty`, `commission`, `trade_date`, `trade_time`, `shareholder_code`, `is_revoke`, `stock_khh`, `create_date`, `update_date`) VALUES (:trade_id, :user_id, :group_id, :stock_id, :stock_code, :stock_name, :trade_price, :trade_number, :turnover_amount, :trade_type, :counter_fee, :stamp_duty, :commission, :trade_date, :trade_time, :shareholder_code, :is_revoke, :stock_khh, :create_date, :update_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_trade SET `trade_id` = :trade_id, `user_id` = :user_id, `group_id` = :group_id, `stock_id` = :stock_id, `stock_code` = :stock_code, `stock_name` = :stock_name, `trade_price` = :trade_price, `trade_number` = :trade_number, `turnover_amount` = :turnover_amount, `trade_type` = :trade_type, `counter_fee` = :counter_fee, `stamp_duty` = :stamp_duty, `commission` = :commission, `trade_date` = :trade_date, `trade_time` = :trade_time, `shareholder_code` = :shareholder_code, `is_revoke` = :is_revoke, `stock_khh` = :stock_khh, `create_date` = :create_date, `update_date` = :update_date WHERE `trade_id` = :trade_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_trade WHERE `trade_id` = ?";

	@Override
	public void save(Trade trade) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(trade);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		trade.setTradeId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(Trade trade) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(trade);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(Trade trade) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_trade SET ");
		if(trade.getTradeId() != null){
			sql.append(" trade_id = ?, ");
			param.add(trade.getTradeId());
		}
		if(trade.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(trade.getUserId());
		}
		if(trade.getGroupId() != null){
			sql.append(" group_id = ?, ");
			param.add(trade.getGroupId());
		}
		if(trade.getStockId() != null){
			sql.append(" stock_id = ?, ");
			param.add(trade.getStockId());
		}
		if(trade.getStockCode() != null){
			sql.append(" stock_code = ?, ");
			param.add(trade.getStockCode());
		}
		if(trade.getStockName() != null){
			sql.append(" stock_name = ?, ");
			param.add(trade.getStockName());
		}
		if(trade.getTradePrice() != null){
			sql.append(" trade_price = ?, ");
			param.add(trade.getTradePrice());
		}
		if(trade.getTradeNumber() != null){
			sql.append(" trade_number = ?, ");
			param.add(trade.getTradeNumber());
		}
		if(trade.getTurnoverAmount() != null){
			sql.append(" turnover_amount = ?, ");
			param.add(trade.getTurnoverAmount());
		}
		if(trade.getTradeType() != null){
			sql.append(" trade_type = ?, ");
			param.add(trade.getTradeType());
		}
		if(trade.getCounterFee() != null){
			sql.append(" counter_fee = ?, ");
			param.add(trade.getCounterFee());
		}
		if(trade.getStampDuty() != null){
			sql.append(" stamp_duty = ?, ");
			param.add(trade.getStampDuty());
		}
		if(trade.getCommission() != null){
			sql.append(" commission = ?, ");
			param.add(trade.getCommission());
		}
		if(trade.getTradeDate() != null){
			sql.append(" trade_date = ?, ");
			param.add(trade.getTradeDate());
		}
		if(trade.getTradeTime() != null){
			sql.append(" trade_time = ?, ");
			param.add(trade.getTradeTime());
		}
		if(trade.getShareholderCode() != null){
			sql.append(" shareholder_code = ?, ");
			param.add(trade.getShareholderCode());
		}
		if(trade.getIsRevoke() != null){
			sql.append(" is_revoke = ?, ");
			param.add(trade.getIsRevoke());
		}
		if(trade.getStockKhh() != null){
			sql.append(" stock_khh = ?, ");
			param.add(trade.getStockKhh());
		}
		if(trade.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(trade.getCreateDate());
		}
		if(trade.getUpdateDate() != null){
			sql.append(" update_date = ? ");
			param.add(trade.getUpdateDate());
		}
		sql.append(" WHERE trade_id = ? ");
		param.add(trade.getTradeId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param trades
	 * @return
	 */
	public Map<String, Object>[] toMap(List<Trade> trades){
		Map<String, Object>[] maps = new Map[trades.size()];
		for(int i = 0; i < trades.size(); i++){
			Trade trade = trades.get(i);
			maps[i] = toMap(trade);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param trade
	 * @return
	 */
	public Map<String, Object> toMap(Trade trade){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("trade_id", trade.getTradeId());
        paramMap.put("user_id", trade.getUserId());
        paramMap.put("group_id", trade.getGroupId());
        paramMap.put("stock_id", trade.getStockId());
        paramMap.put("stock_code", trade.getStockCode());
        paramMap.put("stock_name", trade.getStockName());
        paramMap.put("trade_price", trade.getTradePrice());
        paramMap.put("trade_number", trade.getTradeNumber());
        paramMap.put("turnover_amount", trade.getTurnoverAmount());
        paramMap.put("trade_type", trade.getTradeType());
        paramMap.put("counter_fee", trade.getCounterFee());
        paramMap.put("stamp_duty", trade.getStampDuty());
        paramMap.put("commission", trade.getCommission());
        paramMap.put("trade_date", trade.getTradeDate());
        paramMap.put("trade_time", trade.getTradeTime());
        paramMap.put("shareholder_code", trade.getShareholderCode());
        paramMap.put("is_revoke", trade.getIsRevoke());
        paramMap.put("stock_khh", trade.getStockKhh());
        paramMap.put("create_date", trade.getCreateDate());
        paramMap.put("update_date", trade.getUpdateDate());
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
	public void delete(Long tradeId){
		jdbcTemplate.update(DELETE_SQL, tradeId);
	}

	@Override
	public void batchSave(List<Trade> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<Trade> list){
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
	 * @param tradeId 交易记录表主键
	 * @return Trade
	 */
	@Override
	public Trade findById(Long tradeId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`trade_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(Trade.class), tradeId);
	}

	/**
	 * 根据对象查询
	 * @param trade
	 * @return List
	 */
	@Override
	public List<Trade> find(Trade trade){
		return this.find(trade, null, null);
	}

	/**
	 * 根据对象查询
	 * @param trade
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<Trade> find(Trade trade, String[][] orders){
		return this.find(trade, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param trade
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Trade> find(Trade trade, Long offset, Long rows){
		return this.find(trade, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param trade
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Trade> find(Trade trade, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(trade != null){
			if(trade.getTradeId() != null){
				sql.append(" AND _this.`trade_id` = ?");
				param.add(trade.getTradeId());
			}
			if(trade.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(trade.getUserId());
			}
			if(trade.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(trade.getGroupId());
			}
			if(trade.getStockId() != null){
				sql.append(" AND _this.`stock_id` = ?");
				param.add(trade.getStockId());
			}
			if(trade.getStockCode() != null && !"".equals(trade.getStockCode())){
				sql.append(" AND _this.`stock_code` = ?");
				param.add(trade.getStockCode());
			}
			if(trade.getStockName() != null && !"".equals(trade.getStockName())){
				sql.append(" AND _this.`stock_name` = ?");
				param.add(trade.getStockName());
			}
			if(trade.getTradeNumber() != null){
				sql.append(" AND _this.`trade_number` = ?");
				param.add(trade.getTradeNumber());
			}
			if(trade.getTradeType() != null && !"".equals(trade.getTradeType())){
				sql.append(" AND _this.`trade_type` = ?");
				param.add(trade.getTradeType());
			}
			if(trade.getTradeDate() != null){
				sql.append(" AND _this.`trade_date` = ?");
				param.add(trade.getTradeDate());
			}
			if(trade.getTradeTime() != null){
				sql.append(" AND _this.`trade_time` = ?");
				param.add(trade.getTradeTime());
			}
			if(trade.getShareholderCode() != null && !"".equals(trade.getShareholderCode())){
				sql.append(" AND _this.`shareholder_code` = ?");
				param.add(trade.getShareholderCode());
			}
			if(trade.getIsRevoke() != null && !"".equals(trade.getIsRevoke())){
				sql.append(" AND _this.`is_revoke` = ?");
				param.add(trade.getIsRevoke());
			}
			if(trade.getStockKhh() != null && !"".equals(trade.getStockKhh())){
				sql.append(" AND _this.`stock_khh` = ?");
				param.add(trade.getStockKhh());
			}
			if(trade.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(trade.getCreateDate());
			}
			if(trade.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(trade.getUpdateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Trade.class));
	}


	/**
	 * 根据对象查询条数
	 * @param trade
	 * @return Long
	 */
	@Override
	public Long count(Trade trade){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_trade  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(trade != null){
			if(trade.getTradeId() != null){
				sql.append(" AND _this.`trade_id` = ? ");
				param.add(trade.getTradeId());
			}
			if(trade.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(trade.getUserId());
			}
			if(trade.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(trade.getGroupId());
			}
			if(trade.getStockId() != null){
				sql.append(" AND _this.`stock_id` = ? ");
				param.add(trade.getStockId());
			}
			if(trade.getStockCode() != null && !"".equals(trade.getStockCode())){
				sql.append(" AND _this.`stock_code` = ? ");
				param.add(trade.getStockCode());
			}
			if(trade.getStockName() != null && !"".equals(trade.getStockName())){
				sql.append(" AND _this.`stock_name` = ? ");
				param.add(trade.getStockName());
			}
			if(trade.getTradeNumber() != null){
				sql.append(" AND _this.`trade_number` = ? ");
				param.add(trade.getTradeNumber());
			}
			if(trade.getTradeType() != null && !"".equals(trade.getTradeType())){
				sql.append(" AND _this.`trade_type` = ? ");
				param.add(trade.getTradeType());
			}
			if(trade.getTradeDate() != null){
				sql.append(" AND _this.`trade_date` = ? ");
				param.add(trade.getTradeDate());
			}
			if(trade.getTradeTime() != null){
				sql.append(" AND _this.`trade_time` = ? ");
				param.add(trade.getTradeTime());
			}
			if(trade.getShareholderCode() != null && !"".equals(trade.getShareholderCode())){
				sql.append(" AND _this.`shareholder_code` = ? ");
				param.add(trade.getShareholderCode());
			}
			if(trade.getIsRevoke() != null && !"".equals(trade.getIsRevoke())){
				sql.append(" AND _this.`is_revoke` = ? ");
				param.add(trade.getIsRevoke());
			}
			if(trade.getStockKhh() != null && !"".equals(trade.getStockKhh())){
				sql.append(" AND _this.`stock_khh` = ? ");
				param.add(trade.getStockKhh());
			}
			if(trade.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(trade.getCreateDate());
			}
			if(trade.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(trade.getUpdateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}