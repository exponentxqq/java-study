package com.study.jvm.memory;

import com.study.jvm.gc.MemoryAnalysis;
import org.openjdk.jol.info.ClassLayout;

/** @date 2021/7/7 21:30 */
public class ObjectMemory {
  public static void main(String[] args) {
    final MemoryAnalysis analysis = new MemoryAnalysis();
    MemoryAnalysis[] arr = {analysis};
    // 对象内部信息
    final String instanceInfo = ClassLayout.parseInstance(arr).toPrintable();
    System.out.println(instanceInfo);
    System.out.println("-------------------");
    // 对象外部信息：包括引用的对象
    //    final String instanceInfo1 = GraphLayout.parseInstance(arr).toPrintable();
    //    System.out.println(instanceInfo1);
    //    System.out.println("--------------------");
    //    // 对象占用空间总大小
    //    final long size = GraphLayout.parseInstance(arr).totalSize();
    //    System.out.println("total size: " + size);
    System.out.println("done");
  }
}
