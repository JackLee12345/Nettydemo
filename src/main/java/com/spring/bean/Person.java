package com.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name;

    public Person(){
        this.name = "xiaoming";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonName(){
        return name;
    }
}
