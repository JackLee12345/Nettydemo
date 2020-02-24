package com.xxx.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.InetAddress;


/**
 * @author user
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    private String result = "";

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (!(msg instanceof FullHttpRequest)) {
            result = "未知请求!";
            send(ctx, result, HttpResponseStatus.BAD_REQUEST);
            return;
        }
        FullHttpRequest httpRequest = (FullHttpRequest) msg;
        try {
            String path = httpRequest.uri();
            System.out.println("path: " + path);
            String body = getBody(httpRequest);
            System.out.println("body: " + body);
            HttpMethod method = httpRequest.method();
            System.out.println("method: " + method);
            HttpVersion httpVersion = httpRequest.protocolVersion();
            System.out.println("httpVersion: " + httpVersion);
            if (HttpMethod.GET.equals(method)) {
                System.out.println("body: " + body);
                result = "GET请求";
                send(ctx, result, HttpResponseStatus.OK);
                return;
            }
            if (HttpMethod.POST.equals(method)) {
                System.out.println("body: " + body);
                result = "POST请求";
                send(ctx, result, HttpResponseStatus.OK);
                return;
            }
            if (HttpMethod.PUT.equals(method)) {
                System.out.println("body: " + body);
                result = "PUT请求";
                send(ctx, result, HttpResponseStatus.OK);
                return;
            }
            if (HttpMethod.DELETE.equals(method)) {
                System.out.println("body: " + body);
                result = "DELETE请求";
                send(ctx, result, HttpResponseStatus.OK);
                return;
            }
        } catch (Exception e) {
            System.out.println("处理请求失败!");
            e.printStackTrace();
        } finally {
            //释放请求
            httpRequest.release();
        }
    }

    /**
     * 获取body参数
     *
     * @param request
     * @return
     */
    private String getBody(FullHttpRequest request) {
        ByteBuf buf = request.content();
        return buf.toString(CharsetUtil.UTF_8);
    }

    /**
     * 发送的返回值
     *
     * @param ctx     返回
     * @param context 消息
     * @param status  状态
     */
    private void send(ChannelHandlerContext ctx, String context, HttpResponseStatus status) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status, Unpooled.copiedBuffer(context, CharsetUtil.UTF_8));
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8");
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接的客户端地址......:" + ctx.channel().remoteAddress());
        ctx.writeAndFlush("客户端" + InetAddress.getLocalHost().getHostName() + "成功与服务端建立连接！ ");
        super.channelActive(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        System.out.println("channelRegistered");
        ctx.writeAndFlush(new byte[]{(byte)1});
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
        System.out.println("channelUnregistered");
    }
}
