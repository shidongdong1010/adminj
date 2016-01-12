package com.lhy.adminj.sys.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhy.adminj.basic.service.UserCommonFriendsService;

/**
 * 查找共同好友定时任务
 * @author wn
 *
 */
@Service("commonFriendTask")
public class FindCommonFriendTask {
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
	@Autowired
    private UserCommonFriendsService userCommonFriendsService;
	
	public void find() {
		try{
			logger.info("查找共同好友定时任务开始执行");
			userCommonFriendsService.executeFindCommonFriend();
			System.out.println("查找共同好友定时任务");
		}catch (Exception e){
			e.printStackTrace();
			logger.error("查找共同好友定时任务出错", e);
		}
	}
}
