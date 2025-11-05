package Assn_2025_11_05;

import java.util.Arrays;

public class Check2StringAnagram {
    public static void main(String[] args) {
        System.out.println("*13. Java Program to Determine if Two Strings are Anagrams");
        String s1="silent";
        String s2="listen";
        char[] s1CharArr=s1.toCharArray();
        char[] s2CharArr=s2.toCharArray();
        Arrays.sort(s1CharArr);
        Arrays.sort(s2CharArr);
        if(Arrays.equals(s1CharArr,s2CharArr)){
            System.out.println("Anagram");
        }
        else System.out.println("Not an Anagram");
    }
}
