package com.company;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.lang.StringBuffer;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("myfile.txt"));
        StringBuffer text = new StringBuffer("");
        while (in.hasNextLine()) {
            text.append(in.nextLine() + "  ");
        }
        String process_text = text.toString();
        System.out.println(process_text);
        StringTokenizer tokens = new StringTokenizer(process_text, " ,.");
        String answer = "";
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            char[] temp_char = token.toCharArray();
            char temp = temp_char[0];
            temp_char[0] = temp_char[token.length() - 1];
            temp_char[token.length() - 1] = temp;
            String changedString = new String(temp_char);
            answer = answer.concat(changedString + " ");
        }
        System.out.println(answer);
    }
}
