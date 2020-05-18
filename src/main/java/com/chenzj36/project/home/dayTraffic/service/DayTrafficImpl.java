package com.chenzj36.project.home.dayTraffic.service;

import com.chenzj36.project.home.dayTraffic.mapper.DayTrafficMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/5/7 21:27
 * @Description
 */
@Service
public class DayTrafficImpl implements IDayService {

    @Autowired
    DayTrafficMapper dayTrafficMapper;

    @Override
    public Integer getDayTraffic() {
        return dayTrafficMapper.getDayTraffic();
    }
}
