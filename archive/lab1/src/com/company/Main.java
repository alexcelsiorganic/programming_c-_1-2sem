package com.company;

import java.util.Scanner;

public class Main {

    public static int partition(int l, int r, int[] a) {
        int pivot = a[l];
        int m = l;
        for (int i = l + 1; i < r; i++) {
            if (a[i] <= pivot) {
                m += 1;
                int temp = a[m];
                a[m] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[l];
        a[l] = a[m];
        a[m] = temp;
        return m;
    }

    public static void sort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
//        double index = Math.random() * r;
//
//        int temp = a[l];
//        a[l] = a[(int)index];
//        a[(int)index] = temp;
        int m = partition(l, r, a);
        sort(a, l, m);
        sort(a, m + 1, r);
    }

    public static void main(String[] args) {
       int[] a = new int[10];
       for (int i = 0; i < 10; i++) {
            a[i] = 100 - i * i;
       }
        for (int item : a) {
            System.out.print(item + " ");
        }
        System.out.println("");
        Main.sort(a, 0, 10);
       for (int item : a) {
           System.out.print(item + " ");
       }
    }

    static double calculateActualValue(double x) {
        return Math.log(1 + x);
    }

    static double calculateTailorSeries(double eps, double x) {
        double elem = 100;
        double calculatedValue = 0;
        double multiple = x;
        int counter = 2;
        calculatedValue += multiple;
        while (Math.abs(elem) >= Math.abs(eps)) {
            multiple *= (-1) * x;
            elem = multiple / counter;
            calculatedValue += elem;
            counter++;
        }
        return calculatedValue;
    }

    private static String formattedNumericValue(double value) {
        return String.format("%.9f", value);
    }
}
