package Tasks_2025_11_29;


/**
 * @author jalibkenz
 * TO REMEMBER THE CONCEPT
 * Connect Ropes — Minimum Cost
 *
 * Idea: put all rope lengths in a min-heap. Repeatedly remove the two smallest lengths, connect them (cost = sum), add the sum back to the heap. Accumulate total cost. This greedy approach is optimal.
 *
 * Complexity: building heap O(n), each of ~n merges takes O(log n) → O(n log n).
 * Use long for cost to avoid overflow on large inputs.
 *
 * Median in a Stream
 *
 * Idea: maintain two heaps:
 *
 * maxHeap (largest at top) for lower half (use Collections.reverseOrder()).
 *
 * minHeap (smallest at top) for upper half.
 *
 * Balance sizes so they differ by at most 1. Insert in O(log n). Median:
 *
 * if sizes equal → average of tops (return double)
 *
 * else → top of the larger heap.
 *
 * Complexity: insert O(log n), getMedian O(1).
 */



import java.util.*;

//Connect Ropes — Minimum Cost   | Median in a Stream
public class CRMC_MIAS {

    // ---------- Connect Ropes (Min Cost) ----------
    // Returns minimum cost to connect all ropes.
    public static long connectRopesMinCost(long[] ropes) {
        if (ropes == null || ropes.length == 0) return 0L;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long r : ropes) minHeap.offer(r);

        long totalCost = 0L;
        while (minHeap.size() > 1) {
            long a = minHeap.poll();
            long b = minHeap.poll();
            long cost = a + b;
            totalCost += cost;
            minHeap.offer(cost);
        }
        return totalCost;
    }

    // ---------- Median in a Stream ----------
    public static class MedianStream {
        private PriorityQueue<Integer> maxHeap; // lower half
        private PriorityQueue<Integer> minHeap; // upper half

        public MedianStream() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        // Add number to data structure
        public void add(int num) {
            // Decide where to put the number
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // Re-balance: sizes should differ by at most 1
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            }
        }

        // Return median as double
        public double getMedian() {
            if (maxHeap.size() == minHeap.size()) {
                if (maxHeap.isEmpty()) return 0.0; // no elements
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        }
    }

    // ---------- Demo main ----------
    public static void main(String[] args) {
        // Demo: Connect ropes
        long[] ropes = {4, 3, 2, 6};
        long minCost = connectRopesMinCost(ropes);
        System.out.println("Connect ropes minimum cost: " + minCost);
        // Expected: 29 (combine 2+3=5 cost, heap -> {4,5,6}; combine 4+5=9 cost -> {6,9}; combine 6+9=15 cost; total 5+9+15 = 29)

        // Demo: Median stream
        MedianStream ms = new MedianStream();
        int[] stream = {5, 15, 1, 3};
        for (int x : stream) {
            ms.add(x);
            System.out.println("Added " + x + " → median = " + ms.getMedian());
        }
        // Expected medians: after 5 -> 5.0, after 15 -> 10.0, after 1 -> 5.0, after 3 -> 4.0
    }
}

