package Assn_2025_11_03;
import java.util.Scanner;

public class LeftRotateArrElemBy2Pos {
    public static void main(String[] args) {
        System.out.println("2. Java Program to Left Rotate the Elements in an Array by 2 Positions");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array elements\n");
        String userInput=sc.nextLine();

        String[] userInputArr=userInput.split(" ");
        String[] tempStrArr=new String[userInputArr.length];
        System.arraycopy(userInputArr,2,tempStrArr,0,userInputArr.length-2);
        System.arraycopy(userInputArr,0,tempStrArr,tempStrArr.length-1-1,2);
        System.out.println(String.join(" ",tempStrArr));
    }
}
