package com.mjq.account;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author majingqiang
 */
@SpringCloudApplication
@MapperScan(basePackages = {"com.mjq.account.mapper"})
@EnableTransactionManagement
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
