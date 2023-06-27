package com.example.spring;

import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent {
    private static final long serialVersionUID = 999999L;
    public UserRegisteredEvent(Object source) {
        super(source);
    }
}
