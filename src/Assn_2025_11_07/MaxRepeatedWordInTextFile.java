package Assn_2025_11_07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


public class MaxRepeatedWordInTextFile {
    public static void main(String[] args) {

        //Read File
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/Users/jalibkenz/IdeaProjects/TekPyramidAssignments/src/Assn_2025_11_07/TextFile.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }




        //read Line by line using BufferedReader which internally calls FileReader(which only reads char by char)
        String oneLineInFile;
        String allWords="";
        try {
            if (br!=null) { // handling null point exception in BufferedReader
                while ((oneLineInFile = br.readLine()) != null) {
                    //System.out.println(oneLineInFile);
                    allWords = allWords.concat(" " + oneLineInFile);
                }
            }
            System.out.println(allWords);
        }catch (IOException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }



        //now checking frequency
        String[] userInputArr=allWords.split(" ");
        Map<String,Integer> wordList = new LinkedHashMap<>();
        for (int i = 0; i <= userInputArr.length-1; i++) {
            wordList.put(userInputArr[i], wordList.getOrDefault(userInputArr[i],0)+1);
        }
        System.out.println("The Frequency of Elements are:");
        for(Map.Entry<String, Integer> x: wordList.entrySet()){//Using Entry to fetch entry in entries (key value pairs)
            System.out.printf("%10s | appears | %s\n",x.getKey(),x.getValue());
        }



    }
}
