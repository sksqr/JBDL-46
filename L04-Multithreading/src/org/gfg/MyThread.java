package org.gfg;

import java.util.Scanner;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Hello from - "+Thread.currentThread().getName());
//        System.out.println("Enter your name: ");
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        System.out.println("Hello "+name+" - "+Thread.currentThread().getName() );
    }
}
