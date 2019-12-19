package com.nio.server;

public class TimeServer {

    public static void main(String[] args) {

        MultiplerxerTimeServer multiplerxerTimeServer = new MultiplerxerTimeServer(8080);

        new Thread(multiplerxerTimeServer).start();
    }
}
