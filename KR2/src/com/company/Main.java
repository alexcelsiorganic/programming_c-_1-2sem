package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;
import java.lang.StringBuilder;

public class Main {
    public static int getCtrlRight(ArrayList<StringBuilder> lines, int numString, int numChar) {
        int counter = 0;
        StringBuilder a = lines.get(numString);
        String[] words  = a.toString().split(" ");
        int i = 0;
        while (counter < numChar) {
            counter += words[i].length();
            i += 1;
        }
        if (i != 0) {
            return counter;
        }
        else {
            return words[0].length() - 1;
        }
    }
    public static int getCtrlLeft(ArrayList<StringBuilder> lines, int numString, int numChar) {
        int counter = 0;
        StringBuilder a = lines.get(numString);
        String[] words  = a.toString().split(" ");
        int i = 0;
        while (counter <= numChar) {
            counter += words[i].length();
            i += 1;
        }
        if (i != 0) {
            return counter - words[i - 1].length() + 1;
        }
        if (numChar == 0) {
            return 0;
        }
        else {
            return 0;
        }
    }

    public static int[] getCtrlUp(ArrayList<StringBuilder> lines, int numString, int numChar) {
        int counter = 0;
        if (numString != 0 &&
                lines.get(numString).toString().length() <= lines.get(numString - 1).toString().length()) {
            int [] a = {numString - 1, numChar};
            return a;
        }
        else if (numString != 0 &&
                lines.get(numString).toString().length() > lines.get(numString - 1).toString().length()) {
            int [] a = {numString - 1, lines.get(numString - 1).toString().length() - 1};
            return a;
        }
        else {
            int[] a = {numString, numChar};
            return a;
        }
    }
    public static int[] getCtrlDown(ArrayList<StringBuilder> lines, int numString, int numChar) {
        int counter = 0;
        if (numString != lines.size() - 1 &&
                lines.get(numString).toString().length() <= lines.get(numString + 1).toString().length()) {
            int [] a = {numString + 1, numChar};
            return a;
        }
        else if (numString != lines.size() - 1 &&
                lines.get(numString).toString().length() > lines.get(numString + 1).toString().length()) {
            int [] a = {numString + 1, lines.get(numString + 1).toString().length()};
            return a;
        }
        else {
            int[] a = {numString, numChar};
            return a;
        }
    }
    public static boolean notCommand(String a) {
        if (!a.equals("goto") &&
                !a.equals("right")
                &&!a.equals("left") && !a.equals("ctrl") &&!a.equals("ins")
                &&!a.equals("enter") && !a.equals("del") && !a.equals("backspace") &&!a.equals("up") &&!a.equals("down")) {
            return true;
        }
            return false;
    }
    public static void main(String[] args) throws IOException {
        FileReader file1 = new FileReader("input1.txt");
        Scanner in1 = new Scanner(file1);
        ArrayList<StringBuilder> lines = new ArrayList<>();
        in1.useDelimiter("\n");
        while (in1.hasNextLine()) {
            lines.add(new StringBuilder(in1.nextLine()));
        }
        FileReader file2 = new FileReader("input2.txt");
        Scanner in2 = new Scanner(file2);
        ArrayList<String> commands = new ArrayList<>();
        in2.useDelimiter("\n");
        while (in2.hasNextLine()) {
            commands.add(in2.nextLine());
        }
        int[] pos = new int[2];
        boolean insCheck = false;
        int insCount = 0;
        for (String i : commands) {
            String[] words = i.split(" ");
            if (words[0].equals("goto")) {
                if (pos[0] < lines.size()) {
                    pos[0] = Integer.parseInt(words[1]);
                }
                if (pos[1] < lines.get(pos[0]).length()) {
                    pos[1] = Integer.parseInt(words[2]);
                }
            }
            if (words[0].equals("right")) {
                if (pos[1] + 1 < lines.get(pos[0]).length()) {
                    pos[1] += 1;
                }
            }
            if (words[0].equals("left")) {
                if (pos[1] - 1 >= 0) {
                    pos[1] -= 1;
                }
            }
            if (words[0].equals("up")) {
                int a = pos[0];
                int b = pos[1];
                pos[0] = getCtrlUp(lines, a, b)[0];
                pos[1] = getCtrlUp(lines, a, b)[1];
            }
            if (words[0].equals("down")) {
                int a = pos[0];
                int b = pos[1];
                pos[0] = getCtrlDown(lines, a, b)[0];
                pos[1] = getCtrlDown(lines, a, b)[1];
            }
            if (words[0].equals("ctrl")) {
                if (words[1].equals("left")) {
                    int a = pos[0];
                    int b = pos[1];
                    pos[1] = getCtrlLeft(lines, a, b);
                }
                if (words[1].equals("right")) {
                    int a = pos[0];
                    int b = pos[1];
                    pos[1] = getCtrlRight(lines, a, b);
                }
                if (words[1].equals("down")) {
                    if (pos[0] != lines.size() - 1) {
                        pos[0] += 1;
                    }
                    pos[1] = 0;
                }
                if (words[1].equals("up")) {
                    if (pos[0] != 0) {
                        pos[0] -= 1;
                    }
                    pos[1] = 0;
                }
                if (words[1].equals("backspace")) {
                    int a = getCtrlLeft(lines, pos[0], pos[1]);
                    if (pos[1] != 0) {
                        lines.get(pos[0]).delete(getCtrlLeft(lines, pos[0], pos[1]), pos[1]);
                        pos[1] = a;
                    }
                }
                if (words[1].equals("del")) {
                    int a  = getCtrlRight(lines, pos[0], pos[1]) - 1;
                    if (pos[1]  != lines.get(pos[0]).length() - 1) {
                        lines.get(pos[0]).delete(pos[1], getCtrlRight(lines, pos[0], pos[1]) + 1);
                        pos[1] = a;
                    }
                }
            }
            if (words[0].equals("backspace")) {
                if (pos[1] != 0) {
                    lines.get(pos[0]).delete(pos[1] - 1, pos[1]);
                    pos[1] -= 1;
                }
                else if (pos[0] != 0){
                    String s = lines.get(pos[0]).toString();
                    lines.get(pos[0] - 1).append(s);
                    lines.remove(pos[0]);
                    pos[0] -= 1;
                    pos[1] = lines.get(pos[0]).length() - 1;
                }
            }
            if (words[0].equals("del")) {
                lines.get(pos[0]).delete(pos[1], pos[1] + 1);
                if (pos[1] != 0) {
                    pos[1] -= 1;
                }
            }
            if (words[0].equals("ins")) {
                if (insCount % 2 == 0) {
                    insCheck = true;
                    insCount += 1;
                } else {
                    insCheck = false;
                    insCount += 1;
                }
            }
            if (words[0].equals("enter")) {
                StringBuilder s2 = new StringBuilder("");
                if (pos[1] != lines.get(pos[0]).length()) {
                    s2 = new StringBuilder(lines.get(pos[0]).substring(pos[1], lines.get(pos[0]).length()));
                } else {
                    s2 = new StringBuilder(lines.get(pos[0]));
                }
                lines.get(pos[0]).delete(pos[1], lines.get(pos[0]).length());
                lines.add(pos[0] + 1, s2);
            }
            if (notCommand(words[0])) {
                if (!insCheck) {
                    for (int k = 0; k < words.length; k++) {
                        System.out.println(lines.get(pos[0]).length());
                        lines.get(pos[0]).insert(pos[1], words[k]);
                        pos[1] += words[k].length();
                    }
                }
                else {
                    for (int k = 0; k < words.length; k++) {
                            int l = words[k].length();
                        System.out.println(lines.get(pos[0]));
                            lines.get(pos[0]).delete(pos[1],pos[1] + l);
                        System.out.println(lines.get(pos[0]));
                            lines.get(pos[0]).insert(pos[1], words[k]);
                            pos[1] += l;
                        }
                    }
                }
            }
        FileWriter writer = new FileWriter("output.txt");
        for (StringBuilder i : lines) {
            writer.write(i.toString() + "\n");
        }
        writer.close();
    }
}
