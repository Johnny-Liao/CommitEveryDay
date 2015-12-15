package Thread.TheArtofJCP.chapter8;

import java.util.concurrent.TimeUnit;

/**
 * 测试使用join方法实现一个或多个线程等待其他线程完成操作
 * Created by johnny on 15-10-25.
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);  // 放大效果
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("parser1");
            }
        });

        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("parser2");
            }
        });

        parser1.start();
        parser2.start();
        // join 使当前线程等待join线程执行结束
        parser1.join();         // main 线程等待parser1执行结束
        parser2.join();
        System.out.println("all parser finish.");
    }
}
