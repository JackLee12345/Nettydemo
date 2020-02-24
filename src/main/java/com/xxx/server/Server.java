package com.xxx.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {

    public void start(int port) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap b = new ServerBootstrap();
        try {
            b.group(group).channel(NioServerSocketChannel.class).childHandler(new NettyServerFilter());
            ChannelFuture future = b.bind(port).sync();
            System.out.println("服务端启动成功...");
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}

