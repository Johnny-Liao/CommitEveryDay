package Thread.TheArtofJCP.chapter4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * Created by johnny on 15-10-12.
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true.  Wait @ : " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 条件满足，完成工作
                System.out.println(Thread.currentThread() + " flag is false.  Running @ : " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }

    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                // 获取lock的锁，然后进行通知，通知时不会释放lock的锁
                // 直到当前线程释放lock后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread() + " hold lock. Notify @ : " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notify();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. Sleep @ : " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait(), "Wait Thread.");
        waitThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread notifyThread = new Thread(new Notify(), "Notify Thread.");
        notifyThread.start();
    }
}
