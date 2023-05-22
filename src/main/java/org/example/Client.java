package org.example;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket("192.168.31.55",8080);
        Socket socket = new Socket("192.168.31.55",8080);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferWritter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferWritter.write("momomm op");
//        bufferWritter.write(bufferedReader.readLine());
        bufferWritter.flush();
        socket.close();

    }
}
