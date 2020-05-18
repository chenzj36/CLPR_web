package com.chenzj36.project.monitor.job.service;

import com.chenzj36.project.monitor.job.domain.CapRecord;
import com.chenzj36.project.monitor.job.domain.Mapper_1;

import java.util.List;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/4/23 14:57
 * @Description
 */
public interface ITrafficService {
    /**
     * 查询capture_record表中最后一条数据的id
     *
     * @param
     * @return 最后一条数据的id
     */
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
