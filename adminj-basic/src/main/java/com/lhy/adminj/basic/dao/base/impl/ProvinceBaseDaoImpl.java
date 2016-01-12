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

import com.lhy.adminj.basic.dao.base.ProvinceBaseDao;
import com.lhy.adminj.basic.model.Province;

/**
 * 省份表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class ProvinceBaseDaoImpl implements ProvinceBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`province_id`, _this.`prov_cn_name`, _this.`short_name`, _this.`prov_en_name`, _this.`valid_flag`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`province_id`, _this.`prov_cn_name`, _this.`short_name`, _this.`prov_en_name`, _this.`valid_flag` FROM loc_province _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO loc_province(`province_id`, `prov_cn_name`, `short_name`, `prov_en_name`, `valid_flag`) VALUES (:province_id, :prov_cn_name, :short_name, :prov_en_name, :valid_flag)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE loc_province SET `province_id` = :province_id, `prov_cn_name` = :prov_cn_name, `short_name` = :short_name, `prov_en_name` = :prov_en_name, `valid_flag` = :valid_flag WHERE `province_id` = :province_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM loc_province WHERE `province_id` = ?";

	@Override
	public void save(Province province) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(province);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		province.setProvinceId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(Province province) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(province);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(Province province) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE loc_province SET ");
		if(province.getProvinceId() != null){
			sql.append(" province_id = ?, ");
			param.add(province.getProvinceId());
		}
		if(province.getProvCnName() != null){
			sql.append(" prov_cn_name = ?, ");
			param.add(province.getProvCnName());
		}
		if(province.getShortName() != null){
			sql.append(" short_name = ?, ");
			param.add(province.getShortName());
		}
		if(province.getProvEnName() != null){
			sql.append(" prov_en_name = ?, ");
			param.add(province.getProvEnName());
		}
		if(province.getValidFlag() != null){
			sql.append(" valid_flag = ? ");
			param.add(province.getValidFlag());
		}
		sql.append(" WHERE province_id = ? ");
		param.add(province.getProvinceId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param provinces
	 * @return
	 */
	public Map<String, Object>[] toMap(List<Province> provinces){
		Map<String, Object>[] maps = new Map[provinces.size()];
		for(int i = 0; i < provinces.size(); i++){
			Province province = provinces.get(i);
			maps[i] = toMap(province);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param province
	 * @return
	 */
	public Map<String, Object> toMap(Province province){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("province_id", province.getProvinceId());
        paramMap.put("prov_cn_name", province.getProvCnName());
        paramMap.put("short_name", province.getShortName());
        paramMap.put("prov_en_name", province.getProvEnName());
        paramMap.put("valid_flag", province.getValidFlag());
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
	public void delete(Long provinceId){
		jdbcTemplate.update(DELETE_SQL, provinceId);
	}

	@Override
	public void batchSave(List<Province> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<Province> list){
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
	 * @param provinceId 省份ID
	 * @return Province
	 */
	@Override
	public Province findById(Long provinceId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`province_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(Province.class), provinceId);
	}

	/**
	 * 根据对象查询
	 * @param province
	 * @return List
	 */
	@Override
	public List<Province> find(Province province){
		return this.find(province, null, null);
	}

	/**
	 * 根据对象查询
	 * @param province
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<Province> find(Province province, String[][] orders){
		return this.find(province, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param province
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Province> find(Province province, Long offset, Long rows){
		return this.find(province, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param province
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Province> find(Province province, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(province != null){
			if(province.getProvinceId() != null){
				sql.append(" AND _this.`province_id` = ?");
				param.add(province.getProvinceId());
			}
			if(province.getProvCnName() != null && !"".equals(province.getProvCnName())){
				sql.append(" AND _this.`prov_cn_name` = ?");
				param.add(province.getProvCnName());
			}
			if(province.getShortName() != null && !"".equals(province.getShortName())){
				sql.append(" AND _this.`short_name` = ?");
				param.add(province.getShortName());
			}
			if(province.getProvEnName() != null && !"".equals(province.getProvEnName())){
				sql.append(" AND _this.`prov_en_name` = ?");
				param.add(province.getProvEnName());
			}
			if(province.getValidFlag() != null && !"".equals(province.getValidFlag())){
				sql.append(" AND _this.`valid_flag` = ?");
				param.add(province.getValidFlag());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Province.class));
	}


	/**
	 * 根据对象查询条数
	 * @param province
	 * @return Long
	 */
	@Override
	public Long count(Province province){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM loc_province  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(province != null){
			if(province.getProvinceId() != null){
				sql.append(" AND _this.`province_id` = ? ");
				param.add(province.getProvinceId());
			}
			if(province.getProvCnName() != null && !"".equals(province.getProvCnName())){
				sql.append(" AND _this.`prov_cn_name` = ? ");
				param.add(province.getProvCnName());
			}
			if(province.getShortName() != null && !"".equals(province.getShortName())){
				sql.append(" AND _this.`short_name` = ? ");
				param.add(province.getShortName());
			}
			if(province.getProvEnName() != null && !"".equals(province.getProvEnName())){
				sql.append(" AND _this.`prov_en_name` = ? ");
				param.add(province.getProvEnName());
			}
			if(province.getValidFlag() != null && !"".equals(province.getValidFlag())){
				sql.append(" AND _this.`valid_flag` = ? ");
				param.add(province.getValidFlag());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}