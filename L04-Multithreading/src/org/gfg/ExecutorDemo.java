package org.gfg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        long startTime = System.currentTimeMillis();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0; i<20; i++) {
            executorService.submit(() -> {
                System.out.println(" Task Running in : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
//        executorService.shutdownNow();

//        executorService.submit(() -> {
//            System.out.println("Task Running in : " + Thread.currentThread().getName());
//        });

//        while (executorService.isTerminated()){
//            ;
//        }

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Total time taken: "+(endTime - startTime)+" ms");

        System.out.println("Done");
    }
}
