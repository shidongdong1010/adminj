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

import com.lhy.adminj.basic.dao.base.ResultContentBaseDao;
import com.lhy.adminj.basic.model.ResultContent;

/**
 * 实时交易表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class ResultContentBaseDaoImpl implements ResultContentBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void save(ResultContent resultContent) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO smc_result_content ");
		sql.append("   (  ");
		sql.append("		result_content_id,  ");
		sql.append("		gid,  ");
		sql.append("		bank_name,  ");
		sql.append("		today_start_pri,  ");
		sql.append("		yestod_end_pri,  ");
		sql.append("		now_pri,  ");
		sql.append("		today_max,  ");
		sql.append("		today_min,  ");
		sql.append("		competitive_pri,  ");
		sql.append("		reserve_pri,  ");
		sql.append("		tra_number,  ");
		sql.append("		tra_amount,  ");
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
		sql.append("		r_date,  ");
		sql.append("		r_time,  ");
		sql.append("		stock_name,  ");
		sql.append("		dot,  ");
		sql.append("		now_pic,  ");
		sql.append("		rate,  ");
		sql.append("		trad_number,  ");
		sql.append("		trad_amount,  ");
		sql.append("		minurl,  ");
		sql.append("		dayurl,  ");
		sql.append("		weekurl,  ");
		sql.append("		monthurl,  ");
		sql.append("		resultcod,  ");
		sql.append("		creat_date,  ");
		sql.append("		creator,  ");
		sql.append("		last_update_date,  ");
		sql.append("		last_updater,  ");
		sql.append("		dr  ");
		sql.append("   )  ");
		sql.append(" VALUES ");
		sql.append("   (  ");
		sql.append("		null,  ");
		sql.append("		:gid,  ");
		sql.append("		:bank_name,  ");
		sql.append("		:today_start_pri,  ");
		sql.append("		:yestod_end_pri,  ");
		sql.append("		:now_pri,  ");
		sql.append("		:today_max,  ");
		sql.append("		:today_min,  ");
		sql.append("		:competitive_pri,  ");
		sql.append("		:reserve_pri,  ");
		sql.append("		:tra_number,  ");
		sql.append("		:tra_amount,  ");
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
		sql.append("		:r_date,  ");
		sql.append("		:r_time,  ");
		sql.append("		:stock_name,  ");
		sql.append("		:dot,  ");
		sql.append("		:now_pic,  ");
		sql.append("		:rate,  ");
		sql.append("		:trad_number,  ");
		sql.append("		:trad_amount,  ");
		sql.append("		:minurl,  ");
		sql.append("		:dayurl,  ");
		sql.append("		:weekurl,  ");
		sql.append("		:monthurl,  ");
		sql.append("		:resultcod,  ");
		sql.append("		:creat_date,  ");
		sql.append("		:creator,  ");
		sql.append("		:last_update_date,  ");
		sql.append("		:last_updater,  ");
		sql.append("		:dr  ");
		sql.append("   )  ");

		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(resultContent);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		resultContent.setResultContentId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(ResultContent resultContent) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE smc_result_content ");
		sql.append("    SET ");
        sql.append("        result_content_id     = :result_content_id, ");
        sql.append("        gid     = :gid, ");
        sql.append("        bank_name     = :bank_name, ");
        sql.append("        today_start_pri     = :today_start_pri, ");
        sql.append("        yestod_end_pri     = :yestod_end_pri, ");
        sql.append("        now_pri     = :now_pri, ");
        sql.append("        today_max     = :today_max, ");
        sql.append("        today_min     = :today_min, ");
        sql.append("        competitive_pri     = :competitive_pri, ");
        sql.append("        reserve_pri     = :reserve_pri, ");
        sql.append("        tra_number     = :tra_number, ");
        sql.append("        tra_amount     = :tra_amount, ");
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
        sql.append("        r_date     = :r_date, ");
        sql.append("        r_time     = :r_time, ");
        sql.append("        stock_name     = :stock_name, ");
        sql.append("        dot     = :dot, ");
        sql.append("        now_pic     = :now_pic, ");
        sql.append("        rate     = :rate, ");
        sql.append("        trad_number     = :trad_number, ");
        sql.append("        trad_amount     = :trad_amount, ");
        sql.append("        minurl     = :minurl, ");
        sql.append("        dayurl     = :dayurl, ");
        sql.append("        weekurl     = :weekurl, ");
        sql.append("        monthurl     = :monthurl, ");
        sql.append("        resultcod     = :resultcod, ");
        sql.append("        creat_date     = :creat_date, ");
        sql.append("        creator     = :creator, ");
        sql.append("        last_update_date     = :last_update_date, ");
        sql.append("        last_updater     = :last_updater, ");
    	sql.append("        dr     = :dr ");
		sql.append("  WHERE result_content_id = :result_content_id ");
		
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(resultContent);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}
	
	/**
	 * 将对象转换成Map
	 * @param resultContent
	 * @return
	 */
	public Map<String, Object> toMap(ResultContent resultContent){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("result_content_id", resultContent.getResultContentId());
        paramMap.put("gid", resultContent.getGid());
        paramMap.put("bank_name", resultContent.getBankName());
        paramMap.put("today_start_pri", resultContent.getTodayStartPri());
        paramMap.put("yestod_end_pri", resultContent.getYestodEndPri());
        paramMap.put("now_pri", resultContent.getNowPri());
        paramMap.put("today_max", resultContent.getTodayMax());
        paramMap.put("today_min", resultContent.getTodayMin());
        paramMap.put("competitive_pri", resultContent.getCompetitivePri());
        paramMap.put("reserve_pri", resultContent.getReservePri());
        paramMap.put("tra_number", resultContent.getTraNumber());
        paramMap.put("tra_amount", resultContent.getTraAmount());
        paramMap.put("buy_one", resultContent.getBuyOne());
        paramMap.put("buy_one_pri", resultContent.getBuyOnePri());
        paramMap.put("buy_two", resultContent.getBuyTwo());
        paramMap.put("buy_two_pri", resultContent.getBuyTwoPri());
        paramMap.put("buy_thre", resultContent.getBuyThre());
        paramMap.put("buy_three_pri", resultContent.getBuyThreePri());
        paramMap.put("buy_four", resultContent.getBuyFour());
        paramMap.put("buy_four_pri", resultContent.getBuyFourPri());
        paramMap.put("buy_five", resultContent.getBuyFive());
        paramMap.put("buy_five_pri", resultContent.getBuyFivePri());
        paramMap.put("sell_one", resultContent.getSellOne());
        paramMap.put("sell_one_pri", resultContent.getSellOnePri());
        paramMap.put("sell_two", resultContent.getSellTwo());
        paramMap.put("sell_two_pri", resultContent.getSellTwoPri());
        paramMap.put("sell_thre", resultContent.getSellThre());
        paramMap.put("sell_three_pri", resultContent.getSellThreePri());
        paramMap.put("sell_four", resultContent.getSellFour());
        paramMap.put("sell_four_pri", resultContent.getSellFourPri());
        paramMap.put("sell_five", resultContent.getSellFive());
        paramMap.put("sell_five_pri", resultContent.getSellFivePri());
        paramMap.put("r_date", resultContent.getRDate());
        paramMap.put("r_time", resultContent.getRTime());
        paramMap.put("stock_name", resultContent.getStockName());
        paramMap.put("dot", resultContent.getDot());
        paramMap.put("now_pic", resultContent.getNowPic());
        paramMap.put("rate", resultContent.getRate());
        paramMap.put("trad_number", resultContent.getTradNumber());
        paramMap.put("trad_amount", resultContent.getTradAmount());
        paramMap.put("minurl", resultContent.getMinurl());
        paramMap.put("dayurl", resultContent.getDayurl());
        paramMap.put("weekurl", resultContent.getWeekurl());
        paramMap.put("monthurl", resultContent.getMonthurl());
        paramMap.put("resultcod", resultContent.getResultcod());
        paramMap.put("creat_date", resultContent.getCreatDate());
        paramMap.put("creator", resultContent.getCreator());
        paramMap.put("last_update_date", resultContent.getLastUpdateDate());
        paramMap.put("last_updater", resultContent.getLastUpdater());
        paramMap.put("dr", resultContent.getDr());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		StringBuilder sql = new StringBuilder();
        sql.append("result_content_id, ");
        sql.append("gid, ");
        sql.append("bank_name, ");
        sql.append("today_start_pri, ");
        sql.append("yestod_end_pri, ");
        sql.append("now_pri, ");
        sql.append("today_max, ");
        sql.append("today_min, ");
        sql.append("competitive_pri, ");
        sql.append("reserve_pri, ");
        sql.append("tra_number, ");
        sql.append("tra_amount, ");
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
        sql.append("r_date, ");
        sql.append("r_time, ");
        sql.append("stock_name, ");
        sql.append("dot, ");
        sql.append("now_pic, ");
        sql.append("rate, ");
        sql.append("trad_number, ");
        sql.append("trad_amount, ");
        sql.append("minurl, ");
        sql.append("dayurl, ");
        sql.append("weekurl, ");
        sql.append("monthurl, ");
        sql.append("resultcod, ");
        sql.append("creat_date, ");
        sql.append("creator, ");
        sql.append("last_update_date, ");
        sql.append("last_updater, ");
		sql.append("dr ");
		return sql.toString();
	}

	@Override
	public void delete(Long resultContentId){
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM smc_result_content ");
		sql.append(" WHERE result_content_id = ? ");

		jdbcTemplate.update(sql.toString(), resultContentId);
	}

	/**
	 * 根据主键查询
	 * @param resultContentId 实时数据表主键
	 * @return ResultContent
	 */
	@Override
	public ResultContent findById(Long resultContentId){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_result_content ");
		sql.append(" WHERE result_content_id = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(ResultContent.class), resultContentId);
	}

	/**
	 * 根据对象查询
	 * @param resultContent
	 * @return List
	 */
	@Override
	public List<ResultContent> find(ResultContent resultContent){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_result_content ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(resultContent != null && resultContent.getResultContentId() != null){
			sql.append("  AND result_content_id = ? ");
			param.add(resultContent.getResultContentId());
        }
        if(resultContent != null && resultContent.getGid() != null){
			sql.append("  AND gid = ? ");
			param.add(resultContent.getGid());
        }
		if(resultContent != null && resultContent.getBankName() != null && !"".equals(resultContent.getBankName())){
            sql.append("  AND bank_name = ? ");
			param.add(resultContent.getBankName());
		}
        if(resultContent != null && resultContent.getTraNumber() != null){
			sql.append("  AND tra_number = ? ");
			param.add(resultContent.getTraNumber());
        }
        if(resultContent != null && resultContent.getBuyOne() != null){
			sql.append("  AND buy_one = ? ");
			param.add(resultContent.getBuyOne());
        }
        if(resultContent != null && resultContent.getBuyTwo() != null){
			sql.append("  AND buy_two = ? ");
			param.add(resultContent.getBuyTwo());
        }
        if(resultContent != null && resultContent.getBuyThre() != null){
			sql.append("  AND buy_thre = ? ");
			param.add(resultContent.getBuyThre());
        }
        if(resultContent != null && resultContent.getBuyFour() != null){
			sql.append("  AND buy_four = ? ");
			param.add(resultContent.getBuyFour());
        }
        if(resultContent != null && resultContent.getBuyFive() != null){
			sql.append("  AND buy_five = ? ");
			param.add(resultContent.getBuyFive());
        }
        if(resultContent != null && resultContent.getSellOne() != null){
			sql.append("  AND sell_one = ? ");
			param.add(resultContent.getSellOne());
        }
        if(resultContent != null && resultContent.getSellTwo() != null){
			sql.append("  AND sell_two = ? ");
			param.add(resultContent.getSellTwo());
        }
        if(resultContent != null && resultContent.getSellThre() != null){
			sql.append("  AND sell_thre = ? ");
			param.add(resultContent.getSellThre());
        }
        if(resultContent != null && resultContent.getSellFour() != null){
			sql.append("  AND sell_four = ? ");
			param.add(resultContent.getSellFour());
        }
        if(resultContent != null && resultContent.getSellFive() != null){
			sql.append("  AND sell_five = ? ");
			param.add(resultContent.getSellFive());
        }
        if(resultContent != null && resultContent.getRDate() != null){
			sql.append("  AND r_date = ? ");
			param.add(resultContent.getRDate());
        }
		if(resultContent != null && resultContent.getRTime() != null && !"".equals(resultContent.getRTime())){
            sql.append("  AND r_time = ? ");
			param.add(resultContent.getRTime());
		}
		if(resultContent != null && resultContent.getStockName() != null && !"".equals(resultContent.getStockName())){
            sql.append("  AND stock_name = ? ");
			param.add(resultContent.getStockName());
		}
        if(resultContent != null && resultContent.getTradNumber() != null){
			sql.append("  AND trad_number = ? ");
			param.add(resultContent.getTradNumber());
        }
		if(resultContent != null && resultContent.getMinurl() != null && !"".equals(resultContent.getMinurl())){
            sql.append("  AND minurl = ? ");
			param.add(resultContent.getMinurl());
		}
		if(resultContent != null && resultContent.getDayurl() != null && !"".equals(resultContent.getDayurl())){
            sql.append("  AND dayurl = ? ");
			param.add(resultContent.getDayurl());
		}
		if(resultContent != null && resultContent.getWeekurl() != null && !"".equals(resultContent.getWeekurl())){
            sql.append("  AND weekurl = ? ");
			param.add(resultContent.getWeekurl());
		}
		if(resultContent != null && resultContent.getMonthurl() != null && !"".equals(resultContent.getMonthurl())){
            sql.append("  AND monthurl = ? ");
			param.add(resultContent.getMonthurl());
		}
		if(resultContent != null && resultContent.getResultcod() != null && !"".equals(resultContent.getResultcod())){
            sql.append("  AND resultcod = ? ");
			param.add(resultContent.getResultcod());
		}
        if(resultContent != null && resultContent.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(resultContent.getCreatDate());
        }
        if(resultContent != null && resultContent.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(resultContent.getCreator());
        }
        if(resultContent != null && resultContent.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(resultContent.getLastUpdateDate());
        }
        if(resultContent != null && resultContent.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(resultContent.getLastUpdater());
        }
        if(resultContent != null && resultContent.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(resultContent.getDr());
        }
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(ResultContent.class));
	}

	/**
	 * 根据对象查询
	 * @param resultContent
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<ResultContent> find(ResultContent resultContent, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_result_content ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(resultContent != null && resultContent.getResultContentId() != null){
			sql.append("  AND result_content_id = ? ");
			param.add(resultContent.getResultContentId());
        }
        if(resultContent != null && resultContent.getGid() != null){
			sql.append("  AND gid = ? ");
			param.add(resultContent.getGid());
        }
		if(resultContent != null && resultContent.getBankName() != null && !"".equals(resultContent.getBankName())){
            sql.append("  AND bank_name = ? ");
			param.add(resultContent.getBankName());
		}
        if(resultContent != null && resultContent.getTraNumber() != null){
			sql.append("  AND tra_number = ? ");
			param.add(resultContent.getTraNumber());
        }
        if(resultContent != null && resultContent.getBuyOne() != null){
			sql.append("  AND buy_one = ? ");
			param.add(resultContent.getBuyOne());
        }
        if(resultContent != null && resultContent.getBuyTwo() != null){
			sql.append("  AND buy_two = ? ");
			param.add(resultContent.getBuyTwo());
        }
        if(resultContent != null && resultContent.getBuyThre() != null){
			sql.append("  AND buy_thre = ? ");
			param.add(resultContent.getBuyThre());
        }
        if(resultContent != null && resultContent.getBuyFour() != null){
			sql.append("  AND buy_four = ? ");
			param.add(resultContent.getBuyFour());
        }
        if(resultContent != null && resultContent.getBuyFive() != null){
			sql.append("  AND buy_five = ? ");
			param.add(resultContent.getBuyFive());
        }
        if(resultContent != null && resultContent.getSellOne() != null){
			sql.append("  AND sell_one = ? ");
			param.add(resultContent.getSellOne());
        }
        if(resultContent != null && resultContent.getSellTwo() != null){
			sql.append("  AND sell_two = ? ");
			param.add(resultContent.getSellTwo());
        }
        if(resultContent != null && resultContent.getSellThre() != null){
			sql.append("  AND sell_thre = ? ");
			param.add(resultContent.getSellThre());
        }
        if(resultContent != null && resultContent.getSellFour() != null){
			sql.append("  AND sell_four = ? ");
			param.add(resultContent.getSellFour());
        }
        if(resultContent != null && resultContent.getSellFive() != null){
			sql.append("  AND sell_five = ? ");
			param.add(resultContent.getSellFive());
        }
        if(resultContent != null && resultContent.getRDate() != null){
			sql.append("  AND r_date = ? ");
			param.add(resultContent.getRDate());
        }
		if(resultContent != null && resultContent.getRTime() != null && !"".equals(resultContent.getRTime())){
            sql.append("  AND r_time = ? ");
			param.add(resultContent.getRTime());
		}
		if(resultContent != null && resultContent.getStockName() != null && !"".equals(resultContent.getStockName())){
            sql.append("  AND stock_name = ? ");
			param.add(resultContent.getStockName());
		}
        if(resultContent != null && resultContent.getTradNumber() != null){
			sql.append("  AND trad_number = ? ");
			param.add(resultContent.getTradNumber());
        }
		if(resultContent != null && resultContent.getMinurl() != null && !"".equals(resultContent.getMinurl())){
            sql.append("  AND minurl = ? ");
			param.add(resultContent.getMinurl());
		}
		if(resultContent != null && resultContent.getDayurl() != null && !"".equals(resultContent.getDayurl())){
            sql.append("  AND dayurl = ? ");
			param.add(resultContent.getDayurl());
		}
		if(resultContent != null && resultContent.getWeekurl() != null && !"".equals(resultContent.getWeekurl())){
            sql.append("  AND weekurl = ? ");
			param.add(resultContent.getWeekurl());
		}
		if(resultContent != null && resultContent.getMonthurl() != null && !"".equals(resultContent.getMonthurl())){
            sql.append("  AND monthurl = ? ");
			param.add(resultContent.getMonthurl());
		}
		if(resultContent != null && resultContent.getResultcod() != null && !"".equals(resultContent.getResultcod())){
            sql.append("  AND resultcod = ? ");
			param.add(resultContent.getResultcod());
		}
        if(resultContent != null && resultContent.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(resultContent.getCreatDate());
        }
        if(resultContent != null && resultContent.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(resultContent.getCreator());
        }
        if(resultContent != null && resultContent.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(resultContent.getLastUpdateDate());
        }
        if(resultContent != null && resultContent.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(resultContent.getLastUpdater());
        }
        if(resultContent != null && resultContent.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(resultContent.getDr());
        }
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(ResultContent.class));
	}

	/**
	 * 根据对象查询条数
	 * @param resultContent
	 * @return Long
	 */
	@Override
	public Long count(ResultContent resultContent){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       count(*) ");
		sql.append("  FROM smc_result_content ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(resultContent != null && resultContent.getResultContentId() != null){
			sql.append("  AND result_content_id = ? ");
			param.add(resultContent.getResultContentId());
        }
        if(resultContent != null && resultContent.getGid() != null){
			sql.append("  AND gid = ? ");
			param.add(resultContent.getGid());
        }
		if(resultContent != null && resultContent.getBankName() != null && !"".equals(resultContent.getBankName())){
            sql.append("  AND bank_name = ? ");
			param.add(resultContent.getBankName());
		}
        if(resultContent != null && resultContent.getTraNumber() != null){
			sql.append("  AND tra_number = ? ");
			param.add(resultContent.getTraNumber());
        }
        if(resultContent != null && resultContent.getBuyOne() != null){
			sql.append("  AND buy_one = ? ");
			param.add(resultContent.getBuyOne());
        }
        if(resultContent != null && resultContent.getBuyTwo() != null){
			sql.append("  AND buy_two = ? ");
			param.add(resultContent.getBuyTwo());
        }
        if(resultContent != null && resultContent.getBuyThre() != null){
			sql.append("  AND buy_thre = ? ");
			param.add(resultContent.getBuyThre());
        }
        if(resultContent != null && resultContent.getBuyFour() != null){
			sql.append("  AND buy_four = ? ");
			param.add(resultContent.getBuyFour());
        }
        if(resultContent != null && resultContent.getBuyFive() != null){
			sql.append("  AND buy_five = ? ");
			param.add(resultContent.getBuyFive());
        }
        if(resultContent != null && resultContent.getSellOne() != null){
			sql.append("  AND sell_one = ? ");
			param.add(resultContent.getSellOne());
        }
        if(resultContent != null && resultContent.getSellTwo() != null){
			sql.append("  AND sell_two = ? ");
			param.add(resultContent.getSellTwo());
        }
        if(resultContent != null && resultContent.getSellThre() != null){
			sql.append("  AND sell_thre = ? ");
			param.add(resultContent.getSellThre());
        }
        if(resultContent != null && resultContent.getSellFour() != null){
			sql.append("  AND sell_four = ? ");
			param.add(resultContent.getSellFour());
        }
        if(resultContent != null && resultContent.getSellFive() != null){
			sql.append("  AND sell_five = ? ");
			param.add(resultContent.getSellFive());
        }
        if(resultContent != null && resultContent.getRDate() != null){
			sql.append("  AND r_date = ? ");
			param.add(resultContent.getRDate());
        }
		if(resultContent != null && resultContent.getRTime() != null && !"".equals(resultContent.getRTime())){
            sql.append("  AND r_time = ? ");
			param.add(resultContent.getRTime());
		}
		if(resultContent != null && resultContent.getStockName() != null && !"".equals(resultContent.getStockName())){
            sql.append("  AND stock_name = ? ");
			param.add(resultContent.getStockName());
		}
        if(resultContent != null && resultContent.getTradNumber() != null){
			sql.append("  AND trad_number = ? ");
			param.add(resultContent.getTradNumber());
        }
		if(resultContent != null && resultContent.getMinurl() != null && !"".equals(resultContent.getMinurl())){
            sql.append("  AND minurl = ? ");
			param.add(resultContent.getMinurl());
		}
		if(resultContent != null && resultContent.getDayurl() != null && !"".equals(resultContent.getDayurl())){
            sql.append("  AND dayurl = ? ");
			param.add(resultContent.getDayurl());
		}
		if(resultContent != null && resultContent.getWeekurl() != null && !"".equals(resultContent.getWeekurl())){
            sql.append("  AND weekurl = ? ");
			param.add(resultContent.getWeekurl());
		}
		if(resultContent != null && resultContent.getMonthurl() != null && !"".equals(resultContent.getMonthurl())){
            sql.append("  AND monthurl = ? ");
			param.add(resultContent.getMonthurl());
		}
		if(resultContent != null && resultContent.getResultcod() != null && !"".equals(resultContent.getResultcod())){
            sql.append("  AND resultcod = ? ");
			param.add(resultContent.getResultcod());
		}
        if(resultContent != null && resultContent.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(resultContent.getCreatDate());
        }
        if(resultContent != null && resultContent.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(resultContent.getCreator());
        }
        if(resultContent != null && resultContent.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(resultContent.getLastUpdateDate());
        }
        if(resultContent != null && resultContent.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(resultContent.getLastUpdater());
        }
        if(resultContent != null && resultContent.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(resultContent.getDr());
        }
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}