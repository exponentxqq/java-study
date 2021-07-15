package com.exp.book.nettyauthoritative.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
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
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;

public class TimeServer {
  public static void main(String[] args) {
    new NettyServer().bind();
  }
}

@Slf4j
class NettyServer {
  public void bind() {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap bootstrap = new ServerBootstrap();
      bootstrap
          .group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          .option(ChannelOption.SO_BACKLOG, 1024)
          .childHandler(new ChildChannelHandler());

      final ChannelFuture future = bootstrap.bind(8020).sync();
      future.channel().closeFuture().sync();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}

class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ch.pipeline()
        .addLast(new LineBasedFrameDecoder(1024))
        .addLast(new StringDecoder())
        .addLast(new ServerHandler());
  }
}

@Slf4j
class ServerHandler extends ChannelInboundHandlerAdapter {
  private int counter;

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    // ByteBuf buf = (ByteBuf) msg;
    // byte[] bytes = new byte[buf.readableBytes()];
    // buf.readBytes(bytes);
    // final String body = new String(bytes, StandardCharsets.UTF_8);
    final String body = (String) msg;
    log.info("time server receive order: " + body + "; counter is : " + ++counter);

    final String currentTime =
        ("query time order".equalsIgnoreCase(body) ? Instant.now().toString() : "bad order") + "\n";
    final ByteBuf writeBuf = Unpooled.copiedBuffer(currentTime.getBytes());
    ctx.write(writeBuf);
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    ctx.flush();
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    log.error(cause.getMessage(), cause);
    ctx.close();
  }
}
