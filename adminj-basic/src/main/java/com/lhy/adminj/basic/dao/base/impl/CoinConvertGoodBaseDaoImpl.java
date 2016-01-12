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

import com.lhy.adminj.basic.dao.base.CoinConvertGoodBaseDao;
import com.lhy.adminj.basic.model.CoinConvertGood;

/**
 * 兑换商品表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CoinConvertGoodBaseDaoImpl implements CoinConvertGoodBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`name`, _this.`begin_time`, _this.`end_time`, _this.`coin`, _this.`amount`, _this.`num`, _this.`day_num`, _this.`is_addr`, _this.`summary`, _this.`use_desc`, _this.`convert_desc`, _this.`is_enable`, _this.`publish_time`, _this.`publish_user_id`, _this.`modify_time`, _this.`modify_user_id`, _this.`min_pic_path`, _this.`max_pic_path`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`name`, _this.`begin_time`, _this.`end_time`, _this.`coin`, _this.`amount`, _this.`num`, _this.`day_num`, _this.`is_addr`, _this.`summary`, _this.`use_desc`, _this.`convert_desc`, _this.`is_enable`, _this.`publish_time`, _this.`publish_user_id`, _this.`modify_time`, _this.`modify_user_id`, _this.`min_pic_path`, _this.`max_pic_path` FROM umc_coin_convert_good _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_coin_convert_good(`id`, `name`, `begin_time`, `end_time`, `coin`, `amount`, `num`, `day_num`, `is_addr`, `summary`, `use_desc`, `convert_desc`, `is_enable`, `publish_time`, `publish_user_id`, `modify_time`, `modify_user_id`, `min_pic_path`, `max_pic_path`) VALUES (:id, :name, :begin_time, :end_time, :coin, :amount, :num, :day_num, :is_addr, :summary, :use_desc, :convert_desc, :is_enable, :publish_time, :publish_user_id, :modify_time, :modify_user_id, :min_pic_path, :max_pic_path)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_coin_convert_good SET `id` = :id, `name` = :name, `begin_time` = :begin_time, `end_time` = :end_time, `coin` = :coin, `amount` = :amount, `num` = :num, `day_num` = :day_num, `is_addr` = :is_addr, `summary` = :summary, `use_desc` = :use_desc, `convert_desc` = :convert_desc, `is_enable` = :is_enable, `publish_time` = :publish_time, `publish_user_id` = :publish_user_id, `modify_time` = :modify_time, `modify_user_id` = :modify_user_id, `min_pic_path` = :min_pic_path, `max_pic_path` = :max_pic_path WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_coin_convert_good WHERE `id` = ?";

	@Override
	public void save(CoinConvertGood coinConvertGood) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(coinConvertGood);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		coinConvertGood.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(CoinConvertGood coinConvertGood) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(coinConvertGood);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(CoinConvertGood coinConvertGood) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_coin_convert_good SET ");
		if(coinConvertGood.getId() != null){
			sql.append(" id = ?, ");
			param.add(coinConvertGood.getId());
		}
		if(coinConvertGood.getName() != null){
			sql.append(" name = ?, ");
			param.add(coinConvertGood.getName());
		}
		if(coinConvertGood.getBeginTime() != null){
			sql.append(" begin_time = ?, ");
			param.add(coinConvertGood.getBeginTime());
		}
		if(coinConvertGood.getEndTime() != null){
			sql.append(" end_time = ?, ");
			param.add(coinConvertGood.getEndTime());
		}
		if(coinConvertGood.getCoin() != null){
			sql.append(" coin = ?, ");
			param.add(coinConvertGood.getCoin());
		}
		if(coinConvertGood.getAmount() != null){
			sql.append(" amount = ?, ");
			param.add(coinConvertGood.getAmount());
		}
		if(coinConvertGood.getNum() != null){
			sql.append(" num = ?, ");
			param.add(coinConvertGood.getNum());
		}
		if(coinConvertGood.getDayNum() != null){
			sql.append(" day_num = ?, ");
			param.add(coinConvertGood.getDayNum());
		}
		if(coinConvertGood.getIsAddr() != null){
			sql.append(" is_addr = ?, ");
			param.add(coinConvertGood.getIsAddr());
		}
		if(coinConvertGood.getSummary() != null){
			sql.append(" summary = ?, ");
			param.add(coinConvertGood.getSummary());
		}
		if(coinConvertGood.getUseDesc() != null){
			sql.append(" use_desc = ?, ");
			param.add(coinConvertGood.getUseDesc());
		}
		if(coinConvertGood.getConvertDesc() != null){
			sql.append(" convert_desc = ?, ");
			param.add(coinConvertGood.getConvertDesc());
		}
		if(coinConvertGood.getIsEnable() != null){
			sql.append(" is_enable = ?, ");
			param.add(coinConvertGood.getIsEnable());
		}
		if(coinConvertGood.getPublishTime() != null){
			sql.append(" publish_time = ?, ");
			param.add(coinConvertGood.getPublishTime());
		}
		if(coinConvertGood.getPublishUserId() != null){
			sql.append(" publish_user_id = ?, ");
			param.add(coinConvertGood.getPublishUserId());
		}
		if(coinConvertGood.getModifyTime() != null){
			sql.append(" modify_time = ?, ");
			param.add(coinConvertGood.getModifyTime());
		}
		if(coinConvertGood.getModifyUserId() != null){
			sql.append(" modify_user_id = ?, ");
			param.add(coinConvertGood.getModifyUserId());
		}
		if(coinConvertGood.getMinPicPath() != null){
			sql.append(" min_pic_path = ?, ");
			param.add(coinConvertGood.getMinPicPath());
		}
		if(coinConvertGood.getMaxPicPath() != null){
			sql.append(" max_pic_path = ? ");
			param.add(coinConvertGood.getMaxPicPath());
		}
		sql.append(" WHERE id = ? ");
		param.add(coinConvertGood.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param coinConvertGoods
	 * @return
	 */
	public Map<String, Object>[] toMap(List<CoinConvertGood> coinConvertGoods){
		Map<String, Object>[] maps = new Map[coinConvertGoods.size()];
		for(int i = 0; i < coinConvertGoods.size(); i++){
			CoinConvertGood coinConvertGood = coinConvertGoods.get(i);
			maps[i] = toMap(coinConvertGood);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param coinConvertGood
	 * @return
	 */
	public Map<String, Object> toMap(CoinConvertGood coinConvertGood){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", coinConvertGood.getId());
        paramMap.put("name", coinConvertGood.getName());
        paramMap.put("begin_time", coinConvertGood.getBeginTime());
        paramMap.put("end_time", coinConvertGood.getEndTime());
        paramMap.put("coin", coinConvertGood.getCoin());
        paramMap.put("amount", coinConvertGood.getAmount());
        paramMap.put("num", coinConvertGood.getNum());
        paramMap.put("day_num", coinConvertGood.getDayNum());
        paramMap.put("is_addr", coinConvertGood.getIsAddr());
        paramMap.put("summary", coinConvertGood.getSummary());
        paramMap.put("use_desc", coinConvertGood.getUseDesc());
        paramMap.put("convert_desc", coinConvertGood.getConvertDesc());
        paramMap.put("is_enable", coinConvertGood.getIsEnable());
        paramMap.put("publish_time", coinConvertGood.getPublishTime());
        paramMap.put("publish_user_id", coinConvertGood.getPublishUserId());
        paramMap.put("modify_time", coinConvertGood.getModifyTime());
        paramMap.put("modify_user_id", coinConvertGood.getModifyUserId());
        paramMap.put("min_pic_path", coinConvertGood.getMinPicPath());
        paramMap.put("max_pic_path", coinConvertGood.getMaxPicPath());
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
	public void batchSave(List<CoinConvertGood> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<CoinConvertGood> list){
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
	 * @param id 主键ID
	 * @return CoinConvertGood
	 */
	@Override
	public CoinConvertGood findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(CoinConvertGood.class), id);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertGood
	 * @return List
	 */
	@Override
	public List<CoinConvertGood> find(CoinConvertGood coinConvertGood){
		return this.find(coinConvertGood, null, null);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertGood
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<CoinConvertGood> find(CoinConvertGood coinConvertGood, String[][] orders){
		return this.find(coinConvertGood, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertGood
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<CoinConvertGood> find(CoinConvertGood coinConvertGood, Long offset, Long rows){
		return this.find(coinConvertGood, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertGood
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<CoinConvertGood> find(CoinConvertGood coinConvertGood, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(coinConvertGood != null){
			if(coinConvertGood.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(coinConvertGood.getId());
			}
			if(coinConvertGood.getName() != null && !"".equals(coinConvertGood.getName())){
				sql.append(" AND _this.`name` = ?");
				param.add(coinConvertGood.getName());
			}
			if(coinConvertGood.getBeginTime() != null){
				sql.append(" AND _this.`begin_time` = ?");
				param.add(coinConvertGood.getBeginTime());
			}
			if(coinConvertGood.getEndTime() != null){
				sql.append(" AND _this.`end_time` = ?");
				param.add(coinConvertGood.getEndTime());
			}
			if(coinConvertGood.getNum() != null){
				sql.append(" AND _this.`num` = ?");
				param.add(coinConvertGood.getNum());
			}
			if(coinConvertGood.getDayNum() != null){
				sql.append(" AND _this.`day_num` = ?");
				param.add(coinConvertGood.getDayNum());
			}
			if(coinConvertGood.getIsAddr() != null){
				sql.append(" AND _this.`is_addr` = ?");
				param.add(coinConvertGood.getIsAddr());
			}
			if(coinConvertGood.getSummary() != null && !"".equals(coinConvertGood.getSummary())){
				sql.append(" AND _this.`summary` = ?");
				param.add(coinConvertGood.getSummary());
			}
			if(coinConvertGood.getUseDesc() != null && !"".equals(coinConvertGood.getUseDesc())){
				sql.append(" AND _this.`use_desc` = ?");
				param.add(coinConvertGood.getUseDesc());
			}
			if(coinConvertGood.getConvertDesc() != null && !"".equals(coinConvertGood.getConvertDesc())){
				sql.append(" AND _this.`convert_desc` = ?");
				param.add(coinConvertGood.getConvertDesc());
			}
			if(coinConvertGood.getIsEnable() != null){
				sql.append(" AND _this.`is_enable` = ?");
				param.add(coinConvertGood.getIsEnable());
			}
			if(coinConvertGood.getPublishTime() != null){
				sql.append(" AND _this.`publish_time` = ?");
				param.add(coinConvertGood.getPublishTime());
			}
			if(coinConvertGood.getPublishUserId() != null){
				sql.append(" AND _this.`publish_user_id` = ?");
				param.add(coinConvertGood.getPublishUserId());
			}
			if(coinConvertGood.getModifyTime() != null){
				sql.append(" AND _this.`modify_time` = ?");
				param.add(coinConvertGood.getModifyTime());
			}
			if(coinConvertGood.getModifyUserId() != null){
				sql.append(" AND _this.`modify_user_id` = ?");
				param.add(coinConvertGood.getModifyUserId());
			}
			if(coinConvertGood.getMinPicPath() != null && !"".equals(coinConvertGood.getMinPicPath())){
				sql.append(" AND _this.`min_pic_path` = ?");
				param.add(coinConvertGood.getMinPicPath());
			}
			if(coinConvertGood.getMaxPicPath() != null && !"".equals(coinConvertGood.getMaxPicPath())){
				sql.append(" AND _this.`max_pic_path` = ?");
				param.add(coinConvertGood.getMaxPicPath());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(CoinConvertGood.class));
	}


	/**
	 * 根据对象查询条数
	 * @param coinConvertGood
	 * @return Long
	 */
	@Override
	public Long count(CoinConvertGood coinConvertGood){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_coin_convert_good  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(coinConvertGood != null){
			if(coinConvertGood.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(coinConvertGood.getId());
			}
			if(coinConvertGood.getName() != null && !"".equals(coinConvertGood.getName())){
				sql.append(" AND _this.`name` = ? ");
				param.add(coinConvertGood.getName());
			}
			if(coinConvertGood.getBeginTime() != null){
				sql.append(" AND _this.`begin_time` = ? ");
				param.add(coinConvertGood.getBeginTime());
			}
			if(coinConvertGood.getEndTime() != null){
				sql.append(" AND _this.`end_time` = ? ");
				param.add(coinConvertGood.getEndTime());
			}
			if(coinConvertGood.getNum() != null){
				sql.append(" AND _this.`num` = ? ");
				param.add(coinConvertGood.getNum());
			}
			if(coinConvertGood.getDayNum() != null){
				sql.append(" AND _this.`day_num` = ? ");
				param.add(coinConvertGood.getDayNum());
			}
			if(coinConvertGood.getIsAddr() != null){
				sql.append(" AND _this.`is_addr` = ? ");
				param.add(coinConvertGood.getIsAddr());
			}
			if(coinConvertGood.getSummary() != null && !"".equals(coinConvertGood.getSummary())){
				sql.append(" AND _this.`summary` = ? ");
				param.add(coinConvertGood.getSummary());
			}
			if(coinConvertGood.getUseDesc() != null && !"".equals(coinConvertGood.getUseDesc())){
				sql.append(" AND _this.`use_desc` = ? ");
				param.add(coinConvertGood.getUseDesc());
			}
			if(coinConvertGood.getConvertDesc() != null && !"".equals(coinConvertGood.getConvertDesc())){
				sql.append(" AND _this.`convert_desc` = ? ");
				param.add(coinConvertGood.getConvertDesc());
			}
			if(coinConvertGood.getIsEnable() != null){
				sql.append(" AND _this.`is_enable` = ? ");
				param.add(coinConvertGood.getIsEnable());
			}
			if(coinConvertGood.getPublishTime() != null){
				sql.append(" AND _this.`publish_time` = ? ");
				param.add(coinConvertGood.getPublishTime());
			}
			if(coinConvertGood.getPublishUserId() != null){
				sql.append(" AND _this.`publish_user_id` = ? ");
				param.add(coinConvertGood.getPublishUserId());
			}
			if(coinConvertGood.getModifyTime() != null){
				sql.append(" AND _this.`modify_time` = ? ");
				param.add(coinConvertGood.getModifyTime());
			}
			if(coinConvertGood.getModifyUserId() != null){
				sql.append(" AND _this.`modify_user_id` = ? ");
				param.add(coinConvertGood.getModifyUserId());
			}
			if(coinConvertGood.getMinPicPath() != null && !"".equals(coinConvertGood.getMinPicPath())){
				sql.append(" AND _this.`min_pic_path` = ? ");
				param.add(coinConvertGood.getMinPicPath());
			}
			if(coinConvertGood.getMaxPicPath() != null && !"".equals(coinConvertGood.getMaxPicPath())){
				sql.append(" AND _this.`max_pic_path` = ? ");
				param.add(coinConvertGood.getMaxPicPath());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}