package com.example.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Component3 {
    @Autowired
    private ApplicationEventPublisher context;

    public void register(){
        log.debug("用户注册");
        context.publishEvent(new UserRegisteredEvent(this));
    }
}
