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

    public static ArrayList<Hotel> getHotels(ArrayList<Hotel> test, String inputCity) {
        System.out.println("Hotels: ");
        ArrayList<Hotel> hotels = new ArrayList<>();
        for (int i = 0; i < test.size(); i++) {
            if (test.get(i).getCity().equals(inputCity)) {
                hotels.add(test.get(i));
            }
        }
        return hotels;
    }

    public static ArrayList<Hotel> getCities(ArrayList<Hotel> test, String inputHotel) {
        System.out.println("Cities: ");
        ArrayList<Hotel> cities = new ArrayList<>();
        for (int i = 0; i < test.size(); i++) {
            if (test.get(i).getName().equals(inputHotel)) {
                cities.add(test.get(i));
            }
        }
        return cities;
    }

    public static Comparator<Hotel> getCompHotel() {
        Comparator comp = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel s1, Hotel s2) {
                if (!s1.getCity().equals(s2.getCity())) {
                    return s1.getCity().compareTo(s2.getCity());
                } else {
                    return s2.getStars() - s1.getStars();
                }
            }
        };
        return comp;
    }

    public static Comparator<Hotel> BinaryCompCity() {
        Comparator comp = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel s1, Hotel s2) {
                return s1.getCity().compareTo(s2.getCity());
            }
        };
        return comp;
    }

    public static Comparator<Hotel> BinaryCompHotel() {
        Comparator comp = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel s1, Hotel s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };
        return comp;
    }
}

