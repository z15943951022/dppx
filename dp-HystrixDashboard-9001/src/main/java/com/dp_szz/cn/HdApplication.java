package com.dp_szz.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HdApplication {
    public static void main(String[] args) {
        SpringApplication.run(HdApplication.class,args);
    }
}
