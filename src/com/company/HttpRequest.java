package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

final class HttpRequest implements Runnable {
    final static String CRLF = "\r\n";
    Socket socket;

    HttpRequest (Socket socket) throws Exception {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            processRequest();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void processRequest() throws Exception {
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        InputStreamReader is = new InputStreamReader(in);
        DataOutputStream dos = new DataOutputStream(out);

        BufferedReader br = new BufferedReader(is);
        String requestLine = br.readLine();

        System.out.println();
        System.out.println(requestLine);

        while ((requestLine = br.readLine()).length() != 0) {
            System.out.println(requestLine);
        }

        String path = "src/index.html";
        String status = "HTTP/1.0 200 OK" + CRLF
                ,      contentType = "Content-type: text/html" + CRLF;

        dos.writeBytes(status);
        dos.writeBytes(contentType);
        dos.writeBytes(CRLF);
        dos.writeBytes(readFile(path));

        dos.close();
        br.close();
        socket.close();
    }

    public String readFile (String path) throws FileNotFoundException{
        FileInputStream fs = new FileInputStream(path);
        String buffer = "";
        Scanner scanner = new Scanner(fs);
        while (scanner.hasNext())
            buffer += scanner.nextLine();
        return buffer;
    }
}
