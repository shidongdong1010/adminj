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

import com.lhy.adminj.basic.dao.base.StockHisBaseDao;
import com.lhy.adminj.basic.model.StockHis;

/**
 * 股票历史表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockHisBaseDaoImpl implements StockHisBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`his_stock_id`, _this.`stock_name`, _this.`stock_code`, _this.`zdf`, _this.`zds`, _this.`zgj`, _this.`utime`, _this.`cjl`, _this.`jkp`, _this.`zdj`, _this.`stype`, _this.`cjje`, _this.`zsp`, _this.`zxz`, _this.`create_date`, _this.`update_time`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`his_stock_id`, _this.`stock_name`, _this.`stock_code`, _this.`zdf`, _this.`zds`, _this.`zgj`, _this.`utime`, _this.`cjl`, _this.`jkp`, _this.`zdj`, _this.`stype`, _this.`cjje`, _this.`zsp`, _this.`zxz`, _this.`create_date`, _this.`update_time` FROM smc_stock_his _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO smc_stock_his(`his_stock_id`, `stock_name`, `stock_code`, `zdf`, `zds`, `zgj`, `utime`, `cjl`, `jkp`, `zdj`, `stype`, `cjje`, `zsp`, `zxz`, `create_date`, `update_time`) VALUES (:his_stock_id, :stock_name, :stock_code, :zdf, :zds, :zgj, :utime, :cjl, :jkp, :zdj, :stype, :cjje, :zsp, :zxz, :create_date, :update_time)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE smc_stock_his SET `his_stock_id` = :his_stock_id, `stock_name` = :stock_name, `stock_code` = :stock_code, `zdf` = :zdf, `zds` = :zds, `zgj` = :zgj, `utime` = :utime, `cjl` = :cjl, `jkp` = :jkp, `zdj` = :zdj, `stype` = :stype, `cjje` = :cjje, `zsp` = :zsp, `zxz` = :zxz, `create_date` = :create_date, `update_time` = :update_time WHERE `his_stock_id` = :his_stock_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM smc_stock_his WHERE `his_stock_id` = ?";

	@Override
	public void save(StockHis stockHis) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(stockHis);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		stockHis.setHisStockId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(StockHis stockHis) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(stockHis);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(StockHis stockHis) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE smc_stock_his SET ");
		if(stockHis.getHisStockId() != null){
			sql.append(" his_stock_id = ?, ");
			param.add(stockHis.getHisStockId());
		}
		if(stockHis.getStockName() != null){
			sql.append(" stock_name = ?, ");
			param.add(stockHis.getStockName());
		}
		if(stockHis.getStockCode() != null){
			sql.append(" stock_code = ?, ");
			param.add(stockHis.getStockCode());
		}
		if(stockHis.getZdf() != null){
			sql.append(" zdf = ?, ");
			param.add(stockHis.getZdf());
		}
		if(stockHis.getZds() != null){
			sql.append(" zds = ?, ");
			param.add(stockHis.getZds());
		}
		if(stockHis.getZgj() != null){
			sql.append(" zgj = ?, ");
			param.add(stockHis.getZgj());
		}
		if(stockHis.getUtime() != null){
			sql.append(" utime = ?, ");
			param.add(stockHis.getUtime());
		}
		if(stockHis.getCjl() != null){
			sql.append(" cjl = ?, ");
			param.add(stockHis.getCjl());
		}
		if(stockHis.getJkp() != null){
			sql.append(" jkp = ?, ");
			param.add(stockHis.getJkp());
		}
		if(stockHis.getZdj() != null){
			sql.append(" zdj = ?, ");
			param.add(stockHis.getZdj());
		}
		if(stockHis.getStype() != null){
			sql.append(" stype = ?, ");
			param.add(stockHis.getStype());
		}
		if(stockHis.getCjje() != null){
			sql.append(" cjje = ?, ");
			param.add(stockHis.getCjje());
		}
		if(stockHis.getZsp() != null){
			sql.append(" zsp = ?, ");
			param.add(stockHis.getZsp());
		}
		if(stockHis.getZxz() != null){
			sql.append(" zxz = ?, ");
			param.add(stockHis.getZxz());
		}
		if(stockHis.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(stockHis.getCreateDate());
		}
		if(stockHis.getUpdateTime() != null){
			sql.append(" update_time = ? ");
			param.add(stockHis.getUpdateTime());
		}
		sql.append(" WHERE his_stock_id = ? ");
		param.add(stockHis.getHisStockId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param stockHiss
	 * @return
	 */
	public Map<String, Object>[] toMap(List<StockHis> stockHiss){
		Map<String, Object>[] maps = new Map[stockHiss.size()];
		for(int i = 0; i < stockHiss.size(); i++){
			StockHis stockHis = stockHiss.get(i);
			maps[i] = toMap(stockHis);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param stockHis
	 * @return
	 */
	public Map<String, Object> toMap(StockHis stockHis){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("his_stock_id", stockHis.getHisStockId());
        paramMap.put("stock_name", stockHis.getStockName());
        paramMap.put("stock_code", stockHis.getStockCode());
        paramMap.put("zdf", stockHis.getZdf());
        paramMap.put("zds", stockHis.getZds());
        paramMap.put("zgj", stockHis.getZgj());
        paramMap.put("utime", stockHis.getUtime());
        paramMap.put("cjl", stockHis.getCjl());
        paramMap.put("jkp", stockHis.getJkp());
        paramMap.put("zdj", stockHis.getZdj());
        paramMap.put("stype", stockHis.getStype());
        paramMap.put("cjje", stockHis.getCjje());
        paramMap.put("zsp", stockHis.getZsp());
        paramMap.put("zxz", stockHis.getZxz());
        paramMap.put("create_date", stockHis.getCreateDate());
        paramMap.put("update_time", stockHis.getUpdateTime());
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
	public void delete(Long hisStockId){
		jdbcTemplate.update(DELETE_SQL, hisStockId);
	}

	@Override
	public void batchSave(List<StockHis> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<StockHis> list){
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
	 * @param hisStockId 股票表主键
	 * @return StockHis
	 */
	@Override
	public StockHis findById(Long hisStockId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`his_stock_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(StockHis.class), hisStockId);
	}

	/**
	 * 根据对象查询
	 * @param stockHis
	 * @return List
	 */
	@Override
	public List<StockHis> find(StockHis stockHis){
		return this.find(stockHis, null, null);
	}

	/**
	 * 根据对象查询
	 * @param stockHis
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<StockHis> find(StockHis stockHis, String[][] orders){
		return this.find(stockHis, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param stockHis
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<StockHis> find(StockHis stockHis, Long offset, Long rows){
		return this.find(stockHis, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param stockHis
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<StockHis> find(StockHis stockHis, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(stockHis != null){
			if(stockHis.getHisStockId() != null){
				sql.append(" AND _this.`his_stock_id` = ?");
				param.add(stockHis.getHisStockId());
			}
			if(stockHis.getStockName() != null && !"".equals(stockHis.getStockName())){
				sql.append(" AND _this.`stock_name` = ?");
				param.add(stockHis.getStockName());
			}
			if(stockHis.getStockCode() != null && !"".equals(stockHis.getStockCode())){
				sql.append(" AND _this.`stock_code` = ?");
				param.add(stockHis.getStockCode());
			}
			if(stockHis.getUtime() != null){
				sql.append(" AND _this.`utime` = ?");
				param.add(stockHis.getUtime());
			}
			if(stockHis.getCjl() != null){
				sql.append(" AND _this.`cjl` = ?");
				param.add(stockHis.getCjl());
			}
			if(stockHis.getStype() != null && !"".equals(stockHis.getStype())){
				sql.append(" AND _this.`stype` = ?");
				param.add(stockHis.getStype());
			}
			if(stockHis.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(stockHis.getCreateDate());
			}
			if(stockHis.getUpdateTime() != null){
				sql.append(" AND _this.`update_time` = ?");
				param.add(stockHis.getUpdateTime());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(StockHis.class));
	}


	/**
	 * 根据对象查询条数
	 * @param stockHis
	 * @return Long
	 */
	@Override
	public Long count(StockHis stockHis){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM smc_stock_his  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(stockHis != null){
			if(stockHis.getHisStockId() != null){
				sql.append(" AND _this.`his_stock_id` = ? ");
				param.add(stockHis.getHisStockId());
			}
			if(stockHis.getStockName() != null && !"".equals(stockHis.getStockName())){
				sql.append(" AND _this.`stock_name` = ? ");
				param.add(stockHis.getStockName());
			}
			if(stockHis.getStockCode() != null && !"".equals(stockHis.getStockCode())){
				sql.append(" AND _this.`stock_code` = ? ");
				param.add(stockHis.getStockCode());
			}
			if(stockHis.getUtime() != null){
				sql.append(" AND _this.`utime` = ? ");
				param.add(stockHis.getUtime());
			}
			if(stockHis.getCjl() != null){
				sql.append(" AND _this.`cjl` = ? ");
				param.add(stockHis.getCjl());
			}
			if(stockHis.getStype() != null && !"".equals(stockHis.getStype())){
				sql.append(" AND _this.`stype` = ? ");
				param.add(stockHis.getStype());
			}
			if(stockHis.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(stockHis.getCreateDate());
			}
			if(stockHis.getUpdateTime() != null){
				sql.append(" AND _this.`update_time` = ? ");
				param.add(stockHis.getUpdateTime());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}