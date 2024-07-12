package com.xingcheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan(value = "com.xingcheng.mapper")
public class MallProduct8001 {

    public static void main(String[] args) {
        SpringApplication.run(MallProduct8001.class, args);
    }

}
