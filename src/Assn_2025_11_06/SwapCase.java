package Assn_2025_11_06;

import java.util.Scanner;

public class SwapCase {
    public static void main(String[] args) {
        System.out.println("*18. Java Program to Replace Lower-Case Characters with Upper-Case and Vice-Versa");

        //collecting the String input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String str=sc.nextLine();

        //for indexing converting to char[]
        char[] chArr=str.toCharArray();

        //checking the case and swapping the case
        for (int i = 0; i < chArr.length; i++) {
            //checking upper case and converting to lower case
            if((int)chArr[i]>=(int)'A' && (int)chArr[i]<=(int)'Z'){
                chArr[i]=(char)((int)chArr[i]+32);//converting to 97-122 a-z range
            }
            //checking lower case and converting to lower case
            else if((int)chArr[i]>=(int)'a' && (int)chArr[i]<=(int)'z'){
                chArr[i]=(char)((int)chArr[i]-32);//converting to 65-90 A-Z range
            }
        }
        System.out.println(new String(chArr));
    }
}
