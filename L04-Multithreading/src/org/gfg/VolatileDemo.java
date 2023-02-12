package org.gfg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VolatileDemo {

    public static void main(String[] args) throws InterruptedException {

        VolatileTask task1 = new VolatileTask("S");

        VolatileTask task2 = new VolatileTask("R");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(task1);
        executorService.submit(task2);

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);

        System.out.println("Done");
    }
}
