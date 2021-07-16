package com.exp.book.nettyauthoritative.netty.http.file;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
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

  public static void main(String[] args) {}

  public void run() {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap bootstrap = new ServerBootstrap();
      bootstrap
          .group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          .childHandler(
              new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                  ch.pipeline()
                      .addLast(new HttpRequestDecoder())
                      .addLast(new HttpObjectAggregator(65536))
                      .addLast(new HttpResponseEncoder())
                      .addLast(new ChunkedWriteHandler())
                      .addLast(new HttpFileServerHandler(DEFAULT_URL));
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

@RequiredArgsConstructor
class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
  private final String url;

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {}
}
