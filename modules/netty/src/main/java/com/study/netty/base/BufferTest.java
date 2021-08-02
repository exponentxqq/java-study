package com.study.netty.base;

import java.nio.ByteBuffer;

public class BufferTest {
  public static void main(String[] args) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    System.out.println("初始时-->limit--->" + byteBuffer.limit());
    System.out.println("初始时-->position--->" + byteBuffer.position());
    System.out.println("初始时-->capacity--->" + byteBuffer.capacity());
    System.out.println("初始时-->mark--->" + byteBuffer.mark());

    System.out.println("--------------------------------------");

    String s = "Java3y";
    byteBuffer.put(s.getBytes());

    System.out.println("put后-->limit--->" + byteBuffer.limit());
    System.out.println("put后-->position--->" + byteBuffer.position());
    System.out.println("put后-->capacity--->" + byteBuffer.capacity());
    System.out.println("put后-->mark--->" + byteBuffer.mark());
    System.out.println("---------------------------------------");

    byteBuffer.flip();
    System.out.println("flip后-->limit--->" + byteBuffer.limit());
    System.out.println("flip后-->position--->" + byteBuffer.position());
    System.out.println("flip后-->capacity--->" + byteBuffer.capacity());
    System.out.println("flip后-->mark--->" + byteBuffer.mark());
    System.out.println("---------------------------------------");

    byte[] res = new byte[byteBuffer.limit()];
    byteBuffer.get(res);
    final String s1 = new String(res);
    System.out.println("get后-->limit--->" + byteBuffer.limit());
    System.out.println("get后-->position--->" + byteBuffer.position());
    System.out.println("get后-->capacity--->" + byteBuffer.capacity());
    System.out.println("get后-->mark--->" + byteBuffer.mark());
    System.out.println("-----------------------------------------");

    // clear并不会真的清空数据，只是挪动了指针，“遗忘”了数据
    byteBuffer.clear();
    System.out.println("clear后-->limit--->" + byteBuffer.limit());
    System.out.println("clear后-->position--->" + byteBuffer.position());
    System.out.println("clear后-->capacity--->" + byteBuffer.capacity());
    System.out.println("clear后-->mark--->" + byteBuffer.mark());
    System.out.println("-----------------------------------------");
  }
}
