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

import com.lhy.adminj.basic.dao.base.StockBaseDao;
import com.lhy.adminj.basic.model.Stock;

/**
 * 股票表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockBaseDaoImpl implements StockBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`stock_id`, _this.`stock_name`, _this.`stock_code`, _this.`zdf`, _this.`zds`, _this.`zgj`, _this.`utime`, _this.`cjl`, _this.`jkp`, _this.`zdj`, _this.`stype`, _this.`cjje`, _this.`zsp`, _this.`zxz`, _this.`create_date`, _this.`update_time`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`stock_id`, _this.`stock_name`, _this.`stock_code`, _this.`zdf`, _this.`zds`, _this.`zgj`, _this.`utime`, _this.`cjl`, _this.`jkp`, _this.`zdj`, _this.`stype`, _this.`cjje`, _this.`zsp`, _this.`zxz`, _this.`create_date`, _this.`update_time` FROM smc_stock _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO smc_stock(`stock_id`, `stock_name`, `stock_code`, `zdf`, `zds`, `zgj`, `utime`, `cjl`, `jkp`, `zdj`, `stype`, `cjje`, `zsp`, `zxz`, `create_date`, `update_time`) VALUES (:stock_id, :stock_name, :stock_code, :zdf, :zds, :zgj, :utime, :cjl, :jkp, :zdj, :stype, :cjje, :zsp, :zxz, :create_date, :update_time)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE smc_stock SET `stock_id` = :stock_id, `stock_name` = :stock_name, `stock_code` = :stock_code, `zdf` = :zdf, `zds` = :zds, `zgj` = :zgj, `utime` = :utime, `cjl` = :cjl, `jkp` = :jkp, `zdj` = :zdj, `stype` = :stype, `cjje` = :cjje, `zsp` = :zsp, `zxz` = :zxz, `create_date` = :create_date, `update_time` = :update_time WHERE `stock_id` = :stock_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM smc_stock WHERE `stock_id` = ?";

	@Override
	public void save(Stock stock) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(stock);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		stock.setStockId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(Stock stock) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(stock);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(Stock stock) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE smc_stock SET ");
		if(stock.getStockId() != null){
			sql.append(" stock_id = ?, ");
			param.add(stock.getStockId());
		}
		if(stock.getStockName() != null){
			sql.append(" stock_name = ?, ");
			param.add(stock.getStockName());
		}
		if(stock.getStockCode() != null){
			sql.append(" stock_code = ?, ");
			param.add(stock.getStockCode());
		}
		if(stock.getZdf() != null){
			sql.append(" zdf = ?, ");
			param.add(stock.getZdf());
		}
		if(stock.getZds() != null){
			sql.append(" zds = ?, ");
			param.add(stock.getZds());
		}
		if(stock.getZgj() != null){
			sql.append(" zgj = ?, ");
			param.add(stock.getZgj());
		}
		if(stock.getUtime() != null){
			sql.append(" utime = ?, ");
			param.add(stock.getUtime());
		}
		if(stock.getCjl() != null){
			sql.append(" cjl = ?, ");
			param.add(stock.getCjl());
		}
		if(stock.getJkp() != null){
			sql.append(" jkp = ?, ");
			param.add(stock.getJkp());
		}
		if(stock.getZdj() != null){
			sql.append(" zdj = ?, ");
			param.add(stock.getZdj());
		}
		if(stock.getStype() != null){
			sql.append(" stype = ?, ");
			param.add(stock.getStype());
		}
		if(stock.getCjje() != null){
			sql.append(" cjje = ?, ");
			param.add(stock.getCjje());
		}
		if(stock.getZsp() != null){
			sql.append(" zsp = ?, ");
			param.add(stock.getZsp());
		}
		if(stock.getZxz() != null){
			sql.append(" zxz = ?, ");
			param.add(stock.getZxz());
		}
		if(stock.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(stock.getCreateDate());
		}
		if(stock.getUpdateTime() != null){
			sql.append(" update_time = ? ");
			param.add(stock.getUpdateTime());
		}
		sql.append(" WHERE stock_id = ? ");
		param.add(stock.getStockId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param stocks
	 * @return
	 */
	public Map<String, Object>[] toMap(List<Stock> stocks){
		Map<String, Object>[] maps = new Map[stocks.size()];
		for(int i = 0; i < stocks.size(); i++){
			Stock stock = stocks.get(i);
			maps[i] = toMap(stock);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param stock
	 * @return
	 */
	public Map<String, Object> toMap(Stock stock){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("stock_id", stock.getStockId());
        paramMap.put("stock_name", stock.getStockName());
        paramMap.put("stock_code", stock.getStockCode());
        paramMap.put("zdf", stock.getZdf());
        paramMap.put("zds", stock.getZds());
        paramMap.put("zgj", stock.getZgj());
        paramMap.put("utime", stock.getUtime());
        paramMap.put("cjl", stock.getCjl());
        paramMap.put("jkp", stock.getJkp());
        paramMap.put("zdj", stock.getZdj());
        paramMap.put("stype", stock.getStype());
        paramMap.put("cjje", stock.getCjje());
        paramMap.put("zsp", stock.getZsp());
        paramMap.put("zxz", stock.getZxz());
        paramMap.put("create_date", stock.getCreateDate());
        paramMap.put("update_time", stock.getUpdateTime());
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
	public void delete(Long stockId){
		jdbcTemplate.update(DELETE_SQL, stockId);
	}

	@Override
	public void batchSave(List<Stock> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<Stock> list){
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
	 * @param stockId 股票表主键
	 * @return Stock
	 */
	@Override
	public Stock findById(Long stockId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`stock_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(Stock.class), stockId);
	}

	/**
	 * 根据对象查询
	 * @param stock
	 * @return List
	 */
	@Override
	public List<Stock> find(Stock stock){
		return this.find(stock, null, null);
	}

	/**
	 * 根据对象查询
	 * @param stock
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<Stock> find(Stock stock, String[][] orders){
		return this.find(stock, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param stock
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Stock> find(Stock stock, Long offset, Long rows){
		return this.find(stock, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param stock
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Stock> find(Stock stock, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(stock != null){
			if(stock.getStockId() != null){
				sql.append(" AND _this.`stock_id` = ?");
				param.add(stock.getStockId());
			}
			if(stock.getStockName() != null && !"".equals(stock.getStockName())){
				sql.append(" AND _this.`stock_name` = ?");
				param.add(stock.getStockName());
			}
			if(stock.getStockCode() != null && !"".equals(stock.getStockCode())){
				sql.append(" AND _this.`stock_code` = ?");
				param.add(stock.getStockCode());
			}
			if(stock.getUtime() != null){
				sql.append(" AND _this.`utime` = ?");
				param.add(stock.getUtime());
			}
			if(stock.getCjl() != null){
				sql.append(" AND _this.`cjl` = ?");
				param.add(stock.getCjl());
			}
			if(stock.getStype() != null && !"".equals(stock.getStype())){
				sql.append(" AND _this.`stype` = ?");
				param.add(stock.getStype());
			}
			if(stock.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(stock.getCreateDate());
			}
			if(stock.getUpdateTime() != null){
				sql.append(" AND _this.`update_time` = ?");
				param.add(stock.getUpdateTime());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Stock.class));
	}


	/**
	 * 根据对象查询条数
	 * @param stock
	 * @return Long
	 */
	@Override
	public Long count(Stock stock){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM smc_stock  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(stock != null){
			if(stock.getStockId() != null){
				sql.append(" AND _this.`stock_id` = ? ");
				param.add(stock.getStockId());
			}
			if(stock.getStockName() != null && !"".equals(stock.getStockName())){
				sql.append(" AND _this.`stock_name` = ? ");
				param.add(stock.getStockName());
			}
			if(stock.getStockCode() != null && !"".equals(stock.getStockCode())){
				sql.append(" AND _this.`stock_code` = ? ");
				param.add(stock.getStockCode());
			}
			if(stock.getUtime() != null){
				sql.append(" AND _this.`utime` = ? ");
				param.add(stock.getUtime());
			}
			if(stock.getCjl() != null){
				sql.append(" AND _this.`cjl` = ? ");
				param.add(stock.getCjl());
			}
			if(stock.getStype() != null && !"".equals(stock.getStype())){
				sql.append(" AND _this.`stype` = ? ");
				param.add(stock.getStype());
			}
			if(stock.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(stock.getCreateDate());
			}
			if(stock.getUpdateTime() != null){
				sql.append(" AND _this.`update_time` = ? ");
				param.add(stock.getUpdateTime());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}