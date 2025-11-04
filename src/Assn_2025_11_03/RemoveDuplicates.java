package Assn_2025_11_03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println("5. Java Program to Remove the Duplicates from an Array");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String userInput = sc.nextLine();
        String[] userInputArr=userInput.split(" ");
        Map<String,Integer> wordList = new LinkedHashMap<>();
        for (int i = 0; i <= userInputArr.length-1; i++) {
            wordList.put(userInputArr[i], wordList.getOrDefault(userInputArr[i],0)+1);
        }
        System.out.println("Removed Duplicates:");
        for(Map.Entry<String, Integer> x: wordList.entrySet()){
            if(x.getValue()==1) {
                System.out.printf("%10s | appears | %s\n", x.getKey(), x.getValue());
            }
        }
    }
}
