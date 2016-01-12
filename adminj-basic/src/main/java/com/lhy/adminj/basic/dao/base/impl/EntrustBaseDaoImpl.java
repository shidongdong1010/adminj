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

import com.lhy.adminj.basic.dao.base.EntrustBaseDao;
import com.lhy.adminj.basic.model.Entrust;

/**
 * 股票委托表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class EntrustBaseDaoImpl implements EntrustBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void save(Entrust entrust) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO tmc_entrust ");
		sql.append("   (  ");
		sql.append("		entrust_id,  ");
		sql.append("		stock_id,  ");
		sql.append("		stock_code,  ");
		sql.append("		stock_number,  ");
		sql.append("		entrust_price,  ");
		sql.append("		entrust_date,  ");
		sql.append("		entrust_style,  ");
		sql.append("		buy_one,  ");
		sql.append("		buy_one_pri,  ");
		sql.append("		buy_two,  ");
		sql.append("		buy_two_pri,  ");
		sql.append("		buy_thre,  ");
		sql.append("		buy_three_pri,  ");
		sql.append("		buy_four,  ");
		sql.append("		buy_four_pri,  ");
		sql.append("		buy_five,  ");
		sql.append("		buy_five_pri,  ");
		sql.append("		sell_one,  ");
		sql.append("		sell_one_pri,  ");
		sql.append("		sell_two,  ");
		sql.append("		sell_two_pri,  ");
		sql.append("		sell_thre,  ");
		sql.append("		sell_three_pri,  ");
		sql.append("		sell_four,  ");
		sql.append("		sell_four_pri,  ");
		sql.append("		sell_five,  ");
		sql.append("		sell_five_pri,  ");
		sql.append("		creat_date,  ");
		sql.append("		creator,  ");
		sql.append("		last_update_date,  ");
		sql.append("		last_updater,  ");
		sql.append("		dr  ");
		sql.append("   )  ");
		sql.append(" VALUES ");
		sql.append("   (  ");
		sql.append("		null,  ");
		sql.append("		:stock_id,  ");
		sql.append("		:stock_code,  ");
		sql.append("		:stock_number,  ");
		sql.append("		:entrust_price,  ");
		sql.append("		:entrust_date,  ");
		sql.append("		:entrust_style,  ");
		sql.append("		:buy_one,  ");
		sql.append("		:buy_one_pri,  ");
		sql.append("		:buy_two,  ");
		sql.append("		:buy_two_pri,  ");
		sql.append("		:buy_thre,  ");
		sql.append("		:buy_three_pri,  ");
		sql.append("		:buy_four,  ");
		sql.append("		:buy_four_pri,  ");
		sql.append("		:buy_five,  ");
		sql.append("		:buy_five_pri,  ");
		sql.append("		:sell_one,  ");
		sql.append("		:sell_one_pri,  ");
		sql.append("		:sell_two,  ");
		sql.append("		:sell_two_pri,  ");
		sql.append("		:sell_thre,  ");
		sql.append("		:sell_three_pri,  ");
		sql.append("		:sell_four,  ");
		sql.append("		:sell_four_pri,  ");
		sql.append("		:sell_five,  ");
		sql.append("		:sell_five_pri,  ");
		sql.append("		:creat_date,  ");
		sql.append("		:creator,  ");
		sql.append("		:last_update_date,  ");
		sql.append("		:last_updater,  ");
		sql.append("		:dr  ");
		sql.append("   )  ");

		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(entrust);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		entrust.setEntrustId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(Entrust entrust) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE tmc_entrust ");
		sql.append("    SET ");
        sql.append("        entrust_id     = :entrust_id, ");
        sql.append("        stock_id     = :stock_id, ");
        sql.append("        stock_code     = :stock_code, ");
        sql.append("        stock_number     = :stock_number, ");
        sql.append("        entrust_price     = :entrust_price, ");
        sql.append("        entrust_date     = :entrust_date, ");
        sql.append("        entrust_style     = :entrust_style, ");
        sql.append("        buy_one     = :buy_one, ");
        sql.append("        buy_one_pri     = :buy_one_pri, ");
        sql.append("        buy_two     = :buy_two, ");
        sql.append("        buy_two_pri     = :buy_two_pri, ");
        sql.append("        buy_thre     = :buy_thre, ");
        sql.append("        buy_three_pri     = :buy_three_pri, ");
        sql.append("        buy_four     = :buy_four, ");
        sql.append("        buy_four_pri     = :buy_four_pri, ");
        sql.append("        buy_five     = :buy_five, ");
        sql.append("        buy_five_pri     = :buy_five_pri, ");
        sql.append("        sell_one     = :sell_one, ");
        sql.append("        sell_one_pri     = :sell_one_pri, ");
        sql.append("        sell_two     = :sell_two, ");
        sql.append("        sell_two_pri     = :sell_two_pri, ");
        sql.append("        sell_thre     = :sell_thre, ");
        sql.append("        sell_three_pri     = :sell_three_pri, ");
        sql.append("        sell_four     = :sell_four, ");
        sql.append("        sell_four_pri     = :sell_four_pri, ");
        sql.append("        sell_five     = :sell_five, ");
        sql.append("        sell_five_pri     = :sell_five_pri, ");
        sql.append("        creat_date     = :creat_date, ");
        sql.append("        creator     = :creator, ");
        sql.append("        last_update_date     = :last_update_date, ");
        sql.append("        last_updater     = :last_updater, ");
    	sql.append("        dr     = :dr ");
		sql.append("  WHERE entrust_id = :entrust_id ");
		
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(entrust);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}
	
	/**
	 * 将对象转换成Map
	 * @param entrust
	 * @return
	 */
	public Map<String, Object> toMap(Entrust entrust){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("entrust_id", entrust.getEntrustId());
        paramMap.put("stock_id", entrust.getStockId());
        paramMap.put("stock_code", entrust.getStockCode());
        paramMap.put("stock_number", entrust.getStockNumber());
        paramMap.put("entrust_price", entrust.getEntrustPrice());
        paramMap.put("entrust_date", entrust.getEntrustDate());
        paramMap.put("entrust_style", entrust.getEntrustStyle());
        paramMap.put("buy_one", entrust.getBuyOne());
        paramMap.put("buy_one_pri", entrust.getBuyOnePri());
        paramMap.put("buy_two", entrust.getBuyTwo());
        paramMap.put("buy_two_pri", entrust.getBuyTwoPri());
        paramMap.put("buy_thre", entrust.getBuyThre());
        paramMap.put("buy_three_pri", entrust.getBuyThreePri());
        paramMap.put("buy_four", entrust.getBuyFour());
        paramMap.put("buy_four_pri", entrust.getBuyFourPri());
        paramMap.put("buy_five", entrust.getBuyFive());
        paramMap.put("buy_five_pri", entrust.getBuyFivePri());
        paramMap.put("sell_one", entrust.getSellOne());
        paramMap.put("sell_one_pri", entrust.getSellOnePri());
        paramMap.put("sell_two", entrust.getSellTwo());
        paramMap.put("sell_two_pri", entrust.getSellTwoPri());
        paramMap.put("sell_thre", entrust.getSellThre());
        paramMap.put("sell_three_pri", entrust.getSellThreePri());
        paramMap.put("sell_four", entrust.getSellFour());
        paramMap.put("sell_four_pri", entrust.getSellFourPri());
        paramMap.put("sell_five", entrust.getSellFive());
        paramMap.put("sell_five_pri", entrust.getSellFivePri());
        paramMap.put("creat_date", entrust.getCreatDate());
        paramMap.put("creator", entrust.getCreator());
        paramMap.put("last_update_date", entrust.getLastUpdateDate());
        paramMap.put("last_updater", entrust.getLastUpdater());
        paramMap.put("dr", entrust.getDr());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		StringBuilder sql = new StringBuilder();
        sql.append("entrust_id, ");
        sql.append("stock_id, ");
        sql.append("stock_code, ");
        sql.append("stock_number, ");
        sql.append("entrust_price, ");
        sql.append("entrust_date, ");
        sql.append("entrust_style, ");
        sql.append("buy_one, ");
        sql.append("buy_one_pri, ");
        sql.append("buy_two, ");
        sql.append("buy_two_pri, ");
        sql.append("buy_thre, ");
        sql.append("buy_three_pri, ");
        sql.append("buy_four, ");
        sql.append("buy_four_pri, ");
        sql.append("buy_five, ");
        sql.append("buy_five_pri, ");
        sql.append("sell_one, ");
        sql.append("sell_one_pri, ");
        sql.append("sell_two, ");
        sql.append("sell_two_pri, ");
        sql.append("sell_thre, ");
        sql.append("sell_three_pri, ");
        sql.append("sell_four, ");
        sql.append("sell_four_pri, ");
        sql.append("sell_five, ");
        sql.append("sell_five_pri, ");
        sql.append("creat_date, ");
        sql.append("creator, ");
        sql.append("last_update_date, ");
        sql.append("last_updater, ");
		sql.append("dr ");
		return sql.toString();
	}

	@Override
	public void delete(Long entrustId){
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM tmc_entrust ");
		sql.append(" WHERE entrust_id = ? ");

		jdbcTemplate.update(sql.toString(), entrustId);
	}

	/**
	 * 根据主键查询
	 * @param entrustId 股票委托表主键
	 * @return Entrust
	 */
	@Override
	public Entrust findById(Long entrustId){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM tmc_entrust ");
		sql.append(" WHERE entrust_id = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(Entrust.class), entrustId);
	}

	/**
	 * 根据对象查询
	 * @param entrust
	 * @return List
	 */
	@Override
	public List<Entrust> find(Entrust entrust){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM tmc_entrust ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(entrust != null && entrust.getEntrustId() != null){
			sql.append("  AND entrust_id = ? ");
			param.add(entrust.getEntrustId());
        }
        if(entrust != null && entrust.getStockId() != null){
			sql.append("  AND stock_id = ? ");
			param.add(entrust.getStockId());
        }
		if(entrust != null && entrust.getStockCode() != null && !"".equals(entrust.getStockCode())){
            sql.append("  AND stock_code = ? ");
			param.add(entrust.getStockCode());
		}
        if(entrust != null && entrust.getStockNumber() != null){
			sql.append("  AND stock_number = ? ");
			param.add(entrust.getStockNumber());
        }
        if(entrust != null && entrust.getEntrustDate() != null){
			sql.append("  AND entrust_date = ? ");
			param.add(entrust.getEntrustDate());
        }
		if(entrust != null && entrust.getEntrustStyle() != null && !"".equals(entrust.getEntrustStyle())){
            sql.append("  AND entrust_style = ? ");
			param.add(entrust.getEntrustStyle());
		}
        if(entrust != null && entrust.getBuyOne() != null){
			sql.append("  AND buy_one = ? ");
			param.add(entrust.getBuyOne());
        }
        if(entrust != null && entrust.getBuyTwo() != null){
			sql.append("  AND buy_two = ? ");
			param.add(entrust.getBuyTwo());
        }
        if(entrust != null && entrust.getBuyThre() != null){
			sql.append("  AND buy_thre = ? ");
			param.add(entrust.getBuyThre());
        }
        if(entrust != null && entrust.getBuyFour() != null){
			sql.append("  AND buy_four = ? ");
			param.add(entrust.getBuyFour());
        }
        if(entrust != null && entrust.getBuyFive() != null){
			sql.append("  AND buy_five = ? ");
			param.add(entrust.getBuyFive());
        }
        if(entrust != null && entrust.getSellOne() != null){
			sql.append("  AND sell_one = ? ");
			param.add(entrust.getSellOne());
        }
        if(entrust != null && entrust.getSellTwo() != null){
			sql.append("  AND sell_two = ? ");
			param.add(entrust.getSellTwo());
        }
        if(entrust != null && entrust.getSellThre() != null){
			sql.append("  AND sell_thre = ? ");
			param.add(entrust.getSellThre());
        }
        if(entrust != null && entrust.getSellFour() != null){
			sql.append("  AND sell_four = ? ");
			param.add(entrust.getSellFour());
        }
        if(entrust != null && entrust.getSellFive() != null){
			sql.append("  AND sell_five = ? ");
			param.add(entrust.getSellFive());
        }
        if(entrust != null && entrust.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(entrust.getCreatDate());
        }
        if(entrust != null && entrust.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(entrust.getCreator());
        }
        if(entrust != null && entrust.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(entrust.getLastUpdateDate());
        }
        if(entrust != null && entrust.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(entrust.getLastUpdater());
        }
        if(entrust != null && entrust.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(entrust.getDr());
        }
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Entrust.class));
	}

	/**
	 * 根据对象查询
	 * @param entrust
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Entrust> find(Entrust entrust, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM tmc_entrust ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(entrust != null && entrust.getEntrustId() != null){
			sql.append("  AND entrust_id = ? ");
			param.add(entrust.getEntrustId());
        }
        if(entrust != null && entrust.getStockId() != null){
			sql.append("  AND stock_id = ? ");
			param.add(entrust.getStockId());
        }
		if(entrust != null && entrust.getStockCode() != null && !"".equals(entrust.getStockCode())){
            sql.append("  AND stock_code = ? ");
			param.add(entrust.getStockCode());
		}
        if(entrust != null && entrust.getStockNumber() != null){
			sql.append("  AND stock_number = ? ");
			param.add(entrust.getStockNumber());
        }
        if(entrust != null && entrust.getEntrustDate() != null){
			sql.append("  AND entrust_date = ? ");
			param.add(entrust.getEntrustDate());
        }
		if(entrust != null && entrust.getEntrustStyle() != null && !"".equals(entrust.getEntrustStyle())){
            sql.append("  AND entrust_style = ? ");
			param.add(entrust.getEntrustStyle());
		}
        if(entrust != null && entrust.getBuyOne() != null){
			sql.append("  AND buy_one = ? ");
			param.add(entrust.getBuyOne());
        }
        if(entrust != null && entrust.getBuyTwo() != null){
			sql.append("  AND buy_two = ? ");
			param.add(entrust.getBuyTwo());
        }
        if(entrust != null && entrust.getBuyThre() != null){
			sql.append("  AND buy_thre = ? ");
			param.add(entrust.getBuyThre());
        }
        if(entrust != null && entrust.getBuyFour() != null){
			sql.append("  AND buy_four = ? ");
			param.add(entrust.getBuyFour());
        }
        if(entrust != null && entrust.getBuyFive() != null){
			sql.append("  AND buy_five = ? ");
			param.add(entrust.getBuyFive());
        }
        if(entrust != null && entrust.getSellOne() != null){
			sql.append("  AND sell_one = ? ");
			param.add(entrust.getSellOne());
        }
        if(entrust != null && entrust.getSellTwo() != null){
			sql.append("  AND sell_two = ? ");
			param.add(entrust.getSellTwo());
        }
        if(entrust != null && entrust.getSellThre() != null){
			sql.append("  AND sell_thre = ? ");
			param.add(entrust.getSellThre());
        }
        if(entrust != null && entrust.getSellFour() != null){
			sql.append("  AND sell_four = ? ");
			param.add(entrust.getSellFour());
        }
        if(entrust != null && entrust.getSellFive() != null){
			sql.append("  AND sell_five = ? ");
			param.add(entrust.getSellFive());
        }
        if(entrust != null && entrust.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(entrust.getCreatDate());
        }
        if(entrust != null && entrust.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(entrust.getCreator());
        }
        if(entrust != null && entrust.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(entrust.getLastUpdateDate());
        }
        if(entrust != null && entrust.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(entrust.getLastUpdater());
        }
        if(entrust != null && entrust.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(entrust.getDr());
        }
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Entrust.class));
	}

	/**
	 * 根据对象查询条数
	 * @param entrust
	 * @return Long
	 */
	@Override
	public Long count(Entrust entrust){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       count(*) ");
		sql.append("  FROM tmc_entrust ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(entrust != null && entrust.getEntrustId() != null){
			sql.append("  AND entrust_id = ? ");
			param.add(entrust.getEntrustId());
        }
        if(entrust != null && entrust.getStockId() != null){
			sql.append("  AND stock_id = ? ");
			param.add(entrust.getStockId());
        }
		if(entrust != null && entrust.getStockCode() != null && !"".equals(entrust.getStockCode())){
            sql.append("  AND stock_code = ? ");
			param.add(entrust.getStockCode());
		}
        if(entrust != null && entrust.getStockNumber() != null){
			sql.append("  AND stock_number = ? ");
			param.add(entrust.getStockNumber());
        }
        if(entrust != null && entrust.getEntrustDate() != null){
			sql.append("  AND entrust_date = ? ");
			param.add(entrust.getEntrustDate());
        }
		if(entrust != null && entrust.getEntrustStyle() != null && !"".equals(entrust.getEntrustStyle())){
            sql.append("  AND entrust_style = ? ");
			param.add(entrust.getEntrustStyle());
		}
        if(entrust != null && entrust.getBuyOne() != null){
			sql.append("  AND buy_one = ? ");
			param.add(entrust.getBuyOne());
        }
        if(entrust != null && entrust.getBuyTwo() != null){
			sql.append("  AND buy_two = ? ");
			param.add(entrust.getBuyTwo());
        }
        if(entrust != null && entrust.getBuyThre() != null){
			sql.append("  AND buy_thre = ? ");
			param.add(entrust.getBuyThre());
        }
        if(entrust != null && entrust.getBuyFour() != null){
			sql.append("  AND buy_four = ? ");
			param.add(entrust.getBuyFour());
        }
        if(entrust != null && entrust.getBuyFive() != null){
			sql.append("  AND buy_five = ? ");
			param.add(entrust.getBuyFive());
        }
        if(entrust != null && entrust.getSellOne() != null){
			sql.append("  AND sell_one = ? ");
			param.add(entrust.getSellOne());
        }
        if(entrust != null && entrust.getSellTwo() != null){
			sql.append("  AND sell_two = ? ");
			param.add(entrust.getSellTwo());
        }
        if(entrust != null && entrust.getSellThre() != null){
			sql.append("  AND sell_thre = ? ");
			param.add(entrust.getSellThre());
        }
        if(entrust != null && entrust.getSellFour() != null){
			sql.append("  AND sell_four = ? ");
			param.add(entrust.getSellFour());
        }
        if(entrust != null && entrust.getSellFive() != null){
			sql.append("  AND sell_five = ? ");
			param.add(entrust.getSellFive());
        }
        if(entrust != null && entrust.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(entrust.getCreatDate());
        }
        if(entrust != null && entrust.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(entrust.getCreator());
        }
        if(entrust != null && entrust.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(entrust.getLastUpdateDate());
        }
        if(entrust != null && entrust.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(entrust.getLastUpdater());
        }
        if(entrust != null && entrust.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(entrust.getDr());
        }
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}