package com.unfbx.zdm_push.controller.actions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: ZedQ
 * @Date: 2022/12/16 14:59
 * @Description:
 */
@Component
@Slf4j
public class Actions {

    @Resource
    GetTopList getTopList;

    //抓取api  topList
    @Scheduled(cron = "${corn.top}")
    public void ActionsApiList(){
        log.info("进入corn");
        for (int i=100001;i<100113;i++)
            getTopList.getRequest(i);
        log.info("结束corn");

    }
}
