package com.xxx.spring;


import org.springframework.stereotype.Service;

@Service
public class User {

    private String username;

    private int id;

    public String getUsername() {
        return "xiaoming";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return 34;
    }

    public void setId(int id) {
        this.id = id;
    }
}
