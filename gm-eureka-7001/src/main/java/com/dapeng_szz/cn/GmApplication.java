package com.dapeng_szz.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GmApplication {
    public static void main(String[] args) {
        SpringApplication.run(GmApplication.class,args);
    }
}
