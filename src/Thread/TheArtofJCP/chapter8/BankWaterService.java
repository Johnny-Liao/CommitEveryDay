package Thread.TheArtofJCP.chapter8;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 模拟银行流水处理服务
 * Created by johnny on 15-10-25.
 */
public class BankWaterService implements Runnable {

    /**
     * 创建4个屏障，处理完成之后执行当前的run方法
     */
    private CyclicBarrier c = new CyclicBarrier(4, this); // this don't forget.

    /**
     * 假设只有4个sheet，所以只启动4个线程
     */
    private Executor executor = Executors.newFixedThreadPool(4);

    /**
     * 保存每个sheet计算出的银流结果
     */
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count () {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // 计算当前sheet的银流结果，计算代码省略
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    // 完成一个计算，插入一个屏障
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
        // 汇总每个sheet计算出的结果
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
