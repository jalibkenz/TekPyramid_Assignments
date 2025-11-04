package Assn_2025_11_04;

import java.util.Arrays;

public class SortArEleBubble {
    public static void main(String[] args) {
        System.out.println("9. Java Program to Sort Elements in an Array Using Bubble Sort");
        int[] intArr = {9, 8, 7, 6, 5};
        // int[] intArr = {1,2,3,4,5};
//        Arrays.sort(intArr);
//        System.out.println(Arrays.toString(intArr));
        int[] d = sortArray(intArr);
        System.out.println(Arrays.toString(d));
    }

    static int[] sortArray(int[] x) {
        int temp;
        boolean swapDone = false;
        for (int j = 0; j < x.length - 1; j++) {
            for (int i = 0; i < x.length - 1; i++) {
                if (x[i] > x[i + 1]) {
                    temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                    swapDone = true;
                }

            }
            if (!swapDone) {
                break;
            }
        }
        return x;
    }
}
