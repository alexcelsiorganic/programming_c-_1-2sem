package com.company;
import java.util.ArrayList;
import java.util.Comparator;

class Hotel {
    private String city;
    private String name;
    private int stars;


    public Hotel(String city, String a, int b) {
        this.city = city;
        this.name = a;
        this.stars = b;

    }
    public String getCity() {
        return this.city;
    }
    public String getName() {
        return this.name;
    }
    public int getStars() {
        return this.stars;
    }

}
