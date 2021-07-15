package com.exp.book.nettyauthoritative.netty.decoder;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscribeResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  private int subId;
  private int code;
  private String description;

  @Override
  public String toString() {
    return "SubscribeResponse{"
        + "subId="
        + subId
        + ", code="
        + code
        + ", description='"
        + description
        + '\''
        + '}';
  }
}
