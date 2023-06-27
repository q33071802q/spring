package com.example.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

@SpringBootApplication
@Slf4j
public class A01Application {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ConfigurableApplicationContext context = SpringApplication.run(A01Application.class);
//        System.out.println(context);

        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Map<String, Object> map = (Map<String, Object>) singletonObjects.get(beanFactory);
        //所以@Component这个注解其实就是个key 对应一个value集合 代表项目里所有配置的@Component的集合
        map.entrySet().stream().filter(e -> e.getKey().startsWith("component"))
                .forEach(e -> System.out.println(e.getKey() + "=" + e.getValue()));
        context.close();

    }

}

@Component
class Component1 {

}

@Component
class Component2 {

}