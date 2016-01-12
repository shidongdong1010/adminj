package com.lhy.adminj.basic.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.lhy.adminj.basic.dao.ProvinceDao;
import com.lhy.adminj.basic.dao.base.impl.ProvinceBaseDaoImpl;

/**
 * 省份表Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class ProvinceDaoImpl extends ProvinceBaseDaoImpl implements ProvinceDao {

	@Override
	public void delete(final String[] provinceIds){
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM loc_province ");
		sql.append(" WHERE province_id = ? ");

		jdbcTemplate.batchUpdate(sql.toString(),
		          new BatchPreparedStatementSetter(){
		                    public void setValues(PreparedStatement ps, int i)
		                    		throws SQLException {
		                        ps.setString(1, provinceIds[i]);
		                    }
		                    public int getBatchSize() {
		                        return provinceIds.length;
		                    }
		          });
	}
}
