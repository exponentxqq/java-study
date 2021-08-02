package com.study.book.nettyauthoritative.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UdpServer {
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
          .handler(new UdpServerHandler());
      bootstrap.bind(8020).sync().channel().closeFuture().sync();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    } finally {
      group.shutdownGracefully();
    }
  }
}

@Slf4j
class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {
  private static final String[] DICTORIES = {"只要功夫深，铁杵磨成针", "一寸光阴一寸金，寸金难买寸光阴", "锄禾日当午，汗滴禾下土"};

  @Override
  public void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
    final String request = msg.content().toString(StandardCharsets.UTF_8);
    log.info(request);
    if ("谚语字典查询？".equals(request)) {
      final ByteBuf response =
          Unpooled.copiedBuffer("谚语查询结果：" + nextQuote(), StandardCharsets.UTF_8);
      ctx.writeAndFlush(new DatagramPacket(response, msg.sender()));
    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    log.error(cause.getMessage(), cause);
    ctx.close();
  }

  private String nextQuote() {
    final int index = ThreadLocalRandom.current().nextInt(DICTORIES.length);
    return DICTORIES[index];
  }
}
