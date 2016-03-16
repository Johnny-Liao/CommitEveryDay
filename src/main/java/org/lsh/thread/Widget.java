package org.lsh.thread;

/**
 * 演示内置锁是可重入的
 * Created by Johnny Liao on 2016/3/5.
 */
public class Widget {

    public synchronized void doSomething () {
        System.out.println("Widget say do something");
    }

}
