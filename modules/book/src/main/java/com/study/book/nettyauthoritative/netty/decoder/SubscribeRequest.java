package com.study.book.nettyauthoritative.netty.decoder;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscribeRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  private int subId;
  private String username;
  private String product;
  private String phone;
  private String address;

  @Override
  public String toString() {
    return "SubscribeRequest{"
        + "subId="
        + subId
        + ", username='"
        + username
        + '\''
        + ", product='"
        + product
        + '\''
        + ", phone='"
        + phone
        + '\''
        + ", address='"
        + address
        + '\''
        + '}';
  }
}
