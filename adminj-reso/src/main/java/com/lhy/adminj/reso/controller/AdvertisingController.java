package com.lhy.adminj.reso.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lhy.adminj.basic.model.AdvertisingInfo;
import com.lhy.adminj.basic.model.AnnouncementInfo;
import com.lhy.adminj.basic.service.AdvertisingInfoService;
import com.lhy.adminj.basic.util.ObjectUtil;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import com.lhy.common.lang.StringUtil;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResult;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResultHelper;

@Controller
@RequestMapping("/advertising")
public class AdvertisingController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private JsonResultHelper       jsonResultHelper;
	
	@Autowired
	private AdvertisingInfoService advertisingInfoService;
	
	/**
     * 图像上传路径
     **/
    @Value("#{properties['advertisingPath']}")
    private String advertisingPath;
	
	/**
     * 广告列表页面
     **/
    @RequestMapping("/advertisingList.html")
    public String advertisingList() {
        logger.info("广告列表界面");
        return "/tactics/advertising/advertisingList";
    }
    
    /**
     * 广告列表记录
     **/
    @RequestMapping("/advertisingDataList.json")
    @ResponseBody
    public Page<AdvertisingInfo> advertisingDataList(AdvertisingInfo advertisingInfo, HttpServletRequest request) {
        logger.info("广告列表记录: {}", advertisingInfo);

        // 去掉为空字符串的条件
        ObjectUtil.nullStringConverNull(advertisingInfo);

        // 设置条件，只查询未审核的晒单记录

        Page<AdvertisingInfo> page = PageUtil.getPage(request);
        // 统计总记录数
        page.setTotal(advertisingInfoService.count(advertisingInfo));
        List<AdvertisingInfo> list = advertisingInfoService.find(advertisingInfo, page.getFirst(), page.getPageSize());
        
        page.setRows(list);
        return page;
    }
    
    /**
     * 进入新增广告页面
     **/
    @RequestMapping("/toinsertAdvertising.html")
    public String toinsertAdvertising() {
        logger.info("进入新增广告页面");
        return "/tactics/advertising/advertisingEdit";
    }
    
    /**
     * 进入修改广告页面
     **/
    @RequestMapping("/preUpdateAdvertising.html")
    public String preUpdateAdvertising(HttpServletRequest request,Model model) {
        logger.info(" 进入修改广告页面");
        String advertisingId = request.getParameter("advertisingId");
        AdvertisingInfo advertisingInfo =advertisingInfoService.findById(Long.parseLong(advertisingId));
        model.addAttribute("advertisingInfo", advertisingInfo);
        return "/tactics/advertising/advertisingEdit";
    }
    
   
    @RequestMapping("/insertAdvertising.json")
    @ResponseBody
    public JsonResult insertAdvertising(HttpServletRequest request,@RequestParam MultipartFile advertisingLogo) {
    	String advertisingUrl = request.getParameter("advertisingUrl");
    	String advertisingId = request.getParameter("advertisingId");
    	HttpSession session = request.getSession();
        if(StringUtil.isEmpty(advertisingUrl)){
        	return jsonResultHelper.buildFailJsonResultWithErrorMsg("广告url不能为空！");
        }
        try{
        	String filePath = advertisingPath;
        	String url = session.getServletContext().getRealPath(File.separator);
    		String path = url+filePath;
        	if(StringUtil.isEmpty(advertisingId) ){
        		if(null == advertisingLogo|| StringUtil.isEmpty(advertisingLogo.getOriginalFilename())){
                	return jsonResultHelper.buildFailJsonResultWithErrorMsg("操作失败！");
                }
        		String advertisingLogoName = advertisingLogo.getOriginalFilename();
            	String[] fileTypes = new String[] { ".jpg", ".bmp", ".gif", ".png" };
            	if(!verifySuffix(advertisingLogoName,fileTypes)){
            		return jsonResultHelper.buildFailJsonResultWithErrorMsg("操作失败,广告logo格式错误");
            	}
            	String newadvertisingLogoName = String.valueOf(System.currentTimeMillis());
            	if(!saveFile(newadvertisingLogoName,advertisingLogo,path)){
            		return jsonResultHelper.buildFailJsonResultWithErrorMsg("保存公告logo失败！");
            	}
            	AdvertisingInfo advertisingInfo = new AdvertisingInfo();
            	advertisingInfo.setAdvertisingUrl(advertisingUrl);
            	advertisingInfo.setAdvertisingLogo(File.separator+filePath+newadvertisingLogoName);
            	advertisingInfo.setAdvertisingCreateId(6L);
            	advertisingInfo.setCreateTime(new Date());
            	advertisingInfo.setIsDel("1");
            	advertisingInfoService.save(advertisingInfo);
        	}else{
        		AdvertisingInfo advertisingInfo =advertisingInfoService.findById(Long.parseLong(advertisingId));
        		if(null != advertisingLogo&& !StringUtil.isEmpty(advertisingLogo.getOriginalFilename())){
        			String advertisingLogoName = advertisingLogo.getOriginalFilename();
                	String[] fileTypes = new String[] { ".jpg", ".bmp", ".gif", ".png" };
                	if(!verifySuffix(advertisingLogoName,fileTypes)){
                		return jsonResultHelper.buildFailJsonResultWithErrorMsg("操作失败,公告logo格式错误");
                	}
                	String newAdvertisingLogoName = String.valueOf(System.currentTimeMillis())+ "_" + advertisingLogoName;
                	if(!saveFile(newAdvertisingLogoName,advertisingLogo,path)){
                		return jsonResultHelper.buildFailJsonResultWithErrorMsg("保存公告logo失败！");
                	}
                	advertisingInfo.setAdvertisingLogo(File.separator+filePath+newAdvertisingLogoName);
        		}
        		advertisingInfo.setAdvertisingUrl(advertisingUrl);
             	
        		advertisingInfo.setAdvertisingUpdateId(7L);
        		advertisingInfo.setUpdateTime(new Date());
        		advertisingInfoService.update(advertisingInfo);
        	}
        }catch(Exception e){
        	e.printStackTrace();
        	logger.info(e.getMessage());
        	return jsonResultHelper.buildFailJsonResultWithErrorMsg("操作失败！");
        }
        return jsonResultHelper.buildSuccessJsonResult("操作成功");
    }
    
    /**
     * 验证图片格式
     * @param fileName
     * @param fileTypes
     * @return
     */
    private  boolean verifySuffix(String fileName, String[] fileTypes) {
		for (String type : fileTypes) {
			if (fileName.endsWith(type)) {
				return true;
			}
		}
		return false;
	}
    
    /**
     * 保存图片到服务器
     * @param newFileName
     * @param fileData
     * @return
     */
    private boolean saveFile(String newFileName, MultipartFile fileData,String path) {
		// 写入文件至服务器目录
		FileOutputStream out = null;
		try {
			File prizesFolder = new File(path);
			if (!prizesFolder.exists() || !prizesFolder.isDirectory()) {
				prizesFolder.mkdirs();
			}
			out = new FileOutputStream(path+newFileName);
			// 写入文件
			out.write(fileData.getBytes());
			out.flush();
			return true;
		} catch (Exception e) {
			logger.error("文件写入异常" + e.getMessage());
			return false;
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {

				}
			}
		}
	}
    
    /**
     * 删除广告
     * @param request
     * @return
     */
    @RequestMapping("/delAdvertising.json")
    @ResponseBody
    public JsonResult delAdvertising(HttpServletRequest request) {
    	String advertisingId = request.getParameter("advertisingId");
    	try{
    		AdvertisingInfo advertisingInfo =advertisingInfoService.findById(Long.parseLong(advertisingId));
    		advertisingInfo.setIsDel("0");
    		advertisingInfoService.update(advertisingInfo);
    	}catch(Exception e){
         	e.printStackTrace();
         	logger.info(e.getMessage());
         	return jsonResultHelper.buildFailJsonResultWithErrorMsg("删除广告失败！");
        }
    	return jsonResultHelper.buildSuccessJsonResult("删除广告成功");
    }
    
    /**
     * 进入预览公告页面
     **/
    @RequestMapping("/checkAdvertising.html")
    public String checkAdvertising(HttpServletRequest request,Model model) {
        logger.info(" 进入修改公告页面");
        String advertisingId = request.getParameter("advertisingId");
        AdvertisingInfo advertisingInfo =advertisingInfoService.findById(Long.parseLong(advertisingId));
        model.addAttribute("advertisingInfo", advertisingInfo);
        return "/tactics/advertising/advertisingCheck";
    }
}
