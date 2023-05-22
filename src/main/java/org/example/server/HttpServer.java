package org.example.server;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

public class HttpServer {
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket acceptSocket = serverSocket.accept();
            new Thread(
                    () -> {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));
                            BufferedWriter bufferWritter = new BufferedWriter(new OutputStreamWriter(acceptSocket.getOutputStream()));
                            //buffWritter use to respond the client
                            //by write string to their output
                            String input = bufferedReader.readLine();
                            //        String string = bufferedReader.readLine();
                            System.out.println("method : " + input.split(" ")[0]
                                    + "\n" + "Resource : " + input.split(" ")[1]);
                            //        bufferWritter.write(input +" "+string+" "+ LocalDate.now());
//                            bufferWritter.newLine();    //to shift close connection message to new line

                            bufferWritter.write("HTTP/1.1 200");
                            bufferWritter.newLine();    //http response newline
                            bufferWritter.newLine();    //http response newline
                            // these 2 newline is require to make html payload to render
                            //because it standard format to transfer webpage
                            //i guess lol
                            bufferWritter.write(
                                    "<html>" +
                                            "<body>" +
                                            "<h1>" +
                                            "<p align=\"center\">"+
                                            "hello world" +
                                            "</p>"+
                                            "</h1>" +
                                            "</body>" +
                                            "</html>"
                                            );


                            bufferWritter.flush();
                            System.out.println(input);
//                            serverSocket.close();
                        } catch (Exception e) {
                            throw new RuntimeException();
                        }
                    }).start();
        }
    }
}
