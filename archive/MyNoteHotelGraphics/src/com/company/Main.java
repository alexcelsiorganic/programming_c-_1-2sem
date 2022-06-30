package com.company;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;

public class Main extends JFrame {
    private ArrayList<Hotel> hotels;
    Main(String title, ArrayList<Hotel> hotels) {
        super(title);
        this.hotels = hotels;
        Container c = getContentPane();
        JTextField tf = new JTextField("",50);
        c.add(tf, BorderLayout.NORTH);
        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        c.add(ta);
        JPanel p = new JPanel();
        c.add(p, BorderLayout.SOUTH);
        JButton b_4 = new JButton("Отобразить");
        ActionListener actionListener_4 = new B4ActionListener(this.hotels, tf, ta);
        b_4.addActionListener(actionListener_4);
        JButton b_1 = new JButton("Отсортировать");
        ActionListener actionListener_1 = new B1ActionListener(this.hotels, tf, ta);
        b_1.addActionListener(actionListener_1);
        JButton b_2 = new JButton("Найти города");
        ActionListener actionListener_2 = new B2ActionListener(this.hotels, tf, ta);
        b_2.addActionListener(actionListener_2);
        JButton b_3 = new JButton("Найти гостиницы");
        ActionListener actionListener_3 = new B3ActionListener(this.hotels, tf, ta);
        b_3.addActionListener(actionListener_3);
        p.add(b_1);
        p.add(b_2);
        p.add(b_3);
        p.add(b_4);
        setSize(300,200);
        setVisible(true);
    }
    public class B1ActionListener implements ActionListener {
        private JTextField tf;
        private JTextArea ta;
        private ArrayList<Hotel> hots;
        B1ActionListener(ArrayList<Hotel> hotels, JTextField tf, JTextArea ta) {
            this.hots = new ArrayList<>();
            for (Hotel item : hotels) {
                this.hots.add(item);
            }
            this.tf = tf;
            this.ta = ta;
        }
        public void actionPerformed(ActionEvent e) {
            this.ta.setText("");
            Collections.sort(this.hots, Hotel.getCompHotel());
            for (Hotel item :this.hots) {
                this.ta.append(item.getCity() +  " "  + item.getName() + " " + item.getStars() + '\n');
            }
        }
    }
    public class B4ActionListener implements ActionListener {
        private JTextField tf;
        private JTextArea ta;
        private ArrayList<Hotel> hots;
        B4ActionListener(ArrayList<Hotel> hotels, JTextField tf, JTextArea ta) {
            this.hots = new ArrayList<Hotel>();
            for (Hotel item : hotels) {
                this.hots.add(item);
            }
            this.tf = tf;
            this.ta = ta;
        }
        public void actionPerformed(ActionEvent e) {
            this.ta.setText("");
            for (Hotel item : this.hots) {
                this.ta.append(item.getCity() + " " + item.getName() + " " + item.getStars() + '\n');
            }
        }
    }
    public class B2ActionListener implements ActionListener {
        private JTextField tf;
        private JTextArea ta;
        private ArrayList<Hotel> hots;
        B2ActionListener(ArrayList<Hotel> hots, JTextField tf, JTextArea ta) {
            this.hots = hotels;
            this.tf = tf;
            this.ta = ta;
        }
        public void actionPerformed(ActionEvent e) {
            ArrayList<Hotel> cities = Hotel.getCities(this.hots, this.tf.getText());
            System.out.println(this.tf.getText());
            ta.setText("");
            for (Hotel item : cities) {
                ta.append(item.getCity() +  " "  + item.getName() + " " + item.getStars() + '\n');
            }
        }
    }
    public class B3ActionListener implements ActionListener {
        private JTextField tf;
        private JTextArea ta;
        private ArrayList<Hotel> hotels;
        B3ActionListener(ArrayList<Hotel> hotels, JTextField tf, JTextArea ta) {
            this.hotels = hotels;
            this.tf = tf;
            this.ta = ta;
        }
        public void actionPerformed(ActionEvent e) {
            ArrayList<Hotel> hot = Hotel.getHotels(this.hotels, tf.getText());
            ta.setText("");
            for (Hotel item : hot) {
                ta.append(item.getCity() + " " + item.getName() + " " + item.getStars() + '\n');
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("hotel.txt"));
        ArrayList<Hotel> hotels = new ArrayList<>();
        while (in.hasNextLine()) {
            String[] words = in.nextLine().split(" ");
            hotels.add(new Hotel(words[0], words[1], Integer.parseInt(words[2])));
        }
        for (int j = 0; j < hotels.size(); j++) {
            System.out.println(hotels.get(j).getCity() + " " + hotels.get(j).getName() + " " + hotels.get(j).getStars());
        }
        JFrame f = new Main("MyNote", hotels);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        in.close();
        }
}

