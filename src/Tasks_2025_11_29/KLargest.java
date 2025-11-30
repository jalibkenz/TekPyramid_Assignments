package Tasks_2025_11_29;

import java.util.*;

public class KLargest {
    public static List<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min Heap

        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest, keep only k largest
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(kLargest(arr, 3)); // e.g. [10,15,20] (order not guaranteed)
    }
}
