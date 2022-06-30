package com.company;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.lang.Math;
import java.util.Scanner;
import java.util.*;

class GraphTest extends JFrame {
    public GraphTest(int n, int raduis, ArrayList<Edge> edges){
        setTitle("Drawing a Graph");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.n = n;
        this.raduis = raduis;
        this.edges = edges;
    }
    public void algorithm_Deikstra(int[][] adjacency_matrix) {
        int[] tops = new int[n];
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth() / 2;
        int h = getHeight() / 2;
        int min = Math.min(w, h);
        int rad = 4 * min / 5;
        int r_little = Math.abs(min - rad) / 10;
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            double f = 2 * Math.PI * i / n;
            x[i] = (int) Math.round(h + rad * Math.cos(f));
            y[i] = (int) Math.round(w + rad * Math.sin(f));
//            g2d.drawString(String.valueOf(i), x,y + (r_little + 10));
            g2d.drawOval(x[i] - r_little, y[i] - r_little, 2 * r_little, 2 * r_little);
        }
        for (int i = 0; i < n; i++) {
            g2d.drawLine(x[edges.get(i).Get_first()], y[edges.get(i).Get_first()], x[edges.get(i).Get_second()], y[edges.get(i).Get_second()]);
        }
    }
    public static int calculateDistance(int v1, int v2) {
        return (int)Math.sqrt(Math.abs(Math.pow(v1, 2) - Math.pow(v2, 2)));
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader sc = new BufferedReader(new FileReader("graphtest.txt"))) {
            int n = Integer.parseInt(sc.readLine());
            ArrayList<Edge> edges = new ArrayList<>();
            String s;
            int [][] adjacency_matrix = new int[n][n];
            while ((s = sc.readLine()) != null) {
                String[] edge = s.split(" ");
                edges.add(new Edge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1])));
                adjacency_matrix[Integer.parseInt(edge[0])][Integer.parseInt(edge[1])]
                        = calculateDistance(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
            }
            new GraphTest(n, 20, edges);
        }
    }
    private int n;
    private int raduis;
    private ArrayList<Edge> edges;

}


