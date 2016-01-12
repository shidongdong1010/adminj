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

import com.lhy.adminj.basic.dao.base.UserStockPositionActualBaseDao;
import com.lhy.adminj.basic.model.UserStockPositionActual;

/**
 * 股票时段持仓表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserStockPositionActualBaseDaoImpl implements UserStockPositionActualBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`actual_position_id`, _this.`actual_type`, _this.`actual_date`, _this.`stock_id`, _this.`stock_code`, _this.`stock_name`, _this.`user_id`, _this.`group_id`, _this.`group_detail_id`, _this.`stock_khh`, _this.`stock_num`, _this.`sell_num`, _this.`currency`, _this.`cost_price`, _this.`profit_loss`, _this.`profit_loss_ratio`, _this.`curr_price`, _this.`today_buy_num`, _this.`today_sell_num`, _this.`cost_amount`, _this.`converted_exchange_rate`, _this.`shareholder_code`, _this.`create_date`, _this.`update_date`, _this.`is_del`, _this.`remark`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`actual_position_id`, _this.`actual_type`, _this.`actual_date`, _this.`stock_id`, _this.`stock_code`, _this.`stock_name`, _this.`user_id`, _this.`group_id`, _this.`group_detail_id`, _this.`stock_khh`, _this.`stock_num`, _this.`sell_num`, _this.`currency`, _this.`cost_price`, _this.`profit_loss`, _this.`profit_loss_ratio`, _this.`curr_price`, _this.`today_buy_num`, _this.`today_sell_num`, _this.`cost_amount`, _this.`converted_exchange_rate`, _this.`shareholder_code`, _this.`create_date`, _this.`update_date`, _this.`is_del`, _this.`remark` FROM tmc_user_stock_position_actual _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_user_stock_position_actual(`actual_position_id`, `actual_type`, `actual_date`, `stock_id`, `stock_code`, `stock_name`, `user_id`, `group_id`, `group_detail_id`, `stock_khh`, `stock_num`, `sell_num`, `currency`, `cost_price`, `profit_loss`, `profit_loss_ratio`, `curr_price`, `today_buy_num`, `today_sell_num`, `cost_amount`, `converted_exchange_rate`, `shareholder_code`, `create_date`, `update_date`, `is_del`, `remark`) VALUES (:actual_position_id, :actual_type, :actual_date, :stock_id, :stock_code, :stock_name, :user_id, :group_id, :group_detail_id, :stock_khh, :stock_num, :sell_num, :currency, :cost_price, :profit_loss, :profit_loss_ratio, :curr_price, :today_buy_num, :today_sell_num, :cost_amount, :converted_exchange_rate, :shareholder_code, :create_date, :update_date, :is_del, :remark)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_user_stock_position_actual SET `actual_position_id` = :actual_position_id, `actual_type` = :actual_type, `actual_date` = :actual_date, `stock_id` = :stock_id, `stock_code` = :stock_code, `stock_name` = :stock_name, `user_id` = :user_id, `group_id` = :group_id, `group_detail_id` = :group_detail_id, `stock_khh` = :stock_khh, `stock_num` = :stock_num, `sell_num` = :sell_num, `currency` = :currency, `cost_price` = :cost_price, `profit_loss` = :profit_loss, `profit_loss_ratio` = :profit_loss_ratio, `curr_price` = :curr_price, `today_buy_num` = :today_buy_num, `today_sell_num` = :today_sell_num, `cost_amount` = :cost_amount, `converted_exchange_rate` = :converted_exchange_rate, `shareholder_code` = :shareholder_code, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del, `remark` = :remark WHERE `actual_position_id` = :actual_position_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_user_stock_position_actual WHERE `actual_position_id` = ?";

	@Override
	public void save(UserStockPositionActual userStockPositionActual) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userStockPositionActual);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userStockPositionActual.setActualPositionId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserStockPositionActual userStockPositionActual) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userStockPositionActual);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserStockPositionActual userStockPositionActual) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_user_stock_position_actual SET ");
		if(userStockPositionActual.getActualPositionId() != null){
			sql.append(" actual_position_id = ?, ");
			param.add(userStockPositionActual.getActualPositionId());
		}
		if(userStockPositionActual.getActualType() != null){
			sql.append(" actual_type = ?, ");
			param.add(userStockPositionActual.getActualType());
		}
		if(userStockPositionActual.getActualDate() != null){
			sql.append(" actual_date = ?, ");
			param.add(userStockPositionActual.getActualDate());
		}
		if(userStockPositionActual.getStockId() != null){
			sql.append(" stock_id = ?, ");
			param.add(userStockPositionActual.getStockId());
		}
		if(userStockPositionActual.getStockCode() != null){
			sql.append(" stock_code = ?, ");
			param.add(userStockPositionActual.getStockCode());
		}
		if(userStockPositionActual.getStockName() != null){
			sql.append(" stock_name = ?, ");
			param.add(userStockPositionActual.getStockName());
		}
		if(userStockPositionActual.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userStockPositionActual.getUserId());
		}
		if(userStockPositionActual.getGroupId() != null){
			sql.append(" group_id = ?, ");
			param.add(userStockPositionActual.getGroupId());
		}
		if(userStockPositionActual.getGroupDetailId() != null){
			sql.append(" group_detail_id = ?, ");
			param.add(userStockPositionActual.getGroupDetailId());
		}
		if(userStockPositionActual.getStockKhh() != null){
			sql.append(" stock_khh = ?, ");
			param.add(userStockPositionActual.getStockKhh());
		}
		if(userStockPositionActual.getStockNum() != null){
			sql.append(" stock_num = ?, ");
			param.add(userStockPositionActual.getStockNum());
		}
		if(userStockPositionActual.getSellNum() != null){
			sql.append(" sell_num = ?, ");
			param.add(userStockPositionActual.getSellNum());
		}
		if(userStockPositionActual.getCurrency() != null){
			sql.append(" currency = ?, ");
			param.add(userStockPositionActual.getCurrency());
		}
		if(userStockPositionActual.getCostPrice() != null){
			sql.append(" cost_price = ?, ");
			param.add(userStockPositionActual.getCostPrice());
		}
		if(userStockPositionActual.getProfitLoss() != null){
			sql.append(" profit_loss = ?, ");
			param.add(userStockPositionActual.getProfitLoss());
		}
		if(userStockPositionActual.getProfitLossRatio() != null){
			sql.append(" profit_loss_ratio = ?, ");
			param.add(userStockPositionActual.getProfitLossRatio());
		}
		if(userStockPositionActual.getCurrPrice() != null){
			sql.append(" curr_price = ?, ");
			param.add(userStockPositionActual.getCurrPrice());
		}
		if(userStockPositionActual.getTodayBuyNum() != null){
			sql.append(" today_buy_num = ?, ");
			param.add(userStockPositionActual.getTodayBuyNum());
		}
		if(userStockPositionActual.getTodaySellNum() != null){
			sql.append(" today_sell_num = ?, ");
			param.add(userStockPositionActual.getTodaySellNum());
		}
		if(userStockPositionActual.getCostAmount() != null){
			sql.append(" cost_amount = ?, ");
			param.add(userStockPositionActual.getCostAmount());
		}
		if(userStockPositionActual.getConvertedExchangeRate() != null){
			sql.append(" converted_exchange_rate = ?, ");
			param.add(userStockPositionActual.getConvertedExchangeRate());
		}
		if(userStockPositionActual.getShareholderCode() != null){
			sql.append(" shareholder_code = ?, ");
			param.add(userStockPositionActual.getShareholderCode());
		}
		if(userStockPositionActual.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userStockPositionActual.getCreateDate());
		}
		if(userStockPositionActual.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userStockPositionActual.getUpdateDate());
		}
		if(userStockPositionActual.getIsDel() != null){
			sql.append(" is_del = ?, ");
			param.add(userStockPositionActual.getIsDel());
		}
		if(userStockPositionActual.getRemark() != null){
			sql.append(" remark = ? ");
			param.add(userStockPositionActual.getRemark());
		}
		sql.append(" WHERE actual_position_id = ? ");
		param.add(userStockPositionActual.getActualPositionId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userStockPositionActuals
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserStockPositionActual> userStockPositionActuals){
		Map<String, Object>[] maps = new Map[userStockPositionActuals.size()];
		for(int i = 0; i < userStockPositionActuals.size(); i++){
			UserStockPositionActual userStockPositionActual = userStockPositionActuals.get(i);
			maps[i] = toMap(userStockPositionActual);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userStockPositionActual
	 * @return
	 */
	public Map<String, Object> toMap(UserStockPositionActual userStockPositionActual){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("actual_position_id", userStockPositionActual.getActualPositionId());
        paramMap.put("actual_type", userStockPositionActual.getActualType());
        paramMap.put("actual_date", userStockPositionActual.getActualDate());
        paramMap.put("stock_id", userStockPositionActual.getStockId());
        paramMap.put("stock_code", userStockPositionActual.getStockCode());
        paramMap.put("stock_name", userStockPositionActual.getStockName());
        paramMap.put("user_id", userStockPositionActual.getUserId());
        paramMap.put("group_id", userStockPositionActual.getGroupId());
        paramMap.put("group_detail_id", userStockPositionActual.getGroupDetailId());
        paramMap.put("stock_khh", userStockPositionActual.getStockKhh());
        paramMap.put("stock_num", userStockPositionActual.getStockNum());
        paramMap.put("sell_num", userStockPositionActual.getSellNum());
        paramMap.put("currency", userStockPositionActual.getCurrency());
        paramMap.put("cost_price", userStockPositionActual.getCostPrice());
        paramMap.put("profit_loss", userStockPositionActual.getProfitLoss());
        paramMap.put("profit_loss_ratio", userStockPositionActual.getProfitLossRatio());
        paramMap.put("curr_price", userStockPositionActual.getCurrPrice());
        paramMap.put("today_buy_num", userStockPositionActual.getTodayBuyNum());
        paramMap.put("today_sell_num", userStockPositionActual.getTodaySellNum());
        paramMap.put("cost_amount", userStockPositionActual.getCostAmount());
        paramMap.put("converted_exchange_rate", userStockPositionActual.getConvertedExchangeRate());
        paramMap.put("shareholder_code", userStockPositionActual.getShareholderCode());
        paramMap.put("create_date", userStockPositionActual.getCreateDate());
        paramMap.put("update_date", userStockPositionActual.getUpdateDate());
        paramMap.put("is_del", userStockPositionActual.getIsDel());
        paramMap.put("remark", userStockPositionActual.getRemark());
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
	public void delete(Long actualPositionId){
		jdbcTemplate.update(DELETE_SQL, actualPositionId);
	}

	@Override
	public void batchSave(List<UserStockPositionActual> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserStockPositionActual> list){
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
	 * @param actualPositionId 股票持仓ID
	 * @return UserStockPositionActual
	 */
	@Override
	public UserStockPositionActual findById(Long actualPositionId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`actual_position_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserStockPositionActual.class), actualPositionId);
	}

	/**
	 * 根据对象查询
	 * @param userStockPositionActual
	 * @return List
	 */
	@Override
	public List<UserStockPositionActual> find(UserStockPositionActual userStockPositionActual){
		return this.find(userStockPositionActual, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userStockPositionActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserStockPositionActual> find(UserStockPositionActual userStockPositionActual, String[][] orders){
		return this.find(userStockPositionActual, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userStockPositionActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserStockPositionActual> find(UserStockPositionActual userStockPositionActual, Long offset, Long rows){
		return this.find(userStockPositionActual, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userStockPositionActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserStockPositionActual> find(UserStockPositionActual userStockPositionActual, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userStockPositionActual != null){
			if(userStockPositionActual.getActualPositionId() != null){
				sql.append(" AND _this.`actual_position_id` = ?");
				param.add(userStockPositionActual.getActualPositionId());
			}
			if(userStockPositionActual.getActualType() != null && !"".equals(userStockPositionActual.getActualType())){
				sql.append(" AND _this.`actual_type` = ?");
				param.add(userStockPositionActual.getActualType());
			}
			if(userStockPositionActual.getActualDate() != null){
				sql.append(" AND _this.`actual_date` = ?");
				param.add(userStockPositionActual.getActualDate());
			}
			if(userStockPositionActual.getStockId() != null){
				sql.append(" AND _this.`stock_id` = ?");
				param.add(userStockPositionActual.getStockId());
			}
			if(userStockPositionActual.getStockCode() != null && !"".equals(userStockPositionActual.getStockCode())){
				sql.append(" AND _this.`stock_code` = ?");
				param.add(userStockPositionActual.getStockCode());
			}
			if(userStockPositionActual.getStockName() != null && !"".equals(userStockPositionActual.getStockName())){
				sql.append(" AND _this.`stock_name` = ?");
				param.add(userStockPositionActual.getStockName());
			}
			if(userStockPositionActual.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userStockPositionActual.getUserId());
			}
			if(userStockPositionActual.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(userStockPositionActual.getGroupId());
			}
			if(userStockPositionActual.getGroupDetailId() != null){
				sql.append(" AND _this.`group_detail_id` = ?");
				param.add(userStockPositionActual.getGroupDetailId());
			}
			if(userStockPositionActual.getStockKhh() != null && !"".equals(userStockPositionActual.getStockKhh())){
				sql.append(" AND _this.`stock_khh` = ?");
				param.add(userStockPositionActual.getStockKhh());
			}
			if(userStockPositionActual.getStockNum() != null){
				sql.append(" AND _this.`stock_num` = ?");
				param.add(userStockPositionActual.getStockNum());
			}
			if(userStockPositionActual.getSellNum() != null){
				sql.append(" AND _this.`sell_num` = ?");
				param.add(userStockPositionActual.getSellNum());
			}
			if(userStockPositionActual.getCurrency() != null && !"".equals(userStockPositionActual.getCurrency())){
				sql.append(" AND _this.`currency` = ?");
				param.add(userStockPositionActual.getCurrency());
			}
			if(userStockPositionActual.getTodayBuyNum() != null){
				sql.append(" AND _this.`today_buy_num` = ?");
				param.add(userStockPositionActual.getTodayBuyNum());
			}
			if(userStockPositionActual.getTodaySellNum() != null){
				sql.append(" AND _this.`today_sell_num` = ?");
				param.add(userStockPositionActual.getTodaySellNum());
			}
			if(userStockPositionActual.getShareholderCode() != null && !"".equals(userStockPositionActual.getShareholderCode())){
				sql.append(" AND _this.`shareholder_code` = ?");
				param.add(userStockPositionActual.getShareholderCode());
			}
			if(userStockPositionActual.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userStockPositionActual.getCreateDate());
			}
			if(userStockPositionActual.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userStockPositionActual.getUpdateDate());
			}
			if(userStockPositionActual.getIsDel() != null && !"".equals(userStockPositionActual.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(userStockPositionActual.getIsDel());
			}
			if(userStockPositionActual.getRemark() != null && !"".equals(userStockPositionActual.getRemark())){
				sql.append(" AND _this.`remark` = ?");
				param.add(userStockPositionActual.getRemark());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserStockPositionActual.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userStockPositionActual
	 * @return Long
	 */
	@Override
	public Long count(UserStockPositionActual userStockPositionActual){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_user_stock_position_actual  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userStockPositionActual != null){
			if(userStockPositionActual.getActualPositionId() != null){
				sql.append(" AND _this.`actual_position_id` = ? ");
				param.add(userStockPositionActual.getActualPositionId());
			}
			if(userStockPositionActual.getActualType() != null && !"".equals(userStockPositionActual.getActualType())){
				sql.append(" AND _this.`actual_type` = ? ");
				param.add(userStockPositionActual.getActualType());
			}
			if(userStockPositionActual.getActualDate() != null){
				sql.append(" AND _this.`actual_date` = ? ");
				param.add(userStockPositionActual.getActualDate());
			}
			if(userStockPositionActual.getStockId() != null){
				sql.append(" AND _this.`stock_id` = ? ");
				param.add(userStockPositionActual.getStockId());
			}
			if(userStockPositionActual.getStockCode() != null && !"".equals(userStockPositionActual.getStockCode())){
				sql.append(" AND _this.`stock_code` = ? ");
				param.add(userStockPositionActual.getStockCode());
			}
			if(userStockPositionActual.getStockName() != null && !"".equals(userStockPositionActual.getStockName())){
				sql.append(" AND _this.`stock_name` = ? ");
				param.add(userStockPositionActual.getStockName());
			}
			if(userStockPositionActual.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userStockPositionActual.getUserId());
			}
			if(userStockPositionActual.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(userStockPositionActual.getGroupId());
			}
			if(userStockPositionActual.getGroupDetailId() != null){
				sql.append(" AND _this.`group_detail_id` = ? ");
				param.add(userStockPositionActual.getGroupDetailId());
			}
			if(userStockPositionActual.getStockKhh() != null && !"".equals(userStockPositionActual.getStockKhh())){
				sql.append(" AND _this.`stock_khh` = ? ");
				param.add(userStockPositionActual.getStockKhh());
			}
			if(userStockPositionActual.getStockNum() != null){
				sql.append(" AND _this.`stock_num` = ? ");
				param.add(userStockPositionActual.getStockNum());
			}
			if(userStockPositionActual.getSellNum() != null){
				sql.append(" AND _this.`sell_num` = ? ");
				param.add(userStockPositionActual.getSellNum());
			}
			if(userStockPositionActual.getCurrency() != null && !"".equals(userStockPositionActual.getCurrency())){
				sql.append(" AND _this.`currency` = ? ");
				param.add(userStockPositionActual.getCurrency());
			}
			if(userStockPositionActual.getTodayBuyNum() != null){
				sql.append(" AND _this.`today_buy_num` = ? ");
				param.add(userStockPositionActual.getTodayBuyNum());
			}
			if(userStockPositionActual.getTodaySellNum() != null){
				sql.append(" AND _this.`today_sell_num` = ? ");
				param.add(userStockPositionActual.getTodaySellNum());
			}
			if(userStockPositionActual.getShareholderCode() != null && !"".equals(userStockPositionActual.getShareholderCode())){
				sql.append(" AND _this.`shareholder_code` = ? ");
				param.add(userStockPositionActual.getShareholderCode());
			}
			if(userStockPositionActual.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userStockPositionActual.getCreateDate());
			}
			if(userStockPositionActual.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userStockPositionActual.getUpdateDate());
			}
			if(userStockPositionActual.getIsDel() != null && !"".equals(userStockPositionActual.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(userStockPositionActual.getIsDel());
			}
			if(userStockPositionActual.getRemark() != null && !"".equals(userStockPositionActual.getRemark())){
				sql.append(" AND _this.`remark` = ? ");
				param.add(userStockPositionActual.getRemark());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}