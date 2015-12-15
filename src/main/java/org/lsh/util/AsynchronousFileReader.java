package org.lsh.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.*;

/**
 * 使用多线程异步读取文件，一条线程读取一个文件
 * Created by Johnny Liao on 2015/12/15.
 */
public class AsynchronousFileReader {

    Logger logger = Logger.getLogger(AsynchronousFileReader.class);
    /**
     * 从文件中读取的日志字符串存入此BlockingQueue提供多线程异步服务。
     */
    public BlockingQueue<String> logStringQueue = new LinkedBlockingQueue<String>(3600 * 1024);           // 1M 约等于 3600行

    private int threadHolder = 1; // default one thread.
    private int maxThreadHolder = Runtime.getRuntime().availableProcessors() * 2; // 最大线程数为处理器核心数的两倍
    private ExecutorService fixedThreadPool = null;

    /**
     * 只读取单个文件
     *
     * @param filePath 单个文件路径
     */
    public AsynchronousFileReader(String filePath) {
        fixedThreadPool = Executors.newFixedThreadPool(this.threadHolder);
        read(filePath);
    }

    /**
     * 提供多线程异步读取多个文件
     *
     * @param filePath 文件路径数组
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
     * 根据路径名读取单个的文件，多线程处理并放入BlockingQueue。
     *
     * @param filePath 读取的文件路径
     */
    public void read(String filePath) {
        this.fixedThreadPool.execute(new FileReaderWithSingleThread(filePath));
    }

    /**
     * 根据路径名读取多个的文件，多线程处理并放入BlockingQueue。
     *
     * @param filePath 读取的文件路径
     */
    public void read(String[] filePath) {
        for (int i = 0; i < filePath.length; i++) {
            this.fixedThreadPool.execute(new FileReaderWithSingleThread(filePath[i]));
        }
    }


    /**
     * 一条线程处理单个文件的读取工作
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
     * 按行读取文件
     *
     * @param filePath 文件路径
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
                    // 添加进阻塞队列，提供多线程异步操作
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
     * 读取完文件后关闭线程池
     * @return 关闭成功标识
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
         * 异步读取多个文件
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
        System.out.println("当前线程数： " + logFileReader.threadHolder + " 最大线程数：" + logFileReader.maxThreadHolder);
        while (true) {
            try {
                String logString;
                if ((logString = logFileReader.logStringQueue.poll(2000, TimeUnit.MICROSECONDS)) != null) {  // 从BlockingQueue中取不到数据时等待2s,还取不到则认为读取完毕，退出。
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
