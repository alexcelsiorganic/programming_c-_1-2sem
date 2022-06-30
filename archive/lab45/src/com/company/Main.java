package com.company;
import java.util.Scanner;
import java.io.File;
import java.lang.StringBuffer;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;




public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("a.csv"));
        in.useDelimiter(";");
        StringBuffer writeText = new StringBuffer("");
        while(in.hasNextLine()) {
            writeText.append(in.nextLine() + '\n');
            System.out.println(writeText);
        }





    }
}
