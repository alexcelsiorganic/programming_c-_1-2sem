package com.company;
import java.awt.*;
import java.security.KeyException;
import java.util.*;
import java.lang.Math;
import java.awt.geom.Point2D;
import javax.swing.JPanel;
import java.util.Collections;


class Edge {


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


    private final int v1;
    private final int v2;
}


class Top implements Comparator<Top> {

    public Top() {
     this.num = 0;
     this.distance = 0;
    }
    public Top(int x_1, int y_1, int x_2, int y_2, int num_2) {
        this.num = num_2;
        this.distance = (int)Math.sqrt(Math.pow(x_1 - x_2, 2)
                + Math.pow(y_1 - y_2, 2));
    }
    public Top(int num_2, int distance) {
        this.num = num_2;
        this.distance = distance;
    }

    public int compare(Top top_1, Top top_2) {
       return Integer.compare(top_1.distance, top_2.distance);
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNum() {
        return this.num;
    }


    private final int num;
    private final int distance;
}


class TestPanel extends JPanel {

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int pivot = array[middle];
        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }


    public TestPanel(MainFrame frame, int n, ArrayList<Edge> edges, ArrayList aList, ArrayList<Point2D> tops) {
        super();
        mouse = aList;
        this.n = n;
        this.edges = edges;
        this.tops = tops;
        addMouseListener(new MyMouseClick(frame));
        addMouseMotionListener(new MyMouseClick(frame));
    }


    public int searchMin(Map<Integer, ArrayList<Top>> map, int key) {
        int minIndex = 0;
        if (map.containsKey(key)) {
            int min = map.get(key).get(0).getDistance();
            for (Top item : map.get(key)) {
                if (item.getDistance() < min) {
                    min = item.getDistance();
                    minIndex = item.getNum();
                }
            }
        }
        return minIndex;
    }


    public ArrayList<Integer> Deikstr(ArrayList<ArrayList<Top>> alist, int source, int end, int[] tops, int[] prevs) {
        this.list = alist;
        Set<Integer> set = new HashSet<Integer>();
        PriorityQueue<Top> queue = new PriorityQueue<Top>(n, new Top());
        ArrayList<Integer> way = new ArrayList<>();
        for (int i = 0; i < this.n; i++) {
            tops[i] = 222222;
        }
        for (int i = 0; i < this.n; i++) {
            prevs[i] = -1;
        }
        tops[source] = 0;
        queue.add(new Top(0,0,0,0, source));
        int top = -1;
        while (!queue.isEmpty()) {
            int min = queue.remove().getNum();
            top = min;
            int newDistance = -1;
            for (int i = 0; i < list.get(min).size(); i++) {
                Top a = list.get(min).get(i);
                int num = a.getNum();
                int distance = a.getDistance();
                if (!set.contains(a.getNum())) {
                    newDistance = tops[min] + distance;
                    if (tops[a.getNum()] > newDistance) {
                        tops[a.getNum()] = newDistance;
                        prevs[a.getNum()] = min;
                    }
                    queue.add(new Top(a.getNum(), tops[a.getNum()]));
                }
            }
            set.add(min);
        }

        System.out.println("PREVS");
        int cur = end;
        way.add(cur);
        while (prevs[cur] != -1) {
            cur = prevs[cur];
            System.out.println(cur);
            way.add(cur);
        }
        return way;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth() / 2;
        int h = getHeight() / 2;
        int min = Math.min(w, h);
        int rad = 4 * min / 5;
        int r_little = Math.abs(min - rad) / 10;
        Graphics2D g2d = (Graphics2D)g;
        for (int i = 0; i < n; i++) {
            if ((int)tops.get(i).getX() > w) {
                g.drawString(String.valueOf(i), (int)tops.get(i).getX() + 10, (int)tops.get(i).getY() + (r_little + 10));
            }
            else {
                g.drawString(String.valueOf(i), (int)tops.get(i).getX() - 10, (int)tops.get(i).getY() + (r_little + 10));
            }

        }
        for (int i = 0; i < this.n; i++) {
            g2d.drawOval((int)tops.get(i).getX() - r_little, (int)tops.get(i).getY() - r_little, 2 * r_little, 2 * r_little);
        }
        ArrayList<ArrayList<Top>> list = new ArrayList<>();
        int source = 2;
        int end = 2;
        if (mouse.size() >= 2) {
            int source_x = (int) ((Point2D) (mouse.get(mouse.size() - 2))).getX();
            int source_y = (int) ((Point2D) (mouse.get(mouse.size() - 2))).getY();
            for (int i = 0; i < n; i++) {
                if (Math.abs((int)tops.get(i).getX() - source_x) < 20) {
                    if (Math.abs((int)tops.get(i).getY() - source_y) < 20) {
                        source = i;
                    }
                }
            }
            int end_x = (int) ((Point2D) (mouse.get(mouse.size() - 1))).getX();
            int end_y = (int) ((Point2D) (mouse.get(mouse.size() - 1))).getY();
            for (int i = 0; i < n; i++) {
                if (Math.abs((int)tops.get(i).getX() - end_x) < 20) {
                    if (Math.abs((int)tops.get(i).getY() - end_y) < 20) {
                        end = i;
                    }
                }
            }
        }
        System.out.println("!!!!!!!!!" + " " + end + " " + source);
        for (int i = 0; i < this.n; i++) {
            list.add(new ArrayList<Top>());
        }
        for (Edge item : edges) {
            g2d.drawLine((int)tops.get(item.Get_first()).getX(), (int)tops.get(item.Get_first()).getY(),
                    (int)tops.get(item.Get_second()).getX(), (int)tops.get(item.Get_second()).getY());
            g.drawString(String.valueOf((int)Math.sqrt(Math.pow(((int)tops.get(item.Get_first()).getX() - (int)tops.get(item.Get_second()).getX()), 2)
                            + Math.pow(((int)tops.get(item.Get_first()).getY() - (int)tops.get(item.Get_second()).getY()), 2))),
                    ((int)tops.get(item.Get_first()).getX() + (int)tops.get(item.Get_second()).getX()) / 2,
                    ((int)tops.get(item.Get_first()).getY() + (int)tops.get(item.Get_second()).getY()) / 2);
            list.get(item.Get_first()).add(new Top((int)tops.get(item.Get_first()).getX(), (int)tops.get(item.Get_first()).getY(),
                    (int)tops.get(item.Get_second()).getX(), (int)tops.get(item.Get_second()).getY(), item.Get_second()));
            list.get(item.Get_second()).add(new Top((int)tops.get(item.Get_first()).getX(), (int)tops.get(item.Get_first()).getY(),
                    (int)tops.get(item.Get_second()).getX(), (int)tops.get(item.Get_second()).getY(), item.Get_first()));
        }
        System.out.println(source + " " + end);
        int[] tops = new int[n];
        int[] prevs = new int[n];
        ArrayList<Integer> way = new ArrayList<>(Deikstr(list, source, end, tops, prevs));
        g2d.setColor(Color.RED);
        for (int i = 0; i < way.size() - 1; i++) {
            g2d.drawLine((int)this.tops.get(way.get(i)).getX(), (int)this.tops.get(way.get(i)).getY(),
                    (int)this.tops.get(way.get(i + 1)).getX(), (int)this.tops.get(way.get(i + 1)).getY());
        }
        for (int i = 0; i < tops.length; i++) {
            System.out.println(source + " to " + i + " is "
                    + tops[i]);
        }
    }

    private final int n;
    private ArrayList mouse;
    ArrayList<Point2D> tops;
    private final ArrayList<Edge> edges;
    ArrayList<ArrayList<Top>> list;
    private MainFrame frame;
}