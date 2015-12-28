package org.lsh.net.diffServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 基于OIO的Server端
 * Created by Johnny Liao on 2015/12/28.
 */
public class PlainOIOServer {

    public void server(int port) throws IOException {
        ServerSocket ss = new ServerSocket(port);
        try {
            // epoll bug
            while (true) {
                final Socket clientSocket = ss.accept();
                System.out.println("Accecpted connection from " + clientSocket);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            out = clientSocket.getOutputStream();
                            out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                            out.flush();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } finally {
                            try {
                                clientSocket.close();
                            } catch (IOException e) {
                                // ignore on close.
                            }
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            // default port
            port = 8080;
        }
        new PlainOIOServer().server(port);
    }
}
