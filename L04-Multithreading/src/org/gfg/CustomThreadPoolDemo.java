package org.gfg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolDemo {

    public static void main(String[] args) {
        int  corePoolSize  =    5;
        int  maxPoolSize   =   10;
        long keepAliveTime = 5000;
        ExecutorService threadPoolExecutor =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>()
                );

        threadPoolExecutor.submit(()->System.out.println("Doing task : "+Thread.currentThread().getName()));
//        threadPoolExecutor.submit(()->System.out.println("Doing task : "+Thread.currentThread().getName()));
//        threadPoolExecutor.submit(()->System.out.println("Doing task : "+Thread.currentThread().getName()));
//        threadPoolExecutor.submit(()->System.out.println("Doing task : "+Thread.currentThread().getName()));

        threadPoolExecutor.shutdown();
        System.out.println("Done");;

    }
}
