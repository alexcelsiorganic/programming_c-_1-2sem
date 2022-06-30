package com.company;

import java.util.ArrayList;
import java.util.Comparator;
public class Books {
    private String author;
    private String name;
    private int price;
    private int year;


    public Books(String name, String author, int price, int year) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPrice() {
        return this.price;
    }

    public int getYear() {
        return year;
    }


    public static ArrayList<com.company.Books> getBooks(ArrayList<com.company.Books> test, String inputName) {
        System.out.println("Hotels: ");
        ArrayList<com.company.Books> books = new ArrayList<>();
        for (int i = 0; i < test.size(); i++) {
            if (test.get(i).getName().equals(inputName)) {
                books.add(test.get(i));
            }
        }
        return books;
    }

}