package org.gfg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                //
                return "Returning data from thread : "+Thread.currentThread().getName();
            }
        };

        List<Future<String>> futureList = new ArrayList<>();
        for(int i=0; i<10; i++){
            Future<String> futureString = executorService.submit(callable);
            futureList.add(futureString);
        }

        try {
            for(Future<String> stringFuture : futureList){
                System.out.println(stringFuture.get());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
        executorService.awaitTermination(1,TimeUnit.MINUTES);
        System.out.println("Done");


    }
}
