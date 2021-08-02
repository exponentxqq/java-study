package com.study.netty.gateway.filter.impl;

import com.study.netty.gateway.filter.HttpResponseFilter;
import io.netty.handler.codec.http.FullHttpResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeaderHttpResponseFilter implements HttpResponseFilter {
  @Override
  public void filter(FullHttpResponse response) {
    response.headers().set("kk", "java-1-nio");
  }
}
