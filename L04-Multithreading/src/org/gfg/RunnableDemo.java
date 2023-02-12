package org.gfg;

public class RunnableDemo {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();

        Thread thread = new Thread(myTask);
        thread.setName("worker-0");
        thread.start();

        Thread thread1 = new Thread(myTask);
        thread1.setName("worker-1");
        thread1.start();

//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Random task by - "+Thread.currentThread().getName());
//            }
//        });

        Thread thread2 = new Thread(()->System.out.println("Random task by - "+Thread.currentThread().getName()));
        thread2.setName("worker-2");
        thread2.start();


    }
}
