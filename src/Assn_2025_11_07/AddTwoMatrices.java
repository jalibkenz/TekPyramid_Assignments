package Assn_2025_11_07;

import java.util.Scanner;

public class AddTwoMatrices {
    public static void main(String[] args) {
        System.out.println("25. Java Program to Add Two Matrices");
        System.out.println("Enter number of rows required");
        Scanner sc = new Scanner(System.in);
        int rows=sc.nextInt();
        System.out.println("Enter number of columns required");
        int columns = sc.nextInt();

        int[][] matrixOne=new int[rows][columns];
        int[][] matrixTwo=new int[rows][columns];
        int[][] matrixOnePlusTwo=new int[rows][columns];

        System.out.println("Enter 1st Array Elements");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixOne[i][j]=sc.nextInt();
            }
        }

        System.out.println("Enter 2nd Array Elements");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixTwo[i][j]=sc.nextInt();
            }
        }

        System.out.println("Sum of two matrices are");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixOnePlusTwo[i][j]=matrixOne[i][j]+matrixTwo[i][j];
                System.out.printf("%d ",matrixOnePlusTwo[i][j]);
            }
            System.out.println();
        }
    }
}
