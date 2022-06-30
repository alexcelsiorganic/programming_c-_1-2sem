package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;


public class Main {


    public static ArrayList<Employee> readEmployees(File file) throws FileNotFoundException {
        ArrayList<Employee> employees = new ArrayList<>();
        try (Scanner sc1 = new Scanner(new FileReader(file))) {
            while (sc1.hasNextLine()) {
                String line = sc1.nextLine();
                String[] words = line.split(";");
                String[] date_1 = words[3].split("\\.");
                String[] date_2 = words[4].split("\\.");
                employees.add(new Employee(Integer.parseInt(words[0]),
                        words[1], words[2], new MyDate(date_1), new MyDate(date_2),
                        Integer.parseInt(words[5]), Integer.parseInt(words[6])));
            }
            employees.forEach(System.out::println);
        }
        return employees;
    }


    public static ArrayList<Request> readRequests(File file) throws FileNotFoundException {
        ArrayList<Request> requests = new ArrayList<>();
        try (Scanner sc2 = new Scanner(new FileReader(file))) {
            while (sc2.hasNextLine()) {
                String line = sc2.nextLine();
                String[] words = line.split(";");
                requests.add(new Request(Integer.parseInt(words[0]), Integer.parseInt(words[1]),
                        Integer.parseInt(words[2]), Integer.parseInt(words[3])));
            }
            requests.forEach(System.out::println);
        }
        return requests;
    }


    public static void firstTask(ArrayList<Employee> e, ArrayList<Request> r) throws IOException {
        FileWriter writer = new FileWriter("output1.txt");
        ArrayList<Request> r1 = new ArrayList<>();
        for (Request i : r) {
            if (i.getDaysoff_id() == 1) {
                r1.add(i);
            }
        }
        int counter = 0;
        for (Request i : r1) {
            for (Employee j : e) {
                 if (i.getEmpl_id() == j.getEmpl_id()) {
                     if (i.getDays() > j.getVacation_days()) {
                         if (counter == 0) {
                             writer.write(i.toString());
                             counter += 1;
                         }
                         else {
                             writer.write("\n" + i.toString());
                         }
                     }
                 }
            }
        }
        writer.close();
    }


    public static void secondTask(ArrayList<Employee> e, int input_vac_days) throws IOException {
        FileWriter writer = new FileWriter("output2.txt");
        ArrayList<Employee> lot_days = new ArrayList<>();
        for (Employee i : e) {
            if (i.getVacation_days() >= input_vac_days) {
                lot_days.add(i);
            }
        }
       Collections.sort(lot_days, new Comparator<Employee>() {
           @Override
           public int compare(Employee o1, Employee o2) {
               return o1.getEmpl_surname().compareTo(o2.getEmpl_surname());
           }
       });
        if (lot_days.size() > 0) {
            writer.write(lot_days.get(0).getEmpl_surname() + ";" + lot_days.get(0).getEmpl_name()
                    + ";" + lot_days.get(0).getVacation_days());
        }
       for (int i = 1; i < lot_days.size(); i++) {
           writer.write("\n" + lot_days.get(i).getEmpl_surname() + ";" + lot_days.get(i).getEmpl_name()
                   + ";" + lot_days.get(i).getVacation_days());
       }
        writer.close();
    }

    public static void thirdTask(ArrayList<Employee> e) throws IOException, ParseException {
        FileWriter writer = new FileWriter("output3.txt");
        Collections.sort(e, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                try {
                    if (o1.getStart_date().subDay(o1.getEnd_date()) != o2.getStart_date().subDay(o2.getEnd_date())) {
                        return Integer.compare(o2.getStart_date().subDay(o1.getEnd_date()), o1.getStart_date().subDay(o1.getEnd_date()));
                    }
                    else {
                        return o1.getEmpl_surname().compareTo(o2.getEmpl_surname());
                    }
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                return 0;
            }
        });
        if (e.size() > 0) {
            writer.write(e.get(0).getEmpl_surname() + ";" +
                    e.get(0).getEmpl_name() + ";" + e.get(0).getStart_date().subDay(e.get(0).getEnd_date()));
        }
        for (int i = 1; i < e.size(); i++) {
            writer.write("\n" + e.get(i).getEmpl_surname() + ";" +
                    e.get(i).getEmpl_name() + ";" + e.get(i).getStart_date().subDay(e.get(i).getEnd_date()));
        }
        writer.close();
    }


    public static void fourthTask(ArrayList<Employee> e, int id) throws IOException {
        FileWriter writer = new FileWriter("output4.txt");
        MyDate today = new MyDate(19, 1, 2022);
        for (Employee i : e) {
            if (i.getEmpl_id() == id) {
                int amountMonth = today.subMonth(i.getEnd_date());
                int vacDays = amountMonth * 2;
                int diff = i.getVacation_days() - vacDays;
                if (diff >= 0) {
                    writer.write(String.valueOf(diff));
                } else {
                    writer.write(String.valueOf(-1));
                }
            }
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException, ParseException {
        File file_1 = new File("input1.txt");
        ArrayList<Employee> employees = readEmployees(file_1);
        File file_2 =new File("input2.txt");
        ArrayList<Request> requests = readRequests(file_2);
        firstTask(employees, requests);
        FileReader file3 = new FileReader("input3.txt");
        Scanner sc3 = new Scanner(file3);
        int days = sc3.nextInt();
        secondTask(employees, days);
        thirdTask(employees);
        FileReader file4 = new FileReader("input4.txt");
        Scanner sc4 = new Scanner(file4);
        int id = sc4.nextInt();
        fourthTask(employees, id);
    }
}
