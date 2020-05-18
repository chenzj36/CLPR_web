package com.chenzj36.project.monitor.job.service;

import com.chenzj36.project.monitor.job.domain.CapRecord;
import com.chenzj36.project.monitor.job.domain.Mapper_1;
import com.chenzj36.project.monitor.job.mapper.TrafficMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/4/23 15:00
 * @Description
 */
@Service
public class TrafficServiceImpl implements ITrafficService {

    @Autowired
    TrafficMapper trafficMapper;

    @Override
    public Integer getLastOneRecord() {
        return trafficMapper.getLastOneRecord();
    }

    @Override
    public CapRecord getOneRecord(Integer id) {
        return trafficMapper.getOneRecord(id);
    }

    @Override
    public Integer getCapGantry(Integer cap_id) {
        return trafficMapper.getCapGantry(cap_id);
    }

    @Override
    public Integer getPos(Integer cap_gantry) {

        return trafficMapper.getPos(cap_gantry);
    }

    @Override
    public Integer getNeg(Integer cap_gantry) {

        return trafficMapper.getNeg(cap_gantry);
    }

    @Override
    public void addLinkTraffic(Integer lf_id) {
        trafficMapper.addLinkTraffic(lf_id);
    }

    @Override
    public List<Integer> getBeforePosGantry(Integer lf_id, Integer gantry_id) {
        return trafficMapper.getBeforePosGantry(lf_id, gantry_id);
    }

    @Override
    public List<Integer> findUCapID(Integer gantry_id) {
        return trafficMapper.findUCapID(gantry_id);
    }

    @Override
    public List<Integer> whetherHaveRec(Mapper_1 mapper) {
        return trafficMapper.whetherHaveRec(mapper);
    }

    @Override
    public void minusLinkTraffic(Integer lf_id) {
        trafficMapper.minusLinkTraffic(lf_id);
    }

    @Override
    public void initLinkTraffic() {
        trafficMapper.initLinkTraffic();
    }
}
