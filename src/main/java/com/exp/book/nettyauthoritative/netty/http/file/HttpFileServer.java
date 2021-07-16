package com.exp.book.nettyauthoritative.netty.http.file;

import com.exp.book.nettyauthoritative.netty.NettyServer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpFileServer {
  private static final String DEFAULT_URL = "/src/com/phei/netty/";

  public static void main(String[] args) {
    new NettyServer()
        .run(
            new ChannelInitializer<>() {
              @Override
              protected void initChannel(Channel ch) throws Exception {
                ch.pipeline()
                    .addLast(new HttpRequestDecoder())
                    .addLast(new HttpObjectAggregator(65536))
                    .addLast(new HttpResponseEncoder())
                    .addLast(new ChunkedWriteHandler())
                    .addLast(new HttpFileServerHandler(DEFAULT_URL));
              }
            });
  }
}

@RequiredArgsConstructor
class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
  private final String url;

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {}
}
