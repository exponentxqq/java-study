package com.study.jvm.jmm.analysis;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

@Slf4j
public class ClassStruct {
  public static void main(String[] args) {
    emptyClassAnalysis();
    boolClassAnalysis();
    arrayAnalysis();
  }

  private static void emptyClassAnalysis() {
    final EmptyClass emptyClass = new EmptyClass();
    log.info(VM.current().details());
    // # Using compressed oop with 3-bit shift.
    // # Using compressed klass with 3-bit shift.
    // # Objects are 8 bytes aligned.
    // # Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
    // # Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
    log.info(ClassLayout.parseInstance(emptyClass).toPrintable());
    // 从如下结构可知： 对象占用内存16字节，其中对象头12字节，填充对齐4字节，其位数情况为 101
    // 15:25:42.539 [main] INFO com.study.jvm.jmm.analysis.ClassStruct -
    // com.study.jvm.jmm.analysis.EmptyClass object internals:
    // OFF  SZ   TYPE DESCRIPTION               VALUE
    // 0   8        (object header: mark)     0x0000000000000005 (biasable; age: 0)
    // 8   4        (object header: class)    0x0009bef0
    // 12   4        (object alignment gap)
    // Instance size: 16 bytes
    // Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
    log.info("hash: " + Integer.toHexString(emptyClass.hashCode()));
    log.info(ClassLayout.parseInstance(emptyClass).toPrintable());
  }

  private static void boolClassAnalysis() {
    final BoolClass boolClass = new BoolClass();
    log.info(VM.current().details());
    // # Using compressed oop with 3-bit shift.
    // # Using compressed klass with 3-bit shift.
    // # Objects are 8 bytes aligned.
    // # Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
    // # Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
    log.info(ClassLayout.parseInstance(boolClass).toPrintable());
    // 从如下结构可知： 对象占用内存16字节，其中对象头12字节，对象体的flag字段占用1字节，填充对齐3字节
    // OFF  SZ      TYPE DESCRIPTION               VALUE
    // 0   8           (object header: mark)     0x0000000000000005 (biasable; age: 0)
    // 8   4           (object header: class)    0x00115a70
    // 12   1   boolean BoolClass.flag            false
    // 13   3           (object alignment gap)
    // Instance size: 16 bytes                         ---------------------->   对象内存占用
    // Space losses: 0 bytes internal + 3 bytes external = 3 bytes total   -------> 空间损耗
  }

  private static void arrayAnalysis() {
    int[] arr = new int[23];
    log.info(VM.current().details());
    log.info(ClassLayout.parseInstance(arr).toPrintable());
  }
}

class EmptyClass {}

class BoolClass {
  private boolean flag = false;
}
