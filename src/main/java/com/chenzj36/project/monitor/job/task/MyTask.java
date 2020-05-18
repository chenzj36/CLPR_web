package com.chenzj36.project.monitor.job.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/4/17 14:43
 * @Description
 */
@Component("myTask")
public class MyTask {
    Logger logger = LoggerFactory.getLogger(getClass());
    public void scheduleTask(){
        logger.info(getClass().getName() + ".scheduleTask() execute ok");
    }
}
