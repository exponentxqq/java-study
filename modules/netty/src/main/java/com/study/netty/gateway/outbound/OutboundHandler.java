package com.study.netty.gateway.outbound;

import com.study.netty.gateway.domain.ServerConfig;
import com.study.netty.gateway.filter.HttpRequestFilter;
import com.study.netty.gateway.outbound.netty.NettyHttpClientOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import java.util.List;

public interface OutboundHandler {
  void handle(
      final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, HttpRequestFilter filter);

  static OutboundHandler getInstance(List<ServerConfig> serverConfigs) {
    //    return new HttpClientOutboundHandler(serverConfigs);
    //    return new OkhttpOutboundHandler(serverConfigs);
    return NettyHttpClientOutboundHandler.getInstance(serverConfigs);
  }
}
