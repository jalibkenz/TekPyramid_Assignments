package Assn_2025_11_07;

import java.util.Scanner;

public class MultiTwoMatrices {
    public static void main(String[] args) {
        System.out.println("26. Java Program to Multiply Two Matrices");
        Scanner sc = new Scanner(System.in);
        //Array 1
        System.out.println("2D Array 1: Enter number of rows required");
        int rows1 = sc.nextInt();
        System.out.println("2D Array 1: Enter number of columns required");
        int columns1 = sc.nextInt();

        //Array 2
        System.out.println("2D Array 2: Enter number of rows required");
        int rows2 = sc.nextInt();
        System.out.println("2D Array 2: Enter number of columns required");
        int columns2 = sc.nextInt();

        int[][] matrixOne = new int[rows1][columns1];
        int[][] matrixTwo = new int[rows2][columns2];
        int[][] matrixOneMultiTwo = new int[rows1][columns2];

        System.out.println("Enter 1st Array Elements");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {
                matrixOne[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter 2nd Array Elements");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < columns2; j++) {
                matrixTwo[i][j] = sc.nextInt();
            }
        }


        // Check if multiplication is possible
        if (columns1 != rows2) {
            System.out.println("Matrix multiplication not possible");
            System.out.println("Note: Columns of first Matrix must be equal Rows of second.");
            sc.close();
            return;
        }

        // Matrix multiplication
        System.out.println("Multiplications of two matrices are");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                int sum = 0;
                for (int k = 0; k < columns1; k++) {   // columns1 == rows2
                    sum += matrixOne[i][k] * matrixTwo[k][j];
                }
                matrixOneMultiTwo[i][j] = sum;
                System.out.print(matrixOneMultiTwo[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
