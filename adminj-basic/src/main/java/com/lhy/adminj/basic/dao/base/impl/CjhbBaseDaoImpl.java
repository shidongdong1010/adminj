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

import com.lhy.adminj.basic.dao.base.CjhbBaseDao;
import com.lhy.adminj.basic.model.Cjhb;

/**
 * Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CjhbBaseDaoImpl implements CjhbBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`cjrq`, _this.`recordid`, _this.`khh`, _this.`show_wtlb`, _this.`cjsl`, _this.`zqdm`, _this.`cjjg`, _this.`wtlb`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`cjrq`, _this.`recordid`, _this.`khh`, _this.`show_wtlb`, _this.`cjsl`, _this.`zqdm`, _this.`cjjg`, _this.`wtlb` FROM smc_cjhb _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO smc_cjhb(`id`, `cjrq`, `recordid`, `khh`, `show_wtlb`, `cjsl`, `zqdm`, `cjjg`, `wtlb`) VALUES (:id, :cjrq, :recordid, :khh, :show_wtlb, :cjsl, :zqdm, :cjjg, :wtlb)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE smc_cjhb SET `id` = :id, `cjrq` = :cjrq, `recordid` = :recordid, `khh` = :khh, `show_wtlb` = :show_wtlb, `cjsl` = :cjsl, `zqdm` = :zqdm, `cjjg` = :cjjg, `wtlb` = :wtlb WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM smc_cjhb WHERE `id` = ?";

	@Override
	public void save(Cjhb cjhb) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(cjhb);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		cjhb.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(Cjhb cjhb) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(cjhb);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(Cjhb cjhb) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE smc_cjhb SET ");
		if(cjhb.getId() != null){
			sql.append(" id = ?, ");
			param.add(cjhb.getId());
		}
		if(cjhb.getCjrq() != null){
			sql.append(" cjrq = ?, ");
			param.add(cjhb.getCjrq());
		}
		if(cjhb.getRecordid() != null){
			sql.append(" recordid = ?, ");
			param.add(cjhb.getRecordid());
		}
		if(cjhb.getKhh() != null){
			sql.append(" khh = ?, ");
			param.add(cjhb.getKhh());
		}
		if(cjhb.getShowWtlb() != null){
			sql.append(" show_wtlb = ?, ");
			param.add(cjhb.getShowWtlb());
		}
		if(cjhb.getCjsl() != null){
			sql.append(" cjsl = ?, ");
			param.add(cjhb.getCjsl());
		}
		if(cjhb.getZqdm() != null){
			sql.append(" zqdm = ?, ");
			param.add(cjhb.getZqdm());
		}
		if(cjhb.getCjjg() != null){
			sql.append(" cjjg = ?, ");
			param.add(cjhb.getCjjg());
		}
		if(cjhb.getWtlb() != null){
			sql.append(" wtlb = ? ");
			param.add(cjhb.getWtlb());
		}
		sql.append(" WHERE id = ? ");
		param.add(cjhb.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param cjhbs
	 * @return
	 */
	public Map<String, Object>[] toMap(List<Cjhb> cjhbs){
		Map<String, Object>[] maps = new Map[cjhbs.size()];
		for(int i = 0; i < cjhbs.size(); i++){
			Cjhb cjhb = cjhbs.get(i);
			maps[i] = toMap(cjhb);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param cjhb
	 * @return
	 */
	public Map<String, Object> toMap(Cjhb cjhb){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", cjhb.getId());
        paramMap.put("cjrq", cjhb.getCjrq());
        paramMap.put("recordid", cjhb.getRecordid());
        paramMap.put("khh", cjhb.getKhh());
        paramMap.put("show_wtlb", cjhb.getShowWtlb());
        paramMap.put("cjsl", cjhb.getCjsl());
        paramMap.put("zqdm", cjhb.getZqdm());
        paramMap.put("cjjg", cjhb.getCjjg());
        paramMap.put("wtlb", cjhb.getWtlb());
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
	public void batchSave(List<Cjhb> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<Cjhb> list){
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
	 * @return Cjhb
	 */
	@Override
	public Cjhb findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(Cjhb.class), id);
	}

	/**
	 * 根据对象查询
	 * @param cjhb
	 * @return List
	 */
	@Override
	public List<Cjhb> find(Cjhb cjhb){
		return this.find(cjhb, null, null);
	}

	/**
	 * 根据对象查询
	 * @param cjhb
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<Cjhb> find(Cjhb cjhb, String[][] orders){
		return this.find(cjhb, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param cjhb
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Cjhb> find(Cjhb cjhb, Long offset, Long rows){
		return this.find(cjhb, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param cjhb
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Cjhb> find(Cjhb cjhb, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(cjhb != null){
			if(cjhb.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(cjhb.getId());
			}
			if(cjhb.getCjrq() != null){
				sql.append(" AND _this.`cjrq` = ?");
				param.add(cjhb.getCjrq());
			}
			if(cjhb.getRecordid() != null){
				sql.append(" AND _this.`recordid` = ?");
				param.add(cjhb.getRecordid());
			}
			if(cjhb.getKhh() != null && !"".equals(cjhb.getKhh())){
				sql.append(" AND _this.`khh` = ?");
				param.add(cjhb.getKhh());
			}
			if(cjhb.getShowWtlb() != null && !"".equals(cjhb.getShowWtlb())){
				sql.append(" AND _this.`show_wtlb` = ?");
				param.add(cjhb.getShowWtlb());
			}
			if(cjhb.getCjsl() != null){
				sql.append(" AND _this.`cjsl` = ?");
				param.add(cjhb.getCjsl());
			}
			if(cjhb.getZqdm() != null && !"".equals(cjhb.getZqdm())){
				sql.append(" AND _this.`zqdm` = ?");
				param.add(cjhb.getZqdm());
			}
			if(cjhb.getWtlb() != null && !"".equals(cjhb.getWtlb())){
				sql.append(" AND _this.`wtlb` = ?");
				param.add(cjhb.getWtlb());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Cjhb.class));
	}


	/**
	 * 根据对象查询条数
	 * @param cjhb
	 * @return Long
	 */
	@Override
	public Long count(Cjhb cjhb){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM smc_cjhb  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(cjhb != null){
			if(cjhb.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(cjhb.getId());
			}
			if(cjhb.getCjrq() != null){
				sql.append(" AND _this.`cjrq` = ? ");
				param.add(cjhb.getCjrq());
			}
			if(cjhb.getRecordid() != null){
				sql.append(" AND _this.`recordid` = ? ");
				param.add(cjhb.getRecordid());
			}
			if(cjhb.getKhh() != null && !"".equals(cjhb.getKhh())){
				sql.append(" AND _this.`khh` = ? ");
				param.add(cjhb.getKhh());
			}
			if(cjhb.getShowWtlb() != null && !"".equals(cjhb.getShowWtlb())){
				sql.append(" AND _this.`show_wtlb` = ? ");
				param.add(cjhb.getShowWtlb());
			}
			if(cjhb.getCjsl() != null){
				sql.append(" AND _this.`cjsl` = ? ");
				param.add(cjhb.getCjsl());
			}
			if(cjhb.getZqdm() != null && !"".equals(cjhb.getZqdm())){
				sql.append(" AND _this.`zqdm` = ? ");
				param.add(cjhb.getZqdm());
			}
			if(cjhb.getWtlb() != null && !"".equals(cjhb.getWtlb())){
				sql.append(" AND _this.`wtlb` = ? ");
				param.add(cjhb.getWtlb());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}