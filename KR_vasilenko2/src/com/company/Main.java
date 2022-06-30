package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;
import java.lang.StringBuilder;




public class Main {
    public static int Search(ArrayList<String> i_S, String k) {
        for (int i = 0; i < i_S.size(); i++) {
            if (i_S.get(i).equals(k)) {
                return i + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
	FileReader f1 = new FileReader("input1.txt");
    FileReader f2 = new FileReader("input2.txt");
        ArrayList<String> text = new ArrayList<>();
        Scanner in10 = new Scanner(f1);
    if (in10.hasNextLine()) {
        ArrayList<StringBuilder> fragments = new ArrayList<>();
        Scanner in2 = new Scanner(f2);
        fragments.add(new StringBuilder(""));
        while (in2.hasNextLine()) {
            String s = in2.next();
            if (s.charAt(3) == ']') {
                fragments.add(new StringBuilder(s.substring(3, s.length())));
            }
            else {
                int i = 3;
                while (s.charAt(i) == ']') {
                    i += 1;
                }
                fragments.add(new StringBuilder(s.substring(i, s.length())));
            }
        }
        int[] counts = new int[fragments.size()];
        ArrayList<String> i_S = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            i_S.add(new String("[" + i + "]"));
        }
        while (in10.hasNextLine()) {
            String l = in10.nextLine();
            text.add(l);
        }
        for (String l : text) {
            Scanner k = new Scanner(l);
            while(k.hasNext()) {
                String j = k.next();
                if (Search(i_S, j) != -1) {
                    text.add(fragments.get(Search(i_S, j)).toString());
                    counts[Search(i_S, j)] += 1;
                }
                else {
                    text.add(j);
            }
        }
        FileWriter writer = new FileWriter("output1.txt");
        FileWriter writer2 = new FileWriter("output2.txt");
        FileWriter writer3 = new FileWriter("output3.txt");
        for (int i = fragments.size() - 1; i > 0; i--) {
            if (i != 1) {
                writer3.write(String.valueOf(i) + "\n");
            }
            else {
                writer3.write(String.valueOf(i));
            }
        }
        for (String s : text) {
            writer.write(s + " ");
        }
        int counter = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0) {
                counter += 1;
            }
        }
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0) {
                if (counter != 1) {
                    writer2.write("[" + i + "]" + fragments.get(i) + "\n");
                    counter = counter -  1;
                }
                else {
                    writer2.write("[" + i + "]" + fragments.get(i));
                }

            }
        }
        writer.close();
        writer2.close();
        writer3.close();
    }
    else {
        FileWriter writer = new FileWriter("output1.txt");
        FileWriter writer2 = new FileWriter("output2.txt");
        FileWriter writer3 = new FileWriter("output3.txt");
        writer.close();
        writer2.close();
        writer3.close();

    }
    }
}
