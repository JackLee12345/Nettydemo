package com.nio.client;

import com.sun.org.apache.bcel.internal.generic.Select;

public class TimeClientHandle implements Runnable {
    private String ip;

    private int port;

    public TimeClientHandle(String ip,int port){
        this.ip = ip;
        this.port = port;
    }

    public void run() {

    }
}
