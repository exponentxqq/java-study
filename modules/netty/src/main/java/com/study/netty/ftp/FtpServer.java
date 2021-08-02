package com.study.netty.ftp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class FtpServer {
  public static void main(String[] args) throws InterruptedException {
    new FtpServer().start();
  }

  public void start() throws InterruptedException {
    EventLoopGroup bossGroup = new NioEventLoopGroup(2);
    EventLoopGroup workerGroup = new NioEventLoopGroup(4);
    final ServerBootstrap bootstrap = new ServerBootstrap();
    final ChannelFuture channelFuture =
        bootstrap
            .group(bossGroup, workerGroup)
            .channel(NioServerSocketChannel.class)
            .childHandler(new FtpServerHandler())
            .bind(2121);

    channelFuture.sync();
  }
}

class FtpServerHandler extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ch.pipeline();
  }
}
