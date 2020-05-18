package com.chenzj36.project.monitor.job.domain;

import java.util.List;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/4/24 10:57
 * @Description
 */
public class Mapper_1 {
    private String timestamp;
    private List<Integer> capID;
    private String plate_num;



    public Mapper_1(String timestamp, List<Integer> capID, String plate_num) {
        this.timestamp = timestamp;
        this.capID = capID;
        this.plate_num = plate_num;
    }

    public List<Integer> getCapID() {
        return capID;
    }

    public void setPlate_num(String plate_num) {
        this.plate_num = plate_num;
    }

    public String getPlate_num() {
        return plate_num;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setCapID(List<Integer> capID) {
        this.capID = capID;
    }

    @Override
    public String toString() {
        return "Mapper_1{" +
                "timestamp='" + timestamp + '\'' +
                ", capID=" + capID +
                ", plate_num='" + plate_num + '\'' +
                '}';
    }
}
