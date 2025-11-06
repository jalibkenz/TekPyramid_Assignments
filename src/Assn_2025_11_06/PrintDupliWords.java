package Assn_2025_11_06;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintDupliWords {
    public static void main(String[] args) {
        System.out.println("*23. Java Program to Print the Duplicate Words in a String");

        //collecting the String input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String userInput=sc.nextLine();

        //checking freq of words
        String[] userInputArr=userInput.split(" ");
        Map<String,Integer> wordList = new LinkedHashMap<>();
        for (int i = 0; i <= userInputArr.length-1; i++) {
            wordList.put(userInputArr[i], wordList.getOrDefault(userInputArr[i],0)+1);
        }

        for(Map.Entry<String, Integer> x: wordList.entrySet()){//Using Entry to fetch entry in entries (key value pairs)
            if(x.getValue()>1) {//filtering out only duplicates
                System.out.printf("%10s | appears | %s\n", x.getKey(), x.getValue());
            }
        }
    }
}
