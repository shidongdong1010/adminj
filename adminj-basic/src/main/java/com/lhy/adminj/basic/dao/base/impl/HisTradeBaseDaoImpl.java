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

import com.lhy.adminj.basic.dao.base.HisTradeBaseDao;
import com.lhy.adminj.basic.model.HisTrade;

/**
 * 证券历史交易查询Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class HisTradeBaseDaoImpl implements HisTradeBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void save(HisTrade hisTrade) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO smc_his_trade ");
		sql.append("   (  ");
		sql.append("		smc_id,  ");
		sql.append("		fid_khh,  ");
		sql.append("		user_id,  ");
		sql.append("		fid_browindex,  ");
		sql.append("		fid_cjrq,  ");
		sql.append("		fid_jys,  ");
		sql.append("		fid_gdh,  ");
		sql.append("		fid_bz,  ");
		sql.append("		fid_wth,  ");
		sql.append("		fid_wtlb,  ");
		sql.append("		fid_zqdm,  ");
		sql.append("		fid_zqmc,  ");
		sql.append("		fid_cjsj,  ");
		sql.append("		fid_cjsl,  ");
		sql.append("		fid_cjjg,  ");
		sql.append("		fid_jsj,  ");
		sql.append("		fid_cjje,  ");
		sql.append("		fid_bzs1,  ");
		sql.append("		fid_s1,  ");
		sql.append("		fid_s2,  ");
		sql.append("		fid_s3,  ");
		sql.append("		fid_s4,  ");
		sql.append("		fid_s5,  ");
		sql.append("		fid_s6,  ");
		sql.append("		fid_s11,  ");
		sql.append("		fid_s12,  ");
		sql.append("		fid_s13,  ");
		sql.append("		fid_cjbh,  ");
		sql.append("		fid_cjbs,  ");
		sql.append("		fid_ysje,  ");
		sql.append("		fid_bczqsl,  ");
		sql.append("		fid_bczjye,  ");
		sql.append("		fid_jysfy,  ");
		sql.append("		fid_jyfy,  ");
		sql.append("		fid_jsrq,  ");
		sql.append("		fid_lxje,  ");
		sql.append("		creat_date,  ");
		sql.append("		creator,  ");
		sql.append("		last_update_date,  ");
		sql.append("		last_updater,  ");
		sql.append("		dr  ");
		sql.append("   )  ");
		sql.append(" VALUES ");
		sql.append("   (  ");
		sql.append("		null,  ");
		sql.append("		:fid_khh,  ");
		sql.append("		:user_id,  ");
		sql.append("		:fid_browindex,  ");
		sql.append("		:fid_cjrq,  ");
		sql.append("		:fid_jys,  ");
		sql.append("		:fid_gdh,  ");
		sql.append("		:fid_bz,  ");
		sql.append("		:fid_wth,  ");
		sql.append("		:fid_wtlb,  ");
		sql.append("		:fid_zqdm,  ");
		sql.append("		:fid_zqmc,  ");
		sql.append("		:fid_cjsj,  ");
		sql.append("		:fid_cjsl,  ");
		sql.append("		:fid_cjjg,  ");
		sql.append("		:fid_jsj,  ");
		sql.append("		:fid_cjje,  ");
		sql.append("		:fid_bzs1,  ");
		sql.append("		:fid_s1,  ");
		sql.append("		:fid_s2,  ");
		sql.append("		:fid_s3,  ");
		sql.append("		:fid_s4,  ");
		sql.append("		:fid_s5,  ");
		sql.append("		:fid_s6,  ");
		sql.append("		:fid_s11,  ");
		sql.append("		:fid_s12,  ");
		sql.append("		:fid_s13,  ");
		sql.append("		:fid_cjbh,  ");
		sql.append("		:fid_cjbs,  ");
		sql.append("		:fid_ysje,  ");
		sql.append("		:fid_bczqsl,  ");
		sql.append("		:fid_bczjye,  ");
		sql.append("		:fid_jysfy,  ");
		sql.append("		:fid_jyfy,  ");
		sql.append("		:fid_jsrq,  ");
		sql.append("		:fid_lxje,  ");
		sql.append("		:creat_date,  ");
		sql.append("		:creator,  ");
		sql.append("		:last_update_date,  ");
		sql.append("		:last_updater,  ");
		sql.append("		:dr  ");
		sql.append("   )  ");

		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(hisTrade);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		hisTrade.setSmcId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(HisTrade hisTrade) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE smc_his_trade ");
		sql.append("    SET ");
        sql.append("        smc_id     = :smc_id, ");
        sql.append("        fid_khh     = :fid_khh, ");
        sql.append("        user_id     = :user_id, ");
        sql.append("        fid_browindex     = :fid_browindex, ");
        sql.append("        fid_cjrq     = :fid_cjrq, ");
        sql.append("        fid_jys     = :fid_jys, ");
        sql.append("        fid_gdh     = :fid_gdh, ");
        sql.append("        fid_bz     = :fid_bz, ");
        sql.append("        fid_wth     = :fid_wth, ");
        sql.append("        fid_wtlb     = :fid_wtlb, ");
        sql.append("        fid_zqdm     = :fid_zqdm, ");
        sql.append("        fid_zqmc     = :fid_zqmc, ");
        sql.append("        fid_cjsj     = :fid_cjsj, ");
        sql.append("        fid_cjsl     = :fid_cjsl, ");
        sql.append("        fid_cjjg     = :fid_cjjg, ");
        sql.append("        fid_jsj     = :fid_jsj, ");
        sql.append("        fid_cjje     = :fid_cjje, ");
        sql.append("        fid_bzs1     = :fid_bzs1, ");
        sql.append("        fid_s1     = :fid_s1, ");
        sql.append("        fid_s2     = :fid_s2, ");
        sql.append("        fid_s3     = :fid_s3, ");
        sql.append("        fid_s4     = :fid_s4, ");
        sql.append("        fid_s5     = :fid_s5, ");
        sql.append("        fid_s6     = :fid_s6, ");
        sql.append("        fid_s11     = :fid_s11, ");
        sql.append("        fid_s12     = :fid_s12, ");
        sql.append("        fid_s13     = :fid_s13, ");
        sql.append("        fid_cjbh     = :fid_cjbh, ");
        sql.append("        fid_cjbs     = :fid_cjbs, ");
        sql.append("        fid_ysje     = :fid_ysje, ");
        sql.append("        fid_bczqsl     = :fid_bczqsl, ");
        sql.append("        fid_bczjye     = :fid_bczjye, ");
        sql.append("        fid_jysfy     = :fid_jysfy, ");
        sql.append("        fid_jyfy     = :fid_jyfy, ");
        sql.append("        fid_jsrq     = :fid_jsrq, ");
        sql.append("        fid_lxje     = :fid_lxje, ");
        sql.append("        creat_date     = :creat_date, ");
        sql.append("        creator     = :creator, ");
        sql.append("        last_update_date     = :last_update_date, ");
        sql.append("        last_updater     = :last_updater, ");
    	sql.append("        dr     = :dr ");
		sql.append("  WHERE smc_id = :smc_id ");
		
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(hisTrade);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}
	
	/**
	 * 将对象转换成Map
	 * @param hisTrade
	 * @return
	 */
	public Map<String, Object> toMap(HisTrade hisTrade){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("smc_id", hisTrade.getSmcId());
        paramMap.put("fid_khh", hisTrade.getFidKhh());
        paramMap.put("user_id", hisTrade.getUserId());
        paramMap.put("fid_browindex", hisTrade.getFidBrowindex());
        paramMap.put("fid_cjrq", hisTrade.getFidCjrq());
        paramMap.put("fid_jys", hisTrade.getFidJys());
        paramMap.put("fid_gdh", hisTrade.getFidGdh());
        paramMap.put("fid_bz", hisTrade.getFidBz());
        paramMap.put("fid_wth", hisTrade.getFidWth());
        paramMap.put("fid_wtlb", hisTrade.getFidWtlb());
        paramMap.put("fid_zqdm", hisTrade.getFidZqdm());
        paramMap.put("fid_zqmc", hisTrade.getFidZqmc());
        paramMap.put("fid_cjsj", hisTrade.getFidCjsj());
        paramMap.put("fid_cjsl", hisTrade.getFidCjsl());
        paramMap.put("fid_cjjg", hisTrade.getFidCjjg());
        paramMap.put("fid_jsj", hisTrade.getFidJsj());
        paramMap.put("fid_cjje", hisTrade.getFidCjje());
        paramMap.put("fid_bzs1", hisTrade.getFidBzs1());
        paramMap.put("fid_s1", hisTrade.getFidS1());
        paramMap.put("fid_s2", hisTrade.getFidS2());
        paramMap.put("fid_s3", hisTrade.getFidS3());
        paramMap.put("fid_s4", hisTrade.getFidS4());
        paramMap.put("fid_s5", hisTrade.getFidS5());
        paramMap.put("fid_s6", hisTrade.getFidS6());
        paramMap.put("fid_s11", hisTrade.getFidS11());
        paramMap.put("fid_s12", hisTrade.getFidS12());
        paramMap.put("fid_s13", hisTrade.getFidS13());
        paramMap.put("fid_cjbh", hisTrade.getFidCjbh());
        paramMap.put("fid_cjbs", hisTrade.getFidCjbs());
        paramMap.put("fid_ysje", hisTrade.getFidYsje());
        paramMap.put("fid_bczqsl", hisTrade.getFidBczqsl());
        paramMap.put("fid_bczjye", hisTrade.getFidBczjye());
        paramMap.put("fid_jysfy", hisTrade.getFidJysfy());
        paramMap.put("fid_jyfy", hisTrade.getFidJyfy());
        paramMap.put("fid_jsrq", hisTrade.getFidJsrq());
        paramMap.put("fid_lxje", hisTrade.getFidLxje());
        paramMap.put("creat_date", hisTrade.getCreatDate());
        paramMap.put("creator", hisTrade.getCreator());
        paramMap.put("last_update_date", hisTrade.getLastUpdateDate());
        paramMap.put("last_updater", hisTrade.getLastUpdater());
        paramMap.put("dr", hisTrade.getDr());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		StringBuilder sql = new StringBuilder();
        sql.append("smc_id, ");
        sql.append("fid_khh, ");
        sql.append("user_id, ");
        sql.append("fid_browindex, ");
        sql.append("fid_cjrq, ");
        sql.append("fid_jys, ");
        sql.append("fid_gdh, ");
        sql.append("fid_bz, ");
        sql.append("fid_wth, ");
        sql.append("fid_wtlb, ");
        sql.append("fid_zqdm, ");
        sql.append("fid_zqmc, ");
        sql.append("fid_cjsj, ");
        sql.append("fid_cjsl, ");
        sql.append("fid_cjjg, ");
        sql.append("fid_jsj, ");
        sql.append("fid_cjje, ");
        sql.append("fid_bzs1, ");
        sql.append("fid_s1, ");
        sql.append("fid_s2, ");
        sql.append("fid_s3, ");
        sql.append("fid_s4, ");
        sql.append("fid_s5, ");
        sql.append("fid_s6, ");
        sql.append("fid_s11, ");
        sql.append("fid_s12, ");
        sql.append("fid_s13, ");
        sql.append("fid_cjbh, ");
        sql.append("fid_cjbs, ");
        sql.append("fid_ysje, ");
        sql.append("fid_bczqsl, ");
        sql.append("fid_bczjye, ");
        sql.append("fid_jysfy, ");
        sql.append("fid_jyfy, ");
        sql.append("fid_jsrq, ");
        sql.append("fid_lxje, ");
        sql.append("creat_date, ");
        sql.append("creator, ");
        sql.append("last_update_date, ");
        sql.append("last_updater, ");
		sql.append("dr ");
		return sql.toString();
	}

	@Override
	public void delete(Long smcId){
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM smc_his_trade ");
		sql.append(" WHERE smc_id = ? ");

		jdbcTemplate.update(sql.toString(), smcId);
	}

	/**
	 * 根据主键查询
	 * @param smcId 主键
	 * @return HisTrade
	 */
	@Override
	public HisTrade findById(Long smcId){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_his_trade ");
		sql.append(" WHERE smc_id = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(HisTrade.class), smcId);
	}

	/**
	 * 根据对象查询
	 * @param hisTrade
	 * @return List
	 */
	@Override
	public List<HisTrade> find(HisTrade hisTrade){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_his_trade ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(hisTrade != null && hisTrade.getSmcId() != null){
			sql.append("  AND smc_id = ? ");
			param.add(hisTrade.getSmcId());
        }
		if(hisTrade != null && hisTrade.getFidKhh() != null && !"".equals(hisTrade.getFidKhh())){
            sql.append("  AND fid_khh = ? ");
			param.add(hisTrade.getFidKhh());
		}
        if(hisTrade != null && hisTrade.getUserId() != null){
			sql.append("  AND user_id = ? ");
			param.add(hisTrade.getUserId());
        }
		if(hisTrade != null && hisTrade.getFidBrowindex() != null && !"".equals(hisTrade.getFidBrowindex())){
            sql.append("  AND fid_browindex = ? ");
			param.add(hisTrade.getFidBrowindex());
		}
		if(hisTrade != null && hisTrade.getFidJys() != null && !"".equals(hisTrade.getFidJys())){
            sql.append("  AND fid_jys = ? ");
			param.add(hisTrade.getFidJys());
		}
		if(hisTrade != null && hisTrade.getFidGdh() != null && !"".equals(hisTrade.getFidGdh())){
            sql.append("  AND fid_gdh = ? ");
			param.add(hisTrade.getFidGdh());
		}
		if(hisTrade != null && hisTrade.getFidBz() != null && !"".equals(hisTrade.getFidBz())){
            sql.append("  AND fid_bz = ? ");
			param.add(hisTrade.getFidBz());
		}
		if(hisTrade != null && hisTrade.getFidWtlb() != null && !"".equals(hisTrade.getFidWtlb())){
            sql.append("  AND fid_wtlb = ? ");
			param.add(hisTrade.getFidWtlb());
		}
		if(hisTrade != null && hisTrade.getFidZqdm() != null && !"".equals(hisTrade.getFidZqdm())){
            sql.append("  AND fid_zqdm = ? ");
			param.add(hisTrade.getFidZqdm());
		}
		if(hisTrade != null && hisTrade.getFidZqmc() != null && !"".equals(hisTrade.getFidZqmc())){
            sql.append("  AND fid_zqmc = ? ");
			param.add(hisTrade.getFidZqmc());
		}
		if(hisTrade != null && hisTrade.getFidCjsj() != null && !"".equals(hisTrade.getFidCjsj())){
            sql.append("  AND fid_cjsj = ? ");
			param.add(hisTrade.getFidCjsj());
		}
		if(hisTrade != null && hisTrade.getFidS11() != null && !"".equals(hisTrade.getFidS11())){
            sql.append("  AND fid_s11 = ? ");
			param.add(hisTrade.getFidS11());
		}
		if(hisTrade != null && hisTrade.getFidS12() != null && !"".equals(hisTrade.getFidS12())){
            sql.append("  AND fid_s12 = ? ");
			param.add(hisTrade.getFidS12());
		}
		if(hisTrade != null && hisTrade.getFidS13() != null && !"".equals(hisTrade.getFidS13())){
            sql.append("  AND fid_s13 = ? ");
			param.add(hisTrade.getFidS13());
		}
		if(hisTrade != null && hisTrade.getFidCjbh() != null && !"".equals(hisTrade.getFidCjbh())){
            sql.append("  AND fid_cjbh = ? ");
			param.add(hisTrade.getFidCjbh());
		}
        if(hisTrade != null && hisTrade.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(hisTrade.getCreatDate());
        }
        if(hisTrade != null && hisTrade.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(hisTrade.getCreator());
        }
        if(hisTrade != null && hisTrade.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(hisTrade.getLastUpdateDate());
        }
        if(hisTrade != null && hisTrade.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(hisTrade.getLastUpdater());
        }
        if(hisTrade != null && hisTrade.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(hisTrade.getDr());
        }
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(HisTrade.class));
	}

	/**
	 * 根据对象查询
	 * @param hisTrade
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<HisTrade> find(HisTrade hisTrade, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_his_trade ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(hisTrade != null && hisTrade.getSmcId() != null){
			sql.append("  AND smc_id = ? ");
			param.add(hisTrade.getSmcId());
        }
		if(hisTrade != null && hisTrade.getFidKhh() != null && !"".equals(hisTrade.getFidKhh())){
            sql.append("  AND fid_khh = ? ");
			param.add(hisTrade.getFidKhh());
		}
        if(hisTrade != null && hisTrade.getUserId() != null){
			sql.append("  AND user_id = ? ");
			param.add(hisTrade.getUserId());
        }
		if(hisTrade != null && hisTrade.getFidBrowindex() != null && !"".equals(hisTrade.getFidBrowindex())){
            sql.append("  AND fid_browindex = ? ");
			param.add(hisTrade.getFidBrowindex());
		}
		if(hisTrade != null && hisTrade.getFidJys() != null && !"".equals(hisTrade.getFidJys())){
            sql.append("  AND fid_jys = ? ");
			param.add(hisTrade.getFidJys());
		}
		if(hisTrade != null && hisTrade.getFidGdh() != null && !"".equals(hisTrade.getFidGdh())){
            sql.append("  AND fid_gdh = ? ");
			param.add(hisTrade.getFidGdh());
		}
		if(hisTrade != null && hisTrade.getFidBz() != null && !"".equals(hisTrade.getFidBz())){
            sql.append("  AND fid_bz = ? ");
			param.add(hisTrade.getFidBz());
		}
		if(hisTrade != null && hisTrade.getFidWtlb() != null && !"".equals(hisTrade.getFidWtlb())){
            sql.append("  AND fid_wtlb = ? ");
			param.add(hisTrade.getFidWtlb());
		}
		if(hisTrade != null && hisTrade.getFidZqdm() != null && !"".equals(hisTrade.getFidZqdm())){
            sql.append("  AND fid_zqdm = ? ");
			param.add(hisTrade.getFidZqdm());
		}
		if(hisTrade != null && hisTrade.getFidZqmc() != null && !"".equals(hisTrade.getFidZqmc())){
            sql.append("  AND fid_zqmc = ? ");
			param.add(hisTrade.getFidZqmc());
		}
		if(hisTrade != null && hisTrade.getFidCjsj() != null && !"".equals(hisTrade.getFidCjsj())){
            sql.append("  AND fid_cjsj = ? ");
			param.add(hisTrade.getFidCjsj());
		}
		if(hisTrade != null && hisTrade.getFidS11() != null && !"".equals(hisTrade.getFidS11())){
            sql.append("  AND fid_s11 = ? ");
			param.add(hisTrade.getFidS11());
		}
		if(hisTrade != null && hisTrade.getFidS12() != null && !"".equals(hisTrade.getFidS12())){
            sql.append("  AND fid_s12 = ? ");
			param.add(hisTrade.getFidS12());
		}
		if(hisTrade != null && hisTrade.getFidS13() != null && !"".equals(hisTrade.getFidS13())){
            sql.append("  AND fid_s13 = ? ");
			param.add(hisTrade.getFidS13());
		}
		if(hisTrade != null && hisTrade.getFidCjbh() != null && !"".equals(hisTrade.getFidCjbh())){
            sql.append("  AND fid_cjbh = ? ");
			param.add(hisTrade.getFidCjbh());
		}
        if(hisTrade != null && hisTrade.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(hisTrade.getCreatDate());
        }
        if(hisTrade != null && hisTrade.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(hisTrade.getCreator());
        }
        if(hisTrade != null && hisTrade.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(hisTrade.getLastUpdateDate());
        }
        if(hisTrade != null && hisTrade.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(hisTrade.getLastUpdater());
        }
        if(hisTrade != null && hisTrade.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(hisTrade.getDr());
        }
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(HisTrade.class));
	}

	/**
	 * 根据对象查询条数
	 * @param hisTrade
	 * @return Long
	 */
	@Override
	public Long count(HisTrade hisTrade){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       count(*) ");
		sql.append("  FROM smc_his_trade ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(hisTrade != null && hisTrade.getSmcId() != null){
			sql.append("  AND smc_id = ? ");
			param.add(hisTrade.getSmcId());
        }
		if(hisTrade != null && hisTrade.getFidKhh() != null && !"".equals(hisTrade.getFidKhh())){
            sql.append("  AND fid_khh = ? ");
			param.add(hisTrade.getFidKhh());
		}
        if(hisTrade != null && hisTrade.getUserId() != null){
			sql.append("  AND user_id = ? ");
			param.add(hisTrade.getUserId());
        }
		if(hisTrade != null && hisTrade.getFidBrowindex() != null && !"".equals(hisTrade.getFidBrowindex())){
            sql.append("  AND fid_browindex = ? ");
			param.add(hisTrade.getFidBrowindex());
		}
		if(hisTrade != null && hisTrade.getFidJys() != null && !"".equals(hisTrade.getFidJys())){
            sql.append("  AND fid_jys = ? ");
			param.add(hisTrade.getFidJys());
		}
		if(hisTrade != null && hisTrade.getFidGdh() != null && !"".equals(hisTrade.getFidGdh())){
            sql.append("  AND fid_gdh = ? ");
			param.add(hisTrade.getFidGdh());
		}
		if(hisTrade != null && hisTrade.getFidBz() != null && !"".equals(hisTrade.getFidBz())){
            sql.append("  AND fid_bz = ? ");
			param.add(hisTrade.getFidBz());
		}
		if(hisTrade != null && hisTrade.getFidWtlb() != null && !"".equals(hisTrade.getFidWtlb())){
            sql.append("  AND fid_wtlb = ? ");
			param.add(hisTrade.getFidWtlb());
		}
		if(hisTrade != null && hisTrade.getFidZqdm() != null && !"".equals(hisTrade.getFidZqdm())){
            sql.append("  AND fid_zqdm = ? ");
			param.add(hisTrade.getFidZqdm());
		}
		if(hisTrade != null && hisTrade.getFidZqmc() != null && !"".equals(hisTrade.getFidZqmc())){
            sql.append("  AND fid_zqmc = ? ");
			param.add(hisTrade.getFidZqmc());
		}
		if(hisTrade != null && hisTrade.getFidCjsj() != null && !"".equals(hisTrade.getFidCjsj())){
            sql.append("  AND fid_cjsj = ? ");
			param.add(hisTrade.getFidCjsj());
		}
		if(hisTrade != null && hisTrade.getFidS11() != null && !"".equals(hisTrade.getFidS11())){
            sql.append("  AND fid_s11 = ? ");
			param.add(hisTrade.getFidS11());
		}
		if(hisTrade != null && hisTrade.getFidS12() != null && !"".equals(hisTrade.getFidS12())){
            sql.append("  AND fid_s12 = ? ");
			param.add(hisTrade.getFidS12());
		}
		if(hisTrade != null && hisTrade.getFidS13() != null && !"".equals(hisTrade.getFidS13())){
            sql.append("  AND fid_s13 = ? ");
			param.add(hisTrade.getFidS13());
		}
		if(hisTrade != null && hisTrade.getFidCjbh() != null && !"".equals(hisTrade.getFidCjbh())){
            sql.append("  AND fid_cjbh = ? ");
			param.add(hisTrade.getFidCjbh());
		}
        if(hisTrade != null && hisTrade.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(hisTrade.getCreatDate());
        }
        if(hisTrade != null && hisTrade.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(hisTrade.getCreator());
        }
        if(hisTrade != null && hisTrade.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(hisTrade.getLastUpdateDate());
        }
        if(hisTrade != null && hisTrade.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(hisTrade.getLastUpdater());
        }
        if(hisTrade != null && hisTrade.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(hisTrade.getDr());
        }
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}