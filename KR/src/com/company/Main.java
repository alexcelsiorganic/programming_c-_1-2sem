package com.company;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;
import java.util.Collections;
import java.lang.StringBuilder;

public class Main {

    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            ArrayList<Integer> tabs = new ArrayList<>();
            ArrayList<String> applications = new ArrayList<String>();
            while (in.hasNextLine()) {
                int t = 0;
                String s = in.nextLine();
                if (s.startsWith("Run")) {
                    applications.add(s.substring(s.indexOf(" ") + 1, s.length()));
                }
                if (s.startsWith("Alt")) {
                    tabs.add(s.split("\\+").length - 1);
                    t = tabs.size();
                }
            }
            for (String app : applications) {
                System.out.println(app);
            }
            for (Integer count : tabs) {
                System.out.println(count);
            }
            FileWriter writer2 = new FileWriter("output2.txt");
            FileWriter writer3 = new FileWriter("output3.txt");
            int index = 0;
            if (summary > applications.size()) {
                index = summary % applications.size() - 1;
            } else if (summary == applications.size()) {
                index = applications.size() - 1;
            } else {
                index = applications.size() - summary - 1;
            }

            int active_index = 0;
            for (Integer count : tabs) {
                StringBuilder out = new StringBuilder("");
                out.append("Alt");
                for (int i = 0; i < count; i++) {
                    out.append("+Tab");
                }
                out.append("\n");
                writer2.write(out.toString());
            }
            writer3.write(applications.get(index));
            writer3.write("\n");

            Collections.sort(applications, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            FileWriter writer1 = new FileWriter("output1.txt");
            for (String app : applications) {
                writer1.write(app);
                writer1.write("\n");
            }
            writer1.close();
            writer2.close();
            writer3.close();
        }

    }
}
