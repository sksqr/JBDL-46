package org.gfg;

public class MyTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Working on task - "+Thread.currentThread().getName());
    }
}
