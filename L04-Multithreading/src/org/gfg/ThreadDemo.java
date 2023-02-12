package org.gfg;

public class ThreadDemo {

    public static void main(String[] args) {
        System.out.println("Hello from - "+Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        myThread.setName("thread-0");
      //  myThread.run();
        myThread.start();

        MyThread myThread1 = new MyThread();
        myThread1.setName("thread-1");
        myThread1.start();


        try {
            myThread.join();
            myThread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done");

    }
}
