package com.company;
import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.lang.StringBuffer;
import java.util.StringTokenizer;
import java.util.regex.*;

public class Main {


    public static String firstTask (String inputWord) {
        //AAAAAAAAAAAAAAAA((414124124__fg32safasfa)))BBBBBBBBBBBBBBB
        return inputWord.replaceAll("\\(.+\\)", "");
    }


    public static String secondTask (String inputWord) {
//A*b/c1234567890zyx 1865u1l2
        Pattern pattern = Pattern.compile("(\\d{2})(\\d+)");
        StringBuilder new_string = new StringBuilder(inputWord);
        Matcher m = pattern.matcher(new_string);
        while (m.find()) {
           new_string.replace(m.start(), m.end(), m.group(1));
            m = pattern.matcher(new_string);
        }
        System.out.println(new_string);
        return new_string.toString();
    }


    public static String thirdTask (String inputWord) {
        // 2.000000 312321412.9990000 0.000 0100 10
        Pattern pattern_1 = Pattern.compile("(?<=[0-9]{1,})[.]0+$|(?<=[0-9]{1,})[.]0+\\s|(?<=\\.[0-9]{1,}[1-9])0+|(?<=\\s)0(?![.])0*(?=\\d)");
        StringBuilder new_string = new StringBuilder(inputWord);
        Matcher m_1 = pattern_1.matcher(new_string);
        while (m_1.find()) {
            new_string.replace(m_1.start(), m_1.end(), " ");
            m_1 = pattern_1.matcher(new_string);
        }
        return new_string.toString();
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("myfile.txt"));
        StringBuffer text = new StringBuffer("");
        while (in.hasNextLine()) {
             text.append(in.nextLine());
        }
        String process_text = text.toString();
        try (FileWriter writer = new FileWriter("output.txt", false)) {
            //writer.write(firstTask(process_text));
            //writer.write(secondTask(process_text));
             writer.write(thirdTask(process_text));
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}



