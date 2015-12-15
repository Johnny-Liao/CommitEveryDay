package org.lsh.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.*;

/**
 * ʹ�ö��߳��첽��ȡ�ļ���һ���̶߳�ȡһ���ļ�
 * Created by Johnny Liao on 2015/12/15.
 */
public class AsynchronousFileReader {

    Logger logger = Logger.getLogger(AsynchronousFileReader.class);
    /**
     * ���ļ��ж�ȡ����־�ַ��������BlockingQueue�ṩ���߳��첽����
     */
    public BlockingQueue<String> logStringQueue = new LinkedBlockingQueue<String>(3600 * 1024);           // 1M Լ���� 3600��

    private int threadHolder = 1; // default one thread.
    private int maxThreadHolder = Runtime.getRuntime().availableProcessors() * 2; // ����߳���Ϊ������������������
    private ExecutorService fixedThreadPool = null;

    /**
     * ֻ��ȡ�����ļ�
     *
     * @param filePath �����ļ�·��
     */
    public AsynchronousFileReader(String filePath) {
        fixedThreadPool = Executors.newFixedThreadPool(this.threadHolder);
        read(filePath);
    }

    /**
     * �ṩ���߳��첽��ȡ����ļ�
     *
     * @param filePath �ļ�·������
     */
    public AsynchronousFileReader(String[] filePath) {
        int threadHolder = filePath.length;
        if (threadHolder > maxThreadHolder) {
            this.threadHolder = maxThreadHolder;
        } else {
            this.threadHolder = threadHolder;
        }
        fixedThreadPool = Executors.newFixedThreadPool(this.threadHolder);
        read(filePath);
    }


    /**
     * ����·������ȡ�������ļ������̴߳�������BlockingQueue��
     *
     * @param filePath ��ȡ���ļ�·��
     */
    public void read(String filePath) {
        this.fixedThreadPool.execute(new FileReaderWithSingleThread(filePath));
    }

    /**
     * ����·������ȡ������ļ������̴߳�������BlockingQueue��
     *
     * @param filePath ��ȡ���ļ�·��
     */
    public void read(String[] filePath) {
        for (int i = 0; i < filePath.length; i++) {
            this.fixedThreadPool.execute(new FileReaderWithSingleThread(filePath[i]));
        }
    }


    /**
     * һ���̴߳������ļ��Ķ�ȡ����
     */
    class FileReaderWithSingleThread implements Runnable {

        private String filePath;

        public FileReaderWithSingleThread(String filePath) {
            this.filePath = filePath;
        }

        public void run() {
            readLogByPath(filePath);
        }

    }


    /**
     * ���ж�ȡ�ļ�
     *
     * @param filePath �ļ�·��
     */
    public void readLogByPath(String filePath) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String oneLineLog;
            while ((oneLineLog = bufferedReader.readLine()) != null) {
                try {
                    // ��ӽ��������У��ṩ���߳��첽����
                    if (!logStringQueue.offer(oneLineLog, 1000, TimeUnit.MICROSECONDS)) {
                        logger.error("This line is not read : " + oneLineLog);
                    }
                } catch (InterruptedException e) {
                    logger.error("Waiting add log string error. Interrupted !", e);
                }
            }
        } catch (IOException e) {
            logger.error("ReadLogByPath IOException : ", e);
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                logger.error("Close BufferReader Exception in readLogByPath : ", e);
            }
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                logger.error("Close FileReader Exception in readLogByPath : ", e);
            }

        }
    }

    /**
     * ��ȡ���ļ���ر��̳߳�
     * @return �رճɹ���ʶ
     */
    public boolean destroyThreadPool() {
        if (!fixedThreadPool.isShutdown()) {
            fixedThreadPool.shutdown();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        /**
         * �첽��ȡ����ļ�
         */
        String bashPath = "D:\\develop_tools\\eclipse_workspace\\logs\\";
        String[] logs = {
                bashPath + "aaa",
                bashPath + "bbb",
                bashPath + "ccc",
                bashPath + "log4j-test.log",
                bashPath + "log4j-test2.log",
                bashPath + "log-out.log"
        };

        AsynchronousFileReader logFileReader = new AsynchronousFileReader(logs);
        System.out.println("��ǰ�߳����� " + logFileReader.threadHolder + " ����߳�����" + logFileReader.maxThreadHolder);
        while (true) {
            try {
                String logString;
                if ((logString = logFileReader.logStringQueue.poll(2000, TimeUnit.MICROSECONDS)) != null) {  // ��BlockingQueue��ȡ��������ʱ�ȴ�2s,��ȡ��������Ϊ��ȡ��ϣ��˳���
                    System.out.println(logString);
                } else {
                    System.out.println("QUIT AND DestroyThreadPool");
                    logFileReader.destroyThreadPool();
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
