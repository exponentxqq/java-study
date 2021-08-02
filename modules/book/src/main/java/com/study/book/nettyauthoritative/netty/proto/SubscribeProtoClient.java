package com.study.book.nettyauthoritative.netty.proto;

import com.study.book.nettyauthoritative.netty.proto.SubscribeRequestProto.SubscribeRequest;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubscribeProtoClient {
  public static void main(String[] args) {
    connect();
  }

  private static void connect() {
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
                      .addLast(new ProtobufVarint32FrameDecoder())
                      .addLast(
                          new ProtobufDecoder(
                              SubscribeResponseProto.SubscribeResponse.getDefaultInstance()))
                      .addLast(new ProtobufVarint32LengthFieldPrepender())
                      .addLast(new ProtobufEncoder())
                      .addLast(new SubscribeProtoClientHandler());
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
class SubscribeProtoClientHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    for (int i = 0; i < 10; i++) {
      ctx.write(request(i));
    }
    ctx.flush();
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    log.info("receive server response: [" + msg + "]");
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

  private SubscribeRequestProto.SubscribeRequest request(int subId) {
    return SubscribeRequest.newBuilder()
        .setSubId(subId)
        .setUsername("Lilinfeng")
        .setProduct("Netty Book For Proto")
        .setAddress("address")
        .build();
  }
}
