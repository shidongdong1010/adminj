package com.lhy.adminj.basic.dao.impl;

import java.util.List;

import com.lhy.adminj.basic.dao.base.impl.UMenuBaseDaoImpl;
import com.lhy.adminj.basic.dao.UMenuDao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.lhy.adminj.basic.model.UMenu;

/**
 * 菜单表Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class UMenuDaoImpl extends UMenuBaseDaoImpl implements UMenuDao {

	/**
	 * 查询用户拥有的菜单
	 * @param userId
	 * @return
	 */
	public List<UMenu> find(Long userId){
		String sql = "SELECT " +
					"    t.*" +
					" FROM" +
					"    (SELECT " +
					"        a.*" +
					"    FROM" +
					"        u_menu a" +
					"    WHERE a.id != 0 " +
					"        AND " +
					"        NOT EXISTS( SELECT " +
					"                id" +
					"            FROM" +
					"                u_resource b" +
					"            WHERE" +
					"                a.url = b.url) UNION ALL SELECT " +
					"        a.*" +
					"    FROM" +
					"        u_menu a" +
					"    INNER JOIN u_resource b ON a.url = b.url" +
					"    INNER JOIN u_role_resource c ON b.id = c.resource_id" +
					"    INNER JOIN u_user_role d ON c.role_id = d.role_id" +
					"    WHERE" +
					"        d.user_id = ? AND a.id != 0) t" +
					" ORDER BY t.parent_id , t.sort";
		return this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UMenu.class), userId);
	}
}
