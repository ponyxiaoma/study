package com.mjq.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author majingqiang
 */
@SpringCloudApplication
@MapperScan(basePackages = {"com.mjq.mybatis.mapper"})
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
