package com.company;
import java.util.*;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.lang.StringBuffer;
import java.util.StringTokenizer;

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
public class Main {
    public static Comparator<Hotel> getCompHotel() {
        Comparator comp = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel s1, Hotel s2) {
                if (!s1.getCity().equals(s2.getCity())) {
                    return s1.getCity().compareTo(s2.getCity());
                }
                else {
                    return s2.getStars() - s1.getStars();
                }
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
    public static void getHotels(String city, Map<String, ArrayList<Hotel>> hotels) {
        ArrayList<Hotel> h = hotels.get(city);
        for (int i = 0; i < h.size(); i++) {
            System.out.println(h.get(i).getCity() + " " + h.get(i).getName() + "  " + h.get(i).getStars());
        }
    }
    public static void getCities(String hotel, Map<String, ArrayList<Hotel>> hotels) {
        for (String key : hotels.keySet()) {
            ArrayList<Hotel> h = hotels.get(key);
            int index = Collections.binarySearch(h, new Hotel("", hotel, 0), BinaryCompHotel());
            if (index >= 0) {
                int counter_1 = 0;
                while (h.get(index + counter_1).getName().equals(hotel)) {
                    System.out.println(h.get(index + counter_1).getCity());
                    counter_1 += 1;
                }
                int counter_2 = 1;
                if (index - counter_2 > 0) {
                    while (h.get(index - counter_2).getName().equals(hotel)) {
                        System.out.println(h.get(index - counter_2).getCity());
                        counter_2 += 1;
                    }
                }
            }
        }
    }


    public static Comparator<Hotel> MapCompHotel() {
        Comparator comp = new Comparator<Hotel>() {
            @Override
            public int compare(Hotel s1, Hotel s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };
        return comp;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("hotel.txt"));
        Map<String, ArrayList<Hotel>> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Map<Integer, String> map_2 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }
        while (in.hasNextLine()) {
            ArrayList<Hotel> hotel = new ArrayList<>();
            String[] words = in.nextLine().split(" ");
            hotel.add(new Hotel(words[0], words[1], Integer.parseInt(words[2])));
            if (!(map.containsKey(words[0]))) {
                map.put(words[0], hotel);
            }
            else {
                map.get(words[0]).add(new Hotel(words[0], words[1], Integer.parseInt(words[2])));
            }
        }
        for (String key : map.keySet()) {
            ArrayList<Hotel> h = map.get(key) ;
            Collections.sort(map.get(key),getCompHotel());
            for (int i = 0; i < h.size(); i++) {
                System.out.println(h.get(i).getCity() + " " + h.get(i).getName() + "  " + h.get(i).getStars());
            }

        }
        getHotels("Moscow", map);
        getCities("Europe", map);
    }
}



