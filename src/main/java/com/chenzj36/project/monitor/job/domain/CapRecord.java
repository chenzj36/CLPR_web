package com.chenzj36.project.monitor.job.domain;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/4/24 08:53
 * @Description
 */
public class CapRecord {
    private String cap_id;
    private String rec_time;
    private String plate_num;

    public String getCap_id() {
        return cap_id;
    }

    public String getRec_time() {
        return rec_time;
    }

    public String getPlate_num() {
        return plate_num;
    }

    public void setCap_id(String cap_id) {
        this.cap_id = cap_id;
    }

    public void setRec_time(String rec_time) {
        this.rec_time = rec_time;
    }

    public void setPlate_num(String plate_num) {
        this.plate_num = plate_num;
    }

    @Override
    public String toString() {
        return "CapRecord{" +
                "cap_id='" + cap_id + '\'' +
                ", rec_time='" + rec_time + '\'' +
                ", plate_num='" + plate_num + '\'' +
                '}';
    }
}
