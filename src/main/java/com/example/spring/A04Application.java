package com.example.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * EnvironmentCapable
 */
@SpringBootApplication
@Slf4j
public class A04Application {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        ConfigurableApplicationContext context = SpringApplication.run(A04Application.class);
        System.out.println(context.getEnvironment().getProperty("properties.name"));
        context.close();
    }



}

