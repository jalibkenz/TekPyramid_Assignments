package Assn_2025_11_05;


import java.util.Scanner;

public class StringIntoNParts {
    public static void main(String[] args) {
        System.out.println("*14. Java Program to Divide a String into N Parts");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String data");
        String str =sc.nextLine();//Example A aB bC c1

        System.out.println("How many parts you want the String to be broken into:");
        int parts = sc.nextInt();

        int totalLength = str.length();
        if (parts <= 0 || parts > totalLength) {
            System.out.printf("Invalid number of parts. Please enter parts less than %d",totalLength);
            return;
        }

        int equalPartSize = totalLength / parts;
        int start = 0, end = equalPartSize;

        //print equal cut parts portion
        for (int i = 0; i < parts-1; i++) {
            System.out.println(str.substring(start, end));
            start = start + equalPartSize;
            end = end + equalPartSize;
        }
        //print extra portion
        System.out.println(str.substring(start));


    }
}
