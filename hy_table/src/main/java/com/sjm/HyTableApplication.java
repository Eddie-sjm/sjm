package com.sjm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(value = "com.sjm.mapper")
public class HyTableApplication {
    public static void main(String[] args) {
        SpringApplication.run(HyTableApplication.class,args);
    }
}
