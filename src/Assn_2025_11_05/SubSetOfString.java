package Assn_2025_11_05;

public class SubSetOfString {
    public static void main(String[] args) {
        System.out.println("*15. Java Program to Find All Subsets of a String (Example: Subsets of \"FUN\" -> F, FU, FUN, U, UN, N)");
        String str = "ABCD";
        for (int i = 0; i <= str.length() - 1; i++) {
            for (int j = i; j <= str.length() - 1; j++) {
                System.out.println(str.substring(i, j + 1));
            }


        }


    }
}
