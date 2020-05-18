package com.chenzj36.project.home.routeTraffic.service;

import com.chenzj36.project.home.routeTraffic.domain.Record;
import com.chenzj36.project.home.routeTraffic.mapper.RouteTrafficMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/4/25 08:59
 * @Description
 */

@Service
public class RouteTrafficImpl implements IRouterService {

    @Autowired
    RouteTrafficMapper trafficMapper;

    @Override
    public List<Integer> getRouteTraffic() {
        return trafficMapper.getRouteTraffic();
    }

    @Override
    public List<Record> getNewRecord() {
        List<Record> records = trafficMapper.getNewRecord();
        for(int i=0; i<records.size(); i++){
            String cap = records.get(i).getRecCap();
            String gantry = cap.substring(0,3);
            System.out.println("gantry:"+gantry);
            String gantryName = trafficMapper.getRecLoc(gantry);
            records.get(i).setRecLoc(gantryName);
            String rec_time = records.get(i).getRecTime();
            rec_time = rec_time.substring(0,23);
            records.get(i).setRecTime(rec_time);
        }
        return records;
    }

}
