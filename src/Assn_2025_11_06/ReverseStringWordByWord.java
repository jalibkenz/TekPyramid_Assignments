package Assn_2025_11_06;

import java.util.Scanner;

public class ReverseStringWordByWord {
    public static void main(String[] args) {
        System.out.println("*22. Java Program to Reverse a String Word by Word (Example: I Love Programming -> Programming Love I)");

        //collecting the String input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String s1=sc.nextLine();

        //split by delimiter space and store in String[]
        String[] strArr=s1.split(" ");
        int start=0,end=strArr.length-1;
        for (int i = end; i >=start ; i--) {
            System.out.println(strArr[i]);
        }

    }
}
