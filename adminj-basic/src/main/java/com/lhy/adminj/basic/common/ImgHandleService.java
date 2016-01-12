package com.lhy.adminj.basic.common;

import java.io.*;
import java.net.URL;
import java.util.Arrays;

import org.apache.commons.io.input.TeeInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lhy.common.lang.StringUtil;

/**
 * 图片处理服务类
 *
 * @author SDD
 */
@Service
public class ImgHandleService {

    /**
     * 图像上传路径
     **/
    @Value("#{properties['uploadPicPath']}")
    private String uploadPicPath;
    
    /** 用户头像上传路径 **/
    @Value("#{properties['uploadHeadPicPath']}")
    private String              uploadHeadPicPath;

    String[] fileExts = {"bmp", "png", "jpeg", "jpg", "gif", "BMP", "PNG", "JPEG", "JPG", "GIF"};
    Long maxSize = 1024 * 1024 * 5L;


    private static final Logger LOGGER = LoggerFactory.getLogger(ImgHandleService.class);

    /**
     * 检查是否是图片
     *
     * @param file
     * @return
     */
    public boolean isImg(MultipartFile file) {
        // 获取文件的后缀名
        String fileName = file.getOriginalFilename();// 得到文件的名字
        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        if (Arrays.binarySearch(fileExts, fileExt) == -1) {
            return false;
        }
        return true;
    }

    /**
     * 得到头像的文件
     *
     * @param imgPath
     * @return
     * @throws FileNotFoundException
     */
    public File getImgFile(String imgPath, int size) throws FileNotFoundException {
        String fileName = uploadPicPath + File.separator + imgPath;
        return new File(fileName);
    }

    /**
     * 保存图片
     *
     * @param multipartFile
     * @param relativePath
     * @return
     * @throws IOException
     */
    public String saveImg(MultipartFile multipartFile, String relativePath, String fileName) throws IOException {
        // 目录
        String filePath = relativePath; // 相对路径
        String absFilePath = uploadPicPath + filePath; // 绝对路径

        File uploadedFileDir = new File(absFilePath);
        if (!uploadedFileDir.exists()) {
            uploadedFileDir.mkdirs();
        }
        // 输出的图片名称
        String picName = filePath + File.separator + fileName  + ".jpg";
        String absPicName = uploadPicPath + File.separator + picName;

        // 保存文件
        File file = new File(absPicName);
        multipartFile.transferTo(file);
        return picName;
    }
    /**
     * 处理保存并压缩图片
     * @param file
     * @param userId
     * @return
     * @throws IOException 
     */
    public String saveHeadImg(String urlString, Long userId) {
        String picName = null;
		try {
			URL url = new URL(urlString);
			picName = saveHeadImg(url.openStream(), userId);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return picName;
    }
    /**
     * 处理保存并压缩图片
     * @param in 字节流
     * @param userId
     * @return
     * @throws IOException 
     */
    public String saveHeadImg(InputStream in, Long userId) {
        // 目录
        String filePath = userId + ""; // 相对路径
        String absFilePath = uploadHeadPicPath + File.separator + filePath; // 绝对路径

        File uploadedFileDir = new File(absFilePath);
        if (!uploadedFileDir.exists()) {
            uploadedFileDir.mkdirs();
        }
        // 输出的图片名称
        String picName = filePath + File.separator + System.currentTimeMillis() + ".jpg";
        String absPicName = uploadHeadPicPath + File.separator + picName;

			
        // 处理压缩图片
		try {
			/*ImgCompress imgCom = new ImgCompress(in, absPicName);
			imgCom.resizeFix(headPicWidth, headPicHeight);*/
			
			// 将图片压缩成三种类型的，分别为100, 200, 400相素的图片
			ImgCompressTee imgCompressTee = new ImgCompressTee(in, absPicName);
			imgCompressTee.resizeFix();
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.error("处理保存并压缩图片出错, userId: " + userId, e);
		}
        return picName;
    }

    
    public String getUploadPicPath() {
		return uploadPicPath;
	}

	public void setUploadPicPath(String uploadPicPath) {
		this.uploadPicPath = uploadPicPath;
	}

	public String getUploadHeadPicPath() {
        return uploadHeadPicPath;
    }

    public void setUploadHeadPicPath(String uploadHeadPicPath) {
        this.uploadHeadPicPath = uploadHeadPicPath;
    }

}
