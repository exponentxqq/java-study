package com.exp.socket.udp.broadcast;

/** @date 2021/6/13 00:13 */
public class MessageCreator {
  private static final String SN_HEADER = "received, i'm SN: ";
  private static final String PORT_HEADER = "received, please call port: ";

  public static String build(int port) {
    return PORT_HEADER + port;
  }

  public static int parsePort(String data) {
    if (data.startsWith(PORT_HEADER)) {
      return Integer.parseInt(data.substring(PORT_HEADER.length()));
    }
    return -1;
  }

  public static String build(String sn) {
    return SN_HEADER + sn;
  }

  public static String parseSn(String data) {
    if (data.startsWith(SN_HEADER)) {
      return data.substring(SN_HEADER.length());
    }
    return null;
  }
}
