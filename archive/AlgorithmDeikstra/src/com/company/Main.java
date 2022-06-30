package com.company;
import javax.imageio.IIOException;
import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader sc = new BufferedReader(new FileReader("graphtest.txt"));
        int n = Integer.parseInt(sc.readLine());
        ArrayList<Edge> edges = new ArrayList<>();
        String s;
        while ((s = sc.readLine()) != null) {
            String[] edge = s.split(" ");
            edges.add(new Edge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1])));
        }
        MainFrame mf = new MainFrame(n, edges);
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.show();
    }
}
