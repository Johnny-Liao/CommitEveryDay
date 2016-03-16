package org.lsh.thread;

/**
 * 演示内置锁是可重入的，获取锁的操作粒度是线程。
 * Created by Johnny Liao on 2016/3/5.
 */
public class LoggingWidget extends Widget {

    @Override
    public synchronized void doSomething() {
        System.out.println("Logging Widget do something");
        super.doSomething();        // 如果不可重入，此处将会发生死锁
    }

    public static void main(String[] args) {
        new LoggingWidget().doSomething();
    }
}
