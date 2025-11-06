package Assn_2025_11_06;

import java.util.Scanner;

public class StringIsRotationOfAnother {
    public static void main(String[] args) {
        System.out.println("*20. Java Program to Determine Whether One String is a Rotation of Another");

        //collecting the String input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String 1");
        String s1=sc.nextLine();
        System.out.println("Enter the String 2");
        String s2=sc.nextLine();

        //checking both strings are of equal length
        if (s1.length() != s2.length()) {
            System.out.println("NO :: The Array is not the rotated array version of the other");
        } else if ((s1 + s2).contains(s2)) {
            System.out.println("YES :: The Array is the rotated array version of the other");
        }
    }
}
