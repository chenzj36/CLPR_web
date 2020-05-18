package com.chenzj36.project.home.routeTraffic.mapper;

import com.chenzj36.project.home.routeTraffic.domain.Record;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/4/25 09:00
 * @Description
 */
@Mapper
@Component
public interface RouteTrafficMapper {

    public List<Integer> getRouteTraffic();

    public List<Record> getNewRecord();

    public String getRecLoc(String gantry);
}
