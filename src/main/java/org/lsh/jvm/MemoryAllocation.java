package org.lsh.jvm;

/**
 * 测试验证内存分配和回收策略
 * Created by johnny on 16-3-22.
 */
public class MemoryAllocation {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
     * 测试对象优先在新生代Eden区分配，当Eden区没有足够空间进行分配时，虚拟机将发生一次Minor GC
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];       // one Minor GC
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:PretenureSizeThreshold=3145728
     * -XX:PretenureSizeThreshold 令大于这个设置值的对象直接在老年代中分配
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation = new byte[4 * _1MB];         // 直接分配在老年代中
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
