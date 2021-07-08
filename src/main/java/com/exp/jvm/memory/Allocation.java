package com.exp.jvm.memory;

/** VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 */
public class Allocation {

  public static void main(String[] args) {
    allocate();
  }

  private static void allocate() {
    byte[] allocation1, allocation2, allocation3, allocation4;
    allocation1 = new byte[2 * 1024 * 1024];
  }

  private static void createBigBytes() {
    byte[] bytes = new byte[1024 * 1024 * 3];
  }
}
// [0.005s][warning][gc] -XX:+PrintGCDetails is deprecated. Will use -Xlog:gc* instead.
// [0.011s][info   ][gc,heap] Heap region size: 1M
// [0.012s][info   ][gc     ] Using G1
// [0.012s][info   ][gc,heap,coops] Heap address: 0x00000007fec00000, size: 20 MB, Compressed Oops
// mode: Zero based, Oop shift amount: 3
// 111111111111111111
// [0.108s][info   ][gc,start     ] GC(0) Pause Young (Concurrent Start) (G1 Humongous Allocation)
// [0.108s][info   ][gc,task      ] GC(0) Using 2 workers of 8 for evacuation
// [0.111s][info   ][gc,phases    ] GC(0)   Pre Evacuate Collection Set: 0.0ms
// [0.111s][info   ][gc,phases    ] GC(0)   Evacuate Collection Set: 2.2ms
// [0.111s][info   ][gc,phases    ] GC(0)   Post Evacuate Collection Set: 0.2ms
// [0.111s][info   ][gc,phases    ] GC(0)   Other: 0.4ms
// [0.111s][info   ][gc,heap      ] GC(0) Eden regions: 2->0(9)
// [0.111s][info   ][gc,heap      ] GC(0) Survivor regions: 0->1(2)
// [0.111s][info   ][gc,heap      ] GC(0) Old regions: 0->0
// [0.111s][info   ][gc,heap      ] GC(0) Humongous regions: 7->3
// [0.111s][info   ][gc,metaspace ] GC(0) Metaspace: 3489K->3489K(1056768K)
// [0.111s][info   ][gc           ] GC(0) Pause Young (Concurrent Start) (G1 Humongous Allocation)
// 8M->3M(20M) 2.923ms
// [0.111s][info   ][gc,cpu       ] GC(0) User=0.00s Sys=0.00s Real=0.00s
// [0.111s][info   ][gc           ] GC(1) Concurrent Cycle
// [0.111s][info   ][gc,marking   ] GC(1) Concurrent Clear Claimed Marks
// [0.111s][info   ][gc,marking   ] GC(1) Concurrent Clear Claimed Marks 0.007ms
// [0.111s][info   ][gc,marking   ] GC(1) Concurrent Scan Root Regions
// 222222222222222222
// [0.112s][info   ][gc,marking   ] GC(1) Concurrent Scan Root Regions 1.288ms
// [0.112s][info   ][gc,marking   ] GC(1) Concurrent Mark (0.112s)
// [0.112s][info   ][gc,marking   ] GC(1) Concurrent Mark From Roots
// [0.112s][info   ][gc,task      ] GC(1) Using 2 workers of 2 for marking
// [0.113s][info   ][gc,marking   ] GC(1) Concurrent Mark From Roots 0.670ms
// [0.113s][info   ][gc,marking   ] GC(1) Concurrent Preclean
// [0.113s][info   ][gc,marking   ] GC(1) Concurrent Preclean 0.027ms
// [0.113s][info   ][gc,marking   ] GC(1) Concurrent Mark (0.112s, 0.113s) 0.722ms
// [0.114s][info   ][gc,start     ] GC(1) Pause Remark
// [0.115s][info   ][gc,stringtable] GC(1) Cleaned string and symbol table, strings: 1378 processed,
// 0 removed, symbols: 16257 processed, 0 removed
// [0.115s][info   ][gc            ] GC(1) Pause Remark 9M->9M(20M) 1.094ms
// [0.115s][info   ][gc,cpu        ] GC(1) User=0.00s Sys=0.00s Real=0.00s
// [0.115s][info   ][gc,marking    ] GC(1) Concurrent Rebuild Remembered Sets
// 333333333333333333
// [0.116s][info   ][gc,marking    ] GC(1) Concurrent Rebuild Remembered Sets 0.313ms
// [0.118s][info   ][gc,start      ] GC(1) Pause Cleanup
// [0.119s][info   ][gc            ] GC(1) Pause Cleanup 13M->13M(20M) 0.353ms
// [0.119s][info   ][gc,cpu        ] GC(1) User=0.00s Sys=0.00s Real=0.00s
// [0.119s][info   ][gc,marking    ] GC(1) Concurrent Cleanup for Next Mark
// [0.119s][info   ][gc,start      ] GC(2) Pause Young (Normal) (G1 Humongous Allocation)
// [0.119s][info   ][gc,task       ] GC(2) Using 2 workers of 8 for evacuation
// [0.123s][info   ][gc,phases     ] GC(2)   Pre Evacuate Collection Set: 0.0ms
// [0.123s][info   ][gc,phases     ] GC(2)   Evacuate Collection Set: 3.3ms
// [0.123s][info   ][gc,phases     ] GC(2)   Post Evacuate Collection Set: 0.3ms
// [0.123s][info   ][gc,phases     ] GC(2)   Other: 0.1ms
// [0.123s][info   ][gc,heap       ] GC(2) Eden regions: 1->0(9)
// [0.123s][info   ][gc,heap       ] GC(2) Survivor regions: 1->1(2)
// [0.123s][info   ][gc,heap       ] GC(2) Old regions: 0->0
// [0.123s][info   ][gc,heap       ] GC(2) Humongous regions: 13->9
// [0.123s][info   ][gc,metaspace  ] GC(2) Metaspace: 3489K->3489K(1056768K)
// [0.123s][info   ][gc            ] GC(2) Pause Young (Normal) (G1 Humongous Allocation)
// 13M->9M(20M) 3.888ms
// [0.123s][info   ][gc,cpu        ] GC(2) User=0.00s Sys=0.00s Real=0.01s
// [0.124s][info   ][gc,marking    ] GC(1) Concurrent Cleanup for Next Mark 4.857ms
// [0.124s][info   ][gc            ] GC(1) Concurrent Cycle 12.837ms
// 444444444444444444
// [0.126s][info   ][gc,heap,exit  ] Heap
// [0.126s][info   ][gc,heap,exit  ]  garbage-first heap   total 20480K, used 14877K
// [0x00000007fec00000, 0x0000000800000000)
// [0.127s][info   ][gc,heap,exit  ]   region size 1024K, 2 young (2048K), 1 survivors (1024K)
// [0.127s][info   ][gc,heap,exit  ]  Metaspace       used 3498K, capacity 4486K, committed 4864K,
// reserved 1056768K
// [0.127s][info   ][gc,heap,exit  ]   class space    used 311K, capacity 386K, committed 512K,
// reserved 1048576K
