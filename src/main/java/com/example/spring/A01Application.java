package com.example.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class A01Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(A01Application.class);
        System.out.println(context);
    }

}
