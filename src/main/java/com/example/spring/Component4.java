package com.example.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Component4 {
    /**
     * 通过反射扫描调用 是同步方法 如果要单独线程执行需要加上@Async
     * 将注解的方式实现了一个监听器对象 也就是继承ApplicationListener
     * @param event
     */
    @EventListener
    public void add(UserRegisteredEvent event){
        System.out.println("event:"+event);
        System.out.println("发送消息:");
    }
}
