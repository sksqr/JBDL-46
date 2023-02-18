package org.example;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoServer {

    public static void main(String[] args) {
        System.out.println("Starting server");
        Scanner scanner = new Scanner(System.in);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        while(true){
         System.out.println("Waiting for request data");
         String data = scanner.nextLine();
         executorService.submit(new Runnable() {
             @Override
             public void run() {
                 try {
                     Thread.sleep(100);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
                 System.out.println("Processing data "+data+" thread:"+Thread.currentThread().getName());
             }
         });
        }
    }
}
