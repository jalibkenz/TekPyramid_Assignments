package Assn_2025_11_04;

public class Print3rdLargestInArray {
    public static void main(String[] args) {
        System.out.println("8. Java Program to Print the 3rd Largest Element in an Integer Array without Using a Sorting Algorithm");
        int[] intArr = {3,2,1};
        printLargest(intArr);
    }

    static void printLargest(int[] x) {
        int tempMax1 = Integer.MIN_VALUE;
        int tempMax2 = Integer.MIN_VALUE;
        int tempMax3 = Integer.MIN_VALUE;
        for (int num : x) {
            if (num > tempMax1) {
                tempMax3 = tempMax2;
                tempMax2 = tempMax1;
                tempMax1 = num;
            } else if (num > tempMax2 && num != tempMax1) {
                tempMax3 = tempMax2;
                tempMax2 = num;
            } else if (num > tempMax3 && num != tempMax2 && num != tempMax1) {
                tempMax3 = num;
            }
        }
        System.out.printf("1st Largest is %d\n",tempMax1);
        System.out.printf("2nd Largest is %d\n",tempMax2);
        System.out.printf("3rd Largest is %d",tempMax3);
    }

}

