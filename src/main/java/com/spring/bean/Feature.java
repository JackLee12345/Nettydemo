package com.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Feature {

    @Autowired
    private Person person;

    public String getName(){
        return person.getPersonName();
    }

}
