package com.bee.sample.ch7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    // @Configuration　表面是一个配置类，　类里面所有带　＠Bean　注解的方法都会被　Spring调用，　
    @Bean
    public URLTestBean getURLTestBean() {
        return new URLTestBean();
    }
}
