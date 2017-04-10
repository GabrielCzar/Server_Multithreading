package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) throws  Exception{
        int port = 9999;
        ServerSocket socketRecepcao = new ServerSocket(port);

        while (true) {
            Socket socketConexao = socketRecepcao.accept();

            HttpRequest request = new HttpRequest(socketConexao);

            Thread thread = new Thread(request);

            thread.start();

        }
    }

}
