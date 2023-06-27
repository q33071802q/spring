package com.example.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;

/**
 * 如果有问题 就看文件编码file encoding 是不是UTF-8
 */
@SpringBootApplication
@Slf4j
public class A03Application {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        ConfigurableApplicationContext context = SpringApplication.run(A03Application.class);
        Resource[] resources = context.getResources("classpath:application.yml");
        assert resources.length==0;

        resources = context.getResources("classpath*:META-INF/spring.factories");
        assert resources.length>0;
        context.close();
    }



}

