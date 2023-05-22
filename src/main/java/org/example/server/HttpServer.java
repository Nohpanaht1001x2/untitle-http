package org.example.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

public class HttpServer {
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket acceptSocket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));
        BufferedWriter bufferWritter = new BufferedWriter(new OutputStreamWriter(acceptSocket.getOutputStream()));
        //buffWritter use to respound the client
        //by write string to their output
        String input = bufferedReader.readLine();
//        String string = bufferedReader.readLine();
        System.out.println("method : "+input.split(" ")[0]
                +"\n"+"method : "+input.split(" ")[1]);
//        bufferWritter.write(input +" "+string+" "+ LocalDate.now());
        bufferWritter.newLine();    //to shift close connection message to new line
        bufferWritter.flush();
        System.out.println(input);
        serverSocket.close();
    }
}
