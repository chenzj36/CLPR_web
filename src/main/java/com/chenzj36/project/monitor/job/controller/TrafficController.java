package com.chenzj36.project.monitor.job.controller;

import com.chenzj36.project.monitor.job.service.ITrafficService;

import com.chenzj36.project.monitor.job.task.TrafficTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/4/23 14:53
 * @Description
 */
@Controller
public class TrafficController {

    @Autowired
    public ITrafficService trafficService;

//    @RequestMapping("/getLastRecordId")
//    @ResponseBody
//    public Integer getLastRecordId(){
//        TrafficTask trafficTask = new TrafficTask();
//        return trafficTask.getLastOneRecord(trafficService);
//    }
}
