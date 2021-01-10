package com.qiancy.dubbo.demo.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 功能简述：
 *
 * @author qiancy
 * @create 2020/12/29
 * @since 1.0.0
 */
@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
public class DubboAccountApplication {

    public static void main(String[] args) throws IOException {
//        SpringApplication springApplication = new SpringApplication(DubboAccountApplication.class);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
//        springApplication.run(args);
//        System.in.read();
        SpringApplication.run(DubboAccountApplication.class, args);
    }
}
