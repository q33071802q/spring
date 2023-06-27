package com.example.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

/**
 * 如果有问题 就看文件编码file encoding 是不是UTF-8
 */
@SpringBootApplication
@Slf4j
public class A02Application {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        ConfigurableApplicationContext context = SpringApplication.run(A02Application.class);
//        System.out.println(context.getMessage("thanks",null, Locale.ENGLISH));
//        System.out.println(context.getMessage("thanks",null,Locale.SIMPLIFIED_CHINESE));
//        System.out.println(context.getMessage("thanks",null,Locale.TRADITIONAL_CHINESE));
//        context.close();

        /**
         * GenericApplicationContext 干净的容器 什么配置都没有
         */
        GenericApplicationContext context = new GenericApplicationContext();

        /**
         * 为容器注册对象 必须刷新应用程序上下文 才能生效
         */
        context.registerBean("messageSource", MessageSource.class, () -> {
            ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
            // 设置编码格式 这个地方编码 说白了就是用什么编码 就用什么解码 看文件编码就行了
            ms.setDefaultEncoding("utf-8");
            // 设置国际化资源文件的 basename
            ms.setBasename("messages");
            return ms;
        });

        /**
         * 重新加载配置 并初始化所有的bean 相当于手动改配置了 可以刷新应用程序上下文
         *
         */
        context.refresh();

        System.out.println(context.getMessage("thanks", null, Locale.ENGLISH));
        System.out.println(context.getMessage("thanks", null, Locale.SIMPLIFIED_CHINESE));
        System.out.println(context.getMessage("thanks", null, Locale.TRADITIONAL_CHINESE));

        context.close();



    }



}

