package com.company;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class Main {
    public static void main(String[] args) throws IOException {
        try (Scanner sc1 = new Scanner(new File("input1.txt"));
             FileWriter writer1 = new FileWriter(new File("output1.txt"));
             FileWriter writer2 = new FileWriter(new File("output2.txt"))) {
            ArrayList<String> tags = new ArrayList<>();
             while (sc1.hasNextLine()) {
                 String[] s = sc1.nextLine().split(" ");
                 Pattern p = Pattern.compile("(?<=<)[^/]+?(?=>)");
                 for (String word : s) {
                     Matcher m = p.matcher(word);
                     if (m.find()) {
                         tags.add(word.substring(m.start(), m.end()));
                     }
                 }
             }
            for (String item : tags) {
                writer1.write(item + "\n");
            }
            Collections.sort(tags, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.length() -  o1.length();
                }
            });
            for (String item : tags) {
                writer2.write(item + "\n");
            }
        }
    }
}
