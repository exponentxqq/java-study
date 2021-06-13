package com.exp.socket.discover.server;

/** @date 2021/6/13 22:24 */
public interface CloseNotify {
  void onSelfClosed(TcpClientHandler clientHandler);
}
