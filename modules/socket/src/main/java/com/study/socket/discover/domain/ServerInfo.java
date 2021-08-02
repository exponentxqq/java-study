package com.study.socket.discover.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** @date 2021/6/13 15:15 */
@AllArgsConstructor
@Getter
public class ServerInfo {
  private final String address;
  private final int port;
  private final String sn;

  @Override
  public String toString() {
    return "ServerInfo{"
        + "address='"
        + address
        + '\''
        + ", port="
        + port
        + ", sn='"
        + sn
        + '\''
        + '}';
  }
}
