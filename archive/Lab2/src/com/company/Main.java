package com.company;

import java.util.Random;
import java.util.Scanner;



public class Main {

    public static int Counter(int[][] matrix, int element) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == element) {
                count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {


        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter n, m: ");
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] firstMatrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    firstMatrix[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(firstMatrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            int size = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (Counter(firstMatrix, firstMatrix[i][j]) == 2) {
                        size++;
                    }
                }
            }
            int[] twice_array = new int[size];
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (Counter(firstMatrix, firstMatrix[i][j]) == 2) {
                        twice_array[index] = firstMatrix[i][j];
                        index++;
                    }
                }
            }
            if (twice_array.length == 0) {
                System.out.println("not found");
            } else {
                int max = 0;
                for (int i = 0; i < size; i++) {
                    if (twice_array[i] > max) {
                        max = twice_array[i];
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (firstMatrix[i][j] == max) {
                            System.out.println(max);
                            System.out.println("row: " + i + " ");
                            System.out.println("column: " + j + " ");

                        }
                    }
                }
            }
        }
    }
}
/*
5 5

1 7 0 10 11
2 442 2 8 61
13 74 90 9 44
4 31 942 2 3
5 6 81 520 17


 */
