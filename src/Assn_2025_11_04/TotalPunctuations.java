package Assn_2025_11_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalPunctuations {
    public static void main(String[] args) {
        System.out.println("10. Java Program to Find the Total Number of Punctuations Present in a String");
        String str="helleeeo!!";
        Pattern p = Pattern.compile("\\p{Punct}");
        Matcher m= p.matcher(str);
        int count=0;
        while (m.find()){
            count++;
            System.out.println(m.group()+" found at "+m.start());
        }
        System.out.println("Count->"+count);
        System.out.println(m.find());
    }
}
