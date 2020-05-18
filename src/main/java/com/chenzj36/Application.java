package com.chenzj36;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author chenzj36
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Application
{
    public static void main(String[] args)
    {
        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(Application.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  项目启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "    ___     _        ___    ___       \n" +
                "   / __|   | |      | _ \\  | _ \\      \n" +
                "  | (__    | |__    |  _/  |  /      \n" +
                "   \\___|   |____|   |_|    |_|_\\      \n");
    }
}