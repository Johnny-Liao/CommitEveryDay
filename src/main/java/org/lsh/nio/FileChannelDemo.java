package org.lsh.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Simple demo of file channel
 * Created by johnny on 15-12-23.
 */
public class FileChannelDemo {

    public static void readFile(String filePath) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r");
        FileChannel inChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int bytesRead = inChannel.read(byteBuffer);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            byteBuffer.flip();
            // 注意 buf.flip() 的调用，首先读取数据到Buffer，然后反转Buffer,接着再从Buffer中读取数据。
            while (byteBuffer.hasRemaining()) {
                System.out.print((char)byteBuffer.get());
            }
            byteBuffer.clear();
            bytesRead = inChannel.read(byteBuffer);
        }
        randomAccessFile.close();
    }

    public static void main(String[] args) throws IOException {
        readFile("/home/johnny/johnnyFiles/test/a.txt");
    }
}
