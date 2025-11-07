package Assn_2025_11_07;

import java.util.Scanner;

public class TransposeMatrix {
    public static void main(String[] args) {
        System.out.println("27. Java Program to Find the Transpose of a Matrix");
        Scanner sc =new Scanner(System.in);
        //Array 1
        System.out.println("2D Array: Enter number of rows required");
        int rows = sc.nextInt();
        System.out.println("2D Array: Enter number of columns required");
        int columns = sc.nextInt();

        int[][] matrixOne = new int[rows][columns];
        int[][] matrixOneTransposed = new int[columns][rows];

        // Input elements
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixOne[i][j] = sc.nextInt();
            }
        }

        // Transpose logic
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixOneTransposed[j][i] = matrixOne[i][j];
            }
        }

        // Print input matrix
        System.out.println("\nOriginal Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrixOne[i][j] + " ");
            }
            System.out.println();
        }

        // Print transposed matrix
        System.out.println("\nTransposed Matrix:");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrixOneTransposed[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();



    }
}
