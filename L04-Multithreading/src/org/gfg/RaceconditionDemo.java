package org.gfg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceconditionDemo {
    public static void main(String[] args) {
        VisitorCount task = new VisitorCount();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i=0; i<40000; i++){
            executorService.submit(task);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total Visitor:"+task.getVistor());
    }
}
