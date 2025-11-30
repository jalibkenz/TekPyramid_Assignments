package Tasks_2025_11_29;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinMaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        minHeap.add(9);
        minHeap.add(8);
        minHeap.add(7);
        minHeap.add(6);
        minHeap.add(5);
        minHeap.add(4);


        maxHeap.add(9);
        maxHeap.add(8);
        maxHeap.add(7);
        maxHeap.add(6);
        maxHeap.add(5);
        maxHeap.add(4);

        System.out.println("Min element: " + minHeap.peek());

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); //while polling the heap-ify keeps root meaningful
        }


        System.out.println("Max element: " + maxHeap.peek());

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }


    }
}

