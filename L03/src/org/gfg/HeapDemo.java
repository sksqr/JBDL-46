package org.gfg;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapDemo {

    public static void main(String[] args) {
//        Queue<Integer> queue = new PriorityQueue(); // min heap
        Queue<Integer> queue = new PriorityQueue(Comparator.reverseOrder()); // max heap
        // min heap, minimum will be at top
        queue.add(6);
        queue.add(2);
        queue.add(10);
        queue.add(1);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
