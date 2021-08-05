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
    // 15:25:42.539 [main] INFO com.study.jvm.jmm.analysis.ClassStruct -
    // com.study.jvm.jmm.analysis.EmptyClass object internals:
    // OFF  SZ   TYPE DESCRIPTION               VALUE
    // 0   8        (object header: mark)     0x0000000000000005 (biasable; age: 0)
    // 8   4        (object header: class)    0x0009bef0
    // 12   4        (object alignment gap)
    // Instance size: 16 bytes
    // Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
  }

  private static void boolClassAnalysis() {
    final BoolClass boolClass = new BoolClass();
    log.info(VM.current().details());
    log.info(ClassLayout.parseInstance(boolClass).toPrintable());
  }

  private static void arrayAnalysis() {
    int[] arr = new int[2];
    log.info(VM.current().details());
    log.info(ClassLayout.parseInstance(arr).toPrintable());
  }
}

class EmptyClass {}

class BoolClass {
  private boolean flag = false;
}
