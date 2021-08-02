package com.study.netty.ftp.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

public class CrlfStringDecoder extends ByteToMessageDecoder {
  private static final byte CR = 13;
  private static final byte LF = 10;

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {}
}
