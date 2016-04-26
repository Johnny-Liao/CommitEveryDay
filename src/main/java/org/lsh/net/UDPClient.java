package org.lsh.net;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * A UDP Client Demo.
 * Created by Johnny Liao on 2015/12/25.
 */

public class UDPClient {
    private static final int TIMEOUT = 5000;  // ���ý������ݵĳ�ʱʱ��
    private static final int MAX_NUM = 5;      // �����ط����ݵ�������

    public static void main(String args[]) throws IOException {
        String str_send = "Hello UDP Server";

        InetAddress serverAddress = InetAddress.getLocalHost();


        // ���� ���ݵ�DatagramPacketʵ��,���ݷ��򱾵�3000�˿�
        DatagramPacket dp_send = new DatagramPacket(str_send.getBytes(), str_send.length(), serverAddress, 3000);


        DatagramSocket datagramSocket = new DatagramSocket(9000);       // �ͻ�����9000�˿ڼ������յ�������
        datagramSocket.setSoTimeout(TIMEOUT);                           // ���ý�������ʱ�������ʱ��
        byte[] buf = new byte[1024];
        // ���� ���ݵ�DatagramPacketʵ��
        DatagramPacket dp_receive = new DatagramPacket(buf, 1024);

        int tries = 0;                              // �ط����ݵĴ���
        boolean receivedResponse = false;           // �Ƿ���յ����ݵı�־λ

        // ֱ�����յ����ݣ������ط������ﵽԤ��ֵ�����˳�ѭ��
        while (!receivedResponse && tries < MAX_NUM) {

            // ��������
            datagramSocket.send(dp_send);


            try {
                // ���մӷ���˷��ͻ���������
                datagramSocket.receive(dp_receive);
                // ������յ������ݲ�������Ŀ���ַ�����׳��쳣
                if (!dp_receive.getAddress().equals(serverAddress)) {
                    throw new IOException("Received packet from an unknown source.");
                }
                // ������յ����ݡ���receivedResponse��־λ��Ϊtrue���Ӷ��˳�ѭ��
                receivedResponse = true;
            } catch (InterruptedIOException e) {
                // �����������ʱ������ʱ���ط�������һ���ط��Ĵ���
                tries += 1;
                System.out.println("Time out," + (MAX_NUM - tries) + " more tries...");
            }
        }

        if (receivedResponse) {
            // ����յ����ݣ����ӡ����
            System.out.println("client received data from server : ");
            String str_receive = new String(dp_receive.getData(), 0, dp_receive.getLength()) + " from " + dp_receive.getAddress().getHostAddress() + ":" + dp_receive.getPort();
            System.out.println(str_receive);
            // ����dp_receive�ڽ���������֮�����ڲ���Ϣ����ֵ���Ϊʵ�ʽ��յ���Ϣ���ֽ���,��������Ҫ��dp_receive���ڲ���Ϣ����������Ϊ1024
            dp_receive.setLength(1024);
        } else {
            // ����ط�MAX_NUM�����ݺ���δ��÷��������ͻ��������ݣ����ӡ������Ϣ
            System.out.println("No response -- give up.");
        }
        datagramSocket.close();
    }
}