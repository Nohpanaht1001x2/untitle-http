package org.example;

import org.example.server.HttpServer;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( Thread.currentThread().getName());
        HttpServer server = new HttpServer();
        server.start();
    }
}
