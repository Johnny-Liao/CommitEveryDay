package Thread.TheArtofJCP.chapter4.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ����ʹ���Զ��峬ʱ����
 * Created by johnny on 15-11-21.
 */
public class ConnectionTest {
    static ConnectionPool pool = new ConnectionPool(10);
    // ��֤����ConnectionRunner�ܹ�ͬʱ��ʼ
    static CountDownLatch start = new CountDownLatch(1);
    // main�߳̽���ȴ�����ConnectionRunner��������ܼ���ִ��
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        // �߳������������޸��߳��������й۲�
        int threadCount = 20;
        end = new CountDownLatch(threadCount);

        // ����ConnectionRunner�������
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunner Thread");
            thread.start();
        }

        // ��֤����ConnectionRunner�ܹ�ͬʱ��ʼ
        start.countDown();
        // �ȴ�����ConnectionRunner���������ִ��main����
        end.await();

        // ����δ��ȡ������
        float rate = (float) notGot.intValue() / (threadCount * count) * 100;
        DecimalFormat df = new DecimalFormat("0.00");//��ʽ��С��
        String rateNum = df.format(rate);//���ص���String����

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
         * �����ȡ�����ڲ���
         * @param count �ܹ���ȡ������
         * @param got ��ȡ�ɹ���
         * @param notGot δ��ȡ�ɹ���
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
                    // ���̳߳��л�ȡ���ӣ����1000ms���޷���ȡ�������᷵��null
                    // �ֱ�ͳ�����ӻ�ȡ������got��δ��ȡ��������notGot
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
