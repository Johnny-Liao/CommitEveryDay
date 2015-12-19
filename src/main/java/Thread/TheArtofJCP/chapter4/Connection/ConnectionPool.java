package Thread.TheArtofJCP.chapter4.Connection;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * ʹ�õȴ���ʱģʽ������һ�����ݿ����ӳ�
 * Created by johnny on 15-10-14.
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    // �ͷ�����
    public void releaseConnection(Connection connection) {
        synchronized (pool) {
            // �ͷ����Ӽ����������ӽ����ӳأ�Ȼ��֪ͨ���еȴ��̣߳�ʹ����Ի�ȡ����
            pool.addLast(connection);
            pool.notifyAll();
        }
    }

    // ��mills���޷���ȡ�����ӣ����᷵��null
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}