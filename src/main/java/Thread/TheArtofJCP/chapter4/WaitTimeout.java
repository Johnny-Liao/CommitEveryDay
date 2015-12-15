package Thread.TheArtofJCP.chapter4;

/**
 * 演示等待超时模型
 * Created by johnny on 15-11-21.
 */
public class WaitTimeout {

    public synchronized String get(long mills) throws InterruptedException {
        long future = System.currentTimeMillis() + mills;
        long remaining = mills;

        while (remaining > 0) {
            wait(remaining);
            remaining = future - System.currentTimeMillis();
        }

        return "result";
    }

    public static void main(String[] args) throws InterruptedException {
        WaitTimeout wt = new WaitTimeout();
        System.out.println(wt.get(5000L));
    }

}