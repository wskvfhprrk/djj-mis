package com.guardlbt;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@MapperScan("com.guardlbt.mapper")
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("当前版本为：djjmisserver-0.0.1-SNAPSHOT");
        log.info("版本日期：2021-8-1");
        SpringApplication.run(Application.class, args);
    }

}
