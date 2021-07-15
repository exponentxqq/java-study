package com.exp.book.nettyauthoritative.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeClient {
  public static void main(String[] args) {
    connect();
  }

  public static void connect() {
    EventLoopGroup group = new NioEventLoopGroup();

    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap
          .group(group)
          .channel(NioSocketChannel.class)
          .option(ChannelOption.TCP_NODELAY, true)
          .handler(
              new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                  ch.pipeline()
                      .addLast(new LineBasedFrameDecoder(1024))
                      .addLast(new StringDecoder())
                      .addLast(new TimeClientHandler());
                }
              });
      final ChannelFuture future = bootstrap.connect("127.0.0.1", 8020).sync();
      future.channel().closeFuture().sync();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    } finally {
      group.shutdownGracefully();
    }
  }
}

@Slf4j
class TimeClientHandler extends ChannelInboundHandlerAdapter {
  private int counter;
  private final byte[] bytes;

  public TimeClientHandler() {
    bytes = "query time order\n".getBytes();
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    ByteBuf message;
    for (int i = 0; i < 100; i++) {
      message = Unpooled.buffer(bytes.length);
      message.writeBytes(bytes);
      ctx.writeAndFlush(message);
    }
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    // final ByteBuf read = (ByteBuf) msg;
    // final byte[] readBytes = new byte[read.readableBytes()];
    // read.readBytes(readBytes);
    // final String body = new String(readBytes, StandardCharsets.UTF_8);
    final String body = (String) msg;
    log.info("now is : " + body + "; counter is: " + ++counter);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    log.error(cause.getMessage(), cause);
    ctx.close();
  }
}
