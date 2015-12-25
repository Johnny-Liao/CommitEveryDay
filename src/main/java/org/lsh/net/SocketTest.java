package org.lsh.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * A simple demo for Socket
 * Created by Johnny Liao on 2015/12/25.
 */
public class SocketTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("jenkov.com", 80);
        InputStream in = socket.getInputStream();
        System.out.println(in.read());
        in.close();
        socket.close();
    }

}
