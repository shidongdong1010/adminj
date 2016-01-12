package com.lhy.adminj.sys.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lhy.adminj.basic.enumeration.CityValidFlagEnum;
import com.lhy.adminj.basic.model.City;
import com.lhy.adminj.basic.model.Province;
import com.lhy.adminj.basic.service.CityService;
import com.lhy.adminj.basic.service.ProvinceService;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;

/**
 * 城市Controllers
 * @author wn
 * @version $v: 1.0.0, $time:2015/9/30 13:14 Exp $
 */
@Controller
@RequestMapping("/sys")
public class CityController {

    @Autowired
    private CityService cityService;
    
    @Autowired
    private ProvinceService provinceService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 城市信息管理
     **/
    @RequestMapping("/city/index.html")
    public ModelAndView index(ModelAndView view) {
        logger.info("城市信息管理");
        List<Province> provinces = provinceService.find(new Province());
        view.addObject("provinces", provinces);
        view.setViewName("/sys/city/index");
        return view;
    }
    
    /**
     * 城市信息管理列表记录
     **/
    @RequestMapping("/city/list.json")
    @ResponseBody
    public Page<Map<String, Object>> list(City city, HttpServletRequest request) {
    	
        Page<Map<String, Object>> page = PageUtil.getPage(request);
        // 统计总记录数
        page.setTotal(cityService.count(city));
        // 分页记录
        List<Map<String, Object>> list = cityService.findCity(city, page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }
    /**
     * 删除信息
     * @param cityIds
     * @return
     */
    @RequestMapping("/city/remove.json")
    @ResponseBody
    public String remove(String cityIds){
    	String status = "1";
    	try {
			String[] cityIdArray = cityIds.split(",");
			cityService.delete(cityIdArray);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除城市信息异常cityIds="+cityIds,e);
			status = "2";
		}
    	return status;
    }
    /**
     * 添加或修改
     * @param city
     * @return
     */
    @RequestMapping("/city/saveOrUpdate.json")
    @ResponseBody
    public String saveOrUpdate(City city){
    	String status = "1";
    	try {
    		if(null==city.getCityId()){
    			cityService.save(city);
    		}else{
    			cityService.update(city);
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除城市信息异常city="+city,e);
			status = "2";
		}
    	return status;
    }
    /**
     * 根据省份id查询所有显示的城市
     * @param provinceId
     * @return
     */
    @ResponseBody
    @RequestMapping("/city/queryByProvinceId.json")
    public List<City> queryCitiesByProvince(Long provinceId){
    	return cityService.find(new City(provinceId, CityValidFlagEnum.Y.getCode()));
    }

}
