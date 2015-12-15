package Thread.TheArtofJCP.chapter4.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试使用自定义超时连接
 * Created by johnny on 15-11-21.
 */
public class ConnectionTest {
    static ConnectionPool pool = new ConnectionPool(10);
    // 保证所有ConnectionRunner能够同时开始
    static CountDownLatch start = new CountDownLatch(1);
    // main线程将会等待所有ConnectionRunner结束后才能继续执行
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        // 线程数量，可以修改线程数量进行观察
        int threadCount = 20;
        end = new CountDownLatch(threadCount);

        // 构造ConnectionRunner所需参数
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunner Thread");
            thread.start();
        }

        // 保证所有ConnectionRunner能够同时开始
        start.countDown();
        // 等待所有ConnectionRunner结束后继续执行main方法
        end.await();

        // 计算未获取到比率
        float rate = (float) notGot.intValue() / (threadCount * count) * 100;
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数
        String rateNum = df.format(rate);//返回的是String类型

        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + notGot);
        System.out.println("not got rate: " + rateNum + "%");
    }

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        /**
         * 构造获取连接内部类
         * @param count 总共获取连接数
         * @param got 获取成功数
         * @param notGot 未获取成功数
         */
        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (count > 0) {
                try {
                    // 从线程池中获取连接，如果1000ms内无法获取到，将会返回null
                    // 分别统计连接获取的数量got和未获取到的数量notGot
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.addAndGet(1);
                        }
                    } else {
                        notGot.addAndGet(1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }

            end.countDown();
        }
    }


}
