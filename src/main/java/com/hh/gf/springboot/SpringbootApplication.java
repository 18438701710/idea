package com.hh.gf.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication()
//@SpringBootApplication()
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper,com.hh.gf.springboot.mapper")
public class SpringbootApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
