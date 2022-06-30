package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;
import java.lang.StringBuilder;








public class Main {

    public static void main(String[] args) throws IOException {
        File file1 = new File("input1.txt");
        Scanner in1 = new Scanner(file1);
        int posib = in1.nextInt();
        File file = new File("input2.docx");
        int length = (int) file.length();
        if (posib <= length) {
            Integer amount = length / posib;
            if (amount % 2 != 0) {
                amount += 1;
            }
            FileWriter writer1 = new FileWriter("output1.txt");
            writer1.write(amount.toString());
            ArrayList<String> names = new ArrayList<>();
            for (int i = 0; i < amount; i++) {
                Integer k = i + 1;
                names.add(new String(k.toString() + "#input2.txt"));
            }
            ArrayList<FileOutputStream> files = new ArrayList<>();
            for (int i = 0; i < names.size(); i++) {
                files.add(new FileOutputStream(names.get(i)));
            }
            for (int i = names.size() - 1; i >= 0; i--) {
                System.out.println(names.get(i));
            }
            FileInputStream inputStream = new FileInputStream("input2.docx");
            int count = 0;
            for (int i = 0; i < files.size(); i++) {
                count += posib;
                if (length - count > 0) {
                    byte[] bytes = new byte[posib];
                    inputStream.read(bytes);
                    files.get(i).write(bytes);
                }

                else {
                    System.out.println("A");
                    byte[] bytes = new byte[length - count + posib];
                    System.out.println(count - length);
                    inputStream.read(bytes);
                    files.get(i).write(bytes);
                }
            }
            ArrayList<FileInputStream> f = new ArrayList<>();
            for (int i = 0; i < names.size(); i++) {
                f.add(new FileInputStream(names.get(i)));
            }
            FileOutputStream writer = new FileOutputStream("answer.txt");
            for (int i = 0; i < f.size(); i++) {
                writer.write(f.get(i).readAllBytes());
            }
        }
        else {
            FileInputStream inputStream = new FileInputStream("input2.docx");
            FileOutputStream writer1 = new FileOutputStream("1#input2.txt");
            writer1.write(inputStream.readAllBytes());
            FileInputStream inputStream1 = new FileInputStream("1#input2.txt");
            FileOutputStream writer2 = new FileOutputStream("answer.docx");
            writer2.write(inputStream1.readAllBytes());
        }
    }




}

