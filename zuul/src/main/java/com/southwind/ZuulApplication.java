package com.southwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//包含了 @EnableZuulServer ，设置该类是⽹关的启动类,生成网关代理。
@EnableZuulProxy
//@EnableAutoConfiguration ：可以帮助 Spring Boot 应⽤将所有符合条件的 @Configuration
// 配置加载到当前 Spring Boot 创建并使⽤的 IoC 容器中（是@SpringBootApplication中的注解，
// 基于你已经添加jar依赖项，添加相应的spring设置，直接写SpringBootApplication注解就可以，没必要自己手动使用该注解）。
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
