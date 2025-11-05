package Assn_2025_11_05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalConsonants {
    public static void main(String[] args) {
        System.out.println("*12. Java Program to Find the Total Number of Consonants Present in a String");
        String s="hello dear";
        Pattern p = Pattern.compile("[^aeiou ]");
        Matcher m = p.matcher(s);
        int count=0;
        while(m.find()){
            count++;
            System.out.println(m.group()+" found at "+m.start());
        }
        System.out.println("Total Consonants->"+count);

    }
}
