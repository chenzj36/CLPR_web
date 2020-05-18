package com.chenzj36.project.home.routeTraffic.domain;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/4/29 14:12
 * @Description
 */
public class Record {
    private String plateNum;
    private String recLoc;
    private String recTime;
    private String recCap;

    public Record() {
    }

    public Record(String plateNum, String recLoc, String recTime, String recCap) {
        this.plateNum = plateNum;
        this.recLoc = recLoc;
        this.recTime = recTime;
        this.recCap = recCap;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public String getRecLoc() {
        return recLoc;
    }

    public String getRecTime() {
        return recTime;
    }

    public String getRecCap() {
        return recCap;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public void setRecLoc(String recLoc) {
        this.recLoc = recLoc;
    }

    public void setRecTime(String recTime) {
        this.recTime = recTime;
    }

    public void setRecCap(String recCap) {
        this.recCap = recCap;
    }
}
