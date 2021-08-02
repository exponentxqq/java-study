package com.study.book.nettyauthoritative.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UdpClient {
  public static void main(String[] args) {
    run();
  }

  private static void run() {
    EventLoopGroup group = new NioEventLoopGroup();
    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap
          .group(group)
          .channel(NioDatagramChannel.class)
          .option(ChannelOption.SO_BROADCAST, true)
          .handler(new UdpClientHandler());
      final Channel channel = bootstrap.bind(0).sync().channel();
      channel
          .writeAndFlush(
              new DatagramPacket(
                  Unpooled.copiedBuffer("谚语字典查询？", StandardCharsets.UTF_8),
                  new InetSocketAddress("255.255.255.255", 8020)))
          .sync();
      if (!channel.closeFuture().await(15000)) {
        log.error("timeout!!");
      }
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    } finally {
      group.shutdownGracefully();
    }
  }
}

@Slf4j
class UdpClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
    final String response = msg.content().toString(StandardCharsets.UTF_8);
    if (response.startsWith("谚语查询结果")) {
      log.info(response);
      ctx.close();
    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    log.error(cause.getMessage(), cause);
    ctx.close();
  }
}
