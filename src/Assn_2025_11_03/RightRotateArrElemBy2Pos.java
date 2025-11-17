package Assn_2025_11_03;

import java.util.Scanner;

public class RightRotateArrElemBy2Pos {
    public static void main(String[] args) {
        System.out.println("3. Java Program to Right ROTATE the Elements in an Array by 2 Positions");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array elements\n");
        String userInput=sc.nextLine();
        String[] userInputArr=userInput.split(" ");
        String[] tempStrArr=new String[userInputArr.length];
        System.arraycopy(userInputArr,0,tempStrArr,2,userInputArr.length-2);
        System.arraycopy(userInputArr,userInputArr.length-1-1,tempStrArr,0,2);
        System.out.println(String.join(" ",tempStrArr));
        RightRotateArray.main();
    }
}

//right rotate with flow integer
class RightRotateArray {
    public static void main() {
        System.out.println("Java Program to Right ROTATE the Elements in an Array by 2 Positions");
        Scanner sc = new Scanner(System.in);

        // Input: size of array
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input: elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int positions = 2;  // Rotate by 2 positions

        // Right rotation logic
        for (int i = 0; i < positions; i++) {
            int last = arr[n - 1];  // Store last element
            for (int j = n - 1; j > 0; j--) {
                arr[j] = arr[j - 1];  // Shift elements to the right
            }
            arr[0] = last;  // Put last element at first position
        }

        // Output
        System.out.println("Array after right rotation by 2 positions:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}