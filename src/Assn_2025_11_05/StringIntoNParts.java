package Assn_2025_11_05;


import java.util.Scanner;

public class StringIntoNParts {
    public static void main(String[] args) {
        String str = "abcDEFPQR9";
        Scanner sc = new Scanner(System.in);
        System.out.println("How many parts you want the String to be broken into:");
        int parts = sc.nextInt();

        int totalLength = str.length();
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
