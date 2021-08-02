package com.study.book.nettyauthoritative.netty.decoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubscribeServer {
  public static void main(String[] args) {
    bind();
  }

  public static void bind() {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    ServerBootstrap bootstrap = new ServerBootstrap();
    final ChannelFuture future;
    try {
      bootstrap
          .group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          .option(ChannelOption.SO_BACKLOG, 100)
          .handler(new LoggingHandler(LogLevel.INFO))
          .childHandler(
              new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                  ch.pipeline()
                      .addLast(
                          new ObjectDecoder(
                              1024 * 1024,
                              ClassResolvers.weakCachingConcurrentResolver(
                                  this.getClass().getClassLoader())))
                      .addLast(new ObjectEncoder())
                      .addLast(new SubscribeServerHandler());
                }
              });
      future = bootstrap.bind(8020).sync();
      future.channel().closeFuture().sync();
    } catch (InterruptedException e) {
      log.info(e.getMessage(), e);
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}

@Slf4j
class SubscribeServerHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    final SubscribeRequest request = (SubscribeRequest) msg;
    if ("Lilinfeng".equalsIgnoreCase(request.getUsername())) {
      log.info("server accept client subscribe request: [" + request + "]");
      ctx.writeAndFlush(response(request.getSubId()));
    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    log.error(cause.getMessage(), cause);
    ctx.close();
  }

  private SubscribeResponse response(int subId) {
    final SubscribeResponse response = new SubscribeResponse();
    response.setSubId(subId);
    response.setCode(0);
    response.setDescription(
        "netty book order success, 3 days later, sent to the designed address.");
    return response;
  }
}
