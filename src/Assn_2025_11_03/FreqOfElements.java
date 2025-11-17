package Assn_2025_11_03;

import java.util.*;

public class FreqOfElements {
    public static void main(String[] args) {
        System.out.println("1. Java Program to Find the Frequency of Elements in an Array");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String userInput = sc.nextLine();
        String[] userInputArr=userInput.split(" ");
        Map<String,Integer> wordList = new LinkedHashMap<>();
        for (int i = 0; i <= userInputArr.length-1; i++) {
            wordList.put(userInputArr[i], wordList.getOrDefault(userInputArr[i],0)+1);
        }
        System.out.println("The Frequency of Elements are:");
        for(Map.Entry<String, Integer> x: wordList.entrySet()){//Using Entry to fetch entry in entries (key value pairs)
            System.out.printf("%10s | appears | %s\n",x.getKey(),x.getValue());
        }
        //Another way
        CharFrequency.main();
    }


}


//Frequency of elements from String Literal
class CharFrequency {
    public static void main() {
        String str = "hello world";
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (c != ' ')  // ignore spaces
                freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character frequency: " + freq);
    }
}
