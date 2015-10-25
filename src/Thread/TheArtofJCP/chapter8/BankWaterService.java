package Thread.TheArtofJCP.chapter8;

import java.util.Map;
import java.util.concurrent.*;

/**
 * ģ��������ˮ�������
 * Created by johnny on 15-10-25.
 */
public class BankWaterService implements Runnable {

    /**
     * ����4�����ϣ��������֮��ִ�е�ǰ��run����
     */
    private CyclicBarrier c = new CyclicBarrier(4, this); // this don't forget.

    /**
     * ����ֻ��4��sheet������ֻ����4���߳�
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * ����ÿ��sheet��������������
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count () {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // ���㵱ǰsheet������������������ʡ��
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    // ���һ�����㣬����һ������
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    @Override
    public void run() {
        int result = 0;
        // ����ÿ��sheet������Ľ��
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bws = new BankWaterService();
        bws.count();
    }

}
