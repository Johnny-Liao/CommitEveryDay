package Thread.TheArtofJCP.chapter8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 演示CountDownLatch的使用
 * Created by johnny on 15-10-25.
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();

        c.await();

        System.out.println(3);
    }
}
