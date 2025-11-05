package Assn_2025_11_05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalVowels {
    public static void main(String[] args) {
        System.out.println("*11. Java Program to Find the Total Number of Vowels Present in a String");
        String s="hello dear";
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        int count=0;
        while(m.find()){
            count++;
        }
        System.out.println("Total Vowels->"+count);
    }
}
