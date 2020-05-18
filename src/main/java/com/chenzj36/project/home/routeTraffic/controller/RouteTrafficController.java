package com.chenzj36.project.home.routeTraffic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chenzj36.framework.config.ServerConfig;
import com.chenzj36.framework.web.controller.BaseController;
import com.chenzj36.framework.web.domain.AjaxResult;
import com.chenzj36.project.home.routeTraffic.domain.Record;
import com.chenzj36.project.home.routeTraffic.service.IRouterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Home页面交通流量请求处理
 * 
 * @author chenzj36
 */
@Controller
public class RouteTrafficController extends BaseController
{
    private static final Logger log = LoggerFactory.getLogger(RouteTrafficController.class);
    public static int traffic = 10;

    private static int datT = 8;
    private static int[] A = new int[]{1, 3, 5, 7, 9, 1};
    private static int[] B = new int[]{0, 2, 4, 6, 8, 0};

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private IRouterService routerService;

    /**
     * 请求
     */
    @GetMapping("/home/getRouteTraffic")
    @ResponseBody
    public AjaxResult getDayTraffic()
    {
        datT += 10;
        return success(Integer.toString(datT));
    }

    @RequestMapping("/home/getRouteTraffic2")
    @ResponseBody
    public JSON getDaySingelMax(){
        JSONObject object = new JSONObject();
        List<Integer> traffic = routerService.getRouteTraffic();
        for(int i=0; i<5; i++){
            A[i] = traffic.get(i);
            object.put("A"+Integer.toString(i+1), A[i]);
        }
        for(int i=5; i<10; i++){
            B[i-5] = traffic.get(i);
            object.put("B"+Integer.toString(i-4), B[i-5]);
        }
        return object;
    }

    @RequestMapping("/home/getData")
    @ResponseBody
    public String getData(){
        if(traffic ==101){
            traffic = 50;
        }
        traffic += 1;
        return Integer.toString(traffic);
    }

    @RequestMapping("/home/getNewRecord")
    @ResponseBody
    public JSON getNewRecord(){
        JSONObject object = new JSONObject();
        List<Record> records = routerService.getNewRecord();
//        List<Record> records = new ArrayList<>();
//        records.add(new Record("京A00001", "大厂立交前", "2020 4 28 14:00:03.012", "1002"));
//        records.add(new Record("京A00002", "大厂立交前", "2020 4 28 14:00:03.012", "1002"));
//        records.add(new Record("京A00003", "大厂立交前", "2020 4 28 14:00:03.012", "1002"));
        object.put("records",records);
        return object;
    }
}
