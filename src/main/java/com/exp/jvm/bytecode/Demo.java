package com.exp.jvm.bytecode;

/** @date 2021/6/22 22:51 */
public class Demo {
  private String param;
  private int count;

  public static void main(String[] args) {
    final Demo demo = new Demo();
  }

  public void main(int a) {
    new Demo();
  }

  public int sum() {
    int a = 1;
    int b = 2;
    int c = 3;

    return a + b + c;
  }

  public void each() {
    int[] nums = {1, 4, 6, 9};
  }
}
