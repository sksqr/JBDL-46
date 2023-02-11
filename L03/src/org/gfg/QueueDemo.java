package org.gfg;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("ravi");
        queue.add("Amit");
        queue.add("Harish");
        queue.add("Rahul");

        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
