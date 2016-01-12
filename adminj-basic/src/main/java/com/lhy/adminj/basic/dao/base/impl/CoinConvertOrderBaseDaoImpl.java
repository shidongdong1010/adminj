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

import com.lhy.adminj.basic.dao.base.CoinConvertOrderBaseDao;
import com.lhy.adminj.basic.model.CoinConvertOrder;

/**
 * 兑换订单表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CoinConvertOrderBaseDaoImpl implements CoinConvertOrderBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`order_no`, _this.`order_time`, _this.`order_status`, _this.`user_id`, _this.`user_name`, _this.`user_mobile`, _this.`good_id`, _this.`good_name`, _this.`good_summary`, _this.`pay_coin`, _this.`num`, _this.`express_no`, _this.`express_type`, _this.`express_name`, _this.`express_addr`, _this.`express_mobile`, _this.`status`, _this.`zip_code`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`order_no`, _this.`order_time`, _this.`order_status`, _this.`user_id`, _this.`user_name`, _this.`user_mobile`, _this.`good_id`, _this.`good_name`, _this.`good_summary`, _this.`pay_coin`, _this.`num`, _this.`express_no`, _this.`express_type`, _this.`express_name`, _this.`express_addr`, _this.`express_mobile`, _this.`status`, _this.`zip_code` FROM umc_coin_convert_order _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_coin_convert_order(`id`, `order_no`, `order_time`, `order_status`, `user_id`, `user_name`, `user_mobile`, `good_id`, `good_name`, `good_summary`, `pay_coin`, `num`, `express_no`, `express_type`, `express_name`, `express_addr`, `express_mobile`, `status`, `zip_code`) VALUES (:id, :order_no, :order_time, :order_status, :user_id, :user_name, :user_mobile, :good_id, :good_name, :good_summary, :pay_coin, :num, :express_no, :express_type, :express_name, :express_addr, :express_mobile, :status, :zip_code)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_coin_convert_order SET `id` = :id, `order_no` = :order_no, `order_time` = :order_time, `order_status` = :order_status, `user_id` = :user_id, `user_name` = :user_name, `user_mobile` = :user_mobile, `good_id` = :good_id, `good_name` = :good_name, `good_summary` = :good_summary, `pay_coin` = :pay_coin, `num` = :num, `express_no` = :express_no, `express_type` = :express_type, `express_name` = :express_name, `express_addr` = :express_addr, `express_mobile` = :express_mobile, `status` = :status, `zip_code` = :zip_code WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_coin_convert_order WHERE `id` = ?";

	@Override
	public void save(CoinConvertOrder coinConvertOrder) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(coinConvertOrder);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		coinConvertOrder.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(CoinConvertOrder coinConvertOrder) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(coinConvertOrder);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(CoinConvertOrder coinConvertOrder) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_coin_convert_order SET ");
		if(coinConvertOrder.getId() != null){
			sql.append(" id = ?, ");
			param.add(coinConvertOrder.getId());
		}
		if(coinConvertOrder.getOrderNo() != null){
			sql.append(" order_no = ?, ");
			param.add(coinConvertOrder.getOrderNo());
		}
		if(coinConvertOrder.getOrderTime() != null){
			sql.append(" order_time = ?, ");
			param.add(coinConvertOrder.getOrderTime());
		}
		if(coinConvertOrder.getOrderStatus() != null){
			sql.append(" order_status = ?, ");
			param.add(coinConvertOrder.getOrderStatus());
		}
		if(coinConvertOrder.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(coinConvertOrder.getUserId());
		}
		if(coinConvertOrder.getUserName() != null){
			sql.append(" user_name = ?, ");
			param.add(coinConvertOrder.getUserName());
		}
		if(coinConvertOrder.getUserMobile() != null){
			sql.append(" user_mobile = ?, ");
			param.add(coinConvertOrder.getUserMobile());
		}
		if(coinConvertOrder.getGoodId() != null){
			sql.append(" good_id = ?, ");
			param.add(coinConvertOrder.getGoodId());
		}
		if(coinConvertOrder.getGoodName() != null){
			sql.append(" good_name = ?, ");
			param.add(coinConvertOrder.getGoodName());
		}
		if(coinConvertOrder.getGoodSummary() != null){
			sql.append(" good_summary = ?, ");
			param.add(coinConvertOrder.getGoodSummary());
		}
		if(coinConvertOrder.getPayCoin() != null){
			sql.append(" pay_coin = ?, ");
			param.add(coinConvertOrder.getPayCoin());
		}
		if(coinConvertOrder.getNum() != null){
			sql.append(" num = ?, ");
			param.add(coinConvertOrder.getNum());
		}
		if(coinConvertOrder.getExpressNo() != null){
			sql.append(" express_no = ?, ");
			param.add(coinConvertOrder.getExpressNo());
		}
		if(coinConvertOrder.getExpressType() != null){
			sql.append(" express_type = ?, ");
			param.add(coinConvertOrder.getExpressType());
		}
		if(coinConvertOrder.getExpressName() != null){
			sql.append(" express_name = ?, ");
			param.add(coinConvertOrder.getExpressName());
		}
		if(coinConvertOrder.getExpressAddr() != null){
			sql.append(" express_addr = ?, ");
			param.add(coinConvertOrder.getExpressAddr());
		}
		if(coinConvertOrder.getExpressMobile() != null){
			sql.append(" express_mobile = ?, ");
			param.add(coinConvertOrder.getExpressMobile());
		}
		if(coinConvertOrder.getStatus() != null){
			sql.append(" status = ?, ");
			param.add(coinConvertOrder.getStatus());
		}
		if(coinConvertOrder.getZipCode() != null){
			sql.append(" zip_code = ? ");
			param.add(coinConvertOrder.getZipCode());
		}
		sql.append(" WHERE id = ? ");
		param.add(coinConvertOrder.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param coinConvertOrders
	 * @return
	 */
	public Map<String, Object>[] toMap(List<CoinConvertOrder> coinConvertOrders){
		Map<String, Object>[] maps = new Map[coinConvertOrders.size()];
		for(int i = 0; i < coinConvertOrders.size(); i++){
			CoinConvertOrder coinConvertOrder = coinConvertOrders.get(i);
			maps[i] = toMap(coinConvertOrder);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param coinConvertOrder
	 * @return
	 */
	public Map<String, Object> toMap(CoinConvertOrder coinConvertOrder){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", coinConvertOrder.getId());
        paramMap.put("order_no", coinConvertOrder.getOrderNo());
        paramMap.put("order_time", coinConvertOrder.getOrderTime());
        paramMap.put("order_status", coinConvertOrder.getOrderStatus());
        paramMap.put("user_id", coinConvertOrder.getUserId());
        paramMap.put("user_name", coinConvertOrder.getUserName());
        paramMap.put("user_mobile", coinConvertOrder.getUserMobile());
        paramMap.put("good_id", coinConvertOrder.getGoodId());
        paramMap.put("good_name", coinConvertOrder.getGoodName());
        paramMap.put("good_summary", coinConvertOrder.getGoodSummary());
        paramMap.put("pay_coin", coinConvertOrder.getPayCoin());
        paramMap.put("num", coinConvertOrder.getNum());
        paramMap.put("express_no", coinConvertOrder.getExpressNo());
        paramMap.put("express_type", coinConvertOrder.getExpressType());
        paramMap.put("express_name", coinConvertOrder.getExpressName());
        paramMap.put("express_addr", coinConvertOrder.getExpressAddr());
        paramMap.put("express_mobile", coinConvertOrder.getExpressMobile());
        paramMap.put("status", coinConvertOrder.getStatus());
        paramMap.put("zip_code", coinConvertOrder.getZipCode());
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
	public void delete(Long id){
		jdbcTemplate.update(DELETE_SQL, id);
	}

	@Override
	public void batchSave(List<CoinConvertOrder> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<CoinConvertOrder> list){
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
	 * @param id 
	 * @return CoinConvertOrder
	 */
	@Override
	public CoinConvertOrder findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(CoinConvertOrder.class), id);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertOrder
	 * @return List
	 */
	@Override
	public List<CoinConvertOrder> find(CoinConvertOrder coinConvertOrder){
		return this.find(coinConvertOrder, null, null);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertOrder
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<CoinConvertOrder> find(CoinConvertOrder coinConvertOrder, String[][] orders){
		return this.find(coinConvertOrder, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertOrder
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<CoinConvertOrder> find(CoinConvertOrder coinConvertOrder, Long offset, Long rows){
		return this.find(coinConvertOrder, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertOrder
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<CoinConvertOrder> find(CoinConvertOrder coinConvertOrder, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(coinConvertOrder != null){
			if(coinConvertOrder.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(coinConvertOrder.getId());
			}
			if(coinConvertOrder.getOrderNo() != null && !"".equals(coinConvertOrder.getOrderNo())){
				sql.append(" AND _this.`order_no` = ?");
				param.add(coinConvertOrder.getOrderNo());
			}
			if(coinConvertOrder.getOrderTime() != null){
				sql.append(" AND _this.`order_time` = ?");
				param.add(coinConvertOrder.getOrderTime());
			}
			if(coinConvertOrder.getOrderStatus() != null){
				sql.append(" AND _this.`order_status` = ?");
				param.add(coinConvertOrder.getOrderStatus());
			}
			if(coinConvertOrder.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(coinConvertOrder.getUserId());
			}
			if(coinConvertOrder.getUserName() != null && !"".equals(coinConvertOrder.getUserName())){
				sql.append(" AND _this.`user_name` = ?");
				param.add(coinConvertOrder.getUserName());
			}
			if(coinConvertOrder.getUserMobile() != null && !"".equals(coinConvertOrder.getUserMobile())){
				sql.append(" AND _this.`user_mobile` = ?");
				param.add(coinConvertOrder.getUserMobile());
			}
			if(coinConvertOrder.getGoodId() != null){
				sql.append(" AND _this.`good_id` = ?");
				param.add(coinConvertOrder.getGoodId());
			}
			if(coinConvertOrder.getGoodName() != null && !"".equals(coinConvertOrder.getGoodName())){
				sql.append(" AND _this.`good_name` = ?");
				param.add(coinConvertOrder.getGoodName());
			}
			if(coinConvertOrder.getGoodSummary() != null && !"".equals(coinConvertOrder.getGoodSummary())){
				sql.append(" AND _this.`good_summary` = ?");
				param.add(coinConvertOrder.getGoodSummary());
			}
			if(coinConvertOrder.getNum() != null){
				sql.append(" AND _this.`num` = ?");
				param.add(coinConvertOrder.getNum());
			}
			if(coinConvertOrder.getExpressNo() != null && !"".equals(coinConvertOrder.getExpressNo())){
				sql.append(" AND _this.`express_no` = ?");
				param.add(coinConvertOrder.getExpressNo());
			}
			if(coinConvertOrder.getExpressType() != null){
				sql.append(" AND _this.`express_type` = ?");
				param.add(coinConvertOrder.getExpressType());
			}
			if(coinConvertOrder.getExpressName() != null && !"".equals(coinConvertOrder.getExpressName())){
				sql.append(" AND _this.`express_name` = ?");
				param.add(coinConvertOrder.getExpressName());
			}
			if(coinConvertOrder.getExpressAddr() != null && !"".equals(coinConvertOrder.getExpressAddr())){
				sql.append(" AND _this.`express_addr` = ?");
				param.add(coinConvertOrder.getExpressAddr());
			}
			if(coinConvertOrder.getExpressMobile() != null && !"".equals(coinConvertOrder.getExpressMobile())){
				sql.append(" AND _this.`express_mobile` = ?");
				param.add(coinConvertOrder.getExpressMobile());
			}
			if(coinConvertOrder.getStatus() != null){
				sql.append(" AND _this.`status` = ?");
				param.add(coinConvertOrder.getStatus());
			}
			if(coinConvertOrder.getZipCode() != null && !"".equals(coinConvertOrder.getZipCode())){
				sql.append(" AND _this.`zip_code` = ?");
				param.add(coinConvertOrder.getZipCode());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(CoinConvertOrder.class));
	}


	/**
	 * 根据对象查询条数
	 * @param coinConvertOrder
	 * @return Long
	 */
	@Override
	public Long count(CoinConvertOrder coinConvertOrder){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_coin_convert_order  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(coinConvertOrder != null){
			if(coinConvertOrder.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(coinConvertOrder.getId());
			}
			if(coinConvertOrder.getOrderNo() != null && !"".equals(coinConvertOrder.getOrderNo())){
				sql.append(" AND _this.`order_no` = ? ");
				param.add(coinConvertOrder.getOrderNo());
			}
			if(coinConvertOrder.getOrderTime() != null){
				sql.append(" AND _this.`order_time` = ? ");
				param.add(coinConvertOrder.getOrderTime());
			}
			if(coinConvertOrder.getOrderStatus() != null){
				sql.append(" AND _this.`order_status` = ? ");
				param.add(coinConvertOrder.getOrderStatus());
			}
			if(coinConvertOrder.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(coinConvertOrder.getUserId());
			}
			if(coinConvertOrder.getUserName() != null && !"".equals(coinConvertOrder.getUserName())){
				sql.append(" AND _this.`user_name` = ? ");
				param.add(coinConvertOrder.getUserName());
			}
			if(coinConvertOrder.getUserMobile() != null && !"".equals(coinConvertOrder.getUserMobile())){
				sql.append(" AND _this.`user_mobile` = ? ");
				param.add(coinConvertOrder.getUserMobile());
			}
			if(coinConvertOrder.getGoodId() != null){
				sql.append(" AND _this.`good_id` = ? ");
				param.add(coinConvertOrder.getGoodId());
			}
			if(coinConvertOrder.getGoodName() != null && !"".equals(coinConvertOrder.getGoodName())){
				sql.append(" AND _this.`good_name` = ? ");
				param.add(coinConvertOrder.getGoodName());
			}
			if(coinConvertOrder.getGoodSummary() != null && !"".equals(coinConvertOrder.getGoodSummary())){
				sql.append(" AND _this.`good_summary` = ? ");
				param.add(coinConvertOrder.getGoodSummary());
			}
			if(coinConvertOrder.getNum() != null){
				sql.append(" AND _this.`num` = ? ");
				param.add(coinConvertOrder.getNum());
			}
			if(coinConvertOrder.getExpressNo() != null && !"".equals(coinConvertOrder.getExpressNo())){
				sql.append(" AND _this.`express_no` = ? ");
				param.add(coinConvertOrder.getExpressNo());
			}
			if(coinConvertOrder.getExpressType() != null){
				sql.append(" AND _this.`express_type` = ? ");
				param.add(coinConvertOrder.getExpressType());
			}
			if(coinConvertOrder.getExpressName() != null && !"".equals(coinConvertOrder.getExpressName())){
				sql.append(" AND _this.`express_name` = ? ");
				param.add(coinConvertOrder.getExpressName());
			}
			if(coinConvertOrder.getExpressAddr() != null && !"".equals(coinConvertOrder.getExpressAddr())){
				sql.append(" AND _this.`express_addr` = ? ");
				param.add(coinConvertOrder.getExpressAddr());
			}
			if(coinConvertOrder.getExpressMobile() != null && !"".equals(coinConvertOrder.getExpressMobile())){
				sql.append(" AND _this.`express_mobile` = ? ");
				param.add(coinConvertOrder.getExpressMobile());
			}
			if(coinConvertOrder.getStatus() != null){
				sql.append(" AND _this.`status` = ? ");
				param.add(coinConvertOrder.getStatus());
			}
			if(coinConvertOrder.getZipCode() != null && !"".equals(coinConvertOrder.getZipCode())){
				sql.append(" AND _this.`zip_code` = ? ");
				param.add(coinConvertOrder.getZipCode());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}