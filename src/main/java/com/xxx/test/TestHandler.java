package com.xxx.test;

import com.xxx.server.Server;

/**
 * @author user
 */
public class TestHandler {

    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        server.start(8082);
    }
}
