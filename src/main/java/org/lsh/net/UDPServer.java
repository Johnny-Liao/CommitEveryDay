package org.lsh.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * A demo of UDPServer.
 * Created by Johnny Liao on 2015/12/25.
 */

public class UDPServer {
    public static void main(String[] args) throws IOException {
        String str_send = "Hello UDP Client";
        byte[] buf = new byte[1024];
        // �������3000�˿ڼ������յ�������
        DatagramSocket ds = new DatagramSocket(3000);
        // ���մӿͻ��˷��͹���������
        DatagramPacket dp_receive = new DatagramPacket(buf, 1024);
        System.out.println("server is on��waiting for client to send data......");
        boolean flag = true;
        while (flag) {
            // �������˽������Կͻ��˵�����
            ds.receive(dp_receive);
            System.out.println("server received data from client��");
            String str_receive = new String(dp_receive.getData(), 0, dp_receive.getLength()) +
                    " from " + dp_receive.getAddress().getHostAddress() + ":" + dp_receive.getPort();
            System.out.println(str_receive);
            // ���ݷ������ͻ��˵�9000�˿�
            DatagramPacket dp_send = new DatagramPacket(str_send.getBytes(), str_send.length(), dp_receive.getAddress(), 9000);
            ds.send(dp_send);
            // ����dp_receive�ڽ���������֮�����ڲ���Ϣ����ֵ���Ϊʵ�ʽ��յ���Ϣ���ֽ�����
            // ��������Ҫ��dp_receive���ڲ���Ϣ����������Ϊ1024
            dp_receive.setLength(1024);
        }
        ds.close();
    }
}
