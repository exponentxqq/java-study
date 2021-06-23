package com.exp.jvm.bytecode;

public class EachByteCode {
  public void test() {
    int[] nums = {11, 122};
    int bufsz = 12;
    for (int num : nums) {
      bufsz += num;
    }
  }
}
