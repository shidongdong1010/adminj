package com.lhy.adminj.basic.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.lhy.adminj.basic.dao.CityDao;
import com.lhy.adminj.basic.dao.base.impl.CityBaseDaoImpl;
import com.lhy.adminj.basic.model.City;

/**
 * 城市表Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class CityDaoImpl extends CityBaseDaoImpl implements CityDao {

	@Override
	public void delete(final String[] cityIds) {
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM loc_city ");
		sql.append(" WHERE city_id = ? ");

		jdbcTemplate.batchUpdate(sql.toString(),
		          new BatchPreparedStatementSetter(){
		                    public void setValues(PreparedStatement ps, int i)
		                    		throws SQLException {
		                        ps.setString(1, cityIds[i]);
		                    }
		                    public int getBatchSize() {
		                        return cityIds.length;
		                    }
		          });
	}
	@Override
	public List<Map<String, Object>> findCity(City city, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" 	c.city_id,");
		sql.append(" 	c.city_name,");
		sql.append(" 	c.province_id,");
		sql.append(" 	p.prov_cn_name,");
		sql.append(" 	c.valid_flag");
		sql.append(" FROM");
		sql.append(" 	loc_city c");
		sql.append(" 	INNER JOIN loc_province p ON c.province_id = p.province_id");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(city != null && city.getCityId() != null){
			sql.append("  AND c.city_id = ? ");
			param.add(city.getCityId());
        }
        if(city != null && city.getProvinceId() != null){
			sql.append("  AND c.province_id = ? ");
			param.add(city.getProvinceId());
        }
		if(city != null && city.getCityName() != null && !"".equals(city.getCityName())){
            sql.append("  AND c.city_name = ? ");
			param.add(city.getCityName());
		}
		if(city != null && city.getValidFlag() != null && !"".equals(city.getValidFlag())){
            sql.append("  AND c.valid_flag = ? ");
			param.add(city.getValidFlag());
		}
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

}
