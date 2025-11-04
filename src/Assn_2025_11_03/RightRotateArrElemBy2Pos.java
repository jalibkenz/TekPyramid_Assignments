package Assn_2025_11_03;

import java.util.Scanner;

public class RightRotateArrElemBy2Pos {
    public static void main(String[] args) {
        System.out.println("3. Java Program to Right Rotate the Elements in an Array by 2 Positions");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array elements\n");
        String userInput=sc.nextLine();
        String[] userInputArr=userInput.split(" ");
        String[] tempStrArr=new String[userInputArr.length];
        System.arraycopy(userInputArr,0,tempStrArr,2,userInputArr.length-2);
        System.arraycopy(userInputArr,userInputArr.length-1-1,tempStrArr,0,2);
        System.out.println(String.join(" ",tempStrArr));

    }
}
