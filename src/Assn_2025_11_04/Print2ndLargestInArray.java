package Assn_2025_11_04;

public class Print2ndLargestInArray {
    public static void main(String[] args) {
        System.out.println("7. Java Program to Print the 2nd Largest Element in an Integer Array without Using a Sorting Algorithm");
        int[] intArr={1,2,3,4,5,6,7,11,5};
        printLargest(intArr);
    }
    static void printLargest(int[] x){
        int tempMax=x[0];
        int tempMax2=x[0];
        for (int i = 0; i <= x.length-1; i++) {
            if(tempMax<x[i]){
                tempMax2=tempMax;
                tempMax=x[i];
            }
        }
        System.out.printf("Largest is %d\n",tempMax);
        System.out.printf("2nd Largest is %d",tempMax2);
    }
}
