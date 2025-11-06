package Assn_2025_11_06;

import java.util.Scanner;

public class ReverseStringCharByChar {
    public static void main(String[] args) {
        System.out.println("*21. Java Program to Reverse a String Character by Character");

        //collecting the String input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String s1=sc.nextLine();

        //reverse, so char[] to have index
        char[] charArr=s1.toCharArray();
        int start=0,end=charArr.length-1;
        char temp;
        while(start<end){
            temp=charArr[start];
            charArr[start]=charArr[end];
            charArr[end]=temp;
            start++;
            end--;
        }
        System.out.println(new String(charArr));

    }
}
