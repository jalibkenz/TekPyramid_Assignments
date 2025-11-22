package Assn_2025_11_22.NGE_VP_SP_MS_SWM;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>(); // store indices, values decreasing in dq

        for (int i = 0; i < n; i++) {
            // remove indices out of window (i - k)
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst();

            // remove smaller values from the tail
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();

            dq.offerLast(i);

            // window formed
            if (i >= k - 1) res[i - k + 1] = nums[dq.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        // Output: [3, 3, 5, 5, 6, 7]
    }
}
