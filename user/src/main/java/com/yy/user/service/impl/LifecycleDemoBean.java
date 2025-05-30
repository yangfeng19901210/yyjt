package com.yy.user.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LifecycleDemoBean implements InitializingBean {

    public LifecycleDemoBean() {
        System.out.println("1. Constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("3. PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("4. AfterPropertiesSet");
    }

    public void init() {
        System.out.println("5. Custom init method");
    }

    // Assume this method is called by Spring to set a property
    public void setProperty(String property) {
        System.out.println("2. Property set: " + property);
    }
}