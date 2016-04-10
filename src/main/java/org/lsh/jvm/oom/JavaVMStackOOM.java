package org.lsh.jvm.oom;

/**
 *VM Args: -Xss2M (notice: cpu 100 % 可能系统假死)
 * Created by Johnny Liao on 2016/4/10.
 */
public class JavaVMStackOOM {

    private void dontStop () {
        while(true) {
        }
    }

    private void stackLeakByThread() {
        while(true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
