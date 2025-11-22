package Assn_2025_11_22.NGE_VP_SP_MS_SWM;

import java.util.Stack;
import java.util.Arrays;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>(); // indices of days, monotonic decreasing prices

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
                st.pop();
            }
            span[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
            st.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(calculateSpan(prices)));
        // Output: [1, 1, 1, 2, 1, 4, 6]
    }
}
