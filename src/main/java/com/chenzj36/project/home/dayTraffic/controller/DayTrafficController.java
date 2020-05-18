package com.chenzj36.project.home.dayTraffic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chenzj36.framework.config.ServerConfig;
import com.chenzj36.project.home.dayTraffic.service.IDayService;
import org.omg.PortableInterceptor.INACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chenzj36.framework.web.controller.BaseController;
import com.chenzj36.framework.web.domain.AjaxResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Home页面交通流量请求处理
 * 
 * @author chenzj36
 */
@Controller
public class DayTrafficController extends BaseController
{
    private static final Logger log = LoggerFactory.getLogger(DayTrafficController.class);

    private static int datT = 8888;


    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private IDayService dayService;

    /**
     * 请求
     */
//    @GetMapping("/home/getDayTraffic")
//    @ResponseBody
//    public AjaxResult getDayTraffic()
//    {
//        datT += 10;
//        return success(Integer.toString(datT));
//    }


    @RequestMapping("/home/getDayTraffic")
    @ResponseBody
    public JSON getDayTraffic(){
        JSONObject object = new JSONObject();

        Integer dayTraffic = dayService.getDayTraffic();

        object.put("top1", dayTraffic);
        object.put("top2", dayTraffic-536);
        object.put("top3", dayTraffic+1799);
        object.put("top4", dayTraffic+536);

        return object;
    }


//    @RequestMapping("/home/getData")
//    @ResponseBody
//    public String getData(){
//        Integer dayTraffic = dayService.getDayTraffic();
//        Integer traffic = (dayTraffic/5000)*100;
//        if(traffic ==101){
//            traffic = 50;
//        }
//        return Integer.toString(traffic);
//    }


    @RequestMapping("/home/getDaySingelMax")
    @ResponseBody
    public JSON getDaySingelMax(){
        JSONObject object = new JSONObject();
        //string
        object.put("string","string");
        //int
        object.put("int",2);
        //boolean
        object.put("boolean",true);
        //array
        List<Integer> integers = Arrays.asList(1,2,3);
        object.put("list",integers);
        //null
        object.put("null",null);
        return object;
    }

}
