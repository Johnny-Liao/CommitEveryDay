package org.lsh.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Heap out of memory.
 * VM Args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * Created by Johnny Liao on 2016/4/10.
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true) {
            list.add(new OOMObject());
        }
    }
}
