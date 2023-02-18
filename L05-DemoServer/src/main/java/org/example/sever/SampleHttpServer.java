package org.example.sever;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SampleHttpServer {

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost",8080),0);
            server.createContext("/hello",new HelloHttpHandler());
            //
            server.setExecutor(Executors.newFixedThreadPool(3));
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
