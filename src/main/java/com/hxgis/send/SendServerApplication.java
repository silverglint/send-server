package com.hxgis.send;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.ws.config.annotation.EnableWs;

/**
 * Created by sk on 2019/4/24
 */
@EnableWs
@SpringBootApplication
@EnableSwagger2Doc
@EnableScheduling
public class SendServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SendServerApplication.class);
    }
}
