package Tasks_2025_11_29;

import java.util.*;

public class KSmallest {
    public static List<Integer> kSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder()); // Max Heap

        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove largest, keep only k smallest
            }
        }

        // Now heap has k smallest (not sorted)
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(kSmallest(arr, 3)); // e.g. [4,3,7] (order not guaranteed)
    }
}
