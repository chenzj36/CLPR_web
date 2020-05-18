package com.chenzj36.project.home.routeTraffic.service;


import com.chenzj36.project.home.routeTraffic.domain.Record;

import java.util.List;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/4/25 08:57
 * @Description
 */
public interface IRouterService {
    public List<Integer> getRouteTraffic();

    public List<Record> getNewRecord();
}
