package com.chenzj36.project.monitor.job.mapper;

import com.chenzj36.project.monitor.job.domain.CapRecord;
import com.chenzj36.project.monitor.job.domain.Mapper_1;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/4/23 15:01
 * @Description
 */
@Mapper
@Component
public interface TrafficMapper {
    public Integer getLastOneRecord();

    public CapRecord getOneRecord(Integer id);

    public Integer getCapGantry(Integer cap_id);

    public Integer getPos(Integer cap_gantry);

    public Integer getNeg(Integer cap_gantry);

    public void addLinkTraffic(Integer lf_id);

    public List<Integer> getBeforePosGantry(Integer lf_id, Integer gantry_id);

    public List<Integer> findUCapID(Integer gantry_id);

    public List<Integer> whetherHaveRec(Mapper_1 mapper);

    public void minusLinkTraffic(Integer lf_id);

    public void initLinkTraffic();
}
