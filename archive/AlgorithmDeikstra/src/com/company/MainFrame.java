package com.company;
import java.awt.*;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainFrame extends JFrame  {
    private int n;
    private ArrayList<Point2D> tops;
    private ArrayList<Edge> edges;
    private ArrayList<Point2D> list = new ArrayList();
    private final int WIDTH = 700;
    private final int HEIGHT = 700;


    public MainFrame(int n, ArrayList<Edge> edges) throws HeadlessException, IOException {
        super();
        this.n = n;
        this.edges = edges;
        tops = new ArrayList<>();
        setSize(WIDTH, HEIGHT);
        setTitle("Drawing a Graph");
        setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().width/2 - WIDTH/2),
                (int)(Toolkit.getDefaultToolkit().getScreenSize().height/2 - HEIGHT/2));
        Container content = getContentPane();
        int w = getWidth() / 2;
        int h = getHeight() / 2;
        int min = Math.min(w, h);
        int rad = 4 * min / 5;
        int r_little = Math.abs(min - rad) / 10;
        for (int i = 0; i < n; i++) {
            double f = 2 * Math.PI * i / n;
            tops.add(new Point((int)Math.round(h + rad * Math.cos(f)), (int) Math.round(w + rad * Math.sin(f))));
        }
        TestPanel tp = new TestPanel(this, n, edges, list, tops);
        content.add(tp);
    }


    public void addPoint(Point2D p) {
        list.add(p);
    }


    public int getTopIndex(int x, int y) {
        for(int i = 0; i < tops.size(); i++) {
            if(getDistance(tops.get(i).getX(), tops.get(i).getY(), x, y) < 20) {
                return i;
            }
        }
        return -1;
    }

    public int getMouseIndex(int x, int y) {
        for(int i = 0; i < list.size(); i++) {
            if(getDistance(list.get(i).getX(), list.get(i).getY(), x, y) < 20) {
                return i;
            }
        }
        return -1;
    }


    private double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public void mouseChangePoint(double x, double y, int index) {
        list.get(index).setLocation((int) x, (int) y);
    }

    public void changePoint(double x, double y, int index) {
        tops.get(index).setLocation((int) x, (int) y);
    }
}