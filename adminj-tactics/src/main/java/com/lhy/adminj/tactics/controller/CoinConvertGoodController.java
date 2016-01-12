package com.lhy.adminj.tactics.controller;

import com.lhy.adminj.basic.common.ImgHandleService;
import com.lhy.adminj.basic.enumeration.CoinConvertGoodIsEnableEnum;
import com.lhy.adminj.basic.enumeration.CoinConvertRuleIsEnableEnum;
import com.lhy.adminj.basic.enumeration.UserDynamicInfoAuditStatusEnum;
import com.lhy.adminj.basic.enumeration.UserDynamicInfoTypeEnum;
import com.lhy.adminj.basic.model.CoinConvertGood;
import com.lhy.adminj.basic.model.CoinConvertRule;
import com.lhy.adminj.basic.model.UserDynamicInfo;
import com.lhy.adminj.basic.resultcode.CoinConvertGoodResultCode;
import com.lhy.adminj.basic.resultcode.UserResultCode;
import com.lhy.adminj.basic.service.CoinConvertGoodService;
import com.lhy.adminj.basic.service.CoinConvertRuleService;
import com.lhy.adminj.basic.util.ObjectUtil;
import com.lhy.adminj.basic.util.page.Page;
import com.lhy.adminj.basic.util.page.PageUtil;
import com.lhy.adminj.basic.util.security.AuthUtil;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResult;
import com.lhy.springframework.web.servlet.mvc.support.json.JsonResultHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 兑换商城
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/17 11:11 Exp $
 */
@Controller
@RequestMapping("/tactics")
public class CoinConvertGoodController {

    @Autowired
    private CoinConvertGoodService coinConvertGoodService;

    @Autowired
    private CoinConvertRuleService coinConvertRuleService;

    @Autowired
    private JsonResultHelper jsonResultHelper;

    @Autowired
    private ImgHandleService imgHandleService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 商品列表页
     * @return
     */
    @RequestMapping("/coinConvertGoodList.html")
    public String coinConvertGoodList(){
        return "/tactics/coin/coinConvertGoodList";
    }

    /**
     * 商品列表
     * @return
     */
    @RequestMapping("/coinConvertGoodList.json")
    @ResponseBody
    public Page<CoinConvertGood> coinConvertGoodList(CoinConvertGood coinConvertGood, HttpServletRequest request){
        logger.info("商品列表记录: {}", coinConvertGood);

        // 去掉为空字符串的条件
        ObjectUtil.nullStringConverNull(coinConvertGood);

        Page<CoinConvertGood> page = PageUtil.getPage(request);

        // 统计总记录数
        page.setTotal(coinConvertGoodService.count(coinConvertGood));
        // 分页记录
        List<CoinConvertGood> list = coinConvertGoodService.find(coinConvertGood, page.getFirst(), page.getPageSize());
        page.setRows(list);
        return page;
    }

    /**
     * 商品上架页
     * @return
     */
    @RequestMapping("/addCoinConvertGood.html")
    public String addCoinConvertGood(Model model){
        CoinConvertRule param = new CoinConvertRule();
        param.setIsEnable(CoinConvertRuleIsEnableEnum.Y.getCode());
        List<CoinConvertRule> list = coinConvertRuleService.find(param);
        CoinConvertRule coinConvertRule = list.get(0);
        model.addAttribute("coinConvertRule", coinConvertRule);
        return "/tactics/coin/addCoinConvertGood";
    }

    /**
     * 商品上架
     * @return
     */
    @RequestMapping("/addCoinConvertGood.json")
    @ResponseBody
    public JsonResult addCoinConvertGood(CoinConvertGood coinConvertGood, MultipartFile minFile, MultipartFile maxFile) throws IOException {
        JsonResult result = valImg(minFile);
        if(result != null) return result;
        result = valImg(maxFile);
        if(result != null) return result;

        // 相对路径
        String relativePath = System.currentTimeMillis() + "";

        // 保存图片
        String minPicName = imgHandleService.saveImg(minFile, relativePath, "min");
        String maxPicName = imgHandleService.saveImg(maxFile, relativePath, "max");

        // 保存商品
        coinConvertGood.setMinPicPath(minPicName);
        coinConvertGood.setMaxPicPath(maxPicName);
        coinConvertGood.setIsEnable(CoinConvertGoodIsEnableEnum.Y.getCode());
        coinConvertGood.setPublishTime(new Date());
        coinConvertGood.setPublishUserId(AuthUtil.getUserId());
        coinConvertGood.setModifyTime(new Date());
        coinConvertGood.setModifyUserId(AuthUtil.getUserId());
        coinConvertGoodService.save(coinConvertGood);

        return jsonResultHelper.buildSuccessJsonResult(null);
    }

    /**
     * 更新商品页
     * @return
     */
    @RequestMapping("/updateCoinConvertGood.html")
    public String updateCoinConvertGood(Long id, Model model){
        CoinConvertGood coinConvertGood = coinConvertGoodService.findById(id);
        model.addAttribute("coinConvertGood", coinConvertGood);

        CoinConvertRule param = new CoinConvertRule();
        param.setIsEnable(CoinConvertRuleIsEnableEnum.Y.getCode());
        List<CoinConvertRule> list = coinConvertRuleService.find(param);
        CoinConvertRule coinConvertRule = list.get(0);
        model.addAttribute("coinConvertRule", coinConvertRule);

        return "/tactics/coin/updateCoinConvertGood";
    }

    /**
     * 更新商品
     * @return
     */
    @RequestMapping("/updateCoinConvertGood.json")
    @ResponseBody
    public JsonResult updateCoinConvertGood(CoinConvertGood coinConvertGood, MultipartFile minFile, MultipartFile maxFile) throws IOException {
        CoinConvertGood oldCoinConvertGood = coinConvertGoodService.findById(coinConvertGood.getId());

        // 相对路径
        String relativePath = System.currentTimeMillis() + "";
        JsonResult result = valImg(minFile);
        if(result == null) {
            // 保存图片
            String minPicName = imgHandleService.saveImg(minFile, relativePath, "min");
            oldCoinConvertGood.setMinPicPath(minPicName);
            coinConvertGood.setMinPicPath(minPicName);
        }
        result = valImg(maxFile);
        if(result == null) {
            // 保存图片
            String maxPicName = imgHandleService.saveImg(maxFile, relativePath, "max");
            oldCoinConvertGood.setMinPicPath(maxPicName);
            coinConvertGood.setMaxPicPath(maxPicName);
        }

        // 保存商品
        oldCoinConvertGood.setName(coinConvertGood.getName());
        oldCoinConvertGood.setBeginTime(coinConvertGood.getBeginTime());
        oldCoinConvertGood.setEndTime(coinConvertGood.getEndTime());
        oldCoinConvertGood.setCoin(coinConvertGood.getCoin());
        oldCoinConvertGood.setAmount(coinConvertGood.getAmount());
        oldCoinConvertGood.setNum(coinConvertGood.getNum());
        oldCoinConvertGood.setDayNum(coinConvertGood.getDayNum());
        oldCoinConvertGood.setIsAddr(coinConvertGood.getIsAddr());
        oldCoinConvertGood.setSummary(coinConvertGood.getSummary());
        oldCoinConvertGood.setUseDesc(coinConvertGood.getUseDesc());
        oldCoinConvertGood.setConvertDesc(coinConvertGood.getConvertDesc());
        oldCoinConvertGood.setIsEnable(CoinConvertGoodIsEnableEnum.Y.getCode());
        oldCoinConvertGood.setModifyTime(new Date());
        oldCoinConvertGood.setModifyUserId(AuthUtil.getUserId());
        coinConvertGoodService.update(oldCoinConvertGood);

        return jsonResultHelper.buildSuccessJsonResult(null);
    }

    private JsonResult valImg(MultipartFile file){
        Long maxSize = 1024 * 1024 * 5L;
        try { //把页面表单中的每一个表单元素解析成一个
            if (file == null || file.isEmpty()) {
                return jsonResultHelper.buildFailJsonResult(CoinConvertGoodResultCode.UPLOA_DHEAD_PIC_ERROR);
            }
            // 图片过大
            if (file.getSize() > maxSize) {
                return jsonResultHelper.buildFailJsonResult(CoinConvertGoodResultCode.UPLOA_DHEAD_PIC_SIZE_LIMIT);
            }
            // 检查是否为图片
            if (!imgHandleService.isImg(file)) {
                return jsonResultHelper.buildFailJsonResult(CoinConvertGoodResultCode.UPLOA_DHEAD_PIC_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
