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
                // �������㣬��ɹ���
                System.out.println(Thread.currentThread() + " flag is false.  Running @ : " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }

    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                // ��ȡlock������Ȼ�����֪ͨ��֪ͨʱ�����ͷ�lock����
                // ֱ����ǰ�߳��ͷ�lock��WaitThread���ܴ�wait�����з���
                System.out.println(Thread.currentThread() + " hold lock. Notify @ : " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notify();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // �ٴμ���
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
