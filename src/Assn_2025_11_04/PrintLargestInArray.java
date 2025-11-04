package Assn_2025_11_04;

public class PrintLargestInArray {
    public static void main(String[] args) {
        System.out.println("6. Java Program to Print the Largest Element in an Integer Array without Using a Sorting Algorithm");
        int[] intArr={7,1,11,2};
        printLargest(intArr);
    }
    static void printLargest(int[] x){
        int tempMax=x[0];
        for (int i = 0; i <= x.length-1; i++) {
            if(tempMax<x[i]){
                tempMax=x[i];
            }
        }
        System.out.printf("Largest is %d",tempMax);
    }
}
