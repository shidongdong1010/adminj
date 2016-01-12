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

import com.lhy.adminj.basic.dao.base.StockUserBaseDao;
import com.lhy.adminj.basic.model.StockUser;

/**
 * 证券开户表302001Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockUserBaseDaoImpl implements StockUserBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void save(StockUser stockUser) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO smc_stock_user ");
		sql.append("   (  ");
		sql.append("		stock_user_id,  ");
		sql.append("		fid_khh,  ");
		sql.append("		fid_fwxm,  ");
		sql.append("		fid_wtfs,  ");
		sql.append("		fid_zjbh,  ");
		sql.append("		fid_yyb,  ");
		sql.append("		fid_khqz,  ");
		sql.append("		fid_khkh,  ");
		sql.append("		fid_khxm,  ");
		sql.append("		fid_khzt,  ");
		sql.append("		fid_tzzfl,  ");
		sql.append("		fid_khjf,  ");
		sql.append("		fid_dz,  ");
		sql.append("		fid_dh,  ");
		sql.append("		fid_fax,  ");
		sql.append("		fid_email,  ");
		sql.append("		fid_mobile,  ");
		sql.append("		creat_date,  ");
		sql.append("		creator,  ");
		sql.append("		last_update_date,  ");
		sql.append("		last_updater,  ");
		sql.append("		dr,  ");
		sql.append("		broker_id  ");
		sql.append("   )  ");
		sql.append(" VALUES ");
		sql.append("   (  ");
		sql.append("		null,  ");
		sql.append("		:fid_khh,  ");
		sql.append("		:fid_fwxm,  ");
		sql.append("		:fid_wtfs,  ");
		sql.append("		:fid_zjbh,  ");
		sql.append("		:fid_yyb,  ");
		sql.append("		:fid_khqz,  ");
		sql.append("		:fid_khkh,  ");
		sql.append("		:fid_khxm,  ");
		sql.append("		:fid_khzt,  ");
		sql.append("		:fid_tzzfl,  ");
		sql.append("		:fid_khjf,  ");
		sql.append("		:fid_dz,  ");
		sql.append("		:fid_dh,  ");
		sql.append("		:fid_fax,  ");
		sql.append("		:fid_email,  ");
		sql.append("		:fid_mobile,  ");
		sql.append("		:creat_date,  ");
		sql.append("		:creator,  ");
		sql.append("		:last_update_date,  ");
		sql.append("		:last_updater,  ");
		sql.append("		:dr,  ");
		sql.append("		:broker_id  ");
		sql.append("   )  ");

		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(stockUser);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		stockUser.setStockUserId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(StockUser stockUser) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE smc_stock_user ");
		sql.append("    SET ");
        sql.append("        stock_user_id     = :stock_user_id, ");
        sql.append("        fid_khh     = :fid_khh, ");
        sql.append("        fid_fwxm     = :fid_fwxm, ");
        sql.append("        fid_wtfs     = :fid_wtfs, ");
        sql.append("        fid_zjbh     = :fid_zjbh, ");
        sql.append("        fid_yyb     = :fid_yyb, ");
        sql.append("        fid_khqz     = :fid_khqz, ");
        sql.append("        fid_khkh     = :fid_khkh, ");
        sql.append("        fid_khxm     = :fid_khxm, ");
        sql.append("        fid_khzt     = :fid_khzt, ");
        sql.append("        fid_tzzfl     = :fid_tzzfl, ");
        sql.append("        fid_khjf     = :fid_khjf, ");
        sql.append("        fid_dz     = :fid_dz, ");
        sql.append("        fid_dh     = :fid_dh, ");
        sql.append("        fid_fax     = :fid_fax, ");
        sql.append("        fid_email     = :fid_email, ");
        sql.append("        fid_mobile     = :fid_mobile, ");
        sql.append("        creat_date     = :creat_date, ");
        sql.append("        creator     = :creator, ");
        sql.append("        last_update_date     = :last_update_date, ");
        sql.append("        last_updater     = :last_updater, ");
        sql.append("        dr     = :dr, ");
    	sql.append("        broker_id     = :broker_id ");
		sql.append("  WHERE stock_user_id = :stock_user_id ");
		
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(stockUser);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}
	
	/**
	 * 将对象转换成Map
	 * @param stockUser
	 * @return
	 */
	public Map<String, Object> toMap(StockUser stockUser){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("stock_user_id", stockUser.getStockUserId());
        paramMap.put("fid_khh", stockUser.getFidKhh());
        paramMap.put("fid_fwxm", stockUser.getFidFwxm());
        paramMap.put("fid_wtfs", stockUser.getFidWtfs());
        paramMap.put("fid_zjbh", stockUser.getFidZjbh());
        paramMap.put("fid_yyb", stockUser.getFidYyb());
        paramMap.put("fid_khqz", stockUser.getFidKhqz());
        paramMap.put("fid_khkh", stockUser.getFidKhkh());
        paramMap.put("fid_khxm", stockUser.getFidKhxm());
        paramMap.put("fid_khzt", stockUser.getFidKhzt());
        paramMap.put("fid_tzzfl", stockUser.getFidTzzfl());
        paramMap.put("fid_khjf", stockUser.getFidKhjf());
        paramMap.put("fid_dz", stockUser.getFidDz());
        paramMap.put("fid_dh", stockUser.getFidDh());
        paramMap.put("fid_fax", stockUser.getFidFax());
        paramMap.put("fid_email", stockUser.getFidEmail());
        paramMap.put("fid_mobile", stockUser.getFidMobile());
        paramMap.put("creat_date", stockUser.getCreatDate());
        paramMap.put("creator", stockUser.getCreator());
        paramMap.put("last_update_date", stockUser.getLastUpdateDate());
        paramMap.put("last_updater", stockUser.getLastUpdater());
        paramMap.put("dr", stockUser.getDr());
        paramMap.put("broker_id", stockUser.getBrokerId());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		StringBuilder sql = new StringBuilder();
        sql.append("stock_user_id, ");
        sql.append("fid_khh, ");
        sql.append("fid_fwxm, ");
        sql.append("fid_wtfs, ");
        sql.append("fid_zjbh, ");
        sql.append("fid_yyb, ");
        sql.append("fid_khqz, ");
        sql.append("fid_khkh, ");
        sql.append("fid_khxm, ");
        sql.append("fid_khzt, ");
        sql.append("fid_tzzfl, ");
        sql.append("fid_khjf, ");
        sql.append("fid_dz, ");
        sql.append("fid_dh, ");
        sql.append("fid_fax, ");
        sql.append("fid_email, ");
        sql.append("fid_mobile, ");
        sql.append("creat_date, ");
        sql.append("creator, ");
        sql.append("last_update_date, ");
        sql.append("last_updater, ");
        sql.append("dr, ");
		sql.append("broker_id ");
		return sql.toString();
	}

	@Override
	public void delete(Long stockUserId){
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM smc_stock_user ");
		sql.append(" WHERE stock_user_id = ? ");

		jdbcTemplate.update(sql.toString(), stockUserId);
	}

	/**
	 * 根据主键查询
	 * @param stockUserId 主键
	 * @return StockUser
	 */
	@Override
	public StockUser findById(Long stockUserId){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_stock_user ");
		sql.append(" WHERE stock_user_id = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(StockUser.class), stockUserId);
	}

	/**
	 * 根据对象查询
	 * @param stockUser
	 * @return List
	 */
	@Override
	public List<StockUser> find(StockUser stockUser){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_stock_user ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(stockUser != null && stockUser.getStockUserId() != null){
			sql.append("  AND stock_user_id = ? ");
			param.add(stockUser.getStockUserId());
        }
		if(stockUser != null && stockUser.getFidKhh() != null && !"".equals(stockUser.getFidKhh())){
            sql.append("  AND fid_khh = ? ");
			param.add(stockUser.getFidKhh());
		}
		if(stockUser != null && stockUser.getFidZjbh() != null && !"".equals(stockUser.getFidZjbh())){
            sql.append("  AND fid_zjbh = ? ");
			param.add(stockUser.getFidZjbh());
		}
		if(stockUser != null && stockUser.getFidYyb() != null && !"".equals(stockUser.getFidYyb())){
            sql.append("  AND fid_yyb = ? ");
			param.add(stockUser.getFidYyb());
		}
		if(stockUser != null && stockUser.getFidKhqz() != null && !"".equals(stockUser.getFidKhqz())){
            sql.append("  AND fid_khqz = ? ");
			param.add(stockUser.getFidKhqz());
		}
		if(stockUser != null && stockUser.getFidKhkh() != null && !"".equals(stockUser.getFidKhkh())){
            sql.append("  AND fid_khkh = ? ");
			param.add(stockUser.getFidKhkh());
		}
		if(stockUser != null && stockUser.getFidKhxm() != null && !"".equals(stockUser.getFidKhxm())){
            sql.append("  AND fid_khxm = ? ");
			param.add(stockUser.getFidKhxm());
		}
		if(stockUser != null && stockUser.getFidDz() != null && !"".equals(stockUser.getFidDz())){
            sql.append("  AND fid_dz = ? ");
			param.add(stockUser.getFidDz());
		}
		if(stockUser != null && stockUser.getFidDh() != null && !"".equals(stockUser.getFidDh())){
            sql.append("  AND fid_dh = ? ");
			param.add(stockUser.getFidDh());
		}
		if(stockUser != null && stockUser.getFidFax() != null && !"".equals(stockUser.getFidFax())){
            sql.append("  AND fid_fax = ? ");
			param.add(stockUser.getFidFax());
		}
		if(stockUser != null && stockUser.getFidEmail() != null && !"".equals(stockUser.getFidEmail())){
            sql.append("  AND fid_email = ? ");
			param.add(stockUser.getFidEmail());
		}
		if(stockUser != null && stockUser.getFidMobile() != null && !"".equals(stockUser.getFidMobile())){
            sql.append("  AND fid_mobile = ? ");
			param.add(stockUser.getFidMobile());
		}
        if(stockUser != null && stockUser.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(stockUser.getCreatDate());
        }
        if(stockUser != null && stockUser.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(stockUser.getCreator());
        }
        if(stockUser != null && stockUser.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(stockUser.getLastUpdateDate());
        }
        if(stockUser != null && stockUser.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(stockUser.getLastUpdater());
        }
        if(stockUser != null && stockUser.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(stockUser.getDr());
        }
        if(stockUser != null && stockUser.getBrokerId() != null){
			sql.append("  AND broker_id = ? ");
			param.add(stockUser.getBrokerId());
        }
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(StockUser.class));
	}

	/**
	 * 根据对象查询
	 * @param stockUser
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<StockUser> find(StockUser stockUser, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_stock_user ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(stockUser != null && stockUser.getStockUserId() != null){
			sql.append("  AND stock_user_id = ? ");
			param.add(stockUser.getStockUserId());
        }
		if(stockUser != null && stockUser.getFidKhh() != null && !"".equals(stockUser.getFidKhh())){
            sql.append("  AND fid_khh = ? ");
			param.add(stockUser.getFidKhh());
		}
		if(stockUser != null && stockUser.getFidZjbh() != null && !"".equals(stockUser.getFidZjbh())){
            sql.append("  AND fid_zjbh = ? ");
			param.add(stockUser.getFidZjbh());
		}
		if(stockUser != null && stockUser.getFidYyb() != null && !"".equals(stockUser.getFidYyb())){
            sql.append("  AND fid_yyb = ? ");
			param.add(stockUser.getFidYyb());
		}
		if(stockUser != null && stockUser.getFidKhqz() != null && !"".equals(stockUser.getFidKhqz())){
            sql.append("  AND fid_khqz = ? ");
			param.add(stockUser.getFidKhqz());
		}
		if(stockUser != null && stockUser.getFidKhkh() != null && !"".equals(stockUser.getFidKhkh())){
            sql.append("  AND fid_khkh = ? ");
			param.add(stockUser.getFidKhkh());
		}
		if(stockUser != null && stockUser.getFidKhxm() != null && !"".equals(stockUser.getFidKhxm())){
            sql.append("  AND fid_khxm = ? ");
			param.add(stockUser.getFidKhxm());
		}
		if(stockUser != null && stockUser.getFidDz() != null && !"".equals(stockUser.getFidDz())){
            sql.append("  AND fid_dz = ? ");
			param.add(stockUser.getFidDz());
		}
		if(stockUser != null && stockUser.getFidDh() != null && !"".equals(stockUser.getFidDh())){
            sql.append("  AND fid_dh = ? ");
			param.add(stockUser.getFidDh());
		}
		if(stockUser != null && stockUser.getFidFax() != null && !"".equals(stockUser.getFidFax())){
            sql.append("  AND fid_fax = ? ");
			param.add(stockUser.getFidFax());
		}
		if(stockUser != null && stockUser.getFidEmail() != null && !"".equals(stockUser.getFidEmail())){
            sql.append("  AND fid_email = ? ");
			param.add(stockUser.getFidEmail());
		}
		if(stockUser != null && stockUser.getFidMobile() != null && !"".equals(stockUser.getFidMobile())){
            sql.append("  AND fid_mobile = ? ");
			param.add(stockUser.getFidMobile());
		}
        if(stockUser != null && stockUser.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(stockUser.getCreatDate());
        }
        if(stockUser != null && stockUser.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(stockUser.getCreator());
        }
        if(stockUser != null && stockUser.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(stockUser.getLastUpdateDate());
        }
        if(stockUser != null && stockUser.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(stockUser.getLastUpdater());
        }
        if(stockUser != null && stockUser.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(stockUser.getDr());
        }
        if(stockUser != null && stockUser.getBrokerId() != null){
			sql.append("  AND broker_id = ? ");
			param.add(stockUser.getBrokerId());
        }
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(StockUser.class));
	}

	/**
	 * 根据对象查询条数
	 * @param stockUser
	 * @return Long
	 */
	@Override
	public Long count(StockUser stockUser){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       count(*) ");
		sql.append("  FROM smc_stock_user ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(stockUser != null && stockUser.getStockUserId() != null){
			sql.append("  AND stock_user_id = ? ");
			param.add(stockUser.getStockUserId());
        }
		if(stockUser != null && stockUser.getFidKhh() != null && !"".equals(stockUser.getFidKhh())){
            sql.append("  AND fid_khh = ? ");
			param.add(stockUser.getFidKhh());
		}
		if(stockUser != null && stockUser.getFidZjbh() != null && !"".equals(stockUser.getFidZjbh())){
            sql.append("  AND fid_zjbh = ? ");
			param.add(stockUser.getFidZjbh());
		}
		if(stockUser != null && stockUser.getFidYyb() != null && !"".equals(stockUser.getFidYyb())){
            sql.append("  AND fid_yyb = ? ");
			param.add(stockUser.getFidYyb());
		}
		if(stockUser != null && stockUser.getFidKhqz() != null && !"".equals(stockUser.getFidKhqz())){
            sql.append("  AND fid_khqz = ? ");
			param.add(stockUser.getFidKhqz());
		}
		if(stockUser != null && stockUser.getFidKhkh() != null && !"".equals(stockUser.getFidKhkh())){
            sql.append("  AND fid_khkh = ? ");
			param.add(stockUser.getFidKhkh());
		}
		if(stockUser != null && stockUser.getFidKhxm() != null && !"".equals(stockUser.getFidKhxm())){
            sql.append("  AND fid_khxm = ? ");
			param.add(stockUser.getFidKhxm());
		}
		if(stockUser != null && stockUser.getFidDz() != null && !"".equals(stockUser.getFidDz())){
            sql.append("  AND fid_dz = ? ");
			param.add(stockUser.getFidDz());
		}
		if(stockUser != null && stockUser.getFidDh() != null && !"".equals(stockUser.getFidDh())){
            sql.append("  AND fid_dh = ? ");
			param.add(stockUser.getFidDh());
		}
		if(stockUser != null && stockUser.getFidFax() != null && !"".equals(stockUser.getFidFax())){
            sql.append("  AND fid_fax = ? ");
			param.add(stockUser.getFidFax());
		}
		if(stockUser != null && stockUser.getFidEmail() != null && !"".equals(stockUser.getFidEmail())){
            sql.append("  AND fid_email = ? ");
			param.add(stockUser.getFidEmail());
		}
		if(stockUser != null && stockUser.getFidMobile() != null && !"".equals(stockUser.getFidMobile())){
            sql.append("  AND fid_mobile = ? ");
			param.add(stockUser.getFidMobile());
		}
        if(stockUser != null && stockUser.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(stockUser.getCreatDate());
        }
        if(stockUser != null && stockUser.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(stockUser.getCreator());
        }
        if(stockUser != null && stockUser.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(stockUser.getLastUpdateDate());
        }
        if(stockUser != null && stockUser.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(stockUser.getLastUpdater());
        }
        if(stockUser != null && stockUser.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(stockUser.getDr());
        }
        if(stockUser != null && stockUser.getBrokerId() != null){
			sql.append("  AND broker_id = ? ");
			param.add(stockUser.getBrokerId());
        }
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}