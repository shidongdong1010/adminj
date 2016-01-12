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

import com.lhy.adminj.basic.dao.base.StockActualBaseDao;
import com.lhy.adminj.basic.model.StockActual;

/**
 * 股票时段表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockActualBaseDaoImpl implements StockActualBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`actual_stock_id`, _this.`actual_type`, _this.`actual_date`, _this.`stock_name`, _this.`stock_code`, _this.`zdf`, _this.`zds`, _this.`zgj`, _this.`utime`, _this.`cjl`, _this.`jkp`, _this.`zdj`, _this.`stype`, _this.`cjje`, _this.`zsp`, _this.`zxz`, _this.`diff_price`, _this.`create_date`, _this.`update_time`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`actual_stock_id`, _this.`actual_type`, _this.`actual_date`, _this.`stock_name`, _this.`stock_code`, _this.`zdf`, _this.`zds`, _this.`zgj`, _this.`utime`, _this.`cjl`, _this.`jkp`, _this.`zdj`, _this.`stype`, _this.`cjje`, _this.`zsp`, _this.`zxz`, _this.`diff_price`, _this.`create_date`, _this.`update_time` FROM smc_stock_actual _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO smc_stock_actual(`actual_stock_id`, `actual_type`, `actual_date`, `stock_name`, `stock_code`, `zdf`, `zds`, `zgj`, `utime`, `cjl`, `jkp`, `zdj`, `stype`, `cjje`, `zsp`, `zxz`, `diff_price`, `create_date`, `update_time`) VALUES (:actual_stock_id, :actual_type, :actual_date, :stock_name, :stock_code, :zdf, :zds, :zgj, :utime, :cjl, :jkp, :zdj, :stype, :cjje, :zsp, :zxz, :diff_price, :create_date, :update_time)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE smc_stock_actual SET `actual_stock_id` = :actual_stock_id, `actual_type` = :actual_type, `actual_date` = :actual_date, `stock_name` = :stock_name, `stock_code` = :stock_code, `zdf` = :zdf, `zds` = :zds, `zgj` = :zgj, `utime` = :utime, `cjl` = :cjl, `jkp` = :jkp, `zdj` = :zdj, `stype` = :stype, `cjje` = :cjje, `zsp` = :zsp, `zxz` = :zxz, `diff_price` = :diff_price, `create_date` = :create_date, `update_time` = :update_time WHERE `actual_stock_id` = :actual_stock_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM smc_stock_actual WHERE `actual_stock_id` = ?";

	@Override
	public void save(StockActual stockActual) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(stockActual);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		stockActual.setActualStockId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(StockActual stockActual) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(stockActual);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(StockActual stockActual) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE smc_stock_actual SET ");
		if(stockActual.getActualStockId() != null){
			sql.append(" actual_stock_id = ?, ");
			param.add(stockActual.getActualStockId());
		}
		if(stockActual.getActualType() != null){
			sql.append(" actual_type = ?, ");
			param.add(stockActual.getActualType());
		}
		if(stockActual.getActualDate() != null){
			sql.append(" actual_date = ?, ");
			param.add(stockActual.getActualDate());
		}
		if(stockActual.getStockName() != null){
			sql.append(" stock_name = ?, ");
			param.add(stockActual.getStockName());
		}
		if(stockActual.getStockCode() != null){
			sql.append(" stock_code = ?, ");
			param.add(stockActual.getStockCode());
		}
		if(stockActual.getZdf() != null){
			sql.append(" zdf = ?, ");
			param.add(stockActual.getZdf());
		}
		if(stockActual.getZds() != null){
			sql.append(" zds = ?, ");
			param.add(stockActual.getZds());
		}
		if(stockActual.getZgj() != null){
			sql.append(" zgj = ?, ");
			param.add(stockActual.getZgj());
		}
		if(stockActual.getUtime() != null){
			sql.append(" utime = ?, ");
			param.add(stockActual.getUtime());
		}
		if(stockActual.getCjl() != null){
			sql.append(" cjl = ?, ");
			param.add(stockActual.getCjl());
		}
		if(stockActual.getJkp() != null){
			sql.append(" jkp = ?, ");
			param.add(stockActual.getJkp());
		}
		if(stockActual.getZdj() != null){
			sql.append(" zdj = ?, ");
			param.add(stockActual.getZdj());
		}
		if(stockActual.getStype() != null){
			sql.append(" stype = ?, ");
			param.add(stockActual.getStype());
		}
		if(stockActual.getCjje() != null){
			sql.append(" cjje = ?, ");
			param.add(stockActual.getCjje());
		}
		if(stockActual.getZsp() != null){
			sql.append(" zsp = ?, ");
			param.add(stockActual.getZsp());
		}
		if(stockActual.getZxz() != null){
			sql.append(" zxz = ?, ");
			param.add(stockActual.getZxz());
		}
		if(stockActual.getDiffPrice() != null){
			sql.append(" diff_price = ?, ");
			param.add(stockActual.getDiffPrice());
		}
		if(stockActual.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(stockActual.getCreateDate());
		}
		if(stockActual.getUpdateTime() != null){
			sql.append(" update_time = ? ");
			param.add(stockActual.getUpdateTime());
		}
		sql.append(" WHERE actual_stock_id = ? ");
		param.add(stockActual.getActualStockId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param stockActuals
	 * @return
	 */
	public Map<String, Object>[] toMap(List<StockActual> stockActuals){
		Map<String, Object>[] maps = new Map[stockActuals.size()];
		for(int i = 0; i < stockActuals.size(); i++){
			StockActual stockActual = stockActuals.get(i);
			maps[i] = toMap(stockActual);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param stockActual
	 * @return
	 */
	public Map<String, Object> toMap(StockActual stockActual){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("actual_stock_id", stockActual.getActualStockId());
        paramMap.put("actual_type", stockActual.getActualType());
        paramMap.put("actual_date", stockActual.getActualDate());
        paramMap.put("stock_name", stockActual.getStockName());
        paramMap.put("stock_code", stockActual.getStockCode());
        paramMap.put("zdf", stockActual.getZdf());
        paramMap.put("zds", stockActual.getZds());
        paramMap.put("zgj", stockActual.getZgj());
        paramMap.put("utime", stockActual.getUtime());
        paramMap.put("cjl", stockActual.getCjl());
        paramMap.put("jkp", stockActual.getJkp());
        paramMap.put("zdj", stockActual.getZdj());
        paramMap.put("stype", stockActual.getStype());
        paramMap.put("cjje", stockActual.getCjje());
        paramMap.put("zsp", stockActual.getZsp());
        paramMap.put("zxz", stockActual.getZxz());
        paramMap.put("diff_price", stockActual.getDiffPrice());
        paramMap.put("create_date", stockActual.getCreateDate());
        paramMap.put("update_time", stockActual.getUpdateTime());
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
	public void delete(Long actualStockId){
		jdbcTemplate.update(DELETE_SQL, actualStockId);
	}

	@Override
	public void batchSave(List<StockActual> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<StockActual> list){
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
	 * @param actualStockId 股票表主键
	 * @return StockActual
	 */
	@Override
	public StockActual findById(Long actualStockId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`actual_stock_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(StockActual.class), actualStockId);
	}

	/**
	 * 根据对象查询
	 * @param stockActual
	 * @return List
	 */
	@Override
	public List<StockActual> find(StockActual stockActual){
		return this.find(stockActual, null, null);
	}

	/**
	 * 根据对象查询
	 * @param stockActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<StockActual> find(StockActual stockActual, String[][] orders){
		return this.find(stockActual, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param stockActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<StockActual> find(StockActual stockActual, Long offset, Long rows){
		return this.find(stockActual, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param stockActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<StockActual> find(StockActual stockActual, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(stockActual != null){
			if(stockActual.getActualStockId() != null){
				sql.append(" AND _this.`actual_stock_id` = ?");
				param.add(stockActual.getActualStockId());
			}
			if(stockActual.getActualType() != null && !"".equals(stockActual.getActualType())){
				sql.append(" AND _this.`actual_type` = ?");
				param.add(stockActual.getActualType());
			}
			if(stockActual.getActualDate() != null){
				sql.append(" AND _this.`actual_date` = ?");
				param.add(stockActual.getActualDate());
			}
			if(stockActual.getStockName() != null && !"".equals(stockActual.getStockName())){
				sql.append(" AND _this.`stock_name` = ?");
				param.add(stockActual.getStockName());
			}
			if(stockActual.getStockCode() != null && !"".equals(stockActual.getStockCode())){
				sql.append(" AND _this.`stock_code` = ?");
				param.add(stockActual.getStockCode());
			}
			if(stockActual.getUtime() != null){
				sql.append(" AND _this.`utime` = ?");
				param.add(stockActual.getUtime());
			}
			if(stockActual.getCjl() != null){
				sql.append(" AND _this.`cjl` = ?");
				param.add(stockActual.getCjl());
			}
			if(stockActual.getStype() != null && !"".equals(stockActual.getStype())){
				sql.append(" AND _this.`stype` = ?");
				param.add(stockActual.getStype());
			}
			if(stockActual.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(stockActual.getCreateDate());
			}
			if(stockActual.getUpdateTime() != null){
				sql.append(" AND _this.`update_time` = ?");
				param.add(stockActual.getUpdateTime());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(StockActual.class));
	}


	/**
	 * 根据对象查询条数
	 * @param stockActual
	 * @return Long
	 */
	@Override
	public Long count(StockActual stockActual){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM smc_stock_actual  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(stockActual != null){
			if(stockActual.getActualStockId() != null){
				sql.append(" AND _this.`actual_stock_id` = ? ");
				param.add(stockActual.getActualStockId());
			}
			if(stockActual.getActualType() != null && !"".equals(stockActual.getActualType())){
				sql.append(" AND _this.`actual_type` = ? ");
				param.add(stockActual.getActualType());
			}
			if(stockActual.getActualDate() != null){
				sql.append(" AND _this.`actual_date` = ? ");
				param.add(stockActual.getActualDate());
			}
			if(stockActual.getStockName() != null && !"".equals(stockActual.getStockName())){
				sql.append(" AND _this.`stock_name` = ? ");
				param.add(stockActual.getStockName());
			}
			if(stockActual.getStockCode() != null && !"".equals(stockActual.getStockCode())){
				sql.append(" AND _this.`stock_code` = ? ");
				param.add(stockActual.getStockCode());
			}
			if(stockActual.getUtime() != null){
				sql.append(" AND _this.`utime` = ? ");
				param.add(stockActual.getUtime());
			}
			if(stockActual.getCjl() != null){
				sql.append(" AND _this.`cjl` = ? ");
				param.add(stockActual.getCjl());
			}
			if(stockActual.getStype() != null && !"".equals(stockActual.getStype())){
				sql.append(" AND _this.`stype` = ? ");
				param.add(stockActual.getStype());
			}
			if(stockActual.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(stockActual.getCreateDate());
			}
			if(stockActual.getUpdateTime() != null){
				sql.append(" AND _this.`update_time` = ? ");
				param.add(stockActual.getUpdateTime());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}