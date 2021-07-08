package com.exp.jvm.jmm.oom;

import java.util.ArrayList;
import java.util.List;

/** jvm参数配置：-verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 */
public class HeapOOM {
  static class OOMObject {}

  public static void main(String[] args) {
    List<OOMObject> list = new ArrayList<>();
    while (true) {
      list.add(new OOMObject());
    }
  }
}
