package com.exp.socket.discover;

/** @date 2021/6/13 14:40 */
public class Constant {
  public static final byte[] UDP_HEADER = new byte[] {8, 8, 8, 8, 8, 8, 8, 8};
  public static final int UDP_VERIFY_LEN = UDP_HEADER.length + 2 + 4;
  public static final int TCP_SERVER_PORT = 20000;
  public static final int UDP_SERVER_PORT = 30000;
  public static final int UDP_CLIENT_PORT = 30001;
}
