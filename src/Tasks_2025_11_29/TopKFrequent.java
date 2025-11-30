package Tasks_2025_11_29;

import java.util.*;

public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        // 1. Count frequency
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        System.out.println(freq);

        // 2. Min-heap based on frequency to store in format  multiple array[ number , frequency ]
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // 3. Keep only top k frequent
        for (var entry : freq.entrySet()) {
            minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            if (minHeap.size() > k)
                minHeap.poll();
        }

        // 4. Extract result
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll()[0];
        }

        return result;
    }

    // Main method for running test
    public static void main(String[] args) {
        int[] nums = {1111, 1111, 1111, 2, 2, 3, 3, 3, 3};
        int k = 2;

        int[] ans = topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(ans));
    }
}
