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

import com.lhy.adminj.basic.dao.base.UserStockPositionBaseDao;
import com.lhy.adminj.basic.model.UserStockPosition;

/**
 * 股票持仓表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserStockPositionBaseDaoImpl implements UserStockPositionBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`position_id`, _this.`stock_id`, _this.`stock_code`, _this.`stock_name`, _this.`user_id`, _this.`group_id`, _this.`group_detail_id`, _this.`stock_khh`, _this.`stock_num`, _this.`sell_num`, _this.`currency`, _this.`cost_price`, _this.`profit_loss`, _this.`profit_loss_ratio`, _this.`curr_price`, _this.`today_buy_num`, _this.`today_sell_num`, _this.`cost_amount`, _this.`converted_exchange_rate`, _this.`shareholder_code`, _this.`create_date`, _this.`update_date`, _this.`is_del`, _this.`remark`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`position_id`, _this.`stock_id`, _this.`stock_code`, _this.`stock_name`, _this.`user_id`, _this.`group_id`, _this.`group_detail_id`, _this.`stock_khh`, _this.`stock_num`, _this.`sell_num`, _this.`currency`, _this.`cost_price`, _this.`profit_loss`, _this.`profit_loss_ratio`, _this.`curr_price`, _this.`today_buy_num`, _this.`today_sell_num`, _this.`cost_amount`, _this.`converted_exchange_rate`, _this.`shareholder_code`, _this.`create_date`, _this.`update_date`, _this.`is_del`, _this.`remark` FROM tmc_user_stock_position _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_user_stock_position(`position_id`, `stock_id`, `stock_code`, `stock_name`, `user_id`, `group_id`, `group_detail_id`, `stock_khh`, `stock_num`, `sell_num`, `currency`, `cost_price`, `profit_loss`, `profit_loss_ratio`, `curr_price`, `today_buy_num`, `today_sell_num`, `cost_amount`, `converted_exchange_rate`, `shareholder_code`, `create_date`, `update_date`, `is_del`, `remark`) VALUES (:position_id, :stock_id, :stock_code, :stock_name, :user_id, :group_id, :group_detail_id, :stock_khh, :stock_num, :sell_num, :currency, :cost_price, :profit_loss, :profit_loss_ratio, :curr_price, :today_buy_num, :today_sell_num, :cost_amount, :converted_exchange_rate, :shareholder_code, :create_date, :update_date, :is_del, :remark)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_user_stock_position SET `position_id` = :position_id, `stock_id` = :stock_id, `stock_code` = :stock_code, `stock_name` = :stock_name, `user_id` = :user_id, `group_id` = :group_id, `group_detail_id` = :group_detail_id, `stock_khh` = :stock_khh, `stock_num` = :stock_num, `sell_num` = :sell_num, `currency` = :currency, `cost_price` = :cost_price, `profit_loss` = :profit_loss, `profit_loss_ratio` = :profit_loss_ratio, `curr_price` = :curr_price, `today_buy_num` = :today_buy_num, `today_sell_num` = :today_sell_num, `cost_amount` = :cost_amount, `converted_exchange_rate` = :converted_exchange_rate, `shareholder_code` = :shareholder_code, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del, `remark` = :remark WHERE `position_id` = :position_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_user_stock_position WHERE `position_id` = ?";

	@Override
	public void save(UserStockPosition userStockPosition) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userStockPosition);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userStockPosition.setPositionId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserStockPosition userStockPosition) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userStockPosition);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserStockPosition userStockPosition) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_user_stock_position SET ");
		if(userStockPosition.getPositionId() != null){
			sql.append(" position_id = ?, ");
			param.add(userStockPosition.getPositionId());
		}
		if(userStockPosition.getStockId() != null){
			sql.append(" stock_id = ?, ");
			param.add(userStockPosition.getStockId());
		}
		if(userStockPosition.getStockCode() != null){
			sql.append(" stock_code = ?, ");
			param.add(userStockPosition.getStockCode());
		}
		if(userStockPosition.getStockName() != null){
			sql.append(" stock_name = ?, ");
			param.add(userStockPosition.getStockName());
		}
		if(userStockPosition.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userStockPosition.getUserId());
		}
		if(userStockPosition.getGroupId() != null){
			sql.append(" group_id = ?, ");
			param.add(userStockPosition.getGroupId());
		}
		if(userStockPosition.getGroupDetailId() != null){
			sql.append(" group_detail_id = ?, ");
			param.add(userStockPosition.getGroupDetailId());
		}
		if(userStockPosition.getStockKhh() != null){
			sql.append(" stock_khh = ?, ");
			param.add(userStockPosition.getStockKhh());
		}
		if(userStockPosition.getStockNum() != null){
			sql.append(" stock_num = ?, ");
			param.add(userStockPosition.getStockNum());
		}
		if(userStockPosition.getSellNum() != null){
			sql.append(" sell_num = ?, ");
			param.add(userStockPosition.getSellNum());
		}
		if(userStockPosition.getCurrency() != null){
			sql.append(" currency = ?, ");
			param.add(userStockPosition.getCurrency());
		}
		if(userStockPosition.getCostPrice() != null){
			sql.append(" cost_price = ?, ");
			param.add(userStockPosition.getCostPrice());
		}
		if(userStockPosition.getProfitLoss() != null){
			sql.append(" profit_loss = ?, ");
			param.add(userStockPosition.getProfitLoss());
		}
		if(userStockPosition.getProfitLossRatio() != null){
			sql.append(" profit_loss_ratio = ?, ");
			param.add(userStockPosition.getProfitLossRatio());
		}
		if(userStockPosition.getCurrPrice() != null){
			sql.append(" curr_price = ?, ");
			param.add(userStockPosition.getCurrPrice());
		}
		if(userStockPosition.getTodayBuyNum() != null){
			sql.append(" today_buy_num = ?, ");
			param.add(userStockPosition.getTodayBuyNum());
		}
		if(userStockPosition.getTodaySellNum() != null){
			sql.append(" today_sell_num = ?, ");
			param.add(userStockPosition.getTodaySellNum());
		}
		if(userStockPosition.getCostAmount() != null){
			sql.append(" cost_amount = ?, ");
			param.add(userStockPosition.getCostAmount());
		}
		if(userStockPosition.getConvertedExchangeRate() != null){
			sql.append(" converted_exchange_rate = ?, ");
			param.add(userStockPosition.getConvertedExchangeRate());
		}
		if(userStockPosition.getShareholderCode() != null){
			sql.append(" shareholder_code = ?, ");
			param.add(userStockPosition.getShareholderCode());
		}
		if(userStockPosition.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userStockPosition.getCreateDate());
		}
		if(userStockPosition.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userStockPosition.getUpdateDate());
		}
		if(userStockPosition.getIsDel() != null){
			sql.append(" is_del = ?, ");
			param.add(userStockPosition.getIsDel());
		}
		if(userStockPosition.getRemark() != null){
			sql.append(" remark = ? ");
			param.add(userStockPosition.getRemark());
		}
		sql.append(" WHERE position_id = ? ");
		param.add(userStockPosition.getPositionId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userStockPositions
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserStockPosition> userStockPositions){
		Map<String, Object>[] maps = new Map[userStockPositions.size()];
		for(int i = 0; i < userStockPositions.size(); i++){
			UserStockPosition userStockPosition = userStockPositions.get(i);
			maps[i] = toMap(userStockPosition);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userStockPosition
	 * @return
	 */
	public Map<String, Object> toMap(UserStockPosition userStockPosition){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("position_id", userStockPosition.getPositionId());
        paramMap.put("stock_id", userStockPosition.getStockId());
        paramMap.put("stock_code", userStockPosition.getStockCode());
        paramMap.put("stock_name", userStockPosition.getStockName());
        paramMap.put("user_id", userStockPosition.getUserId());
        paramMap.put("group_id", userStockPosition.getGroupId());
        paramMap.put("group_detail_id", userStockPosition.getGroupDetailId());
        paramMap.put("stock_khh", userStockPosition.getStockKhh());
        paramMap.put("stock_num", userStockPosition.getStockNum());
        paramMap.put("sell_num", userStockPosition.getSellNum());
        paramMap.put("currency", userStockPosition.getCurrency());
        paramMap.put("cost_price", userStockPosition.getCostPrice());
        paramMap.put("profit_loss", userStockPosition.getProfitLoss());
        paramMap.put("profit_loss_ratio", userStockPosition.getProfitLossRatio());
        paramMap.put("curr_price", userStockPosition.getCurrPrice());
        paramMap.put("today_buy_num", userStockPosition.getTodayBuyNum());
        paramMap.put("today_sell_num", userStockPosition.getTodaySellNum());
        paramMap.put("cost_amount", userStockPosition.getCostAmount());
        paramMap.put("converted_exchange_rate", userStockPosition.getConvertedExchangeRate());
        paramMap.put("shareholder_code", userStockPosition.getShareholderCode());
        paramMap.put("create_date", userStockPosition.getCreateDate());
        paramMap.put("update_date", userStockPosition.getUpdateDate());
        paramMap.put("is_del", userStockPosition.getIsDel());
        paramMap.put("remark", userStockPosition.getRemark());
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
	public void delete(Long positionId){
		jdbcTemplate.update(DELETE_SQL, positionId);
	}

	@Override
	public void batchSave(List<UserStockPosition> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserStockPosition> list){
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
	 * @param positionId 股票持仓ID
	 * @return UserStockPosition
	 */
	@Override
	public UserStockPosition findById(Long positionId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`position_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserStockPosition.class), positionId);
	}

	/**
	 * 根据对象查询
	 * @param userStockPosition
	 * @return List
	 */
	@Override
	public List<UserStockPosition> find(UserStockPosition userStockPosition){
		return this.find(userStockPosition, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userStockPosition
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserStockPosition> find(UserStockPosition userStockPosition, String[][] orders){
		return this.find(userStockPosition, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userStockPosition
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserStockPosition> find(UserStockPosition userStockPosition, Long offset, Long rows){
		return this.find(userStockPosition, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userStockPosition
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserStockPosition> find(UserStockPosition userStockPosition, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userStockPosition != null){
			if(userStockPosition.getPositionId() != null){
				sql.append(" AND _this.`position_id` = ?");
				param.add(userStockPosition.getPositionId());
			}
			if(userStockPosition.getStockId() != null){
				sql.append(" AND _this.`stock_id` = ?");
				param.add(userStockPosition.getStockId());
			}
			if(userStockPosition.getStockCode() != null && !"".equals(userStockPosition.getStockCode())){
				sql.append(" AND _this.`stock_code` = ?");
				param.add(userStockPosition.getStockCode());
			}
			if(userStockPosition.getStockName() != null && !"".equals(userStockPosition.getStockName())){
				sql.append(" AND _this.`stock_name` = ?");
				param.add(userStockPosition.getStockName());
			}
			if(userStockPosition.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userStockPosition.getUserId());
			}
			if(userStockPosition.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(userStockPosition.getGroupId());
			}
			if(userStockPosition.getGroupDetailId() != null){
				sql.append(" AND _this.`group_detail_id` = ?");
				param.add(userStockPosition.getGroupDetailId());
			}
			if(userStockPosition.getStockKhh() != null && !"".equals(userStockPosition.getStockKhh())){
				sql.append(" AND _this.`stock_khh` = ?");
				param.add(userStockPosition.getStockKhh());
			}
			if(userStockPosition.getStockNum() != null){
				sql.append(" AND _this.`stock_num` = ?");
				param.add(userStockPosition.getStockNum());
			}
			if(userStockPosition.getSellNum() != null){
				sql.append(" AND _this.`sell_num` = ?");
				param.add(userStockPosition.getSellNum());
			}
			if(userStockPosition.getCurrency() != null && !"".equals(userStockPosition.getCurrency())){
				sql.append(" AND _this.`currency` = ?");
				param.add(userStockPosition.getCurrency());
			}
			if(userStockPosition.getTodayBuyNum() != null){
				sql.append(" AND _this.`today_buy_num` = ?");
				param.add(userStockPosition.getTodayBuyNum());
			}
			if(userStockPosition.getTodaySellNum() != null){
				sql.append(" AND _this.`today_sell_num` = ?");
				param.add(userStockPosition.getTodaySellNum());
			}
			if(userStockPosition.getShareholderCode() != null && !"".equals(userStockPosition.getShareholderCode())){
				sql.append(" AND _this.`shareholder_code` = ?");
				param.add(userStockPosition.getShareholderCode());
			}
			if(userStockPosition.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userStockPosition.getCreateDate());
			}
			if(userStockPosition.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userStockPosition.getUpdateDate());
			}
			if(userStockPosition.getIsDel() != null && !"".equals(userStockPosition.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(userStockPosition.getIsDel());
			}
			if(userStockPosition.getRemark() != null && !"".equals(userStockPosition.getRemark())){
				sql.append(" AND _this.`remark` = ?");
				param.add(userStockPosition.getRemark());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserStockPosition.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userStockPosition
	 * @return Long
	 */
	@Override
	public Long count(UserStockPosition userStockPosition){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_user_stock_position  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userStockPosition != null){
			if(userStockPosition.getPositionId() != null){
				sql.append(" AND _this.`position_id` = ? ");
				param.add(userStockPosition.getPositionId());
			}
			if(userStockPosition.getStockId() != null){
				sql.append(" AND _this.`stock_id` = ? ");
				param.add(userStockPosition.getStockId());
			}
			if(userStockPosition.getStockCode() != null && !"".equals(userStockPosition.getStockCode())){
				sql.append(" AND _this.`stock_code` = ? ");
				param.add(userStockPosition.getStockCode());
			}
			if(userStockPosition.getStockName() != null && !"".equals(userStockPosition.getStockName())){
				sql.append(" AND _this.`stock_name` = ? ");
				param.add(userStockPosition.getStockName());
			}
			if(userStockPosition.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userStockPosition.getUserId());
			}
			if(userStockPosition.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(userStockPosition.getGroupId());
			}
			if(userStockPosition.getGroupDetailId() != null){
				sql.append(" AND _this.`group_detail_id` = ? ");
				param.add(userStockPosition.getGroupDetailId());
			}
			if(userStockPosition.getStockKhh() != null && !"".equals(userStockPosition.getStockKhh())){
				sql.append(" AND _this.`stock_khh` = ? ");
				param.add(userStockPosition.getStockKhh());
			}
			if(userStockPosition.getStockNum() != null){
				sql.append(" AND _this.`stock_num` = ? ");
				param.add(userStockPosition.getStockNum());
			}
			if(userStockPosition.getSellNum() != null){
				sql.append(" AND _this.`sell_num` = ? ");
				param.add(userStockPosition.getSellNum());
			}
			if(userStockPosition.getCurrency() != null && !"".equals(userStockPosition.getCurrency())){
				sql.append(" AND _this.`currency` = ? ");
				param.add(userStockPosition.getCurrency());
			}
			if(userStockPosition.getTodayBuyNum() != null){
				sql.append(" AND _this.`today_buy_num` = ? ");
				param.add(userStockPosition.getTodayBuyNum());
			}
			if(userStockPosition.getTodaySellNum() != null){
				sql.append(" AND _this.`today_sell_num` = ? ");
				param.add(userStockPosition.getTodaySellNum());
			}
			if(userStockPosition.getShareholderCode() != null && !"".equals(userStockPosition.getShareholderCode())){
				sql.append(" AND _this.`shareholder_code` = ? ");
				param.add(userStockPosition.getShareholderCode());
			}
			if(userStockPosition.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userStockPosition.getCreateDate());
			}
			if(userStockPosition.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userStockPosition.getUpdateDate());
			}
			if(userStockPosition.getIsDel() != null && !"".equals(userStockPosition.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(userStockPosition.getIsDel());
			}
			if(userStockPosition.getRemark() != null && !"".equals(userStockPosition.getRemark())){
				sql.append(" AND _this.`remark` = ? ");
				param.add(userStockPosition.getRemark());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}