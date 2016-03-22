package org.lsh.jvm;

/**
 * ������֤�ڴ����ͻ��ղ���
 * Created by johnny on 16-3-22.
 */
public class MemoryAllocation {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM������-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
     * ���Զ���������������Eden�����䣬��Eden��û���㹻�ռ���з���ʱ�������������һ��Minor GC
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];       // one Minor GC
    }

    /**
     * VM������-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:PretenureSizeThreshold=3145728
     * -XX:PretenureSizeThreshold ������������ֵ�Ķ���ֱ����������з���
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation = new byte[4 * _1MB];         // ֱ�ӷ������������
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
