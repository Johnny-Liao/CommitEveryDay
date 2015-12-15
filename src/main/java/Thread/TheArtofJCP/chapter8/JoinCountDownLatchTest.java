package Thread.TheArtofJCP.chapter8;

import java.util.concurrent.TimeUnit;

/**
 * ����ʹ��join����ʵ��һ�������̵߳ȴ������߳���ɲ���
 * Created by johnny on 15-10-25.
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);  // �Ŵ�Ч��
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
        // join ʹ��ǰ�̵߳ȴ�join�߳�ִ�н���
        parser1.join();         // main �̵߳ȴ�parser1ִ�н���
        parser2.join();
        System.out.println("all parser finish.");
    }
}
