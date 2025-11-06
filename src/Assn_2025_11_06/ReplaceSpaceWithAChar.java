package Assn_2025_11_06;

import java.util.Scanner;

public class ReplaceSpaceWithAChar {
    public static void main(String[] args) {
        System.out.println("*17. Java Program to Replace the Spaces in a String with a Specific Character");

        //collecting the String input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String str=sc.nextLine();

        //Asking user which character has to be placed instead of white spaces
        System.out.println("Enter the Character to be replaced with");
        String ch=sc.next();

        //replacing the white spaces with char and printing
        System.out.println(str.replaceAll("\\s+",ch));


    }
}
