package com.vivolvle.fundation.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author liangzheng.wei
 * @version 1.0
 * @date 2019/7/16 14:16
 */
@Service
public class ScheduleService {

    private Integer id=1;

    @Scheduled(fixedRate = 15 * 1000, initialDelay = 5*1000)
    public void updateVersionMap() {
        System.out.println(id++);
    }
}
