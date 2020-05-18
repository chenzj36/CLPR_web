package com.chenzj36.project.monitor.job.task;

import com.chenzj36.project.monitor.job.domain.CapRecord;
import com.chenzj36.project.monitor.job.domain.Mapper_1;
import com.chenzj36.project.monitor.job.service.ITrafficService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/4/23 16:29
 * @Description
 */
@Component("trafficTask")
public class TrafficTask {
    @Autowired
    public ITrafficService trafficService;

    Logger logger = LoggerFactory.getLogger(getClass());

    private static boolean first = true;

    private static int lastID;

    public void getLastOneRecord(){
        Integer lastId = trafficService.getLastOneRecord();
        logger.info("lastId:"+Integer.toString(lastId));
//        getOneRecord(2139);
//        getCapGantry(1001);
//        getPos(110);
//        getNeg(110);
//        addLinkTraffic(10);
//        getBeforePosGantry(11, 120);
//        findUCapID(101);
//        List<Integer> capID = new ArrayList<>();
//        Collections.addAll(capID, 1011, 1012);
//        whetherHaveRec("2020-04-23 13:51:49.131", capID);
        flowDetection();
    }

    public void getOneRecord(Integer id){
        CapRecord capRecord = trafficService.getOneRecord(id);
        logger.info("cap_record:"+capRecord.toString());
    }

    public void getCapGantry(Integer cap_id){
        Integer capGantry = trafficService.getCapGantry(cap_id);
        logger.info("capGantry:"+Integer.toString(capGantry));
    }

    public void getPos(Integer cap_gantry){
        Integer pos = trafficService.getPos(cap_gantry);
        logger.info("pos"+ pos);
    }

    public void getNeg(Integer cap_gantry){
        Integer neg = trafficService.getNeg(cap_gantry);
        logger.info("neg"+ neg);
    }

    public void addLinkTraffic(Integer lf_id){
        trafficService.addLinkTraffic(lf_id);
    }

    public void getBeforePosGantry(Integer lf_id, Integer gantry_id){
        List<Integer> list = trafficService.getBeforePosGantry(lf_id, gantry_id);
        logger.info("beforeList:"+list.toString());
    }

    public void findUCapID(Integer gantry_id){
        List<Integer> list = trafficService.findUCapID(gantry_id);
        logger.info("findUCapID:"+list.toString());
    }

    public void whetherHaveRec(String timestamp, List<Integer> capID){
        Mapper_1 mapper = new Mapper_1(timestamp, capID, "车牌号");
        List<Integer> list = trafficService.whetherHaveRec(mapper);
        logger.info("loggerinfo:"+list.toString());
    }

    public void minusLinkTraffic(Integer lf_id){
        trafficService.minusLinkTraffic(lf_id);
    }

    public void flowDetection(){
        if(first) {
            lastID = trafficService.getLastOneRecord();
            first = false;
            trafficService.initLinkTraffic();
            logger.info("first，lastId："+lastID);
        }
        else {
            int newId = trafficService.getLastOneRecord();
            logger.info("newId"+newId);
            logger.info("lastID"+lastID);
            if(newId > lastID) {
                for(int id=lastID+1; id<=newId; id++){
                    CapRecord capRecord = trafficService.getOneRecord(id);
                    Integer cap_gantry = trafficService.getCapGantry(Integer.parseInt(capRecord.getCap_id()));
                    Integer pos = trafficService.getPos(cap_gantry);
                    trafficService.addLinkTraffic(pos);

                    Integer neg = trafficService.getNeg(cap_gantry);
                    if(neg!=0){
                        List<Integer> list = trafficService.getBeforePosGantry(neg, cap_gantry);
                        List<Integer> cap_ids = new ArrayList<>();
                        for(Integer gantry_id:list){
                            List<Integer> cap_id_list = trafficService.findUCapID(gantry_id);
                            cap_ids.addAll(cap_id_list);
                        }
                        Mapper_1 mapper = new Mapper_1(capRecord.getRec_time(), cap_ids, capRecord.getPlate_num());
                        List<Integer> rec_id = trafficService.whetherHaveRec(mapper);
                        if(rec_id.size()==0){
                            logger.info("上游未统计，放行");
                        } else {
                            trafficService.minusLinkTraffic(neg);
                            logger.info("对应区段流量减1");
                        }
                    }
                }
                lastID = newId;
            }else {
                logger.info("无更新......");
            }

        }
    }

}
