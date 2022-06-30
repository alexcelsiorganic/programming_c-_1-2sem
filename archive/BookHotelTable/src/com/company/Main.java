package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;



public class Main extends JFrame {
    private ArrayList<Hotel> hotels;
    private ArrayList<Books> books;
    Main(String name, ArrayList<com.company.Hotel> hotels, ArrayList<com.company.Books> books) {
        super(name);
        this.hotels = hotels;
        this.books = books;
        JFrame jf = new JFrame();
        JPanel p = new JPanel();
        jf.getContentPane().add(p, BorderLayout.SOUTH);
        JButton b_1 = new JButton("Таблица отелей");
        ActionListener actionListener_1 = new B1ActionListener(this.hotels, jf);
        b_1.addActionListener(actionListener_1);
        JButton b_2 = new JButton("Таблица книг");
        ActionListener actionListener_2 = new B2ActionListener(this.books, jf);
        b_2.addActionListener(actionListener_2);
        p.add(b_1);
        p.add(b_2);
        setSize(1000,1000);
        jf.setVisible(true);
    }

    public class B1ActionListener implements ActionListener {
        private JFrame frame;
        private ArrayList<Hotel> h;
        B1ActionListener(ArrayList<Hotel> hots, JFrame frame) {
            this.h = hotels;
            this.frame = frame;
        }
        public void actionPerformed(ActionEvent e) {
            Vector vec_data = new Vector();
            for (Hotel hot :  h) {
                Vector book = new Vector();
                book.add(hot.getName());
                book.add(hot.getStars());
                book.add(hot.getCity());
                vec_data.add(book);
            }
            Vector column_names = new Vector();
            column_names.add("Название отеля");
            column_names.add("Количество звезд");
            column_names.add("Город");
            JTable jt = new JTable(vec_data, column_names);
            jt.setRowHeight(50);
            frame.revalidate();

            frame.add(new JScrollPane(jt), BorderLayout.CENTER);
        }
    }

    public class B2ActionListener implements ActionListener {
        private JFrame frame;
        private ArrayList<Books> b;
        B2ActionListener(ArrayList<Books> books, JFrame frame) {
            this.b = books;
            this.frame = frame;

        }
        public void actionPerformed(ActionEvent e) {
            Vector vec_data = new Vector();
            for (Books bk :  books) {
                Vector book = new Vector();
                book.add(bk.getName());
                book.add(bk.getAuthor());
                book.add(bk.getPrice());
                book.add(bk.getYear());
                vec_data.add(book);
            }
            Vector column_names = new Vector();
            column_names.add("Название книги");
            column_names.add("Автор");
            column_names.add("Цена");
            column_names.add( "Год издания");
            JTable jt = new JTable(vec_data, column_names);
            jt.setRowHeight(50);
            frame.revalidate();

            this.frame.add(new JScrollPane(jt), BorderLayout.CENTER);
        }
    }



    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("Hotels.txt"));
        Scanner in1 = new Scanner(new File("Books.txt"));
        ArrayList<Hotel> hotels = new ArrayList<>();
        ArrayList<Books> books = new ArrayList<>();
        while (in.hasNextLine()) {
            String[] words = in.nextLine().split(" ");
            hotels.add(new Hotel(words[0], words[1], Integer.parseInt(words[2])));
        }
        while (in1.hasNextLine()) {
            String[] words = in1.nextLine().split(" ");
            books.add(new Books(words[0], words[1], Integer.parseInt(words[2]), Integer.parseInt(words[3])));
        }
        JFrame f = new Main("MyNote", hotels, books);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        in.close();
    }
}
