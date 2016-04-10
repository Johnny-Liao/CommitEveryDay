package org.lsh.jvm.oom;

/**
 * VM Args: -Xss128k
 * Created by Johnny Liao on 2016/4/10.
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack Length : " + oom.stackLength);
            throw e;
        }
    }
}
