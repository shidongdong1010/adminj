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

import com.lhy.adminj.basic.dao.base.KhnoBaseDao;
import com.lhy.adminj.basic.model.Khno;

/**
 * Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class KhnoBaseDaoImpl implements KhnoBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`khno`, _this.`brokerid`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`khno`, _this.`brokerid` FROM smc_khno _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO smc_khno(`khno`, `brokerid`) VALUES (:khno, :brokerid)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE smc_khno SET `khno` = :khno, `brokerid` = :brokerid WHERE `khno` = :khno";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM smc_khno WHERE `khno` = ?";

	@Override
	public void save(Khno khno) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(khno);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		khno.setKhno(keyHolder.getKey().toString());
	}
	
	@Override
	public void update(Khno khno) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(khno);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(Khno khno) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE smc_khno SET ");
		if(khno.getKhno() != null){
			sql.append(" khno = ?, ");
			param.add(khno.getKhno());
		}
		if(khno.getBrokerid() != null){
			sql.append(" brokerid = ? ");
			param.add(khno.getBrokerid());
		}
		sql.append(" WHERE khno = ? ");
		param.add(khno.getKhno());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param khnos
	 * @return
	 */
	public Map<String, Object>[] toMap(List<Khno> khnos){
		Map<String, Object>[] maps = new Map[khnos.size()];
		for(int i = 0; i < khnos.size(); i++){
			Khno khno = khnos.get(i);
			maps[i] = toMap(khno);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param khno
	 * @return
	 */
	public Map<String, Object> toMap(Khno khno){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("khno", khno.getKhno());
        paramMap.put("brokerid", khno.getBrokerid());
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
	public void delete(String khno){
		jdbcTemplate.update(DELETE_SQL, khno);
	}

	@Override
	public void batchSave(List<Khno> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<Khno> list){
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
	 * @param khno 客户号
	 * @return Khno
	 */
	@Override
	public Khno findById(String khno){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`khno` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(Khno.class), khno);
	}

	/**
	 * 根据对象查询
	 * @param khno
	 * @return List
	 */
	@Override
	public List<Khno> find(Khno khno){
		return this.find(khno, null, null);
	}

	/**
	 * 根据对象查询
	 * @param khno
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<Khno> find(Khno khno, String[][] orders){
		return this.find(khno, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param khno
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Khno> find(Khno khno, Long offset, Long rows){
		return this.find(khno, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param khno
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Khno> find(Khno khno, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(khno != null){
			if(khno.getKhno() != null && !"".equals(khno.getKhno())){
				sql.append(" AND _this.`khno` = ?");
				param.add(khno.getKhno());
			}
			if(khno.getBrokerid() != null){
				sql.append(" AND _this.`brokerid` = ?");
				param.add(khno.getBrokerid());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Khno.class));
	}


	/**
	 * 根据对象查询条数
	 * @param khno
	 * @return Long
	 */
	@Override
	public Long count(Khno khno){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM smc_khno  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(khno != null){
			if(khno.getKhno() != null && !"".equals(khno.getKhno())){
				sql.append(" AND _this.`khno` = ? ");
				param.add(khno.getKhno());
			}
			if(khno.getBrokerid() != null){
				sql.append(" AND _this.`brokerid` = ? ");
				param.add(khno.getBrokerid());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}