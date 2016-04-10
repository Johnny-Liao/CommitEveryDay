package org.lsh.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * Created by Johnny Liao on 2016/4/10.
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        diffAllocatePosition();
        stringPoolSizeOOM();
    }


    private static void diffAllocatePosition() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);      // 1.7+ both on heap, 1.6- one heap one constant pool.

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);      // 'java' not the first time to view.
    }

    /**
     * JAVA 1.7 及以上不会产生OOM，因为字符串常量池已经移入堆中，并且可以使用-XX:StringTableSize来设定大小。
     **/
    private static void stringPoolSizeOOM() {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
