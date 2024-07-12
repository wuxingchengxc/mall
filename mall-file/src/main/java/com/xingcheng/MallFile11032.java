package com.xingcheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
        (exclude = { DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class })
public class MallFile11032 {

    public static void main(String[] args) {
        SpringApplication.run(MallFile11032.class, args);
    }

}
