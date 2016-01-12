package com.lhy.adminj.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhy.adminj.basic.enumeration.ProvinceValidFlagEnum;
import com.lhy.adminj.basic.model.Province;
import com.lhy.adminj.basic.service.ProvinceService;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;

/**
 * 省份Controllers
 * @author wn
 * @version $v: 1.0.0, $time:2015/9/30 13:14 Exp $
 */
@Controller
@RequestMapping("/sys")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 省份信息管理
     **/
    @RequestMapping("/province/index.html")
    public String index() {
        logger.info("省份信息管理");

        return "/sys/province/index";
    }
    
    /**
     * 省份信息管理列表记录
     **/
    @RequestMapping("/province/list.json")
    @ResponseBody
    public Page<Province> list(Province province, HttpServletRequest request) {
    	
        Page<Province> page = PageUtil.getPage(request);
        // 统计总记录数
        page.setTotal(provinceService.count(province));
        // 分页记录
        List<Province> list = provinceService.find(province, page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }
    /**
     * 删除信息
     * @param provinceIds
     * @return
     */
    @RequestMapping("/province/remove.json")
    @ResponseBody
    public String remove(String provinceIds){
    	String status = "1";
    	try {
			String[] provinceIdArray = provinceIds.split(",");
			provinceService.delete(provinceIdArray);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除省份信息异常provinceIds="+provinceIds,e);
			status = "2";
		}
    	return status;
    }
    /**
     * 添加或修改
     * @param province
     * @return
     */
    @RequestMapping("/province/saveOrUpdate.json")
    @ResponseBody
    public String saveOrUpdate(Province province){
    	String status = "1";
    	try {
    		if(null==province.getProvinceId()){
    			provinceService.save(province);
    		}else{
    			provinceService.update(province);
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除省份信息异常province="+province,e);
			status = "2";
		}
    	return status;
    }
    /**
     * 查询所有显示的省份
     * @return
     */
    @ResponseBody
    @RequestMapping("/province/queryAll.json")
    public List<Province> queryAllpProvinces(){
    	return provinceService.find(new Province(ProvinceValidFlagEnum.Y.getCode()));
    }

}
