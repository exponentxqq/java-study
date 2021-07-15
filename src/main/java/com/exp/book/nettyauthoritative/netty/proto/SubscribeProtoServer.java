package com.exp.book.nettyauthoritative.netty.proto;

import com.exp.book.nettyauthoritative.netty.proto.SubscribeRequestProto.SubscribeRequest;
import com.exp.book.nettyauthoritative.netty.proto.SubscribeResponseProto.SubscribeResponse;
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
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubscribeProtoServer {
  public static void main(String[] args) {
    bind();
  }

  private static void bind() {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap bootstrap = new ServerBootstrap();
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
                      .addLast(new ProtobufVarint32FrameDecoder())
                      .addLast(
                          new ProtobufDecoder(
                              SubscribeRequestProto.SubscribeRequest.getDefaultInstance()))
                      .addLast(new ProtobufVarint32LengthFieldPrepender())
                      .addLast(new ProtobufEncoder())
                      .addLast(new SubscribeProtoServerHandler());
                }
              });
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

@Slf4j
class SubscribeProtoServerHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    final SubscribeRequest request = (SubscribeRequest) msg;
    if ("Lilinfeng".equalsIgnoreCase(request.getUsername())) {
      log.info("service accept client subscribe request: " + request);
      ctx.writeAndFlush(response(request.getSubId()));
    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    log.error(cause.getMessage(), cause);
    ctx.close();
  }

  private SubscribeResponseProto.SubscribeResponse response(int subId) {
    return SubscribeResponse.newBuilder()
        .setSubId(subId)
        .setCode(0)
        .setDescription("Netty book order success, 3 days later, sent to the designed address")
        .build();
  }
}
