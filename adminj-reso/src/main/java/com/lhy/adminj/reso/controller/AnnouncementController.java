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

import com.lhy.adminj.basic.model.AnnouncementInfo;
import com.lhy.adminj.basic.service.AnnouncementInfoService;
import com.lhy.adminj.basic.util.ObjectUtil;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import com.lhy.common.lang.StringUtil;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResult;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResultHelper;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private AnnouncementInfoService announcementInfoService;
	
	@Autowired
    private JsonResultHelper       jsonResultHelper;
	
	/**
     * 图像上传路径
     **/
    @Value("#{properties['announcementPath']}")
    private String announcementPath;
    
	/**
     * 公告列表页面
     **/
    @RequestMapping("/announcementList.html")
    public String announcementList() {
        logger.info("公告列表界面");

        return "/tactics/announcement/announcementList";
    }

    /**
     * 公告列表记录
     **/
    @RequestMapping("/announcementDataList.json")
    @ResponseBody
    public Page<AnnouncementInfo> announcementDataList(AnnouncementInfo announcementInfo, HttpServletRequest request) {
        logger.info("公告列表记录: {}", announcementInfo);

        // 去掉为空字符串的条件
        ObjectUtil.nullStringConverNull(announcementInfo);

        Page<AnnouncementInfo> page = PageUtil.getPage(request);
        
        // 统计总记录数
        page.setTotal(announcementInfoService.count(announcementInfo));
        
        List<AnnouncementInfo> list = announcementInfoService.find(announcementInfo, page.getFirst(), page.getPageSize());
        
        page.setRows(list);
        return page;
    }
    
    /**
     * 进入新增公告页面
     **/
    @RequestMapping("/toinsertAnnouncement.html")
    public String toinsertAnnouncement() {
        logger.info("进入新增公告页面");
        return "/tactics/announcement/announcementEdit";
    }
    
    /**
     * 进入修改公告页面
     **/
    @RequestMapping("/preUpdateAnnouncement.html")
    public String preUpdateAnnouncement(HttpServletRequest request,Model model) {
        logger.info(" 进入修改公告页面");
        String announcementId = request.getParameter("announcementId");
        AnnouncementInfo announcementInfo =announcementInfoService.findById(Long.parseLong(announcementId));
        model.addAttribute("announcementInfo", announcementInfo);
        return "/tactics/announcement/announcementEdit";
    }
    
    
    /**
     * 新增或修改公告
     * @param announcementTitle
     * @param announcementLogo
     * @param announcementDesc
     * @param announcementId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/insertAnnouncement.json")
    @ResponseBody
    public JsonResult insertAnnouncement(HttpServletRequest request,@RequestParam MultipartFile announcementUrl) {
    	String announcementTitle = request.getParameter("announcementTitle");
    	String announcementLogo = request.getParameter("announcementLogo");
    	String announcementDesc = request.getParameter("announcementDesc");
    	String announcementId = request.getParameter("announcementId");
    	HttpSession session = request.getSession();
        if(StringUtil.isEmpty(announcementTitle) || StringUtil.isEmpty(announcementLogo) || StringUtil.isEmpty(announcementDesc)){
        	return jsonResultHelper.buildFailJsonResultWithErrorMsg("公告标题或公告标语或公告内容不能为空！");
        }
        try{
        	String filePath = announcementPath;
        	String url = session.getServletContext().getRealPath(File.separator);
    		String path = url+filePath;
        	if(StringUtil.isEmpty(announcementId) ){
        		if(null == announcementUrl|| StringUtil.isEmpty(announcementUrl.getOriginalFilename())){
                	return jsonResultHelper.buildFailJsonResultWithErrorMsg("操作失败！");
                }
        		String announcementUrlName = announcementUrl.getOriginalFilename();
            	String[] fileTypes = new String[] { ".jpg", ".bmp", ".gif", ".png" };
            	if(!verifySuffix(announcementUrlName,fileTypes)){
            		return jsonResultHelper.buildFailJsonResultWithErrorMsg("操作失败,公告logo格式错误");
            	}
            	String newAnnouncementUrlName = String.valueOf(System.currentTimeMillis())+ "_" + announcementUrlName;
            	if(!saveFile(newAnnouncementUrlName,announcementUrl,path)){
            		return jsonResultHelper.buildFailJsonResultWithErrorMsg("保存公告logo失败！");
            	}
        		AnnouncementInfo announcementInfo = new AnnouncementInfo();
            	announcementInfo.setAnnouncementTitle(announcementTitle);
            	announcementInfo.setAnnouncementLogo(announcementLogo);
            	announcementInfo.setAnnouncementUrl(File.separator+filePath+newAnnouncementUrlName);
            	announcementInfo.setAnnouncementDesc(announcementDesc);
            	announcementInfo.setAnnouncementCreateId(6L);
            	announcementInfo.setCreateTime(new Date());
            	announcementInfo.setIsDel("1");
            	announcementInfoService.save(announcementInfo);
        	}else{
        		AnnouncementInfo announcementInfo =announcementInfoService.findById(Long.parseLong(announcementId));
        		if(null != announcementUrl&& !StringUtil.isEmpty(announcementUrl.getOriginalFilename())){
        			String announcementUrlName = announcementUrl.getOriginalFilename();
                	String[] fileTypes = new String[] { ".jpg", ".bmp", ".gif", ".png" };
                	if(!verifySuffix(announcementUrlName,fileTypes)){
                		return jsonResultHelper.buildFailJsonResultWithErrorMsg("操作失败,公告logo格式错误");
                	}
                	String newAnnouncementUrlName = String.valueOf(System.currentTimeMillis());
                	if(!saveFile(newAnnouncementUrlName,announcementUrl,path)){
                		return jsonResultHelper.buildFailJsonResultWithErrorMsg("保存公告logo失败！");
                	}
                	announcementInfo.setAnnouncementUrl(File.separator+filePath+newAnnouncementUrlName);
        		}
        		announcementInfo.setAnnouncementTitle(announcementTitle);
             	announcementInfo.setAnnouncementLogo(announcementLogo);
             	announcementInfo.setAnnouncementDesc(announcementDesc);
             	announcementInfo.setAnnouncementUpdateId(7L);
             	announcementInfo.setUpdateTime(new Date());
             	announcementInfoService.update(announcementInfo);
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
			out = new FileOutputStream(path + newFileName);
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
     * 删除公告
     * @param request
     * @return
     */
    @RequestMapping("/delAnnouncement.json")
    @ResponseBody
    public JsonResult delAnnouncement(HttpServletRequest request) {
    	String announcementId = request.getParameter("announcementId");
    	try{
    		 AnnouncementInfo announcementInfo =announcementInfoService.findById(Long.parseLong(announcementId));
    	     announcementInfo.setIsDel("0");
    	     announcementInfoService.update(announcementInfo);
    	}catch(Exception e){
         	e.printStackTrace();
         	logger.info(e.getMessage());
         	return jsonResultHelper.buildFailJsonResultWithErrorMsg("删除公告失败！");
        }
    	return jsonResultHelper.buildSuccessJsonResult("删除公告成功");
    }
    
    /**
     * 进入预览公告页面
     **/
    @RequestMapping("/checkAnnouncement.html")
    public String checkAnnouncement(HttpServletRequest request,Model model) {
        logger.info(" 进入修改公告页面");
        String announcementId = request.getParameter("announcementId");
        AnnouncementInfo announcementInfo =announcementInfoService.findById(Long.parseLong(announcementId));
        model.addAttribute("announcementInfo", announcementInfo);
        return "/tactics/announcement/announcementCheck";
    }
    
    
}
