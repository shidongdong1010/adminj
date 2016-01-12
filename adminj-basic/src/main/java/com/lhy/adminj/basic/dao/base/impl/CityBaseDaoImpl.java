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

import com.lhy.adminj.basic.dao.base.CityBaseDao;
import com.lhy.adminj.basic.model.City;

/**
 * 城市表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CityBaseDaoImpl implements CityBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`city_id`, _this.`province_id`, _this.`city_name`, _this.`valid_flag`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`city_id`, _this.`province_id`, _this.`city_name`, _this.`valid_flag` FROM loc_city _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO loc_city(`city_id`, `province_id`, `city_name`, `valid_flag`) VALUES (:city_id, :province_id, :city_name, :valid_flag)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE loc_city SET `city_id` = :city_id, `province_id` = :province_id, `city_name` = :city_name, `valid_flag` = :valid_flag WHERE `city_id` = :city_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM loc_city WHERE `city_id` = ?";

	@Override
	public void save(City city) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(city);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		city.setCityId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(City city) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(city);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(City city) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE loc_city SET ");
		if(city.getCityId() != null){
			sql.append(" city_id = ?, ");
			param.add(city.getCityId());
		}
		if(city.getProvinceId() != null){
			sql.append(" province_id = ?, ");
			param.add(city.getProvinceId());
		}
		if(city.getCityName() != null){
			sql.append(" city_name = ?, ");
			param.add(city.getCityName());
		}
		if(city.getValidFlag() != null){
			sql.append(" valid_flag = ? ");
			param.add(city.getValidFlag());
		}
		sql.append(" WHERE city_id = ? ");
		param.add(city.getCityId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param citys
	 * @return
	 */
	public Map<String, Object>[] toMap(List<City> citys){
		Map<String, Object>[] maps = new Map[citys.size()];
		for(int i = 0; i < citys.size(); i++){
			City city = citys.get(i);
			maps[i] = toMap(city);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param city
	 * @return
	 */
	public Map<String, Object> toMap(City city){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("city_id", city.getCityId());
        paramMap.put("province_id", city.getProvinceId());
        paramMap.put("city_name", city.getCityName());
        paramMap.put("valid_flag", city.getValidFlag());
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
	public void delete(Long cityId){
		jdbcTemplate.update(DELETE_SQL, cityId);
	}

	@Override
	public void batchSave(List<City> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<City> list){
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
	 * @param cityId 城市ID
	 * @return City
	 */
	@Override
	public City findById(Long cityId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`city_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(City.class), cityId);
	}

	/**
	 * 根据对象查询
	 * @param city
	 * @return List
	 */
	@Override
	public List<City> find(City city){
		return this.find(city, null, null);
	}

	/**
	 * 根据对象查询
	 * @param city
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<City> find(City city, String[][] orders){
		return this.find(city, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param city
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<City> find(City city, Long offset, Long rows){
		return this.find(city, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param city
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<City> find(City city, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(city != null){
			if(city.getCityId() != null){
				sql.append(" AND _this.`city_id` = ?");
				param.add(city.getCityId());
			}
			if(city.getProvinceId() != null){
				sql.append(" AND _this.`province_id` = ?");
				param.add(city.getProvinceId());
			}
			if(city.getCityName() != null && !"".equals(city.getCityName())){
				sql.append(" AND _this.`city_name` = ?");
				param.add(city.getCityName());
			}
			if(city.getValidFlag() != null && !"".equals(city.getValidFlag())){
				sql.append(" AND _this.`valid_flag` = ?");
				param.add(city.getValidFlag());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(City.class));
	}


	/**
	 * 根据对象查询条数
	 * @param city
	 * @return Long
	 */
	@Override
	public Long count(City city){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM loc_city  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(city != null){
			if(city.getCityId() != null){
				sql.append(" AND _this.`city_id` = ? ");
				param.add(city.getCityId());
			}
			if(city.getProvinceId() != null){
				sql.append(" AND _this.`province_id` = ? ");
				param.add(city.getProvinceId());
			}
			if(city.getCityName() != null && !"".equals(city.getCityName())){
				sql.append(" AND _this.`city_name` = ? ");
				param.add(city.getCityName());
			}
			if(city.getValidFlag() != null && !"".equals(city.getValidFlag())){
				sql.append(" AND _this.`valid_flag` = ? ");
				param.add(city.getValidFlag());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}