package com.company;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.security.KeyException;
import java.util.*;
import java.lang.Math;
import javax.swing.JPanel;
import java.util.Collections;


class Edge {

    private final int v1;
    private final int v2;

    public Edge(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }


    public int Get_first() {
        return this.v1;
    }


    public int Get_second() {
        return this.v2;
    }

}

class TestPanel extends JPanel {
    public TestPanel(MainFrame frame, int n, ArrayList<Edge> edges) {
        super();
        this.n = n;
        this.edges = edges;
        addMouseListener(new MyMouseClick(frame));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth() / 2;
        int h = getHeight() / 2;
        int min = Math.min(w, h);
        int rad = 4 * min / 5;
        int[] x = new int[n + 1];
        int[] y = new int[n + 1];
        int r_little = Math.abs(min - rad) / 10;
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 1; i < n + 1; i++) {
            double f = 2 * Math.PI * i / n;
            x[i] = (int) Math.round(h + rad * Math.cos(f));
            y[i] = (int) Math.round(w + rad * Math.sin(f));
            if (x[i] > w) {
                g.drawString(String.valueOf(i), x[i] + 10, y[i] + (r_little + 10));
            } else {
                g.drawString(String.valueOf(i), x[i] - 10, y[i] + (r_little + 10));
            }
            g2d.drawOval(x[i] - r_little, y[i] - r_little, 2 * r_little, 2 * r_little);
        }
        for (Edge item : edges) {
            g2d.drawLine(x[item.Get_first()], y[item.Get_first()], x[item.Get_second()], y[item.Get_second()]);

        }
    }

    private final int n;
    private final ArrayList<Edge> edges;
    private MainFrame frame;
}
