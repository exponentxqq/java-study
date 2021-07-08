package com.exp.jvm.memory;

/**
 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseParallelGC -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 */
public class Allocation {
  private static final int _1MB = 1024 * 1024;

  public static void main(String[] args) {
    allocate();
  }

  // VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
  // [0.001s][warning][gc] -XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead.
  // [0.004s][info   ][gc] Using Parallel
  // [0.004s][info   ][gc,heap,coops] Heap address: 0x00000000fec00000, size: 20 MB, Compressed Oops
  // mode: 32-bit
  // 111111111111111111
  // 222222222222222222
  // [0.042s][info   ][gc,start     ] GC(0) Pause Young (Allocation Failure)
  // [0.043s][info   ][gc,heap      ] GC(0) PSYoungGen: 8151K->560K(9216K)
  // [0.043s][info   ][gc,heap      ] GC(0) ParOldGen: 0K->4096K(10240K)
  // [0.043s][info   ][gc,metaspace ] GC(0) Metaspace: 3498K->3498K(1056768K)
  // [0.043s][info   ][gc           ] GC(0) Pause Young (Allocation Failure) 7M->4M(19M) 1.632ms
  // [0.043s][info   ][gc,cpu       ] GC(0) User=0.00s Sys=0.00s Real=0.01s
  // 333333333333333333
  // 444444444444444444
  // [0.045s][info   ][gc,heap,exit ] Heap
  // [0.045s][info   ][gc,heap,exit ]  PSYoungGen      total 9216K, used 5921K [0x00000000ff600000,
  // 0x0000000100000000, 0x0000000100000000)
  // [0.045s][info   ][gc,heap,exit ]   eden space 8192K, 65% used
  // [0x00000000ff600000,0x00000000ffb3c4d8,0x00000000ffe00000)
  // [0.045s][info   ][gc,heap,exit ]   from space 1024K, 54% used
  // [0x00000000ffe00000,0x00000000ffe8c010,0x00000000fff00000)
  // [0.045s][info   ][gc,heap,exit ]   to   space 1024K, 0% used
  // [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
  // [0.045s][info   ][gc,heap,exit ]  ParOldGen       total 10240K, used 8192K [0x00000000fec00000,
  // 0x00000000ff600000, 0x00000000ff600000)
  // [0.045s][info   ][gc,heap,exit ]   object space 10240K, 80% used
  // [0x00000000fec00000,0x00000000ff400030,0x00000000ff600000)
  // [0.045s][info   ][gc,heap,exit ]  Metaspace       used 3507K, capacity 4486K, committed 4864K,
  // reserved 1056768K
  // [0.045s][info   ][gc,heap,exit ]   class space    used 311K, capacity 386K, committed 512K,
  // reserved 1048576K
  private static void allocate() {
    byte[] allocation1, allocation2, allocation3, allocation4;
    allocation1 = new byte[2 * _1MB];
    createBigBytes();
    System.out.println("111111111111111111");
    allocation2 = new byte[2 * _1MB];
    System.out.println("222222222222222222");
    allocation3 = new byte[2 * _1MB];
    System.out.println("333333333333333333");
    createBigBytes();
    allocation4 = new byte[4 * _1MB];
    System.out.println("444444444444444444");
  }

  private static void createBigBytes() {
    byte[] bytes = new byte[_1MB * 3];
  }
}
