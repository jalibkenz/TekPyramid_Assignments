package Assn_2025_11_06;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("*19. Java Program to Determine Whether a Given String is a Palindrome");

        //collecting the String input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String str=sc.nextLine();

        //flag to set NOT BOOLEAN
        boolean isNotBooleanFlag = false;

        //for indexing converting to char[]
        char[] chArr = str.toCharArray();
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (chArr[start] != chArr[end]) {
                isNotBooleanFlag = true;
                break;
            }
            start++;
            end--;
        }

        if (isNotBooleanFlag) {
            System.out.println("Not a Palindrome");
        } else {
            System.out.println("Palindrome");
        }

    }
}
