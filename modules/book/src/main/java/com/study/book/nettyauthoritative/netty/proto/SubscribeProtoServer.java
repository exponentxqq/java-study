package com.study.book.nettyauthoritative.netty.proto;

import com.study.book.nettyauthoritative.netty.NettyServer;
import com.study.book.nettyauthoritative.netty.proto.SubscribeRequestProto.SubscribeRequest;
import com.study.book.nettyauthoritative.netty.proto.SubscribeResponseProto.SubscribeResponse;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubscribeProtoServer {
  public static void main(String[] args) {
    new NettyServer()
        .run(
            new ChannelInitializer<>() {
              @Override
              protected void initChannel(Channel ch) throws Exception {
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
