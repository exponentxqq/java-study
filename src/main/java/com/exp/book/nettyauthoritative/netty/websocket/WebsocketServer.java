package com.exp.book.nettyauthoritative.netty.websocket;

import com.exp.book.nettyauthoritative.netty.NettyServer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.handler.stream.ChunkedWriteHandler;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebsocketServer {
  public static void main(String[] args) {
    new NettyServer()
        .run(
            new ChannelInitializer<>() {
              @Override
              protected void initChannel(Channel ch) throws Exception {
                ch.pipeline()
                    .addLast(new HttpServerCodec())
                    .addLast(new HttpObjectAggregator(65536))
                    .addLast(new ChunkedWriteHandler())
                    .addLast(new WebSocketServerHandler());
              }
            });
  }
}

@Slf4j
class WebSocketServerHandler extends ChannelInboundHandlerAdapter {
  private WebSocketServerHandshaker handshaker;

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    if (msg instanceof FullHttpRequest) {
      handleHttpRequest(ctx, (FullHttpRequest) msg);
    } else if (msg instanceof WebSocketFrame) {
      handleWebsocketRequest(ctx, (WebSocketFrame) msg);
    }
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    ctx.flush();
  }

  private void handleHttpRequest(ChannelHandlerContext context, FullHttpRequest request) {
    if (!request.decoderResult().isSuccess()
        || (!"websocket".equals(request.headers().get("Upgrade")))) {
      httpResponse(
          context,
          request,
          new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
      return;
    }
    WebSocketServerHandshakerFactory wsFactory =
        new WebSocketServerHandshakerFactory("ws://localhost:8020/websocket", null, false);
    handshaker = wsFactory.newHandshaker(request);
    if (handshaker == null) {
      WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(context.channel());
    } else {
      handshaker.handshake(context.channel(), request);
    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    log.error(cause.getMessage(), cause);
    ctx.close();
  }

  private void httpResponse(
      ChannelHandlerContext context, FullHttpRequest request, DefaultFullHttpResponse response) {
    if (response.status().code() != 200) {
      final ByteBuf byteBuf =
          Unpooled.copiedBuffer(response.status().toString(), StandardCharsets.UTF_8);
      response.content().writeBytes(byteBuf);
      byteBuf.release();
      response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
    }
    final ChannelFuture future = context.channel().writeAndFlush(response);
    if (!request.protocolVersion().isKeepAliveDefault() || response.status().code() != 200) {
      future.addListener(ChannelFutureListener.CLOSE);
    }
  }

  private void handleWebsocketRequest(ChannelHandlerContext ctx, WebSocketFrame frame) {
    if (frame instanceof CloseWebSocketFrame) {
      handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
      return;
    }
    if (frame instanceof PingWebSocketFrame) {
      ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
      return;
    }

    if (!(frame instanceof TextWebSocketFrame)) {
      throw new UnsupportedOperationException(
          String.format("%s frame types not supported", frame.getClass().getName()));
    }
    final String text = ((TextWebSocketFrame) frame).text();
    log.info(String.format("%s received %s", ctx.channel(), text));
    ctx.channel()
        .write(new TextWebSocketFrame(text + ",欢迎使用Netty Websocket服务，现在时刻：" + Instant.now()));
  }
}
