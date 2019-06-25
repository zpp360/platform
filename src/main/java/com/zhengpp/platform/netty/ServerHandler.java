package com.zhengpp.platform.netty;

import org.apache.log4j.Logger;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.InetSocketAddress;


@Component
@Qualifier("serverHandler")
@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<String> {
    private static final Logger log = Logger.getLogger(ServerHandler.class);

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg)
            throws Exception {
        log.info("client msg:"+msg);
        InetSocketAddress ipSocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = ipSocket.getAddress().getHostAddress();
        log.info("clientIp:"+clientIp);
        log.info("clientPort:"+ipSocket.getPort());
        String clientIdToLong= ctx.channel().id().asLongText();
        log.info("client long id:"+clientIdToLong);
        String clientIdToShort= ctx.channel().id().asShortText();
        log.info("client short id:"+clientIdToShort);
        if(msg.indexOf("bye")!=-1){
            //close
            ctx.channel().close();
        }else{
            //send to client
            ctx.channel().writeAndFlush("Yoru msg is:"+msg);

        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        log.info("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");

        ctx.channel().writeAndFlush( "Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");

        super.channelActive(ctx);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("\nChannel is disconnected");
        super.channelInactive(ctx);
    }
}
