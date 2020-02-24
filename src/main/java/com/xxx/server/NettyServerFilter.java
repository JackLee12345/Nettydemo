package com.xxx.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.net.SocketAddress;


/**
 * @author user
 */
public class NettyServerFilter extends ChannelInitializer<SocketChannel> {

    public NettyServerFilter() {
        System.out.println("NettyServerFilter...");
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline ph = ch.pipeline();
        System.out.println("客户端地址：" + ph.channel().remoteAddress());
        ph.addLast("encoder", new HttpResponseEncoder());
        ph.addLast("decoder", new HttpRequestDecoder());
        ph.addLast("aggregator", new HttpObjectAggregator(10 * 1024 * 1024));
        ph.addLast("handler", new NettyServerHandler());
    }
}
