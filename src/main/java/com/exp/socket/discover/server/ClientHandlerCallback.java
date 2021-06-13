package com.exp.socket.discover.server;

/** @date 2021/6/13 22:24 */
public interface ClientHandlerCallback {
  void onSelfClosed(TcpClientHandler clientHandler);

  void onNewMessageArrived(TcpClientHandler clientHandler, String message);
}
