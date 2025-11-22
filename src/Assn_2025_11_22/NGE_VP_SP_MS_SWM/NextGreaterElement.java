package Assn_2025_11_22.NGE_VP_SP_MS_SWM;

import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElement {
    public static int[] nextGreaterToRight(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>(); // store indices
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 2, 25, 7, 8};
        System.out.println(Arrays.toString(nextGreaterToRight(a)));
        // Output: [5, 25, 25, -1, 8, -1]
    }
}
